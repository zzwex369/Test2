package com.xyw.medical.fnbj.model;

import java.util.Date;
import java.util.Map;

public class F504Request {
	private F504 f504;
	private String flag;
	private Date timeStr;
	private Date timeEnd;
	private Map<String, Object> fieldMap;
	private int parameterPageindex;
	private int parameterPagesize;
	public F504 getF504() {
		return f504;
	}
	public void setF504(F504 f504) {
		this.f504 = f504;
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
	public Map<String, Object> getFieldMap() {
		return fieldMap;
	}
	public void setFieldMap(Map<String, Object> fieldMap) {
		this.fieldMap = fieldMap;
	}

	
}
