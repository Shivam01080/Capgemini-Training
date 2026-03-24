package Capg;
import java.util.*;

class Product {
    int id;
    String name;
    int quantity;

    Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    void display() {
        System.out.println(id + " | " + name + " | Qty: " + quantity);
    }
}

class Delivery {
    int deliveryId;
    int productId;
    int deliveredQty;
    String address;

    Delivery(int deliveryId, int productId, int deliveredQty, String address) {
        this.deliveryId = deliveryId;
        this.productId = productId;
        this.deliveredQty = deliveredQty;
        this.address = address;
    }

    void display() {
        System.out.println(
            "DeliveryID: " + deliveryId +
            " | ProductID: " + productId +
            " | Qty: " + deliveredQty +
            " | Address: " + address
        );
    }
}

public class LogisticsManagementSystem {

    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Delivery> deliveries = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Logistics Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Stock");
            System.out.println("4. Remove Product");
            System.out.println("5. Create Delivery");
            System.out.println("6. View Deliveries");
            System.out.println("7. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> updateStock();
                case 4 -> removeProduct();
                case 5 -> createDelivery();
                case 6 -> viewDeliveries();
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        products.add(new Product(id, name, qty));
        System.out.println("Product added");
    }

    static void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available");
            return;
        }
        for (Product p : products) {
            p.display();
        }
    }

    static void updateStock() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product p : products) {
            if (p.id == id) {
                System.out.print("Enter new quantity: ");
                p.quantity = sc.nextInt();
                System.out.println("Stock updated");
                return;
            }
        }
        System.out.println("Product not found");
    }

    static void removeProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product p : products) {
            if (p.id == id) {
                products.remove(p);
                System.out.println("Product removed");
                return;
            }
        }
        System.out.println("Product not found");
    }

    static void createDelivery() {
        System.out.print("Enter Delivery ID: ");
        int dId = sc.nextInt();

        System.out.print("Enter Product ID: ");
        int pId = sc.nextInt();

        System.out.print("Enter Quantity to Deliver: ");
        int qty = sc.nextInt();
        sc.nextLine();

        for (Product p : products) {
            if (p.id == pId) {

                if (p.quantity < qty) {
                    System.out.println("Not enough stock");
                    return;
                }

                System.out.print("Enter Delivery Address: ");
                String address = sc.nextLine();

                p.quantity -= qty;
                deliveries.add(new Delivery(dId, pId, qty, address));

                System.out.println("Delivery created");
                return;
            }
        }
        System.out.println("Product not found");
    }

    static void viewDeliveries() {
        if (deliveries.isEmpty()) {
            System.out.println("No deliveries done yet");
            return;
        }
        for (Delivery d : deliveries) {
            d.display();
        }
    }
}