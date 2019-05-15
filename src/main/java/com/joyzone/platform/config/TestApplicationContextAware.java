package com.joyzone.platform.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class TestApplicationContextAware implements ApplicationContextAware, BeanNameAware {

	private String beanName;
	
	private ApplicationContext context;
	
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		this.beanName = name;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.context = applicationContext;
	}

}
