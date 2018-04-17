package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class GetMysql extends HttpServlet{

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; //mysql 
    static final String DB_URL = "jdbc:mysql://112.74.84.181:3306/mydb?useSSL=false&&characterEncoding=UTF-8&noAccessToProcedureBodies=true"; //mysql
    static final String USER = "gastby"; //mysql下
    static final String PASS = "962464yp";
    static Connection conn = null;
    static Statement stmt = null;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            pw.write("真好呢~~~");
            // 执行查询
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM stu";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("accountName");
                String url = rs.getString("pwd");
    
                // 输出数据

                pw.write("ID: " + id);
                pw.write(", 站点名称: " + name);
                pw.write(", 站点 URL: " + url);
                pw.write("<br>");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
	     }catch(SQLException se){
	            // 处理 JDBC 错误
	            se.printStackTrace();
	        }catch(Exception e){
	            // 处理 Class.forName 错误
	            e.printStackTrace();
	        }finally{
	            // 关闭资源
	            try{
	                if(stmt!=null) stmt.close();
	            }catch(SQLException se2){
	            }// 什么都不做
	            try{
	                if(conn!=null) conn.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }
	        }
		
		
		pw.close();
	}

}
