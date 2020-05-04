package com.jbk.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get data
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phono = request.getParameter("phono");

		System.out.println(uname);
		System.out.println(password);
		System.out.println(email);
		System.out.println(phono);

		// process data
		try {

			Class.forName("com.mysql.jdbc.Driver");
			String sql = "Insert into register 	(uname, password,email,phono) values (?,?,?,?)";
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");

			// Statement stmt = connection.createStatement();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, phono);
			

			ps.executeUpdate();

			// PrintWriter out = response.getWriter();

			// navigate data
			request.setAttribute("msg1", "Registration Successfull....");
			RequestDispatcher rd = request.getRequestDispatcher("registration-success.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
