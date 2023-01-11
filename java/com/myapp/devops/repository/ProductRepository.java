package com.myapp.devops.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.devops.model.Product;


//
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	// select * from table_name where productName=
	Optional<List<Product>> findByProductName(String productName);
	
	
	// select * from table_name where price>=?
	Optional<List<Product>> findByPriceGreaterThanEqual(Double price);
	
	Optional<List<Product>> findByProductNameOrPrice(String productName,Double price);

}