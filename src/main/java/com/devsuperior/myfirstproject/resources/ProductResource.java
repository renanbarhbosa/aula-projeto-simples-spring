package com.devsuperior.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.myfirstproject.entities.Product;
import com.devsuperior.myfirstproject.repositories.ProductRepository;

@RestController // faz com que a classe seja reconhecida como um recurso rest.
@RequestMapping(value = "/products") // define um caminho para o qual responder --> localhost:8080/categories
public class ProductResource {
	
	@Autowired
	private ProductRepository categoryRepository;

	@GetMapping // para que seja um endpoint da aplicação, respondendo por uma requisição get do
				// http.
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = categoryRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product cat = categoryRepository.findById(id);
		return ResponseEntity.ok().body(cat);
	}

}