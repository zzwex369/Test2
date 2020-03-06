package com.xyw.medical.birth.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class D401Response extends MessageResponse{
	private List<VD401> vd401s;
	private D401 d401;
	private long rowCount;
	
	public List<VD401> getVd401s() {
		return vd401s;
	}
	public void setVd401s(List<VD401> vd401s) {
		this.vd401s = vd401s;
	}
	public D401 getD401() {
		return d401;
	}
	public void setD401(D401 d401) {
		this.d401 = d401;
	}
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	
}
