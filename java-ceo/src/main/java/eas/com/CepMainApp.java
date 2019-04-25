package eas.com;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Example of Grouping in Stream Java 8 with multiple key and dynamically
 */
public class CepMainApp {

    public static void main(String[] args) {

        Person person1 = new Person("John", "USA", "NYC");
        Person person2 = new Person("Steve", "UK", "London");
        Person person3 = new Person("Anna", "USA", "NYC");
        Person person4 = new Person("Mike", "USA", "Chicago");
        List<Person> persons = Arrays.asList(person1, person2, person3, person4);

        Function<Person, List<Object>> compositeKey = personRecord -> Arrays.asList(personRecord.getCountry(), personRecord.getCity());

        Map<Object, List<Person>> collect = persons.stream().collect(Collectors.groupingBy(compositeKey));

    }

    static public class Person {
        private final String name;
        private final String country;
        private final String city;

        public Person(String name, String country, String city) {
            this.name = name;
            this.country = country;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public String getCountry() {
            return country;
        }

        public String getCity() {
            return city;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", country='" + country + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }
}
