package LeetCode;

import java.util.Random;

public class RemoveSameArrayNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0, 0, 0, 9, -34, -34, 900, -2, 65};
		System.out.println(removeValue(arr, 0));
//		System.out.println(sk(arr, 0, arr.length-1, 6));
//		insert(arr);
		p(arr);
	}

	private static int removeValue(int[] arr, int value) {
		if(arr == null || arr.length < 1)
			return 0;
		int t = -1;
		int end = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != value)
				arr[++ t] = arr[i];
		}
		return t + 1;
	}

	private static int removeSame(int[] arr) {
		if(arr == null || arr.length < 1)
			return 0;
		int t = 0;
		int end = 1;
		for(int i=1; i<arr.length; i++) {
			if(arr[i] != arr[t])
				arr[++ t] = arr[i];
		}
		return t+1;
	}

	static int sk(int[] arr, int p, int r, int i) {
		if(p >= r)
			return arr[p];
		int q = randomizedPartition(arr, p, r);
		int k = q + 1 - p;
		if(i == k)
			return arr[q];
		else if(i < k)
			return sk(arr, p, q-1, i);
		else
			return sk(arr, q+1, r, i-k);
	}
	
	private static int randomizedPartition(int[] arr, int p, int q) {
		int t = randomInt(p, q);
		int temp = arr[q];
		if(t != q) {
			arr[q] = arr[t];
			arr[t] = temp;
		}
//		int temp;
		int value = arr[q];
		int i = p - 1;
		for(int j=p; j<q; j++) {
			if(arr[j] < value) {
				i ++;
				if(i != j) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		if(i + 1 != q) {
			arr[q] = arr[i+1];
			arr[i+1] = value;
		}
			
		return i+1;
	}

	/**
	 * shell排序算法
	 * @param arr
	 */
	private static void shell(int[] arr) {
		// TODO Auto-generated method stub
		if(arr == null || arr.length <= 1)
			return;
		int i, j, temp, gap = arr.length;
		boolean flag;
		while(gap > 1) {
			gap = gap / 2;
			do {
				flag = false;
				for(i = 0; i<arr.length - gap; i++) {
					j = i + gap;
					if(arr[j] < arr[i]) {
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						flag = true;
					}
				}
			} while(flag != false);
		}
	}

	/**
	 * 计数排序算法
	 * @param arr
	 */
	private static void baseSort(int[] arr) {
		if(arr == null || arr.length <= 1)
			return;
		int max = arr[0], min = arr[0];
		//求算出这一个数组里面最大和最小数值是多少
		for(int i=1; i<arr.length; i++) {
			if(arr[i] > max)
				max = arr[i];
			else if(arr[i] < min)
				min = arr[i];
		}
		//用最大数值和最小数值差再加上1得出总共闭区间内多少个数字，
		//并以此建立数组
		int[] c = new int[max + 1 - min];
		//先将C数组计算为闭区间内每一个数字在arr数组里出现了几次
		for(int i=0; i<arr.length; i++) {
			c[arr[i] - min] ++;
		}
		//将C数组换算成前面总共有多少个数字的模式
		for(int i=1; i<c.length; i++) {
			c[i] = c[i-1] + c[i];
		}
		//b数组是输出数组，计算为排序输出以后的新数组
		int[] b = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			b[c[arr[i] - min] - 1] = arr[i];
			c[arr[i] - min] --;
		}
		p(b);
	}

	static void p(int[] a) {
		System.out.print("[");
		for(int i=0; i<a.length; i++) {
			if(i != a.length - 1) System.out.print(a[i] + ",");
			else System.out.print(a[i] + "]");
		}
		System.out.println();
	}
	
	public static void insert(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int temp = arr[i];
			int j = i-1;
			while(j > -1 && temp < arr[j]) {
				arr[j+1] = arr[j];
				j --;
			}
			arr[j+1] = temp;
		}
	}
	
	static int randomInt(int i, int j) {
		if(j <= i)
			return 0;
		Random r = new Random();
		return r.nextInt(j - i + 1) + i;
	}
	
	public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
        	return 0;
        if(nums.length == 1)
        	return 1;
        int k=nums.length;
		for(int i=0; i<k; i++) {
        	/*if(nums[i] == nums[i+1]) {
        		
        	}*/
			if(nums[i] == 0) {
				k--;
			}
			System.out.println(nums[i]);
        }
		return 0;
    }
	
}
