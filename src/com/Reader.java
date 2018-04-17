package com;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Reader {

	static String path = "C:\\Users\\Gastby\\Desktop\\sjk.xls";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int flag;
		PreparedStatement st = null;
		Connection conn = null;
		
		try {  
            //打开文件  
            Workbook book = Workbook.getWorkbook(new File(path)); 
            Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "962464yp");
			String sql = "insert into teach values(?, ?, ?)";
			st = conn.prepareStatement(sql);
            //获得第一个表的工作对象，“0”表示第一个表  
        	Sheet sheet = book.getSheet(4);  
        	int width = 3;
        	
        	//得到第一列，第一行的单元格（0，0）  
        	for(int i=1; i<5; i++) {
        		String[] s1 = new String[width];
        		for(int j=0; j<width; j++) {
            		 s1[j]= sheet.getCell(j, i).getContents();
            		 st.setString(j+1, s1[j]);
    			}
        		st.executeUpdate();
        	} 
            st.close();
            conn.close();
            book.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (BiffException e) {  
            e.printStackTrace();  
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	static void p(Object o) {
		System.out.println(o);
	}

}

