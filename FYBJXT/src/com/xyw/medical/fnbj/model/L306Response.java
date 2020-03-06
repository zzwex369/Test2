package com.xyw.medical.fnbj.model;

import java.util.List;

import com.xyw.medical.loadPicture.model.PictureMessage;

public class L306Response extends PictureMessage {
	private String suffix;
	private String flag;
	private String picNum;
	private String l30601; 
	private String picPath;
	private boolean delStatus;
	private List<VL306> vl306s;
	private String errorMessage;
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getPicNum() {
		return picNum;
	}
	public void setPicNum(String picNum) {
		this.picNum = picNum;
	}
	public String getL30601() {
		return l30601;
	}
	public void setL30601(String l30601) {
		this.l30601 = l30601;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public boolean isDelStatus() {
		return delStatus;
	}
	public void setDelStatus(boolean delStatus) {
		this.delStatus = delStatus;
	}
	public List<VL306> getVl306s() {
		return vl306s;
	}
	public void setVl306s(List<VL306> vl306s) {
		this.vl306s = vl306s;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
