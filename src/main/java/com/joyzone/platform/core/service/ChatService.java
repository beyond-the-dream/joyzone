package com.joyzone.platform.core.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.joyzone.platform.common.utils.Constants;
import com.joyzone.platform.common.utils.JacksonUtil;
import com.joyzone.platform.common.utils.PublicUtil;
import com.joyzone.platform.common.utils.RestTemplateUtil;
import com.joyzone.platform.config.EasemobConfig;
import com.joyzone.platform.core.dto.EasemobToken;
import com.joyzone.platform.core.dto.EasemobUser;
import com.joyzone.platform.core.dto.EasemobUserResponse;


@Service
public class ChatService {

	@Autowired
	private EasemobConfig easemob;
	
	@Autowired
	private RedisService redisService;
	
	private Logger logger = LoggerFactory.getLogger(ChatService.class);
	
	/**
	 * Get easemob token
	 * @return
	 * @throws Exception
	 */
	public EasemobToken getToken(){
		try {
			Set<Object> tokens = redisService.sGet(Constants.EASEMOB_TOKEN);
			if(PublicUtil.isEmpty(tokens)) {			
				String accessUrl = easemob.getTokenUrl();
				Map<String, String> params = new HashMap<String, String>();
				params.put(Constants.EASEMOB_GRANT_TYPE, easemob.getGrantType());
				params.put(Constants.EASEMOB_CLIENT_ID, easemob.getClientId());
				params.put(Constants.EASEMOB_CLIENT_SECRET, easemob.getClientSecret());
				String body = JacksonUtil.deserializer(params);
				Map<String,String> headers = Maps.newHashMap();
				headers.put("content-type", MediaType.APPLICATION_JSON_VALUE);
				headers.put("Acccept", MediaType.APPLICATION_JSON_VALUE);
				String result = RestTemplateUtil.sendJson(accessUrl, body, headers, null);
				if(PublicUtil.isNotEmpty(result)) {
					EasemobToken token = JacksonUtil.parseJson(result, EasemobToken.class);
					redisService.sSetAndTime(Constants.EASEMOB_TOKEN, token.getExpiresIn() / 2,result);
					return token;
				}
				logger.error("Try to get token but failed， return null");
				return null;
			}else {
				Iterator<Object> ite = tokens.iterator();
				while(ite.hasNext()) {
					EasemobToken token = JacksonUtil.parseJson(String.valueOf(ite.next()), EasemobToken.class);
					return token;
				}
			}
		}catch(Exception e) {
			logger.error("Error happened when try to get token..。");
		}
		return null;
	}
	
	/**
	 * Register easemob user
	 * @param userName
	 * @param password
	 * @return
	 */
	public EasemobUser registerUser(String userName, String password) {
		String userOpeUrl = easemob.getOpeUsersUrl();
		Map<String, String> headers = new HashMap<String, String>();
		headers.put(Constants.EASEMOB_HEADER_AUTH, "Bearer " + getToken().getToken());
		try {
			String result = RestTemplateUtil.sendhttp(userOpeUrl, null, headers, null);
			if(PublicUtil.isNotEmpty(result)) {
				EasemobUserResponse easemobUser = JacksonUtil.parseJson(result, EasemobUserResponse.class);
				return easemobUser.getUsers().get(0);
			}
		} catch (Exception e) {
			logger.error("Register easemob user and error happended...");
		}
		return null;
	}
}
