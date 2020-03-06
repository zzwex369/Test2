package com.xyw.medical.rws.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class RwsResponse extends MessageResponse{

	private boolean state;
	private Long rowCount;
	private List<Rws> rwss;
	private Rws rws;
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Long getRowCount() {
		return rowCount;
	}
	public void setRowCount(Long rowCount) {
		this.rowCount = rowCount;
	}
	public List<Rws> getRwss() {
		return rwss;
	}
	public void setRwss(List<Rws> rwss) {
		this.rwss = rwss;
	}
	public Rws getRws() {
		return rws;
	}
	public void setRws(Rws rws) {
		this.rws = rws;
	}

	
}
