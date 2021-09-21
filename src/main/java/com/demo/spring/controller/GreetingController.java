package com.demo.spring.controller;

import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@BasePathAwareController
@RequestMapping(value = "/")
public class GreetingController {

	@GetMapping("/")
	public @ResponseBody String getPrinterType() {
		return "Welcome to version 2";
	}
}
