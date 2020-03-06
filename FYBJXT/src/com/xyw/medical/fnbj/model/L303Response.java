package com.xyw.medical.fnbj.model;

import com.xyw.sys.model.MessageResponse;

public class L303Response extends MessageResponse {
	private String l30301;
	private L303 l303;
	private long rowCount;
//	private List<VL303> vl301s;
	private boolean state;


	public String getL30301() {
		return l30301;
	}
	public void setL30301(String l30301) {
		this.l30301 = l30301;
	}
	public L303 getL303() {
		return l303;
	}
	public void setL303(L303 l303) {
		this.l303 = l303;
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
