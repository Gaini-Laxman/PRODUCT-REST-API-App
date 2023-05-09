package com.klinnovations.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.klinnovations.request.Product;
import com.klinnovations.service.ProductService;

@RestController
public class ProductRestController {

	@Autowired
	private ProductService service;
	
	@PostMapping(value = "/product", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Product> RequestProduct(@RequestBody Product product) {
		Product p = service.RequestProduct(product);

		return new ResponseEntity<>(p, HttpStatus.CREATED);

	}

	@GetMapping(value = "/product/{pid}", produces = "application/json")

	public Product getProductByNum(@PathVariable Integer pid) {

		return service.getProductByNum(pid);

	}
}
