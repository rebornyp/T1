package PAT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PrimTest {

	static PrimTest instance = new PrimTest(); // 用于生成内部类Edge的实例
	static int N, M; // N为顶点总数，M为边的总数
	static List<Edge>[] bag; // 用于存放所有边信息的邻接表
	static boolean[] marked; //
	static PriorityQueue<Edge> pq; // 优先队列
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
		
		lazyPrimMST(); // Prim算法的延时实现
		
		// 打印mst中的所有边信息
		List<Edge> list = new ArrayList<>();
		while(!mst.isEmpty())
			list.add(mst.poll());
		System.out.println(list);
	}

	private static void lazyPrimMST() {
		pq = new PriorityQueue<>();
		marked = new boolean[N];
		mst = new LinkedList<>();
		visit(0); // 先从第0个顶点开始加入最小生成树中
		while(!pq.isEmpty()) {
			Edge e = pq.poll(); // 取出优先队列中最短边
			int u = e.either();
			int v = e.other(u);
			if(marked[u] && marked[v]) continue; //若两个顶点都在mst中，则边失效
			mst.add(e); // 否则即为有效边，加入mst中
			if(!marked[u]) visit(u); // 访问还未在mst中的另一个顶点
			if(!marked[v]) visit(v);
		}
	}

	private static void visit(int i) {
		marked[i] = true; // 代表已经加入mst
		for(Edge e : bag[i]) 
			if(!marked[e.other(i)]) pq.add(e);
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
