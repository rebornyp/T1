class Animal {
	void ran() {
		System.out.println("��������~~~");
	}
}

class Dog extends Animal {
	/*void ran() {
		System.out.println("������~~~");
	}*/
}
public class TestInherit {

	public static void main(String[] args) {
		Dog d = new Dog();
		d.ran();
	}

}
