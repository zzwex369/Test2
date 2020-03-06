package com.xyw.medical.swjc.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class Sw304Response extends MessageResponse {
	private String sw30401;
	private Sw304 sw304;
	private VSw304 vSw304;
	private long rowCount;
	private List<VSw304> vSw304s;
	private boolean state;
	public String getSw30401() {
		return sw30401;
	}
	public void setSw30401(String sw30401) {
		this.sw30401 = sw30401;
	}
	public Sw304 getSw304() {
		return sw304;
	}
	public void setSw304(Sw304 sw304) {
		this.sw304 = sw304;
	}
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	
	public List<VSw304> getvSw304s() {
		return vSw304s;
	}
	public void setvSw304s(List<VSw304> vSw304s) {
		this.vSw304s = vSw304s;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public VSw304 getvSw304() {
		return vSw304;
	}
	public void setvSw304(VSw304 vSw304) {
		this.vSw304 = vSw304;
	}
}
