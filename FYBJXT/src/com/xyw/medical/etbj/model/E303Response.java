package com.xyw.medical.etbj.model;



import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class E303Response extends MessageResponse {
	
	private long e30301;
	private VE301 ve303;
	private List<VE303> ve303s;
	private long rowCount;
	private boolean state;
	public long getE30301() {
		return e30301;
	}
	public void setE30301(long e30301) {
		this.e30301 = e30301;
	}
	public VE301 getVe303() {
		return ve303;
	}
	public void setVe303(VE301 ve303) {
		this.ve303 = ve303;
	}
	public List<VE303> getVe303s() {
		return ve303s;
	}
	public void setVe303s(List<VE303> ve303s) {
		this.ve303s = ve303s;
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
