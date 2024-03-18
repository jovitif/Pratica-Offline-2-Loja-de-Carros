package Pratica01.entity;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Carro implements Serializable {
    private static final long serialVersionUID = 1L;
	private int renavam;
	private String nome;
	private Categoria categoria;
	private int anoFabricacao;
	private double preco;
	
	
	public Carro(int renavam, String nome,Categoria categoria,int anoFabricacao, double preco) {
		this.renavam = renavam;
		this.nome = nome;
		this.setCategoria(categoria);
		this.setAnoFabricacao(anoFabricacao);
		this.preco = preco;
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
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
	    DecimalFormat df = new DecimalFormat("#,##0.00");

	    String carro = "\n" + nome + "\nCódigo renavam: " + renavam + "\nPreço: " + df.format(preco) + " R$\n" + "Ano de fabricação: " + anoFabricacao + "\nCategoria: ";
	    
	    if (categoria.equals(categoria.economico)) {
	        carro = carro + " Econômico";
	    } else if (categoria.equals(categoria.executivo)) {
	        carro = carro + " Executivo";
	    } else {
	        carro = carro + "Intermediário";
	    }
	    
	    return carro;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	
}
