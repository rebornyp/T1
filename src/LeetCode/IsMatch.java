package LeetCode;

public class IsMatch {

	public IsMatch() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "sjd";
		String p = ".*";
		p(isMatch(s, p));
	}

    static boolean isMatch(String s, String p) {
        
    	return s.matches(p);
    }
	
	static void p(Object o) {
		System.out.println(o);
	}
	
}
