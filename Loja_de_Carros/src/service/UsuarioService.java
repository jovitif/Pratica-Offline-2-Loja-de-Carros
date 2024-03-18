package Pratica01.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Pratica01.entity.Carro;
import Pratica01.entity.Permissao;
import Pratica01.entity.Usuario;

public interface UsuarioService extends Remote {
	Usuario autenticado(String login, String senha) throws RemoteException;
	Usuario cadastrado(String login, String senha, Permissao permissao) throws RemoteException;
	Usuario comprarCarro(Carro carro, String comprador)throws RemoteException;
}
