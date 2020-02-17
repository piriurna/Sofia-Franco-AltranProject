package altran.mavencolaborador.models.user;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import altran.mavencolaborador.DBConnector;

public class UserBean {	
	private static DBConnector dbConnector = DBConnector.getConnector();
	
	public static ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<>();
		Connection conn = null;
		conn = dbConnector.getConnection();
		String sql = "SELECT * FROM Users";
		try (Statement stat = conn.createStatement(); ResultSet rs = stat.executeQuery(sql)) {
			while(rs.next()) {
				String username = rs.getString(1);
				users.add(new User(0, username));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
	
	public static boolean login(String username, String password) {	
		Connection conn = null;
		conn = dbConnector.getConnection();
		String sql = "{ CALL LOGIN(?,?,?) }";
		try (CallableStatement stat = conn.prepareCall(sql)) {			
			stat.registerOutParameter(3, Types.VARCHAR);
			
			stat.setString(1, username);
			stat.setString(2, password);
			
			stat.execute();
			
			System.out.println("ID DE SESSAO: " + stat.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public static boolean register(User user, String password) {
		if(alreadyRegistered(user.getUsername())) return false;
		System.out.println("User nao existe, iniciando criação");
		boolean success = false;
		Connection conn = null;
		conn = dbConnector.getConnection();
		String sql = "INSERT INTO Users VALUES (" + "69," + "?, ?)";
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setString(1, user.getUsername());
			stat.setString(2, password);
			stat.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	private static boolean alreadyRegistered(String username) {
		Connection conn = null;
		conn = dbConnector.getConnection();
		String sql = "SELECT * FROM Users WHERE username= ?";
		ResultSet rs = null;
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setString(1, username);
			rs = stat.executeQuery();
			if(rs.next()) {
				System.out.println("User ja existe");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
