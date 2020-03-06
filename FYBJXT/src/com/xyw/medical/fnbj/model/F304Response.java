package com.xyw.medical.fnbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;
import com.xyw.medical.fnbj.model.F304;

public class F304Response extends MessageResponse {
	private long f30401;
	private long f30402;
	private long rowCount;
	private F304 f304;
	private List<VF304> vf304s;
	
	private boolean state;
	
	public long getF30401() {
		return f30401;
	}
	public void setF30401(long f30401) {
		this.f30401 = f30401;
	}
	public long getF30402() {
		return f30402;
	}
	public void setF30402(long f30402) {
		this.f30402 = f30402;
	}
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	public F304 getF304() {
		return f304;
	}
	public void setF304(F304 f304) {
		this.f304 = f304;
	}
	public List<VF304> getVf304s() {
		return vf304s;
	}
	public void setVf304s(List<VF304> vf304s) {
		this.vf304s = vf304s;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
   
}
