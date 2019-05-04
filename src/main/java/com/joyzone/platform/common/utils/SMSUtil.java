package com.joyzone.platform.common.utils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;

@Component
public class SMSUtil {
	
	private static final String SMS_CONTENT = "【来否】您的验证码是1234";
	
	@Autowired
	private YunpianClient smsClient;
	
	public void sendSMS(String phoneNum, String content) {
		Map<String, String> params  = smsClient.newParam(2);
		params.put(YunpianClient.MOBILE, phoneNum);
		params.put(YunpianClient.TEXT, PublicUtil.isEmpty(content) ? SMS_CONTENT : content);
		Result<SmsSingleSend> rst = smsClient.sms().single_send(params);
	}
	
	public void sendSMS(String phoneNum) {
		sendSMS(phoneNum,null);
	}

}
