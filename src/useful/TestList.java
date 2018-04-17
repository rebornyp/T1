package useful;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
/**
 * n个矩阵链乘问题，根据矩阵相乘的结合律，如何简化计算使得该计算过程拥有最少的乘法标量
 * @author Gastby
 *
 */
public class TestList {
	
	public static void main(String[] args) { 
		Random r = new Random();
		int[] arr = {30, 35, 15, 5, 10, 20, 25};
		int len = arr.length - 1;
		int[][] m = new int[len][len];
		int[][] s = new int[len][len];
		MatrixOrder(arr, s, m); //主算法，自下而上求算所有情况下(i<j && i,j都属于0~(len-1))的最优链乘解
		PrintStream ps = System.out;
		ps.println(Arrays.toString(arr));
		StringBuilder str = new StringBuilder();
		for(int i=0; i<m.length; i++) {
			str.append(Arrays.toString(m[i])  + "\n");
		}
		ps.println("[" + str + "]"); //打印m二维矩阵，是一个上三角阵，因为j>i
		ps.println(m[0][len-1]); // 打印出所有矩阵在一起，从第一个到最后一个链乘的最少乘法标量数
		/*回溯构建最佳解并打印出来*/
		printOptimalParens(s, 0, len-1);
	}

	/**
	 * 构造最优解
	 * @param s 用来存放每一组(i, j)代表的矩阵链(i<j)之间的最优分割点
	 * @param i 从第i个矩阵
	 * @param j 到第j个矩阵
	 */
	private static void printOptimalParens(int[][] s, int i, int j) {
		if(i == j) {
			System.out.print("A" + (i + 1));
		} else {
			System.out.print("(");
			printOptimalParens(s, i, s[i][j]);
			printOptimalParens(s, s[i][j]+1, j);
			System.out.print(")");
		}
	}

	/**
	 * 从底向上的求算最佳链乘计算步骤数，并存入m矩阵，内部包含初始化，主要实现算法
	 * @param arr 链乘矩阵系列存储行列数组，n个矩阵则arr长度为n+1,多一个参数
	 * @param s 用来存储第i到j之间最优分割点的二维数组
	 * @param m 存储第i到j个矩阵之间链乘最少乘法标量数
	 */
	private static void MatrixOrder(int[] arr, int[][] s, int[][] m) {
		int n = m.length;
		for(int i=0; i<n; i++) {
			m[i][i] = 0;
		}
		for(int l=2; l<=n; l++) {
			for(int i=0; i<n-l+1; i++) {
				int j = i+l-1;
				m[i][j] = Integer.MAX_VALUE;
				int q;
				for(int k=i; k<j; k++) {
					q = m[i][k] + m[k+1][j] + arr[i] * arr[k+1] * arr[j+1];
					if(q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k; //能用来记录从第i到第j个矩阵链乘里，中间首先挑哪一个数k(i<=k<j)划分用来划分最合适
					}
				}
			}
		}
		
	}

}