import java.io.*;

public class TestFileRename {

	public static void main(String[] args) {
		File f = new File("C:/Users/Gastby/Desktop/�ĵ�����/4");
		if(f.exists()) {
			File[] fs = f.listFiles();
			for(int i=0; i<fs.length; i++) {
				String s = fs[i].getName();
				if(s.indexOf("-") != -1) {
					s = s.substring(s.indexOf("-") + 1);
					fs[i].renameTo(new File(f, s));
				}
			}
		}
	}

}
