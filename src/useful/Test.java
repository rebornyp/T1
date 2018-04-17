package useful;

import java.util.Arrays;
import java.util.Random;

public class Test {

	final Value v = new Value(9);
	
	public static void main(String[] args) {
		while(true) {
			
		}
		
	}
	
	private static String byteToHexString(byte b) {
		// TODO Auto-generated method stub
		String s = "0X";
		s += b  / 16;
		int t = b % 16;
		if(t > 9)
			s += (char)(t + 55);
		else
			s += t;
		
		return s;
	}

	static void p(Object o) {
		System.out.println(o);
	}

}

interface U {
	int uid = 9;
	String str = "sd";
	public String getName();
}

class Value implements U {
	int value;
	String id = "superId";
	Value(int i) {
		value = i;
		id = "null";
		System.out.println("sdasdasdasdad" + i);
	}
	Value() {
		//id = "null";
	}
	
	static void p() {
		//System.out.println("sdasdasdasdad");
	}
	
	private final void f() {
		Test.p("first-f()");
	}
	
	public void g() {
		Test.p("first-g()");
	}
	
	static void d() {
		Test.p("static-super");
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class OverValue implements U{
	static int num = 123;
	String id = "subId";
	static Value vfg = new Value(23);
	
	OverValue() {
		vfg = new Value(1212);
	}
	
	public final void f() {
		Test.p("Second-f()");
	}

	public void g() {
		Test.p("Second-g()");
//		super.f(); 
	}
	
	static void d() {
		Test.p("static-sub");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}

class one {
	static String swim() {
		return null;
	}
}

class two extends one{
	static String swim() {
		return "2";
	}
	
	
}



