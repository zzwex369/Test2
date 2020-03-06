package com.xyw.medical.birth.model;

import java.util.List;

import com.xyw.sys.model.MessageResponse;

public class StockResponse extends MessageResponse {
	private List<Stock> listStock;
	private List<VD505> listVd505;
	private long rowCount;

	public List<Stock> getListStock() {
		return listStock;
	}

	public void setListStock(List<Stock> listStock) {
		this.listStock = listStock;
	}

	public List<VD505> getListVd505() {
		return listVd505;
	}

	public void setListVd505(List<VD505> listVd505) {
		this.listVd505 = listVd505;
	}
	
	public long getRowCount() {
		return rowCount;
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
}
