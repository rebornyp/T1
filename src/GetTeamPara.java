import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetTeamPara extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("谢谢支持啦");
		String number = req.getParameter("number");
		String name = req.getParameter("name");
		String sex;
		if(req.getParameter("sex") == "male")
			sex = "boy";
		else
			sex = "girl";
		String pro = req.getParameter("pro");
		String interest = req.getParameter("interest");
		String song = req.getParameter("song");
		if(name == "") {
			System.exit(-1);
		}
		
		PreparedStatement st = null;
		Connection conn = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "962464yp");
			st = conn.prepareStatement("insert into team values (?, ?, ?, ?, ?, ?)");
			st.setString(1, number);
			pw.println("-1-");
			st.setString(2, sex);
			pw.println("-2-");
			st.setString(3, name);
			pw.println("-3-");
			st.setString(4, pro);
			pw.println("-4-");
			st.setString(5, interest);
			pw.println("-5-");
			st.setString(6, song);
			pw.println("-6-");
			st.executeUpdate();
			pw.println("连接成功");
		} catch(ClassNotFoundException e) {
			pw.println("找不到类了");
			e.printStackTrace();
		} catch(SQLException e) {
			pw.println("SQL连接问题");
			e.printStackTrace();
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
