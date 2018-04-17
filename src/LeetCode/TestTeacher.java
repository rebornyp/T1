package LeetCode;

import java.util.Date;

class Person {
	String name;
	int id;
	
	Person() {
		name = "gastby";
		id = 0;
	}
	Person(int id, String s) {
		this.id = id;
		name = s;
	}
	
	String info() {
		return "id=" + id + "\n" + "name=" + name;
	}
	
	void cry() {
		System.out.println("don't cry fr me~~");
	}
	
}

class Teacher extends Person {
	String school;
	
	Teacher() {
		this.school = "beihang";
	}
	Teacher(int id, String name, String s) {
		super(id, name);
		this.school = s;
	}
	Teacher(int id, String school) {
		this(id, "gastby", school);
	}
	Teacher(String name, String school) {
		this(56, name, school);
	}
	String info() {
		return super.info() + "\nschool=" + school;
	}
	/*void cry() {
		System.out.println("don't cry for me~~");
	}*/
}

class Dog {
	void bite(Person p) {
		System.out.println("ҧ��" + p.info());
	}
	
}
public class TestTeacher {

	public static void main(String[] args) {
		String s = new Date().toString();
		System.out.print(s);
		
		/*Teacher s = new Teacher("lucy", "Qinghua");
		System.out.println(s.info());
		int x = 0, y = 56, z = 88;
		Integer f = new Integer(44);
		String str = "x,y,z";
		System.out.println(str + x + y + z);
		System.out.println(str.hashCode());
		System.out.println(f.hashCode());
		
		Person p = new Teacher(11, "fuch", "bih");
		
		
		System.out.println(p instanceof Teacher);
		System.out.println(p instanceof Person);
		
		System.out.println(p.name);
		p.cry();
		System.out.println(p.info());
		System.out.println();*/
		
/*		Dog d1 = new Dog();
		Dog d2 = new Dog();
		
		Person p1 = new Person(5, "Tom");
		d1.bite(p1);
		d2.bite(p);*/
//		System.out.println(d);
		
		
		
		
		
	}

}
