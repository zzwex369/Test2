package com.xyw.medical.birth.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class D505Response extends MessageResponse {
	private List<VD505> vd505s;

	private long rowCount;

	public List<VD505> getVd505s() {
		return vd505s;
	}

	public void setVd505s(List<VD505> vd505s) {
		this.vd505s = vd505s;
	}

	public long getRowCount() {
		return rowCount;
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
}
