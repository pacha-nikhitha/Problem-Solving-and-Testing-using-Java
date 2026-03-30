import java.util.*;

class EntityRecord {
    int id;
    String student, course, instructor, date;
    int duration;

    EntityRecord(int id, String s, String c, String i, String d, int dur) {
        this.id = id;
        this.student = s;
        this.course = c;
        this.instructor = i;
        this.date = d;
        this.duration = dur;
    }

    void display() {
        System.out.println("Enrollment_ID: " + id +
                ", Student: " + student +
                ", Course: " + course +
                ", Instructor: " + instructor +
                ", Start Date: " + date +
                ", Duration: " + duration + " weeks");
    }
}

class Task13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<EntityRecord> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new EntityRecord(
                    sc.nextInt(),
                    sc.next(),
                    sc.next(),
                    sc.next(),
                    sc.next(),
                    sc.nextInt()
            ));
        }

        for (EntityRecord e : list)
            e.display();
    }
}
