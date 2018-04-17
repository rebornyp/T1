package com;
public class Cat {
	int id;
	static int sid = 0;
	String name;
	
	public Cat() {
		id = sid++;
		name = "pupu";
	}
	
	public Cat(String s) {
		id = sid++;
		name = s;
	}
	
	void print() {
		System.out.println("这是第" + sid + "条猫");
		System.out.println(Math.PI);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat.sid = 56;
		Cat a  = new Cat("mimi");
		a.print();
		for(int i = 0;i < 56;i++) {
			Cat sb = new Cat();
			sb.print();
		}
	}

}
