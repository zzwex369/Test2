package com.xyw.medical.common.et.yey.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class E705Response extends MessageResponse {
	private String e70501;
	private E705 e705;
	private long rowCount;
	private List<VE705> ve705s;
	private boolean state;
	public String getE70501() {
		return e70501;
	}
	public void setE70501(String e70501) {
		this.e70501 = e70501;
	}
	public E705 getE705() {
		return e705;
	}
	public void setE705(E705 e705) {
		this.e705 = e705;
	}
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	public List<VE705> getVe705s() {
		return ve705s;
	}
	public void setVe705s(List<VE705> ve705s) {
		this.ve705s = ve705s;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	
}
