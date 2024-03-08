package model.entity;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {
	private String login;
	private String senha;
	private Permissao permissao;
	private List<Carro> carros;
	
	public Usuario(String login, String senha) {
		setLogin(login);
		setSenha(senha);
		setPermissao(Permissao.cliente);
		setCarros(null);
	}
	
	
	
	public List<Carro> getCarros() {
		return carros;
	}



	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}



	public Permissao getPermissao() {
		return permissao;
	}



	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}



	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
  
        Pattern p = Pattern.compile(regex);
 
 
        Matcher m = p.matcher(senha);
        
        if(m.matches()) {
        	this.senha = senha;
        }else {
        	System.out.println("Senha Inválida");
        }
	}
	
	@Override
	public String toString() {
		return "Login: " + login + "\nSenha: " + senha;
	}

}
