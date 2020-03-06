package com.xyw.medical.ycfsw.model;

import java.util.List;
import com.xyw.medical.ycfsw.model.VD604;
import com.xyw.sys.model.MessageResponse;

public class D604Response extends MessageResponse{
	private long rowCount;
	private List<VD604> vD604s;
	private D604 d604;
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	public List<VD604> getvD604s() {
		return vD604s;
	}
	public void setvD604s(List<VD604> vD604s) {
		this.vD604s = vD604s;
	}
	public D604 getD604() {
		return d604;
	}
	public void setD604(D604 d604) {
		this.d604 = d604;
	}
	
	
	
	

}
