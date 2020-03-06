package com.xyw.medical.fnbj.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class L402Request {
	private String l40201;
	private L402 l402;
	private String suffixSql;
	private Date timeStr;
	private Date timeEnd;
	private int parameterPageindex;
	private int parameterPagesize;
	private List<HashMap<String, Object>> picList;//图片集合
	private String flag;

	public String getSuffixSql() {
		return suffixSql;
	}
	public void setSuffixSql(String suffixSql) {
		this.suffixSql = suffixSql;
	}
	public List<HashMap<String, Object>> getPicList() {
		return picList;
	}
	public void setPicList(List<HashMap<String, Object>> picList) {
		this.picList = picList;
	}
	public String getL40201() {
		return l40201;
	}
	public void setL40201(String l40201) {
		this.l40201 = l40201;
	}
	public L402 getL402() {
		return l402;
	}
	public void setL402(L402 l402) {
		this.l402 = l402;
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
