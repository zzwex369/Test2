package com.xyw.medical.fnbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class F604Response extends MessageResponse{
	private F604 f604;
	private List<VF604> vf604s;
	
	private long rowCount;
	private boolean state;
	public F604 getF604() {
		return f604;
	}
	public void setF604(F604 f604) {
		this.f604 = f604;
	}
	public List<VF604> getVf604s() {
		return vf604s;
	}
	public void setVf604s(List<VF604> vf604s) {
		this.vf604s = vf604s;
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
	
}
