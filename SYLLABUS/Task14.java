import java.util.*;

class Vehicle {
    int id;
    String model;
    double baseRent;

    Vehicle(int id, String model, double baseRent) {
        this.id = id;
        this.model = model;
        this.baseRent = baseRent;
    }

    double calculateRent() {
        return baseRent;
    }
}

class Car extends Vehicle {
    int seats;

    Car(int id, String model, double baseRent, int seats) {
        super(id, model, baseRent);
        this.seats = seats;
    }

    double calculateRent() {
        return baseRent + (seats * 100);
    }
}

class Bike extends Vehicle {
    int cc;

    Bike(int id, String model, double baseRent, int cc) {
        super(id, model, baseRent);
        this.cc = cc;
    }

    double calculateRent() {
        return baseRent + (cc * 2);
    }
}

class Task14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Vehicle> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char type = sc.next().charAt(0);

            if (type == 'C') {
                list.add(new Car(
                        sc.nextInt(),
                        sc.next(),
                        sc.nextDouble(),
                        sc.nextInt()
                ));
            } else {
                list.add(new Bike(
                        sc.nextInt(),
                        sc.next(),
                        sc.nextDouble(),
                        sc.nextInt()
                ));
            }
        }

        for (Vehicle v : list) {
            System.out.println("Vehicle ID: " + v.id +
                    ", Model: " + v.model +
                    ", Total Rent: " + v.calculateRent());
        }
    }
}
