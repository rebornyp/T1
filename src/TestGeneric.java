import java.util.*;

public class TestGeneric {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("aaa");
		l.add("bbb");
		l.add("vcc");
		for(int i=0; i<l.size(); i++) {
			String s = l.get(i);
			System.out.println(s);
		}
		
		Collection<String> c = new HashSet<String>();
		c.add("sdi");
		c.add("s");
		c.add("di");
		
		Iterator<String> it = c.iterator();
		for( ; it.hasNext(); ) {
			System.out.println(it.next());
		}
		
		for(Iterator<String> v = l.iterator(); v.hasNext();) {
			System.out.println(v.next());
		}
		
	}

}
