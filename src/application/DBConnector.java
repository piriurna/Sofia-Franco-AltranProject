package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnector {
	
	private static Connection conn;
	
	public static Connection getConnection(String USER, String PASS, String URL) {
		try {
			if(conn == null)
				conn = DriverManager.getConnection(USER, PASS, URL);
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return conn;
	}
}
