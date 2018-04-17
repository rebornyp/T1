package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-1,0,-5,-2,-2,-4,0,1,-2};
		int target = -9;
		Arrays.sort(arr);
		p(fourSum(arr, target));
		
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums == null)
        	return null;
        if(nums.length < 4)
        	return list;
        for(int i=0; i<nums.length-3; i++) {
        	if(i > 0 && nums[i] == nums[i-1])
        		continue;
        	for(int j=i+1; j<nums.length-2; j++) {
        		if(j > i+1 && nums[j] == nums[j-1])
        			continue;
        		find(nums, list, i, j, target - nums[i] - nums[j]);
        	}
        }
        return list;
    }
	
	private static void find(int[] nums, List<List<Integer>> list, int i, int j, int target) {
		// TODO Auto-generated method stub
		int left = j + 1, right = nums.length - 1;
		while(left < right) {
			if(nums[left] + nums[right] == target) {
				List<Integer> l = new ArrayList<Integer>();
				l.add(nums[i]);
				l.add(nums[j]);
				l.add(nums[left]);
				l.add(nums[right]);
				list.add(l);
				while(left < right && nums[left] == nums[left + 1]) left ++;
				while(left < right && nums[right] == nums[right-1]) right --;
				left ++;
				right --;
			} else if(nums[left] + nums[right] > target)
				right --;
			else
				left ++;
		}
	}

	static void p(Object o) {
		System.out.println(o);
	}
	
}
