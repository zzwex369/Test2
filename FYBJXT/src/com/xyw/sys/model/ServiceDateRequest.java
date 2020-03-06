package com.xyw.sys.model;

public class ServiceDateRequest {
	private String dateType;//需要返回的日期类型  字符串  date 两种   1 date 2 字符串
	private String formatDateStr; //字符串类型 默认 yyyy-MM-dd 
	
	public String getFormatDateStr() {
		return formatDateStr;
	}

	public void setFormatDateStr(String formatDateStr) {
		this.formatDateStr = formatDateStr;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	
}
