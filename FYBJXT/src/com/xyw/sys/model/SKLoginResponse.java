package com.xyw.sys.model;

public class SKLoginResponse extends MessageResponse{
	private boolean states;//是否是同一个加密狗
	private String name;//返回用户名
	public SKLoginResponse() {
	}
	public boolean isStates() {
		return states;
	}
	public void setStates(boolean states) {
		this.states = states;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
