package com.xyw.medical.birth.model;

public class D401Request {
	private D401 d401;
	private VD401 vd401;
	private int parameterPageindex;
	private int parameterPagesize;
	private String code;//原签发单位
	
	public D401 getD401() {
		return d401;
	}

	public void setD401(D401 d401) {
		this.d401 = d401;
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

	public VD401 getVd401() {
		return vd401;
	}

	public void setVd401(VD401 vd401) {
		this.vd401 = vd401;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
