package com.alpha.sms.entity;

import javax.inject.Named;

import org.springframework.stereotype.Component;

//@Component
@Named("dum")
public class Dummy {

	public String toString()
	{
		return "Hey";
	}
	
}
