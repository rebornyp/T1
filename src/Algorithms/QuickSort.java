package Algorithms;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 5, -9, 21, -23, 8};
//		Arrays.sort(a);
//		insertSort(a, 0, a.length-1);
		quickSort(a, 0, a.length-1);
		p(a);
	}
	
	/**
	 * 插入排序算法
	 * @param a
	 * @param left
	 * @param right
	 */
	static void insertSort(int[] a, int left, int right) {
		for (int i = left, j = i; i < right; j = ++i) {
            p(i +"-" + j);
			long ai = a[i+1];
            while (ai < a[j]) {
                a[j + 1] = a[j];
                if (j-- == left) {
                    break;
                }
            }
            a[j + 1] = (int)ai;
        }
	}

	/**
	 * 在[i,j]之间随机产生一个整数
	 * @param i
	 * @param j
	 * @return
	 */
	static int randomInt(int i, int j) {
		if(j <= i)
			return 0;
		Random r = new Random();
		return r.nextInt(j - i + 1) + i;
	}
	
	/**
	 * 快速排序算法，输入数组a，和数组下界start与上界end
	 * @param a
	 * @param start
	 * @param end
	 */
	private static void quickSort(int[] a, int start, int end) {
		if(a == null || a.length <= 1 || start >= end)
			return;
		int i = start-1, temp; //这个是为了让后续好+1啊
		int rand = randomInt(start, end);
		if(rand != end) {
			temp = a[end];
			a[end] = a[rand];
			a[rand] = temp;
		}
		int value = a[end]; // 定下一个数值，如果定下最后一个，那么就从前往后开始遍历，如果定下最前头一个，那么就从后往前遍历
		for(int j=start; j<end; j++) {
			if(a[j] <= value) {
				i ++; // 结合初始条件就能看懂了
				if(i != j) { //可以减少i=j时再去换值
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		if(i+1 != end) {
			a[end] = a[i+1]; //搞完了正好从0~i都是小于value的数值，那么就把第i+1个(肯定是大于value或者是它本身)和定下的value互换位置
			a[i+1] = value;
		}
		//以value换了以后的新的位置为界限，然后左右都递归调用原函数进行排序
		quickSort(a, start, i);
		quickSort(a, i+2, end);
	}

	static void p(int[] a) {
		String s = "[";
		for(int i=0; i<a.length; i++)
			if(i != a.length - 1)
				s += a[i] + ",";
			else
				s += a[i] + "]";
		System.out.println(s);
	}
	
	static void p(Object o) {
		System.out.println(o);
	}
}
