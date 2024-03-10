package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Gateway {
	ServerSocket servidor;
	Socket cliente;
	ObjectInputStream entrada;
	ObjectOutputStream saida;
	int porta;

	Gateway(int porta){
		this.porta = porta;
		this.rodar();
	}
	
	private void rodar() {
		try {
			servidor = new ServerSocket(porta);
			System.out.println("Servidor iniciado na porta " + porta);
            cliente = servidor.accept();
            System.out.println("Conexao estabelecida com: " + cliente.getInetAddress().getHostAddress());


		} catch (IOException e) {
			System.out.println("Servidor já em uso: " + e);
			//e.printStackTrace();
		}
	}
	
	
	public static void main(String []args) {
		new Gateway(1993);

	}
}
