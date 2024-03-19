package controller;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Scanner;

import entity.Carro;
import entity.Permissao;
import entity.Usuario;
import service.CarroService;
import service.UsuarioService;


public class Cliente {
	static Usuario user;
	static String login;
	static boolean atualizado = true;
	static String senha;
    private static Scanner scanner = new Scanner(System.in);
	static int porta = 50005;
	
	public static void menuInicial() {
		System.out.print("Digite seu login:");
		login = scanner.next();
		System.out.print("Digite a sua senha:");
		senha = scanner.next();
		conectar();
	}
	
	public static void conectar() {
		config();
		try {
			Registry registro = LocateRegistry.getRegistry("localhost", porta);

			UsuarioService stubObjRemotoCliente = (UsuarioService) registro.lookup("UsuarioService");
			user = stubObjRemotoCliente.autenticado(login, senha);

			if (user != null) {
				if (user.getPermissao().equals(Permissao.funcionario)) {
					menuFuncionario();

				} else {
					menuCliente();
				}
			} else {
				System.out.println("Falha ao autenticar");
			}

			scanner.close();
		} catch (Exception e) {
			System.err.println("Cliente: " + e.toString());
			e.printStackTrace();
		}
	}
	
	private Cliente() {
	}

	private static void config() {
		System.setProperty("java.security.policy", "java.policy");
	}

	public static void listar() {
		try {
			System.out.println("listando...");
			Registry registro = LocateRegistry.getRegistry("localhost", 50006);
			CarroService stubObjRemotoCliente = (CarroService) registro.lookup("CarroService");

			List<Carro> listaCarros = stubObjRemotoCliente.listarCarros();
			for (Carro carro : listaCarros) {
				System.out.println(carro.toString());
			}
		} catch (Exception e) {
			System.err.println("Erro ao listar carros: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void buscar() {
		System.out.print("Digite o renavam:");
		int renavam = scanner.nextInt();
		try {
			System.out.println("buscando por renavam...");
			Registry registro = LocateRegistry.getRegistry("localhost", 50006);
			CarroService stubObjRemotoCliente = (CarroService) registro.lookup("CarroService");
			System.out.println(stubObjRemotoCliente.buscarRenavam(renavam));
		} catch (Exception e) {
			System.err.println("Erro ao buscar carro: " + e.getMessage());
			e.printStackTrace();
		}	
	}
	
	public static void quantidade() {
		try {
			Registry registro = LocateRegistry.getRegistry("localhost", 50006);
			CarroService stubObjRemotoCliente = (CarroService) registro.lookup("CarroService");
			System.out.println("O sistema possui " + stubObjRemotoCliente.QntCarro() + " carros");
		} catch (Exception e) {
			System.err.println("Erro ao buscar carro: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void comprar() {
		try {
			Registry registro = LocateRegistry.getRegistry("localhost", 50006);
			CarroService stubObjRemotoCliente = (CarroService) registro.lookup("CarroService");
			List<Carro> listaCarros = stubObjRemotoCliente.listarCarros();
			for (Carro carro : listaCarros) {
				System.out.println(carro.toString());
			}
			System.out.print("Digite o renavam do carro que deseja comprar: ");
			int renavam = scanner.nextInt();
			Carro comprado = stubObjRemotoCliente.buscarRenavam(renavam);
			UsuarioService stubObjRemotoCliente2 = (UsuarioService) registro.lookup("UsuarioService");
			stubObjRemotoCliente2.comprarCarro(comprado, user.getLogin());
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	public static void adicionar() {
		
	}
	
	public static void remover() {
		try {
			Registry registro = LocateRegistry.getRegistry("localhost", 50006);
			CarroService stubObjRemotoCliente = (CarroService) registro.lookup("CarroService");
			List<Carro> listaCarros = stubObjRemotoCliente.listarCarros();
			for (Carro carro : listaCarros) {
				System.out.println(carro.toString());
			}
			System.out.print("Digite o renavam do carro que deseja remover: ");
			int renavam = scanner.nextInt();
			stubObjRemotoCliente.removerCarro(renavam);
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	public static void menuFuncionario() throws NotBoundException {
		if(atualizado == true) {
			System.out.println(user);	
		}
		System.out.println("Deseja realizar quais operações ?");
		System.out.println("[1] Listar");
		System.out.println("[2] Pesquisar");
		System.out.println("[3] Exibir quantidade");
		System.out.println("[4] Comprar carro");
		System.out.println("[5] add carro");
		System.out.println("[6] remover carro");
		System.out.println("[7] editar carro");
		System.out.println("[8] Sair do sistema");
		System.out.print("OPÇÃO=");
		Scanner scanner = new Scanner(System.in);
		int opcao = scanner.nextInt();
		switch (opcao) {
		case 1:
			listar();
			menuFuncionario();
			break;
		case 2:
			buscar();
			menuFuncionario();
			break;
		case 3:
			quantidade();
			menuFuncionario();
			break;
		case 4:	
			comprar();
			menuFuncionario();
			break;
		case 5:
			adicionar();
			menuFuncionario();
			break;
		case 6:
			remover();	
			menuFuncionario();
			break;
		case 7:
			editar();
			menuFuncionario();
			break;
		case 8:
			System.out.println("Realizando logout...");
			user = null;
			menuInicial();
			break;
		default:
			System.out.println("Nenhuma opção valida foi digitada...");
		}
	}

	private static void editar() {
		// TODO Auto-generated method stub
		
	}

	public static void menuCliente() throws NotBoundException {
		if(atualizado == true) {
			System.out.println(user);	
		}
		System.out.println("Deseja realizar quais operações ?");
		System.out.println("[1] Listar");
		System.out.println("[2] Pesquisar");
		System.out.println("[3] Exibir quantidade");
		System.out.println("[4] Comprar carro");
		System.out.println("[5] Sair do sistema");
		System.out.print("OPÇÃO=");
		Scanner scanner = new Scanner(System.in);
		int opcao = scanner.nextInt();
		switch (opcao) {
		case 1:
			listar();
			menuCliente();
			break;
		case 2:
			buscar();
			menuCliente();
			break;
		case 3:
			quantidade();
			menuCliente();
			break;
		case 4:	
			comprar();
			menuCliente();
			break;
		case 5:
			System.out.println("Realizando logout...");
			user = null;
			menuCliente();
			break;
			
		default:
			System.out.println("Nenhuma opção valida foi digitada...");
		}
	}


	public static void main(String[] args) {
		menuInicial();
	}
}
