
public class TestReg {

	public static void main(String[] args) {
		p("abc".matches("..."));
		p("dhq3yr793hfbweu".replaceAll("\\d", "-"));
	}
	
	static void p(Object o) {
		System.out.println(o);
	}
}
