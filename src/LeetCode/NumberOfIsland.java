package LeetCode;

public class NumberOfIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
		System.out.println(numIslands(grid));
	}

	
	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int row = grid.length, col = grid[0].length;
		boolean[][] b = new boolean[row][col];
		int num = 0;
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (grid[i][j] == '0' || b[i][j]) continue;
				else {
					dfs(grid, i, j, b);
					num ++;
				}
			}
		}
		return num;
    }


	private static void dfs(char[][] grid, int i, int j, boolean[][] b) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || b[i][j] || grid[i][j] == '0') return;
		b[i][j] = true;
		dfs(grid, i-1, j, b);
		dfs(grid, i+1, j, b);
		dfs(grid, i, j-1, b);
		dfs(grid, i, j+1, b);
	}
}
