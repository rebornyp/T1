package PAT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

	int a = 1;
	static String s;
	static int m = 2;
	static {
		s = "oss";
		System.out.println(m);
	}
	
	Test() {
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1, -20, -2, 9, 4, -5}; 
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(find(-2, arr));
	}

	private static int find(int val, int[] arr) {
		int left = 0, right = arr.length - 1;
		int mid = 0;
		while(left < right - 1) {
			mid = left + (right - left) / 2;
			if(val > arr[mid])
				left = mid;
			else right = mid;
		}
		if(val == arr[right]) return right;
		else if(val == arr[left]) return left;
		return -1;
	}

	private static int count(int[] arr) {
		if(arr == null || arr.length == 0) return 0;
		int max = arr[0], temp = arr[0];
		for(int i=1; i<arr.length; i++) {
			/*temp = Math.max(temp + arr[i], arr[i]);
			max = Math.max(max, temp);*/
			temp = Math.min(temp + arr[i], arr[i]);
			max = Math.min(max, temp);
		}
		return max;
	}

	private static int help() {
		int i = 0;
		try {
			i = 1;
			return i;
		} catch (Exception e) {
			i = 2;
			return i;
		} finally {
			i = 3;
		}
	}

	
}
