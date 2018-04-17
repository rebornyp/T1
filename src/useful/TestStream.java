package useful;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class TestStream implements Serializable{
	
	
	public static void main(String[] args) throws IOException {
/*		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		int n = 0;
		while((line = br.readLine()) != null) {
			if(line.equals("exit"))
				System.exit(-1);
			System.out.println(line);
		}*/
		
/*		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println(reader.readLine());
	    reader.close();*/
		
		System.out.println((2.0e-6*100000000.1));
		System.out.println(false || true && false || false);
		System.out.println(Math.abs(-2147483648));
		
	}
	
}
