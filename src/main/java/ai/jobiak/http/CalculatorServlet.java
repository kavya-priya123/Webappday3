package ai.jobiak.http;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String num1 = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    

    private Connection connect() {
    	String url="jdbc:mysql://localhost:3306/world";
    	String userName="root";
    	String password="admin";
    	Connection con=null;
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con=DriverManager.getConnection(url,userName,password);
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	return con;
    }
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int result=0;
		int num1=0;
		int num2=0;
		String num1Str=request.getParameter("num1");
		String num2Str=request.getParameter("num2");
		String result1Str=num1Str+num2Str;
		try {
		Connection con=connect();
		int count=0;
		PreparedStatement ps=con.prepareStatement("insert into calculator values(?,?,?)");
		ps.setString(1,num1Str);
		ps.setString(2,num2Str);
		ps.setString(3,result1Str);
		
		count=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		response.getWriter().println(result1Str);
	}
}


