package entity;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Carro implements Serializable {
    private static final long serialVersionUID = 1L;
	private long renavam;
	private String nome;
	private Categoria categoria;
	private int anoFabricacao;
	private double preco;
	
	
	public Carro(long renavam, String nome,Categoria categoria,int anoFabricacao, double preco) {
		setRenavam(renavam);
		setNome(nome);
		setCategoria(categoria);
		setAnoFabricacao(anoFabricacao);
		setPreco(preco);
	}
	public long getRenavam() {
		return renavam;
	}
	public void setRenavam(long renavam) {
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
