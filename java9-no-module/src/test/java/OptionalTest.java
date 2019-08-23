import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void ifPresentOrElseTest() {
        Optional<String> empty = Optional.of("Hello World");

        empty.ifPresentOrElse(s -> System.out.println("Existe un valor igual a: " + s), () -> System.out.println("No existe valor"));
    }


    @Test
    public void orElseGetTest() {
        Optional<String> empty = Optional.ofNullable(null);

        String value = empty.orElseGet(() -> "Value by default");

        Assert.assertEquals(value, "Value by default");
    }

    @Test
    public void streamTest() {
        Optional<String> empty = Optional.ofNullable("Eduardo Alfonso");

        Optional<String> any = empty.stream()
                .filter(s -> s.contains("nso"))
                .filter(s -> s.contains("ardo"))
                .map(s -> s + " Sanchez")
                .findAny();

        Assert.assertFalse(any.isEmpty());
        Assert.assertEquals(any.get(),"Eduardo Alfonso Sanchez");
    }


}
