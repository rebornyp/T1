package PAT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class CoutingLeaves {

	static int N, M;
	static List<Integer>[] list;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		list = new ArrayList[N];
		for(int i=0; i<list.length; i++)
			list[i] = new ArrayList<Integer>();
		for(int i=0; i<M; i++) {
			int k = s.nextInt() - 1;
			int n = s.nextInt();
			for(int j=0; j<n; j++)
				list[k].add(s.nextInt() - 1);
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		int num = 1, temp = 0, depth = 0, total = 0;
		int[] arr = new int[N];
		while(!queue.isEmpty()) {
			int index = queue.poll();
			num --;
			if(list[index].size() == 0)
				total ++;
			for(int i=0; i<list[index].size(); i++)
				queue.add(list[index].get(i));
			temp += list[index].size();
			if(num == 0) {
				num = temp;
				temp = 0;
				arr[depth ++] = total;
				total = 0;
			}
		}
		
		for(int i=0; i<depth; i++) {
			if(i == 0) System.out.print(arr[i]);
			else System.out.print(" " + arr[i]);
		}
	}

}
