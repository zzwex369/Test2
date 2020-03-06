package com.xyw.medical.birth.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class D504Response extends MessageResponse {
	private List<D504> d504s;

	private long rowCount;
	
	
	public List<D504> getD504s() {
		return d504s;
	}

	public void setD504s(List<D504> d504s) {
		this.d504s = d504s;
	}

	public long getRowCount() {
		return rowCount;
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	
}
