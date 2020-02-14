package application.models.colaborador;

public class Colaborador {
	private String id, name, nId, address, cellphone,
		email, imagePath, cvPath;
	

	
	public Colaborador() {}
	
	public Colaborador(String id, String name, String nId, String address,
			String cellphone, String email, String imagePath,String cvPath) {
		this.setId(id);
		this.setName(name);
		this.setnId(nId);
		this.setAddress(address);
		this.setCellphone(cellphone);
		this.setEmail(email);
		this.setImagePath(imagePath);
		this.setCvPath(cvPath);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return getName();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getnId() {
		return nId;
	}

	public void setnId(String nId) {
		this.nId = nId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getCvPath() {
		return cvPath;
	}

	public void setCvPath(String cvPath) {
		this.cvPath = cvPath;
	}


	
}
