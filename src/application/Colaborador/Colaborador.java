package application.colaborador;

public class Colaborador {
	String name, nId, address, cellphone,
		email, imagePath, cvPath;
	
	TipoId tipoId;
	
	public Colaborador() {}
	
	public Colaborador(String name, TipoId tipoId, String nId, String address,
			String cellphone, String email, String imagePath,String cvPath) {
		this.name = name;
		this.tipoId = tipoId;
		this.nId = nId;
		this.address = address;
		this.cellphone = cellphone;
		this.email = email;
		this.imagePath = imagePath;
		this.cvPath = cvPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getN_id() {
		return nId;
	}

	public void setN_id(String n_id) {
		this.nId = n_id;
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
