package PAT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class KruskalTest {

	static KruskalTest instance = new KruskalTest(); // 用于生成内部类Edge的实例
	static int N, M; // N为顶点总数，M为边的总数
	static List<Edge>[] bag; // 用于存放所有边信息的邻接表
	static boolean[] marked; //
	static PriorityQueue<Edge> pq; // 优先队列
	static Queue<Edge> mst; // 用于存放最小生成树中的所有边
	static int[] id; // 并查集算法中的基数组
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] temp1 = s.nextLine().trim().split(" ");
		N = Integer.valueOf(temp1[0]);
		bag = new ArrayList[N];
		for(int i=0; i<N; i++)
			bag[i] = new ArrayList<>();
		id = new int[N];
		for(int i=0; i<N; i++)
			id[i] = i;
		
		pq = new PriorityQueue<>();
		
		M = Integer.valueOf(temp1[1]);
		for(int i=0; i<M; i++) {
			temp1 = s.nextLine().trim().split(" ");
			int u = Integer.valueOf(temp1[0]);
			int v = Integer.valueOf(temp1[1]);
			int weigh = Integer.valueOf(temp1[2]);
			Edge e = instance.new Edge(u, v, weigh);
			bag[u].add(e);
			bag[v].add(e); // 因为是无向边，所以一条边得存在两个地方
			pq.add(e);
		}
		
		krusal();
		
		// 打印mst中的所有边信息
		List<Edge> list = new ArrayList<>();
		while(!mst.isEmpty())
			list.add(mst.poll());
		System.out.println(list);
	}

	/**
	 * kruskal主算法思想
	 */
	private static void krusal() {
		mst = new LinkedList<>();
		while(!pq.isEmpty() && mst.size() < N-1) {
			Edge e = pq.poll();
			int u = e.either(), v = e.other(u);
			if(connected(u, v)) continue; // 采用并查集算法，如果两个顶点已经联通
			union(u, v); // 联通两个点
			mst.add(e); // 将边e加入MST队列中
		}
	}

	private static void union(int u, int v) {
		int r1 = find(u), r2 = find(v);
		if(r1 == r2) return;
		id[r1] = r2;
	}

	private static boolean connected(int u, int v) {
		return find(u) == find(v);
	}

	private static int find(int u) {
		while(u != id[u]) u = id[u];
		return u;
	}

	/**
	 * 最小生成树中的带权无向边的类
	 * @author Gastby
	 *
	 */
	private class Edge implements Comparable<Edge>{

		private final int weigh; //权值
		final int u, v; //两个顶点
		
 		Edge(int u, int v, int weigh) {
			this.u = u;
			this.v = v;
			this.weigh = weigh;
		}

		public int weigh() {
			return weigh;
		}
		
		/**
		 * 返回其中一个顶点
		 * @return
		 */
		public int either() {
			return u;
		}
		
		public int other(int k) {
			if(k == u) return v;
			else return u;
		}
		
		/**
		 * 因为要放入优先队列中，所以得实现Comparable接口 
		 */
		@Override
		public int compareTo(Edge that) {
			if(this.weigh() < that.weigh()) return -1;
			else if(this.weigh() > that.weigh()) return 1;
			else return 0;
		}
		
		public String toString() {
			return "边长是" + weigh();
		}
	}
}
