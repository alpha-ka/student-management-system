package com.alpha.sms.profileConfig;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;




//@Profile("dev")
//@Configuration
public class ProfileConfigDev implements ProfileConfig {

	@Value("${spring.environment}")
	private String env;
	@Value("${spring.message}")
	private String message;
	
	@PostConstruct
	public void getProfileInfo() {
		
		System.out.println( env+"Configured\n"+message);
	}
}
