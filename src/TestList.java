import java.util.*;

public class TestList {

	public static void main(String[] args) {
		List<String> l1 = new LinkedList<String>();
		for(int i=0; i<5; i++) {
			l1.add("test" + i);
		}
		System.out.println(l1);
		l1.add("moring");
		System.out.println(l1);
		System.out.println(l1.set(2, "sofa"));
		System.out.println(l1);
		l1.add(1, "sm");
		System.out.println(l1);
//		l1.remove(2);
		l1.remove("test4");
		System.out.println(l1);
//		System.out.println(l1.get(4));
		Collections.sort(l1);
		System.out.println(l1);
		Collections.shuffle(l1);
		System.out.println(l1);
		Collections.reverse(l1);
		System.out.println(l1);
		l1.clear();
		Cat c1 = new Cat(1);
		Cat c2 = new Cat(99);
		Cat c3 = new Cat(56);
		List<Cat> l2 = new LinkedList<Cat>();
		l2.add(c1);
		l2.add(c2);
		l2.add(c3);
		Collections.sort(l2);
		System.out.println(l2);
		Collections.reverse(l2);
		System.out.println(l2);
		Collections.shuffle(l2);
		System.out.println(l2);
		
	}

}

class Cat implements Comparable<Cat>{
	int size;
	public enum color {red, blue, yellow};
	
	Cat(int size) {
		this.size = size;
	}
	
	/*public boolean equals(Object obj) {
		
	}*/
	
	public String toString() {
		return "这只体型是" + size + "的猫";
	}
	
	public int compareTo(Cat o) {
		if(size > o.size)
			return 1;
		else if(size == o.size)
			return 0;
		else return -1;
	}
	
}
