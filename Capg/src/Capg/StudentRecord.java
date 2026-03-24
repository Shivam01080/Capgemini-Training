package Capg;
import java.io.*;
import java.util.*;

public class StudentRecord {

    static final String FILE_NAME = "students.dat";

    static HashMap<Integer, Double> readStudents() {
        HashMap<Integer, Double> map = new HashMap<>();

        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return map;

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            map = (HashMap<Integer, Double>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            
        }

        return map;
    }

    static void writeStudents(HashMap<Integer, Double> map) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(map);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error writing file");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. List All Students");
            System.out.println("3. Search by Roll");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            HashMap<Integer, Double> students = readStudents();

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll: ");
                    int roll = sc.nextInt();

                    if (students.containsKey(roll)) {
                        System.out.println("Roll number already exists!");
                        break;
                    }

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    students.put(roll, marks);
                    writeStudents(students);

                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No records found.");
                    } else {
                        for (Map.Entry<Integer, Double> entry : students.entrySet()) {
                            System.out.println("Roll: " + entry.getKey() +
                                               " Marks: " + entry.getValue());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll to search: ");
                    int searchRoll = sc.nextInt();

                    if (students.containsKey(searchRoll)) {
                        System.out.println("Marks: " + students.get(searchRoll));
                    } else {
                        System.out.println("Record not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}