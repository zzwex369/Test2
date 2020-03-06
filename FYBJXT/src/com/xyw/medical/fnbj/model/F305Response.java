package com.xyw.medical.fnbj.model;

import java.util.List;

public class F305Response {
	private long rowCount;
	private F305 f305;
	private boolean state;
	private List<VF305> vf305s;
	private String errorMessage;
	private String promptMessage;
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	public F305 getF305() {
		return f305;
	}
	public void setF305(F305 f305) {
		this.f305 = f305;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public List<VF305> getVf305s() {
		return vf305s;
	}
	public void setVf305s(List<VF305> vf305s) {
		this.vf305s = vf305s;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getPromptMessage() {
		return promptMessage;
	}
	public void setPromptMessage(String promptMessage) {
		this.promptMessage = promptMessage;
	}
}
