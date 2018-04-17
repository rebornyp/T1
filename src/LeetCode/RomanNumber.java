package LeetCode;

import java.util.Random;

public class RomanNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random r = new Random();
		int num = r.nextInt(4000);
		p(num);
		String s = intToRoman(num);
		p(s);
		p(romanToInt(s));
		
	}

	private static int romanToInt(String s) {
		if(s == null || s.equals(""))
			return 0;
		char[][] c = {{'M', 'Q'}, {'C', 'D'}, {'X', 'L'}, {'I', 'V'}};
		for(int i=0; i<4; i++) {
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(j) == c[i][0]) {
					
				}
			}
			
		}
		return 0;
    }
	
    private static String intToRoman(int num) {
    	char[][] c = {{'M', 'Q'}, {'C', 'D'}, {'X', 'L'}, {'I', 'V'}};
    	String s = String.format("%1$4s", num);
		int[] arr = new int[4];
		String f, result = "";
		for(int i=3; i>=0; i--) {
			f = "";
			if(String.valueOf(s.charAt(i)).equals(" "))
				arr[i] = 0;
			else
				arr[i] =s.charAt(i) - 48;
			if(arr[i] != 0) {
				if(arr[i] < 4)
					for(int k=0; k<arr[i]; k++)
						f +=  String.valueOf(c[i][0]);
				else if(arr[i] == 4)
					f =  String.valueOf(c[i][0]) + String.valueOf(c[i][1]);
				else if(arr[i] == 5)
					f = String.valueOf(c[i][1]);
				else if(arr[i] < 9) {
					f = String.valueOf(c[i][1]);
					for(int k=0; k<(arr[i]-5); k++)
						f += String.valueOf(c[i][0]);  
				} else
					f = String.valueOf(c[i][0]) + String.valueOf(c[i-1][0]);
			}
			result = f + result;
			p(arr[i] + "---" + f);
		}
		return result;
    	
    }
	
	static void p(Object o) {
		System.out.println(o);
	}
	
}
