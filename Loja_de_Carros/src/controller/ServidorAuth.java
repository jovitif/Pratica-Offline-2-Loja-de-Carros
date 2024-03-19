package controller;

import entity.Carro;
import entity.Permissao;
import entity.Usuario;
import service.UsuarioService;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import java.util.ArrayList;
import java.util.List;

public class ServidorAuth implements UsuarioService {
    private List<Usuario> users;

    public ServidorAuth() {
        users = allUsers();
    }

    public static List<Usuario> allUsers() {
        List<Usuario> users = new ArrayList<>();
        users.add(new Usuario("joaosales", "@Joaosales1234", Permissao.funcionario));
        users.add(new Usuario("Tester", "#Tester1234", Permissao.cliente));
        users.add(new Usuario("Maria", "@Maria1234", Permissao.funcionario));
        users.add(new Usuario("Batman", "@Batman1234", Permissao.cliente));
        users.add(new Usuario("SeuBarriga", "@Barriguinha1234", Permissao.cliente));
        users.add(new Usuario("Francismo", "@Fran1234",Permissao.funcionario));
        return users;
    }
    
    @Override
	public Usuario cadastrado(String login, String senha, Permissao permissao) throws RemoteException {
		System.out.println("Cadastrando um usuário...");
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getLogin().equals(login))
				return null;
		}
		Usuario user = new Usuario(login, senha, permissao);
		users.add(user);
		return user;
	}

	@Override
	public Usuario comprarCarro(Carro carro, String comprador) throws RemoteException{
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getLogin().equals(comprador)) {
				users.get(i).adicionarCarro(carro);
				return users.get(i);
			}
		}
		return null;
	}

    
    @Override
    public Usuario autenticado(String login, String senha) throws RemoteException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login) && users.get(i).getSenha().equals(senha)) {
                return users.get(i);
            }
        }
        return null;
    }
}

