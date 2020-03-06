package com.xyw.sys.model;

public class SysView02Request {
	private int parameterPageindex;
	private int parameterPagesize;
	private SysView02 sysView02;
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
	public SysView02 getSysView02() {
		return sysView02;
	}
	public void setSysView02(SysView02 sysView02) {
		this.sysView02 = sysView02;
	}
}
