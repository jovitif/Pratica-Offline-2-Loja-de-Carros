
package model.entity;

import java.sql.Date;

public class Carro {
	private int renavam;
	private String nome;
	private Categoria categoria;
	private Date anoFabricacao;
	private int qntDisponivel;
	private double preco;
	
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
	public Date getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(Date anoFabricacao) {
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
	
}