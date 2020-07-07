package com.cts.product.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.cts.product.config.AppConfig;
import com.cts.product.entity.Product;
import com.cts.product.service.ProductCrudService;

public class ProductController {

	public static void main(String[] args) {
		AbstractApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		ProductCrudService crudService = ac.getBean(ProductCrudService.class);
		Product product = new Product();
		product.setId(1);
		product.setName("Book");
		product.setDecsription("Spring ORM");
		product.setPrice(2500);

		crudService.save(product);

		ac.close();

	}

}
