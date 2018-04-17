package LeetCode;

import java.util.Arrays;

public class CandyQuestions {

	public static void main(String[] args) {
		int[] arr = {7, 1,2,2,2,2,21, 5, 3, 6, 4};
//		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		Integer i = 1;
		
		System.out.println(Integer.toBinaryString(~i));
	}

    private static void quickSort(int[] arr, int lo, int hi) {
    	if(lo >= hi) return;
    	int j = partition(arr, lo, hi);
    	quickSort(arr, lo, j-1);
    	quickSort(arr, j+1, hi);
	}

	private static int partition(int[] arr, int lo, int hi) {
		int i = lo, j = hi+1;
		// use the left number of whole array as the privote to partify the array
		int v = arr[lo];
		while(true) {
			while(arr[++ i] < v) if(i == hi) break;
			while(arr[-- j] > v) if(j == lo) break;
			if(i >= j) break;
			// exchange arr[i] and arr[j]; 
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		// exchange arr[j] and arr[lo];
		int temp = arr[lo];
		arr[lo] = arr[j];
		arr[j] = temp;
		// and return the index of final v position which is j;
		return j;
	}

	public static int maxProfit(int[] prices) {
    	if(prices == null || prices.length < 2)
    		return 0;
        int[] t = new int[prices.length-1];
        for(int i=0; i<t.length; i++)
        	t[i] = prices[i+1] - prices[i];
        int temp = 0, sum = t[0], max = sum;
        for(int i=1; i<t.length; i++) {
        	if(t[i] > sum + t[i])
        		sum = t[i];
        	else
        		sum += t[i];
        	if(sum > max)
        		max = sum;
        }
        return max < 0 ? 0 : max;
    }
    
    public static int maxMultipileProfit(int[] prices) {
    	if(prices == null || prices.length < 2)
    		return 0;
        int[] t = new int[prices.length-1];
        for(int i=0; i<t.length; i++)
        	t[i] = prices[i+1] - prices[i];
        int sum = 0;
        for(int i=0; i<t.length; i++) {
        	if(t[i] <= 0) continue;
        	sum += t[i];
        }
        return sum < 0 ? 0 : sum;
    }

    public static int atMostTwoMaxProfit(int k, int[] prices) {  
        if(prices==null || prices.length==0)  
            return 0;  
        int[] local = new int[k+1];  
        int[] global = new int[k+1];  
        for(int i=0;i<prices.length-1;i++)  
        {  
            int diff = prices[i+1]-prices[i];  
            for(int j=k;j>=1;j--)  
            {  
                local[j] = Math.max(global[j-1]+(diff>0?diff:0), local[j]+diff);  
                global[j] = Math.max(local[j],global[j]);  
            }  
        }  
        return global[k];  
    }  

    public static boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int l = 0, r = s.length()-1;
        boolean f = false;
        while(l <= r) {
        	if(s.charAt(l) == s.charAt(r)) {
        		l ++;
        		r --;
        	} else if(f == true)
        		return false;
        	else if(l + 1 == r)
        		return true;
        	else if(s.charAt(l+1) == s.charAt(r)) {
        		f = true;
        		l = l + 2;
        		r --;
        	} else if(s.charAt(l) == s.charAt(r-1)) {
        		f = true;
        		l ++;
        		r = r - 2;
        	}
        }
        return true;
    }
}
