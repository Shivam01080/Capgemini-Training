package Capg;
import java.io.*;
import java.util.*;
public class practice {
//how to work with abstract class
//-> by creating a child class
	public static void main(String[] args) {
		try {
			FileReader f = new FileReader("abc");
		}
		catch(Exception e){
			System.out.println("File Not Found!!!");
		}
		InputStream input = System.in;
		InputStreamReader ip = new InputStreamReader(input);
		
//		Reader r = new Reader(ip);  // no object for this class as this is an abstract class
		BufferedReader br = new BufferedReader(ip);
		br.lines();
	}

}
