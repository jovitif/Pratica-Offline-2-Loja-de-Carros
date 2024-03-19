package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String senha;
	private String login;
	private Permissao permissao;
	private List<Carro> carros;

	
	public Usuario(String login, String senha, Permissao permissao) {
		this.login = login;
		this.senha = senha;
		this.setPermissao(permissao);
		this.carros = new ArrayList<Carro>();
	}
	
	
	public List<Carro> getCarros() {
		return carros;
	}
	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	 public void adicionarCarro(Carro carro) {
	        carros.add(carro);
	    }
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}


	@Override
	public String toString() {
		String menuUsuario = "Seja bem-vindo " + login + "\n";
		menuUsuario = menuUsuario + "Nível de acesso: ";
		if(permissao.equals(permissao.funcionario)) {
			menuUsuario = menuUsuario + "funcionário\n";
		}else {
			menuUsuario = menuUsuario + "cliente\n";
		}
		menuUsuario = menuUsuario + "Lista de carros: " + carros + "\n";
		return menuUsuario;
	}


	public Permissao getPermissao() {
		return permissao;
	}


	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
	
	
}
