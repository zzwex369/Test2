package com.xyw.medical.etbj.model;

import java.util.Date;

public class E502Request {
	private long e50201;
	private long e50202;
	
	private E502 e502;
	private VE502 ve502;
	
	private Date timeStr;
	private Date timeEnd;
	private int parameterPageindex;
	private int parameterPagesize;
	private String flag;
	public long getE50201() {
		return e50201;
	}
	public void setE50201(long e50201) {
		this.e50201 = e50201;
	}
	public long getE50202() {
		return e50202;
	}
	public void setE50202(long e50202) {
		this.e50202 = e50202;
	}
	public E502 getE502() {
		return e502;
	}
	public void setE502(E502 e502) {
		this.e502 = e502;
	}
	public VE502 getVe502() {
		return ve502;
	}
	public void setVe502(VE502 ve502) {
		this.ve502 = ve502;
	}
	public Date getTimeStr() {
		return timeStr;
	}
	public void setTimeStr(Date timeStr) {
		this.timeStr = timeStr;
	}
	public Date getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}
	public int getParameterPageindex() {
		return parameterPageindex;
	}
	public void setParameterPageindex(int parameterPageindex) {
		this.parameterPageindex = parameterPageindex;
	}
	public int getParameterPagesize() {
		return parameterPagesize;
	}
	public void setParameterPagesize(int parameterPagesize) {
		this.parameterPagesize = parameterPagesize;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public E502Request(long e50201, long e50202, E502 e502, VE502 ve502,
			Date timeStr, Date timeEnd, int parameterPageindex,
			int parameterPagesize, String flag) {
		super();
		this.e50201 = e50201;
		this.e50202 = e50202;
		this.e502 = e502;
		this.ve502 = ve502;
		this.timeStr = timeStr;
		this.timeEnd = timeEnd;
		this.parameterPageindex = parameterPageindex;
		this.parameterPagesize = parameterPagesize;
		this.flag = flag;
	}
	public E502Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "E502Request [e502=" + e502 + ", e50201=" + e50201 + ", e50202="
				+ e50202 + ", flag=" + flag + ", parameterPageindex="
				+ parameterPageindex + ", parameterPagesize="
				+ parameterPagesize + ", timeEnd=" + timeEnd + ", timeStr="
				+ timeStr + ", ve502=" + ve502 + "]";
	}
	
}
