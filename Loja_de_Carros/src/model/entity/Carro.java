
package model.entity;

import java.time.LocalDate;

public class Carro {
	private int renavam;
	private String nome;
	private Categoria categoria;
	private LocalDate anoFabricacao;
	private int qntDisponivel; //Talvez esse atributo seja excluido depois
	private double preco;
	
	public Carro(int renavam, String nome, Categoria categoria, LocalDate anoFabricacao, int qntDisponivel, double preco) {
		setRenavam(renavam);
		setNome(nome);
		setCategoria(categoria);
		setAnoFabricacao(anoFabricacao);
		setQntDisponivel(qntDisponivel);
		setPreco(preco);
	}
	
	public int getRenavam() {
		return renavam;
	}
	public void setRenavam(int renavam) {
		this.renavam = renavam;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public LocalDate getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(LocalDate anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public int getQntDisponivel() {
		return qntDisponivel;
	}
	public void setQntDisponivel(int qntDisponivel) {
		this.qntDisponivel = qntDisponivel;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Carro [renavam=" + renavam + ", nome=" + nome + ", categoria=" + categoria + ", anoFabricacao="
				+ anoFabricacao + ", qntDisponivel=" + qntDisponivel + ", preco=" + preco + "]";
	}
	
	public static void main(String []args) {
		Carro car = new Carro(1224, "fiat novo uno", Categoria.economico,  LocalDate.of(2099, 04, 25), 122, 100.00);
		Carro car2 = new Carro(1224, "chevrolet onix", Categoria.economico,  LocalDate.of(2099, 04, 25), 122, 100.00);
		Carro car3 = new Carro(1224, "chevrolet onix", Categoria.economico,  LocalDate.of(2099, 04, 25), 122, 100.00);

		System.out.print(car);

		System.out.print(car2);
	}
}