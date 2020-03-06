package com.xyw.medical.birth.model;

import java.io.Serializable;

public class VD601_DBF  implements Serializable {
	private static final long serialVersionUID = 1L;
	private String USERNAME;//助产机构名字
//	private String USERIDKEY;//无
//	private String TBJGDM;//无
	private String JG_ZC;//是否助产机构
	private String CF_XM;//产妇姓名
	
//	private String CF_BH;  //孕产妇健康档案编号
//	private String CF_JDSJ;  //建档时间YYYYMMDD
	
	private String CF_BAH;//病历号
	private String CF_ZJLX;//证件类型
	private String CF_ZJHM;///证件号码（身份证号）
	private String CF_CSRQ;//出生日期yyyyMMdd
	private String CF_GJ;//国籍代码
	private String CF_MZ;//民族
	private String CF_HJ_S;//产妇户口省 区 市所在地
	private String CF_HJ_SD;//市 地 州 所在地
	private String CF_HJ_XQ;//县
	private String CF_HJ_QHDM;//行政区划代码
	private String CF_JZD_S;//居住地省 区 市所在地
	private String CF_JZD_SD;//市 地 州 所在地
	private String 	CF_JZD_XQ;//县
	private String 	CF_JZ_QHDM;//行政区划代码
	private String 	CF_YC;//孕次
	private String 	CF_CC;//产次
	private String 	CF_YFZC;//孕周
	private String CF_GWYS;//是否高危妊娠       妊娠风险级别
	private String CF_FMDD;//分娩地点
	private String 	CF_FMFS;//分娩方式
	private String 	CF_FMRQ;//分娩日期
	
	private String FMTS; //妊娠结局本次为      产妇本次分娩的分娩胎数
	private String 	FM_XB1;//性别代码1
	private String 	FM_RSJJ1;//妊娠结局1
	private String 	FM_PF1;//1分钟apgar
	private String 	FM_XB2;//d601_94
	private String 	FM_RSJJ2;//d601_95
	private String 	FM_PF2;//d601_96
	private String 	FM_XB3;//d601_86_ZH
	private String 	FM_RSJJ3;//d601_40_ZH
	private String 	FM_PF3;//d601_48_ZH
	private String 	FM_XB4;//d601_26_ZH
	private String 	FM_RSJJ4;//d601_92_ZH1
	private String 	FM_PF4;//d601_92_ZH2
	
