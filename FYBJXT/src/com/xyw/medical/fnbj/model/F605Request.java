package com.xyw.medical.fnbj.model;

import java.util.Date;
import java.util.Map;



public class F605Request {
	private String f60501;
	private F605 f605;
	private String suffixSql;
	private Date timeStr;
	private Date timeEnd;
	private int parameterPageindex;
	private int parameterPagesize;
	private String flag;
	private int codeLength;
	
	public int getCodeLength() {
		return codeLength;
	}
	public void setCodeLength(int codeLength) {
		if(codeLength==0)
			codeLength=14;
		this.codeLength = codeLength;
	}
	private Map< String, Object> fieldMap;
	public String getF60501() {
		return f60501;
	}
	public void setF60501(String f60501) {
		this.f60501 = f60501;
	}
	public F605 getF605() {
		return f605;
	}
	public void setF605(F605 f605) {
		this.f605 = f605;
	}
	public String getSuffixSql() {
		return suffixSql;
	}
	public void setSuffixSql(String suffixSql) {
		this.suffixSql = suffixSql;
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
