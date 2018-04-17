package LeetCode;

import java.util.Random;

public class MostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] arr = new int[4];
		int[] arr = {0, 2};
/*		Random r = new Random();
		for(int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(10);
			p(arr[i]);
		}*/
		p(maxArea(arr));
		p(maxArea2(arr));
	}
	
    private static int maxArea2(int[] arr) {
    	if(arr == null || arr.length < 2 )
    		return 0;
    	int max = 0;
    	int start = 0, end = arr.length - 1;
    	while(start < end) {
    		int temp;
    		if(arr[start] == 0 || arr[end] == 0)
    			temp = 0;
    		else
    			temp = Math.min(arr[start], arr[end]) * (end - start);
    		max = Math.max(max, temp);
    		if(arr[start] <= arr[end])
    			start ++;
    		else
    			end --;
    	}
    	return max;
	}

	static int maxArea(int[] arr) {
    	if(arr == null || arr.length < 2 )
    		return 0;
    	int max = 0;
        for(int i=0; i<arr.length; i++) {
        	if(arr[i] != 0) {
        		int temp = 0;
        		for(int j = 0; j<arr.length; j++) {
        			if(j == i)
        				continue;
        			if(arr[j] != 0)
        				temp = Math.max(temp, Math.min(arr[j], arr[i]) * Math.abs(j - i));
        		}
        		max = Math.max(temp, max);
        	}
        }
    	return max;
    }
	
	static void p(Object o) {
		System.out.println(o);
	}
}
