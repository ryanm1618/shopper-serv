package com.ryan.shopper.shopperserv.exception;

public class ErrorResponse {
	private int statusCode;
	private String message;
	
	public ErrorResponse(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}
	public int getStatusCode() {
		return this.statusCode;
	}
	public String getMessage() {
		return this.message;
	}
}
