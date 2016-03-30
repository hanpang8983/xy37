package com.shxt.model;

import java.io.Serializable;

public class User implements Serializable {
	
	private Integer userId;
	private String account;
	private String pwd;
	private String userName;
	private String status;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", account=" + account + ", pwd=" + pwd + ", userName=" + userName
				+ ", status=" + status + "]";
	}
	
	
	

}
