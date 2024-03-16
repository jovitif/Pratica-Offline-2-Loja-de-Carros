package model.service;

import java.util.ArrayList;
import java.util.List;

import model.entity.Carro;
import model.entity.Categoria;

public class CarroBO {
	public static int getQntCarros(List<Carro> carros) {
		return carros.size();
	}
	
	public static List<Carro> getAllByCategorie(Categoria categoria, List<Carro> carros){
		List<Carro> carrosByCategorie = new ArrayList<Carro>();
		for(int i = 0; i < carros.size(); i++) {
			if(categoria == carros.get(i).getCategoria()) {
				carrosByCategorie.add(carros.get(i));
			}
		}
		return carrosByCategorie;
	}
	
	public static int GetQntCarrosByCategorie(Categoria categoria, List<Carro> carros) {
		int qnt = 0;
		for(int i = 0; i < carros.size(); i++) {
			if(categoria == carros.get(i).getCategoria()) {
				qnt++;
			}
		}
		return qnt;
	}
	
	public static boolean removeByName(String name, List<Carro> carros) {
		for(int i = 0; i < carros.size(); i++) {
			if(carros.get(i).getNome() == name) {
				carros.get(i).setQntDisponivel(carros.get(i).getQntDisponivel() - 1);
				if(carros.get(i).getQntDisponivel() == 0)
					carros.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public static boolean removeByRenavam(int renavam,List<Carro> carros) {
		for(int i = 0; i < carros.size(); i++) {
			if(carros.get(i).getRenavam() == renavam) {
				carros.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public static Carro buscarByRenavam(int renavam, List<Carro> carros) {
		for(int i = 0; i < carros.size(); i++) {
			if(carros.get(i).getRenavam() == renavam) {
				return carros.get(i);
			}
		}
		return null;
	}
}
