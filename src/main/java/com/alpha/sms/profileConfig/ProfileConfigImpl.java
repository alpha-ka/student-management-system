package com.alpha.sms.profileConfig;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile(value={"dev","uat","prod"})
@Configuration
public class ProfileConfigImpl implements ProfileConfig {

	@Value("${spring.environment}")
	private String env;
	@Value("${spring.message}")
	private String message;
	
	@PostConstruct
	public void getProfileInfo() {
		
		System.out.println( env+"Configured\n"+message);
	}

}
