package altran.mavencolaborador.models.user;

public class User {

	private int id;
	private String username;
	
	public User(int id, String username) {
		this.setId(id);
		this.setUsername(username);
	}
	
	public String toString() {
		return username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
