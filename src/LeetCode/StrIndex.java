package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StrIndex {

	public static void main(String[] args) {
		Integer[] a = {5, 12, 64, 32, 9, 45};
		LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(a)); 
//		List<Integer> list = Arrays.asList(a);
//		list.add(0);
//		list.add(34);
		list.addFirst(100);
		list.addLast(999);
		System.out.println(list);
	}
	
	public List<Integer> findSubstring(String s, String[] words) {
		
		return null;
    }
	
	public static int divide(int dividend, int divisor) {
		// 相除时溢出处理
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // 求符号位
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        // 求绝对值，为防止溢出使用long
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        // 记录结果
        int result = 0;

        // 被除数大于除数
        while (dvd >= dvs) {
            // 记录除数
            long tmp = dvs;
            // 记录商的大小
            long mul = 1;

            while (dvd >= (tmp << 1)) {
                tmp <<= 1;
                mul <<= 1;
            }

            // 减去最接近dvd的dvs的指数倍的值（值为tmp）
            dvd -= tmp;

            // 修正结果
            result += mul;
        }

        return result * sign;
    }

}
