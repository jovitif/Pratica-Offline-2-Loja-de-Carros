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
}
