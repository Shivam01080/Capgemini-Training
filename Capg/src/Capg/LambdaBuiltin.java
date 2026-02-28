package Capg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;


public class LambdaBuiltin {

	public static void main(String[] args) {
		//List<Integer> list = List.of(1,2,3,4,5,9,6);
		//list.forEach((x) -> System.out.print(x + " "));
		
		//Function<String, String> fun1 = (str) -> str.substring(0,2).toUpperCase().concat(str.substring(2));
		
		//String ab = fun1.apply("Shivam");
		//4System.out.println(ab);
		
		//Supplier<Integer> s = () -> new Random().nextInt(20);
		//for(int i = 0; i < 5; i++) {
		//	System.out.println(s.get());
		//}
		List<Integer> list = new ArrayList<>(
                List.of(2, 58, 695, 39, 18, 100, 8494, 677)
        );
		list.removeIf((x) -> x >100);
		System.out.println(list);
	}
}
