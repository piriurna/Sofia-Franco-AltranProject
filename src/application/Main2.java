package application;

import java.sql.Date;

import application.models.colaborador.Colaborador;
import application.models.colaborador.ColaboradorDAO;

public class Main2 {
	
<<<<<<< HEAD:src/application/Main2.java
	public static void main2(String args[]){ 
	try{  
		System.out.println(UserDAO.getAllUsers());
=======
	public static void main(String args[]){ 
	try{
		//Recupera e imprime os valores do colaborador
		ColaboradorDAO.getColaborador("1233").printInfo();
		
		//Retorna a lista de colaboradores
		System.out.println(ColaboradorDAO.getColaboradores());
		
		
		//Inserir ou modificar colaborador (Verificado atraves do cartaoDeCidadao)
		System.out.println("Numero de colaboradores modificados: " + 
					ColaboradorDAO.updateColaborador(
							new Colaborador("123","Teste", "addres67s", "1234",
									Date.valueOf("2020-05-04"), "email", "123456789", null, null)));
		
		//Deleta o colaborador com o cartaoCidadao Especificado
		ColaboradorDAO.deleteColaborador("1234");
>>>>>>> bf2edaff4af0776e3a53ae30d4f8f043142449a7:src/application/Main.java
		}catch(Exception e){ 
			System.out.println(e);
		}  
	}
}
