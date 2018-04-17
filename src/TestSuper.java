
public class TestSuper {

	public static void main(String[] args) {
		Son s = new Son();
		System.out.println(s.value);
	}

}

class Father {
	int value = 10;
	Father() {
		System.out.println("father is here...");
	}
	Father(int i) {
		System.out.println("another father is here...");
		value += i;
	}
}

class Son extends Father {
	Son() {
		super(23);
		System.out.println(value + " " + super.value);
		value ++;
		System.out.println("i am the son...");
	}
}