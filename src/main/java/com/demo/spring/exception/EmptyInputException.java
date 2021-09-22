package com.demo.spring.exception;

public class EmptyInputException extends RuntimeException {
	public EmptyInputException() {
		super("Input field is empty");
	}
}
