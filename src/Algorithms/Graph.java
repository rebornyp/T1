package Algorithms;

import java.io.InputStream;
import java.util.HashSet;

/**
 * 《算法》书籍中的图一章节里的代码实现之-
 * 无向图
 * 的数据类型
 * @author Gastby
 *
 */
public class Graph {

	/**
	 * 顶点个数 
	 */
	private final int V;
	
	/**
	 * 图总共边数
	 */
	private int E;
	
	
	
	/**
	 * 创建一个包含V个顶点但不包含边的图
	 * @param V
	 */
	Graph(int v) {
		V = v;
	}
	
	/**
	 * 该构造方法是从输入流中创建一个图，输入流可以是文件读入，或者是控制台的读入
	 * 输入的内容第一个是顶点个数 V
	 * 第二个是总共边数 E
	 * 随后是顶点对如 0 1（用空格间隔开来）
	 * 每次换行读取下一个内容
	 * @param in
	 */
	Graph(InputStream in) {
		V = 0;
	}
	
	/**
	 * 顶点数
	 * @return
	 */
	int V() {
		
		return 0;
	}
	
	/**
	 * 边数
	 * @return
	 */
	int E() {
		return 0;
	}
	
	/**
	 * 向图中添加一条边 v-w
	 * @param v
	 * @param w
	 */
	void addEdge(int v, int w) {}
	
	/**
	 * 求V相邻的所有顶点
	 * @param v
	 * @return
	 */
	Iterable<Integer> adj(int v) {
		return null;
	}
	
	/**
	 * 对象的字符串表示
	 */
	public String toString() {
		return super.toString();
	} 
	
	public static void main(String[] args) {
		
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(1);
		hs.add(2);
		System.out.println(hs.contains(1));
		
		
	}



}
