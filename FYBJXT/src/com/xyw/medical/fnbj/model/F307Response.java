package com.xyw.medical.fnbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class F307Response extends MessageResponse{
	private F306 f307;
	private long rowCount;
	private List<VF307> vf307s;
	
	private boolean state;
	private String errorMessage;
	private String promptMessage;
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	public F306 getF307() {
		return f307;
	}
	public void setF307(F306 f307) {
		this.f307 = f307;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public List<VF307> getVf307s() {
		return vf307s;
	}
	public void setVf307s(List<VF307> vf307s) {
		this.vf307s = vf307s;
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
