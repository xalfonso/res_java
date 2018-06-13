package eas.com.Example4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IterationExternalVsInternalTest {


    public List<String> testOldWay(float minNote) {
        List<Student> studentList = Arrays.asList(
                new Student("Isabel", 9.5f),
                new Student("Roberto", 10f),
                new Student("Javier", 6.3f),
                new Student("Maria", 5f),
                new Student("Ismael", 8.3f)
        );
        List<String> studentNames = new ArrayList<>();
        for (Student aStudentList : studentList) {
            if (aStudentList.getNote() >= minNote) {
                studentNames.add(aStudentList.getName());
            }
        }
        return studentNames;
    }

    public List<String> testNewWay(float minNote) {
        List<Student> studentList = Arrays.asList(
                new Student("Isabel", 9.5f),
                new Student("Roberto", 10f),
                new Student("Javier", 6.3f),
                new Student("Maria", 5f),
                new Student("Ismael", 8.3f)
        );
        return studentList.stream()
                .filter(student -> student.getNote() >= minNote)
                .map(student -> student.getName())
                .collect(Collectors.toList());
    }

    public List<String> testNewWayMethodReference(float minNote) {
        List<Student> studentList = Arrays.asList(
                new Student("Isabel", 9.5f),
                new Student("Roberto", 10f),
                new Student("Javier", 6.3f),
                new Student("Maria", 5f),
                new Student("Ismael", 8.3f)
        );
        return studentList.stream()
                .filter(student -> student.getNote() >= minNote)
                .map(Student::getName)
                .collect(Collectors.toList());
    }


}
