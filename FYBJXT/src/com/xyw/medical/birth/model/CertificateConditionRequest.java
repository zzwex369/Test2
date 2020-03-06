package com.xyw.medical.birth.model;

import java.util.Date;


public class CertificateConditionRequest {
	
	private Date date_start;
	private Date date_end;
	
	private String institution;
	private String institutionType;
	
	private String areacode;
	private String areacodeZh;
	private String areacodeType;
	
	private String flag;
	
	private int parameterPageindex;
	private int parameterPagesize;
	
	public Date getDate_start() {
		return date_start;
	}
	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}
	public Date getDate_end() {
		return date_end;
	}
	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getInstitutionType() {
		return institutionType;
	}
	public void setInstitutionType(String institutionType) {
		this.institutionType = institutionType;
	}
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getAreacodeZh() {
		return areacodeZh;
	}
	public void setAreacodeZh(String areacodeZh) {
		this.areacodeZh = areacodeZh;
	}
	public String getAreacodeType() {
		return areacodeType;
	}
	public void setAreacodeType(String areacodeType) {
		this.areacodeType = areacodeType;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
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
	
}
