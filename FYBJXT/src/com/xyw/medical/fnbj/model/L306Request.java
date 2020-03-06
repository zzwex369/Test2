package com.xyw.medical.fnbj.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class L306Request{ 
	private L306 l306;
	private String flag;
	private String picNum;
	private String picPath;
	private String suffix;
	private Date timeStr;
	private Date timeEnd;
	private boolean delStatus;
	private List<HashMap<String, Object>> picList;
	private int parameterPageindex;
	private int parameterPagesize;
	
	
	public boolean isDelStatus() {
		return delStatus;
	}
	public void setDelStatus(boolean delStatus) {
		this.delStatus = delStatus;
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
	public String getPicNum() {
		return picNum;
	}
	public void setPicNum(String picNum) {
		this.picNum = picNum;
	}
	
	public List<HashMap<String, Object>> getPicList() {
		return picList;
	}
	public void setPicList(List<HashMap<String, Object>> picList) {
		this.picList = picList;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public L306 getL306() {
		return l306;
	}
	public void setL306(L306 l306) {
		this.l306 = l306;
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
