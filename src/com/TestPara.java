package com;

import java.util.Random;

public class TestPara {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Run r = new Run();
		Thread th1 = new Thread(r);
		th1.start();
		
		Random rd = new Random();
		
		
	}

	static void p(Object o) {
		System.out.println(o);
	}
	
}

class Run implements Runnable {

	boolean flag = true;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag) {
			
		}
	}
	
}