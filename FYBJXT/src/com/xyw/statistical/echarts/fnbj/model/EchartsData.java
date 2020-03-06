package com.xyw.statistical.echarts.fnbj.model;

import java.io.Serializable;
import java.util.Map;

public class EchartsData implements Serializable{
	private static final long serialVersionUID = 6793761416856658230L;

	private Map<String, Object> data;

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
}