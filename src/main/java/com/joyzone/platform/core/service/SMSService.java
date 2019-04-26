package com.joyzone.platform.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jsms.api.common.SMSClient;

@Service
public class SMSService {

	@Autowired
	private SMSClient smsClient;
	
	public void sendRegistration(String phoneNum) {
		
	}
}
