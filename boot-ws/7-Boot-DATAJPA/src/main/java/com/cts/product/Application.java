package com.cts.product;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.product.model.Product;
import com.cts.product.service.ProductService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(Application.class, args);

		ProductService ps = ac.getBean(ProductService.class);

		Product prod = ps.findById(6);
		prod.setDescription("Average");
		prod.setDateAdded(LocalDateTime.now());

		//ps.save(prod);

		/*
		ps.findAll().forEach(product -> {
			System.out.println(product.getId());
			System.out.println(product.getName());
			System.out.println(product.getDescription());
			System.out.println(product.getPrice());
			System.out.println("---------------------------------");
		});
		
		*/
		
		/*
		
		ps.findByNameLike("%i%").forEach(product->{
			System.out.println(product.getId());
			System.out.println(product.getName());
			System.out.println(product.getDescription());
			System.out.println(product.getPrice());
			System.out.println("---------------------------------");
		});
		
		*/
		
		
		/*
		ps.findByPriceGreaterThanEqual(15000).forEach(product->{
			System.out.println(product.getId());
			System.out.println(product.getName());
			System.out.println(product.getDescription());
			System.out.println(product.getPrice());
			System.out.println("---------------------------------");
		});
		
		*/
		
		/*
		
		ps.findByPriceBetween(3000, 15000).forEach(product->{
			System.out.println(product.getId());
			System.out.println(product.getName());
			System.out.println(product.getDescription());
			System.out.println(product.getPrice());
			System.out.println("---------------------------------");
		});
		
		*/
		
		ps.findByProductName("%e%").forEach(product->{
			
			System.out.println(product.getId());
			System.out.println(product.getName());
			System.out.println(product.getDescription());
			System.out.println(product.getPrice());
			System.out.println("---------------------------------");
		});
		
		
		
		
		
		
		
		
		
		
		

	}

}
