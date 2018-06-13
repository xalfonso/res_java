package eas.com.example2;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionalInterfacesOfLanguagesTest {

    /**
     * Create a lambda of Function.
     */
    @Test
    public void testFunction() {
        Function<String, Integer> stringIntegerFunction = s -> s.length();
        assertEquals(6, stringIntegerFunction.apply("Horeca").intValue());
    }

    /**
     * Create a lambda of Function.
     */
    @Test
    public void testFunctionWithMethodReference() {
        Function<String, Integer> stringIntegerFunction = String::length;
        assertEquals(8, stringIntegerFunction.apply("Internet").intValue());
    }

    @Test
    public void testPredicate() {
        Predicate<Integer> integerPredicate = integer -> integer > 0;
        assertFalse(integerPredicate.test(0));
    }

    @Test
    public void testPredicateWithMethodReference() {
        Predicate<String> stringPredicate = String::isEmpty;
        assertTrue(stringPredicate.test(""));
    }

}
