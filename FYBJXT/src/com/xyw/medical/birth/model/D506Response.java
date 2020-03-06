package com.xyw.medical.birth.model;

import java.util.List;
import com.xyw.sys.model.MessageResponse;

public class D506Response extends MessageResponse {
	private long rowCount;
	private List<VD506> vd506s;
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	public List<VD506> getVd506s() {
		return vd506s;
	}
	public void setVd506s(List<VD506> vd506s) {
		this.vd506s = vd506s;
	}
	
}
