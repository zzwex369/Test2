package com.xyw.medical.loadPicture.model;

import java.util.List;


public class PictureMessage {
	private boolean status;
	private byte []imageByte;
	private String message;
	private long rowCount;
	private List<Object []> picArrays;//0：二进制图片，1.图片格式  2.序号

	public PictureMessage(boolean status, byte[] imageByte, String message) {
		super();
		this.status = status;
		this.imageByte = imageByte;
		this.message = message;
	}


	public long getRowCount() {
		return rowCount;
	}


	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}


	public List<Object[]> getPicArrays() {
		return picArrays;
	}


	public void setPicArrays(List<Object[]> picArrays) {
		this.picArrays = picArrays;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public byte[] getImageByte() {
		return imageByte;
	}


	public void setImageByte(byte[] imageByte) {
		this.imageByte = imageByte;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	public PictureMessage(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public PictureMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}	
