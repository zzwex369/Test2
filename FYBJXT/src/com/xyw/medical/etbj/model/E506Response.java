package com.xyw.medical.etbj.model;

import com.xyw.sys.model.MessageResponse;

public class E506Response extends MessageResponse {
	private String id;
	private E506 e506;
	private long rowCount;
	private boolean state;
	

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public E506 getE506() {
		return e506;
	}
	public void setE506(E506 e506) {
		this.e506 = e506;
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
