package useful;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadSqlFileToMysql {

    final static String JDBC_DRIVER = "com.mysql.jdbc.Driver"; //mysql 
    static final String DB_URL = "jdbc:mysql://112.74.84.181:3306/mydb?useSSL=false&&characterEncoding=UTF-8&noAccessToProcedureBodies=true"; //mysql
    static final String USER = "gastby"; //mysql下
    static final String PASS = "962464yp";
	
	public static void main(String[] args) {
		String filePath = "C:\\Users\\Gastby\\Desktop\\a.sql";
		File f = new File(filePath);
		FileInputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
	    Connection conn = null;
	    Statement stmt = null;
	    
		try {
			is = new FileInputStream(f);
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String s = null;
			
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			String sql = null;
			System.out.println("aaa");
			/*while((s = br.readLine()) != null) {
				sql = s;
				if(sql != null || sql != "")
					stmt.execute(sql);
				System.out.println(s);
			}*/
			stmt.execute("create table article");
//			sql = "insert into stu (accountName, pwd) values ('ss', 'we232');";
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("ddd");
			try {
				if(br != null)
					br.close();
				if(isr != null)
					isr.close();
				if(is != null)
					is.close();
	            if(stmt != null)
	            	stmt.close();
	            if(conn != null)
	            	conn.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
