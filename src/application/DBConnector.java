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
	
	private String URL = "jdbc:oracle:thin:@10.12.3.101:1521:xe";
	private String USER = "system";
	private String PASS = "Pa$$word";

	public static DBConnector getConnector() {
		if (dbConnector == null)
			dbConnector = new DBConnector();
		return dbConnector;
	}

	public Connection getConnection() {
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
