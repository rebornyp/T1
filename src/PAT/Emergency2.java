package PAT;

import java.util.Arrays;
import java.util.Scanner;

public class Emergency2 {

	static int[][] edge;
	static int[] dis, visited, team;
	static int N;
	static int INF = Integer.MAX_VALUE;
	static int pathCount = 0, hands = 0;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] temp1 = s.nextLine().trim().split(" ");
		String[] temp2 = s.nextLine().trim().split(" ");
		N = Integer.valueOf(temp1[0]);
		int M = Integer.valueOf(temp1[1]);
		int st = Integer.valueOf(temp1[2]);
		int des = Integer.valueOf(temp1[3]);
		edge = new int[N][N];
		dis = new int[N];
		visited = new int[N];
		team = new int[N];
		for(int i=0; i<N; i++)
			team[i] = Integer.valueOf(temp2[i]);
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				if(i == j) edge[i][j] = 0;
				else edge[i][j] = Integer.MAX_VALUE;
		for(int i=0; i<M; i++) {
			temp1 = s.nextLine().trim().split(" ");
			int u = Integer.valueOf(temp1[0]);
			int v = Integer.valueOf(temp1[1]);
			int distance = Integer.valueOf(temp1[2]);
			edge[u][v] = distance;
			edge[v][u] = distance;
		}
		
		SPA(st);
		dfs(st, des, team[st], dis[st]);
		System.out.println(pathCount + " " + hands);
	}

	private static void dfs(int st, int des, int num, int distance) {
		if(st == des) {
			if(distance == dis[des])
				pathCount ++;
			if(distance == dis[des] && num > hands)
				hands = num;
			return;
		}
		if(dis[st] > dis[des]) return;
		for(int i=0; i<N; i++)
			if(i != st && edge[st][i] != INF && dis[st] + edge[st][i] <= dis[i])
				dfs(i, des, num + team[i], dis[i]);
	}

	private static void SPA(int st) {

		//初始化dis数组
		for(int i=0; i<N; i++)
			dis[i] = edge[st][i];
		visited[st] = 1;
		
		//Dijkstra算法核心代码
		int min, u;
		for(int i=0; i<N; i++) {
			u = -1;
			min = Integer.MAX_VALUE;
			for(int j=0; j<N; j++) {
				if(visited[j] == 0 && dis[j] < min) {
					min = dis[j];
					u = j;
				}
			}
			if(u == -1) break;
			visited[u] = 1;
			for(int j=0; j<N; j++) {
				if(edge[u][j] < INF) {
					if(dis[j] > dis[u] + edge[u][j])
						dis[j] = dis[u] + edge[u][j];
				}
			}
		}
		
		System.out.println(Arrays.toString(dis));
	}

}
