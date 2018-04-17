package PAT;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		Random r = new Random();
		int n = 10;
		int[] arr = {11, 8, 16, 15};//, 4, 12, 10, 11, 7}; //
		/*for(int i=0; i<n; i++)
			arr[i] = r.nextInt(20);*/
		System.out.println(Arrays.toString(arr));
		int[] t = {1, 4, 7, 8, 10, 11, 12, 15, 16};
		System.out.println(Arrays.toString(t));
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int left, int right) {
		if(left < right) {
			int k = partition3(arr, left, right);
			quickSort(arr, left, k-1);
			quickSort(arr, k+1, right);
		}
	}

	/**
	 * 选取最左边元素作为哨兵，并从右边开始堆积；但从右向左开始遍历
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition1(int[] arr, int p, int q) {
		int value = arr[p], index = q+1;
		for(int i=q; i>p; i--)
			if(arr[i] > value)
				exchange(arr, --index, i);
		exchange(arr, --index, p); //此时可能++index和left相等
		return index;
	}
	
	/**
	 * 选取最右边元素作为哨兵，并从左边开始堆积；但从左边开始遍历
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition2(int[] arr, int p, int q) {
		int value = arr[q], index = p-1;
		for(int i=p; i<q; i++)
			if(arr[i] <= value)
				exchange(arr, ++index, i);
		exchange(arr, ++index, q);
		return index;
	}
	
	/**
	 * 选取最右边元素作为哨兵，并从左边开始堆积；但从右边开始往左遍历
	 * @param arr
	 * @param p
	 * @param q
	 * @return
	 */
	private static int partition3(int[] arr, int p, int q) {
		int value = arr[q], index = q+1;
		for(int i=q; i>=p; i--)
			if(arr[i] > value)
				exchange(arr, --index, i);
		exchange(arr, --index, q);
		return index;
	}

	private static void exchange(int[] arr, int i, int j) {
		if(i == j) return;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}