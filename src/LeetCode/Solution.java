package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		int[] arr = {5,4,6,3,2,1,7,8,9,10};
		TreeNode root = create(arr);
		show(root);
		System.out.println();
		System.out.println(isBalanced(root));
		int i = 9;
		System.out.println(i);
	}
	
    public static boolean isBalanced(TreeNode root) {
        if(root == null)
        	return true;
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1)
        	return false;
        else
        	return isBalanced(root.left) && isBalanced(root.right);
    }

	private static TreeNode sortedArrayToBST(ListNode head) {
		if(head == null) return null;
		ListNode temp = head;
		List<Integer> list = new ArrayList<Integer>();
		while(temp != null) {
			list.add(temp.val);
			temp = temp.next;
		}
		int[] arr = list.stream().mapToInt(i->i).toArray();
		System.out.println(Arrays.toString(arr));
		return sortedArrayToBST(arr);
	}

	static void show(TreeNode root) {
		if(root == null)
			return;
		show(root.left);
		System.out.print(root.val + "-");
		show(root.right);
	}

	static TreeNode create(int[] arr) {
		TreeNode root = null;
		for(int i=0; i<arr.length; i++)
			root = add(root, arr[i]);
		return root;
	}

	/**
	 * 二叉排序树的插入节点
	 * @param root
	 * @param i
	 */
	static TreeNode add(TreeNode root, int i) {
		if(root == null)
			return new TreeNode(i);
		TreeNode x, y;
		x = root;
		y = root;
		while(x != null) {
			y = x;
			if(i < x.val)
				x = x.left;
			else
				x = x.right;
		}
		if(i < y.val)
			y.left = new TreeNode(i);
		else
			y.right = new TreeNode(i);
		return root;
	}

	private static boolean helper(List<Integer> list, TreeNode header) {
		
		if(header == null)
			return true;
		boolean left, right;
		left = helper(list, header.left);
		if(list.get(list.size()-1) != null && list.get(list.size()-1) >= header.val)
			return false;
		list.add(header.val);
		right = helper(list, header.right);
		return left && right;
		
	}
	
    private ArrayList<TreeNode> helper(int left, int right)  
    {  
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();  
        if(left>right)  
        {  
            res.add(null);  
            return res;  
        }  
        for(int i=left;i<=right;i++)  
        {  
            ArrayList<TreeNode> leftList = helper(left,i-1);  
            ArrayList<TreeNode> rightList = helper(i+1,right);  
            for(int j=0;j<leftList.size();j++)  
            {  
                for(int k=0;k<rightList.size();k++)  
                {  
                    TreeNode root = new TreeNode(i);  
                    root.left = leftList.get(j);  
                    root.right = rightList.get(k);  
                    res.add(root);  
                }  
            }  
        }  
        return res;  
    } 

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
    	return symHelper(root.left, root.right);
    }

	private static boolean symHelper(TreeNode left, TreeNode right) {
		if(left == null || right == null)
			return (left == null && right == null) ? true : false;
		if(left.val != right.val)
			return false;
		boolean l = symHelper(left.left, right.right), r = symHelper(left.right, right.left);
		return l && r;
	}
	
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> temp = new ArrayList<Integer>();
        int curNum = 0, lastNum = 1;
        q.add(root);
        while(!q.isEmpty()) {
        	TreeNode t = q.poll();
        	lastNum --;
        	temp.add(t.val);
        	if(t.left != null) {
        		curNum ++;
        		q.add(t.left);
        	}
        	
        	if(t.right != null) {
        		curNum ++;
        		q.add(t.right);
        	}
        	
        	if(lastNum == 0) {
        		lastNum = curNum;
        		curNum = 0;
        		list.add(temp);
        		temp = new ArrayList<Integer>();
        	}
        }
    	return list;
    }
	
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> temp = new ArrayList<Integer>();
        int curNum = 0, lastNum = 1, level = 0;
        q.add(root);
        while(!q.isEmpty()) {
        	TreeNode t = q.poll();
        	lastNum --;
        	temp.add(t.val);
    		if(t.left != null) {
        		curNum ++;
        		q.add(t.left);
        	}
        	
        	if(t.right != null) {
        		curNum ++;
        		q.add(t.right);
        	}
        	if(lastNum == 0) {
        		lastNum = curNum;
        		curNum = 0;
        		if(level % 2 == 1)
        			Collections.reverse(temp);
        		list.add(temp);
        		temp = new ArrayList<Integer>();
        		level ++;
        	}
        }
        return list;
    }

    public static int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(postorder == null || inorder == null)
    		return null;
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i=0; i<inorder.length; i++)
    		map.put(inorder[i], i);
    	return builderHelper(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map);
    }

	private static TreeNode builderHelper(int[] postorder, int i, int j, int[] inorder, int k, int l,
			Map<Integer, Integer> map) {
		if(i > j)
			return null;
		TreeNode root = new TreeNode(postorder[j]);
		int mid = map.get(postorder[j]);
		root.left = builderHelper(postorder, i, i+mid-k-1, inorder, k, mid-1, map);
		root.right = builderHelper(postorder, i+mid-k, j-1, inorder, mid+1, l, map);
		return root;
	}
	
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
        	return null;
        return helperSortedTree(0, nums.length-1, nums);
    }

	private static TreeNode helperSortedTree(int i, int j, int[] nums) {
		if(i > j)
			return null;
		if(i == j)
			return new TreeNode(nums[i]);
		int mid = (i + j) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helperSortedTree(i, mid-1, nums);
		root.right = helperSortedTree(mid+1, j, nums);
		return root;
	}
}
