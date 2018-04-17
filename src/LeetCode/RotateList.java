package LeetCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.util.ClassPath;

public class RotateList {

	
	public static void main(String[] args) throws IOException {
		
//		Scanner s = new Scanner(System.in);
		Scanner s;
		File f = new File("");
		String str = RotateList.class.getResource("/").getPath() + "/LeetCode.RotateList.java";
		File f2 = new File(str);
		
		System.out.println(f.getAbsolutePath());
		
		
//		Properties property = System.getProperties();
//        String dir = property.getProperty("java.class.path");
//        System.out.println(dir + "\\" + ClassPath.class.getName());
/*		if(f2.exists()) System.out.println("adokdaowdnoawsmndfawio");
		System.out.println(f.getAbsolutePath());
		System.out.println(f.getCanonicalPath());
		System.out.println(f.getPath());
		System.out.println(RotateList.class.getResource("/").getPath());*/
		
		
		if(!f.exists()) return;
		System.out.println(f.getAbsolutePath());
		try {
			s = new Scanner(f);
//			s.useDelimiter("\n");
			while(s.hasNextLine()) {
				System.out.println("输出：" + s.nextLine());
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
}

