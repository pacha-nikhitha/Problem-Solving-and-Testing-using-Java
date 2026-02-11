package PSTJ;

import java.time.LocalDate;
import java.util.*;

class Event {
    String name;
    LocalDate date;

    Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }
}

public class Events {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<Event> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String dateStr = sc.nextLine();
            LocalDate date = LocalDate.parse(dateStr);
            events.add(new Event(name, date));
        }

        int month = sc.nextInt();

        if (events.isEmpty()) {
            System.out.println("No events available");
            sc.close();
            return;
        }

        events.sort(Comparator.comparing(e -> e.date));

        for (Event e : events) {
            System.out.print(e.name + " ");
        }
        System.out.println();

        System.out.println(events.get(0).name);
        System.out.println(events.get(events.size() - 1).name);

        boolean found = false;
        for (Event e : events) {
            if (e.date.getMonthValue() == month) {
                System.out.print(e.name + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.print("No events in this month");
        }

        sc.close();
    }
}
