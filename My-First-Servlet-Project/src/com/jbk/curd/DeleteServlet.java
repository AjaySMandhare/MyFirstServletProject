package com.jbk.curd;


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


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		try {
			
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from register where id=?");
			ps.setInt(1,id);
			
			int result=ps.executeUpdate();
			if(result>0) {
				request.setAttribute("msg", "User Deleted");
				//System.out.println("Recorded deleted");
				RequestDispatcher rd=request.getRequestDispatcher("deleteEmployee.jsp");
				rd.forward(request, response);
			}
			else {
				//System.out.println("Recorded  not deleted");
				request.setAttribute("msg", "User not deleted");
				RequestDispatcher rd=request.getRequestDispatcher("deleteEmployee.jsp");
				rd.forward(request, response);
				
			}
				}catch (Exception e) {
			e.printStackTrace();
		}
		
		
			}
}

