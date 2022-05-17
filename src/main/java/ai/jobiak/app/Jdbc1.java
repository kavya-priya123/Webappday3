package ai.jobiak.app;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class Jdbc1 implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		String url="jdbc:mysql://localhost:3306/world";
		String userName="root";
		String password="admin";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,userName,password);
			out.println("Connected to db");
			Statement st=con.createStatement();
			String sql="Select * from country";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5)+rs.getString(6)+"::"+rs.getString(7)+"::"+rs.getString(8)+"::"+rs.getString(9)+"::"+rs.getString(10)+rs.getString(11)+"::"+rs.getString(12)+"::"+rs.getString(13)+"::"+rs.getString(14)+"::"+rs.getString(15));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}
