package Capg;
import java.util.*;

public class DiceGame {
	static Scanner sc = new Scanner(System.in);
	static HashMap<Integer, Integer> map = new HashMap<>();
	
	static Random rand = new Random();
	static void game(int a) {
		int p1 = rand.nextInt(6) + 1;
		int p2 = rand.nextInt(6) + 1;
		if(p1 > p2){
			System.out.println("Player 1 Won!!!");
		}
		else if(p2 > p1) {
			System.out.println("Player 2 Won!!!");
		}
		else {
			System.out.println("Tie!!!");
		}

	}
	
	public static void main(String[] args) {
		System.out.println("Enter number of players");
		int players = sc.nextInt();
		while(true) {
			System.out.println("1. Play\n2. Exit");
			int ch = sc.nextInt();
			switch(ch) {
			case 1 -> game(players);
			case 2 -> {
				sc.close();
				return;
			}
			}
		}
	}

}
