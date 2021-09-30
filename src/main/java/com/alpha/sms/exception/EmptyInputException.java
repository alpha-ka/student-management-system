package com.alpha.sms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class EmptyInputException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmptyInputException(String message)
	{
		super(message);
	}

}
