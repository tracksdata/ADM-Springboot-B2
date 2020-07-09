package com.cts.product.service;

import java.util.List;

import com.cts.product.model.Product;

public interface ProductService {

	List<Product> findByNameLike(String name);
	List<Product> findByPriceGreaterThanEqual(double price);
	List<Product> findByPriceBetween(double startRange,double endRange);
	List<Product> findByProductName(String name);



	void save(Product product);

	List<Product> saveAll(List<Product> products);

	List<Product> findAll();

	Product findById(int id);

	void deleteById(int id);
	
	

}
