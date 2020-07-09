package com.cts.product.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cts.product.model.Product;
@Repository(value = "mongoDB")
public class MongoDBDaoImpl implements ProductDao{

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> saveAll(List<Product> products) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll() {
		System.out.println("findAll for MongoDB");
		return null;
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

}
