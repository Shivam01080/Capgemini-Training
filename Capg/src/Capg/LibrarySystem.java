package Capg;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;


class Book {
    int id;
    String title;
    boolean issued;
    Integer issuedTo;
    LocalDate issueDate;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.issued = false;
        this.issuedTo = null;
        this.issueDate = null;
    }
}

class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}


public class LibrarySystem {

    static Scanner sc = new Scanner(System.in);

    static HashMap<Integer, Book> books = new HashMap<>();
    static HashMap<Integer, User> users = new HashMap<>();

    static final int MAX_DAYS = 14;
    static final int FINE_PER_DAY = 5;


    static void addUser() {
        System.out.print("Enter User ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        users.put(id, new User(id, name));
        System.out.println("User added!");
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        books.put(id, new Book(id, title));
        System.out.println("Book added!");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books.");
            return;
        }

        System.out.println("\nID | Title | Status");
        for (Book b : books.values()) {
            System.out.println(
                    b.id + " | " + b.title + " | " +
                            (b.issued ? "Issued" : "Available"));
        }
    }

    static void issueBook() {
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();

        Book b = books.get(bookId);
        if (b == null || b.issued) {
            System.out.println("Cannot issue book.");
            return;
        }

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        if (!users.containsKey(userId)) {
            System.out.println("User not found.");
            return;
        }

        b.issued = true;
        b.issuedTo = userId;
        b.issueDate = LocalDate.now();

        System.out.println("Book issued!");
    }


    static void returnBook() {
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();

        Book b = books.get(bookId);
        if (b == null || !b.issued) {
            System.out.println("Invalid return.");
            return;
        }

        long days = ChronoUnit.DAYS.between(
                b.issueDate, LocalDate.now());

        if (days > MAX_DAYS) {
            long fine = (days - MAX_DAYS) * FINE_PER_DAY;
            System.out.println("Late! Fine: ₹" + fine);
        } else {
            System.out.println("Returned on time.");
        }

        b.issued = false;
        b.issuedTo = null;
        b.issueDate = null;
    }


    static void issuedBooks() {
        System.out.println("\nIssued Books:");
        boolean found = false;

        for (Book b : books.values()) {
            if (b.issued) {
                User u = users.get(b.issuedTo);
                System.out.println(
                        b.id + " | " + b.title +
                                " | User: " + u.name);
                found = true;
            }
        }

        if (!found) System.out.println("None.");
    }


    public static void main(String[] args) {

        while (true) {
            System.out.println("1. Add User\n2. Add Book\n3. View Books\n4. Issue Book\n5. Return Book\n6. Issued Books\n");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> addUser();
                case 2 -> addBook();
                case 3 -> viewBooks();
                case 4 -> issueBook();
                case 5 -> returnBook();
                case 6 -> issuedBooks();
                case 7 -> {
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
