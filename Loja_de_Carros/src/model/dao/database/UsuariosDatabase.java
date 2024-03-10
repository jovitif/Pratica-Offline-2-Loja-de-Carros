package model.dao.database;

import java.util.ArrayList;
import java.util.List;

import model.entity.Permissao;
import model.entity.Usuario;

public class UsuariosDatabase {
	public static List<Usuario> allUsers() {
		List<Usuario> users = new ArrayList<>();
		users.add(new Usuario("joaosales","@Joaosales1234", Permissao.cliente));
		users.add(new Usuario("Tester","#Tester1234", Permissao.funcionario));
		users.add(new Usuario("Baria","@Maria1234", Permissao.funcionario));
		users.add(new Usuario("Batman","@Batman1234", Permissao.cliente));
		users.add(new Usuario("SeuBarriga","@Barriguinha1234", Permissao.cliente));
		return users;
	}
}
