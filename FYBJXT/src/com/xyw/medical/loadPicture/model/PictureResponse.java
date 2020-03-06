package com.xyw.medical.loadPicture.model;

import java.util.List;

public class PictureResponse extends PictureMessage {
	private long rowCount;
	private List<VPicture> vp;
	private Pictures pictures;
	private VPicture vPicture;
	
	public PictureResponse(boolean status, byte[] imageByte, String message,
			long rowCount, List<VPicture> vp, Pictures pictures,
			VPicture vPicture) {
		this.rowCount = rowCount;
		this.vp = vp;
		this.pictures = pictures;
		this.vPicture = vPicture;
	}

	public long getRowCount() {
		return rowCount;
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}

	public List<VPicture> getVp() {
		return vp;
	}

	public void setVp(List<VPicture> vp) {
		this.vp = vp;
	}

	public Pictures getPictures() {
		return pictures;
	}

	public void setPictures(Pictures pictures) {
		this.pictures = pictures;
	}

	public VPicture getvPicture() {
		return vPicture;
	}

	public void setvPicture(VPicture vPicture) {
		this.vPicture = vPicture;
	}

	public PictureResponse() {
		// TODO Auto-generated constructor stub
	}

}
