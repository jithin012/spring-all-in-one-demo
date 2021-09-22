package com.demo.spring.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String userName) {
		super("Github user with username " + userName + " not found");
	}
}
