package application.models.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.DBConnector;

public class UserDAO {

	public static boolean login(String username, String password) {
		boolean connected = false;
		Connection conn = DBConnector.getConnection("", "", "");
		String sql = "";
		try (PreparedStatement stat = conn.prepareStatement(sql); ResultSet rs = stat.executeQuery()) {
			stat.setString(1, username);
			stat.setString(2, password);
			if(rs.next())
				connected = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connected;
	}
	
	public static boolean register(User user, String password) {
		if(alreadyRegistered(user.getUsername())) return false;
		boolean success = false;
		Connection conn = DBConnector.getConnection("", "", "");
		String sql = "  ";
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setString(1, user.getUsername());
			stat.setString(2, user.getName());
			stat.setString(3, password);
			stat.setString(4, user.getEmail());
			stat.setString(5, user.getCellphone());
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
		Connection conn = DBConnector.getConnection("", "", "");
		String sql = "  ";
		try (PreparedStatement stat = conn.prepareStatement(sql); ResultSet rs = stat.executeQuery()) {
			stat.setString(1, username);
			if(rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
