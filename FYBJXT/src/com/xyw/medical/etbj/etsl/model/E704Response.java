package com.xyw.medical.etbj.etsl.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class E704Response extends MessageResponse{

	private boolean falg;
	/**
	 * 1 重复数据
	 * 2出现异常
	 * 3没有数据
	 */
	private int state;
	private VE704 ve704;
	private List<VE704> ve704s;
	private long rowCount;
	public boolean isFalg() {
		return falg;
	}
	public void setFalg(boolean falg) {
		this.falg = falg;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public VE704 getVe704() {
		return ve704;
	}
	public void setVe704(VE704 ve704) {
		this.ve704 = ve704;
	}
	public List<VE704> getVe704s() {
		return ve704s;
	}
	public void setVe704s(List<VE704> ve704s) {
		this.ve704s = ve704s;
	}
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	
	
	
}
