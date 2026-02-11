import java.util.*;
import java.util.stream.*;

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }
}

public class Solution1 {

    static int ageLimit;

    public static boolean isOlder(Person p) {
        return p.getAge() > ageLimit;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int age = sc.nextInt();
            persons.add(new Person(name, age));
        }

        ageLimit = sc.nextInt();

        String sortedNames = persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .map(Person::getName)
                .collect(Collectors.joining(" "));
        System.out.println(sortedNames);

        String filteredNames = persons.stream()
                .filter(Solution1::isOlder)
                .map(Person::getName)
                .collect(Collectors.joining(" "));
        System.out.println(filteredNames);

        String upperNames = persons.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.joining(" "));
        System.out.println(upperNames);

        sc.close();
    }
}
