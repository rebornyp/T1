package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		int n = 2;
		int[][] arr = generateMatrix(n);
		for(int i=0; i<n; i++)
			System.out.println(Arrays.toString(arr[i]));
	}
	
    public static int[][] generateMatrix(int n) {
    	int[][] arr = new int[n][n];
    	int min = (n + 1) / 2;
    	int k = 1;
    	for(int i=0; i<min; i++) {
        	int last = n - i - 1;
    		for(int j=i; j<n-1-i; j++)
    			arr[i][j] = k ++;
    		for(int j=i; j<=n-1-i; j++)
    			arr[j][last] = k ++;
    		for(int j=n-2-i; j>=i; j--)
    			arr[last][j] = k ++;
    		for(int j=n-2-i; j>i; j--)
    			arr[j][i] = k ++;
        }
        return arr; 
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
        	return list;
        int m = matrix.length, n = matrix[0].length;
        int min = (Math.min(m, n) + 1) / 2;
        for(int i=0; i<min; i++) {
        	int lastRow = m - i - 1;
        	int lastCol = n - i - 1;
        	if(i == lastRow) {
        		for(int j=i; j<=n-1-i; j++)
            		list.add(matrix[i][j]);
        	} else if(i == lastCol) {
        		for(int j=i; j<=m-1-i; j++)
            		list.add(matrix[j][lastCol]);
        	} else {
        		for(int j=i; j<n-1-i; j++)
        			list.add(matrix[i][j]);
        		for(int j=i; j<=m-1-i; j++)
        			list.add(matrix[j][lastCol]);
        		for(int j=n-2-i; j>=i; j--)
        			list.add(matrix[lastRow][j]);
        		for(int j=m-2-i; j>i; j--)
        			list.add(matrix[j][i]);
        	}
        }
        
        return list;
    }
}
