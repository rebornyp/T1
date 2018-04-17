package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestSql extends HttpServlet {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://112.74.84.181:3306/mydb?useSSL=false&&characterEncoding=UTF-8&noAccessToProcedureBodies=true";
    static final String USER = "gastby";
    static final String PASS = "962464yp";
    static Connection conn = null;
    static PreparedStatement stmt = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		String accountName = req.getParameter("accountName");
		String pwd = req.getParameter("pwd");
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "insert into stu (accountName, pwd) values (?, ?);";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, accountName);
			stmt.setString(2, pwd);
			stmt.executeUpdate();
			pw.println("恭喜你，注册成功");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		pw.write("nice to meet you");
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