	private String 	JG_DWFZR;///单位负责人
	private String 	JG_TBR;//填表人
	private String 	JG_LXDH;//联系电话
	private String 	JG_BCRQ;//报出日期
	
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getJG_ZC() {
		return JG_ZC;
	}
	public void setJG_ZC(String jG_ZC) {
		JG_ZC = jG_ZC;
	}
	public String getCF_XM() {
		return CF_XM;
	}
	public void setCF_XM(String cF_XM) {
		CF_XM = cF_XM;
	}
	public String getCF_BAH() {
		return CF_BAH;
	}
	public void setCF_BAH(String cF_BAH) {
		CF_BAH = cF_BAH;
	}
	public String getCF_ZJLX() {
		return CF_ZJLX;
	}
	public void setCF_ZJLX(String cF_ZJLX) {
		CF_ZJLX = cF_ZJLX;
	}
	public String getCF_ZJHM() {
		return CF_ZJHM;
	}
	public void setCF_ZJHM(String cF_ZJHM) {
		CF_ZJHM = cF_ZJHM;
	}
	public String getCF_CSRQ() {
		return CF_CSRQ;
	}
	public void setCF_CSRQ(String cF_CSRQ) {
		CF_CSRQ = cF_CSRQ;
	}
	public String getCF_GJ() {
		return CF_GJ;
	}
	public void setCF_GJ(String cF_GJ) {
		CF_GJ = cF_GJ;
	}
	public String getCF_MZ() {
		return CF_MZ;
	}
	public void setCF_MZ(String cF_MZ) {
		CF_MZ = cF_MZ;
	}
	public String getCF_HJ_S() {
		return CF_HJ_S;
	}
	public void setCF_HJ_S(String cF_HJ_S) {
		CF_HJ_S = cF_HJ_S;
	}
	public String getCF_HJ_SD() {
		return CF_HJ_SD;
	}
	public void setCF_HJ_SD(String cF_HJ_SD) {
		CF_HJ_SD = cF_HJ_SD;
	}
	public String getCF_HJ_XQ() {
		return CF_HJ_XQ;
	}
	public void setCF_HJ_XQ(String cF_HJ_XQ) {
		CF_HJ_XQ = cF_HJ_XQ;
	}
	public String getCF_HJ_QHDM() {
		return CF_HJ_QHDM;
	}
	public void setCF_HJ_QHDM(String cF_HJ_QHDM) {
		CF_HJ_QHDM = cF_HJ_QHDM;
	}
	public String getCF_JZD_S() {
		return CF_JZD_S;
	}
	public void setCF_JZD_S(String cF_JZD_S) {
		CF_JZD_S = cF_JZD_S;
	}
	public String getCF_JZD_SD() {
		return CF_JZD_SD;
	}
	public void setCF_JZD_SD(String cF_JZD_SD) {
		CF_JZD_SD = cF_JZD_SD;
	}
	public String getCF_JZD_XQ() {
		return CF_JZD_XQ;
	}
	public void setCF_JZD_XQ(String cF_JZD_XQ) {
		CF_JZD_XQ = cF_JZD_XQ;
	}
	public String getCF_JZ_QHDM() {
		return CF_JZ_QHDM;
	}
	public void setCF_JZ_QHDM(String cF_JZ_QHDM) {
		CF_JZ_QHDM = cF_JZ_QHDM;
	}
	public String getCF_YC() {
		return CF_YC;
	}
	public void setCF_YC(String cF_YC) {
		CF_YC = cF_YC;
	}
	public String getCF_CC() {
		return CF_CC;
	}
	public void setCF_CC(String cF_CC) {
		CF_CC = cF_CC;
	}
	public String getCF_YFZC() {
		return CF_YFZC;
	}
	public void setCF_YFZC(String cF_YFZC) {
		CF_YFZC = cF_YFZC;
	}
	public String getCF_GWYS() {
		return CF_GWYS;
	}
	public void setCF_GWYS(String cF_GWYS) {
		CF_GWYS = cF_GWYS;
	}
	public String getCF_FMDD() {
		return CF_FMDD;
	}
	public void setCF_FMDD(String cF_FMDD) {
		CF_FMDD = cF_FMDD;
	}
	public String getCF_FMFS() {
		return CF_FMFS;
	}
	public void setCF_FMFS(String cF_FMFS) {
		CF_FMFS = cF_FMFS;
	}
	public String getCF_FMRQ() {
		return CF_FMRQ;
	}
	public void setCF_FMRQ(String cF_FMRQ) {
		CF_FMRQ = cF_FMRQ;
	}
	public String getFMTS() {
		return FMTS;
	}
	public void setFMTS(String fMTS) {
		FMTS = fMTS;
	}
	public String getFM_XB1() {
		return FM_XB1;
	}
	public void setFM_XB1(String fM_XB1) {
		FM_XB1 = fM_XB1;
	}
	public String getFM_RSJJ1() {
		return FM_RSJJ1;
	}
	public void setFM_RSJJ1(String fM_RSJJ1) {
		FM_RSJJ1 = fM_RSJJ1;
	}
	public String getFM_PF1() {
		return FM_PF1;
	}
	public void setFM_PF1(String fM_PF1) {
		FM_PF1 = fM_PF1;
	}
	public String getFM_XB2() {
		return FM_XB2;
	}
	public void setFM_XB2(String fM_XB2) {
		FM_XB2 = fM_XB2;
	}
	public String getFM_RSJJ2() {
		return FM_RSJJ2;
	}
	public void setFM_RSJJ2(String fM_RSJJ2) {
		FM_RSJJ2 = fM_RSJJ2;
	}
	public String getFM_PF2() {
		return FM_PF2;
	}
	public void setFM_PF2(String fM_PF2) {
		FM_PF2 = fM_PF2;
	}
	public String getFM_XB3() {
		return FM_XB3;
	}
	public void setFM_XB3(String fM_XB3) {
		FM_XB3 = fM_XB3;
	}
	public String getFM_RSJJ3() {
		return FM_RSJJ3;
	}
	public void setFM_RSJJ3(String fM_RSJJ3) {
		FM_RSJJ3 = fM_RSJJ3;
	}
	public String getFM_PF3() {
		return FM_PF3;
	}
	public void setFM_PF3(String fM_PF3) {
		FM_PF3 = fM_PF3;
	}
	public String getFM_XB4() {
		return FM_XB4;
	}
	public void setFM_XB4(String fM_XB4) {
		FM_XB4 = fM_XB4;
	}
	public String getFM_RSJJ4() {
		return FM_RSJJ4;
	}
	public void setFM_RSJJ4(String fM_RSJJ4) {
		FM_RSJJ4 = fM_RSJJ4;
	}
	public String getFM_PF4() {
		return FM_PF4;
	}
	public void setFM_PF4(String fM_PF4) {
		FM_PF4 = fM_PF4;
	}
	public String getJG_DWFZR() {
		return JG_DWFZR;
	}
	public void setJG_DWFZR(String jG_DWFZR) {
		JG_DWFZR = jG_DWFZR;
	}
	public String getJG_TBR() {
		return JG_TBR;
	}
	public void setJG_TBR(String jG_TBR) {
		JG_TBR = jG_TBR;
	}
	public String getJG_LXDH() {
		return JG_LXDH;
	}
	public void setJG_LXDH(String jG_LXDH) {
		JG_LXDH = jG_LXDH;
	}
	public String getJG_BCRQ() {
		return JG_BCRQ;
	}
	public void setJG_BCRQ(String jG_BCRQ) {
		JG_BCRQ = jG_BCRQ;
	}
	
}
