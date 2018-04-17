package LeetCode;

import java.util.Arrays;

public class ThreeCloest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {6, 5, 12, 0, 100, -4};
		p(threeSumClosest(a, 0));
	}

	public static int threeSumClosest(int[] a, int target) {
        if(a == null || a.length < 3) return 0;
		Arrays.sort(a);
		int ret = 0;
		int gap = Integer.MAX_VALUE;
		for(int i=0; i<a.length-2; i++) {
			if(i > 0 && a[i] == a[i-1]) continue;
			int left = i+1, right = a.length-1;
			while(left < right) {
				int temp = a[i] + a[left] + a[right];
				if(temp > target) {
					if(temp - target < gap) {
						gap = temp - target;
						ret = temp;
					}
					right --;
				} else if(temp < target) {
					if(target - temp < gap) {
						gap = target - temp;
						ret = temp;
					}
					left ++;
				} else
					return temp;
			}
		}
		return ret;
    }
	
	/**
	 * 打印方法
	 * @param o
	 */
	static void p(Object o) {
		System.out.println(o);
	}
}
