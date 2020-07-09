package com.cts.product.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cts.product.model.Product;

@Repository(value = "mySQL")
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Product product) {

		if (findById(product.getId()) != null) {
			em.merge(product);
		} else {
			em.persist(product);
		}
	}

	@Override
	public List<Product> saveAll(List<Product> products) {
		for (Product product : products) {
			em.persist(product);
		}

		return products;
	}

	@Override
	public List<Product> findAll() {
		System.out.println("===> ProductDaoImpl: findAll");
		return em.createQuery("from Product").getResultList();
	}

	@Override
	public Product findById(int id) {
		return em.find(Product.class, id);
	}

	@Override
	public void deleteById(int id) {

		em.remove(findById(id));
	}

}
