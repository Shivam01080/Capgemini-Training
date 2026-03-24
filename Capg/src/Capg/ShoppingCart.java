package Capg;
import java.util.*;

class Details{
	String name;
	String brand;
	
	Details(String name, String brand){
		this.name = name;
		this.brand = brand;
	}
}

public class ShoppingCart {
	static List<Details> sp = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	static void disp() {
		if (sp.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }
		for(Details d : sp) {
			System.out.println(d.name + "|" + d.brand);
		}
	}
	static void removeItem() {
        disp();

        if (sp.isEmpty()) return;

        System.out.print("Enter index to remove: ");
        int idx = sc.nextInt();

        if (idx >= 0 && idx < sp.size()) {
            sp.remove(idx);
            System.out.println("Item removed!");
        } else {
            System.out.println("Invalid index!");
        }
    }
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("1. Add\n2. Remove\n3. Show\n4. Exit");
			int ch = sc.nextInt();
			sc.nextLine();
			switch(ch) {
			case 1 -> {
				System.out.print("Enter Name: ");
				String name = sc.nextLine();
				System.out.print("Enter Brand: ");
				String brand = sc.nextLine();
				sp.add(new Details(name, brand));
			}
			case 2 -> removeItem();
			case 3 -> disp();
			case 4 -> {
				sc.close();
				return;
			}
			default -> System.out.println("Invalid choice!");	
			}
		}
		
		
	}

}
