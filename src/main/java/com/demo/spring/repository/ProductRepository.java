package com.demo.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.spring.model.Product;

public interface ProductRepository extends MongoRepository<Product, Long> {

	Page<Product> findAll(Pageable pageAble);

	Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageAble);

	// Page<Product> findByQuery(Query query, Pageable pageAble);

//	List<Product> findByOrderByPriceAsc();
//
//	List<Product> findByPriceGreaterThan(double price);
//
//	List<Product> findByPriceLessThan(double price);
//
//	List<Product> findByPriceBetween(double min, double max);
//
//	List<Product> findByModel(String model);
//
//	List<Product> findByUsageType(UsageType type);
//
//	List<Product> findByPrinterColorType(PrinterColorType colorType);
//
//	List<Product> findByPrinterFunctionType(PrinterFunctionType functionType);
//
//	List<Product> findByProductType(ProductType productType);
//
//	List<Product> findByModelIsNotNull();
//
//	List<Product> findByPriceBetweenAndUsageType(double min, double max, UsageType type);
//
//	List<Product> findByUsageTypeOrUsageType(UsageType type1, UsageType type2);


	// IsNull, IsNotNull, Like, Not, IsTrue, IsFalse, Exist

}
