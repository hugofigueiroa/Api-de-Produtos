package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

@RestController // Define que a classe é um controlador Rest ; 
@RequestMapping("/produtos") // Define a rota que será utilizada por essa classe ; 
public class ProdutoController {
	
	@Autowired // Fazendo a injeção de dependência ;
	private ProdutoRepository produtoRepository;

	// Função responsável por adicionar um produto ; 
	
	@PostMapping // Define a função que será executada quando surgir uma requisição do tipo post nessa rota ; 
	public Produto salvarProduto(@RequestBody Produto produto) {
		produtoRepository.save(produto); // Salvando o produto no banco de dados ; 
		return produto ; // Retornando o produto que foi gerado ; 
	}
	
	// Função responsável por recuperar um produto pelo ID ; 
	
	@GetMapping("/{id}") // Define a função que será executada quando surgir uma requisição do tipo get com parâmetros nessa rota ; 
	public Produto obterProdutoPorId(@PathVariable  Long id) {
		// Optional<Produto> produto = produtoRepository.findById(id); // Selecionando no banco de dados o produto do ID passado como parâmetro, e atribuindo a variável ; 
		// return produto.isPresent() ? produto.get() : null; // Caso o produto exista, será retornado o produto, e caso não exista será retornado nulo ; 
		return produtoRepository.findById(id).orElse(null); // Se o produto existir, ele retornará o produto, caso não exista ele retornará nulo ; 
	}
	
	// Função responsável por deletar um produto pelo ID ;
	
	@DeleteMapping("/{id}") // Define a função que será executada quando surgir uma requisição do tipo delete nessa rota ; 
	public void deletarProdutoPorId(@PathVariable Long id) {
		produtoRepository.deleteById(id); // Deletando o produto com o ID informado no banco de dados ; 
	}
	
	// Função responsável por atualizar um produto pelo ID ; 
	
	@PutMapping("/{id}") // Define a função que será executada quando surgir uma requisição do tipo put ; 
	public void atualizarProdutoPorId(@PathVariable Long id, @RequestBody Produto produto) {
		produto.setId(id); // Atribuindo ao produto o ID recebido como parâmetro ; 
		produtoRepository.save(produto); // Salvando o produto no banco de dados ; 
	}
	
	// Função responsável por pesquisar produtos no banco de dados dado uma condição de busca (nesse caso, pelo nome) ; 
	
	@GetMapping // Define a função que será executada quando surgir uma requisiçaõ do tipo get nessa rota ; 
	public List<Produto> buscarProdutos(@RequestParam String nome) { 
		return produtoRepository.findByNome(nome); // Retornando os produtos cadastrados com o nome recebido como parâmetro ; 
	}
}
