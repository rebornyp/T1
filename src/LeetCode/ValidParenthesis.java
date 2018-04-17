package LeetCode;

import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "[[";
		p(isValid(s));
	}

	public static boolean isValid(String s) {
		if(s == null)
			return false;
		if(s.length() == 0)
			return true;
		if(s.length() % 2 == 1)
			return false;
		char[][] c = {{'(', '[', '{'}, {')', ']', '}'}};
		Stack<Character> stack = new Stack<Character>();
		boolean f = true;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
				continue;
			}
			boolean flag = false;
			for(int j=0; j<3; j++) {
				if(s.charAt(i) == c[1][j]) {
					if(stack.isEmpty())
						break;
					else
						if(stack.pop() == c[0][j]) {
							flag = true;
							break;
						}
				}
			}	
			if(flag == true)
				continue;
			else {
				f = false;
				break;
			}
		}
		if(stack.isEmpty())
			return f;
		else
			return false;
    }

	static void p(Object o) {
		System.out.println(o);
	}
}
