package com.ryan.shopper.shopperserv.config;

/*
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
*/

//import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

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
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> relayMethodArgumentNotValidException(MethodArgumentNotValidException e){
		/**
		List<String> errors = e.getBindingResult().getFieldErrors().stream()
																   .map(err -> err.getDefaultMessage()) 
																   .collect(Collectors.toList());
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), errors);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		**/
		
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
}
