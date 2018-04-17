import java.io.*;

public class TestStream {

	public static void main(String[] args) {
//		FileInputStream f = null;
//		FileOutputStream o = null;
		FileReader f = null;
		FileWriter o = null;
		
		int d = 0;
		
		try {
			f = new FileReader("C:/Users/Gastby/Desktop/Codes/T1/src/TestStream.java");
			o = new FileWriter("C:/Users/Gastby/Desktop/test.java");
			
			while((d = f.read()) != -1) {
				System.out.print((char)d);
//				o.write(d);
			}
			for(int i=15000; i<50000; i++) {
				o.write(i);
				if(i % 150 == 0)
					o.write(13);
					
			}
			System.out.println(Math.pow(2, 16));
			System.out.println(Byte.MAX_VALUE);
			System.out.println(Short.MAX_VALUE);
			System.out.println(Integer.MAX_VALUE);
			System.out.println(Long.MAX_VALUE);
			f.close();
			o.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件找不到....");
			System.exit(-1);
		} catch (IOException p) {
			System.out.println("文件读的不对...");
			System.exit(-1);
		}
		
	}

}
