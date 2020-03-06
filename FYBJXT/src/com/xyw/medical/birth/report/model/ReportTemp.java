package com.xyw.medical.birth.report.model;


public class ReportTemp {
	private int t01;//上一年底出生证库存数
	private int t02;//当年出生证申领数
	private int t03;//首次签发出生证书
	private int t04;//出生证换发数
	private int t05;//出生证补发数
	private int t06;//小计 = t03 + t04 + t05
	private int t07;//家庭接生员接生的签发数    
	private int t08;//其它情况的签发数  
	private int t09;//小计  = t07 + t08
	private int t10;//运输毁损
	private int t11;//存储毁损
	private int t12;//发放毁损
	private int t13;//空白遗失
	private int t14;//空白被盗
	private int t15;//打印错误
	private int t16;//填写错误
	private int t17;//遗失
	private int t18;//其它原因
	private int t19;//小计 = T10 + T11 + T12 + T13 + T14 + T15 + T16 + T17 + T18
	private int t20;//合计 = T06 + T09 + T19
	private int t21;//当年年底库存数  = T01 + T02 - T20
	private int t22;//当年医疗保健机构内活产数
	public int getT01() {
		return t01;
	}

	public void setT01(int t01) {
		this.t01 = t01;
	}

	public int getT02() {
		return t02;
	}

	public void setT02(int t02) {
		this.t02 = t02;
	}

	public int getT03() {
		return t03;
	}

	public void setT03(int t03) {
		this.t03 = t03;
	}

	public int getT04() {
		return t04;
	}

	public void setT04(int t04) {
		this.t04 = t04;
	}

	public int getT05() {
		return t05;
	}

	public void setT05(int t05) {
		this.t05 = t05;
	}

	public int getT06() {
		return t06;
	}

	public void setT06(int t06) {
		this.t06 = t06;
	}

	public int getT07() {
		return t07;
	}

	public void setT07(int t07) {
		this.t07 = t07;
	}

	public int getT08() {
		return t08;
	}

	public void setT08(int t08) {
		this.t08 = t08;
	}

	public int getT09() {
		return t09;
	}

	public void setT09(int t09) {
		this.t09 = t09;
	}

	public int getT10() {
		return t10;
	}

	public void setT10(int t10) {
		this.t10 = t10;
	}

	public int getT11() {
		return t11;
	}

	public void setT11(int t11) {
		this.t11 = t11;
	}

	public int getT12() {
		return t12;
	}

	public void setT12(int t12) {
		this.t12 = t12;
	}

	public int getT13() {
		return t13;
	}

	public void setT13(int t13) {
		this.t13 = t13;
	}

	public int getT14() {
		return t14;
	}

	public void setT14(int t14) {
		this.t14 = t14;
	}

	public int getT15() {
		return t15;
	}

	public void setT15(int t15) {
		this.t15 = t15;
	}

	public int getT16() {
		return t16;
	}

	public void setT16(int t16) {
		this.t16 = t16;
	}

	public int getT17() {
		return t17;
	}

	public void setT17(int t17) {
		this.t17 = t17;
	}

	public int getT18() {
		return t18;
	}

	public void setT18(int t18) {
		this.t18 = t18;
	}

	public int getT19() {
		return t19;
	}

	public void setT19(int t19) {
		this.t19 = t19;
	}

	public int getT20() {
		return t20;
	}

	public void setT20(int t20) {
		this.t20 = t20;
	}

	public int getT21() {
		return t21;
	}

	public void setT21(int t21) {
		this.t21 = t21;
	}

	public int getT22() {
		return t22;
	}

	public void setT22(int t22) {
		this.t22 = t22;
	}

	public int getT23() {
		return t23;
	}

	public void setT23(int t23) {
		this.t23 = t23;
	}

	public int getT24() {
		return t24;
	}

	public void setT24(int t24) {
		this.t24 = t24;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getInstitutionZh() {
		return institutionZh;
	}

	public void setInstitutionZh(String institutionZh) {
		this.institutionZh = institutionZh;
	}

	private int t23;//上报分娩登记数
	private int t24;//漏报分娩登记数
	private String year;//年份
	private String institution;//机构代码
	private String institutionZh;//机构名称
	
	public ReportTemp() {
		
	}
	
}