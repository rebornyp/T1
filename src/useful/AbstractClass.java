package useful;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow {}
class Powder extends Snow {}
class Light extends Powder {}
class Heavy extends Powder {}

public class AbstractClass {

	public static void main(String[] args) {
//		List<Snow> l2 = new ArrayList<Snow>();
//		Collections.addAll(l2, new Snow());
		
		List<Snow> l3 = new ArrayList<Snow>(Arrays.asList(new Light(), new Heavy()));
		l3.add(new Snow());
		Collections.addAll(l3, new Snow(), new Heavy());
		p(l3.size());
		p("sd");
	}

	static void p(Object i) {
		System.out.println(i);
	}
	
}
