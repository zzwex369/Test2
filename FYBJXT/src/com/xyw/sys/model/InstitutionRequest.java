package com.xyw.sys.model;

public class InstitutionRequest {
	private String institutionCode;
	private boolean showPrompt;
	private boolean flag;
	private String institutionFlag;
	public String getInstitutionCode() {
		return institutionCode;
	}

	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}

	public boolean isShowPrompt() {
		return showPrompt;
	}

	public void setShowPrompt(boolean showPrompt) {
		this.showPrompt = showPrompt;
	}

	public String getInstitutionFlag() {
		return institutionFlag;
	}

	public void setInstitutionFlag(String institutionFlag) {
		this.institutionFlag = institutionFlag;
	}

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
