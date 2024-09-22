package com.ryan.shopper.shopperserv.config;


public class ErrorResponse {
	private int statusCode;
	private String errorMessage;
	
	public ErrorResponse(int statusCode, String errorMessage) {
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
	}
	public int getStatusCode() {
		return this.statusCode;
	}
	public String getErrorMessages(){
		return this.errorMessage;
	}
}
