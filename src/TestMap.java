import java.util.*;

public class TestMap {

	public static void main(String[] args) {
		Map<String, Double> m1 = new HashMap<String, Double>();
		Map<String, Double> m2 = new TreeMap<String, Double>();
		m1.put("one", 56.0);
		m1.put("two", 25.0);
		m1.put("three", -99.0);
		m2.put("ss", 0.66);
		m2.put("hdajk", 12.1314);
		System.out.println(m1);
		System.out.println(m1.size());
		System.out.println(m2);
		System.out.println(m2.size());
		System.out.println(m1.containsKey("one"));
		System.out.println(m2.containsValue(12.1314));
		
		Map<String, Double> m3 = new HashMap<String, Double>(m1);
		m3.putAll(m2);
		System.out.println(m3);
		m3.remove("one");
		System.out.println(m3);
		System.out.println(m3.get("two"));
		
	}

}

