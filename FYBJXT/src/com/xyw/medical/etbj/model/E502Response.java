package com.xyw.medical.etbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;
/**
 * @author libo
 * 创建时间：Jun 17, 2017 10:20:21 AM
 */
public class E502Response extends MessageResponse {
	private long e50201;
	private E502 e502;
	private List<VE502> ve502;
	private long rowCount;
	private boolean state;
	public long getE50201() {
		return e50201;
	}
	public void setE50201(long e50201) {
		this.e50201 = e50201;
	}
	public E502 getE502() {
		return e502;
	}
	public void setE502(E502 e502) {
		this.e502 = e502;
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
	
	public List<VE502> getVe502() {
		return ve502;
	}
	public void setVe502(List<VE502> ve502) {
		this.ve502 = ve502;
	}
	
	public E502Response(long e50201, E502 e502, List<VE502> ve502,
			long rowCount, boolean state) {
		super();
		this.e50201 = e50201;
		this.e502 = e502;
		this.ve502 = ve502;
		this.rowCount = rowCount;
		this.state = state;
	}
	public E502Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "E502Response [e502=" + e502 + ", e50201=" + e50201
				+ ", rowCount=" + rowCount + ", state=" + state + ", ve502="
				+ ve502 + "]";
	}
	
	
}
