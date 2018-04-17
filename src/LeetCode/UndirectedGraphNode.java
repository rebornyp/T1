package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class UndirectedGraphNode {

	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
	
	public static void main(String[] args) {
		String s = "kabau";
		System.out.println(longestPalindrome(s));
	}

	public static String longestPalindrome(String s) {  
	    if(s == null || s.length()==0)  
	        return "";  
	    int maxLen = 0;  
	    String res = "";  
	    for(int i=0;i<2*s.length()-1;i++)  
	    {  
	        int left = i/2;  
	        int right = i/2;  
	        if(i%2==1)  
	            right++;  
	        String str = lengthOfPalindrome(s,left,right);  
	        System.out.println(left + "-" + right + str);
	        if(maxLen<str.length())  
	        {  
	            maxLen = str.length();  
	            res = str;  
	        }  
	    }  
	    return res;  
	}  
	private static String lengthOfPalindrome(String s, int left, int right)  
	{  
	      
	    while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))  
	    {  
	        left--;  
	        right++;  
	    }  
	    return s.substring(left+1,right);  
	} 
	
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null) return node;
    	Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    	Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    	map.put(node, new UndirectedGraphNode(node.label));
    	queue.offer(node);
    	while(!queue.isEmpty()) {
    		UndirectedGraphNode temp = queue.poll();
    		for(int i=0; i<temp.neighbors.size(); i++) {
    			UndirectedGraphNode cur = temp.neighbors.get(i);
    			if(!map.containsKey(cur)) {
    				map.put(cur, new UndirectedGraphNode(cur.label));
    				queue.offer(cur);
    			}
    			map.get(temp).neighbors.add(map.get(cur));
    		}
    	}
    	
    	return map.get(node);
    }
    
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        String head = "";
        head += root.val;
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        helper(root, head, list);
        return list.get(0);
    }

	private void helper(TreeNode root, String head, List<Integer> list) {
		if(root == null) return;
		head += root.val;
		if(root.left == null && root.right == null)
			list.set(0, list.get(0) + Integer.valueOf(head));
		helper(root.left, head, list);
		helper(root.right, head, list);
	}
    
    
}
