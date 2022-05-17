package ai.jobiak.app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifeCycleServlet implements Servlet {

	
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
	//startup work-acquire resources->Deserialization
		try {
			System.out.println("Entered init().....");
			FileOutputStream fos = new FileOutputStream("Hello.txt");
			fos.write("This is added in init() to demonstrate the timing of init method".getBytes());
			fos.close();
			System.out.println("Exiting init().....");
			} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.getWriter().println("This is from service()........");
		
	}

	@Override
	public void destroy() {
		// cleanup work-Serialization
		try {
			System.out.println("Entered destroy().....");
			FileOutputStream fos = new FileOutputStream("Hello.txt",true);
			fos.write("This is added in destroy() to demonstrate the timing of destroy method".getBytes());
			fos.close();
			System.out.println("Exiting destroy().....");
			Thread.currentThread().join();
			} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
