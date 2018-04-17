package useful;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Map {

	//顶点的类
	private class VerNode {
		String info;//顶点信息
		EdgeNode link;
		int indegree = 0;   
	}

	//有向边的类
	private class EdgeNode {
		int num;//指向顶点的在边节点表的顶点位置
		double weight;//边的权值
		EdgeNode link;
	}	
	
	int n;//图顶点数目
	VerNode[] side ;//图的边结点数组
	static Queue<Integer> theQueue = new LinkedList<Integer>();//用来广度优先遍历的队列
	//构造方法
	public Map(int i) {
		this.n = i;
		this.side = new VerNode[i];
	}
	  
	public Map() {
		n = 10;
		this.side = new VerNode[n];
	}
		
	public static void main(String[] args) {
//		Map s = creatMap();//图的创建
//		s.output();//打印邻接表
//		s.topology();//拓扑排序方法
//		DFS_main(s);//深度优先算法
//		BFS_main(s);//广度优先算法
		
		
	}
	
	//广度优先搜索算法
	private static void BFS_main(Map s) {
		int i = 0;
		int[] visited = new int[s.n];
		for(i = 0;i < s.n;i++) {
			visited[i] = 0;
		}
		for(i = 0;i < s.n;i++) {
			if(visited[i] == 0)
				BFS(s , i , visited);
		}
	}
	private static void BFS(Map s, int i, int[] visited) {
		System.out.println("顶点信息如下："+s.side[i].info);
		visited[i] = 1;		
		int w ;		
		theQueue.add(i);
		while(!theQueue.isEmpty()) {
			i = (Integer)theQueue.remove();
			if(s.side[i].link == null)
				w = -1;
			else
				w = s.side[i].link.num;
			EdgeNode p = s.side[i].link;
			while(w != -1) {
				if(visited[i] != 1) {
					System.out.println(s.side[w].info);
					visited[i] = 1;
					theQueue.add(w);
				}
				p = p.link;
				if(p == null)
					w = -1;
				else
					w = p.num;
			}
		}		
	}

	//深度优先遍历算法
	private static void DFS_main(Map s) {
		int i = 0;
		int[] visited = new int[s.n];
		for(i = 0;i < s.n;i++) {
			visited[i] = 0;
		}
		for(i = 0;i < s.n;i++) {
			if(visited[i] == 0)
				DFS(s , i , visited);
		}
	}

	//深度优先算法递归部分
	private static void DFS(Map s, int i, int[] visited) {
		System.out.println("顶点信息如下："+s.side[i].info);
		visited[i] = 1;
		
		int w ;
		
		if(s.side[i].link == null)
			w = -1;
		else 
			w = s.side[i].link.num;
		
		EdgeNode p = s.side[i].link;
		while(w != -1) {
			if(visited[w] == 0)
				DFS(s , w , visited);
			p = p.link;
			if(p == null)
				w = -1;
			else
				w = p.num;
		}
		
	}

	//图的拓扑排序算法
	private void topology() {
		int top = -1;
		EdgeNode p;
		for(int i = 0;i < n;i++) {
			if(side[i].indegree == 0) {
				side[i].indegree = top;
				top = i;
			}
		}
		
		String[] name = new String[n];
		System.out.println("拓扑排序如下~~~");
		
		
		for(int i = 0;i < n;i++) {
			if(top == -1) {
				System.out.println("图存在回路");
				break;
			}
			else {
				int temp = top;
				top = side[top].indegree;
				name[i] = side[temp].info;
				System.out.printf("%s  ",side[temp].info);
				p = side[temp].link;
				while(p != null) {
					int k = p.num;
					side[k].indegree--;
					if(side[k].indegree == 0) {
						side[k].indegree = top;
						top = k;
					}
					p = p.link;
				}
			} 
		}
	}
	
	
	//打印树的边节点函数
	private void output() {
		System.out.println("打印图的节点信息如下");
		for(int i = 0;i < this.n;i++) {
			System.out.printf("第%d个顶点信息  %s,该顶点入度是%d",i+1,this.side[i].info , this.side[i].indegree);
			System.out.println();
			System.out.printf("从第%d个顶点出发的边的信息如下",i+1);
			System.out.println();
			EdgeNode p = this.side[i].link;
			if(p == null)
				System.out.println("抱歉，并没有找到从该点出发的边");
			else{
				int k = 0;
				while(p != null) {
					k++;
					System.out.printf("第%d条边指向第%d个顶点，权值是%f  ", k , p.num + 1 , p.weight);
					System.out.println();
					p = p.link;
				}
			}
		}
	}
	
	
	//创建图的函数
	private static Map creatMap() {
		System.out.println("请输入图的顶点数");
		Scanner s = new Scanner(System.in);
		int temp = s.nextInt();
		if(temp < 1)
			return null;
		Map m = new Map(temp);
		
		for(int i = 0;i < temp;i++) {
			System.out.printf("请输入图第%d个顶点的信息", i+1);
			Map.VerNode tempNode = new Map().new VerNode();
			tempNode.info = s.next();
			m.side[i] = tempNode;
		}
		
		System.out.println("下面请按照顶点编号（第几个顶点），权值，下一个顶点编号的顺序");
		System.out.println("依次输入所创建图的边信息,输入完毕请输入-1（中间请用空格间隔开来）");
		while(true) {
			int a = s.nextInt();
			if(a == -1)
				break;
			double weight = s.nextDouble();
			int b = s.nextInt();
			
			if(m.side[a-1].link == null) {
				Map.EdgeNode node = new Map().new EdgeNode();
				node.weight = weight;
				node.num = b - 1;
				m.side[b-1].indegree++;	
				m.side[a-1].link = node;
			}
			else {
				EdgeNode p = m.side[a-1].link;
				while(p.link != null) {
					p = p.link;
				}
				Map.EdgeNode node = new Map().new EdgeNode();
				node.weight = weight;
				node.num = b - 1;
				m.side[b-1].indegree++;	
				p.link = node;
			}
			
		}
		s.close();
		return m;
	}

}
