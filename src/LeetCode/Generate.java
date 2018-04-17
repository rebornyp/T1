package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Generate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p(generateParenthesis(2));
		
	}
	static char[] ch= {'(', ')'};
	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		if(n < 1)
			return list;
		String str = "";
        find(list, str, n, n);
		return list;
    }
	private static void find(List<String> list, String str, int n1, int n2) {
		p("~~~~~~~~~~~~~~~~~" + n1 + "---" + n2);
		if(n1 > n2) {
			return;
		}
		if(n1 == 0 && n2 == 0) {
			list.add(str);
			return;
		}
		if(n1 > 0) {
			find(list, str + "(", n1 - 1, n2);
//			p("----");
		}
		p("from the left to right");
		if(n2 > 0) {
			find(list, str + ")", n1, n2 - 1) ;
//			p("----");
		}
		p(n1 + "---" + n2);
	}

	static void p(Object o) {
		System.out.println(o);
	}
}
