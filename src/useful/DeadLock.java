package useful;

public class DeadLock {
	
	public static void main(String[] args) {
		A a = new A();
		B1 b1 = new B1(a);
		B2 b2 = new B2(a);
		b1.start();
		b2.start();
	}

}


class A {
	
	boolean flag = false;
	
	public synchronized void num() throws Exception {
		for(int i=1; i<53; i=i+2){
			
			if(flag) {
				wait();
			} 
				System.out.print("-"+i + "-" + (i+1)+"-");
				flag = true;	
				notify();
			
		}
	}

	public synchronized void cha() throws Exception {
		for(int i=1; i<27; i++) {
			if(!flag) {
				wait();
			} 
			System.out.print((char)(i + 64));
			flag = false;
			notify();
		}
	}
	
}

class B1 extends Thread {
	
	@Override
	public void run() {
		try {
			a.num();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private A a = new A();
	public B1(A a) {
		this.a = a;
	}
}

class B2 extends Thread {
	public void run() {
		try {
			a.cha();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private A a = new A();
	public B2(A a) {
		this.a = a;
	}
}