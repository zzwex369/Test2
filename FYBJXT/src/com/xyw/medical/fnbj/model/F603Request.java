package com.xyw.medical.fnbj.model;

import java.util.Date;
import java.util.HashMap;

public class F603Request {
	private String f60301;
	private F603 f603;
	private HashMap<String, Object> paramMap;
	private int parameterPageindex;
	private int parameterPagesize;
	private String flag;
	public String getF60301() {
		return f60301;
	}
	public void setF60301(String f60301) {
		this.f60301 = f60301;
	}
	public F603 getF603() {
		return f603;
	}
	public void setF603(F603 f603) {
		this.f603 = f603;
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
