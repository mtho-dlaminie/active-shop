package com.momentum.activeshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.momentum.activeshop.model.Product;
import com.momentum.activeshop.service.ActiveShopService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
public class ProductController {
	
	ActiveShopService activeShopService;

    @Autowired
    public ProductController(ActiveShopService activeShoppeService) {
    	this.activeShopService = activeShoppeService;
    }
	
	@GetMapping(value = "/v1/products")
	@ApiOperation(value = "Returns a List of available products", response = Product.class, responseContainer = "List")
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(activeShopService.getAllProducts());
	}

	@PostMapping(value = "/v1/{customer-id}/purchase-product", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Products purchased", response = Product.class, responseContainer = "List")
	public ResponseEntity<List<Product>> purchaseProduct(@PathVariable("customer-id") int customerId,
			@RequestBody List<Product> products) {	
		return ResponseEntity.ok(activeShopService.purchaseProduct(customerId, products));
	}

}
