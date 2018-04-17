package com;

import java.util.*;

public class GetMostLongStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "asdfghdjkl";
		//String  s = "s";
		System.out.println(leng2(s));
		
		
		
	}

	private static int leng2(String s) {
		// TODO Auto-generated method stub
		if(s == null || s == "")
            return 0;
		int left, right, max;
		Set<Character> set = new HashSet<Character>();
		left = 0;
		right = max = 0;
		while(right < s.length()) {
			if(!set.contains(s.charAt(right))) {
				set.add(s.charAt(right));
			} else {
				max = Math.max(max, right - left);
				while(s.charAt(left) != s.charAt(right)) {
					set.remove(s.charAt(left));
					left ++;
				}
				left ++;
			}
			
			right ++;
			
		}
		
		return Math.max(max, right - left);
	}

	
	
/*	static void p(int[] arr) {
		for(int i=9; i<arr.length; i++) {
			
		}
		
	}*/
	
}
