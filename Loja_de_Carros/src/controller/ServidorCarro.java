package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.dao.database.CarrosDatabase;
import model.entity.Carro;
import model.entity.Categoria;
import model.service.CarroBO;

public class ServidorCarro {
	private int porta;
	private String ip;
	private static List<Carro> carros;
	
	public ServidorCarro(int porta, String ip) {
		setPorta(porta);
		setIp(ip);
		carros = new ArrayList<>();
		this.rodar();
	}
	
	private void rodar() {
		
	}



	public int getPorta() {
		return porta;
	}
	public void setPorta(int porta) {
		this.porta = porta;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public static void main(String []args) {
		ServidorCarro server = new ServidorCarro(300,"");
		carros = CarrosDatabase.allCarros();
		
		carros.size();
		System.out.println(CarroBO.getQntCarros(carros));
		System.out.println(CarroBO.getAllByCategorie(Categoria.executivo, carros));
		System.out.println(CarroBO.GetQntCarrosByCategorie(Categoria.economico, carros));
		System.out.println(CarroBO.removeByName("execult", carros));
		System.out.println(CarroBO.getAllByCategorie(Categoria.executivo, carros));

	}
}
