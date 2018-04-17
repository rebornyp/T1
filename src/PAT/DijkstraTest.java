package PAT;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraTest {

	static DijkstraTest instance = new DijkstraTest(); // 用于生成内部类Edge的实例
	static int N, M; // N为顶点总数，M为边的总数
	static List<Edge>[] bag; // 用于存放所有边信息的邻接表
	static int[] dis; // 每一个顶点到出发点的距离数组
	static Edge[] edgeTo; // 使得每一个顶点加入最短路径树的边数组，若没加入，则为空
	static PriorityQueue<IndexMinPQ> pq; // 优先队列
	
	
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
		dis = new int[N];
		edgeTo = new Edge[N];
		for(int i=0; i<N; i++)
			dis[i] = Integer.MAX_VALUE;
		
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
		}
		
		//以上都是图的邻接表的构建
		
		int s0 = 0; // 选定0号顶点作为出发点
		dijkstra(s0); // 计算从s0号顶点出发到其余各点的最短路径
		
		// 打印所有可达的最短路径及加入最短路径树的边信息
		for(int i=0; i<N; i++) {
			if(edgeTo[i] == null && i != s0)
				System.out.println(s0 + "->" + i + ": 不可达；");
			else
				System.out.println(s0 + "->" + i + ": " + dis[i] + "， 最后使该顶点加入树的是：" + edgeTo[i]);
		}
	}
	
	/**
	 * dijkstra算法的主核心代码
	 * @param s
	 */
	private static void dijkstra(int s) {
		dis[s] = 0;
		pq = new PriorityQueue<>();
		pq.add(instance.new IndexMinPQ(s, 0));
		while(!pq.isEmpty())
			relax(pq.poll().v);
	}

	/**
	 * 对顶点进行u的所有邻接边进行松弛
	 * @param u
	 */
	private static void relax(int u) {
		for(Edge e : bag[u]) {
			int v = e.other(u);
			if(dis[v] > dis[u] + e.weigh()) {
				dis[v] = dis[u] + e.weigh();
				edgeTo[v] = e; // 使得顶点v加入最短路径树的边e保存在数组上；
				check(v, dis[v]);
			}
		}
	}

	/**
	 * check函数是用来判断当前的顶点v是否在队列pq中
	 * 如果不存在就得在pq中添加进v及此时他的最短距离。
	 * 如果v已经在，那么就得将修改后的dis[v]重新存入队列中
	 * 因为java是值传递，所以队列里的this.e仅仅是和dis[v]相等，若外部的dis[v]修改了
	 * 那么this.e也得进行修改，做到即时更新顶点v到初始点s的距离
	 * @param v 被松弛的顶点v
	 * @param d 松驰后的距离d
	 */
	private static void check(int v, int d) {
		Iterator<IndexMinPQ> it = pq.iterator();
		while(it.hasNext()) {
			IndexMinPQ temp = it.next();
			if(temp.v == v) {
				temp.distance = d;
				return; // 一旦查找到队列中含有该点就立马停止返回
			}
		}
		pq.add(instance.new IndexMinPQ(v, d)); // 优先队列加入该点和距离
	}

	/**
	 * 这个类主要实现了对每次松弛后顶点序号，及此时顶点到初始点s的距离的存储
	 * 主要用于后续实现对距离e的排序，并可以及时取出最小距离的顶点序号key
	 * @author Gastby
	 *
	 */
	private class IndexMinPQ implements Comparable<IndexMinPQ> {

		int v; // 保存顶点下标
		int distance; // 保存v顶点到出发点s的距离
		
		IndexMinPQ(int k, int e) {
			this.v = k;
			this.distance = e;
		}

		/**
		 * 因为要放入优先队列中，所以必须实现这个接口
		 */
		@Override
		public int compareTo(IndexMinPQ p) {
			if(distance > p.distance) return 1;
			else if(distance < p.distance) return -1;
			return 0;
		}
	}
	
	/**
	 * 带权有向边的类，其实在最短路径中这个边类和最小生成树中的边是一样的
	 * 而且这条边不管用来表示有向还是无向图，加权或者不加权，都是一样的(不加权无非都是1咯)；
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
			return "长为" + weigh() + "的边";
		}
	}

}
