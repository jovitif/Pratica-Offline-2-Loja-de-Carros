package model.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BaseInterBO <VO> extends Remote{
	public boolean adicionar(VO vo) throws Exception, RemoteException;
	public VO buscarPorNome(VO vo) throws Exception, RemoteException;
	public VO buscarPorRenavam(VO vo) throws Exception, RemoteException;
	public List<VO> listar() throws Exception, RemoteException;
	public boolean atualizar(VO vo) throws Exception, RemoteException;
	public boolean apagar(VO vo) throws Exception, RemoteException;
	public void cadastrarUsuario(String login, String senha) throws RemoteException;
}
