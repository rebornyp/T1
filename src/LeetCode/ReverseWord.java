package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReverseWord {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		for(int i=5; i<=625; i=i+5)
			System.out.println(trailingZeroes(i));
		System.out.println();
	}
    
    public static int trailingZeroes(int n) {
        if(n < 0) return 0;
        int k = 0;
        for(int i = 5; i <= n; i = i + 5) {
        	int temp = i;
        	while(temp % 5 == 0) {
        		k ++;
        		temp = temp / 5;
        	}
        }
        return k;
    }
	
	public static int getLadder(int n) {
		int p = 1;
		while(n > 0) {
			p *= n;
			n --;
		}
		return p;
	} 
	
	private static String ch(int n) {
    	StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
	}

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums) {
        	if(map.containsKey(i))
        		map.put(i, map.get(i) + 1);
        	else
        		map.put(i, 1);
        	if(map.get(i) > nums.length / 2) return i;
//        	map.containsKey(i) ? map.put(i, map.get(i) + 1) : map.put(i, 1);
        }
        return 0;
    }

	public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[3];
        int left = 0, right = nums.length-1;
        while(left < right) {
        	if(nums[left] + nums[right] > target)
        		right --;
        	else if(nums[left] + nums[right] < target)
        		left ++;
        	else
        		break;
        }
        arr[1] = left + 1;
        arr[2] = right + 1;
    	return arr;
    }
	
	public static int findPeakElement(int[] nums) {
		int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return right;
    }
	
	public ListNode getIntersectionNode(ListNode A, ListNode B) {
        if(A == null || B == null) return null;
        int l1 = 1, l2 = 0;
        ListNode p1 = A, p2 = B;
        while(p1.next != null) {
        	l1 ++;
        	p1 = p1.next;
        }
        while(p2 != null) {
        	l2 ++;
        	p2 = p2.next;
        }
        
        int d = Math.abs(l1 - l2);
        if(l1 > l2) {
        	p1 = A;
        	p2 = B;
        } else {
        	p1 = B;
        	p2 = A;
        }
        int i = 0;
        while(i < d) {
        	p1 = p1.next;
        	i ++;
        }
        while(p1 != p2) {
        	p1 = p1.next;
        	p2 = p2.next;
        }
        return p1;
        
    }
	
	public static int findMin(int[] num) {
        /*if(nums == null || nums.length == 0) return 0;
		int left = 0, right = nums.length-1;
		while(left < right) {
			if(nums[left] < nums[right])
				return nums[left];
			int mid = (left + right) / 2;
			if(nums[mid] >= nums[left])
				left = mid + 1;
			else
				right = mid;
		}
		return nums[(left + right) / 2];*/
		
		int lo = 0;
        int hi = num.length - 1;
        int mid = 0;
        
        while(lo < hi) {
//            mid = lo + (hi - lo) / 2;
            mid = (lo + hi) / 2;
            if (num[mid] > num[hi])
                lo = mid + 1;
            else if (num[mid] < num[hi])
                hi = mid;
            else 
                hi--;
        }
        return num[lo];
    }
	
	public static int maxProduct(int[] A) {
		int loc_min = 1, loc_max = 1;
		int glb_max = A[0];
		for (int i : A) {
			if (i > 0) {
				glb_max = Math.max(glb_max, loc_max * i);
				loc_max *= i;
				loc_min *= i;
			} else if (i < 0) {
				glb_max = Math.max(glb_max, loc_min * i);
				int temp = loc_max;
				loc_max = Math.max(loc_min * i, 1);
				loc_min = temp * i;
			} else {
				glb_max = Math.max(glb_max, 0);
				loc_max = 1;
				loc_min = 1;
			}
		}
	         
	       return glb_max; 
    }
	
	public static String reverseWords(String s) {
		String[] str = s.trim().split("\\s+");
		System.out.println(Arrays.toString(str));
		StringBuilder sb = new StringBuilder();
		for(int i=str.length-1; i>=0; i--) {
			if(i == str.length-1)
				sb.append(str[i]);
			else {
				sb.append(" ");
				sb.append(str[i]);
			}
		}
		return sb.toString();
    }
}
