package model.entity;

public class Usuario {
	private String login;
	private String senha;
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
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
		this.senha = senha;
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
