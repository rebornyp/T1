package useful;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 
 * @author Gastby
 * 最近在看论文，发现一些pdf的文档里的总结非常好，所以想着摘抄下来，存入word文档里，可是选择后复制粘贴到word里
 * 发现即使是不保留原格式，还是又大量的空格存在，所以想着写个小程序消除空格
 * 本实例就是基于JAVA-IO运用的一个解决实际问题的小例子
 *
 */

public class Trim {

	/**
	 * main方法是用来运行主程序的函数
	 * @param args
	 * @throws IOException --抛出的IO异常是可能IO读取文件时候可能存在的异常
	 */
	
	public static void main(String[] args) throws IOException {
		String filePath = "C:\\Users\\Gastby\\Desktop\\a.txt";
		File f = new File(filePath);
		InputStream is = null;
		InputStreamReader isr = null;
		if(f.exists()) {
			try {
				is = new FileInputStream(f);
				isr = new InputStreamReader(is, getCharset(filePath));  
				String str = "";
				int b;
				while((b = isr.read()) != -1) {
					char c = (char)b;
					if(!String.valueOf(c).equals(" ")) {
						str += c;
					}
				}
				System.out.print(str.trim());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				isr.close();
				is.close();
			}
		}
		
	}
	
	
	/**
	 * 这是自定义的打印函数，每次打印写System都很费劲啊
	 * @param o 输入任何Object都将调用其toString()方法并将字符串打印
	 */
	static void p(Object o) {
		System.out.println(o);
	}
	
	/**
	 * 这是获取某一个文件的编码格式方法
	 * @param fileName 输入的是文件的系统路径
	 * @return 返回字符串的编码格式<String>类型
	 * @throws IOException
	 */
	private static String getCharset(String fileName) throws IOException{  
        FileReader fr = new FileReader(fileName);
        int p = fr.read();
          
        String code = null;    
          
        switch (p) {    
            case 0xefbb:    
                code = "UTF-8";    
                break;    
            case 0xfffe:    
                code = "Unicode";    
                break;    
            case 0xfeff:    
                code = "UTF-16BE";    
                break;    
            default:    
                code = "GBK";    
        }    
        return code;  
	}  

}
