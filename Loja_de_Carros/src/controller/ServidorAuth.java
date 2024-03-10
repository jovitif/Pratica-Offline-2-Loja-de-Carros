package controller;

import java.util.ArrayList;
import java.util.List;

import model.dao.database.UsuariosDatabase;
import model.entity.Usuario;

public class ServidorAuth {
	private static List<Usuario> users;
	
	public ServidorAuth() {
		users = new ArrayList<>();
	}
	public static void main(String []args) {
		users = UsuariosDatabase.allUsers();
		System.out.println(users.toString());
	}
}
