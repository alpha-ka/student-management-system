package com.alpha.sms.controller;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="customActuator")
public class CustomActuator {

	@ReadOperation
	public String readDBDetails()
	{
		return "Give current read DB status of application";
	}
	
	@WriteOperation
	public String writeDBDetails()
	{
		return "Give current write DB status of application";
	}
	@DeleteOperation
	public String deleteDBDetails()
	{
		return "Give current delete DB status of application";
	}
	
}
