package com.momentum.activeshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.momentum.activeshop.model.Customer;
import com.momentum.activeshop.service.ActiveShopService;

@CrossOrigin
@RestController
public class CustomerController {

	ActiveShopService activeShopService;

    @Autowired
    public CustomerController(ActiveShopService activeShoppeService) {
    	this.activeShopService = activeShoppeService;
    }
    
	@GetMapping(value = "/v1/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return ResponseEntity.ok(activeShopService.getAllCustomers());
	}
}
