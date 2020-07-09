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
	private ProductDao prodDao;

	@Override
	public void save(Product product) {

		prodDao.save(product);

	}

	@Override
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
		return prodDao.findById(id).orElse(null);
	}

	@Override

	public void deleteById(int id) {
		prodDao.deleteById(id);

	}

	@Override
	public List<Product> findByNameLike(String name) {
		// TODO Auto-generated method stub
		return prodDao.findByNameLike(name);
	}

	@Override
	public List<Product> findByPriceGreaterThanEqual(double price) {
		// TODO Auto-generated method stub
		return prodDao.findByPriceGreaterThanEqual(price);
	}

	@Override
	public List<Product> findByPriceBetween(double startRange, double endRange) {
		// TODO Auto-generated method stub
		return prodDao.findByPriceBetween(startRange, endRange);
	}

	@Override
	public List<Product> findByProductName(String name) {
		// TODO Auto-generated method stub
		return prodDao.findByProductName(name);
	}

}
