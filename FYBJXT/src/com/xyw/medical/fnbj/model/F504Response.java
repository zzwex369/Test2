package com.xyw.medical.fnbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class F504Response extends MessageResponse{
	private F504 f504;
	private List<VF504> vf504s;
	private long rowCount;
	private boolean state;
	public F504 getF504() {
		return f504;
	}
	public void setF504(F504 f504) {
		this.f504 = f504;
	}
	public List<VF504> getVf504s() {
		return vf504s;
	}
	public void setVf504s(List<VF504> vf504s) {
		this.vf504s = vf504s;
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
