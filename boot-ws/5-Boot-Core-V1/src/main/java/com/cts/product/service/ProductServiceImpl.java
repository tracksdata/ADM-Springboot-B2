package com.cts.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.cts.product.dao.ProductDao;
import com.cts.product.model.Product;

@Service
@Lazy
//@Scope("singleton")
//@PropertySource("myfile.properties")

public class ProductServiceImpl implements ProductService {
	public ProductServiceImpl() {
		System.out.println("==== ProductService Object created...");
	}

	// @Autowired
	// private Environment env;

	@Value("${name}")
	private String custName;

	@Autowired
	@Qualifier(value = "mongoDB")
	private ProductDao prodDao;

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return prodDao.save(product);
	}

	@Override
	public List<Product> saveAll(List<Product> products) {
		// TODO Auto-generated method stub
		return prodDao.saveAll(products);
	}

	@Override
	public List<Product> findAll() {
		System.out.println(" Name: " + custName);
		System.out.println("===> ProductServiceImpl: findAll");
		// TODO Auto-generated method stub
		return prodDao.findAll();
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return prodDao.findById(id);
	}

	@Override
	public void deleteById(int id) {
		prodDao.deleteById(id);

	}

}
