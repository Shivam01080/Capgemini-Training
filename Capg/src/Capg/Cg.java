package Capg;

public class Cg { 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {2,4,6,8};
		
		String [] str = new String [3];
		str[0] = "abc";
		str[1] = "cde";
		str[2] = "efg";
		System.out.println("through function");
		disp(str);
		System.out.println();
		evenidx(arr);
		System.out.println();
		for(int i = 0; i < str.length; i++ ) {
			System.out.println(str[i]);
		}
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		char [] charr = retArr();
		for (char i : charr) {
			System.out.print(i + " ");
		}
	}
	public static void disp(String [] a){
		for(String i : a) {
			System.out.print(i + " ");
		}
	}
	public static void evenidx(int[] a) {
		for(int i = 0; i < a.length; i++) {
			if(i % 2 == 0)
				System.out.print(a[i] + " ");
		}
	}
	public static char[] retArr() {
		char[] ch = {'a', 'b', 'c'};
		return ch;
	}
}
