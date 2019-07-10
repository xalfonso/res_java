import eas.com.DummyMessages;
import org.junit.Test;

public class DummyTest {

    @Test
    public void performanceDirectlyFromBundleTest() {
        for (int i = 0; i < 100; i++) {
            String value = DummyMessages.MESSAGE_RESOLVER.getString("some.dummy.value");
        }
    }

    @Test
    public void performanceUseConstantTest() {
        for (int i = 0; i < 100; i++) {
            String value = DummyMessages.value;
        }
    }

}
