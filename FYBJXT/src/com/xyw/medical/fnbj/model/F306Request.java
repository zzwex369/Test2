package com.xyw.medical.fnbj.model;


public class F306Request {
	private F305 f306;
	private VF305 vf306;
	private String f30102;
	private String f30105;
	private String jigou;
	private String timeStr;
	private String timeEnd;
	private String f30601;
	private int parameterPageindex;
	private int parameterPagesize;
	private String errorMessage;
	private String promptMessage;
	private String flag;
	public F305 getF306() {
		return f306;
	}
	public void setF306(F305 f306) {
		this.f306 = f306;
	}
	public VF305 getVf306() {
		return vf306;
	}
	public void setVf306(VF305 vf306) {
		this.vf306 = vf306;
	}
	public String getF30102() {
		return f30102;
	}
	public void setF30102(String f30102) {
		this.f30102 = f30102;
	}
	public String getF30105() {
		return f30105;
	}
	public void setF30105(String f30105) {
		this.f30105 = f30105;
	}
	public String getJigou() {
		return jigou;
	}
	public void setJigou(String jigou) {
		this.jigou = jigou;
	}
	public String getTimeStr() {
		return timeStr;
	}
	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getF30601() {
		return f30601;
	}
	public void setF30601(String f30601) {
		this.f30601 = f30601;
	}
	public int getParameterPageindex() {
		return parameterPageindex;
	}
	public void setParameterPageindex(int parameterPageindex) {
		this.parameterPageindex = parameterPageindex;
	}
	public int getParameterPagesize() {
		return parameterPagesize;
	}
	public void setParameterPagesize(int parameterPagesize) {
		this.parameterPagesize = parameterPagesize;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getPromptMessage() {
		return promptMessage;
	}
	public void setPromptMessage(String promptMessage) {
		this.promptMessage = promptMessage;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
