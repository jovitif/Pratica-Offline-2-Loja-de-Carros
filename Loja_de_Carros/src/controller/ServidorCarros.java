package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import entity.Carro;
import entity.Categoria;
import service.CarroService;

public class ServidorCarros implements CarroService {
	List<Carro> carros; 

	public ServidorCarros() {
		carros = allCarros();
	}

	public static List<Carro> allCarros() {
		List<Carro> carros = new ArrayList<>();
		carros.add(new Carro(67482953045L, "Fiat Novo Uno", Categoria.economico, 2017, 61190.00));
		carros.add(new Carro(51896302752L, "Chevrolet Onix", Categoria.economico, 2021, 58686.00));
		carros.add(new Carro(74215836957L, "Ford Ka", Categoria.economico, 2015, 39888.00));
		carros.add(new Carro(30572418637L, "Hyundai HB20 1.6 Vision", Categoria.economico, 2021, 67500.00));
		carros.add(new Carro(89031425773L, "Ford Ka Sedan SE 1.0 (Flex)", Categoria.intermediario, 2019, 52900.00));
		carros.add(new Carro(46793280131L, "Chevrolet Onix Plus 1.0", Categoria.intermediario, 2023, 90000.00));
		carros.add(new Carro(62389574116L, "Renault Logan", Categoria.intermediario, 2023, 64233.00));
		carros.add(new Carro(18974250363L, "Toyota Etios X Plus 1.5 AT", Categoria.intermediario, 2021, 72940.00));
		carros.add(
				new Carro(54261983773L, "Toyota Corolla Altis Hybrid Premium", Categoria.executivo, 2024, 198890.00));
		carros.add(new Carro(37625891431L, "Honda Civic", Categoria.executivo, 2024, 259900.00));
		carros.add(new Carro(90847362188L, "Chevrolet Cruze Sedan", Categoria.executivo, 2023, 149990.00));
		carros.add(new Carro(21548763012L, "Ambition 2.0", Categoria.executivo, 2016, 122730.00));
		return carros;
	}

	@Override
	public List<Carro> listarCarros() throws RemoteException {
		System.out.println("Listando carros...");
		Collections.sort(carros, (carro1, carro2) -> carro1.getNome().compareTo(carro2.getNome()));
		return carros;
	}

	@Override
	public Carro buscarRenavam(long renavam) throws RemoteException {
		for (int i = 0; i < carros.size(); i++) {
			if (carros.get(i).getRenavam() == renavam)
				return carros.get(i);
		}
		return null;
	}

	@Override
	public int QntCarro() throws RemoteException {
		return carros.size();
	}

	@Override
	public Carro removerCarro(long renavam) throws RemoteException {
		for (int i = 0; i < carros.size(); i++) {
			if (carros.get(i).getRenavam() == renavam) {
				Carro carRemovido = carros.get(i);
				carros.remove(i);
				return carRemovido;
			}
		}
		return null;
	}

	@Override
	public String adicionarCarro(long renavam, String nome, double preco, Categoria categoria, int ano)
			throws RemoteException {
		for (int i = 0; i < carros.size(); i++) {
			if (carros.get(i).getRenavam() == renavam)
				return "O renavam digitado já foi utilizado\n";
		}
		Carro carro = new Carro(renavam, nome, categoria, ano, preco);
		carros.add(carro);
		return "O carro foi adicionado: " + carro.toString();
	}

	@Override
	public Carro editarCarro(long renavam, String nome, double preco, Categoria categoria, int ano)
			throws RemoteException {
		for (int i = 0; i < carros.size(); i++) {
			if (carros.get(i).getRenavam() == renavam) {
				carros.get(i).setAnoFabricacao(ano);
				carros.get(i).setCategoria(categoria);
				carros.get(i).setNome(nome);
				carros.get(i).setPreco(preco);
				return carros.get(i);
			}
		}
		return null;
	}

}
