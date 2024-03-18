package Pratica01.controller;

import java.nio.channels.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Pratica01.entity.Carro;
import Pratica01.entity.Categoria;
import Pratica01.entity.Usuario;
import Pratica01.service.CarroService;

public class ServidorCarros implements CarroService {
	List<Carro> carros;

	public ServidorCarros() {
		carros = allCarros();
	}
	 public static List<Carro> allCarros() {
	        List<Carro> carros = new ArrayList<>();
	        carros.add(new Carro(674829530,"Fiat Novo Uno",Categoria.economico,2017,61190.00));
	        carros.add(new Carro(518963027,"Chevrolet Onix",Categoria.economico,2021,58686.00));
	        carros.add(new Carro(742158369,"Ford Ka",Categoria.economico,2015, 39888.00));
	        carros.add(new Carro(305724186,"Hyundai HB20 1.6 Vision",Categoria.economico, 2021, 67500.00));
	        carros.add(new Carro(890314257,"Ford Ka Sedan SE 1.0 (Flex)",Categoria.intermediario,2019,52900.00));
	        carros.add(new Carro(467932801,"Chevrolet Onix Plus 1.0",Categoria.intermediario, 2023,90000.00));
	        carros.add(new Carro(623895741,"Renault Logan",Categoria.intermediario, 2023,64233.00));
	        carros.add(new Carro(189742503," Toyota Etios X Plus 1.5 AT",Categoria.intermediario, 2021,72940.00));
	        carros.add(new Carro(542619837,"Toyota Corolla Altis Hybrid Premium",Categoria.executivo, 2024, 198890.00));
	        carros.add(new Carro(376258914,"Honda Civic",Categoria.executivo, 2024, 259900.00));
	        carros.add(new Carro(908473621,"Chevrolet Cruze Sedan",Categoria.executivo,2023,149990.00));
	        carros.add(new Carro(215487630,"Ambition 2.0",Categoria.executivo, 2016,122730.00));


	        return carros;
	    }
	 
	  @Override
	    public List<Carro> listarCarros() throws RemoteException {
	        System.out.println("Listando carros...");
	        return carros; 
	    }
	@Override
	public Carro buscarRenavam(int renavam) throws RemoteException {
		for(int i = 0; i < carros.size();i++) {
			if(carros.get(i).getRenavam() == renavam)
				return carros.get(i);
		}
		return null;
	}
	@Override
	public int QntCarro() throws RemoteException {
		return carros.size();
	}
	@Override
	public void removerCarro(int renavam) throws RemoteException {
		for(int i = 0; i < carros.size(); i++) {
			if(carros.get(i).getRenavam() == renavam) {
				carros.remove(i);
			}
		}
	}

}
