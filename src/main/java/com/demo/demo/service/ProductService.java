
package com.demo.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.demo.entity.Product;
import com.demo.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	
	@Autowired
	private ProductRepository productRepository;
	
	//save
	public Product saveProduct(Product product) {
		product.setId(null);
		return productRepository.save(product);
	}
	
	//get Id 
	
	public Product getProductById(String id) {
		return productRepository.findById(id).get(); 
		}
		
		
	public List<Product> getProduct(){
		return productRepository.findAll();
	}
	
	public boolean deketeProduct(String id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isEmpty()) {
			return false;
		}
		productRepository.deleteById(id);
		return true;
	}
	public Product updateProduct(Product product,String id) {
		Product existingProduct=productRepository.findById(id).get();
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setTags(product.getTags());
		existingProduct.setStock(product.getStock());
		
		return productRepository.save(existingProduct);
	}
	
	
}
