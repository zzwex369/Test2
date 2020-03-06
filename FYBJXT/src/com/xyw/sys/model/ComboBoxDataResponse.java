package com.xyw.sys.model;

import java.util.List;

public class ComboBoxDataResponse {
	private List<ComboBoxData> comboBoxDataList;
	private String flag;
	private boolean showPrompt;
	public ComboBoxDataResponse(){}
	
	public List<ComboBoxData> getComboBoxDataList() {
		return comboBoxDataList;
	}

	public void setComboBoxDataList(List<ComboBoxData> comboBoxDataList) {
		this.comboBoxDataList = comboBoxDataList;
	}

	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public boolean getShowPrompt() {
		return showPrompt;
	}

	public void setShowPrompt(boolean showPrompt) {
		this.showPrompt = showPrompt;
	}
	
}
