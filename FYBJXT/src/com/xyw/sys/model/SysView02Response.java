package com.xyw.sys.model;

import java.util.List;

public class SysView02Response extends MessageResponse {
	private List<SysView02> sysView02List;
	private long rowCount;
	public List<SysView02> getSysView02List() {
		return sysView02List;
	}

	public void setSysView02List(List<SysView02> sysView02List) {
		this.sysView02List = sysView02List;
	}

	public long getRowCount() {
		return rowCount;
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	
}
