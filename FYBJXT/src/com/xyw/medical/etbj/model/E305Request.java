package com.xyw.medical.etbj.model;

import java.util.Date;

public class E305Request {
	
	private E305 e305;
	private Date timeStart;//随访起始时间
	private Date timeEnd;//随访结束时间
	private int parameterPageindex;
	private int parameterPagesize;
	private String flag;
	private String f301_02;
	private String f301_05;
	public E305 getE305() {
		if(e305==null)
			e305=new E305();
		return e305;
	}
	public void setE305(E305 e305) {
		this.e305 = e305;
	}
	public Date getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}
	public Date getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
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
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getF301_02() {
		return f301_02;
	}
	public void setF301_02(String f301_02) {
		this.f301_02 = f301_02;
	}
	public String getF301_05() {
		return f301_05;
	}
	public void setF301_05(String f301_05) {
		this.f301_05 = f301_05;
	}
	
	
}
