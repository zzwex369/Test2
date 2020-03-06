package com.xyw.medical.birth.certificateCondition.dao.impl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import com.xyw.medical.birth.certificateCondition.dao.CertificateConditionDao;
import com.xyw.medical.birth.model.CertificateConditionRequest;
import com.xyw.medical.birth.model.CertificateConditionResponse;
import com.xyw.medical.birth.model.ConditionTemp;
import com.xyw.medical.birth.model.VD301;
import com.xyw.medical.birth.report.model.ReportGenderTemp;
import com.xyw.sys.util.StringUtil;

public class CertificateConditionDaoImpl implements CertificateConditionDao {
	
	@Resource
	private DataSource dataSource;

	@Override
	public CertificateConditionResponse queryB(CertificateConditionRequest certificateConditionRequest) {
		
		String institution = certificateConditionRequest.getInstitution();
		Date date_start = certificateConditionRequest.getDate_start();
		Date date_end = certificateConditionRequest.getDate_end();
		String areacode = certificateConditionRequest.getAreacode();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		StringBuffer parameterConditionwhere = new StringBuffer();
		
		if(!StringUtil.isBlankString(institution))
		{
			parameterConditionwhere.append(" and t.d301_26 like '");
			parameterConditionwhere.append(institution);
			parameterConditionwhere.append("%'");
		}
		if(date_start != null)
		{
			String d30128Start = simpleDateFormat.format(date_start);
			parameterConditionwhere.append(" and to_date(t.d301_28,'yyyy-mm-dd') >= to_date('" + d30128Start + "', 'yyyy-mm-dd')");
		}
		if(date_end != null)
		{
			String d30128End = simpleDateFormat.format(date_end);
			parameterConditionwhere.append(" and to_date(t.d301_28,'yyyy-mm-dd') <= to_date('" + d30128End + "', 'yyyy-mm-dd')");
		}
		if(areacode != null)
		{
			parameterConditionwhere.append(" and t.d301_05 like '" + areacode +"%' ");
		}
		return this.queryD301(parameterConditionwhere.toString(), certificateConditionRequest);
	}
	
	@Override
	public CertificateConditionResponse queryE(CertificateConditionRequest certificateConditionRequest) {
		
		Date date_start = certificateConditionRequest.getDate_start();
		Date date_end = certificateConditionRequest.getDate_end();
		String areacode = certificateConditionRequest.getAreacode();
		String areacodeZh = certificateConditionRequest.getAreacodeZh();
		String institution = certificateConditionRequest.getInstitution();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		StringBuffer parameterConditionwhere = new StringBuffer();
		
		if(!StringUtil.isBlankString(institution))
		{
			parameterConditionwhere.append(" and t.d301_26 like '");
			parameterConditionwhere.append(institution);
			parameterConditionwhere.append("%'");
		}
		if(date_start != null)
		{
			String d30128Start = simpleDateFormat.format(date_start);
			parameterConditionwhere.append(" and to_date(t.d301_28,'yyyy-mm-dd') >= to_date('" + d30128Start + "', 'yyyy-mm-dd')");
		}
		if(date_end != null)
		{
			String d30128End = simpleDateFormat.format(date_end);
			parameterConditionwhere.append(" and to_date(t.d301_28,'yyyy-mm-dd') <= to_date('" + d30128End + "', 'yyyy-mm-dd')");
		}
		if(areacode != null)
		{
			parameterConditionwhere.append(" and t.d301_05 like '" + areacode +"%' ");
		}
		if(areacodeZh != null)
		{
			parameterConditionwhere.append(" and t.d301_48 like '%" + areacodeZh.substring(0, 2) +"%' ");
		}
		
		return this.queryD301(parameterConditionwhere.toString(), certificateConditionRequest);
	}
	
