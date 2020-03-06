package com.xyw.medical.fnbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class F503Response extends MessageResponse{
	private F503 f503;
	private List<VF503> vf503s;
	
	private long rowCount;
	private boolean state;
	public F503 getF503() {
		return f503;
	}
	public void setF503(F503 f503) {
		this.f503 = f503;
	}
	public List<VF503> getVf503s() {
		return vf503s;
	}
	public void setVf503s(List<VF503> vf503s) {
		this.vf503s = vf503s;
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
