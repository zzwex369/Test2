package com.xyw.medical.birth.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class D605Response extends MessageResponse{
	private long d60501;
	private long rowCount;
	private List<VD605> vd605s;
	public long getD60501() {
		return d60501;
	}
	public void setD60501(long d60501) {
		this.d60501 = d60501;
	}
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	public List<VD605> getVd605s() {
		return vd605s;
	}
	public void setVd605s(List<VD605> vd605s) {
		this.vd605s = vd605s;
	}
	
}
