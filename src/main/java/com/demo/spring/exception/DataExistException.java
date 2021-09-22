package com.demo.spring.exception;

public class DataExistException extends RuntimeException {
	public DataExistException(String message) {
		super(message);
	}
}
