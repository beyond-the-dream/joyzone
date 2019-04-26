package com.joyzone.platform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.jsms.api.common.SMSClient;

@Configuration
public class SEMEConfig {
	
	@Value("${jiguang.appKey}")
	private String appKey;
	
	@Value("${jiguang.masterSecret}")
	private String masterSecret;
	
	@Bean(name="smsClient")
	public SMSClient newClient() {
		SMSClient client = new SMSClient(masterSecret, appKey);
		return client;
	}

}
