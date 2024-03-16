package controller;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import model.dao.database.UsuariosDatabase;
import model.entity.Usuario;

public class ServidorAuth {
	private static List<Usuario> users;
	Socket conexao;
	String ip;
	int porta;
	
	public ServidorAuth(int porta, String ip) {
		users = new ArrayList<>();
		this.porta = porta;
		this.ip = ip;
		this.rodar();
	}
	
	private void rodar() {
		try {
			conexao = new Socket(ip, porta);
			System.out.println("Conectado ao servidor " + ip + ", na porta: " + porta);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void main(String []args) {
		users = UsuariosDatabase.allUsers();
		System.out.println(users.toString());
		new ServidorAuth(1993, "127.0.0.2");
	}
}
