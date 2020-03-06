package com.xyw.sys.model;

public class LoginResponse extends MessageResponse{
	
	private SystemUser systemUser = null;
	
	public LoginResponse() {
	}
	
	public SystemUser getSystemUser() {
		return systemUser;
	}
	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}
}
