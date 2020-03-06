package com.xyw.medical.common.et.yey.model;

import java.util.Date;



public class E705Request {

	private E705 e705;
	private Date timeStr;
	private Date timeEnd;
	private String e70501;
	private String e70504;
	private int parameterPageindex;
	private int parameterPagesize;
	private String flag;
	public E705 getE705() {
		return e705;
	}
	public void setE705(E705 e705) {
		this.e705 = e705;
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
	public String getE70501() {
		return e70501;
	}
	public void setE70501(String e70501) {
		this.e70501 = e70501;
	}
	public String getE70504() {
		return e70504;
	}
	public void setE70504(String e70504) {
		this.e70504 = e70504;
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

	
}
