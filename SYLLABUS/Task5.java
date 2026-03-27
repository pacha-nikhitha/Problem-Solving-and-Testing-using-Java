import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            students.add(new Student(sc.next(), sc.nextInt()));
        }

        int k = sc.nextInt();

        students.stream()
                .sorted((s1, s2) -> {
                    if (s2.marks != s1.marks)
                        return s2.marks - s1.marks;
                    return s1.name.compareTo(s2.name);
                })
                .limit(k)
                .map(s -> s.name)
                .forEach(name -> System.out.print(name + " "));
    }
}
