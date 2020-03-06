package com.xyw.medical.etbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class E503Response extends MessageResponse {
	private long e50301;
	private E503 e503;
	private List<VE503> ve503;
	private long rowCount;
	private boolean state;
	public long getE50301() {
		return e50301;
	}
	public void setE50301(long e50301) {
		this.e50301 = e50301;
	}
	public E503 getE503() {
		return e503;
	}
	public void setE503(E503 e503) {
		this.e503 = e503;
	}
	public List<VE503> getVe503() {
		return ve503;
	}
	public void setVe503(List<VE503> ve503) {
		this.ve503 = ve503;
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
