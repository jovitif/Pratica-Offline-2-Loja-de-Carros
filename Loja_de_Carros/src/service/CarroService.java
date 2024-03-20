package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Carro;
import entity.Categoria;

//interface do objeto do servidor
public interface CarroService extends Remote{

    List<Carro> listarCarros() throws RemoteException;
	//adicionar um carro
    String adicionarCarro(long renavam, String nome, double preco, Categoria categoria, int ano) throws RemoteException;
	//alterar atributos de carro
    Carro editarCarro(long renavam, String nome, double preco, Categoria categoria, int ano) throws RemoteException;
	Carro buscarRenavam(long renavam) throws RemoteException;
	int QntCarro() throws RemoteException;

	void removerCarro(long renavam)throws RemoteException;

	
	
	
}
