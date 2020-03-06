package com.xyw.medical.fnbj.model;

import java.util.List;
import java.util.Map;

import com.xyw.sys.model.MessageResponse;

public class F601Response extends MessageResponse{
	private F601 f601;
	private List<VF601> vf601s;
	private Map<String, Object> f601Map;
	private long rowCount;
	private boolean state;
	
	public Map<String, Object> getF601Map() {
		return f601Map;
	}
	public void setF601Map(Map<String, Object> f601Map) {
		this.f601Map = f601Map;
	}
	public F601 getF601() {
		return f601;
	}
	public void setF601(F601 f601) {
		this.f601 = f601;
	}
	public List<VF601> getVf601s() {
		return vf601s;
	}
	public void setVf601s(List<VF601> vf601s) {
		this.vf601s = vf601s;
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
