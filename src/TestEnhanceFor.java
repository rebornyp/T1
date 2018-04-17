import java.util.*;

public class TestEnhanceFor {

	public static void main(String[] args) {
		Set<String> s1 = new HashSet<String>();
		Set<String> s2 = new HashSet<String>();
		s1.add("a");
		s1.add("b");
		s1.add("c");
		s2.add("a");
		s2.add("b");
		s2.add("ss");
		
		Set<String> f = new HashSet<String>(s1);
		f.retainAll(s2);
		Set<String> f2 = new HashSet<String>();
		f2.addAll(s2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(f);
		System.out.println(f2);
		
	}

}
