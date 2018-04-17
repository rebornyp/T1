import java.io.File;
import java.io.IOException;

public class TestFile {

	enum MyColor {red, blue, yellow};
	
	public static void main(String[] args) {
		String directory = "mydirrr";
		String filename = "myfile.do";
		File myFile = new File(directory, filename);
		if(myFile.exists()) {
			System.out.println("文件名字" + myFile.getAbsolutePath());
			System.out.println("文件大小" + myFile.length());
		}
		else {
			myFile.getParentFile().mkdirs();
			try {
				myFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String s = "F:/电影B";
		File testfile = new File(s);
		System.out.println("文件名字" + testfile.getParent());
		System.out.println("文件名字" + testfile.toString());
		if(testfile.exists()) {
			File[] f = testfile.listFiles();
			if(f != null) {
				for(int i=0; i<f.length; i++) {
					System.out.println("文件名字" + f[i].getName());
				}
			}
		}
		
//		File newFile = new File("C:/Users/Gastby/Desktop/java");
		File newFile = new File("C:/Users/Gastby/Desktop/A");
		if(newFile.exists()) {
			printFiles(newFile, 0);
		}
		
		MyColor c = MyColor.blue;		
	}
	
	static void printFiles(File s, int k) {
		printSpace(k);
		System.out.println(s.getName());
		File[] n = s.listFiles();
		if(n == null)
			return;
		else {
			for(int i=0; i<n.length; i++) {
				printFiles(n[i], k + 1);
			}
		}
	}

	static void printSpace(int n) {
		for(int i=0; i<n; i++) {
			System.out.print("  ");
		}
	}
}
