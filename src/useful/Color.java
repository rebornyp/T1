package useful;

import java.util.Arrays;

public enum Color {
	Blue("sd"), white("aw"), Red("kk"), Green("dai"), Pink("dmoais");
	private final String name;
	private Color(String name) {
		this.name = name;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("das");
		System.out.println(Arrays.toString(Color.values()));
		System.out.println(Color.valueOf("Red"));
		int[] a = new int[12];
		long[] b = new long[9];
		System.out.println(b.getClass().getClassLoader());
		
	}
	
}

