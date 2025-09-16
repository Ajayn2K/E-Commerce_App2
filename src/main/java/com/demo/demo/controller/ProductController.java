package com.demo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.entity.Product;
import com.demo.demo.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")

public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public Product save(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	@GetMapping("/{id}")
	public Product findById(@PathVariable String id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/all")
	public List<Product> finddAll(){
		return productService.getProduct();
	}
	
	@PutMapping("/{id}")
	public Product updateProducts(@RequestBody Product product,String  id ) {
		return productService.updateProduct(product, id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteProduct(String id) {
		return productService.deketeProduct(id);
	}

}
