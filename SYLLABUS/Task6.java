import java.util.*;

class Task6 {
    static class Record {
        String item;
        int amount;
        Record(String i, int a) { item = i; amount = a; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, Integer> total = new LinkedHashMap<>();
        Map<String, Record> maxItem = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String cat = sc.next();
            String item = sc.next();
            int amt = sc.nextInt();

            total.put(cat, total.getOrDefault(cat, 0) + amt);

            if (!maxItem.containsKey(cat) || maxItem.get(cat).amount < amt) {
                maxItem.put(cat, new Record(item, amt));
            }
        }

        for (String cat : total.keySet()) {
            System.out.println(cat + " " + total.get(cat) + " " + maxItem.get(cat).item);
        }
    }
}
