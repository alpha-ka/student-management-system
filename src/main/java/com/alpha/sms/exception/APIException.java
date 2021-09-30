package com.alpha.sms.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class APIException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public APIException(String message)
	{
		super(message);
	}
}
