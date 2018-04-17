package PAT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PublicBikeManage2 {

	static int Cmax, N, des, total, send;;
	static int[] nums, dis;
	static int[][] edges;
	static boolean[] marked;
	static private List<Integer> result = null;
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		Cmax = s.nextInt();
		N = s.nextInt() + 1;
		des = s.nextInt();
		int M = s.nextInt();
		nums = new int[N];
		dis = new int[N];
		for(int i=0; i<N; i++)
			dis[i] = Integer.MAX_VALUE;
		marked = new boolean[N];
		edges = new int[N][N];
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++) 
				if(j == i) edges[i][j] = 0;
				else edges[i][j] = Integer.MAX_VALUE;
		for(int i=1; i<N; i++)
			nums[i] = s.nextInt();
		for(int i=0; i<M; i++) {
			int u = s.nextInt();
			int v = s.nextInt();
			edges[u][v] = s.nextInt();
			edges[v][u] = edges[u][v];
		}
		s.close();
		
		dis[0] = 0;
		dijkstra();
		
		System.out.println(Arrays.toString(dis));
		
		for(int i=0; i<marked.length; i++)
			marked[i] = false;
		marked[0] = true;
		List<Integer> temp = new ArrayList<>();
		temp.add(0);
		dfs(0, 0, 0, 0, temp);
		
		System.out.print(send + " ");
		for(int i=0; i<result.size(); i++) {
			if(i == 0) System.out.print(result.get(i));
			else System.out.print("->" + result.get(i));
		}
		System.out.print(" " + total);	
		
	}

	private static void dfs(int u, int rout, int bag, int back, List<Integer> tempList) {
		if(rout > dis[des]) return;
		if(rout == dis[des] && u == des) {
			boolean flag = false;
			if(result == null) {
				flag = true;
			} else if(bag < send) {
				flag = true;
			} else if(bag == send && back < total) {
				flag = true;
			}
			if(flag) {
				result = new ArrayList<>(tempList);
                send = bag;
                total = back;
			} else return;
		} else if(rout == dis[des]) return;
		
		for(int i=0; i<N; i++) {
			if(edges[u][i] == Integer.MAX_VALUE) continue;
			int b1 = bag, b2 = back;
			if(marked[i] || dis[i] == Integer.MAX_VALUE) continue;
			marked[i] = true;
			if(nums[i] < Cmax / 2) {
				int temp = Cmax / 2 - nums[i];
				if(back - temp >= 0) {
					back -= temp;
				} else {
					bag += (temp - back);
					back = 0;
				}
			} else {
				int temp = nums[i] - Cmax / 2;
				back += temp;
			}
			tempList.add(i);
			dfs(i, rout + edges[u][i], bag, back, tempList);
			bag = b1;
			back = b2;
			marked[i] = false;
			tempList.remove(tempList.size()-1);
		}
		
	}
	
	/**
	 * 单源最短路径求算
	 * @param s
	 */
	private static void dijkstra() {
		int min, u;
		for(int i=0; i<N; i++) {
			u = -1;
			min = Integer.MAX_VALUE;
			for(int j=0; j<N; j++) {
				if(!marked[j] && dis[j] < min) {
					min = dis[j];
					u = j;
				}
			}
			if(u == -1) break;
			marked[u] = true;
			for(int j=0; j<N; j++) {
				if(dis[u] + edges[u][j] < 0 || marked[j]) continue; // 这个一定得加上，防止相加和越界
				if(dis[j] > dis[u] + edges[u][j])
					dis[j] = dis[u] + edges[u][j];
			}
		}
	}
	
	

}
