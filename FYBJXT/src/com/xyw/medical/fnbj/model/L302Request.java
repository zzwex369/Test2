package com.xyw.medical.fnbj.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;



public class L302Request {
	private String l30201;
	private String l30202;
	private L302 l302;
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
	public String getL30201() {
		return l30201;
	}
	public void setL30201(String l30201) {
		this.l30201 = l30201;
	}
	public String getL30202() {
		return l30202;
	}
	public void setL30202(String l30202) {
		this.l30202 = l30202;
	}
	public L302 getL302() {
		return l302;
	}
	public void setL302(L302 l302) {
		this.l302 = l302;
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
	public List<HashMap<String, Object>> getPicList() {
		return picList;
	}
	public void setPicList(List<HashMap<String, Object>> picList) {
		this.picList = picList;
	}
	
	
}
