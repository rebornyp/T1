import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TomcatSer extends HttpServlet {

//	static int num = 1;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		String id = req.getParameter("name");
		String password = req.getParameter("pw");
		
		PreparedStatement st = null;
		Connection conn = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "962464yp");
			st = conn.prepareStatement("insert into student values (?, ?)");
			st.setString(1, id);
			st.setString(2, password);
			st.executeUpdate();
			
			pw.println("连接成功");
		} catch(ClassNotFoundException e) {
			pw.println("找不到类了");
			e.printStackTrace();
		} catch(SQLException e) {
			pw.println("SQL连接问题");
			
			//e.printStackTrace();
		}
		try {
			if(st != null) {
				st.close();
				st = null;
			}
			if(conn != null) {
				conn.close();
				conn = null;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	static void p(Object o) {
		System.out.println(o);
	}

}
