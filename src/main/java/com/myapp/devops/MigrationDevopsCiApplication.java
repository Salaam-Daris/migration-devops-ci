package com.myapp.devops;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.myapp.devops.model.Product;
import com.myapp.devops.repository.ProductRepository;

@SpringBootApplication
public class MigrationDevopsCiApplication {
	
	@Autowired
	private ProductRepository repository;
    public static void main(String[] args) {
		SpringApplication.run(MigrationDevopsCiApplication.class, args);
	}
    
    @Bean
    CommandLineRunner runner() {
    	return arge -> {
    		
    		List<Product> products=List.of(new Product("Iphone14","Iphone14Pro", 86455.50,4.5),
    		      new Product("OnePlus10","Iphone10Pro", 66455.50,4.8),
    		      new Product("SamsungFlip","SamsungFlipPro", 56455.50,4.2));
    		//insert into table-name and values
    		repository.saveAll(products);
    		repository.findAll().forEach(System.out::println);
//    		repository.findByProductName("OnePlus10").forEach(System.out::println);
    		
    	};
    }
      
}
