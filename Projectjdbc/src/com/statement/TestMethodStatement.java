package com.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestMethodStatement {

	static Connection con=null;
	static Statement stmt=null;
	static ResultSet rs=null;
	
	public static Connection findConnection()
	{
		try
		{
		
			con=DriverManager.getConnection("jdbc:mysql://localhost/jdbcj21","root","root");
			
			if(con==null)
				System.out.println("Connection not established");
			else
				System.out.println("Connection  established");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return con;
		
	}
	public static void insertRecord()throws SQLException
	{
		con=findConnection();
		String sql="insert into students values(103,'sanjay',80)";
		stmt=con.createStatement();
		stmt.executeUpdate(sql);
		System.out.println("insert record");
		
	}
	
	public  static void updateRecord()throws SQLException
	{
		con=findConnection();
		
		String sql="update students set name='Ravi' where id=102";
		stmt=con.createStatement();
		stmt.executeUpdate(sql);
		System.out.println("update  record");
	}
	
	public  static void  deleteRecord()throws SQLException
	{
		con=findConnection();
		
		String sql="delete from students where id=103";
		stmt=con.createStatement();
		stmt.executeUpdate(sql);
		System.out.println("Delete  record");
	}
	
	public  static void DisplayRecord()throws SQLException
	{  con=findConnection();
	
	    stmt=con.createStatement();
        rs=	stmt.executeQuery("select * from students");
	
        while(rs.next())
		    {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		    }
	
	}
	
	public static void main(String[] args)throws SQLException {
	
		Scanner sc=new Scanner(System.in);
		int choice;
		String s=null;
		
		do
		{
			System.out.println("1.Insert Record");
			System.out.println("2.Update Record");
			System.out.println("3.Delete Record");
			System.out.println("4.Display Record");
			
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			
			switch(choice)
			{	
			 case 1:
				insertRecord();
				break;
				
			 case 2:
					updateRecord();
					break;
					
			case 3:
					deleteRecord();
					break;
					
			 case 4:
						DisplayRecord();
						break;
			}
			
			System.out.println("Do you want to continue yes or no");
			s=sc.next();
			
		}while(s.equals("yes"));
       System.out.println("Finish Program");
	}

}
