package LeetCode;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class MinStack {
	private Deque<Integer> lk;
    public MinStack() {
        lk = new LinkedList<Integer>();
        
    }
    
    public void push(int x) {
        lk.push(x);
    }
    
    public void pop() {
        lk.pop();
    }
    
    public int top() {
        return lk.peek();
    }
    
    public int getMin() {
        Iterator<Integer> it = lk.iterator();
        int min = lk.peek(), temp;
        while(it.hasNext()) {
        	temp = it.next();
        	if(temp < min)
        		min = temp;
        }
        return min;
    }
    
    public static void main(String[] args) {
    	MinStack ms = new MinStack();
    	ms.push(1);
    	System.out.println(ms.top());
    	ms.push(2);
    	ms.push(0);
    	System.out.println(ms.getMin());
    	ms.pop();
    	System.out.println(ms.top());
    	
    }
}
