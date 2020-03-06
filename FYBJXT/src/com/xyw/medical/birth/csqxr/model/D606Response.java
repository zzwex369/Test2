package com.xyw.medical.birth.csqxr.model;

import java.util.List;
import com.xyw.medical.birth.csqxr.model.VD606;
import com.xyw.sys.model.MessageResponse;

public class D606Response extends MessageResponse {
	private D606 d606;
	private List<VD606> vD606s;
	private long rowCount;
	private boolean state;
	
	public D606 getD606() {
		return d606;
	}
	public void setD606(D606 d606) {
		this.d606 = d606;
	}
	public List<VD606> getvD606s() {
		return vD606s;
	}
	public void setvD606s(List<VD606> vD606s) {
		this.vD606s = vD606s;
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
}
