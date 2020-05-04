package com.jbk.curd;
import java.util.*;

import com.jbk.servlet.Emp;

import java.sql.*;

public class EmployeeDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(Emp e){
		int status=0;
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into register(uname,password,email,phono) values (?,?,?,?)");
			ps.setString(1,e.getUname());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getPhono());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Emp e){
		int status=0;
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update register set uname=?,password=?,email=?,phono=? where id=?");
			ps.setString(1,e.getUname());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getPhono());
			ps.setInt(5,e.getId());
			
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	/*public static int delete(int id){
		int status=0;
		try{
			Connection con=UserDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from register where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}*/
	public static Emp getEmployeeById(int id){
		Emp e=new Emp();
		
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from register where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setUname(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setPhono(rs.getString(5));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<Emp> getAllEmployees(){
		List<Emp> list=new ArrayList<Emp>();
		
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from register");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp e=new Emp();
				e.setId(rs.getInt(1));
				e.setUname(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setPhono(rs.getString(5));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}
