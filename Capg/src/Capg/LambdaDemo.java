package Capg;
import java.util.*;

public class LambdaDemo {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "Shivam"));
		list.add(new Employee(2, "Sourav"));
		list.add(new Employee(3, "Axar"));
		list.add(new Employee(4, "Aditya"));
		list.add(new Employee(5, "Navneet"));
		
		list.sort((a, b) -> a.name.compareTo(b.name));
		list.forEach(System.out::println);

	}



}
