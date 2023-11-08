package models;

import java.math.BigDecimal;
import java.text.Format;
import java.util.UUID;

public class Produto {

	public int id;
	public String codigo;
	public String nome;
	public BigDecimal preco;
	
	public Produto() {}
   public Produto(String nome, String codigo, BigDecimal preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }
	public Produto(String nome,BigDecimal preco) {
		this.nome = nome;
		this.preco = preco;
		geraCodigo();
	}

	public void geraCodigo() {
		this.codigo = UUID.randomUUID().toString();
	}

	public String getNome() {
		return this.nome;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public void setPreco(final BigDecimal preco) {
		this.preco = preco;
	}

	public String getCodigo() {
		return this.codigo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome: %s Codigo: %s  Preço:R$ %s".formatted(this.nome,this.codigo,this.preco.toString());
	}
}
