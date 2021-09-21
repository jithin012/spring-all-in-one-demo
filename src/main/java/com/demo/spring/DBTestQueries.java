package com.demo.spring;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.demo.spring.model.Product;
import com.demo.spring.repository.ProductRepository;

@Component
@Order(2)
public class DBTestQueries implements CommandLineRunner {
	private ProductRepository productRepository;

	public DBTestQueries(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void run(String... args) throws Exception {
		long count = this.productRepository.count();
		System.out.println("Total Number of items " + count);
//		List<Product> products = this.productRepository.findByOrderByPriceAsc();
//		showProducts(products);

//		List<Product> higherPricePrinter = this.productRepository.findByPriceGreaterThan(100000);
//		showProducts(higherPricePrinter);

//		List<Product> affordablePricePrinter = this.productRepository.findByPriceLessThan(20000);
//		showProducts(affordablePricePrinter);

//		List<Product> printersPriceBetween = this.productRepository.findByPriceBetween(10000, 20000);
//		showProducts(printersPriceBetween);

//		List<Product> printerByModel = this.productRepository.findByModel("CZ175A");
//		showProducts(printerByModel);

//		List<Product> homeTypePrinter = this.productRepository.findByUsageType(UsageType.Home);
//		showProducts(homeTypePrinter);

//		List<Product> businessTypePrinter = this.productRepository.findByUsageType(UsageType.Business);
//		showProducts(businessTypePrinter);

//		List<Product> enterpriseTypePrinter = this.productRepository.findByUsageType(UsageType.Enterprise);
//		showProducts(enterpriseTypePrinter);

//		List<Product> colorPrinter = this.productRepository.findByPrinterColorType(PrinterColorType.Color);
//		showProducts(colorPrinter);

//		List<Product> blackAndWhitePrinter = this.productRepository
//				.findByPrinterColorType(PrinterColorType.BlackAndWhite);
//		showProducts(blackAndWhitePrinter);

//		List<Product> functionTypePrinters = this.productRepository
//				.findByPrinterFunctionType(PrinterFunctionType.PrintOnly); // PrintScanCopyFax PrintScanCopy
//																			// PrintScanCopyWireless
//		showProducts(functionTypePrinters);

//		List<Product> ColorMultifunctionalPrinter = this.productRepository
//				.findByProductType(ProductType.ColorMultifunctional);
//		showProducts(ColorMultifunctionalPrinter);

//		List<Product> colorPrinter = this.productRepository
//				.findByProductType(ProductType.Color);
//		showProducts(colorPrinter);

//		List<Product> inkjetPrinter = this.productRepository.findByProductType(ProductType.Inkjet);
//		showProducts(inkjetPrinter);

//		List<Product> laserPrinter = this.productRepository.findByProductType(ProductType.Laser);
//		showProducts(laserPrinter);

//		List<Product> multiFunctionalPrinter = this.productRepository.findByProductType(ProductType.Multifunctional);
//		showProducts(multiFunctionalPrinter);

//		List<Product> officePrinter = this.productRepository.findByProductType(ProductType.OfficePrinter);
//		showProducts(officePrinter);

//		List<Product> products = this.productRepository.findByModelIsNotNull();
//		showProducts(products);

//		List<Product> affordableHomeTypePrinter = this.productRepository.findByPriceBetweenAndUsageType(10000, 20000,
//				UsageType.Home);
//		showProducts(affordableHomeTypePrinter);

//		List<Product> commercialPrinters = this.productRepository.findByUsageTypeOrUsageType(UsageType.Business,
//				UsageType.Enterprise);
//		showProducts(commercialPrinters);

	}

	private void showProducts(List<Product> products) {
		for (Product product : products) {
			System.out.println(product);
		}
	}

}
