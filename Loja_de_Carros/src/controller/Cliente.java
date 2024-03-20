package controller;

import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entity.Carro;
import entity.Categoria;
import entity.Permissao;
import entity.Usuario;
import service.CarroService;
import service.UsuarioService;

public class Cliente {
	static Usuario user;
	static String login;
	static String senha;
	static boolean atualizado = true;
	static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
	static int portaAuth = 50005;
	static int portaCarro = 50006;

	public static void menuLogin() {
		System.out.print("Digite seu login:");
		login = scanner.next();
		System.out.print("Digite a sua senha:");
		senha = scanner.next();
		conectar();
	}

	public static void conectar() {
		config();
		try {
			Registry registro = LocateRegistry.getRegistry("localhost", portaAuth);
			UsuarioService stubObjRemotoCliente = (UsuarioService) registro.lookup("UsuarioService");
			user = stubObjRemotoCliente.autenticado(login, senha);
			if (user != null) {
				if (user.getPermissao().equals(Permissao.funcionario)) {
					menuFuncionario(atualizado);
				} else {
					menuCliente(atualizado);
				}
			} else {
				System.out.println("Falha ao autenticar. Verifique suas credenciais e tente novamente.");
				menuLogin();
			}
			scanner.close();
		} catch (java.rmi.ConnectException e) {
			System.err.println(
					"Não foi possível conectar ao servidor. Verifique se o servidor está em execução e tente novamente.");
		} catch (Exception e) {
			System.err.println("Ocorreu um erro inesperado durante a autenticação.");
			e.printStackTrace();
		}

	}

	private static void config() {
		System.setProperty("java.security.policy", "java.policy");
	}

