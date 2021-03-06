package Algorithms;

import java.io.PrintStream;

/**
 * 最长公共子序列问题（LCS问题）
 * @author Gastby
 *
 */
public class LongestSubString {

	public static void main(String[] args) {
		String a = "asdfsd";
		String b = "agrsds";
		PrintStream ps = System.out;
		Nut[][] c = lg(a, b);
		LCS(c, a, a.length(), b.length());
		
	}

	/**
	 * 
	 * @param c
	 * @param a
	 * @param i
	 * @param j
	 */
	private static void LCS(Nut[][] c, String a, int i, int j) {
		if(i == 0 || j == 0)
			return;
		if(c[i][j].s.equals("wn")) {
			LCS(c, a, i-1, j-1);
			System.out.print(a.charAt(i-1));
		} else if(c[i][j].s.equals("w"))
			LCS(c, a, i, j-1);
		else
			LCS(c, a, i-1, j);
	}

	/**
	 * 用来获取最长子序列主算法
	 * @param a 字符串a
	 * @param b 字符串b
	 * @return 返回是Nut[]数组c,保留有数值和特殊符号
	 */
	private static Nut[][] lg(String a, String b) {
		int m = a.length(), n = b.length();
		Nut[][] c = new Nut[m+1][n+1];
		for(int i=0; i<m+1; i++) {
			for(int j=0; j<n+1; j++) {
				c[i][j] = new Nut();
			}
		}
		for(int i=1; i<m+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					c[i][j].val = c[i-1][j-1].val + 1;
					c[i][j].s = "wn";
				} else if(c[i-1][j].val > c[i][j-1].val) {
					c[i][j].val = c[i-1][j].val;
					c[i][j].s = "n";
				} else {
					c[i][j].val = c[i][j-1].val;
					c[i][j].s = "w";
				}
				System.out.print("(" + c[i][j].val + c[i][j].s + ")");
			}
			System.out.println();
		}
		return c;
	}

}

class Nut {
	int val = 0;
	String s;
} 