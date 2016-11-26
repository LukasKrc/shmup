package test.lt.Shmup.Main;

import static org.mockito.Mockito.*;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import lt.Shmup.Main.Event;
import lt.Shmup.Main.Observer;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

@RunWith(DataProviderRunner.class)
public class EventTest {

    @DataProvider
    public static Object[][] provideEventNames() {
        return new Object[][] {
                { "" },
                { "Foo" }
        };
    }

    @Test
    @UseDataProvider("provideEventNames")
    public void eventObserverGetsDispatched(String eventName) throws Exception {
        Observer observerMock = mock(Observer.class);
        Event.attachObserver(observerMock);
        Event.notify(eventName, new HashMap<>());
        verify(observerMock).notify(eventName, new HashMap<>());
    }
}