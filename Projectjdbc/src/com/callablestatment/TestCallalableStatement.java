package com.callablestatment;

import java.sql.*;

public class TestCallalableStatement {

	public static void main(String[] args)throws SQLException {
		

		Connection con=null;
		CallableStatement ctst=null;
		
		ResultSet rs=null;

		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
				
				con=DriverManager.getConnection("jdbc:mysql://localhost/mydatabase","root","root");
				
				if(con==null)
					System.err.println("Connection not establish");
				else
					System.out.println("Connection established");

				
				ctst=con.prepareCall("{call insertData10(?,?)}");
				
				ctst.setInt(1,4);
				ctst.setString(2, "Shiv");
				
				ctst.executeUpdate();
				
				System.out.println("procedure called");
			
				
				CallableStatement ctmt1=con.prepareCall("select * from actors");
				rs=ctmt1.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+""+rs.getString(2));
				}
				
	}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	   finally
	   {
		   con.close();
	   }
		}

}
