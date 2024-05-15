package com.ryan.shopper.shopperserv.exception;

public class UserAlreadyExistsException extends Exception{
	public UserAlreadyExistsException(String message) {
		super(message);
	}
}
