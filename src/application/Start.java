package application;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Start {

	public static void mais(String[] args) {
		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Nicolau061194@")) {
			
			if(conn != null) { 
				
				Statement stmt=(Statement) conn.createStatement();
				
				String d="select * from emp where empid=' "+empid+"'";
				
				ResultSet rd=((java.sql.Statement) stmt).executeQuery(d);
				
				System.out.println(""+d);
			}
			else
			{
				System.out.println("Failed to make connection");
			}
}
		catch(SQLException e)
		{
				System.err.format("SQL State; %s\n%s", e.getSQLState(), e.getMessage());
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}