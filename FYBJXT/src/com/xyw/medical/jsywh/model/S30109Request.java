package com.xyw.medical.jsywh.model;

import com.xyw.medical.jsywh.model.S30109;

public class S30109Request {
	
	private int pageIndex;
	private int pageSize;
	private S30109 s30109;
	private VS30109 vs30109;
	private String systemCode;
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public S30109 getS30109() {
		return s30109;
	}
	public void setS30109(S30109 s30109) {
		this.s30109 = s30109;
	}
	public VS30109 getVs30109() {
		return vs30109;
	}
	public void setVs30109(VS30109 vs30109) {
		this.vs30109 = vs30109;
	}
	public String getSystemCode() {
		return systemCode;
	}
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}
	
}
