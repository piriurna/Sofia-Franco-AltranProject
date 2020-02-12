package application;

import application.models.colaborador.ColaboradorDAO;

public class Main {
	
	public static void main(String args[]){ 
	try{  
		System.out.println(ColaboradorDAO.getColaboradores());
		  
		}catch(Exception e){ 
			System.out.println(e);
		}  
	}
}
