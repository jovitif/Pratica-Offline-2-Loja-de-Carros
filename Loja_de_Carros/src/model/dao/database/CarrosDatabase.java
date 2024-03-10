package model.dao.database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entity.Carro;
import model.entity.Categoria;

public class CarrosDatabase {
	public static List<Carro> allCarros() {
		List<Carro> carros = new ArrayList<>();
		carros.add(new Carro(1224, "fiat novo uno", Categoria.economico,  LocalDate.of(2099, 04, 25), 122, 100.00));
		carros.add(new Carro(1224, "chevrolet onix", Categoria.economico,  LocalDate.of(2099, 04, 25), 122, 100.00));
		carros.add(new Carro(1224, "chevrolet onix", Categoria.economico,  LocalDate.of(2099, 04, 25), 122, 100.00));
		carros.add(new Carro(1224, "execult", Categoria.executivo,  LocalDate.of(2099, 04, 25), 1, 100.00));
		return carros;
	}
}
