package model.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	@Column(nullable = false)
	private String nome;
	@Column(name = "cadastro" ,nullable = false)
	private LocalDate dataCadastro;
	@Column(nullable = false)
	private String marca;
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false)
	private String lote;
	@Column(nullable = false, precision = 10, scale = 2)
	private Double preco;


	public Produto() {
		super();
	}

	public Produto(Integer cod, String nome, LocalDate dataCadastro, String marca, String descricao, String lote,
			Double preco) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		this.marca = marca;
		this.descricao = descricao;
		this.lote = lote;
		this.preco = preco;
	
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getCod() {
		return cod;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public String getMarca() {
		return marca;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getLote() {
		return lote;
	}

	public Double getPreco() {
		return preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod, dataCadastro, descricao, lote, marca, nome, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(cod, other.cod) && Objects.equals(dataCadastro, other.dataCadastro)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(lote, other.lote)
				&& Objects.equals(marca, other.marca) && Objects.equals(nome, other.nome)
				&& Objects.equals(preco, other.preco);
	}
	
	

}
