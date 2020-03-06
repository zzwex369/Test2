package com.xyw.medical.etbj.model;

import java.util.Date;
import java.util.List;

public class E601Request {
	private E601 e601;
	private Date timeStr;
	private Date timeEnd;
	private List<String> e60101List;
	private int parameterPageindex;
	private int parameterPagesize;
	private String DateField;
	private String flag;
	
	public List<String> getE60101List() {
		return e60101List;
	}
	public void setE60101List(List<String> e60101List) {
		this.e60101List = e60101List;
	}
	public E601 getE601() {
		if(e601==null)
			e601=new E601();
		return e601;
	}
	public void setE601(E601 e601) {
		this.e601 = e601;
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
	public String getDateField() {
		return DateField;
	}
	public void setDateField(String dateField) {
		DateField = dateField;
	}
	
	
	
}
