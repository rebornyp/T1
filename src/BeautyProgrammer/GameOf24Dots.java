package BeautyProgrammer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GameOf24Dots {

	public static void main(String[] args) {
		int[][] pre = {{1, 0}, {2, 0}, {3, 0}, {2, 1}, {3, 2}, {1, 3}};
		System.out.println(canFinish(4, pre));
	}
	
    public static boolean canFinish(int num, int[][] pre) {
    	List<Integer>[] list = new ArrayList[num];
    	for(int i=0; i<num; i++)
    		list[i] = new ArrayList<Integer>();
    	
    	for(int i=0; i<pre.length; i++) {
    		list[pre[i][1]].add(pre[i][0]);
    	}
//    	System.out.println(Arrays.toString(list));
    	
    	int[] indegree = new int[num];
    	for(int i=0; i<list.length; i++) {
    		for(int j : list[i])
    			indegree[j] ++;
    	}
//    	System.out.println(Arrays.toString(indegree));
    	
    	Deque<Integer> stack = new LinkedList<Integer>();
    	for(int i=0; i<indegree.length; i++)
    		if(indegree[i] == 0)
    			stack.push(i);
    	while(!stack.isEmpty()) {
    		int i = stack.pop();
    		for(int j : list[i]) {
    			indegree[j] --;
    			if(indegree[j] == 0)
    				stack.push(j);
    		}
    	}
    	for(int i : indegree)
    		if(i != 0)
    			return false;
        return true;
    }
}
