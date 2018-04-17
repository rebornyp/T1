package LeetCode;

import java.util.LinkedList;

public class MergeSortedNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = ListNode.createList(4);
		l1 = ListNode.reverse(l1);
		ListNode.show(l1);
		ListNode p = changeK(l1, 4);
		ListNode.show(p);
		
	}
	
	
	
	private static ListNode changeK(ListNode l1, int k) {
		int flag = 0, i, j = 0, num = 0;
		ListNode temp = l1;
		while(temp != null) {
			num ++;
			temp = temp.next;
		}
		num = num / k;
		if(num == 0)
			return l1;
		ListNode p = l1, q = p, r, head = null, head1 = null;
		while(j < num) {
			flag ++;
			i = 0;
			q = null;
			while(i < k) {
				r = q;
				q = p;
				if(i == 0)
					head = q;
				p = p.next;
				q.next = r;
				i ++;
			}
			head.next = p;
			if(flag == 1) {
				l1 = q;
				head1 = head;
			}
			head1.next = q;
			head1 = head;
			j ++;
		}
		head1.next = p;
		return l1;
	}



	//逆转相邻两个的链表
	private static ListNode change(ListNode l1) {
		if(l1 == null || l1.next == null)
			return l1;
		ListNode p = l1, temp = l1.next;
		l1.next = temp.next;
		temp.next = l1;
		l1 = temp;
		temp = p.next;
		
		while(temp != null && temp.next != null) {
			p.next = temp.next;
			p = p.next;
			temp.next = p.next;
			p.next = temp;
			temp = temp.next;
			p = p.next;
		}
		p.next = temp;
		return l1;
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0)
			return null;
		if(lists.length == 1)
			return lists[0];
		return merge(lists, 0, lists.length-1);
    }
	
	private static ListNode merge(ListNode[] lists, int i, int j) {
		if(i == j)
			return lists[i];
		int middle = (i + j) / 2;
		ListNode l1 = merge(lists, i, middle);
		ListNode l2 = merge(lists, middle + 1, j);
		return mergeTwoLists(l1, l2);
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode fakeHead = new ListNode(-1);
		ListNode l3 = fakeHead;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				l3.next = l1;
				l3 = l3.next;
				l1 = l1.next;
			}
			else {
				l3.next = l2;
				l3 = l3.next;
				l2 = l2.next;
			}
		}
		if(l1 == null)
			l3.next = l2;
		else
			l3.next = l1;
		return fakeHead.next; 
    }

}
