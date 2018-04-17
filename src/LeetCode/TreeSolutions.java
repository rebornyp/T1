package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TreeSolutions {

	public static void main(String[] args) {
		String s = "cars";
		List<String> list = new ArrayList<String>();
		String[] str = {"car","ca","r","bbbb"};
		if(str.length < 31)
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		for(String temp : str)
			list.add(temp);
		System.out.println(wordBreak(s, list));
	}

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode p = head, temp;
        while(p != null) {
        	RandomListNode tp = new RandomListNode(p.label);
        	tp.next = p.next;
        	p.next = tp;
        	p = tp.next;
        }
        p = head;
        while(p != null) {
        	if(p.random != null)
        		p.next.random = p.random.next;
        	p = p.next.next;
        }
        head = head.next;
        p = head;
        while(p.next != null) {
        	temp = p.next;
        	p.next = temp.next;
        	p = p.next;
        }
    	return head;
    }
	
    public static boolean wordBreak(String s, List<String> dict) {
        if(dict == null) return false;
        if(s.length() == 0 && dict.size() == 0) return true;
        for(String str : dict)
        	if(s.indexOf(str) == 0)
        		if(s.equals(str) ? true : wordBreak(s.substring(str.length()), dict)) return true;
        
    	return false;
    }
	
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode p = head, q = head, r;
        while(q.next != null && q.next.next != null) {
        	p = p.next;
        	q = q.next.next;
        }
        ListNode temp = p;
        p = p.next;
        q = null;
        while(p != null) {
        	r = q;
        	q = p;
        	p = p.next;
        	q.next = r;
        }
        temp.next = null;
        p = head;
        ListNode.show(head);
        ListNode.show(q);
        while(q != null) {
        	r = p.next;
        	p.next = q;
        	q = q.next;
        	p.next.next = r;
        	p = r;
        }
    }
	
    public static ListNode insertionSortList(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode pre = head, last = head, q = head.next, p = null;
    	last.next = null;
    	while(q != null) {
    		if(q.val < head.val) {
    			p = q.next;
    			q.next = head;
    			head = q;
    			q = p;
    		} else {
    			last = head;
    			while(last.next != null && last.next.val < q.val) last = last.next;
    			p = last.next;
    			last.next = q;
    			pre = q.next;
    			q.next = p;
    			q = pre;
    		}
    	}
    	return head;
    }
	
    public static ListNode sortList(ListNode head) {
    	//判断是否为空或只有一个元素
    	if(head == null || head.next == null) return head;
    	//pre的所有比head大的前部分链表首个元素，一开始pre是head，发现一个比head小，就链到pre前面，并更新pre
    	//last是所有比head大的元素的链表末尾元素，因为是从后面插入，所以last得时时往后挪位置
    	ListNode pre = head, last = head, q = head.next, p = null;
    	//先切断链表，前pre，后last
    	last.next = null;
    	while(q != null) {
    		if(q.val < head.val) {
    			p = q.next; //先保存q下一个结点
    			q.next = pre; //把q链到前面pre去
    			pre = q; //更新pre
    			q = p; //继续把q放到原链表的遍历路径上去
    		} else {
    			last.next = q; //只要该元素比head大，就接到last后去
    			last = last.next; //把last往后挪一个位置
    			q = q.next; //q也往后挪一个位置，好比较后面元素
    			last.next = null; //同时继续切断last和还未比较元素之间的关系，
    			//防止如果下一个元素比head小，按照前面的代码会出现环
    		}
    	}
    	//此刻之后，head前面的都比head小，head后面的都比head大
    	last = head.next; //然后把head(即快排里面的比较元素的下一个元素)取出，好递归进行排序
    	head.next = null; //同时切断整个链表为两份
    	pre = sortList(pre); //对前面部分进行快排， 下同
    	last = sortList(last);
    	head.next = last; //因为head是肯定还在中间的(细想可知)，所以这里直接继续从中间接上即可。
    	return pre; //返回头节点
    }
	
	public static int evalRPN(String[] tokens) {
    	if(tokens == null || tokens.length == 0) return 0;
    	Deque<Integer> lk = new LinkedList<Integer>(); 
        for(String s : tokens) {
        	if(s.matches("[+-]")) {
        		int a = lk.pop(), b = lk.pop();
        		if(s.matches("\\+")) a = b + a;
        		else a = b - a;
        		lk.push(a);
        	} else if(s.matches("[/*]")) {
        		int a = lk.pop(), b = lk.pop();
        		if(s.matches("/")) a = b / a;
        		else a = a * b;
        		lk.push(a);
        	} else
        		lk.push(Integer.valueOf(s));
        }
//        System.out.println(lk);
//        System.out.println(lc);
        
    	return lk.pop();
    }
	
    public int minimumTotal(List<List<Integer>> tr) {
        if(tr == null) return 0;
        int[] arr = new int[tr.size()];
        arr[0] = tr.get(0).get(0);
        for(int i=1; i<tr.size(); i++) {
        	
        	for(int j=0; j<tr.get(i).size(); j++) {
        		int temp = tr.get(i).get(j);
        		if(j == 0)
        			temp += arr[j];
        		else if(j == tr.get(i).size()-1)
        			temp += arr[j-1];
        		else
        			temp += Math.min(arr[j], arr[j-1]);
        		tr.get(i).set(j, temp);
        	}
        	for(int j=0; j<tr.get(i).size(); j++)
        		arr[j] = tr.get(i).get(j);
        }
        int total = tr.get(tr.size()-1).get(0);
        for(int i=1; i<tr.get(tr.size()-1).size(); i++)
        	if(tr.get(tr.size()-1).get(i) < total)
        		total = tr.get(tr.size()-1).get(i);
        return total;
    }
	
    public static List<Integer> getRow(int rowIndex) {
    	List<Integer> temp = new ArrayList<Integer>();
        if(rowIndex < 0) return temp;
        return generate(rowIndex).get(rowIndex);
    }
	
    public static List<List<Integer>> generate(int num) {
    	num ++;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(num < 1) return list;
    	List<Integer> basic = new ArrayList<Integer>();
    	basic.add(1);
    	list.add(new ArrayList<Integer>(basic));
    	if(num == 1) return list;
    	basic.add(1);
    	list.add(new ArrayList<Integer>(basic));
    	if(num == 2) return list;
    	for(int i=3; i<=num; i++) {
    		List<Integer> pointer = list.get(list.size()-1);
    		basic.clear();
    		basic.add(1);
    		for(int j=0; j<pointer.size()-1; j++)
    			basic.add(pointer.get(j) + pointer.get(j+1));
    		basic.add(1);
    		list.add(new ArrayList<Integer>(basic));
    	}
        return list;
    }
	
	public void connect(TreeLinkNode root) {
        if(root == null) return;
        int cur = 0, last = 1;
        TreeLinkNode temp = null;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        while(!q.isEmpty()) {
        	TreeLinkNode t = q.poll();
        	last --;
        	if(temp != null)
        		temp.next = t;
        	temp = t;
        	if(t.left != null) {
        		cur ++;
        		q.add(t.left);
        	}
        	if(t.right != null) {
        		cur ++;
        		q.add(t.right);
        	}
        	if(last == 0) {
        		last = cur;
        		cur = 0;
        		temp = null;
        		t.next = temp;
        	}
        }
    }
	
    public static void flatten(TreeNode root) {
        if(root == null)
        	return;
        flatten(root.left);
        System.out.println(root.val);
        flatten(root.right);
        
    }
	
  
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null)
        	return list;
        pathSumHelper(root, sum, 0, list, new ArrayList<Integer>());
        return list;
    }
	
    
    private static void pathSumHelper(TreeNode root, int sum, int val, List<List<Integer>> list, ArrayList<Integer> arr) {
    	if(root.left == null && root.right == null) {
//    		System.out.println(list + "-" + sum + "-" + val + "-" + root.val);
    		val = val + root.val;
    		if(val == sum) {
    			arr.add(root.val);
    			list.add(new ArrayList<Integer>(arr));
    			arr.remove(arr.size()-1);
    		}
			return;
		}
    	arr.add(root.val);
		if(root.left != null) {
			pathSumHelper(root.left, sum, val+root.val, list, arr);
		}
		System.out.println(list);
		if(root.right != null)
			pathSumHelper(root.right, sum, val+root.val, list, arr);
		arr.remove(arr.size()-1);
	}

	
    public static int minDepth(TreeNode root) {
        if(root == null)
        	return 0;
    	return countMinDepth(root, -1, 1);
    }

	
    private static int countMinDepth(TreeNode root, int md, int cur) {
		if(root.left == null && root.right == null) {
			if(md == -1)
				md = cur;
			else if(md > cur)
				md = cur;
			return md;
		}
		int l = md, r = md;
		if(root.left != null)
			l = countMinDepth(root.left, md, cur+1);
		if(root.right != null)
			r = countMinDepth(root.right, md, cur+1);
		return Math.min(l, r) == -1 ? Math.max(l,  r) : Math.min(l, r);
	}

    
    
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
    	return helper(root, sum, 0);
    }

	
    private static boolean helper(TreeNode root, int sum, int val) {
		if(root.left == null && root.right == null) {
			if(root.val + val == sum)
				return true;
			return false;
		}
		boolean l = false, r = false;
		if(root.left != null)
			l = helper(root.left, sum, val+root.val);
		if(root.right != null)
			r = helper(root.right, sum, val+root.val);
		
		return l || r;
	}
	
}
