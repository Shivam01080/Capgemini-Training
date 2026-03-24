package Capg;

public class StringOperations {
	public static void main(String[] args) {

        String str = " Java Programming 123! ";

        System.out.println("1. Lowercase: " + str.toLowerCase());

        System.out.println("2. Uppercase: " + str.toUpperCase());

        int vowels = 0, consonants = 0, digits = 0, special = 0;
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("AEIOUaeiou".indexOf(ch) != -1)
                    vowels++;
                else
                    consonants++;
            } else if (Character.isDigit(ch))
                digits++;
            else if (ch != ' ')
                special++;
        }
        System.out.println("3. Vowels: " + vowels + ", Consonants: " + consonants +
                ", Digits: " + digits + ", Special: " + special);

        int spaces = 0;
        for (char ch : str.toCharArray())
            if (ch == ' ')
                spaces++;
        System.out.println("4. Spaces: " + spaces);

        String evenOdd = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (i % 2 == 0)
                evenOdd += Character.toUpperCase(ch);
            else
                evenOdd += Character.toLowerCase(ch);
        }
        System.out.println("5. Even-Odd Case: " + evenOdd);

        System.out.println("6. Remove spaces: " + str.replace(" ", ""));

        if (str.length() > 2)
            System.out.println("7. Remove first & last: " + str.substring(1, str.length() - 1));

        System.out.println("8. Remove vowels: " + str.replaceAll("[AEIOUaeiou]", ""));

        System.out.println("9. Trim spaces: '" + str.trim() + "'");

        String[] words = str.trim().split("\\s+");
        String titleCase = "";
        for (String w : words)
            titleCase += Character.toUpperCase(w.charAt(0)) + w.substring(1).toLowerCase() + " ";
        System.out.println("10. Title Case: " + titleCase.trim());

        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--)
            reverse += str.charAt(i);
        System.out.println("11. Reverse: " + reverse);

        String clean = str.trim().replaceAll("\\s+", "");
        String rev = "";
        for (int i = clean.length() - 1; i >= 0; i--)
            rev += clean.charAt(i);
        System.out.println("12. Palindrome: " + clean.equalsIgnoreCase(rev));

        System.out.println("13. Word Count: " + words.length);

        char removeChar = 'a';
        System.out.println("14. Remove '" + removeChar + "': " +
                str.replace(String.valueOf(removeChar), ""));

        System.out.println("15. Remove first occurrence of 'a': " +
                str.replaceFirst("a", ""));
    }
}