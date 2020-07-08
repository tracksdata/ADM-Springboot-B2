package com.cts.product.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Bean
	public void f2() {
		System.out.println("===> ProductService of f1 method");
	}

}
