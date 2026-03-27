import java.util.*;
import java.util.stream.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}

public class Task3 {

    public static boolean isOlder(Person p, int ageLimit) {
        return p.getAge() > ageLimit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            persons.add(new Person(sc.next(), sc.nextInt()));
        }

        int ageLimit = sc.nextInt();

        // Sorted names
        persons.stream()
                .map(Person::getName)
                .sorted()
                .forEach(name -> System.out.print(name + " "));
        System.out.println();

        // Filter older than ageLimit
        persons.stream()
                .filter(p -> isOlder(p, ageLimit))
                .map(Person::getName)
                .forEach(name -> System.out.print(name + " "));
        System.out.println();

        // Uppercase names
        persons.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .forEach(name -> System.out.print(name + " "));
    }
}
