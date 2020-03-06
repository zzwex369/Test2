package com.xyw.medical.fnbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class F308Response extends MessageResponse {
	private long f30801;
	private long f30802;
	private long rowCount;
	private F308 f308;
	private List<VF308> vf308s;
	
	private boolean state;

	public long getF30801() {
		return f30801;
	}

	public void setF30801(long f30801) {
		this.f30801 = f30801;
	}

	public long getF30802() {
		return f30802;
	}

	public void setF30802(long f30802) {
		this.f30802 = f30802;
	}

	public long getRowCount() {
		return rowCount;
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}

	public F308 getF308() {
		return f308;
	}

	public void setF308(F308 f308) {
		this.f308 = f308;
	}

	public List<VF308> getVf308s() {
		return vf308s;
	}

	public void setVf308s(List<VF308> vf308s) {
		this.vf308s = vf308s;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
}
