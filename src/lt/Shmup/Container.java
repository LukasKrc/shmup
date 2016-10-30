package lt.Shmup;

import java.lang.reflect.Constructor;
import java.util.*;

public class Container {
    private static Container instance;
    private HashMap<Class<?>, Class<?>> classMap;
    private HashMap<Class<?>, Object> instanceMap;

    private Container() {
        classMap = new HashMap<>();
        instanceMap = new HashMap<>();
    }

    private static void assureInstanceExists() {
        if (instance == null) {
            instance = new Container();
        }
    }

    public static void register(
            Class<?> interfaceClass,
            Class<?> implementationClass
    ) {
        assureInstanceExists();
        instance.classMap.put(interfaceClass, implementationClass);
    }

    public static Object get(Class<?> interfaceClass) {
        assureInstanceExists();
        return instance.get(interfaceClass, false, false);
    }

    public static Object get(
            Class<?> interfaceClass,
            boolean shouldCreateNewInstance
    ) {
        assureInstanceExists();
        return instance.get(interfaceClass, shouldCreateNewInstance, false);
    }

    public static Object get(
            Class<?> interfaceClass,
            boolean shouldCreateNewInstance,
            boolean shouldRecursivelyCreateNewInstances
    ) {
        assureInstanceExists();
        if (!instance.doesImplementationExists(interfaceClass)) {
            throw new RuntimeException(
                    "Implementation for " + interfaceClass + " is not configured."
            );
        }
        if (shouldCreateNewInstance) {
            return instance.createNewInstance(
                    interfaceClass,
                    shouldRecursivelyCreateNewInstances
            );
        }

        Object classInstance = instance.createAndStoreInstance(
                interfaceClass,
                shouldRecursivelyCreateNewInstances
        );
        return classInstance;
    }

    private Object createAndStoreInstance(
            Class<?> interfaceClass,
            boolean shouldRecursivelyCreateNewInstances
    ) {
        Object classInstance = instanceMap.get(interfaceClass);
        if (classInstance == null) {
            classInstance = createNewInstance(
                    interfaceClass,
                    shouldRecursivelyCreateNewInstances
            );
            instanceMap.put(interfaceClass, classInstance);
        }
        return classInstance;
    }

    private boolean doesImplementationExists(Class<?> interfaceClass) {
        return classMap.get(interfaceClass) != null;
    }

    private Object createNewInstance(
            Class<?> interfaceClass,
            boolean shouldRecursivelyCreateNewInstances
    ) {
        Class<?> implementationClass = classMap.get(interfaceClass);
        Constructor<?> constructor = getConstructor(implementationClass);
        try {
            return constructor.newInstance(
                    getParams(constructor, shouldRecursivelyCreateNewInstances)
            );
        } catch (Exception e) {
            Logger.getInstance().logException(e);
            System.exit(1);
        }

        return null;
    }

    private Constructor<?> getConstructor(Class<?> implementationClass) {
        return implementationClass.getConstructors()[0];
    }

    private Object[] getParams(
            Constructor<?> constructor,
            boolean shouldRecursivelyCreateNewInstances
    ) {
        List<Class> paramTypes =
                Arrays.<Class>asList(constructor.getParameterTypes());
        if (paramTypes.size() < 1) {
            return new Object[]{};
        }

        ArrayList<Object> params = new ArrayList<>();
        for (Class<?> paramClass : paramTypes) {
            if (Collections.frequency(paramTypes, paramClass) > 1) {
                params.add(get(paramClass, true, true));
            } else {
                params.add(
                        get(
                                paramClass,
                                shouldRecursivelyCreateNewInstances,
                                shouldRecursivelyCreateNewInstances
                        )
                );
            }
        }

        return params.toArray();
    }
}
