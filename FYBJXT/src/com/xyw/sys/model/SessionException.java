package com.xyw.sys.model;

public class SessionException extends RuntimeException {
	private static final long serialVersionUID = 7405259392303275457L;
	private String errorCode;
	private String errorMessage;
	public SessionException() {
		
	}
	public SessionException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
