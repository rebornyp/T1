package PAT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Emergency {
	
	class Edge {
		int v, weigh;
		Edge(int v, int weigh) {
			this.v = v;
			this.weigh = weigh;
		}
		
	}
	
	static Emergency instance = new Emergency();
	static int[] team, dis, visited;
	static List<Edge>[] list;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] temp1 = s.nextLine().trim().split(" ");
		String[] temp2 = s.nextLine().trim().split(" ");
		int N = Integer.valueOf(temp1[0]);
		int M = Integer.valueOf(temp1[1]);
		int st = Integer.valueOf(temp1[2]);
		int des = Integer.valueOf(temp1[3]);
		team = new int[N];
		list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			team[i] = Integer.valueOf(temp2[i]);
			list[i] = new ArrayList<Edge>();
			dis[i] = INF; // 代表离出发点无穷远
			visited[i] = 0; //代表还未访问
		}
		for(int i=0; i<M; i++) {
			temp1 = s.nextLine().trim().split(" ");
			int u = Integer.valueOf(temp1[0]);
			int v = Integer.valueOf(temp1[1]);
			int distance = Integer.valueOf(temp1[2]); 
			Edge e1 = instance.new Edge(v, distance);
			list[u].add(e1);
			Edge e2 = instance.new Edge(u, distance);
			list[v].add(e2);
		}
		SPA(st);
	}

	private static void SPA(int st) {
		dis[st] = 0;
		List<Integer> list = new ArrayList<Integer>();
		list.add(st);
		while(!list.isEmpty()) {
			
		}
	}

	
}