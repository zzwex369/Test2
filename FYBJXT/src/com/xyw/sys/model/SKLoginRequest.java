package com.xyw.sys.model;

public class SKLoginRequest {
	private String name;
	private String pwd;
	private String permission;
	private String ranTime;//随机时间
	private String sKID;//加密狗ID
	private String clientResult;//客户端加密结果
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getRanTime() {
		return ranTime;
	}
	public void setRanTime(String ranTime) {
		this.ranTime = ranTime;
	}
	public String getSKID() {
		return sKID;
	}
	public void setSKID(String sKID) {
		this.sKID = sKID;
	}
	public String getClientResult() {
		return clientResult;
	}
	public void setClientResult(String clientResult) {
		this.clientResult = clientResult;
	}
	
}
