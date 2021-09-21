package com.demo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.spring.exception.ProductNotFoundException;
import com.demo.spring.model.Product;
import com.demo.spring.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Page<Product> findDefaultPaginatedProduct(Pageable pageAble) {
		return productRepository.findAll(pageAble);
	}

	public Page<Product> searchByName(String name, Pageable pageAble) {
		return productRepository.findByNameContainingIgnoreCase(name, pageAble);
	}

	public Product findProductById(long id) {
		Product product = productRepository.findById(id).orElse(null);
		if (product == null) {
			throw new ProductNotFoundException(id);
		}

		return product;

	}
}
