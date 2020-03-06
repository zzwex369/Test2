package com.xyw.medical.fnbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class F310Response extends MessageResponse {
	private long f31001;
	private long rowCount;
	private F310 f310;
	private List<VF310> vf310s;
	private boolean state;
	
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public long getF31001() {
		return f31001;
	}
	public void setF31001(long f31001) {
		this.f31001 = f31001;
	}
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	public F310 getF310() {
		return f310;
	}
	public void setF310(F310 f310) {
		this.f310 = f310;
	}
	public List<VF310> getVf310s() {
		return vf310s;
	}
	public void setVf310s(List<VF310> vf310s) {
		this.vf310s = vf310s;
	}
	
}
