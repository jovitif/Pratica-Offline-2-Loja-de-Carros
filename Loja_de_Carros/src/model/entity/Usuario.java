package model.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {
	private String login;
	private String senha;
	
	public Usuario(String login, String senha) {
		setLogin(login);
		setSenha(senha);
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

	public static void main(String []args) {
		Usuario user = new Usuario("joaosales","joaosales1234");
		System.out.println(user);
	}
}
