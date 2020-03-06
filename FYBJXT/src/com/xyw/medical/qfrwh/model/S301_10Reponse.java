package com.xyw.medical.qfrwh.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class S301_10Reponse extends MessageResponse{
	private long rowCount;
	private List<VS301_10> vs301_10s;
	public S301_10 s301_10;
	
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	public List<VS301_10> getVs301_10s() {
		return vs301_10s;
	}
	public void setVs301_10s(List<VS301_10> vs301_10s) {
		this.vs301_10s = vs301_10s;
	}
	public S301_10 getS301_10() {
		return s301_10;
	}
	public void setS301_10(S301_10 s301_10) {
		this.s301_10 = s301_10;
	}
	
	

}
