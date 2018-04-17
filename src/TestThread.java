
public class TestThread {

	public static void main(String[] args) {
		T t = new T();
//		Thread th = new Thread(t);
//		th.start();
		t.run();
		for(int i=0; i<100; i++) {
			System.out.println(i);
		}
	}

}

//class T implements Runnable{
class T extends Thread {

	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("----" + i);
		}
	}
	
}
