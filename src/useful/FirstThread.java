package useful;

public class FirstThread extends Thread{

	private int i;
	
	@Override
	public void run() {
		for(; i<10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		for(int j=0; j<30; j++) {
			System.out.println(Thread.currentThread().getName() + " " + j);
			if(j == 20) {
				Thread t = new FirstThread();
				t.start();
				Thread.sleep(1);
//				new FirstThread().start();
			}
		}
	}

	
}
