package controller;

import java.util.Scanner;

import model.service.UsuarioBO;

public class Cliente {
	public static Scanner scanner = new Scanner(System.in);
	public static void mostrarMenuInicial() {
		System.out.println("Seja bem vindo a loja de carros");
		System.out.println("Deseja se cadastrar no sistema [1] ou realizar login [2] ou fechar[0]?");
		System.out.print("Escolha");
		short escolha;
		escolha = scanner.nextShort();
		if(escolha == 1) {
			System.out.print("Digite o login:");
			String login = scanner.next();
			System.out.print("Digite a senha:");
			String senha = scanner.next();
			System.out.print("Repita a senha:");
			String repitaSenha = scanner.next();
			if(UsuarioBO.validarSenha(senha) && UsuarioBO.validarSenha(senha, repitaSenha)) {
				System.out.println("Usuario cadastrado");
			}else {
				System.out.println("Usuario não cadastrado");

			}
		}
	}
	
	public static void main(String []args) {
		mostrarMenuInicial();
	}
}
