package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Carro;

//interface do objeto do servidor
public interface CarroService extends Remote{

    List<Carro> listarCarros() throws RemoteException;
	//adicionar um carro
	//apagar um carro
	//listar carros
	//pesquisar (consultar) carro
	//alterar atributos de carro
	//atualizar listagem de carros enviados aos clientes conectados
	//exibir quantidade de carros

	Carro buscarRenavam(int renavam) throws RemoteException;
	int QntCarro() throws RemoteException;

	void removerCarro(int renavam)throws RemoteException;

	
	
	
}
