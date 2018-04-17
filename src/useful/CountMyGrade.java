package useful;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CountMyGrade {

	public static void main(String[] args) {
		Random r = new Random();
		
		
	}

    public static List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(nums == null)
    		return res;
    	res.add(new ArrayList<Integer>());
    	for(int k=1; k<=nums.length; k++) {
    		helper(nums, k, 0,new ArrayList<Integer>(), res); 
    	}
    	return res;
    }
	
	private static void helper(int[] nums, int k, int start, ArrayList<Integer> item, List<List<Integer>> res) {
	    if(item.size() == k)  
	    {  
	        res.add(new ArrayList<Integer>(item));  
	        return;  
	    }
	    for(int i=start;i<nums.length;i++)  
	    {  
	        item.add(nums[i]);  
	        helper(nums,k,i+1,item,res);  
	        item.remove(item.size()-1);  
	    } 
	}

	public static List<List<Integer>> combine(int n, int k) {  
	    List<List<Integer>> res = new ArrayList<List<Integer>>();  
	    if(n<=0 || n<k)  
	        return res;  
	    helper(n,k,1,new ArrayList<Integer>(), res);  
	    return res;  
	}  
	private static void helper(int n, int k, int start, ArrayList<Integer> item, List<List<Integer>> res)  
	{  
	    if(item.size()==k)  
	    {  
	        res.add(new ArrayList<Integer>(item));  
	        return;  
	    }  
	    for(int i=start;i<=n;i++)  
	    {  
	        item.add(i);  
	        helper(n,k,i+1,item,res);  
	        item.remove(item.size()-1);  
	    }  
	} 

	private static void countNum2(int[] A) {
	    if(A==null || A.length==0)  
	        return;  
	    int idx0 = 0;  
	    int idx1 = 0;  
	    for(int i=0;i<A.length;i++)  
	    {  
	        if(A[i]==0)  
	        {  
	        	A[i] = 2;  
	            A[idx1++] = 1;  
	            A[idx0++] = 0;  
	        }  
	        else if(A[i]==1)  
	        {  
	        	A[i] = 2;  
	            A[idx1++] = 1;  
	        }  
	    } 
	}
	
    private static void countNum(int[] A) {
    	int[] res = new int[A.length];  
        int[] helper = new int[3];  
        for(int i=0;i<A.length;i++)  
        {  
            helper[A[i]]++;  
        }  
        for(int i=1;i<3;i++)  
        {  
            helper[i]=helper[i]+helper[i-1];  
        }  
        System.out.println(Arrays.toString(A));
        for(int i=0;i<A.length;i++)  
        {  
        	System.out.println(Arrays.toString(res));
            res[helper[A[i]]-1] = A[i];  
            helper[A[i]]--;  
        }  
        for(int i=0;i<A.length;i++)  
        {  
            A[i] = res[i];  
        }
	}

	public static void sortColors(int[] nums) {
        LinkedList<Integer> l = new LinkedList<Integer>();
        int index = 0;
        for(int i=0; i<nums.length; i++) {
        	switch(nums[i]) {
        	case 0: 
        		l.addFirst(0);
        		index ++;
        		break;
        	case 1:
        		l.add(index, 1);
        		break;
        	case 2:
        		l.addLast(2);
        		default:
        	}
        }
        for(int i=0; i<nums.length; i++) 
        	nums[i] = l.get(i);
    }
    
	private static boolean searchMatrix2(int[][] arr, int target) {
		if(arr == null || arr.length == 0 || arr[0].length == 0) return false;
		int row = -1;
		for(int i=0; i<arr.length; i++) {
			if(target > arr[i][0]) {
				row ++;
			} else if(target == arr[i][0])
				return true;
			else
				break;
		}
		if(row == -1) return false;
		for(int i=0; i<arr[0].length; i++) {
			if(target == arr[row][i])
				return true;
		}
		return false;
	}

	/**
	 * 计算我的成绩
	 * @return
	 */
	private static double count() {
		double[][] arr = {{95, 84, 2}, {92, 83.5, 2}, {96, 89, 2}, {95, 92, 1}, {96, 86, 1}, {95, 90, 2}, {95, 85, 2},{92, 76, 2}, {96, 78, 3}, {96, 94, 1}, {95, 95, 2}, {99, 95, 2}, {100, 100, 1}, {93, 85, 2}, {90, 78, 2}};
		double mul = 0.0, up = 0.0;
		for(int i=0; i<arr.length; i++) {
			up += (arr[i][1] / arr[i][0]) * 100 * arr[i][2];
			mul += arr[i][2];
		}
		System.out.println(up);
		System.out.println(mul);
		return up / mul;
	}

    public static boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length == 0 || matrix[0].length == 0) return true;
    	if(target < 0 || target > matrix.length) return false;
    	int index = 0, num = 0, rowMax = 0;
    	boolean flag;
    	for(int i=0; i<matrix.length; i++) {
    		flag = true;
    		int min = matrix[i][0];
    		for(int j=1; j<matrix[0].length; j++) {
    			if(matrix[i][j] >= min)
    				min = matrix[i][j];
    			else flag = false;
    		}
    		
    		if(flag == true) {
    			if(index == 0 || matrix[i][0] > rowMax) {
    				num ++;
    				index ++;
    			} else {
    				index = 1;
    				num = 1;
    			}
    			rowMax = min;
    		} else {
    			index = 0;
    			num = 0;
    		}
    		
    		if(num == target)
    			return true;
    	}
    	return false;
    }
}
