package com.xyw.client.upload.model;

import java.util.List;

import com.xyw.medical.birth.model.VD301;
import com.xyw.medical.birth.model.VD304;
import com.xyw.medical.birth.model.VD305;
import com.xyw.medical.birth.model.VD401;
import com.xyw.medical.birth.model.VD501;
import com.xyw.medical.birth.model.VD502;
import com.xyw.medical.birth.model.VD601;
import com.xyw.sys.model.MessageResponse;

public class UploadResponse extends MessageResponse {
	private List<VD501> vd501s;
	private List<VD502> vd502s;
	private List<VD601> vd601s;
	private List<VD301> vd301s;
	private List<VD401> vd401s;
	private List<VD304> vd304s;
	private List<VD305> vd305s;
	private long rowCount;
	
	public List<VD501> getVd501s() {
		return vd501s;
	}
	public void setVd501s(List<VD501> vd501s) {
		this.vd501s = vd501s;
	}
	public List<VD502> getVd502s() {
		return vd502s;
	}
	public void setVd502s(List<VD502> vd502s) {
		this.vd502s = vd502s;
	}
	public List<VD601> getVd601s() {
		return vd601s;
	}
	public void setVd601s(List<VD601> vd601s) {
		this.vd601s = vd601s;
	}
	public List<VD301> getVd301s() {
		return vd301s;
	}
	public void setVd301s(List<VD301> vd301s) {
		this.vd301s = vd301s;
	}
	public List<VD401> getVd401s() {
		return vd401s;
	}
	public void setVd401s(List<VD401> vd401s) {
		this.vd401s = vd401s;
	}
	public List<VD304> getVd304s() {
		return vd304s;
	}
	public void setVd304s(List<VD304> vd304s) {
		this.vd304s = vd304s;
	}
	public List<VD305> getVd305s() {
		return vd305s;
	}
	public void setVd305s(List<VD305> vd305s) {
		this.vd305s = vd305s;
	}
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
}
