package com.xyw.medical.fnbj.model;

import java.util.Date;
import java.util.List;

public class F601Request {
	
	private F601 f601;
	private Date timeStr;
	private Date timeEnd;
	private List<String> f60101List;
	private int parameterPageindex;
	private int parameterPagesize;
	private String flag;
	
	
	public List<String> getF60101List() {
		return f60101List;
	}
	public void setF60101List(List<String> f60101List) {
		this.f60101List = f60101List;
	}
	public F601 getF601() {
		if(f601==null)
			f601=new F601();
		return f601;
	}
	public void setF601(F601 f601) {
		this.f601 = f601;
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
