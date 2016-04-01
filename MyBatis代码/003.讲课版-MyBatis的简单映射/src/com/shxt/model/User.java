package com.shxt.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	
	private Integer userId;
	private String account;
	private String pwd;
	private String userName;
	private String status;
	
	private String param1;
	
	private Date start_date;
	
	private Date end_date;
	
	private String param2;
	
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
	
	public String getParam1() {
		return param1;
	}
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getParam2() {
		return param2;
	}
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", account=" + account + ", pwd=" + pwd + ", userName=" + userName
				+ ", status=" + status + ", param1=" + param1 + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", param2=" + param2 + "]";
	}
	
	
	
	
	

}
