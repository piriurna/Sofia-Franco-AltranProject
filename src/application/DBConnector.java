package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DBConnector {
	private Connection conn;
	private Statement stat;
	
	private DBConnector() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			stat = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DBConnector dbConnector = new DBConnector();
	
	private String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String USER = "system";
<<<<<<< HEAD
	private String PASS = "Pa$$word";
=======
	private String PASS = "Angelarm210526@";
>>>>>>> bf2edaff4af0776e3a53ae30d4f8f043142449a7

	public static DBConnector getConnector() {
		if (dbConnector == null)
			dbConnector = new DBConnector();
		return dbConnector;
	}

	public Connection getConnection() {
		try {
		if(conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection(URL, USER, PASS);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public Statement createStatement() throws SQLException {
		return conn.createStatement();
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		return stat.executeQuery(sql);
	}
}
