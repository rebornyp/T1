package PAT;

import java.util.Scanner;

public class SpellItRight {

	public static void main(String[] args) {
		String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		Scanner s = new Scanner(System.in);
		String str = s.nextLine().trim();
		s.close();
		int num = 0;
		for(int i=0; i<str.length(); i++) {
			num += str.charAt(i) - '0';
		}
		str = String.valueOf(num);
		for(int i=0; i<str.length(); i++) {
			if(i == 0) System.out.print(word[str.charAt(i) - '0']);
			else System.out.print(" " + word[str.charAt(i) - '0']);
		}
		
	}

}
