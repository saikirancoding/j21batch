package com.resultsetscrollable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestResultSetScrollable {

	public static void main(String[] args) {
		

		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		
		try
		{
		
			con=DriverManager.getConnection("jdbc:mysql://localhost/mydatabase","root","root");
			
			if(con==null)
				System.out.println("Connection not established");
			else
				System.out.println("Connection  established");
			
			
			
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			 rs= stmt.executeQuery("select * from actors");
			 
			 rs.absolute(3);
			 System.out.println(rs.getInt("id")+" "+rs.getString(2));
			
			/*
			  while(rs.next())
			  { System.out.println(rs.getInt("id")+" "+rs.getString(2));
			  }
			 */
			 
			 rs.last();
			 while(rs.previous())
			 {
				 System.out.println(rs.getInt("id")+" "+rs.getString(2));
			 }
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		

	}

}
