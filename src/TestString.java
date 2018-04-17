
public class TestString {
	
	
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "hello";
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		String a1 = new String("hh");
		String a2 = new String("jjjjjj");
		System.out.println(a1 == a2);
		System.out.println(a1.equals(a2));
		System.out.println(a1.compareTo(a2));
		String b1 = "java sun oracle microsoft IBM";
		String[] c = b1.split(" ");
		for(int i=0; i<c.length; i++) {
			System.out.println(c[i]);
		}
		long l = 15497531;
		s1 = String.valueOf(l);
		System.out.println(s1.length());
		Date d = new Date(1994, 12, 24);
//		System.out.println(d);
//		String str = String.valueOf(d);
		String str = d.toString();
		System.out.println(str);
		String s = "javahhjavahsyeijavalsdjavaxsjavajsajavavajavajavajavansmdnajvaajava";
		String[] t = s.split("java");
		for(int i=0; i<t.length; i++) {
			System.out.println(t[i]);
		}
		System.out.println(t.length);
		str = "java";
		int count = 0, index;
		while(s.indexOf(str) != -1) {
			count ++;
			index = s.indexOf(str);
			s = s.substring(index + str.length());
		}
		System.out.println(count);
		
	}

}

class Date {
	int year, month, day;
	Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public String toString() {
		return year + "Äê" + month + "ÔÂ" + day + "ÈÕ";
	} 
}