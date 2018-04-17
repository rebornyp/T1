import java.io.*;

public class TestBufferWriter {

	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/Gastby/Desktop/t.txt"));
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/Gastby/Desktop/t.txt"));
			
			String s = null;
			for(int i=0; i<100; i++) {
				s = String.valueOf(Math.random());
				bw.write(s);
				bw.newLine();
			}
			bw.flush();
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
			bw.close();
			br.close();
			
		} catch (IOException e) {
			System.out.println("没找到文件...");
			System.exit(-1);
		}
	}

}
