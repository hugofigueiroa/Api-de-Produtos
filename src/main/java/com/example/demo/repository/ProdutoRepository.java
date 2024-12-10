package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> { // No primeiro parâmetro, será colocado o tipo de dado que estamos utilizando (nesse caso, Produto), e o tipo de dado da chave primária que está sendo utilizado (nesse caso, String) ; 
	List<Produto> findByNome(String nome);
}
