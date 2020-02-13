package application.models.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.DBConnector;

public class UserDAO {
	private static User loggedInUser = null;
	
	private static DBConnector dbConnector = DBConnector.getConnector();
	
	public static ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<>();
		Connection conn = dbConnector.getConnection();
		String sql = "SELECT * FROM Users";
		try (Statement stat = conn.createStatement(); ResultSet rs = stat.executeQuery(sql)) {
			while(rs.next()) {
				String username = rs.getString(1);
				users.add(new User(0, username, username, username, username));
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
		if(!alreadyRegistered(username)) return false;
		if(!passwordIsCorrect(username, password)) return false;
		
		setLoggedInUser(getUser(username));		
		return true;
	}
	
	private static boolean passwordIsCorrect(String username, String password) {
		boolean matches = false;
		Connection conn = dbConnector.getConnection();
		String sql = "SELECT COUNT(id) FROM Users WHERE  username= ? AND password = ?";
		ResultSet rs = null;
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setString(1, username);
			stat.setString(2, password);
			rs = stat.executeQuery();
			if(rs.next()) {
				matches = true;
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
		return matches;
	}

	private static User getUser(String username) {
		User user = null;
		Connection conn = dbConnector.getConnection();
		String sql = "SELECT id, name, email, cellphone  FROM Users WHERE  username= ?";
		ResultSet rs = null;
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setString(1, username);
			rs = stat.executeQuery();
			if(rs.next()) {
				int id = rs.getInt(1);
//				String name = rs.getString(2);
//				String email = rs.getString(3);
//				String cellphone = rs.getString(4);
				user = new User(id, null, username, null, null);
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
		return user;
	}
	
	public static boolean register(User user, String password) {
		if(alreadyRegistered(user.getUsername())) return false;
		boolean success = false;
		Connection conn = dbConnector.getConnection();
		String sql = "INSERT INTO Users VALUES (?, ?)";
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
		Connection conn = dbConnector.getConnection();
		String sql = "SELECT * FROM Users WHERE  username= ?";
		ResultSet rs = null;
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setString(1, username);
			rs = stat.executeQuery();
			if(rs.next())
				return true;
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

	public static User getLoggedInUser() {
		return loggedInUser;
	}

	public static void setLoggedInUser(User loggedInUser) {
		UserDAO.loggedInUser = loggedInUser;
	}
}
