package ai.jobiak.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Prime implements Servlet {

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
		int n=5;
		int i;
		int count=0;
		for(i=2;i<=n;i++)
		{
			if(n%i==0)
			{
				count++;
			}
		}
		if(count==0)
		    out.println("Given number 5 is Prime Number");
	
		/*else
		{
			PrintWriter out=res.getWriter();
		    out.println("Given number 5 is Not a Prime Number");
		}*/
	}

}
