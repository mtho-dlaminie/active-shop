package com.momentum.activeshop.service;

import java.util.List;

import com.momentum.activeshop.model.Customer;
import com.momentum.activeshop.model.Product;

public interface ActiveShopService {
	
	   List<Customer> getAllCustomers();

	   List<Product> getAllProducts();

	   List<Product> purchaseProduct(int customerId, List<Product> products);
}
