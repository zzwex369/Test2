package com.xyw.medical.birth.report.model;

public class BirthCertificateCount {
	private String institutionCode;
	private String institutionName;
	
	private long kc01;//上一年年底库存数（1）
	private long sl02;//当年申领数（2）
	
	private long qf03;//首次签发数（3）
	private long qf04;//补发数（5）
	private long qf05;//换发数（4）
	private long qfCount06;//机构内签发小计（6）=（3）+（4）+（5）
	
	private long qf07;//家庭接生员接生的签发数（7）
	private long qf08;//其它情况的签发数（8）
	private long qfCount09;//机构外签发小计（9）=（7）+（8）
	
	private long fz10;//因打印或填写错误数（10）
	private long fz11;//遗失数（11）
	private long fz12;//其它原因数（12）
	private long fzCount13;//废证数小计（13）=（10）+（11）+（12）
	
	private long syCount14;//使用合计（14）=（6）+（9）+（13）
	
	private long kc15;//当年年底库存数（15）=（1）+（2）-（14）
	private long hc16;//当年医疗保健机构内活产数（16）
	
	public String getInstitutionCode() {
		return institutionCode;
	}
	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public long getKc01() {
		return kc01;
	}
	public void setKc01(long kc01) {
		this.kc01 = kc01;
	}
	public long getSl02() {
		return sl02;
	}
	public void setSl02(long sl02) {
		this.sl02 = sl02;
	}
	public long getQf03() {
		return qf03;
	}
	public void setQf03(long qf03) {
		this.qf03 = qf03;
	}
	public long getQf04() {
		return qf04;
	}
	public void setQf04(long qf04) {
		this.qf04 = qf04;
	}
	public long getQf05() {
		return qf05;
	}
	public void setQf05(long qf05) {
		this.qf05 = qf05;
	}
	public long getQfCount06() {
		return qfCount06;
	}
	public void setQfCount06(long qfCount06) {
		this.qfCount06 = qfCount06;
	}
	public long getQf07() {
		return qf07;
	}
	public void setQf07(long qf07) {
		this.qf07 = qf07;
	}
	public long getQf08() {
		return qf08;
	}
	public void setQf08(long qf08) {
		this.qf08 = qf08;
	}
	public long getQfCount09() {
		return qfCount09;
	}
	public void setQfCount09(long qfCount09) {
		this.qfCount09 = qfCount09;
	}
	public long getFz10() {
		return fz10;
	}
	public void setFz10(long fz10) {
		this.fz10 = fz10;
	}
	public long getFz11() {
		return fz11;
	}
	public void setFz11(long fz11) {
		this.fz11 = fz11;
	}
	public long getFz12() {
		return fz12;
	}
	public void setFz12(long fz12) {
		this.fz12 = fz12;
	}
	public long getFzCount13() {
		return fzCount13;
	}
	public void setFzCount13(long fzCount13) {
		this.fzCount13 = fzCount13;
	}
	public long getSyCount14() {
		return syCount14;
	}
	public void setSyCount14(long syCount14) {
		this.syCount14 = syCount14;
	}
	public long getKc15() {
		return kc15;
	}
	public void setKc15(long kc15) {
		this.kc15 = kc15;
	}
	public long getHc16() {
		return hc16;
	}
	public void setHc16(long hc16) {
		this.hc16 = hc16;
	}
}
