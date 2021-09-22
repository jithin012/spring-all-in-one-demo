package com.demo.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler /* extends ResponseEntityExceptionHandler */ {

	@ExceptionHandler(value = { ProductNotFoundException.class, UserNotFoundException.class })
	public ResponseEntity itemNotFoundException(RuntimeException ex) {
		return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { DataExistException.class, EmptyInputException.class })
	public ResponseEntity badRequest(RuntimeException ex) {
		return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
