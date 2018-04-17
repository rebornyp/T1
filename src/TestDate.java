

public class TestDate {
	
	int year;
	int month;
	int day;
	
	public TestDate() {
		this.year = 0;
		this.month = 0;
		this.day = 0;
	}
	
	public TestDate(int i, int j, int k) {
		this.year = i;
		this.month = j;
		this.day = k;
	}
	
	public String toString() {
//		System.out.print(this.year + "年" + this.month + "月" + this.day + "日");
		return this.year + "年" + this.month + "月" + this.day + " 日";
	}
	
	public static void change(int i) {
		i = 1265;
	}
	
	public static void change(TestDate b) {
		b = new TestDate(12, 3, 57);
	}
	public static void change2(TestDate b) {
		b.year = 555;
		b.month = 555;
		b.day = 326;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDate a = new TestDate();
		System.out.print(a.year + " " + a.month + " " + a.day);
		TestDate b = new TestDate(15, 26, 85);
		System.out.println();
		System.out.println(b.year + " " + b.month + " " + b.day);
		System.out.println(a);
		System.out.println(b);
		int j = 56;
		change(j);
		System.out.println(j);
		change2(b);
		System.out.println(b);
		
	}

}
