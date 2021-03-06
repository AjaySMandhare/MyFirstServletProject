package com.jbk.curd;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jbk.servlet.Emp;
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private String phono;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String uname=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phono=request.getParameter("phono");
		
		Emp e=new Emp();
		e.setId(id);
		e.setUname(uname);
		e.setPassword(password);
		e.setEmail(email);
		e.setPhono(phono);
		
		int status=EmployeeDao.update(e);
		if(status>0){
			response.sendRedirect("ViewServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
