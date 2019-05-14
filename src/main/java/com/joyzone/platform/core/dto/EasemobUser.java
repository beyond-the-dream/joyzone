package com.joyzone.platform.core.dto;

import java.util.Date;

public class EasemobUser {
	
	/**
	 * easemob user uuid
	 */
	private String uuid;
	
	/**
	 * easemob user type
	 */
	private String type;
	
	/**
	 * easemob user create time
	 */
	private Date createTime;
	
	private Date updateTime;
	
	/**
	 * easemob user name
	 */
	private String userName;
	
	/**
	 * easemob user status
	 */
	private boolean status;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
