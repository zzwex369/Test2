package com.xyw.medical.etbj.model;

import java.util.Date;
import java.util.Map;

public class E505Request {
	private String e50501;
	private E505 e505;
	private VE505 ve505;
	private Date timeStr;
	private Date timeEnd;
	private  int parameterPageindex;
	private  int parameterPagesize;
	private String flag;
	private String suffixSql;

	private Map<String, Object>map;
	
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public String getE50501() {
		return e50501;
	}
	public void setE50501(String e50501) {
		this.e50501 = e50501;
	}
	public E505 getE505() {
		return e505;
	}
	public void setE505(E505 e505) {
		this.e505 = e505;
	}
	public VE505 getVe505() {
		return ve505;
	}
	public void setVe505(VE505 ve505) {
		this.ve505 = ve505;
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
	public String getSuffixSql() {
		return suffixSql;
	}
	public void setSuffixSql(String suffixSql) {
		this.suffixSql = suffixSql;
	}
	
}
