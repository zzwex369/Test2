package com.xyw.medical.etbj.etsl.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class E702Request {
	private String e70201;
	private E702 e702;
	private String suffixSql;
	private Date timeStr;
	private Date timeEnd;
	private String parent_name;
	private String parent_idcard;
	private String parent_phone;
	private String institution;
	private int parameterPageindex;
	private int parameterPagesize;
	private String flag;//用于保存月龄的下标
	private int codeLength;
	private Map< String, Object> fieldMap;
	public String getE70201() {
		return e70201;
	}
	public void setE70201(String e70201) {
		this.e70201 = e70201;
	}
	public E702 getE702() {
		if(e702==null)
			e702=new E702();
		return e702;
	}
	public void setE702(E702 e702) {
		this.e702 = e702;
	}
	public String getSuffixSql() {
		return suffixSql;
	}
	public void setSuffixSql(String suffixSql) {
		this.suffixSql = suffixSql;
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
	public int getCodeLength() {
		return codeLength;
	}
	public void setCodeLength(int codeLength) {
		this.codeLength = codeLength;
	}
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parentName) {
		parent_name = parentName;
	}
	public String getParent_idcard() {
		return parent_idcard;
	}
	public void setParent_idcard(String parentIdcard) {
		parent_idcard = parentIdcard;
	}
	public String getParent_phone() {
		return parent_phone;
	}
	public void setParent_phone(String parentPhone) {
		parent_phone = parentPhone;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public Map<String, Object> getFieldMap() {
		return fieldMap;
	}
	public void setFieldMap(Map<String, Object> fieldMap) {
		if(fieldMap==null){
			fieldMap=new HashMap<String, Object>();
			fieldMap.put("codeField", "e702_71");
			fieldMap.put("dateField", "e702_73");
		}
		this.fieldMap = fieldMap;
	}
	
	
	
}