	public static void listar() {
		try {
			Registry registro = LocateRegistry.getRegistry("localhost", portaCarro);
			CarroService stubObjRemotoCliente = (CarroService) registro.lookup("CarroService");
			List<Carro> listaCarros = stubObjRemotoCliente.listarCarros();
			for (Carro carro : listaCarros) {
				System.out.println(carro.toString());
			}
		} catch (Exception e) {
			System.err.println("Erro ao listar carros: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println();
	}

	public static Carro buscar(long renavam) {
		try {
			Registry registro = LocateRegistry.getRegistry("localhost", portaCarro);
			CarroService stubObjRemotoCliente = (CarroService) registro.lookup("CarroService");
			Carro buscado = stubObjRemotoCliente.buscarRenavam(renavam);
			return buscado;
		} catch (Exception e) {
			System.err.println("Erro ao buscar carro: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public static void quantidade() {
		try {
			Registry registro = LocateRegistry.getRegistry("localhost", portaCarro);
			CarroService stubObjRemotoCliente = (CarroService) registro.lookup("CarroService");
			System.out.println("\nO sistema possui " + stubObjRemotoCliente.QntCarro() + " carros\n");
		} catch (Exception e) {
			System.err.println("Erro ao buscar carro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void comprar() {
		try {
			listar();
			System.out.print("Digite o renavam do carro que deseja comprar: ");
			long renavam = scanner.nextLong();
			Carro comprado = buscar(renavam);
			Registry registro = LocateRegistry.getRegistry("localhost", portaAuth);
			UsuarioService stubObjRemotoCliente2 = (UsuarioService) registro.lookup("UsuarioService");
			stubObjRemotoCliente2.comprarCarro(comprado, user.getLogin());
			remover(renavam);
			conectar();
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida. Por favor, insira apenas números.");
			scanner.next();
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public static void adicionar() {
	    System.out.print("\nDigite o número do Renavam:");
	    long renavam = scanner.nextLong();
	    scanner.nextLine();
	    System.out.print("Digite o nome do carro:");
	    String nome = scanner.nextLine();
	    System.out.print("Digite o preço em R$ do carro:");
	    double preco = lerPrecoFormatado();
	    System.out.print("Digite o ano de fabricação do carro:");
	    int ano = scanner.nextInt();
	    System.out.print("Qual é a categoria do carro (?)\n[1] Economico\n[2] Intermediario\n[3] Executivo\nOpção:");
	    int opcao = scanner.nextInt();
	    Categoria categoria = null;
	    switch (opcao) {
	        case 1:
	            categoria = Categoria.economico;
	            break;
	        case 2:
	            categoria = Categoria.intermediario;
	            break;
	        case 3:
	            categoria = Categoria.executivo;
	            break;
	        default:
	            System.out.println("Opção invalida");
	            adicionar();
	    }
	    try {
	        Registry registro = LocateRegistry.getRegistry("localhost", portaCarro);
	        CarroService stubObjRemotoCliente = (CarroService) registro.lookup("CarroService");
	        String saida = stubObjRemotoCliente.adicionarCarro(renavam, nome, preco, categoria, ano);
	        System.out.println(saida);
	    } catch (Exception e) {
	        System.err.println("Erro ao buscar carro: " + e.getMessage());
	        e.printStackTrace();
	    }
	}


	private static double lerPrecoFormatado() {
		while (true) {
			try {
				return scanner.nextDouble();
			} catch (InputMismatchException e) {
				System.out.print("Formato de preço inválido. Digite novamente:");
				scanner.next();
			}
		}
	}

	public static void remover(long renavam) {
		try {
			Registry registro = LocateRegistry.getRegistry("localhost", portaCarro);
			CarroService stubObjRemotoCliente = (CarroService) registro.lookup("CarroService");
			Carro removido = stubObjRemotoCliente.removerCarro(renavam);
			if(removido !=null)
				System.out.println("Carro removido: " + removido);
			else
				System.out.println("\nCarro não encontrado\n");
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public static void menuFuncionario(boolean atualizado) throws NotBoundException {
		boolean opcaoValida = false;
		while (!opcaoValida) {
			try {
				if (atualizado) {
					System.out.println(user);
				}
				System.out.println("[1] Listar");
				System.out.println("[2] Pesquisar");
				System.out.println("[3] Exibir quantidade");
				System.out.println("[4] Comprar carro");
				System.out.println("[5] Adicionar carro");
				System.out.println("[6] Remover carro");
				System.out.println("[7] Editar carro");
				System.out.println("[8] Sair do sistema");
				System.out.print("Opção:");

				scanner = new Scanner(System.in);
				int opcao = scanner.nextInt();

				switch (opcao) {
				case 1:
					listar();
					atualizado = false;
					menuFuncionario(atualizado);
					break;
				case 2:
					System.out.print("Digite o renavam:");
					long renavam = scanner.nextLong();
					if (buscar(renavam) != null)
						System.out.println(buscar(renavam));
					else
						System.out.println("\nCarro não encontrado\n");
					atualizado = false;
					menuFuncionario(atualizado);

					break;
				case 3:
					quantidade();
					atualizado = false;
					menuFuncionario(atualizado);
					break;
				case 4:
					comprar();
					atualizado = true;
					menuFuncionario(atualizado);
					break;
				case 5:
					adicionar();
					atualizado = false;
					menuFuncionario(atualizado);
					break;
				case 6:
					System.out.print("Digite o renavam do carro que deseja remover: ");
					renavam = scanner.nextLong();
					remover(renavam);
					atualizado = false;
					menuFuncionario(atualizado);
					break;
				case 7:
					editar();
					atualizado = false;
					menuFuncionario(atualizado);
					break;
				case 8:
					System.out.println("\nRealizando logout...\n");
					user = null;
					menuLogin();
					break;
				default:
					System.out.println("Opção inválida. Por favor, escolha uma opção válida de 1 a 8.");
					continue;
				}

				atualizado = false;
				opcaoValida = true;

			} catch (InputMismatchException e) {
				System.out.println("\nEntrada inválida. Por favor, insira apenas números.\n");
				scanner.next();
			} catch (Exception e) {
				System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	private static void editar() {
		System.out.print("Digite o renavam do carro que deseja editar:");
		long renavam = scanner.nextLong();
		scanner.nextLine();

		try {
			System.out.println("buscando por renavam...\n");
			Registry registro = LocateRegistry.getRegistry("localhost", portaCarro);
			CarroService stubObjRemotoCliente = (CarroService) registro.lookup("CarroService");
			Carro buscado = stubObjRemotoCliente.buscarRenavam(renavam);
			if (buscado != null) {
				System.out.println(buscado);
				System.out.print("Digite o nome do carro:");
				String nome = scanner.nextLine();
				System.out.print("Digite o preço em R$ do carro:");
				double preco = lerPrecoFormatado();
				System.out.print("Digite o ano de fabricação do carro:");
				int ano = scanner.nextInt();
				System.out.print(
						"Qual é a categoria do carro (?)\n[1] Economico\n[2] Intermediario\n[3] Executivo\nOpção:");
				int opcao = scanner.nextInt();
				Categoria categoria = null;
				switch (opcao) {
				case 1:
					categoria = Categoria.economico;
					break;
				case 2:
					categoria = Categoria.intermediario;
					break;
				case 3:
					categoria = Categoria.executivo;
					break;
				default:
					System.out.println("Opção invalida");
					editar();
				}
				Carro editado = stubObjRemotoCliente.editarCarro(renavam, nome, preco, categoria, ano);
				if (editado != null)
					System.out.println("Carro editado\n" + editado);
				else
					System.out.println("O carro não pode ser editado\n");
			} else
				System.out.println("O renavam digitado não foi registado em nenhum carro.\n");
		} catch (Exception e) {
			System.err.println("Erro ao buscar carro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void menuCliente(boolean atualizado) throws NotBoundException {
		boolean opcaoValida = false;

		while (!opcaoValida) {
			try {
				if (atualizado) {
					System.out.println(user);
				}
				System.out.println("Deseja realizar quais operações ?");
				System.out.println("[1] Listar");
				System.out.println("[2] Pesquisar");
				System.out.println("[3] Exibir quantidade");
				System.out.println("[4] Comprar carro");
				System.out.println("[5] Sair do sistema");
				System.out.print("Opção:");

				scanner = new Scanner(System.in);
				int opcao = scanner.nextInt();

				switch (opcao) {
				case 1:
					listar();
					atualizado = false;
					menuCliente(atualizado);
					break;
				case 2:
					System.out.print("Digite o renavam:");
					long renavam = scanner.nextLong();
					if (buscar(renavam) != null)
						System.out.println(buscar(renavam));
					else
						System.out.println("\nCarro não encontrado\n");
					atualizado = false;
					menuCliente(atualizado);

					break;
				case 3:
					quantidade();
					atualizado = false;
					menuCliente(atualizado);

					break;
				case 4:
					comprar();
					atualizado = true;
					menuCliente(atualizado);
					break;
				case 5:
					System.out.println("\nRealizando logout...\n");
					user = null;
					menuLogin();
					break;
				default:
					System.out.println("Opção inválida. Por favor, escolha uma opção válida de 1 a 5.");
					continue; // Volta para o início do loop
				}

				opcaoValida = true;

			} catch (InputMismatchException e) {
				System.out.println("\nEntrada inválida. Por favor, insira apenas números.");
				// Limpa o buffer do scanner
				scanner.next();
			} catch (Exception e) {
				System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		menuLogin();
	}
}