package Capg;
import java.util.*;

class Student{
    int id;
    String name;
    String password;
    boolean materialAccessed;

    Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.materialAccessed = false;
    }

    void showStatus() {
        System.out.println("Material Accessed: " +
                (materialAccessed ? "YES" : "NO"));
    }
}

public class StudentPortalSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    static Student loggedInStudent = null;

    static void registerStudent() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("ID already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Create Password: ");
        String pass = sc.nextLine();

        students.add(new Student(id, name, pass));
        System.out.println("Registration Successful!");
    }

    static void login() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        for (Student s : students) {
            if (s.id == id && s.password.equals(pass)) {
                loggedInStudent = s;
                System.out.println(" Welcome, " + s.name + "!");
                studentMenu();
                return;
            }
        }

        System.out.println("Invalid ID or Password!");
    }

    static void studentMenu() {

        while (true) {
            System.out.println("1. Access Study Material");
            System.out.println("2. Check Material Status");
            System.out.println("3. Logout");

            System.out.print("Choose: ");
            int ch = sc.nextInt();

            switch (ch) {

                case 1 -> {
                    System.out.println("\n Opening Study Material...");
                    System.out.println("Java Basics PDF");
                    System.out.println("OOP Concepts Notes");
                    System.out.println("DSA Introduction");

                    loggedInStudent.materialAccessed = true;
                }

                case 2 -> loggedInStudent.showStatus();

                case 3 -> {
                    loggedInStudent = null;
                    System.out.println("Logged out!");
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("1. Register Student");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Choose: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> registerStudent();
                case 2 -> login();
                case 3 -> {
                    System.out.println("Exiting System...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
