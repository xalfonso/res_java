import entity.Student;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

/**
 * @author Msc. Ing. Eduardo Alfonso Sanchez eddie.alfonso@gmail.com
 *         Date & Time: 6/7/2017 15:56
 *         <p>
 *         Example of Stream.reduce()
 *         Example of OptionalInt
 */
public class MainApp {
    public static void main(String[] args) {

        List<Student> studentList = Arrays.asList(
                new Student("Jose Luis", 1, 20, 89.3f),
                new Student("Alfredo Rodriguez", 2, 25, 90.0f),
                new Student("Eduardo Alfonso", 3, 32, 99.99f),
                new Student("Leydis Esther", 4, 33, 100f),
                new Student("Zeus", 5, 40, 96.6f),
                new Student("Luis Daniel", 6, 19, 80.9f)
        );

        OptionalInt optionalInt = studentList.stream().mapToInt(Student::getPosition).reduce((a, b) -> (a * b));

        optionalInt.ifPresent(System.out::print);
        optionalInt.orElse(-1);

    }
}
