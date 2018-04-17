package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {

    public static void main(String[] args) {
/*    	int[] nums = {1,0 , -1, 2, 12, -2, -4};
    	ListNode head = new ListNode(-1), r = head;
    	for(int i=0; i<nums.length; i++) {
    		ListNode p = new ListNode(nums[i]);
    		r.next = p;
    		r = r.next;
    	}
    	show(partition(head.next, 1));*/
    	
    	int num = 4;
    	System.out.println(grayCode(num));
    	
    }

    private static void show(ListNode next) {
		// TODO Auto-generated method stub
		ListNode p = next;
		while(p != null) {
			System.out.print(p.val + "  ");
			p = p.next;
		}
	}
    
    public static List<Integer> grayCode(int n) {
    	List<Integer> list = new ArrayList<Integer>();
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<n; i++)
    		sb.append('0');
        String s2 = sb.toString();
        Set<String> set = new HashSet<String>();
        int k = 0, total = 1;
        while(k < n) {
        	total = total << 1;
        	k ++;
        }
        System.out.println(total);
        while(set.size() < total) {
        	set.add(s2);
			list.add(change(s2));
        	for(int i=s2.length()-1; i>=0; i --) {
        		StringBuilder temp = new StringBuilder(s2);
        		if(s2.charAt(i) == '1' && !set.contains(temp.replace(i, i+1, "0").toString())) {
    				s2 = temp.toString();
        			break;
        		} else if(s2.charAt(i) == '0' && !set.contains(temp.replace(i, i+1, "1").toString())){
        			s2 = temp.toString();
        			break;
        		}
        	}
        }
    	return list;
    }

	private static int change(String s) {
		int r = 0;
		for(int i=0; i<s.length(); i++) {
			r = r << 1;
			if(s.charAt(i) == '1')
				r += 1;
		}
		return r;
	}
    
}
