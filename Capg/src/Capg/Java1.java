package Capg;
import java.util.*;
import java.io.*;

public class Java1 {
	 static void disp(int a, String b) {
			System.out.println("Name: " + b + "\nRoll: " + a);
		}

	public static void main(String[] args) throws IOException{
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Roll number:");
		int roll = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Name:");
		String name = sc.next();
		disp(roll, name);
		*/
		FileInputStream fin = new FileInputStream("data.txt");
		FileOutputStream fout = new FileOutputStream("DATAcopy.txt");
		
		int ch = 0;
		int count = 1;
		while(ch != -1) {
			ch = fin.read();
			count++;
			if(ch == -1) break;
			if(count % 2 != 0) {
				fout.write(ch);
			}
			
		}
		fin.close();
		fout.close();
		System.out.println("file copied!!!");
		
		
		/*2.
		int ch = 0;
		int count = 1;
		while(ch != -1) {
			ch = fin.read();
			if(ch == -1) break;
			if(ch == '\n'){
				count++;
			}
			if(count % 2 != 0) {
				fout.write(ch);
			}
			
		}
		fin.close();
		fout.close();
		System.out.println("file copied!!!");
		*/
		
		/*3.
		int ch = 0;
		int count = 1;
		while(ch != -1) {
			ch = fin.read();
			if(ch == -1) break;
			if(ch == ' '){
				count++;
			}
			if(count % 2 != 0) {
				fout.write(ch);
			}
			
		}
		fin.close();
		fout.close();
		System.out.println("file copied!!!");
		*/
	}

}
