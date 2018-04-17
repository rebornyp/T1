package PAT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PublicBikeManagement {

	static private int Cmax, N, des, total, send; 
	static private int[] nums;
	static final private PublicBikeManagement instance = new PublicBikeManagement();
	static private List<Edge>[] adj;
	static private int[] dis;
	static private boolean[] marked;
	static private List<Integer> result = null;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] temp1 = s.nextLine().trim().split(" ");
		Cmax = Integer.valueOf(temp1[0]);
		N = Integer.valueOf(temp1[1])+1;
		des = Integer.valueOf(temp1[2]);
		int m = Integer.valueOf(temp1[3]);
		
		nums = new int[N];
		adj = new ArrayList[N+1];
		for(int i=0; i<=N; i++)
			adj[i] = new ArrayList<>();
		dis = new int[N];
		for(int i=1; i<N; i++)
			dis[i] = Integer.MAX_VALUE;
		marked = new boolean[N];
		
		temp1 = s.nextLine().trim().split(" ");
		for(int i=1; i<N; i++)
			nums[i] = Integer.valueOf(temp1[i-1]);
		for(int i=0; i<m; i++) {
			temp1 = s.nextLine().trim().split(" ");
			int u = Integer.valueOf(temp1[0]);
			int v = Integer.valueOf(temp1[1]);
			int weigh = Integer.valueOf(temp1[2]);
			Edge e = instance.new Edge(u, v, weigh);
			adj[u].add(e);
			adj[v].add(e);
			
		}
		s.close();
		
		dijkstra(0);
		
		for(int i=0; i<marked.length; i++)
			marked[i] = false;
		marked[0] = true;
		List<Integer> temp = new ArrayList<>();
		temp.add(0);
		dfs(0, 0, 0, 0, 0, temp);
		
		System.out.print(send + " ");
		for(int i=0; i<result.size(); i++) {
			if(i == 0) System.out.print(result.get(i));
			else System.out.print("->" + result.get(i));
		}
		System.out.print(" " + total);
		
	}
	
	private static void dfs(int u, int rout, int depth, int bag, int back, List<Integer> tempList) {
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
		
		for(Edge e : adj[u]) {
			int b1 = bag, b2 = back;
			int v = e.other(u);
			if(marked[v]) continue;
			marked[v] = true;
			if(nums[v] < Cmax / 2) {
				int temp = Cmax / 2 - nums[v];
				if(back - temp >= 0) {
					back -= temp;
				} else {
					bag += (temp - back);
					back = 0;
				}
			} else {
				int temp = nums[v] - Cmax / 2;
				back += temp;
			}
			tempList.add(v);
			dfs(v, rout + e.weigh, depth + 1, bag, back, tempList);
			bag = b1;
			back = b2;
			marked[v] = false;
			tempList.remove(tempList.size()-1);
		}
		
	}

	private static void dijkstra(int s) {
		dis[s] = 0;
		int min, u;
		while(true) {
			min = Integer.MAX_VALUE;
			u = -1;
			for(int i=0; i<N; i++)
				if(!marked[i] && dis[i] < min) {
					min = dis[i];
					u = i;
				}
			if(u == -1) break;
			marked[u] = true;
			for(Edge e : adj[u]) {
				int v = e.other(u);
				if(dis[u] + e.weigh < 0) continue;
				if(dis[v] > dis[u] + e.weigh)
					dis[v] = dis[u] + e.weigh;
			}
		}
	}

	private class Edge {
		private int u, v, weigh;
		Edge(int u, int v, int weigh) {
			this.u = u;
			this.v = v;
			this.weigh = weigh;
		}

		public int other(int k) {
			if(k == u) return v;
			else return u;
		}
		
		public String toString() {
			return " " + weigh;
		}
		
	}
	

}
