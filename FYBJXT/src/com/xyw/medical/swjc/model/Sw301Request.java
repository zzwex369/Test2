package com.xyw.medical.swjc.model;

import java.util.Date;

public class Sw301Request {
	private String sw30101;
	private Sw301 sw301;
	private Date timeStr;
	private Date timeEnd;
	private int parameterPageindex;
	private int parameterPagesize;
	private String flag;
	private String suffixSql;
	private String resType;//返回类型 对应 Sw301Response 属性顺序 1 主键 2 对象  3 视图

	public String getSw30101() {
		return sw30101;
	}
	public void setSw30101(String sw30101) {
		this.sw30101 = sw30101;
	}
	public Sw301 getSw301() {
		return sw301;
	}
	public void setSw301(Sw301 sw301) {
		this.sw301 = sw301;
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
	public String getResType() {
		return resType;
	}
	public void setResType(String resType) {
		this.resType = resType;
	}
	
	
	
}
