package LeetCode;

public class DecodeString {

	public static void main(String[] args) {
		String s = "54494";
		System.out.println(numDecodings(s));
	}
	public static int numDecodings(String s) {
		if(s == null || s.length() == 0) return 0;
		if(s.length() == 1) return s.charAt(0) == '0' ? 0 : 1;
		if(s.charAt(0) == '0')
			return 0;
		int temp = 0;
		if(s.length() >= 2) 
			if(s.charAt(1) == '0' && s.charAt(0)-'0' > 2)
				temp = 0;
			else if(s.charAt(1) == '0')
				temp = 1;
			else if((s.charAt(0)-'0') * 10 + (s.charAt(1)-'0') > 26)
				temp = 1;
			else temp = 2;
		if(s.length() == 2)
			return temp;
		int[] arr = new int[s.length()];
		arr[0] = 1;
		arr[1] = temp;
		for(int i=2; i<s.length(); i++) {
			if(s.charAt(i) == '0' && (s.charAt(i-1)-'0' > 2 || s.charAt(i-1)-'0'< 1))
				return 0;
			if(s.charAt(i) == '0')
				arr[i] = arr[i-2];
			else if(s.charAt(i-1) != '0' && (s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0') < 27)
				arr[i] = arr[i-2] + arr[i-1];
			else
				arr[i] = arr[i-1];
		}
		return arr[s.length()-1];
    }
}
