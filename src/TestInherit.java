class Animal {
	void ran() {
		System.out.println("动物在跑~~~");
	}
}

class Dog extends Animal {
	/*void ran() {
		System.out.println("狗在跑~~~");
	}*/
}
public class TestInherit {

	public static void main(String[] args) {
		Dog d = new Dog();
		d.ran();
	}

}
