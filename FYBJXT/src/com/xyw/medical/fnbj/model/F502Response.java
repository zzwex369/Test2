package com.xyw.medical.fnbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class F502Response extends MessageResponse{
	private F502 f502;
	private List<VF502> vf502s;
	
	private long rowCount;
	private boolean state;
	public F502 getF502() {
		return f502;
	}
	public void setF502(F502 f502) {
		this.f502 = f502;
	}
	public List<VF502> getVf502s() {
		return vf502s;
	}
	public void setVf502s(List<VF502> vf502s) {
		this.vf502s = vf502s;
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
