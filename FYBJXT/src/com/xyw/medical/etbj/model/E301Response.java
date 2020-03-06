package com.xyw.medical.etbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class E301Response extends MessageResponse {
	private long e30101;
	private String e30103;//儿童姓名
	private VE301 ve301;
	private List<VE301> ve301s;
	private long rowCount;
	private boolean state;
	
	public long getE30101() {
		return e30101;
	}
	public void setE30101(long e30101) {
		this.e30101 = e30101;
	}
	public VE301 getVe301() {
		return ve301;
	}
	public void setVe301(VE301 ve301) {
		this.ve301 = ve301;
	}
	public List<VE301> getVe301s() {
		return ve301s;
	}
	public void setVe301s(List<VE301> ve301s) {
		this.ve301s = ve301s;
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
	public String getE30103() {
		return e30103;
	}
	public void setE30103(String e30103) {
		this.e30103 = e30103;
	}
	
}
