package com.xyw.medical.etbj.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;
/**
 * @author libo
 * 创建时间：Jun 17, 2017 11:45:43 AM
 */
public class E501Response extends MessageResponse {
	private long e50101;
	private E501 e501;
	private List<VE501> ve501;
	private long rowCount;
	private boolean state;
	
	public List<VE501> getVe501() {
		return ve501;
	}
	public void setVe501(List<VE501> ve501) {
		this.ve501 = ve501;
	}
	public long getE50101() {
		return e50101;
	}
	public void setE50101(long e50101) {
		this.e50101 = e50101;
	}
	public E501 getE501() {
		return e501;
	}
	public void setE501(E501 e501) {
		this.e501 = e501;
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
	public E501Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public E501Response(long e50101, E501 e501, List<VE501> ve501,
			long rowCount, boolean state) {
		super();
		this.e50101 = e50101;
		this.e501 = e501;
		this.ve501 = ve501;
		this.rowCount = rowCount;
		this.state = state;
	}
	@Override
	public String toString() {
		return "E501Response [e501=" + e501 + ", e50101=" + e50101
				+ ", rowCount=" + rowCount + ", state=" + state + ", ve501="
				+ ve501 + "]";
	}
	
}
