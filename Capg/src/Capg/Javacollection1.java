package Capg;
import java.util.*;

class Student {
    int number;
    String name;
    String mail;

    Student(int number, String name, String mail) {
        this.number = number;
        this.name = name;
        this.mail = mail;
    }
}

public class Javacollection1 {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> stu = new ArrayList<>();

    static void addstu() {
        System.out.print("Enter Student number: ");
        int number = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Mail: ");
        String mail = sc.nextLine();

        stu.add(new Student(number, name, mail));
        System.out.println("Student added successfully!");
    }

    static void display() {
        if (stu.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (int i = 0; i < stu.size(); i++) {
            Student s = stu.get(i);
            System.out.println(i + " -> " + s.number + " " + s.name + " " + s.mail);
        }
    }

    static void removestu() {
        display();

        System.out.print("Enter index to remove: ");
        int idx = sc.nextInt();

        if (idx >= 0 && idx < stu.size()) {
            stu.remove(idx);
            System.out.println("Student removed!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    // UPDATE STUDENT
    static void updates() {
        display();

        System.out.print("Enter index to update: ");
        int idx = sc.nextInt();
        sc.nextLine();

        if (idx >= 0 && idx < stu.size()) {
            Student s = stu.get(idx);

            System.out.print("New Name: ");
            s.name = sc.nextLine();

            System.out.print("New Mail: ");
            s.mail = sc.nextLine();

            System.out.println("Student updated!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Add\n2. Remove\n3. Display\n4. Make Changes\n5. Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> addstu();
                case 2 -> removestu();
                case 3 -> display();
                case 4 -> updates();
                case 5 -> {
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
