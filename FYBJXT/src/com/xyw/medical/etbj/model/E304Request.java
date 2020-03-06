package com.xyw.medical.etbj.model;

import java.util.Date;

public class E304Request {
	private E304 e304;
	private long count_e30402;//月龄查询用
	private Date e30405Start;//随访起始时间
	private Date e30405End;//随访结束时间
	private int parameterPageindex;
	private int parameterPagesize;
	private String flag;
	private String sql;
	private String f301_02;
	private String f301_05;
	
	private String e30402start;
	private String e30402end;
	
	private Date e30451start;
	private Date e30451end;
	
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public E304 getE304() {
		if(e304==null)
			e304=new E304();
		return e304;
	}
	public void setE304(E304 e304) {
		this.e304 = e304;
	}
	public long getCount_e30402() {
		return count_e30402;
	}
	public void setCount_e30402(long countE30402) {
		count_e30402 = countE30402;
	}
	public Date getE30405Start() {
		return e30405Start;
	}
	public void setE30405Start(Date e30405Start) {
		this.e30405Start = e30405Start;
	}
	public Date getE30405End() {
		return e30405End;
	}
	public void setE30405End(Date e30405End) {
		this.e30405End = e30405End;
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
	public String getE30402start() {
		return e30402start;
	}
	public void setE30402start(String e30402start) {
		this.e30402start = e30402start;
	}
	public String getE30402end() {
		return e30402end;
	}
	public void setE30402end(String e30402end) {
		this.e30402end = e30402end;
	}
	public Date getE30451start() {
		return e30451start;
	}
	public void setE30451start(Date e30451start) {
		this.e30451start = e30451start;
	}
	public Date getE30451end() {
		return e30451end;
	}
	public void setE30451end(Date e30451end) {
		this.e30451end = e30451end;
	}
	
}
