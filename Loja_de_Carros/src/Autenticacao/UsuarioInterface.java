package Autenticacao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Carros.Carro;

public interface UsuarioInterface extends Remote {
	Usuario autenticado(String login, String senha) throws RemoteException;
	Usuario comprarCarro(Carro carro, String comprador)throws RemoteException;
}