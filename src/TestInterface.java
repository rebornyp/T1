
interface Dancer {
	int id = 56;
	public void dance();
	public void eat();
}

interface Singer {
	void sing();
	void eat();
}

interface Performer extends Singer {
	void perform();
}

class Student implements Singer, Performer{
	String name;
	public Student(String name) {
		this.name = name;
	}
	public void study() {
		System.out.println(name + " student is studying");
	}
	public void sing() {
		System.out.println(name + " student is singing");
	}
	public void eat() {
		System.out.println(name + " student is eating");
	}
	public void perform() {
		System.out.println(name + " student is performing");
	}
}

class Teacher implements Singer, Dancer {
	String name;
	public Teacher(String name) {
		this.name = name;
	}
	public void study() {
		System.out.println(name + " Teacher is studying");
	}
	public void sing() {
		System.out.println(name + " Teacher is singing");
	}
	public void eat() {
		System.out.println(name + " Teacher is eating");
	}
	public void dance() {
		System.out.println(name + " Teacher is dancing");
	}
}


public class TestInterface {

	public static void main(String[] args) {
		Singer s = new Student("tom");
		s.eat();
		s.sing();
		Dancer d = new Teacher("lily");
		d.dance();
		System.out.println(d.id);
		Student s1 = new Student("jerry");
		Teacher t1 = new Teacher("lucy");
		f(s);
		f(s1);
//		f(t1);
		t1.dance();
		Dancer t2 = (Dancer)t1;
		t2.dance();
		f(t2);
	}
	
	static void f(Singer s) {
		s.sing();
	}
	static void f(Dancer s) {
		s.dance();
	}

}
