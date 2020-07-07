package com.cts.product.service;

import java.io.Serializable;
import java.util.List;

import com.cts.product.entity.Product;

public interface ProductCrudService {

	Serializable save(Product product);

	List<Product> saveAll(List<Product> products);

	List<Product> findAll();

	Product findById(int id);

}
