package application.models.user;

public class User {

	private int id;
	private String name, username, email, cellphone;
	
	public User(int id, String name, String username, String email, String cellphone) {
		this.setName(name);
		this.setId(id);
		this.setUsername(username);
		this.setEmail(email);
		this.setCellphone(cellphone);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
