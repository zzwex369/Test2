package com.xyw.medical.birth.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class QueryBirthResponse extends MessageResponse{
	private boolean state;
	private D301 d301;
	private VD301 vd301;
	private VD304 vd304;
	private VD505 vd505;
	private List<VD601> d601s;
	private List<VD301> listVD301;
	private List<VD302> listVD302;
	private List<VD303> listVD303;
	private List<VD304> listVD304;
	private long rowCount;
	private String flag;
	
    
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public D301 getD301() {
		return d301;
	}

	public void setD301(D301 d301) {
		this.d301 = d301;
	}

	public List<VD301> getListVD301() {
		return listVD301;
	}

	public void setListVD301(List<VD301> listVD301) {
		this.listVD301 = listVD301;
	}

	public long getRowCount() {
		return rowCount;
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}

	public List<VD302> getListVD302() {
		return listVD302;
	}

	public void setListVD302(List<VD302> listVD302) {
		this.listVD302 = listVD302;
	}

	public List<VD303> getListVD303() {
		return listVD303;
	}

	public void setListVD303(List<VD303> listVD303) {
		this.listVD303 = listVD303;
	}

	public VD301 getVd301() {
		return vd301;
	}

	public void setVd301(VD301 vd301) {
		this.vd301 = vd301;
	}

	public VD505 getVd505() {
		return vd505;
	}

	public void setVd505(VD505 vd505) {
		this.vd505 = vd505;
	}

	public List<VD601> getD601s() {
		return d601s;
	}

	public void setD601s(List<VD601> d601s) {
		this.d601s = d601s;
	}

	public VD304 getVd304() {
		return vd304;
	}

	public void setVd304(VD304 vd304) {
		this.vd304 = vd304;
	}

	public List<VD304> getListVD304() {
		return listVD304;
	}

	public void setListVD304(List<VD304> listVD304) {
		this.listVD304 = listVD304;
	}

}
