package com.xyw.medical.fnbj.model;

import java.util.Date;

public class F303Request {
	private F303 f303;
	private VF303 vf303;
	private int zhujian;
	private String jigou;
	private Date timeStr;
	private Date timeEnd;
	private String name;
	private String idcard;
	private int parameterPageindex;
	private int parameterPagesize;
	private String errorMessage;
	private String promptMessage;
	private String flag;
	private String f303123;
	private String f303123_flag;
	private Date f303128;
	private Date F303128Start;
	private Date F303128End;

	public Date getF303128Start() {
		return F303128Start;
	}
	public void setF303128Start(Date f303128Start) {
		F303128Start = f303128Start;
	}
	public Date getF303128End() {
		return F303128End;
	}
	public void setF303128End(Date f303128End) {
		F303128End = f303128End;
	}

	public Date getF303128() {
		return f303128;
	}
	public void setF303128(Date f303128) {
		this.f303128 = f303128;
	}
	public F303 getF303() {
		return f303;
	}
	public void setF303(F303 f303) {
		this.f303 = f303;
	}
	public VF303 getVf303() {
		return vf303;
	}
	public void setVf303(VF303 vf303) {
		this.vf303 = vf303;
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
	public String getJigou() {
		return jigou;
	}
	public void setJigou(String jigou) {
		this.jigou = jigou;
	}
	public Date getTimeStr() {
		return timeStr;
	}
	public void setTimeStr(Date timeStr) {
		this.timeStr = timeStr;
	}
	public Date getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getZhujian() {
		return zhujian;
	}
	public void setZhujian(int zhujian) {
		this.zhujian = zhujian;
	}
	public String getF303123_flag() {
		return f303123_flag;
	}
	public void setF303123_flag(String f303123_flag) {
		this.f303123_flag = f303123_flag;
	}
	public String getF303123() {
		return f303123;
	}
	public void setF303123(String f303123) {
		this.f303123 = f303123;
	}
	
}
