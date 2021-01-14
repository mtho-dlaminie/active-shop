package com.momentum.activeshop.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.momentum.activeshop.data.ProductDao;

public interface ProductRepository extends JpaRepository<ProductDao, Integer> {
	List<ProductDao> findAll();
}
