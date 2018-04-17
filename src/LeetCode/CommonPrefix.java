package LeetCode;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class CommonPrefix {
	public static void main(String[] args) {
		/*Random r = new Random();
		int i = r.nextInt(100);*/
		
		long l = 73032125l;
		l = 73603093l;
		l = 74670343l;
		l = 74971187l;
		l = 76239140l;
		long s = l / 1000;
		System.out.println(s + "秒");
		System.out.println((s = s / 60) + "分钟");
		System.out.println(s / 60 + "小时");
		
		int n = 50;
		
		//System.out.println(f(n));
//		System.out.println(getGoldNumber(100));
//	    System.out.println(getGoldNumber(5));
		
	}

	/**
	 * 斐波那契数列递归调用法
	 * @param n
	 * @return 返回的是斐波那契数组上的第n个数字
	 */
	private static int f(int n) {
		// TODO Auto-generated method stub
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		else
			return f(n-1) + f(n-2);
	}
	
	public static String getGoldNumber(int n) {
		BigDecimal a = new BigDecimal(0.618);
		BigDecimal b = new BigDecimal("1");
		for (int i = 1; i < n + 1; i++) {
			a = b.divide(a.add(b), n, BigDecimal.ROUND_HALF_UP);
		}
		return a.toString();
	}
	
}
