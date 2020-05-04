package com.jbk.curd;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jbk.servlet.Emp;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phono=request.getParameter("phono");
		
		Emp e=new Emp();
		e.setUname(uname);
		e.setPassword(password);
		e.setEmail(email);
		e.setPhono(phono);
		
		int status=EmployeeDao.save(e);
		if(status>0){
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}

}
