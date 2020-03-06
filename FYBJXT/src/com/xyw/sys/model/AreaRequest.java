package com.xyw.sys.model;

public class AreaRequest {
	private String areaCode;
	private boolean showPrompt;
	private String areaFlag;
	private String table;
	
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public boolean getShowPrompt() {
		return showPrompt;
	}
	public void setShowPrompt(boolean showPrompt) {
		this.showPrompt = showPrompt;
	}
	public String getAreaFlag() {
		return areaFlag;
	}
	public void setAreaFlag(String areaFlag) {
		this.areaFlag = areaFlag;
	}
}
