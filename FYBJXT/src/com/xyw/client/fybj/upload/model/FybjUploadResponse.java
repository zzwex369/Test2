package com.xyw.client.fybj.upload.model;

import java.util.List;

import com.xyw.medical.etbj.model.VE601;
import com.xyw.sys.model.MessageResponse;

public class FybjUploadResponse extends MessageResponse{
	private List<VE601> ve601s;
	private long rowCount;
	
	public List<VE601> getVe601s() {
		return ve601s;
	}
	public void setVe601s(List<VE601> ve601s) {
		this.ve601s = ve601s;
	}
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
}
