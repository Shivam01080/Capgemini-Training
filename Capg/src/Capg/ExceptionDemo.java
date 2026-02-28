package Capg;
import java.util.*;

public class ExceptionDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int count = 0;
		try {
			while(count < 5) {
				try {
					System.out.println("Enter Number: ");
					int n = sc.nextInt();
					sum += n;
					count++;
				}
				catch(InputMismatchException e) {
					System.out.println("Wrong Input!!!");
					sc.next();
				}
				System.out.println(sum);
			}
		}
		catch(NoSuchElementException n) {
				System.out.println("Not Sufficient Elements!!!");
		}
		catch(IllegalStateException i) {
				System.out.println("Scanner has been closed!!!");
		}
		
	}

}
