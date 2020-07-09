package com.cts.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.product.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	List<Product> findByNameLike(String name);

	List<Product> findByPriceGreaterThanEqual(double price);
	
	List<Product> findByPriceBetween(double startRange,double endRange);
	
	
	@Query("from Product as p where p.name like :myProductName")
	//List<Product> findByProductName(String name);
	List<Product> findByProductName(@Param("myProductName") String name);

}