package useful;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyContainer<T> {

	private final int max = 10;
	private final List<T> list = new ArrayList<>();
	Lock lock = new ReentrantLock();
	private Condition producer = lock.newCondition();
	private Condition consumer = lock.newCondition();
	
	void put(T t) {
		try {
			lock.lock();
			while (list.size() == max) {
				producer.await();
			}
			list.add(t);
			consumer.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	synchronized T get() {
		T t = null;
		try {
			lock.lock();
			while (list.size() == 0) {
				consumer.await();
			}
			t = list.get(list.size()-1);
			producer.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return t;
	}
	
	public static void main(String[] args) {
		MyContainer<String> m = new MyContainer<>();
		
		for (int i=0; i<10; i++) {
			new Thread(() -> {
				for (int j=0; j<5; j++) System.out.println(Thread.currentThread().getName() + " consumed " + m.get());
			}, "c" + i).start();;
		}
		
		for (int i=0; i<10; i++) {
			new Thread(() -> {
				for (int j=0; j<5; j++) {
					m.put(Thread.currentThread().getName() + ":" + j);
				}
			}, "p" + i).start();;
		}
	}
	
}
