package com.xyw.medical.fnbj.model;

import java.util.Date;

public class F606Request {

	/**
	 * 单位代码
	 */
	private String f606_67;
	/**
	 * 姓名
	 */
	private String f606_03;
	/**
	 * 证件号码
	 */
	private String f606_05;
	/**
	 * 开始时间
	 */
	private Date timeStr;
	/**
	 * 结束时间
	 */
	private Date timeEnd;
	/**
	 * 主键
	 */
	private String zhujian;
	/**
	 * 页面开始下标
	 */
	private Integer parameterPageindex;
	/**
	 * 数量
	 */
	private Integer parameterPagesize;
	public String getF606_67() {
		return f606_67;
	}
	public void setF606_67(String f606_67) {
		this.f606_67 = f606_67;
	}
	public String getF606_03() {
		return f606_03;
	}
	public void setF606_03(String f606_03) {
		this.f606_03 = f606_03;
	}
	public String getF606_05() {
		return f606_05;
	}
	public void setF606_05(String f606_05) {
		this.f606_05 = f606_05;
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
	public String getZhujian() {
		return zhujian;
	}
	public void setZhujian(String zhujian) {
		this.zhujian = zhujian;
	}
	public Integer getParameterPageindex() {
		return parameterPageindex;
	}
	public void setParameterPageindex(Integer parameterPageindex) {
		this.parameterPageindex = parameterPageindex;
	}
	public Integer getParameterPagesize() {
		return parameterPagesize;
	}
	public void setParameterPagesize(Integer parameterPagesize) {
		this.parameterPagesize = parameterPagesize;
	}
	
}
