package com.jbk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jbk.curd.EmployeeDao;


@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	System.out.println("I am in fogot password");
	String email=request.getParameter("email");
	String password=request.getParameter("password");
	
	System.out.println(email);
	
	try {
		Connection con=EmployeeDao.getConnection();
		PrintWriter out=response.getWriter();
		PreparedStatement ps=con.prepareStatement("update register set password=? where email=?");
		ps.setString(2, email);
		ps.setString(1, password);
		int result=ps.executeUpdate();
		
		if(result>0) {	
			response.sendRedirect("updatepass.jsp");
			
			}
		else{
			out.println("Invalid Email Id !");
			}
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
		
	}

}
