package altran.mavencolaborador.controller.colaborador;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class LoginController implements Serializable{

	private static final long serialVersionUID = -6867509601018950973L;

	public void login() {
		//Pegar os campos username e password e buscar na base de dados
	}
}
