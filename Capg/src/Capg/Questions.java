package Capg;

public class Questions {
	public static void main(String[] args) {
		int[] arr = {4,2,8,1,7};
		add(arr);
		minimum(arr);
		System.out.println("Maximum Element:" + maximum(arr));
		secondmax(arr);
		avg(arr);
	}
	public static void add(int[] a) {
		int sum = 0;
		for(int i : a) {
			sum += i;	
		}
		System.out.println("Sum of Elements:" + sum);
		
	}
	public static void minimum(int[] a) {
		int mn = a[0];
		for(int i : a) {
			if(mn > i) {
				mn = i;
			}
		}
		System.out.println("Minimum Element:" + mn);
	}
	public static int maximum(int[] a) {
		int mx = a[0];
		for(int i : a) {
			if(mx < i) {
				mx = i;
			}
		}
		return mx;
	}
	public static void secondmax(int[] a) {
		int mx = maximum(a);
		int smx = a[0];
		for(int i : a) {
			if(smx < i && i != mx) {
				smx = i;
			}
		}
		System.out.println("Second Maximum Element:" + smx);
	}
	public static void avg(int[] a) {
		double avg;
		double sum = 0;
		for(int i : a) {
			sum += i;
		}
		avg = sum/a.length;
		System.out.println("Average:" + avg);
	}
}
