package Capg;
import java.util.HashMap;
import java.util.Map;

public class Hashmap_questions {
	public static void countfreq(String st) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(char ch : st.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
	}

	public static void main(String[] args) {
		String s = "Programming";
		countfreq(s);

	}

}
