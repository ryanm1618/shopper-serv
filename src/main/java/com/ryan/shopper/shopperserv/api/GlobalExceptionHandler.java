package com.ryan.shopper.shopperserv.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.ryan.shopper.shopperserv.exception.ErrorResponse;
import com.ryan.shopper.shopperserv.exception.UserAlreadyExistsException;
import com.ryan.shopper.shopperserv.exception.UserInfoNotFoundException;
import com.ryan.shopper.shopperserv.exception.UserInfoValidationException;
import com.ryan.shopper.shopperserv.exception.UserNotFoundException;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> relayUserNotFoundException(UserNotFoundException e){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
	}
	@ExceptionHandler(UserInfoNotFoundException.class)
	public ResponseEntity<ErrorResponse> relayUserInfoNotFoundException(UserInfoNotFoundException e){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> relayUserAlreadyExistsException(UserAlreadyExistsException e){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.FORBIDDEN.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);
	}
	@ExceptionHandler(UserInfoValidationException.class)
	public ResponseEntity<ErrorResponse> relayUserInfoValidationException(UserInfoValidationException e){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
}
