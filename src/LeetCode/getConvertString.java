package LeetCode;

import java.util.ArrayList;

public class getConvertString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "asdjka";
		p(get(s, 1));

	}

	private static String get(String s, int n) {
		// TODO Auto-generated method stub
		if(s == null || s == "" || n < 1)
			return null;
		if(n == 1)
			return s;
		int column = 0;
		ArrayList<Point> arr = new ArrayList<Point>();
		for(int i=0; i<s.length(); i++) {
			Point p = new Point();
			p.c = s.charAt(i);
			if((i / (n - 1)) % 2 == 0) {
				p.row = i % (n - 1);
				p.column = column;
			} else {
				p.row = (n - 1) - (i % (n - 1));
				p.column = column ++;
			}
			//p( i + "---" +p.row + "---" + p.column);
			arr.add(p);
		}
		
		String ls = "";
		int maxColumn = 0;
		for(Point p : arr) {
			maxColumn = Math.max(maxColumn, p.column);
		}
		char[][] r = new char[n][maxColumn + 1];
		for(Point p : arr) {
			r[p.row][p.column] = p.c;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<=maxColumn; j++) {
				if(r[i][j] != 0)
					ls += r[i][j];
			}
		}

		return ls;
	}

	static void p(Object o) {
		System.out.println(o);
	}
}

class Point {
	int row, column;
	char c;
}