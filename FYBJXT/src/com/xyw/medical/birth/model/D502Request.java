package com.xyw.medical.birth.model;

public class D502Request {
	private D502 d502;
	private VD502 vd502;
	private int parameterPageindex;
	private int parameterPagesize;
	private String institutionCode;
	public D502 getD502() {
		return d502;
	}

	public void setD502(D502 d502) {
		this.d502 = d502;
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

	public VD502 getVd502() {
		return vd502;
	}

	public void setVd502(VD502 vd502) {
		this.vd502 = vd502;
	}

	public String getInstitutionCode() {
		return institutionCode;
	}

	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}
}
