package lt.Shmup.Main;

import lt.Shmup.Config;
import lt.Shmup.Container;
import lt.Shmup.Logger;

import java.util.HashMap;

public class ClassRegistrator {
    public void createMainDependencies() {
        HashMap<String, String> classMap = Config.map("dependencies/main");
        for (String interfaceName : classMap.keySet()) {
            String implementationName = classMap.get(interfaceName);
            registerClass("lt.Shmup.Main." + interfaceName, implementationName);
        }
    }

    private void registerClass(String interfaceName, String implementationName) {
        try {
            attemptClassRegistration(interfaceName, implementationName);
        } catch (ClassNotFoundException e) {
            Logger.getInstance().logException(e);
            System.exit(1);
        }
    }

    private void attemptClassRegistration(
            String interfaceName,
            String implementationName
    ) throws ClassNotFoundException {
        Class interfaceClass = Class.forName(interfaceName);
        implementationName = getImplementationClassName(
                interfaceName,
                implementationName,
                interfaceClass
        );
        Container.register(
                Class.forName(interfaceName),
                Class.forName(implementationName)
        );
    }

    private String getImplementationClassName(String interfaceName, String implementationName, Class interfaceClass) {
        implementationName =
                interfaceName + "s." + implementationName + interfaceClass.getSimpleName();
        return implementationName;
    }
}