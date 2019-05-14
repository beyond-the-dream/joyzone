package com.joyzone.platform.core.dto;

import java.util.List;

public class EasemobUserResponse {
	
	private String action;
	
	private String application;
	
	private String path;
	
	private String uri;
	
	private List<EasemobUser> users;
	
	private Integer duration;
	
	private String organization;
	
	private String applicationName;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public List<EasemobUser> getUsers() {
		return users;
	}

	public void setUsers(List<EasemobUser> users) {
		this.users = users;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

}
