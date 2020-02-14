package application;

import java.sql.Statement;
import java.sql.Types;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Start {

	public static void main(String[] args) {
		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Pa$$w0rd")) {
			
			if(conn != null) { 
			//Statement stmt=(Statement) conn.createStatement();
				
				
				String d="{call Login(?,?,?)}";
				
				
				//Callable tipico para os statements
				
				CallableStatement stmt =conn.prepareCall(d);
				
				//parametro in - set
				stmt.setString(1, "JSilva");
				stmt.setString(2, "Pa$$w0rd");
				
				stmt.registerOutParameter(3,Types.VARCHAR);
				
				stmt.executeUpdate();
				
				
				//guarda variavel 3
				String SessionID=stmt.getString(3);
				
				System.out.println(SessionID);
				
				
				//ResultSet rs=((java.sql.Statement) stmt).executeQuery(d);
				
//				int ID;
//				String Nome;
//				String NumcartaoCidadao;
//				
//				
//				while (rs.next())
//				{
//					ID=rs.getInt("ID");
//					Nome=rs.getString("Nome");
//					NumcartaoCidadao=rs.getString("NumCartaoCidadao");
//					System.out.println(ID+"\t"+Nome+"\t"+NumcartaoCidadao);
//				}
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