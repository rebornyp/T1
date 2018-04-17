package LeetCode;

import java.util.Arrays;
import java.util.Random;

public class UniquePath {

	public static void main(String[] args) {
		String s = "123";
		
	}

	private static void p(int[][] arr) {
		for(int i=0; i<arr.length; i++)
			System.out.println(Arrays.toString(arr[i]));
	}

	public static int uniquePaths(int m, int n) {
		if(m < 1 || n < 1) return 0;
		if(m == 1 || n == 1) return 1;
		int[] arr = new int[m];
		for(int i=0; i<m; i++)
			arr[i] = 1;
		for(int i=1; i<n; i++) {
			for(int j=1; j<m; j++) {
				arr[j] = arr[j] + arr[j-1];
			}
		}
		return arr[m-1];
    }
	
    public static int uniquePathsWithObstacles(int[][] og) {
        if(og == null || og.length == 0) return 0;
    	int m = og.length, n = og[0].length;
    	int[] arr = new int[m];
    	boolean flag = false;
    	for(int i=0; i<m; i++) {
    		if(og[i][0] == 0 && flag == false) arr[i] = 1;
    		else if(flag == false)
    			flag = true;
    		if(flag == true) arr[i] = 0;
    	}
    	boolean fn = false;
    	if(arr[0] == 0) fn = true;
    	for(int i=1; i<n; i++) {
    		if(og[0][i] == 0 && fn == false)
    			arr[0] = 1;
    		else if(fn == false)
    			fn = true;
    		if(fn == true) arr[0] = 0;
    		for(int j=1; j<m; j++) {
    			if(og[j][i] == 0)
    				arr[j] = arr[j] + arr[j-1];
    			else
    				arr[j] = 0;
    		}
    	}
        return arr[m-1];
    }

    public static int minPathSum(int[][] grid) {
    	if(grid == null || grid.length == 0) return 0;
    	int m = grid.length, n = grid[0].length;
    	for(int i=1; i<m; i++)
    		grid[i][0] = grid[i][0] + grid[i-1][0];
    	for(int i=1; i<n; i++)
    		grid[0][i] = grid[0][i] + grid[0][i-1];
    	for(int i=1; i<m; i++) {
    		for(int j=1; j<n; j++) {
    			if(grid[i-1][j] > grid[i][j-1])
    				grid[i][j] += grid[i][j-1];
    			else
    				grid[i][j] += grid[i-1][j];
    		}
    	}
    	return grid[m-1][n-1];
    }
}
