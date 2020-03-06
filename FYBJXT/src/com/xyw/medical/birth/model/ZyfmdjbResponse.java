package com.xyw.medical.birth.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class ZyfmdjbResponse extends MessageResponse {
	private List<VD601> vd601s;
	private long rowCount;
	
	public List<VD601> getVd601s() {
		return vd601s;
	}
	public void setVd601s(List<VD601> vd601s) {
		this.vd601s = vd601s;
	}
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
}
