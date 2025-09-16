package com.demo.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.demo.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product,String>{

}
