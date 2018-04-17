package LeetCode;

import java.util.Scanner;

public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Random r = new Random();
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		s.close();
		p(change(str));
	}

	private static int change(String str) {
		// TODO Auto-generated method stub
		if(str == null || str.trim().length() == 0)
			return 0;
		String s = str.trim();
		if(s.charAt(0) == '+' || s.charAt(0) == '-') {
			if(s.charAt(1) == '+' || s.charAt(1) == '-')
				return 0;
			
		}
		return 0;
	}

	static void p(Object o) {
		System.out.println(o);
	}
}
