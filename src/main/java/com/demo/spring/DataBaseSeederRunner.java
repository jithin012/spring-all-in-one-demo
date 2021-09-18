package com.demo.spring;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.demo.spring.mock.MockData;
import com.demo.spring.model.Product;
import com.demo.spring.repository.ProductRepository;

@Component
@Order(1)
public class DataBaseSeederRunner implements CommandLineRunner {
	private ProductRepository productRepository;

	public DataBaseSeederRunner(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void run(String... args) throws Exception {
		System.out.println("seeder start....");
		empty();
		seed();
		System.out.println("seeder end....");

	}

	public void seed() throws IOException {
		List<Product> products = MockData.getProducts();
		this.productRepository.insert(products);
	}

	public void empty() {
		this.productRepository.deleteAll();
	}
}
