package LeetCode;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class CheckMyTable implements Serializable{

	
	public static void main(String[] args) throws CloneNotSupportedException {

		System.out.println();
		File f = new File("C:\\Users\\Gastby\\Desktop\\a.txt");
		File f2 = new File("C:\\Users\\Gastby\\Desktop\\b.java");		
		
		if(f.exists()) {
			FileReader fis = null;
			FileWriter fo  = null;
			char[] b = new char[1024];
			int r = 0;
			try {
				fis = new FileReader(f);
				fo = new FileWriter(f2);
				while((r = fis.read(b)) > 0) {
					fo.write(b, 0, r);
				}
				fis.close();
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(fis != null)
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				
				if(fo != null)
					try {
						fo.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
		
	}
	
}
