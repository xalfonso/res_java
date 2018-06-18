package eas.com.Example5;

import eas.com.Example4.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreatingStreamTest {

    public void byCollectionTest() {
        List<Student> studentList = Arrays.asList(
                new Student("Isabel", 9.5f),
                new Student("Roberto", 10f),
                new Student("Javier", 6.3f),
                new Student("Maria", 5f),
                new Student("Ismael", 8.3f)
        );

        Stream<Student> stream = studentList.stream();
    }

    public void byArrayTest() {
        int[] numberArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        IntStream streamPrimitiveNumbers = IntStream.of(numberArray);
    }

    public void byOfTest() {
        Stream<String> stream = Stream.of("Lunes", "Martes", "Miercoles");
    }

    public void byGenerateTest() {
        Random random = new Random();
        LongStream longStream = LongStream.generate(() -> random.nextLong()).limit(50);
    }

    public void byIterateTest() {
        Random random = new Random();
        LongStream longStream = LongStream.iterate(0, n -> n + 2).limit(50);
    }

}
