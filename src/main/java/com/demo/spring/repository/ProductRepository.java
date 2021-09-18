package com.demo.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.spring.constants.PrinterColorType;
import com.demo.spring.constants.PrinterFunctionType;
import com.demo.spring.constants.ProductType;
import com.demo.spring.constants.UsageType;
import com.demo.spring.model.Product;

public interface ProductRepository extends MongoRepository<Product, Long> {

	List<Product> findByOrderByPriceAsc();

	List<Product> findByPriceGreaterThan(double price);

	List<Product> findByPriceLessThan(double price);

	List<Product> findByPriceBetween(double min, double max);

	List<Product> findByModel(String model);

	List<Product> findByUsageType(UsageType type);

	List<Product> findByPrinterColorType(PrinterColorType colorType);

	List<Product> findByPrinterFunctionType(PrinterFunctionType functionType);

	List<Product> findByProductType(ProductType productType);

	List<Product> findByModelIsNotNull();

	List<Product> findByPriceBetweenAndUsageType(double min, double max, UsageType type);

	List<Product> findByUsageTypeOrUsageType(UsageType type1, UsageType type2);
}
