package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductDemo {
	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(ProductDemo.class, args);

//		String[] beans = appContext.getBeanDefinitionNames();
//		Arrays.sort(beans);
//		for (String name : beans) {
//			System.out.println(name);
//		}
	}
}
