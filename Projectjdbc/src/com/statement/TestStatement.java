package com.statement;

import java.sql.*;

public class TestStatement {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		
		//Class.forName("com.mysql.cj.jdbc.Driver");

		try
		{
		
			con=DriverManager.getConnection("jdbc:mysql://localhost/jdbcj21","root","root");
			
			if(con==null)
				System.out.println("Connection not established");
			else
				System.out.println("Connection  established");
			
		/*	String sql="create table students(id int,name varchar(20),marks int,primary key(id))";
		
			stmt=con.createStatement();
			stmt.executeUpdate(sql);
			
			System.out.println("Table create");
			
			*/
			
		//Insert record
			/*
			String sql="insert into students values(102,'Vijay',80)";
			stmt=con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("insert record");
			*/
			
			//Delete record
		/*	String sql="delete from students where id=103";
			stmt=con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Delete  record");
			*/
			//update record
			/*
			String sql="update students set name='Ram' where id=102";
			stmt=con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("update  record");
			*/
			
			//Result Set
			
			stmt=con.createStatement();
		rs=	stmt.executeQuery("select * from students");
			
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
