package model.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsuarioBO {
	public static boolean validarSenha(String senha, String senha2) {
		if(senha.equals(senha2))
			return true;
		return false;
	}
	
	public static boolean validarSenha(String senha) {
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
  
        Pattern p = Pattern.compile(regex);
 
 
        Matcher m = p.matcher(senha);
        
        if(m.matches()) {
        	return true;
        }else {
        	return false;
        }
	}
}
