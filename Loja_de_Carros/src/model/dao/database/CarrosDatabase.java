package model.dao.database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entity.Carro;
import model.entity.Categoria;

public class CarrosDatabase {
	public static List<Carro> allCarros() {
		List<Carro> carros = new ArrayList<>();
		carros.add(new Carro(1672351046, "Toyota Prius", Categoria.economico,  LocalDate.of(2099, 04, 25), 122, 100.00));
		carros.add(new Carro(1487213590, "Honda Fit", Categoria.economico,  LocalDate.of(2099, 04, 25), 122, 100.00));
		carros.add(new Carro(1064821357, "Volkswagen Gol 1.0", Categoria.economico,  LocalDate.of(2099, 04, 25), 122, 100.00));
		carros.add(new Carro(1209547862, "Ford Ka 1.0", Categoria.economico,  LocalDate.of(2099, 04, 25), 1, 100.00));
		carros.add(new Carro(1431968251, "Mercedes-Benz Classe E", Categoria.executivo,  LocalDate.of(2099, 04, 25), 1, 100.00));
		carros.add(new Carro(1820371946, "BMW Série 5", Categoria.executivo,  LocalDate.of(2099, 04, 25), 1, 100.00));
		carros.add(new Carro(1102587946, "Audi A6", Categoria.executivo,  LocalDate.of(2099, 04, 25), 1, 100.00));
		carros.add(new Carro(1721093586, "Volvo S90", Categoria.executivo,  LocalDate.of(2099, 04, 25), 1, 100.00));
		carros.add(new Carro(1357148620, "Toyota Corolla", Categoria.intermediario,  LocalDate.of(2099, 04, 25), 1, 100.00));
		carros.add(new Carro(1586902473, "Honda Civic", Categoria.intermediario,  LocalDate.of(2099, 04, 25), 1, 100.00));
		carros.add(new Carro(1964702185, "Volkswagen Jetta", Categoria.intermediario,  LocalDate.of(2099, 04, 25), 1, 100.00));
		carros.add(new Carro(1240736198, "Ford Fusion", Categoria.intermediario,  LocalDate.of(2099, 04, 25), 1, 100.00));

		return carros;
	}
}
