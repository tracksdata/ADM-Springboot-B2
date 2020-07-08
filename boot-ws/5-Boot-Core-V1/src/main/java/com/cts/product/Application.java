package com.cts.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.product.service.ProductService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(Application.class, args);

		ProductService ps1 = ac.getBean(ProductService.class);
		ProductService ps2 = ac.getBean(ProductService.class);

		System.out.println("ProductService ps1 hashCode: " + System.identityHashCode(ps1));
		System.out.println("ProductService ps2 hashCode: " + System.identityHashCode(ps2));

		ps1.findAll();
	}

}
