package com.xyw.sys.model;

import java.util.List;

public class AssistResponse extends MessageResponse {
	private List<D807> listD807;
	private long rowCount;
	private D807 d807;
	
	public List<D807> getListD807() {
		return listD807;
	}

	public void setListD807(List<D807> listD807) {
		this.listD807 = listD807;
	}

	public long getRowCount() {
		return rowCount;
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}

	public D807 getD807() {
		return d807;
	}

	public void setD807(D807 d807) {
		this.d807 = d807;
	}
}
