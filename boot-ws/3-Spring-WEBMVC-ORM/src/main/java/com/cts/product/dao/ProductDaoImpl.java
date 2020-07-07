package com.cts.product.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.product.entity.Product;

@Repository
public class ProductDaoImpl implements ProductCrudDao {

	@Autowired
	private SessionFactory sf;

	public Serializable save(Product product) {
		return sf.getCurrentSession().save(product);
	}

	public List<Product> saveAll(List<Product> products) {
		Session ses = sf.getCurrentSession();
		for (Product prod : products) {
			ses.save(prod);
		}
		return products;
	}

	public List<Product> findAll() {
		return sf.getCurrentSession().createQuery("from Product").list();
	}

	public Product findById(int id) {
		return sf.getCurrentSession().get(Product.class, id);
	}

}
