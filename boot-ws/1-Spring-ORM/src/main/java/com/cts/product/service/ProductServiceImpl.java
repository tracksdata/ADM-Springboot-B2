package com.cts.product.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.product.dao.ProductCrudDao;
import com.cts.product.entity.Product;

@Service
public class ProductServiceImpl implements ProductCrudService {

	@Autowired
	private ProductCrudDao crudDao;

	@Transactional
	public Serializable save(Product product) {
		// TODO Auto-generated method stub
		return crudDao.save(product);
	}

	@Transactional
	public List<Product> saveAll(List<Product> products) {
		// TODO Auto-generated method stub
		return crudDao.saveAll(products);
	}

	@Transactional
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return crudDao.findAll();
	}

	@Transactional
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return crudDao.findById(id);
	}

}
