package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WordDictionary {

	public static void main(String args[]) {
		String s = "sd";
	}
	
    public static boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int i = nums[0];
        for(int j=1; j<nums.length; j++)
            i &= nums[j];
        System.out.println(Integer.toBinaryString(i));
        return i == Integer.MAX_VALUE ? true : false;
    }
	
    public static int minSubArrayLen(int s, int[] nums) {
        int[] arr = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
        	int sum = 0, n = 0;
        	for(int j=i; j>=0; j--) {
        		sum += nums[j];
        		n ++;
        		if(sum >= s) break;
        	}
        	if(sum >= s) arr[i] = n;
        	if(arr[i] < min && arr[i] != 0)
        		min = arr[i];
        }
        System.out.println(Arrays.toString(arr));
    	return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static int[] canFinish(int num, int[][] pre) {
    	List<Integer>[] list = new ArrayList[num];
    	int[] result = new int[num];
    	for(int i=0; i<num; i++)
    		list[i] = new ArrayList<Integer>();
    	
    	for(int i=0; i<pre.length; i++) {
    		list[pre[i][1]].add(pre[i][0]);
    	}
    	
    	int[] indegree = new int[num];
    	for(int i=0; i<list.length; i++) {
    		for(int j : list[i])
    			indegree[j] ++;
    	}
    	
    	int top = -1;
    	int[] temp = new int[num];
    	for(int i=0; i<num; i++)
    		if(indegree[i] == 0) {
    			temp[i] = top;
    			top = i;
    		}
    	
    	for(int i=0; i<num; i++) {
    		if(top == -1)
    			return null;
    		int j = top;
    		top = temp[top];
    		result[i] = j;
    		for(int k : list[j]) {
    			if(-- indegree[k] == 0) {
    				temp[k] = top;
    				top = k;
    			}
    		}
    	}
    	
        return result;
        
    }
    
}
