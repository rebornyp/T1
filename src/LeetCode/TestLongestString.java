package LeetCode;

public class TestLongestString {
	
	public static void main(String[] args) {

		String s = "abcde";
		p(get(s));
		
	}

	private static String get(String s) {
		if(s == null || s.length() == 0)
			return null;
		if(s.length() == 1)
			return s;
		int max = 1, flag = 0;
		for(int i=0; i<s.length() - 1; i++) {
			int temp = 0;
			if(s.charAt(i) == s.charAt(i + 1)) {
				int m = i, n = i + 1;
				while(m >= 0 && n <s.length() && s.charAt(m) == s.charAt(n)) {
					temp += 2;
					m --;
					n ++;
				}
			}
			if(temp > max) {
				flag = i;
				max = temp;
			}
			if (i != 0 && s.charAt(i - 1) == s.charAt(i + 1)){
				temp = 1;
				int m = i - 1, n = i + 1;
				while(m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)) {
					temp += 2;
					m --; 
					n ++;
				}
			}
			p(temp);
			if(temp > max) {
				flag = i;
				max = temp;
			}
		}
		p(max);
		if(max % 2 == 0)
			return s.substring(flag + 1 - (max / 2), flag + (max / 2) + 1);
		else {
/*			if(flag == 0)
				return String.valueOf(s.charAt(0));
			else*/
				return s.substring(flag - (max - 1) / 2, flag + ((max - 1) / 2) + 1);
		}
	}

	static void p(Object o) {
		System.out.println(o);
	}
	
}