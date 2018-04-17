package PAT;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class CountQueues {

	static int N, M, K, Q;
	
    public static void main(String[] args) {
    	
    
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		K = s.nextInt();
		Q = s.nextInt();
		int[] p = new int[K];
		int[] q = new int[K];
		String[] r = new String[K];
		for (int i=0; i<K; i++) {
			p[i] = s.nextInt();
		}
		for (int i=0; i<Q; i++) {
			q[i] = s.nextInt();
		}
		
		help(p, r);
		
		for (int i=0; i<Q; i++) {
			System.out.println(r[q[i] - 1]);
		}
		//fengshi.yw@alibaba-inc.com
	}
	
	private static void help(int[] p, String[] r) {
		int[] cur = new int[N]; 
		int[] t = new int[K];
		int i;
		Deque<Integer>[] queue = new LinkedList[N]; 
		for (i=0; i<N*M; i++) {
			if (i == K) break;
			if (i < N) {
				cur[i] = p[i];
				t[i] = cur[i];
				r[i] = change(cur[i]);
			} else {
				int k = i % N;
				queue[k].offer(i);
				t[i] = t[queue[k].peekLast()] + p[i];
				r[i] = change(cur[k] + p[i]);
				
			}
		}
		
		if (i < K) {
			for (; i<K; i++) {
				int index = findMin(cur);
				queue[index].offer(i);
				cur[index] += p[queue[index].poll()];
				
			}
		}
		
		
	}
	
	private static int findMin(int[] cur) {
		int index = 0;
		for (int i=1; i<cur.length; i++) {
			if (cur[i] < cur[index])
				index = i;
		}
		return index;
	}
	
	private static String change(int i) {
		String temp;
		int h = i / 60 + 8;
		if (h > 9) temp = "" + h;
		else temp = "0" + h + ":";
		int m = i % 60;
		if (m < 10) temp += "0" + m;
		else temp += m;
		return temp;
	}

}
 