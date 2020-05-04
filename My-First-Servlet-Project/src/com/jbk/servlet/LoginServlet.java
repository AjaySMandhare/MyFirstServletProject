package com.jbk.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get data
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		
		System.out.println(uname);
		System.out.println(password);
		
		//process data
		boolean correct = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");

			Statement stmt = connection.createStatement();

			String sql = "select * from register where uname ='" + uname + "' and password = '" + password + "'";
			ResultSet rm = stmt.executeQuery(sql);

			if (rm.next()) {
				correct = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (correct) {
			//navigate data		
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("msg", " Wrong User Name and password................");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

		
}
