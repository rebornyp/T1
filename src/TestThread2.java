import java.time.chrono.HijrahChronology;
import java.util.*;
public class TestThread2 {

	public static void main(String[] args) {
		T2 t = new T2();
		Thread x = new Thread(t);
		x.start();
		System.out.println(Integer.MAX_VALUE);
		System.out.println((long)(Math.pow(2, 32)));
		System.out.println(Long.MAX_VALUE);
	}
}

class T2 implements Runnable {
	public void run() {
//		System.out.println("现在日期是" + new Date(2016, 1, 25) + "...");
//		Date s = new Date();
//		HijrahChronology Hc = new HijrahChronology();
//		System.out.println("现在日期是" + new Date() + "...");
	}
}