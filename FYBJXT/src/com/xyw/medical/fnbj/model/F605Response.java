package com.xyw.medical.fnbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class F605Response extends MessageResponse {
	private String f60501;
	private F605 f605;
	private long rowCount;
	private List<VF605> vf605s;
	private boolean state;
	public String getF60501() {
		return f60501;
	}
	public void setF60501(String f60501) {
		this.f60501 = f60501;
	}
	public F605 getF605() {
		return f605;
	}
	public void setF605(F605 f605) {
		this.f605 = f605;
	}
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public List<VF605> getVf605s() {
		return vf605s;
	}
	public void setVf605s(List<VF605> vf605s) {
		this.vf605s = vf605s;
	}

	
}
