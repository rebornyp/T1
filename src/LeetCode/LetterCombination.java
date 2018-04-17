package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 遍历手机9格键盘所有的拼音类型的情况，这里写的是递归算法，后面回继续补上非递归算法
 * @author Gastby
 *
 */
public class LetterCombination {
	
	public static void main(String[] args) {
		
		String digits = "02400017";
		p(letterCombinations(digits));
		
	}

	public static List<String> letterCombinations(String s) {
		List<String> list = new ArrayList<String>();
		if(s == null)
			return null;
		if(s.length() == 0)
			return list;
		String[] num = new String[10];
		num[0] = "";
		num[1] = "";
		num[2] = "abc";
		num[3] = "def";
		num[4] = "ghi";
		num[5] = "jkl";
		num[6] = "mno";
		num[7] = "pqrs";
		num[8] = "tuv";
		num[9] = "wxyz";
		char[] middleChar = new char[s.length()];
		recursiveLetter(list, s, num, 0, middleChar);
		p(list.size());
		return list;
    }
	
	private static void recursiveLetter(List<String> list, String s, String[] num, int index, char[] middleChar) {
		if(index == s.length()) {
			String str = "";
			for(int i=0; i<s.length(); i++) {
				if(middleChar[i] >= 'a' && middleChar[i] <= 'z')
					str += middleChar[i];
			}
			list.add(str);
			return;
		}
		if(s.charAt(index) < '2') {
			recursiveLetter(list, s, num, index + 1, middleChar);
			return;
		}
		int n = s.charAt(index) - '0';
		//p(list);
		for(int i=0; i<num[n].length(); i++) {
			middleChar[index] = num[n].charAt(i);
			recursiveLetter(list, s, num, index + 1, middleChar);
		}
	}

	static void p(Object o) {
		System.out.println(o);
	}
}
