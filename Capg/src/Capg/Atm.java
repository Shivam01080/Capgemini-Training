package Capg;
import java.util.*;
class Account {
    long pin;
    double balance;

    Account(long pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }
}

public class Atm {
	static HashMap<Integer, Account> map = new HashMap<>();
    static boolean loggedIn = false;
    static int currentUser = -1;

    static Scanner sc = new Scanner(System.in);

    public static void register() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        if (map.containsKey(id)) {
            System.out.println("ID exists!");
            return;
        }

        System.out.print("Enter PIN: ");
        long pass = sc.nextLong();

        map.put(id, new Account(pass, 0.0));
        System.out.println("Registered successfully!");
        login(id, pass);
    }

    public static void login(int id, long pass) {
        if (map.containsKey(id) && map.get(id).pin == pass) {
            loggedIn = true;
            currentUser = id;
            System.out.println("Logged in Successfully!!");
        } else {
            System.out.println("Invalid ID or PIN!");
        }
    }

   
    public static void deposit() {
        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();

        if (amt <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        map.get(currentUser).balance += amt;
        System.out.println("Deposited Successfully!");
    }


    public static void withdraw() {
        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();

        Account acc = map.get(currentUser);

        if (amt > acc.balance) {
            System.out.println("Insufficient Balance!");
        } else {
            acc.balance -= amt;
            System.out.println("Withdrawal Successful!");
        }
    }

   
    public static void checkBalance() {
        System.out.println("Current Balance: " +
                map.get(currentUser).balance);
    }


    public static void changePin() {
        System.out.print("Enter old PIN: ");
        long old = sc.nextLong();

        Account acc = map.get(currentUser);

        if (acc.pin == old) {
            System.out.print("Enter new PIN: ");
            acc.pin = sc.nextLong();
            System.out.println("PIN changed successfully!");
        } else {
            System.out.println("Wrong PIN!");
        }
    }

	public static void main(String[] args) {
		while (true) {
            System.out.println("1. Register\n2. Login3. Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> register();
                case 2 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter PIN: ");
                    long pass = sc.nextLong();
                    login(id, pass);
                    while (loggedIn) {
                        System.out.println("\n--- MENU ---");
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Check Balance");
                        System.out.println("4. Change PIN");
                        System.out.println("5. Logout");

                        int op = sc.nextInt();

                        switch (op) {
                            case 1 -> deposit();
                            case 2 -> withdraw();
                            case 3 -> checkBalance();
                            case 4 -> changePin();
                            case 5 -> {
                                loggedIn = false;
                                currentUser = -1;
                                System.out.println("Logged out!");
                            }
                        }
                    }
                }

                case 3 -> {
                    System.out.println("Thank you for using ATM!");
                    sc.close();
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }

}
