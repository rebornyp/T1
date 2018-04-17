package com;

import java.util.Date;

public class TestThread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
/*		for(int i=0; i<10; i++) {
			p(i);
		}
		Runner1 r = new Runner1();
		Thread th = new Thread(r);
		th.start();
		for(int i=0; i<100; i++) {
			p(i);
		}*/
		
		MyThread my = new MyThread();
		my.start();
		Thread.sleep(10000);
//		my.flag = false;
		my.interrupt();
	}
	
	static void p(Object o) {
		System.out.println(o);
	}
	
	
}

class MyThread extends Thread {
	boolean flag = true;
	public void run() {
		while(flag) {
			p("当前时间是：" + new Date());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				p("ok, we have done this job");
				return;
			}
		}
		
	}
	
	static void p(Object o) {
		System.out.println(o);
	}
}

class Runner1 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<100; i++) {
			p("---------" + i);
		}
	}
	
	static void p(Object o) {
		System.out.println(o);
	}
	
}