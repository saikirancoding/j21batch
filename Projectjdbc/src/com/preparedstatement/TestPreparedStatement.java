package com.preparedstatement;

import java.sql.*;

public class TestPreparedStatement {

public static void main(String[] args)throws SQLException {
		
		Connection con=null;
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost/mydatabase","root","root");
			
			if(con==null)
				System.out.println("Connection not established");
			else
				System.out.println("Connection established");
			
			String sql="create table student1(id int,name varchar(20),marks int,primary key(id))";
			
			ptmt=con.prepareStatement(sql);
			ptmt.execute();
			
			System.out.println("Table create");
			
//			String sql1="insert into student1 values(?,?,?)";
//			ptmt=con.prepareStatement(sql1);
//			
//			ptmt.setInt(1,110);
//			ptmt.setString(2,"Maya");
//			ptmt.setInt(3,90);
//
//			ptmt.executeUpdate();
//			
//			System.out.println("Record inserted");
			
		/*	
			PreparedStatement stmt=con.prepareStatement("update student1 set name=? where id=?");  
			stmt.setString(1,"Sanjay");//1 specifies the first parameter in the query i.e. name  
			stmt.setInt(2,101);  
			  
			int i=stmt.executeUpdate();  
			System.out.println(i+" records updated");  
			*/
			
			/*
			PreparedStatement stmt=con.prepareStatement("delete from student1 where id=?");  
			stmt.setInt(1,101);  
			  
			int i=stmt.executeUpdate();  
			System.out.println(i+" records deleted");  */
			
			/*
			PreparedStatement stmt=con.prepareStatement("select * from emp");  
			ResultSet rs=stmt.executeQuery();  
			while(rs.next()){  
			System.out.println(rs.getInt(1)+" "+rs.getString(2));  
			}  */
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}


}
