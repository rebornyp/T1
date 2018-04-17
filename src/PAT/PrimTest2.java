package PAT;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 事实证明，这个方法是不行的 ，不能采用红黑树，还是得用IndexMinPQ来存储所有优先队列才行
 * @author Gastby
 *
 */

public class PrimTest2 {
	static PrimTest2 instance = new PrimTest2(); // 用于生成内部类Edge的实例
	static int N, M; // N为顶点总数，M为边的总数
	static List<Edge>[] bag; // 用于存放所有边信息的邻接表
	static boolean[] marked; //
	static int[] dis;
	static Edge[] edgeTo; //距离树最近的边
	static TreeMap<Integer, Integer> pq; // 变种后的优先队列，由于优先队列不仅需要存储边权值，也得保存是顶点信息，所以这里使用红黑树
	static Queue<Edge> mst; // 用于存放最小生成树中的所有边
	
	/**
	 * 用于测试主函数，输入形式如下，
	 * 5 6 
	 * 0 1 2
	 * 0 2 3
	 * 0 3 1
	 * 1 2 4
	 * 2 4 5
	 * 3 4 6
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] temp1 = s.nextLine().trim().split(" ");
		N = Integer.valueOf(temp1[0]);
		bag = new ArrayList[N];
		for(int i=0; i<N; i++)
			bag[i] = new ArrayList<>();
		edgeTo = new Edge[N];
		marked = new boolean[N];
		dis = new int[N];
		for(int i=0; i<N; i++)
			dis[i] = Integer.MAX_VALUE;
		M = Integer.valueOf(temp1[1]);
		for(int i=0; i<M; i++) {
			temp1 = s.nextLine().trim().split(" ");
			int u = Integer.valueOf(temp1[0]);
			int v = Integer.valueOf(temp1[1]);
			int weigh = Integer.valueOf(temp1[2]);
			Edge e = instance.new Edge(u, v, weigh);
			bag[u].add(e);
			bag[v].add(e); // 因为是无向边，所以一条边得存在两个地方
		}
		
		quickPrimMST(); // Prim算法的延时实现
		
		// 打印mst中的所有边信息
		List<Edge> list = new ArrayList<>();
		for(Edge e : edgeTo)
			if(e != null) list.add(e);
		System.out.println(list);
	}


	private static void quickPrimMST() {
		pq = new TreeMap<>();
		dis[0] = 0;
		pq.put(dis[0], 0);
		while(!pq.isEmpty())
			visit(pq.pollFirstEntry().getValue());
	}


	private static void visit(int i) {
		marked[i] = true; // 代表已经加入MST
		for(Edge e : bag[i]) { 
			int v = e.other(i);
			if(marked[v]) continue; // 若已经在MST中则不考虑，仅考虑所有不在MST上的顶点
			if(e.weigh() < dis[v]) { // 若这条边距离比当前v点离MST的最短距离还小才允与考虑
				edgeTo[v] = e; //记下使得还不在MST的顶点v加入MST瞬间的边e
				dis[v] = e.weigh(); // 记下v点到MST的距离此刻为e权值
				pq.put(dis[v], v); // 如果
			}
		}
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
