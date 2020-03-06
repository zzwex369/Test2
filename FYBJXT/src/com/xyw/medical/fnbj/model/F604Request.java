package com.xyw.medical.fnbj.model;

import java.util.HashMap;

public class F604Request {
	private String f60401;
	private F604 f604;
	private HashMap<String, Object> paramMap;
	private int parameterPageindex;
	private int parameterPagesize;
	private String flag;
	public String getF60401() {
		return f60401;
	}
	public void setF60401(String f60401) {
		this.f60401 = f60401;
	}
	public F604 getF604() {
		return f604;
	}
	public void setF604(F604 f604) {
		this.f604 = f604;
	}
	
	public HashMap<String, Object> getParamMap() {
		return paramMap;
	}
	public void setParamMap(HashMap<String, Object> paramMap) {
		this.paramMap = paramMap;
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
