package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

import model.service.UsuarioBO;

public class Cliente {
	public static Scanner scanner = new Scanner(System.in);

	public Cliente() {
		
	}

	 public static void mostrarMenuInicial() {
	        System.out.println("Seja bem vindo a loja de carros");
	        System.out.println("Deseja se cadastrar no sistema [1] ou realizar login [2] ou fechar[0]?");
	        System.out.print("Escolha: ");
	        short escolha;
	        escolha = scanner.nextShort();
	        if (escolha == 1) {
	            System.out.print("Digite o login: ");
	            String login = scanner.next();
	            System.out.print("Digite a senha: ");
	            String senha = scanner.next();
	            System.out.print("Repita a senha: ");
	            String repitaSenha = scanner.next();
	            if (senha.equals(repitaSenha)) {
	                
	                 //   usuarioService.cadastrarUsuario(login, senha);
	                    System.out.println("Usuário cadastrado com sucesso!");
	              
	            } else {
	                System.out.println("As senhas não coincidem.");
	            }
	        } else if (escolha == 2) {
	            System.out.print("Digite o login: ");
	            String login = scanner.next();
	            System.out.print("Digite a senha: ");
	            String senha = scanner.next();
	            // Realizar login
	        } else {
	            System.out.println("Nenhum foi selecionado");
	        }
	    }

	public static void main(String[] args) {
		
	}
}
