package com.xyw.sys.model;

import java.io.Serializable;

public class ComboBoxData implements Serializable{
	private static final long serialVersionUID = 6793761416856658230L;

	private String data;
	
	private String label;
	
	public ComboBoxData(){
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}