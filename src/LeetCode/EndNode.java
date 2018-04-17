package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EndNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode header = new ListNode(23);
		int k = 0;
		Random r = new Random();
		while(k < 10) {
			ListNode n = new ListNode(r.nextInt(50));
			n.next = header;
			header = n;
			k ++;
		}
		ListNode p = header;
		while(p != null) {
			System.out.print("~" + p.val);
			p = p.next;
		}
		p("---");
		p = removeNthFromEnd(header, -1);
		while(p != null) {
			System.out.print("~" + p.val);
			p = p.next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null)
			return null;
		List<ListNode> arr = new ArrayList<ListNode>();
		ListNode p = head;
		int num = 0;
		while(p != null) {
			arr.add(p);
			num ++;
			p = p.next;
		}
		if(n > 0 && n <= num) {
			if(n == num)
				head = head.next;
			else
				arr.get(num-n-1).next = arr.get(num-n).next;
		}
		return head;
	}
	
	private static void p(Object o) {
		System.out.println(o);
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int value) {
		this.val = value;
	}

	public String toString() {
		return String.valueOf(val);
	}
	
	static ListNode createList(int[] arr) {
		int k = 0;
		ListNode header = null;
		while(k < arr.length) {
			ListNode n = new ListNode(arr[k]);
			n.next = header;
			header = n;
			k ++;
		}
		return header;
	}
	
	static ListNode createList(int num) {
		ListNode header = null;
		int k = 0;
		Random r = new Random();
		int[] arr = new int[num];
		for(int i=0; i<arr.length; i++)
			arr[i] = r.nextInt(50);
		Arrays.sort(arr);
		while(k < arr.length) {
			ListNode n = new ListNode(arr[k]);
			n.next = header;
			header = n;
			k ++;
		}
		return header;
	}
	
	static void show(ListNode header) {
		ListNode p = header;
		while(p != null) {
			System.out.print("~" + p.val);
			p = p.next;
		}
		System.out.println();
	}
	
	static ListNode reverse(ListNode header) {
		ListNode p, q, r;
		p = header;
		q = null;
		while(p != null) {
			r = q;
			q = p;
			p = p.next;
			q.next = r;
		}
		header = q;
		return header;
	}
	
}