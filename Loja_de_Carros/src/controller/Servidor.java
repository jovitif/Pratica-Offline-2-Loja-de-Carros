package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entity.Carro;
import model.entity.Categoria;
import model.service.CarroBO;

public class Servidor {
	private int porta;
	private String ip;
	private static List<Carro> carros;
	
	public Servidor(int porta, String ip) {
		setPorta(porta);
		setIp(ip);
		carros = new ArrayList<>();
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
		Servidor server = new Servidor(300,"");
		Carro car = new Carro(1224, "fiat novo uno", Categoria.economico,  LocalDate.of(2099, 04, 25), 122, 100.00);
		Carro car2 = new Carro(1224, "chevrolet onix", Categoria.economico,  LocalDate.of(2099, 04, 25), 122, 100.00);
		Carro car3 = new Carro(1224, "chevrolet onix", Categoria.economico,  LocalDate.of(2099, 04, 25), 122, 100.00);
		Carro car4 = new Carro(1224, "execult", Categoria.executivo,  LocalDate.of(2099, 04, 25), 122, 100.00);

		carros.add(car);
		carros.add(car2);
		carros.add(car3);
		carros.add(car4);
		carros.size();
		System.out.println(CarroBO.getQntCarros(carros));
		System.out.println(CarroBO.getAllByCategorie(Categoria.executivo, carros));
		System.out.println(CarroBO.GetQntCarrosByCategorie(Categoria.economico, carros));
		System.out.println(CarroBO.removeByName("execul", carros));
		System.out.println(CarroBO.getAllByCategorie(Categoria.executivo, carros));

	}
}
