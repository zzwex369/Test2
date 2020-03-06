package com.xyw.medical.birth.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class D502Response extends MessageResponse{
	private List<VD502> vd502s;

	private long rowCount;
	
	
	public List<VD502> getVd502s() {
		return vd502s;
	}

	public void setVd502s(List<VD502> vd502s) {
		this.vd502s = vd502s;
	}

	public long getRowCount() {
		return rowCount;
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
}
