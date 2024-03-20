package Carros;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CarroInterface extends Remote{
    List<Carro> listarCarros() throws RemoteException;
    Carro adicionarCarro(long renavam, String nome, double preco, Categoria categoria, int ano) throws RemoteException;
    Carro editarCarro(long renavam, String nome, double preco, Categoria categoria, int ano) throws RemoteException;
	Carro buscarRenavam(long renavam) throws RemoteException;
	int QntCarro() throws RemoteException;
	Carro removerCarro(long renavam)throws RemoteException;
}
