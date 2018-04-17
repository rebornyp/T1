package PAT;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeMap;

public class MaxPQ1<Key extends Comparable<Key>> {

	private Key[] keys; //存储最大堆的元素数组
	private int size; //堆中的元素个数，动态改变的参数
	
	MaxPQ1() {
		keys = (Key[])new Comparable[100];
		size = 0;
	}

	/**
	 * 根据设置容量来构造最大堆
	 * @param max
	 */
	MaxPQ1(int max) {
		keys = (Key[])new Comparable[max + 1]; // 比容量多1，是为了腾出index为0的位置不用，方便计算下标
		size = 0;
	}
	
	/**
	 * 根据一个元素数组构造最大堆
	 * @param arr
	 */
	public MaxPQ1(Key[] arr) {
		keys = (Key[])new Comparable[arr.length + 1];
		for(int i=1; i<=arr.length; i++)
			keys[i] = arr[i-1]; //先将元素数组复制到keys中
		size = keys.length-1; 
		for(int i=arr.length/2; i>=1; i--) //这一步可以使得构造最大堆的复杂度降低到O(N)
			siftDown(i);
	}

	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		TreeMap<Integer, String> m = new TreeMap<Integer, String>();
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();
		Random r = new Random();
		for(int i=0; i<10; i++)
			p.add(r.nextInt(100));
		while(!p.isEmpty())
			System.out.print(p.poll() + " ");
	}

	private static void test3() {
		String[] arr = {"sad", "happy", "nice", "good"};
		MaxPQ1<String> m = new MaxPQ1<>(arr);
		List<String> list = new ArrayList<>();
		while(!m.isEmpty())
			list.add(m.delMax());
		System.out.println(list);
	}

	/**
	 * 测试函数2
	 */
	private static void test2() {
		Random r = new Random();
		MaxPQ1<Integer> m = new MaxPQ1<>(50);
		for(int i=0; i<50; i++)
			m.insert(r.nextInt(100));
		List<Integer> list = new ArrayList<>();
		while(!m.isEmpty())
			list.add(m.delMax());
		System.out.println(list);
	}

	/**
	 * 专门测试第一种输入的函数
	 */
	private static void test1() {
		Integer[] arr = {1, 2, 0, 5, 3, 9, 6, 7, 10, 11};
		MaxPQ1<Integer> m = new MaxPQ1<>(arr);
		List<Integer> list = new ArrayList<>();
		while(!m.isEmpty())
			list.add(m.delMax());
		System.out.println(list);
	}

	/**
	 * 判别最大堆是否为空的方法
	 * @return
	 */
	private boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 删除并返回堆顶最大值
	 * @return
	 */
	private Key delMax() {
		Key temp = keys[1];
		keys[1] = keys[size --];
		siftDown(1);
		return temp;
	}

	/**
	 * 从任意位置下沉的函数，所谓下沉，就是将该位置的元素和它的两个儿子的元素对比，看谁更“优先”，不优先的往后挪
	 * @param index 初始位置
	 */
	private void siftDown(int index) {
		int i;
		while(index * 2 <= size) {
			if(keys[index].compareTo(keys[2 * index]) < 0) //如果index的key值比左儿子小
				i = 2 * index;
			else
				i = index;
			
			if(index * 2 + 1 <= size) { //如果存在右儿子
				if(keys[i].compareTo(keys[2*index+1]) < 0)
					i = 2*index+1;
			}
			
			if(i != index) {
				Key temp = keys[i];
				keys[i] = keys[index];
				keys[index] = temp;
				index = i;
			} else 
				break;
		}
	}

	/**
	 * 插入元素的函数
	 * @param next
	 */
	private void insert(Key next) {
		if(size == keys.length - 1) return; //队列已满
		keys[++ size] = next; 
		siftUp(size); //将最后插入的元素上浮
	}

	/**
	 * 从index位置的元素进行上浮操作，和父亲比较，优先的上浮直到不优先为止。
	 * @param index
	 */
	private void siftUp(int index) {
		while(index != 1) {
			if(keys[index].compareTo(keys[index/2]) > 0) {
				Key temp = keys[index];
				keys[index] = keys[index / 2];
				keys[index / 2] = temp;
				index = index / 2;
			} else
				break;
		}
	}

}
