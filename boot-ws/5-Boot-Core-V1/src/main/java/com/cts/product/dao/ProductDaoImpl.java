package com.cts.product.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cts.product.model.Product;

@Repository(value = "mySQL")
public class ProductDaoImpl implements ProductDao {

	@Override
	public Product save(Product product) {
		return null;
	}

	@Override
	public List<Product> saveAll(List<Product> products) {
		return null;
	}

	@Override
	public List<Product> findAll() {
		System.out.println("===> ProductDaoImpl: findAll");
		return null;
	}

	@Override
	public Product findById(int id) {
		return null;
	}

	@Override
	public void deleteById(int id) {

	}

}
