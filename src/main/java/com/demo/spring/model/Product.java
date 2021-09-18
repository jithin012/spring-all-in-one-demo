package com.demo.spring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.demo.spring.constants.PrinterColorType;
import com.demo.spring.constants.PrinterFunctionType;
import com.demo.spring.constants.ProductType;
import com.demo.spring.constants.UsageType;

@Document
public class Product {
	@Id
	private long id;
	
	private String name;
	private String model;
	private PrinterColorType printerColorType;
	private PrinterFunctionType printerFunctionType;
	private ProductType productType;
	private UsageType usageType;
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public PrinterColorType getPrinterColorType() {
		return printerColorType;
	}

	public void setPrinterColorType(PrinterColorType printerColorType) {
		this.printerColorType = printerColorType;
	}

	public PrinterFunctionType getPrinterFunctionType() {
		return printerFunctionType;
	}

	public void setPrinterFunctionType(PrinterFunctionType printerFunctionType) {
		this.printerFunctionType = printerFunctionType;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public UsageType getUsageType() {
		return usageType;
	}

	public void setUsageType(UsageType usageType) {
		this.usageType = usageType;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", model=" + model + ", printerColorType=" + printerColorType
				+ ", printerFunctionType=" + printerFunctionType + ", productType=" + productType + ", usageType="
				+ usageType + ", price=" + price + "]";
	}

}
