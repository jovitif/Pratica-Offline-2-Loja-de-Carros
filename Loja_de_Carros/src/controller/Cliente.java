package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import model.service.UsuarioBO;

public class Cliente {
	ObjectOutputStream saida;
	ObjectInputStream entrada;
	int porta;
	String ip;
	Socket conexao;
	public static Scanner scanner = new Scanner(System.in);

	public Cliente(int porta, String ip) {
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

	public static void mostrarMenuInicial() {
		System.out.println("Seja bem vindo a loja de carros");
		System.out.println("Deseja se cadastrar no sistema [1] ou realizar login [2] ou fechar[0]?");
		System.out.print("Escolha");
		short escolha;
		escolha = scanner.nextShort();
		if (escolha == 1) {
			System.out.print("Digite o login:");
			String login = scanner.next();
			System.out.print("Digite a senha:");
			String senha = scanner.next();
			System.out.print("Repita a senha:");
			String repitaSenha = scanner.next();
			if (UsuarioBO.validarSenha(senha) && UsuarioBO.validarSenha(senha, repitaSenha)) {
				new Cliente(1993, "127.0.0.1");
			} else {
				System.out.println("Usuario não cadastrado");

			}
		}
	}

	public static void main(String[] args) {
		mostrarMenuInicial();

	}
}
