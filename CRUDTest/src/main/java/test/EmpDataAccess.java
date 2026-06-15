package test;
import java.util.*;

import java.sql.*;
public class EmpDataAccess {
private static int status;
public static Connection getConnection() {
	Connection con=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crudtestdb","root","root");
		
	}catch(Exception e)
	{
		System.out.println(e);
	}
	return  con;
	
}
 public static int save(Employee  e) 
 {
	 int status =0;
	 try {
		 Connection con=EmpDataAccess.getConnection();
		 PreparedStatement ps=con.prepareStatement("insert into usertable(id,name,password,email,country) values(?,?,?,?,?)");
		 ps.setInt(1, e.getId());
		 ps.setString(2, e.getName());
		 ps.setString(3, e.getPassword());
		 ps.setString(4, e.getEmail());
		 ps.setString(5, e.getCountry());
		 
		 status=ps.executeUpdate();
		 con.close();
		 
	 }catch ( Exception e2)
	 {
		 System.out.println(e2);
	 }
	 return status;
 }
 
 public static List<Employee> getAllEmployees()
	{
		List<Employee> list = new ArrayList<Employee>();
		
		try
		{
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from usertable limit ");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				
				list.add(e);
				
			}
		
		} catch (Exception e1)
		{
			System.out.println(e1);
		}
		return list;
		
	}


 public static int update(Employee e)
 {
		// TODO Auto-generated method stub
	 
	 int status =0;
	 try {
		 Connection con =EmpDataAccess. getConnection();
			PreparedStatement ps = con.prepareStatement("update Usertable set name=?,password=?,email=?,country=?,where  id=? ");
			//ResultSet rs = ps.executeQuery();
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			ps.setInt(5,e.getId());
				
			status=ps.executeUpdate();
		con.close();
	}
	 catch(Exception e2)
	 {
		System.out.println(e2);
	 }
	return status;
}
	 

 

public static Employee getElemenetBy(int id) {
	
	Employee e=new Employee();
	try{
		Connection con=EmpDataAccess.getConnection();
		PreparedStatement ps=con.prepareStatement("select*from usertable where id=?");
			ps.setInt(1, id);	
			ResultSet rs=ps.executeQuery();
			if(rs.next()) 
			{
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				
			}
		con.close();
	}catch(Exception e2)
	{
		System.out.println(e2);
	}
	return e;
}






public static int delete(int id) {
	// TODO Auto-generated method stub
	try {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("delete for usertable where id=?  ");
		ps.setInt(1,id);
		status =ps.executeUpdate();
		con.close();
	}catch(Exception e)
	{
		System.out.println(e);
	}
	
	
	return status;
	
}
 


	
}