	@Override
	public CertificateConditionResponse queryF(CertificateConditionRequest certificateConditionRequest) {
		
		Date date_start = certificateConditionRequest.getDate_start();
		Date date_end = certificateConditionRequest.getDate_end();
		String areacode = certificateConditionRequest.getAreacode();
		String areacodeZh = certificateConditionRequest.getAreacodeZh();
		String institution = certificateConditionRequest.getInstitution();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		
		if(!StringUtil.isBlankString(institution))
		{
			parameterConditionwhere.append(" and t.d301_26 like '");
			parameterConditionwhere.append(institution);
			parameterConditionwhere.append("%'");
		}
		if(date_start != null)
		{
			String d30128Start = simpleDateFormat.format(date_start);
			parameterConditionwhere.append(" and to_date(t.d301_28,'yyyy-mm-dd') >= to_date('" + d30128Start + "', 'yyyy-mm-dd')");
		}
		if(date_end != null)
		{
			String d30128End = simpleDateFormat.format(date_end);
			parameterConditionwhere.append(" and to_date(t.d301_28,'yyyy-mm-dd') <= to_date('" + d30128End + "', 'yyyy-mm-dd')");
		}
		if(areacode != null)
		{
			parameterConditionwhere.append(" and t.d301_05 like '" + areacode +"%' ");
		}
		if(areacodeZh != null)
		{
			parameterConditionwhere.append(" and (t.d301_48 not like '%" + areacodeZh.substring(0, 2) +"%' or t.d301_48 is null) ");
		}
		return this.queryD301(parameterConditionwhere.toString(), certificateConditionRequest);
	}

	
	public CertificateConditionResponse queryD301(String sql,CertificateConditionRequest certificateConditionRequest){
		
		int parameterPageindex = certificateConditionRequest.getParameterPageindex();
		int parameterPagesize = certificateConditionRequest.getParameterPagesize();
		String flag = certificateConditionRequest.getFlag();
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		CertificateConditionResponse certificateConditionResponse = new CertificateConditionResponse();
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			
			callableStatement.setString(3, "V_D301");
			callableStatement.setString(4, sql);
			callableStatement.setString(5, "t.D301_01");
			
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			
			certificateConditionResponse.setRowCount(rowCount);
			certificateConditionResponse.setFlag(flag);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VD301 vD301 =null;
			List<VD301> vd301s = new ArrayList<VD301>();
			
			while (resultSet.next()) {
				long d30101 = resultSet.getLong("D301_01");
				String d30102 = resultSet.getString("D301_02");
				String d30103 = resultSet.getString("D301_03");
				String d30104 = resultSet.getString("D301_04");
				String d30105 = resultSet.getString("D301_05");
				String d30106 = resultSet.getString("D301_06");
				int d30107 = resultSet.getInt("D301_07");
				double d30108 = resultSet.getDouble("D301_08");
				String d30109 = resultSet.getString("D301_09");
				String d30110 = resultSet.getString("D301_10");
				String d30111 = resultSet.getString("D301_11");
				String d30112 = resultSet.getString("D301_12");
				String d30113 = resultSet.getString("D301_13");
				String d30114 = resultSet.getString("D301_14");
				String d30115 = resultSet.getString("D301_15");
				String d30116 = resultSet.getString("D301_16");
				String d30117 = resultSet.getString("D301_17");
				String d30118 = resultSet.getString("D301_18");
				String d30119 = resultSet.getString("D301_19");
				String d30120 = resultSet.getString("D301_20");
				String d30121 = resultSet.getString("D301_21");
				String d30122 = resultSet.getString("D301_22");
				String d30123 = resultSet.getString("D301_23");
				String d30124 = resultSet.getString("D301_24");
				String d30125 = resultSet.getString("D301_25");
				String d30126 = resultSet.getString("D301_26");
				String d30127 = resultSet.getString("D301_27");
				String d30128 = resultSet.getString("d301_28");
				double d30129 = resultSet.getDouble("D301_29");
				String d30130 = resultSet.getString("D301_30");
				String d30131 = resultSet.getString("D301_31");
				String d30152 = resultSet.getString("D301_52");
				String d30148 = resultSet.getString("D301_48");
				String d30103Zh = resultSet.getString("D301_03_ZH");
				String d30105Zh = resultSet.getString("D301_05_ZH");
				String d30109Zh = resultSet.getString("D301_09_ZH");
				String d30114Zh = resultSet.getString("D301_14_ZH");
				String d30115Zh = resultSet.getString("D301_15_ZH");
				String d30119Zh = resultSet.getString("D301_19_ZH");
				String d30120Zh = resultSet.getString("D301_20_ZH");
				String d30122Zh = resultSet.getString("D301_22_ZH");
				String d30124Zh = resultSet.getString("D301_24_ZH");
				String d30126Zh = resultSet.getString("D301_26_ZH");
				String d30130Zh = resultSet.getString("D301_30_ZH");
				String d30131Zh = resultSet.getString("D301_31_Zh");
				String d30150Zh = resultSet.getString("D301_50_Zh");
				
				String d30132 = resultSet.getString("D301_32");
				String d30133 = resultSet.getString("D301_33");
				String d30134 = resultSet.getString("D301_34");
				String d30134Zh = resultSet.getString("D301_34_Zh");
				String d30135 = resultSet.getString("D301_35");
				String d30135Zh = resultSet.getString("D301_35_Zh");
				String d30136 = resultSet.getString("D301_36");
				String d30137 = resultSet.getString("D301_37");
				String d30137Zh = resultSet.getString("D301_37_Zh");
				String d30138 = resultSet.getString("D301_38");
				String d30138Zh = resultSet.getString("D301_38_Zh");
				String d30139 = resultSet.getString("D301_39");
				String d30140 = resultSet.getString("D301_40");
				String d30143 = resultSet.getString("D301_43");
				
				vD301 = new VD301();
				
				vD301.setD30101(d30101);
				vD301.setD30102(d30102);
				vD301.setD30103(d30103);
				vD301.setD30104(d30104);
				vD301.setD30105(d30105);
				vD301.setD30106(d30106);
				vD301.setD30107(d30107);
				vD301.setD30108(d30108);
				vD301.setD30109(d30109);
				vD301.setD30110(d30110);
				vD301.setD30111(d30111);
				vD301.setD30112(d30112);
				vD301.setD30113(d30113);
				vD301.setD30114(d30114);
				vD301.setD30115(d30115);
				vD301.setD30116(d30116);
				vD301.setD30117(d30117);
				vD301.setD30118(d30118);
				vD301.setD30119(d30119);
				vD301.setD30120(d30120);
				vD301.setD30121(d30121);
				vD301.setD30122(d30122);
				vD301.setD30123(d30123);
				vD301.setD30124(d30124);
				vD301.setD30125(d30125);
				vD301.setD30126(d30126);
				vD301.setD30127(d30127);
				vD301.setD30128(d30128);
				vD301.setD30129(d30129);
				vD301.setD30130(d30130);
				vD301.setD30131(d30131);
				vD301.setD30148(d30148);
				vD301.setD30152(d30152);
				vD301.setD30103Zh(d30103Zh);
				vD301.setD30105Zh(d30105Zh);
				vD301.setD30109Zh(d30109Zh);
				vD301.setD30114Zh(d30114Zh);
				vD301.setD30115Zh(d30115Zh);
				vD301.setD30119Zh(d30119Zh);
				vD301.setD30120Zh(d30120Zh);
				vD301.setD30122Zh(d30122Zh);
				vD301.setD30124Zh(d30124Zh);
				vD301.setD30126Zh(d30126Zh);
				vD301.setD30130Zh(d30130Zh);
				vD301.setD30131Zh(d30131Zh);
				vD301.setD30150Zh(d30150Zh);
				vD301.setD30132(d30132);
				vD301.setD30133(d30133);
				vD301.setD30134(d30134);
				vD301.setD30134Zh(d30134Zh);
				vD301.setD30135(d30135);
				vD301.setD30135Zh(d30135Zh);
				vD301.setD30136(d30136);
				vD301.setD30137(d30137);
				vD301.setD30137Zh(d30137Zh);
				vD301.setD30138(d30138);
				vD301.setD30138Zh(d30138Zh);
				vD301.setD30139(d30139);
				vD301.setD30140(d30140);
				vD301.setD30143(d30143);
				
				
				
				vd301s.add(vD301);
			}
			certificateConditionResponse.setVd301s(vd301s);
		} catch (Exception e) {
			e.printStackTrace();
			certificateConditionResponse.setErrorMessage("查询失败!");
		}finally{
			try {
				if (callableStatement != null) {
					callableStatement.close();
					callableStatement = null;
				}
				if (connection != null) {
					connection.close();
					connection = null;
				}
			} catch (Exception e) {

			}
		}
		return certificateConditionResponse;
	}
	
	@Override
	public CertificateConditionResponse query(CertificateConditionRequest certificateConditionRequest) {
		CertificateConditionResponse certificateConditionResponse = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		List<ReportGenderTemp> listReportGenderTemp = null;
		
		Date date_start = certificateConditionRequest.getDate_start();
		Date date_end = certificateConditionRequest.getDate_end();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date_start_str = sdf.format(date_start);
		String date_end_str = sdf.format(date_end);
		
		String institutionType = certificateConditionRequest.getInstitutionType();
		String institution = certificateConditionRequest.getInstitution();
		
		int parameterPageindex = certificateConditionRequest.getParameterPageindex();
		int parameterPagesize = certificateConditionRequest.getParameterPagesize();
		
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call reportBirth_package.birth_procedure(?, ?, ?, ?, ?)}");
			callableStatement.setString(1, date_start_str);
			callableStatement.setString(2, date_end_str);
			callableStatement.setString(3, institutionType);
			callableStatement.setString(4, institution);
			callableStatement.registerOutParameter(5, OracleTypes.CURSOR);
			callableStatement.execute();
			
			certificateConditionResponse = new CertificateConditionResponse();
			listReportGenderTemp = new ArrayList<ReportGenderTemp>();
			
			certificateConditionResponse.setListReportGenderTemp(listReportGenderTemp);
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "REPORT_GENDERTEMP");
			callableStatement.setString(4, "");
			callableStatement.setString(5, "t.se");

			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			certificateConditionResponse.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet)callableStatement.getObject(7);
			
			listReportGenderTemp = new ArrayList<ReportGenderTemp>();
			while (resultSet.next()) {
				ReportGenderTemp rgt = new ReportGenderTemp();
				rgt.setInstitution(resultSet.getString("institution"));
				rgt.setInstitutionZH(resultSet.getString("institutionZh"));
				rgt.setBoy(resultSet.getInt("boy"));
				rgt.setGirl(resultSet.getInt("girl"));
				rgt.setTotal(resultSet.getInt("total"));
				rgt.setNativePlace(resultSet.getInt("local"));
				rgt.setOtherPlaces(resultSet.getInt("nonlocal"));
				rgt.setSearch(resultSet.getString("search"));
				listReportGenderTemp.add(rgt);
			}
			certificateConditionResponse.setListReportGenderTemp(listReportGenderTemp);
		}catch (Exception e) {
			e.printStackTrace();
		}finally 
		{
			try {
				if(callableStatement != null) {
					callableStatement.close();
					callableStatement = null;
				}
				if(connection != null) {
					connection.close();
					connection = null;
				}
			} catch(Exception e) {
				
			}
		}
		return certificateConditionResponse;
	}

	@Override
	public CertificateConditionResponse queryC(CertificateConditionRequest certificateConditionRequest) {
		
		CertificateConditionResponse certificateConditionResponse = null;
		
		Date date_start = certificateConditionRequest.getDate_start();
		Date date_end = certificateConditionRequest.getDate_end();
		String flag = certificateConditionRequest.getFlag();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date_start_str = sdf.format(date_start);
		String date_end_str = sdf.format(date_end);
		
		String areacode = certificateConditionRequest.getAreacode();
		String areaType = certificateConditionRequest.getAreacodeType();
		
		int parameterPageindex = certificateConditionRequest.getParameterPageindex();
		int parameterPagesize = certificateConditionRequest.getParameterPagesize();
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		List<ConditionTemp> conditionTemps = null;
		
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call reportBirth_package_three.birth_procedure_three(?, ?, ?, ?, ?)}");
			callableStatement.setString(1, date_start_str);
			callableStatement.setString(2, date_end_str);
			callableStatement.setString(3, areacode);
			callableStatement.setString(4, areaType);
			callableStatement.registerOutParameter(5, OracleTypes.CURSOR);
			callableStatement.execute();
			
			
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "CONDITION_TEMP");
			callableStatement.setString(4, "");
			callableStatement.setString(5, "t.se");

			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			
			
			ResultSet resultSet = (ResultSet)callableStatement.getObject(7);
			
			certificateConditionResponse = new CertificateConditionResponse();
			long rowCount = callableStatement.getLong(6);
			certificateConditionResponse.setRowCount(rowCount);
			certificateConditionResponse.setFlag(flag);
			
			conditionTemps = new ArrayList<ConditionTemp>();
			
			ConditionTemp conditionTemp = null;
			while(resultSet.next()) {
				conditionTemp = new ConditionTemp();
				
				conditionTemp.setAreacode(resultSet.getString("AREACODE"));
				conditionTemp.setAredcode_Zh(resultSet.getString("AREACODE_ZH"));
				conditionTemp.setBoy(resultSet.getLong("BOY"));
				conditionTemp.setGirl(resultSet.getLong("GIRL"));
				conditionTemp.setPrecentBoy(resultSet.getString("PERCENT_BOY"));
				conditionTemp.setPrecentGirl(resultSet.getString("PERCENT_GIRL"));
				conditionTemp.setTotal(resultSet.getLong("TOTAL"));
				conditionTemp.setSe(resultSet.getLong("SE"));
				conditionTemp.setLocalNum(resultSet.getLong("LOCAL_NUM"));
				conditionTemp.setNonlocalNum(resultSet.getLong("NONLOCAL_NUM"));
				
				conditionTemps.add(conditionTemp);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally 
		{
			try {
				if(callableStatement != null) {
					callableStatement.close();
					callableStatement = null;
				}
				if(connection != null) {
					connection.close();
					connection = null;
				}
			} catch(Exception e) {
				
			}
		}
		certificateConditionResponse.setConditionTemps(conditionTemps);
		
		return certificateConditionResponse;
	}

}
