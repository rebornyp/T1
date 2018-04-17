package LeetCode;

import java.util.Random;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int t = r.nextInt();
		//p(Integer.MAX_VALUE);
		//p(Integer.MIN_VALUE);
		p(t);
		p(reverse(t));
	}

	private static int reverse(int t) {
		// TODO Auto-generated method stub
		String s = String.valueOf(t);
		char[] arr = s.toCharArray();
		if(arr[0] == '-') {
			s = "-";
			for(int i=arr.length-1; i>0; i--) {
				s += arr[i];
			}
		} else {
			s = "";
			for(int i=arr.length-1; i>=0; i--) {
				s += arr[i];
			}
		}
		int temp;
		try {
			temp = Integer.parseInt(s);
		} catch(NumberFormatException e) {
			temp = 0;
		}
		return temp;
	}

	static void p(Object o) {
		System.out.println(o);
	}
	
}
