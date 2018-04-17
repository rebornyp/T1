package LeetCode;

import java.util.Random;

public class PardominlarNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int num = r.nextInt();
		num = 1001;
		p(num);
		p(isPN(num));
		
	}

	private static void p(Object o) {
		// TODO Auto-generated method stub
		System.out.println(o);
	}

	private static boolean isPN(int num) {
		// TODO Auto-generated method stub
		String s = String .valueOf(num);
		if(s.charAt(0) == '-' || s.charAt(0) == '+')
			return false;
		if(s.length() == 1)
			return true;
		int i = 0;
		boolean f = true;
		while(i < s.length() - 1 - i) {
			if(s.charAt(i) != s.charAt(s.length() - 1 - i))
				f = false;
			i ++;
		}
		return f;
	}

}
