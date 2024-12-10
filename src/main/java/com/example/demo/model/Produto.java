package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Define que a classe representará uma entidade (tabela) no banco de dados ; 
@Table(name = "produtos") // Definindo o nome da tabela que será criada no banco de dados ; 
public class Produto {

	// Atributos ; 

	@Id // Define a chave primária dessa tabela ; 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	 // Definindo que o banco de dados gerará o valor para a chave primária ; 
	private Long id; 
	@Column
	private String nome; 
	@Column
	private String descricao; 
	@Column
	private Double preco;
	
	// Getters e Setters ; 
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	// ToString ; 
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + "]";
	} 
}
