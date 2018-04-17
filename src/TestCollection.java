import java.util.*;

public class TestCollection {

	public static void main(String[] args) {
//		Collection c = new HashSet();
//		Collection c = new ArrayList();
		Set c = new HashSet();
		c.add(new Name("hhh", "shi"));
		Name f1 = new Name("ss", "ia");
		Name f2 = new Name("ss", "ia");
		System.out.println(f1.equals(f2));
		c.add(f1);
		System.out.println(c.add(f2));
		c.add("hello");
		c.add(new Name("hdshbsbh", "shbdsia"));
		System.out.println(c);
		
		/*for(Iterator it = c.iterator();it.hasNext();) {
			Object temp = it.next();
			System.out.println(temp);
		}*/
		
		/*int[] arr = {1, 56, 95, 848, 63};
		for(int i : arr) {
			System.out.println(i);
		}*/
		
		/*for(Object s : c) {
			System.out.println(s);
		}*/
		
	}
}

class Name {
	String first, last;
	Name(String first, String last) {
		this.first = first;
		this.last = last;
	}
	public String toString() {
		return first + "-" + last;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Name) {
			Name o = (Name)obj;
			return (first.equals(o.first)) && (last.equals(o.last));
		}
		return super.equals(obj); 
	}
	
	public int hashCode() {
		return first.hashCode() + last.hashCode();
	}
		
		
		
	/*public int compareTo(Object o) {
		return 12;
	}*/
}

