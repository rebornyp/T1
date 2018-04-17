
public class TestThread1 extends Thread {
	static int i = 0;
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
	
	static void m1() {
		System.out.println("m1 method is running....");
		i++;
		System.out.println(i);
	}
	
	public void run() {
		try {
			sleep(10000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("---" + i);
	}
	
	public static void main(String args[]) {
		TestThread1 t = new TestThread1();
		t.start();
		System.out.println("we are in this main loop  " + i);
		m1();
		System.out.println("last printout   " + i);
	}

}
