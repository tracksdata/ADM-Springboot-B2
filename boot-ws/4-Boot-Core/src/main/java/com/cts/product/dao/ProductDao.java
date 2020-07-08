package com.cts.product.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

	@Bean
	public void f3() {
		System.out.println("===> ProductDao f3 method");
	}
}
