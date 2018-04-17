package useful;

import java.io.PrintStream;
import java.util.HashMap;

/**
 * 斐波那契数列的实现类
 * @author Gastby
 *
 */
public class FormatTest {

	/**
	 * 哈希表用来存放中间生成的的斐波那契数值
	 */
	static HashMap<Integer, Long> map = new HashMap<Integer, Long>();
	public static void main(String[] args) {
		PrintStream pw = System.out;
		int n = 50;
		pw.println(fb(n)); //直接打印第50个斐波那契数列
	}

	/**
	 * 递归调用，求算中间第n个斐波那契数值
	 * @param n
	 * @return
	 */
	private static Long fb(int n) {
		if(n == 1) {
			if(map.containsKey(n)) //先判断是否已经存入了哈希表中
				return map.get(n);
			else
				map.put(n, (long)1);
			return map.get(n);
		} else if(n == 2) {
			if(map.containsKey(n))
				return map.get(n);
			else
				map.put(n, (long)1);
			return map.get(n);
		} else {
			long v1, v2;
			if(map.containsKey(n-1))
				v1 = map.get(n-1);
			else {
				v1 = fb(n-1);
				map.put(n-1, v1);
			}
			if(map.containsKey(n-2))
				v2 = map.get(n-2);
			else {
				v2 = fb(n-2);
				map.put(n-2, v2);
			}
			return v1 + v2;
		}
	}

}

