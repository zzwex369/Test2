package com.xyw.medical.fnbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class F603Response extends MessageResponse{
	private F603 f603;
	private List<VF603> vf603s;
	
	private long rowCount;
	private boolean state;
	public F603 getF603() {
		return f603;
	}
	public void setF603(F603 f603) {
		this.f603 = f603;
	}
	public List<VF603> getVf603s() {
		return vf603s;
	}
	public void setVf603s(List<VF603> vf603s) {
		this.vf603s = vf603s;
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
