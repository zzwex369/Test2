package com.xyw.medical.fnbj.model;

import java.util.Date;

public class L301Request {
	private String l30101;
	private L301 l301;
	private Date timeStr;
	private Date timeEnd;
	private int parameterPageindex;
	private int parameterPagesize;
	private String flag;
	private String status;// 查询状态
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getL30101() {
		return l30101;
	}
	public void setL30101(String l30101) {
		this.l30101 = l30101;
	}
	public L301 getL301() {
		return l301;
	}
	public void setL301(L301 l301) {
		this.l301 = l301;
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
	
}
