package com.cts.product.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.cts.product.dao.ProductDao;
import com.cts.product.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	@Qualifier(value = "mySQL")
	private ProductDao prodDao;

	@Transactional
	@Override
	public void save(Product product) {

		
		prodDao.save(product);

	}

	@Override
	@Transactional
	public List<Product> saveAll(List<Product> products) {
		// TODO Auto-generated method stub
		return prodDao.saveAll(products);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return prodDao.findAll();
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return prodDao.findById(id);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		prodDao.deleteById(id);

	}

}
