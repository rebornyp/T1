package com;

import java.util.ArrayList;
import java.util.Random;

public class TestAddTwoNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List l1 = new List(10);
/*		l1.reverse();
		System.out.println();*/
		
		l1.showList();
		System.out.println();
		List l2 = new List(10);
		l2.showList();
		
		Node c1 = l1.header;
		Node c2 = l2.header;
		Node h = null;
		while(!((c1 == null) || (c2 == null))) {
			int num = c1.val + c2.val;
			Node temp = new Node(num);
			temp.link = h;
			h = temp;
			
			c1 = c1.link;
			c2 = c2.link;
		}
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		
		Node t = h;
		p("\n");
		while(t != null) {
			p(t + "-");
			t = t.link;
		}
		
	}

	static void p(Object o) {
		System.out.print(o);
	}

}

class Node {
	int val;
	Node link;
	Node(int val) {
		this.val = val;
	}
	
	public String toString() {
		return String.valueOf(val);
	}
}

class List {
	Node header;
	List(int[] arr) {
		header = null;
		if(arr == null)
			return;
		for(int i=arr.length-1; i>=0; i--) {
			Node temp = new Node(arr[i]);
			temp.link = header;
			header = temp;
		}
	}
	
	List() {
		header = null;
		Random r = new Random();
		int num = r.nextInt(20);
		int[] arr = new int[num];
		for(int i=0; i<num; i++)
			arr[i] = r.nextInt(10);
		for(int i=arr.length-1; i>=0; i--) {
			Node temp = new Node(arr[i]);
			temp.link = header;
			header = temp;
		}
	}
	
	List(int num) {
		header = null;
		Random r = new Random();
		int[] arr = new int[num];
		for(int i=0; i<num; i++)
			arr[i] = r.nextInt(10);
		for(int i=arr.length-1; i>=0; i--) {
			Node temp = new Node(arr[i]);
			temp.link = header;
			header = temp;
		}
	}
	
	
	void showList() {
		Node temp = header;
		while(temp != null) {
			p(temp.val);
			temp = temp.link;
		}
	}
	
	static void p(Object o) {
		System.out.print("-" + o);
	}
	
	void reverse() {
		Node p, q, r;
		p = header;
		q = null;
		while(p != null) {
			r = q;
			q = p;
			p = p.link;
			q.link = r;
		}
		header = q;
	}
}
