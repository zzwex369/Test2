package com.xyw.medical.birth.model;

public class D501Request {
	private D501 d501;
	private VD501 vd501;
	private int parameterPageindex;
	private int parameterPagesize;
	
	public D501 getD501() {
		return d501;
	}

	public void setD501(D501 d501) {
		this.d501 = d501;
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

	public VD501 getVd501() {
		return vd501;
	}

	public void setVd501(VD501 vd501) {
		this.vd501 = vd501;
	}
}
