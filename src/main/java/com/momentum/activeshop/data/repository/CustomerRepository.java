package com.momentum.activeshop.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.momentum.activeshop.data.CustomerDao;

public interface CustomerRepository extends JpaRepository<CustomerDao, Integer> {
	List<CustomerDao> findAll();
    CustomerDao findByCustomerId(int customerId);
    @Override
    CustomerDao  saveAndFlush(CustomerDao customerDao);
}
