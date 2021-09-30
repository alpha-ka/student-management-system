package com.alpha.sms.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	//handle specific exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(), exception.getMessage(),request.getDescription(true));
		
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	//handle specific exception
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<?> handleEmptyInputException(EmptyInputException exception, WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(), exception.getMessage(),request.getDescription(true));
		
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	//handle specific exception
		@ExceptionHandler(APIException.class)
		public ResponseEntity<?> handleAPIException(APIException exception, WebRequest request)
		{
			ErrorDetails errorDetails=new ErrorDetails(new Date(), exception.getMessage(),request.getDescription(true));
			
			return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
		}
		
	
	//handle global exception
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException (Exception exception, WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(true));
		
		return new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
