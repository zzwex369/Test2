package com.xyw.medical.fnbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class F602Response extends MessageResponse{
	private F602 f602;
	private List<VF602> vf602s;
	private List<String> f60205s; 
	private long rowCount;
	private boolean state;
	
	
	public List<String> getF60205s() {
		return f60205s;
	}
	public void setF60205s(List<String> f60205s) {
		this.f60205s = f60205s;
	}
	public F602 getF602() {
		return f602;
	}
	public void setF602(F602 f602) {
		this.f602 = f602;
	}
	public List<VF602> getVf602s() {
		return vf602s;
	}
	public void setVf602s(List<VF602> vf602s) {
		this.vf602s = vf602s;
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
