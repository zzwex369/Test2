package com.xyw.medical.etbj.etsl.model;

import java.util.Date;

public class E704Request {

	
	private String zhujian;
	private String e70403;
	private String e70404;
	private Date e70406_str;
	private Date e70406_end;
	private Date e70416_str;
	private Date e70416_end;
	private String jigou;
	private int parameterPageindex;
	private int parameterPagesize;
	
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
	public String getZhujian() {
		return zhujian;
	}
	public void setZhujian(String zhujian) {
		this.zhujian = zhujian;
	}
	public String getE70403() {
		return e70403;
	}
	public void setE70403(String e70403) {
		this.e70403 = e70403;
	}
	public String getE70404() {
		return e70404;
	}
	public void setE70404(String e70404) {
		this.e70404 = e70404;
	}
	public Date getE70406_str() {
		return e70406_str;
	}
	public void setE70406_str(Date e70406Str) {
		e70406_str = e70406Str;
	}
	public Date getE70406_end() {
		return e70406_end;
	}
	public void setE70406_end(Date e70406End) {
		e70406_end = e70406End;
	}
	public Date getE70416_str() {
		return e70416_str;
	}
	public void setE70416_str(Date e70416Str) {
		e70416_str = e70416Str;
	}
	public Date getE70416_end() {
		return e70416_end;
	}
	public void setE70416_end(Date e70416End) {
		e70416_end = e70416End;
	}
	public String getJigou() {
		return jigou;
	}
	public void setJigou(String jigou) {
		this.jigou = jigou;
	}
	

}
