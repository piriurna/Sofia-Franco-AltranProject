package application.models.colaborador;

import java.io.FileInputStream;
import java.sql.Date;

public class Colaborador {
	private String id, name, nId, address, cellphone,
		email;
	
	private Date birthday;
	
<<<<<<< HEAD

	
	public Colaborador() {}
	
	public Colaborador(String id, String name, String nId, String address,
			String cellphone, String email, String imagePath,String cvPath) {
		this.setId(id);
		this.setName(name);
=======
	private FileInputStream imagePath, cvPath;
	
	public Colaborador() {}
	
	public Colaborador(String id, String name,String address, String nId, Date birthday, 
			String email, String cellphone, FileInputStream imagePath, FileInputStream cvPath) {
		this.setId(id);
		this.setName(name);
		this.setBirthday(birthday);
>>>>>>> bf2edaff4af0776e3a53ae30d4f8f043142449a7
		this.setnId(nId);
		this.setAddress(address);
		this.setCellphone(cellphone);
		this.setEmail(email);
		this.setImagePath(imagePath);
		this.setCvPath(cvPath);
	}
	
	public void printInfo() {
		System.out.println(id);
		System.out.println(name);
		System.out.println(birthday);
		System.out.println(nId);
		System.out.println(address);
		System.out.println(cellphone);
		System.out.println(email);
		System.out.println(imagePath);
		System.out.println(cvPath);
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

	public FileInputStream getImagePath() {
		return imagePath;
	}

	public void setImagePath(FileInputStream imagePath) {
		this.imagePath = imagePath;
	}

	public FileInputStream getCvPath() {
		return cvPath;
	}

	public void setCvPath(FileInputStream cvPath) {
		this.cvPath = cvPath;
	}

<<<<<<< HEAD

=======
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
>>>>>>> bf2edaff4af0776e3a53ae30d4f8f043142449a7
	
}
