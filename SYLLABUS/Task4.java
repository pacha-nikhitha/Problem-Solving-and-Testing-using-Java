import java.time.*;
import java.util.*;
import java.util.stream.*;

class Event {
    String name;
    LocalDate date;

    Event(String name, String date) {
        this.name = name;
        this.date = LocalDate.parse(date);
    }
}

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Event> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            events.add(new Event(sc.next(), sc.next()));
        }

        int month = sc.nextInt();

        // Sort events
        List<Event> sorted = events.stream()
                .sorted(Comparator.comparing(e -> e.date))
                .collect(Collectors.toList());

        sorted.forEach(e -> System.out.print(e.name + " "));
        System.out.println();

        // Earliest
        System.out.println(sorted.get(0).name);

        // Latest
        System.out.println(sorted.get(sorted.size() - 1).name);

        // Filter by month
        sorted.stream()
                .filter(e -> e.date.getMonthValue() == month)
                .forEach(e -> System.out.print(e.name + " "));
    }
}
