package model.service;

public class UsuarioBO {
	public static boolean validarSenha(String senha, String senha2) {
		if(senha.equals(senha2))
			return true;
		return false;
	}
}
