package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Carro;
import entity.Permissao;
import entity.Usuario;

public interface UsuarioService extends Remote {
	Usuario autenticado(String login, String senha) throws RemoteException;
	Usuario cadastrado(String login, String senha, Permissao permissao) throws RemoteException;
	Usuario comprarCarro(Carro carro, String comprador)throws RemoteException;
}
