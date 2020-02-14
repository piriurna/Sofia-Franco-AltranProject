package application;

import application.models.user.UserDAO;

public class Main2 {
	
	public static void main2(String args[]){ 
	try{  
		System.out.println(UserDAO.getAllUsers());
		}catch(Exception e){ 
			System.out.println(e);
		}  
	}
}
