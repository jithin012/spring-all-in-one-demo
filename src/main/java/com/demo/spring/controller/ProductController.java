package com.demo.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.model.Product;
import com.demo.spring.repository.ProductRepository;

@RestController
@BasePathAwareController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping()
	public @ResponseBody List<Product> getAllproducts() {
		return productRepository.findByOrderByPriceAsc();
	}

	@GetMapping("/{id}")
	public @ResponseBody Optional<Product> getProductById(@PathVariable long id) {
		return productRepository.findById(id);
	}

}
