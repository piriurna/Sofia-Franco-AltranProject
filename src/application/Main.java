package application;

import application.models.user.UserDAO;

public class Main {
	
	public static void main(String args[]){ 
	try{  
		System.out.println(UserDAO.getAllUsers());
		}catch(Exception e){ 
			System.out.println(e);
		}  
	}
}
