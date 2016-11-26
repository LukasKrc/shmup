package test.lt.Shmup.Main.Command.CommandDispatchers;

import com.tngtech.java.junit.dataprovider.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class CommandDispatcherTest {
    @DataProvider
    public static Object[][] provideCommandKeys() {
        int maxKey = 256;
        List<Object> integers = new ArrayList<>();
        for (int i = 0; i < maxKey; i++) {
            integers.add(i);
        }
        Object[][] result = new Object[integers.size()][];
        for (int i = 0; i < maxKey; i++) {
            result[i] = new Object[] { integers.get(i) };
        }

        return result;
    }
}
