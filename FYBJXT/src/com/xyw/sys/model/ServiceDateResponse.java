package com.xyw.sys.model;

public class ServiceDateResponse extends MessageResponse{
	private String dateType;//需要返回的日期类型  字符串  date 两种   1 date 2 字符串
	private Object date;
	private boolean state;
	
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getDateType() {
		return dateType;
	}
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	public Object getDate() {
		return date;
	}
	public void setDate(Object date) {
		this.date = date;
	}
	

}
