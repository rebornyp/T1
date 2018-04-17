package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode200After {

	static int[] arr;
	
	public static void main(String[] args) {
		int n = 10;
		List<Integer> list = new ArrayList<Integer>();
		int i = 1;
		while(i <= n)
			list.add(i ++);
		Collections.shuffle(list);
		arr = new int[list.size()];
		for(i=0; i<list.size(); i++)
			arr[i] = list.get(i);
		System.out.println(list);
		System.out.println(getMinSortNum(arr));
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 成员变量数组arr代表所有烙饼信息，第0个元素是烙饼底部，最后元素的烙饼顶部，要求最后实现有底到顶从大到小的排列
	 * 该函数是为了计算翻烙饼过程中的最少操作数，定义每次翻烙饼只能从顶部到中间某个饼一次翻转，
	 * @param arr2 烙饼信息信息数组
	 * @return 翻烙饼过程中的最少操作数
	 */
    private static int getMinSortNum(int[] arr) {
    	int counter = 0;
    	int mid;
    	for(int i=0; i<arr.length; i++) {
    		mid = i;
    		for(int j=i+1; j<arr.length; j++) {
    			if(arr[j] > arr[mid])
    				mid = j;
    		}
    		if(mid != i) {
    			reverse(mid);
    			reverse(i);
    			counter += 2;
    		}
    	}
    	return counter;
	}

    /**
     * 实现烙饼数组中某个位置到末尾集体翻转
     * @param left 翻转的最左端index
     */
	private static void reverse(int left) {
		int right = arr.length - 1;
		while(left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left ++;
			right --;
		}
	}

	public static int rangeBitwiseAnd(int m, int n) {
    	assert m > 6 : "error";
        int result = m;
    	for(int i=m; i<=n; i++) {
        	result = result & i;
        }
    	return result;
    }
	
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int num = 0;
        for(int i=0; i<s.length(); i++)
        	if(s.charAt(i) == '1')
        		num ++;
        return num;
    }
	
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int num = 0;
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(!visited[i][j] && grid[i][j] == '1') {
        			num ++;
        			bfs(grid, visited, i, j);
        		}
        	}
        }
        return num;
    }

    private void bfs(char[][] grid, boolean[][] visited, int i, int j) {
    	if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1' && !visited[i][j]) {
    		visited[i][j] = true;
    		bfs(grid, visited, i-1, j);
    		bfs(grid, visited, i+1, j);
    		bfs(grid, visited, i, j-1);
    		bfs(grid, visited, i, j+1);
    	}
	}

	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
    	if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int cur = 1, num = 0;
        queue.offer(root);
        while(!queue.isEmpty()) {
        	TreeNode temp = queue.poll();
        	cur --;
        	if(temp.left != null) {
        		num ++;
        		queue.offer(temp.left);
        	}
        	if(temp.right != null) {
        		num ++;
        		queue.offer(temp.right);
        	}
        	if(cur == 0) {
        		list.add(temp.val);
        		cur = num;
        		num = 0;
        		
        	}
        }
        return list;
    }
	
}
 