package view;

import java.util.Scanner;

import model.service.UsuarioBO;

public class CadastroView {
	public static void mostrarCadastroView() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite as informações do usuario:");
		System.out.print("Digite o login:");
		String login = scanner.nextLine();
		System.out.print("Digite a senha:");
		String senha = scanner.nextLine();
		System.out.print("Digite a senha novamente:");
		String senha2 = scanner.nextLine();
		if(UsuarioBO.validarSenha(senha, senha2)) {
			
		}
	}
}
