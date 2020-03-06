package com.xyw.medical.fnbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class F606Response extends MessageResponse{

	private F606 f606;
	private List<Vf606s> vf606s;
	
	private long rowCount;
	private boolean state;
	public F606 getF606() {
		return f606;
	}
	public void setF606(F606 f606) {
		this.f606 = f606;
	}
	public List<Vf606s> getVf606s() {
		return vf606s;
	}
	public void setVf606s(List<Vf606s> vf606s) {
		this.vf606s = vf606s;
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
