package com;

public class Source {

	static int i = 0;
	
	public Source() {
		System.out.println(i);
		this.i = 9;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest t = new ThreadTest("gastby");
		System.out.println("hello,i want go die");
		try {
			Thread.sleep(5555);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t.start();
//		t.run();
//		p(cont(i));
		System.out.println("hello,i want go die");
		
	}

	static void p(Object o) {
		System.out.println(o.toString());
	}
	
	private static int cont(int i2) {
		// TODO Auto-generated method stub
		return i2+1;
	}

}

class ThreadTest implements Runnable{

	private Thread th;
	private String threadName;
	
	ThreadTest(String name) {
		threadName = name;
		System.out.println("creating a thread");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("running a thread");
		try {
		for(int i = 4; i > 0; i--) {
		   System.out.println("Thread: " + threadName + ", " + i);
		// 让线程睡眠一会
		      Thread.sleep(50);
		   }
		} catch(InterruptedException e) {
			System.out.println("Thread " +  threadName + " interrupted.");
		}
		System.out.println("Thread " +  threadName + " exiting.");
	}
	
	public void start () {
       System.out.println("Starting " +  threadName );
       if (th == null) {
//          th = new Thread (this, threadName);
          th = new Thread (this, threadName);
          th.start ();
       }
    }
	
}