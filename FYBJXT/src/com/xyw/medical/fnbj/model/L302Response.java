package com.xyw.medical.fnbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class L302Response extends MessageResponse {
	private String l30201;
	private L302 l302;
	private long rowCount;
	private List<VL302> vl302s;
	private boolean state;

	public String getL30201() {
		return l30201;
	}
	public void setL30201(String l30201) {
		this.l30201 = l30201;
	}
	public L302 getL302() {
		return l302;
	}
	public void setL302(L302 l302) {
		this.l302 = l302;
	}
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	public List<VL302> getVl302s() {
		return vl302s;
	}
	public void setVl302s(List<VL302> vl302s) {
		this.vl302s = vl302s;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
}
