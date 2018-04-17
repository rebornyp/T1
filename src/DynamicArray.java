import java.util.Scanner;

public class DynamicArray {
	int len;
	LinkList l;
	public DynamicArray() {
		len = 0;
		l = new LinkList();
	}
	void add(double temp) {
		len ++;
		l.insertRear(temp);
	}
	double delete() {
		len--;
		double temp = l.deleteRear();
		return temp;
	}
	void printDynamicArray() {
		l.show();
	}
	public static void main(String[] args) {
		DynamicArray d = new DynamicArray();
		double temp;
		Scanner s = new Scanner(System.in);
		while(true) {
			try {
				temp = s.nextDouble();
			} catch(java.util.InputMismatchException e) {
				break;
			} 
			d.add(temp);
		}
		s.close();
		d.printDynamicArray();
	}

}

class Node {
	double data;
	Node link;
}

class LinkList {
	Node header;
	
	public void insertFront(double temp) {
		if(isEmpty()) {
			
			Node n = new Node();
			n.data = temp;
			header = n;
		} else {
			Node n = new Node();
			n.data = temp;
			n.link = header;
			header = n;
		}		
	}
	
	public void insertRear(double temp) {
		if(isEmpty()) {
			Node n = new Node();
			n.data = temp;
			header = n;
		} else {
			Node n = new Node();
			n.data = temp;
			Node tempNode = new Node();
			tempNode = header;
			while(tempNode.link != null) {
				tempNode = tempNode.link;
			}
			tempNode.link = n;
		}
	}
	
	boolean isEmpty() {
		if(header == null)
			return true;
		else
			return false;
	}
	double deleteHeader() {
		double temp = header.data;
		header = header.link;
		return temp;
	}
	double deleteRear() {
		int i = 0, k = getLength();
		Node temp = header;
		while(i < k) {
			temp = temp.link;
			i++;
		}
		double t = temp.data;
		temp.link = null;
		return t;
	}
	int getLength() {
		int i = 0;
		if(header == null)
			return i;
		else {
			Node temp = header;
			while(temp != null) {
				temp = temp.link;
				i++;
			}
			return i;
		}
	}
	void show() {
		Node temp = header;
		System.out.println("Print this linklist below");
		while(temp != null) {
			System.out.print(temp.data + "  ");
			temp = temp.link;
		}
	}
}
