package com.xyw.medical.swjc.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class Sw301Response extends MessageResponse {
	private String sw30101;
	private Sw301 sw301;
	private VSw301 vSw301;
	private long rowCount;
	private List<VSw301> vSw301s;
	private boolean state;
	public String getSw30101() {
		return sw30101;
	}
	public void setSw30101(String sw30101) {
		this.sw30101 = sw30101;
	}
	public Sw301 getSw301() {
		return sw301;
	}
	public void setSw301(Sw301 sw301) {
		this.sw301 = sw301;
	}
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	
	public List<VSw301> getvSw301s() {
		return vSw301s;
	}
	public void setvSw301s(List<VSw301> vSw301s) {
		this.vSw301s = vSw301s;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public VSw301 getvSw301() {
		return vSw301;
	}
	public void setvSw301(VSw301 vSw301) {
		this.vSw301 = vSw301;
	}
}
