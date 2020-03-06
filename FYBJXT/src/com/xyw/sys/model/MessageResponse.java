package com.xyw.sys.model;

public class MessageResponse {
	private String errorMessage;
	private String promptMessage;
	private String sessionInfo;
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
	public String getSessionInfo() {
		return sessionInfo;
	}
	public void setSessionInfo(String sessionInfo) {
		this.sessionInfo = sessionInfo;
	}
}
