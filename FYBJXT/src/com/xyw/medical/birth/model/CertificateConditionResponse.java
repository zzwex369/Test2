package com.xyw.medical.birth.model;

import java.util.List;

import com.xyw.medical.birth.report.model.BirthTemp;
import com.xyw.medical.birth.report.model.ReportGenderTemp;
import com.xyw.sys.model.MessageResponse;

public class CertificateConditionResponse extends MessageResponse {
	
	private List<ReportGenderTemp> listReportGenderTemp;
	private List<BirthTemp> birthTemps;
	private List<ConditionTemp> conditionTemps;
	private List<VD301> vd301s;
	private long rowCount;
	private String flag;

	public List<ReportGenderTemp> getListReportGenderTemp() {
		return listReportGenderTemp;
	}
	public void setListReportGenderTemp(List<ReportGenderTemp> listReportGenderTemp) {
		this.listReportGenderTemp = listReportGenderTemp;
	}
	public List<BirthTemp> getBirthTemps() {
		return birthTemps;
	}
	public void setBirthTemps(List<BirthTemp> birthTemps) {
		this.birthTemps = birthTemps;
	}
	public List<ConditionTemp> getConditionTemps() {
		return conditionTemps;
	}
	public void setConditionTemps(List<ConditionTemp> conditionTemps) {
		this.conditionTemps = conditionTemps;
	}
	public List<VD301> getVd301s() {
		return vd301s;
	}
	public void setVd301s(List<VD301> vd301s) {
		this.vd301s = vd301s;
	}
	public long getRowCount() {
		return rowCount;
	}
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
