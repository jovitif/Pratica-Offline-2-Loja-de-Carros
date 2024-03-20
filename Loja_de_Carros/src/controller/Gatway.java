package controller;

import java.awt.geom.GeneralPath;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import service.CarroService;
import service.UsuarioService;

public class Gatway {
	private static final int PORTA_AUTH = 50005;
	private static final int PORTA_CARRO = 50006;

	public static void config() {
		System.setProperty("java.rmi.server.hostname", "127.0.0.1");
		System.setProperty("java.security.policy", "java.policy");

	}
	
	private static void init() {
		config();
		try {
			ServidorAuth servidorAuth = new ServidorAuth();
			UsuarioService skeletonAuth = (UsuarioService) UnicastRemoteObject.exportObject(servidorAuth, 0);
			LocateRegistry.createRegistry(PORTA_AUTH);
			Registry registroAuth = LocateRegistry.getRegistry(PORTA_AUTH);
			registroAuth.bind("UsuarioService", skeletonAuth);
			System.out.println("ServidorAuth pronto na porta " + PORTA_AUTH);

			ServidorCarros servidorCarro = new ServidorCarros();
			CarroService skeletonCarro = (CarroService) UnicastRemoteObject.exportObject(servidorCarro, 0);
			LocateRegistry.createRegistry(PORTA_CARRO);
			Registry registroCarro = LocateRegistry.getRegistry(PORTA_CARRO);
			registroCarro.bind("CarroService", skeletonCarro);
			System.out.println("ServidorCarro pronto na porta " + PORTA_CARRO);

			System.out.println("Servidores prontos.");
		} catch (Exception e) {
			System.err.println("Erro ao iniciar os servidores: " + e.getMessage());
			e.printStackTrace();
		}
	}
	


	public static void main(String[] args) {
		init();
	}
}