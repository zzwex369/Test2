package com.xyw.medical.fnbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class FA401Response extends MessageResponse{
	private FA401 fA401;
	private long rowCount;
	private List<VFA401> vf401s;
	
	private boolean state;
	private String errorMessage;
	private String promptMessage;
	
	
	public FA401 getfA401() {
		return fA401;
	}
	public void setfA401(FA401 fA401) {
		this.fA401 = fA401;
	}
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	
	public List<VFA401> getVf401s() {
		return vf401s;
	}
	public void setVf401s(List<VFA401> vf401s) {
		this.vf401s = vf401s;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
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
