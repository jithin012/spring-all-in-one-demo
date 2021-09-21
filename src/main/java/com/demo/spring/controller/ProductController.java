package com.demo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.model.Product;
import com.demo.spring.service.ProductService;

@RestController
@BasePathAwareController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping()
	public ResponseEntity<Page<Product>> getAllproducts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "price") String[] sortBy) {

		Pageable paging = PageRequest.of(page, size, Sort.by(sortBy));

		Page<Product> pageProduct = productService.findDefaultPaginatedProduct(paging);

		return new ResponseEntity<Page<Product>>(pageProduct, HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<Page<Product>> doProductSearch(@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size,
			@RequestParam(defaultValue = "usageType, price") String[] sortBy) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sortBy));

		Page<Product> pageProduct;

		if (keyword == "") {
			pageProduct = productService.findDefaultPaginatedProduct(paging);

		} else {
			pageProduct = productService.searchByName(keyword, paging);
		}
		return new ResponseEntity<Page<Product>>(pageProduct, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		Product product = productService.findProductById(id);
		return ResponseEntity.ok().header("Custom-Header", "foo").body(product);
	}

}

