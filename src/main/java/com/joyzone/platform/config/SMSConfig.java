package com.joyzone.platform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yunpian.sdk.YunpianClient;

@Configuration
public class SMSConfig {
	
	@Value("${yunpian.sms.apiKey}")
	private String apiKey;
	
	@Bean(name="smsClient")
	public YunpianClient newClient() {
		YunpianClient client = new YunpianClient(apiKey).init();
		return client;
	}

}
