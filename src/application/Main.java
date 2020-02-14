package application;

import java.sql.Date;

import application.models.colaborador.Colaborador;
import application.models.colaborador.ColaboradorDAO;

public class Main {
	
	public static void main2(String args[]){ 
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
		}catch(Exception e){ 
			System.out.println(e);
		}  
	}
}
