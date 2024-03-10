package model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {
	private String login;
	private String senha;
	private Permissao permissao;
	private List<Carro> carros;
	
	
	public Usuario(String login, String senha, Permissao permissao) {
		setLogin(login);
		setSenha(senha);
		setPermissao(permissao);
		carros = new ArrayList<>();
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
       this.senha = senha;
	}





	@Override
	public String toString() {
		String info = "\n\nINFORMAÇÕES DO USUARIO:\nLogin: " + login + "\nSenha: " + senha + "\nTipo: " + permissao + "\nCarros: " + carros.toString();
	
		return info;
	}
	
	public static void main(String []args) {
	
	}
}
