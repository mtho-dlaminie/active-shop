package com.momentum.activeshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momentum.activeshop.data.CustomerDao;
import com.momentum.activeshop.data.ProductDao;
import com.momentum.activeshop.data.repository.CustomerRepository;
import com.momentum.activeshop.data.repository.ProductRepository;
import com.momentum.activeshop.exception.ActiveShopBadRequestException;
import com.momentum.activeshop.exception.ActiveShopResourceNotFoundException;
import com.momentum.activeshop.model.Customer;
import com.momentum.activeshop.model.Product;
import com.momentum.activeshop.service.ActiveShopService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ActiveShopServiceImpl implements ActiveShopService {

	ProductRepository productRepository;
	CustomerRepository customerRepository;
	
    @Autowired
    public ActiveShopServiceImpl(ProductRepository productRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }
    
    @Override
    public List<Customer> getAllCustomers() {
    	List<CustomerDao> customerDaoList = customerRepository.findAll();
    	List<Customer> customerList = new ArrayList<Customer>();
        customerDaoList.forEach(it -> customerList.add(Customer.builder().customerSource(it).build()));
        return customerList;
    }

    @Override
    public List<Product> getAllProducts() {
        List<ProductDao> productDaoList = productRepository.findAll();
        List<Product> productList = new ArrayList<Product>();
        productDaoList.forEach(it -> productList.add(Product.builder().productSource(it).build()));
        return productList;
    }

    @Override
    public List<Product> purchaseProduct(int customerId, List<Product> products) {

        if (products.isEmpty()) {
            throw new ActiveShopBadRequestException("The customer did not provide any products to purchase");
        }

        CustomerDao customer = customerRepository.findByCustomerId(customerId);

        if (null == customer) {
            throw new ActiveShopResourceNotFoundException("The user with id: " + customerId + " was not found");
        }

        int customerPoints = customer.getActiveDaysPoints();
        
        List<Product> allProducts = getAllProducts();
        
        if (allProducts.containsAll(products)) {
            int pointsRequired = products.stream().map(Product::getPoints)
                    .reduce(0, Integer::sum);
            int pointsDifference = customerPoints - pointsRequired;
            if (pointsDifference >= 0) {
                customer.setActiveDaysPoints(Math.toIntExact(pointsDifference));
                customerRepository.saveAndFlush(customer);
                return products;
            }
            
            log.error("The customer has insufficient points available for the purchase ", pointsRequired, customerPoints);
            throw new ActiveShopBadRequestException("Insufficient points available. " + pointsRequired + " is required");

        }

        log.error("One or more of the products you selected is currently unavailable");
        throw new ActiveShopResourceNotFoundException("One or more of the products selected is currently unavailable.");
    }
}
