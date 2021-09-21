package com.demo.spring.exception;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(long productId) {
		super("product with id " + productId + " not found");
	}
}
