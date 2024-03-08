package view;

import java.util.Scanner;

public class MenuView {
	public static void mostrarMenuInicial() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===================================================================");
		System.out.println("==================SEJA=BEM=VINDO=A=LOJA=DE=CARROS==================");
		System.out.println("===================================================================");
		System.out.println("\nPara acessar nossos serviços é necessário realizar o cadastro/login na aplicação!");
		System.out.println("Digite [L] para realizar LOGIN e [C] para realizar CADASTRO.");
		System.out.print("Opção Digitada: ");
		String opcao = scanner.next();
		
	}
	public static void main(String []args) {
		mostrarMenuInicial();
	}
}
