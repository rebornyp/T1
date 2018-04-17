
public class TestStringBuffer {

	public static void main(String[] args) {
		StringBuffer s = new StringBuffer("hello");
		s.append(true);
		System.out.println(s);
		s.append("989skjda");
		s.append("111.2566");
		System.out.println(s);
		String str = "hiuehfudbvusgfoajbksbvab";
		char[] test = str.toCharArray();
		s.append(test);
		System.out.println(s);
		s.insert(5, "ggg");
		System.out.println(s);
		s.deleteCharAt(5);
		System.out.println(s);
		s.reverse();
		System.out.println(s);
		
		String c = "1, 2.3, 65; 1.03, 625, 99; 0.32, 611, 4478, 2163";
		String[] c1 = c.split(";");
		double[][] d = new double[c1.length][];
		for(int i=0; i<c1.length; i++) {
			String[] c2 = c1[i].split(",");
			d[i] = new double[c2.length];
			for(int j=0; j<c2.length; j++) {
				d[i][j] = Double.parseDouble(c2[j].trim());
				System.out.print(c2[j].trim() + " ");
			}
			System.out.println();
		}
		show(d);
	}
	
	static void show(double[][] d) {
		for(int i=0; i<d.length; i++) {
			for(int j=0; j<d[i].length; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
	}

}
