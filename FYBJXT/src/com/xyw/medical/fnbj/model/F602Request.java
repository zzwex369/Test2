package com.xyw.medical.fnbj.model;

import java.util.Date;
import java.util.List;

public class F602Request {
	private F602 f602;
	private F601 f601;
	private Date timeStr;
	private Date timeEnd;
	private List<String> f60201List;
	private List<F602> f602List;
	private int parameterPageindex;
	private int parameterPagesize;
	private String flag;
	
	public F601 getF601() {
		return f601;
	}
	public void setF601(F601 f601) {
		this.f601 = f601;
	}
	public List<F602> getF602List() {
		return f602List;
	}
	public void setF602List(List<F602> f602List) {
		this.f602List = f602List;
	}
	public List<String> getF60201List() {
		return f60201List;
	}
	public void setF60201List(List<String> f60201List) {
		this.f60201List = f60201List;
	}
	public F602 getF602() {
		if(f602==null)
			f602=new F602();
		return f602;
	}
	public void setF602(F602 f602) {
		this.f602 = f602;
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
