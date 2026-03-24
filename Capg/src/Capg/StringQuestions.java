package Capg;

public class StringQuestions {
	public static int countchar(String st) {
		int count = 0;
		for(int i = 0; i < st.length(); i++) {
			if(Character.isLetter(st.charAt(i))){
				count++;
			}
		}
		return count;
	}
	public static String rev(String st) {
		StringBuilder sb = new StringBuilder(st);
		int i = 0;
		int j = sb.length() - 1;
		while(i < j) {
			char temp = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, temp);
			i++;
			j--;
		}
		return sb.toString();
		
	}
	public static void palin(String st) {
		int i = 0;
		int j = st.length() - 1;
		while(i < j) {
			if(st.charAt(i) != st.charAt(j)) {
				System.out.println("Not Palindrome");
			}
			i++;
			j--;
		}
		System.out.println("Palindrome");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Hello World 123!!!";
		System.out.println("Characters Count: " + countchar(s));
		System.out.println("Reverse String: " + rev(s));
		palin("racecar");
	}
}
