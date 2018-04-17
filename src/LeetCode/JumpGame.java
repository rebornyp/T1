package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class JumpGame {

	public static void main(String[] args) {
		
		
	}
    
    public static List<Interval> merge(List<Interval> list) {
    	if(list.size() <= 1)
    		return list;
    	Comp[] arr = new Comp[list.size()];
    	for(int i=0; i<arr.length; i++)
    		arr[i] = new Comp(list.get(i).start, i);
    	QuickSort(arr, 0, arr.length-1);
    	System.out.println(Arrays.toString(arr));
    	List<Interval> newlist = new LinkedList<Interval>();
    	for(int i=0; i<arr.length; i++)
    		newlist.add(list.get(arr[i].pre));
    	System.out.println(newlist);
    	int i = 0;
    	while(i + 1 < newlist.size()) {
    		if(newlist.get(i).end >= newlist.get(i+1).end) {
    			newlist.remove(i+1);
    			
    		} else if(newlist.get(i).end >= newlist.get(i+1).start) {
    			Interval temp = new Interval(newlist.get(i).start, newlist.get(i+1).end);
    			newlist.add(i+2, temp);
    			newlist.remove(i);
    			newlist.remove(i);
    			
    		} else {
    			i ++;
    			
    		}
    	}
    	return newlist;
    }

	private static void QuickSort(Comp[] arr, int start, int end) {
		if(start >= end)
			return;
		int val = arr[end].val, temp;
		int i = start - 1;
		for(int j=start; j<end; j++) {
			if(arr[j].val < val) {
				i ++;
				if(i != j) {
					arr[i].last = j;
					arr[j].last = i;
					Comp t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}
			}
		}
		if(i + 1 != end) {
			arr[i+1].last = end;
			arr[end].last = i+1;
			Comp t = arr[i+1];
			arr[i+1] = arr[end];
			arr[end] = t;
		}
		QuickSort(arr, start, i);
		QuickSort(arr, i+2, end);
	}    
}

class Comp {
	int val, pre, last;
	Comp(int val, int pre) {
		this.val = val;
		this.pre = pre;
	}
	
/*	public String toString() {
		return "初始位置：" + pre + "，数值：" + val + "，结束位置" + last;
	}*/
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    public String toString() {
    	return "(" + start + "~" + end + ")";
    }
}