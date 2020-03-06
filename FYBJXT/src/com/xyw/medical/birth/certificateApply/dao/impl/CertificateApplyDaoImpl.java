package com.xyw.medical.birth.certificateApply.dao.impl;

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

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.birth.certificateApply.dao.CertificateApplyDao;
import com.xyw.medical.birth.model.D501;
import com.xyw.medical.birth.model.D501Request;
import com.xyw.medical.birth.model.D501Response;
import com.xyw.medical.birth.model.D503;
import com.xyw.medical.birth.model.VD501;
import com.xyw.sys.util.StringUtil;

public class CertificateApplyDaoImpl implements CertificateApplyDao {

	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;
	
	
	@Override
	public D501Response saveD501(D501Request d501Request) {

		D501Response d501Response = new D501Response();
		try {
			
			D501 d501 = d501Request.getD501();
			
			Session session = this.sessionFactory.getCurrentSession();
			
			if(d501.getD50114().length() >= 6) {
				
				String sqlB = "select t.d501_01 from D501 t where ? >= to_number(t.d501_07)  and ? <= to_number(t.d501_08) and t.D501_02 = ? and t.D501_06 = ?";
				
				String sqlA = "select t.d502_01 from D502 t where ? >= to_number(t.d502_09)  and ? <= to_number(t.d502_10) and t.D502_11 = ? and t.D502_02 = ?";
				
				SQLQuery sqlQueryB = session.createSQLQuery(sqlB);
				
				sqlQueryB.setInteger(0, Integer.valueOf(d501.getD50107()));
				sqlQueryB.setInteger(1, Integer.valueOf(d501.getD50108()));
				sqlQueryB.setString(2,  d501.getD50109());
				sqlQueryB.setString(3, d501.getD50106());
				
				Object objB = sqlQueryB.uniqueResult();
				
				if(objB == null) {
					d501Response.setErrorMessage("出生证起始编号或终止编号超出范围!");
					return d501Response;
				}
				
				SQLQuery sqlQueryA = session.createSQLQuery(sqlA);
				sqlQueryA.setInteger(0, Integer.valueOf(d501.getD50107()));
				sqlQueryA.setInteger(1, Integer.valueOf(d501.getD50108()));
				sqlQueryA.setString(2,  d501.getD50106());
				sqlQueryA.setString(3, d501.getD50109());
			
				
				Object objA = sqlQueryA.uniqueResult();
				
				if(objA == null) {
					d501Response.setErrorMessage("入库数据不存在,先入库然后再分配!");
					return d501Response;
				}
				
				d501.setD50115(Long.valueOf(objB + ""));
				d501.setD50116(Long.valueOf(objA + ""));
				
				//分配之前判断是否证号已经使用
				String sqlC = "select t.d505_01 from d505 t where t.d505_04 = ? and to_number(substr(t.d505_03, 2)) between ? and ? and t.d505_05 <> 1 and substr(t.d505_03, 1,1) = ?";
				SQLQuery sqlQueryC = session.createSQLQuery(sqlC);
				sqlQueryC.setString(0,  d501.getD50109());
				sqlQueryC.setInteger(1, Integer.valueOf(d501.getD50107()));
				sqlQueryC.setInteger(2, Integer.valueOf(d501.getD50108()));
				sqlQueryC.setString(3, d501.getD50106());
				
				@SuppressWarnings("rawtypes")
				List result = sqlQueryC.list();
				
				if(result.size() > 0){
					d501Response.setErrorMessage("该号段包含已使用证号！请确认分配证号未使用！");
					return d501Response;
				}
				
				//验证是否重复分配
				String sqlD = "select t.d501_01 from D501 t where ? >= to_number(t.d501_07)  and ? <= to_number(t.d501_08) and t.D501_09 = ? and t.D501_06 = ?";
				
				SQLQuery sqlQueryD = session.createSQLQuery(sqlD);
				
				sqlQueryD.setInteger(0, Integer.valueOf(d501.getD50107()));
				sqlQueryD.setInteger(1, Integer.valueOf(d501.getD50107()));
				sqlQueryD.setString(2,  d501.getD50109());
				sqlQueryD.setString(3, d501.getD50106());
				
				Object objD = sqlQueryD.uniqueResult();
				
				
				
				String sqlE = "select t.d501_01 from D501 t where ? >= to_number(t.d501_07) and ? <= to_number(t.d501_08) and t.D501_09 = ? and t.D501_06 = ?";
				 
				SQLQuery sqlQueryE = session.createSQLQuery(sqlE);
				
				sqlQueryE.setInteger(0, Integer.valueOf(d501.getD50108()));
				sqlQueryE.setInteger(1, Integer.valueOf(d501.getD50108()));
				sqlQueryE.setString(2,  d501.getD50109());
				sqlQueryE.setString(3, d501.getD50106());
				
				Object objE = sqlQueryE.uniqueResult(); 
				
				if(objD != null || objE != null) {
					d501Response.setErrorMessage("该段证号有的已保存，请勿重复分配!");
					return d501Response;
				}
			}
			long id = (Long) session.save(d501);
			if (id > 0) {
				D503 d503 = new D503();
				d503.setD50302(d501.getD50109());
				d503.setD50303(d501.getD50110());
				d503.setD50304(d501.getD50105());
				d503.setD50305(d501.getD50112());
				d503.setD50306(0);
				d503.setD50307(d501.getD50109());
				d503.setD50308(d501.getD50111());
				d503.setD50309(d501.getD50107());
				d503.setD50310(d501.getD50108());
				d503.setD50311(d501.getD50106());
				d503.setD50313(d501.getD50101());
				
				long row = (Long)session.save(d503);
				if(row > 0)
				{
					d501Response.setPromptMessage("申领成功!");
				}else
				{
					d501Response.setErrorMessage("申领失败!");
				}
			} else {
				d501Response.setErrorMessage("申领失败!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return d501Response;
	}

	@Override
	public D501Response queryD501(D501Request d501Request) {
		D501 d501 = d501Request.getD501();
		
		long d501_01_p = d501.getD50101();
		String d501_02_p = d501.getD50102();
		String d501_06 = d501.getD50106();
		
		String d501_09_p = d501.getD50109();
		Date d501_12 = d501.getD50112();
		Date d501_12_end = d501.getD50112_end();
		long d501_15 = d501.getD50115();
		int parameterPageindex = d501Request.getParameterPageindex();
		int parameterPagesize = d501Request.getParameterPagesize();

		StringBuffer parameterConditionwhere = new StringBuffer();

		if(d501_01_p > 0) {
			parameterConditionwhere.append(" and t.d501_01 = ");
			parameterConditionwhere.append(d501_01_p);
		}
		
		if (!StringUtil.isBlankString(d501_02_p)) {
			parameterConditionwhere.append(" and t.d501_02 = '");
			parameterConditionwhere.append(d501_02_p);
			if("single".equals(d501.getD50114()))
			{
				parameterConditionwhere.append("'");
			}else
			{
				parameterConditionwhere.append("' or t.d501_02 in (select t.D101_01 from D101 t where t.D101_11 = '");
				parameterConditionwhere.append(d501_02_p);
				parameterConditionwhere.append("')");
			}
		}
		
		if(!StringUtil.isBlankString(d501_06)) {
			String first = d501_06.substring(0, 1);
			String d50106 = d501_06.substring(1, d501_06.length());
			long d50106_num = Long.valueOf(d50106);
			parameterConditionwhere.append(" and t.d501_06 = '");
			parameterConditionwhere.append(first);
			parameterConditionwhere.append("'");
			
			parameterConditionwhere.append(" and " + d50106_num + " >= to_number(t.d501_07)");
			parameterConditionwhere.append(" and " + d50106_num + " <= to_number(t.d501_08)");
		}
		
		if (!StringUtil.isBlankString(d501_09_p)) {
			parameterConditionwhere.append(" and (t.d501_09 = '");
			parameterConditionwhere.append(d501_09_p);
			parameterConditionwhere.append("' or t.d501_02 = '");
			parameterConditionwhere.append(d501_09_p);
			parameterConditionwhere.append("')");
		}
		
		if(d501_12 != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String d501_12_text = simpleDateFormat.format(d501_12);
			parameterConditionwhere.append(" and t.d501_12 >= to_date('" + d501_12_text + "', 'yyyy-mm-dd')");
		}
		
		if(d501_12_end != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String d501_12_end_text = simpleDateFormat.format(d501_12_end);
			parameterConditionwhere.append(" and t.d501_12 <= to_date('" + d501_12_end_text + "', 'yyyy-mm-dd')");
		}
	
		if(d501_15 > 0d) {
			parameterConditionwhere.append(" and t.d501_15 =");
			parameterConditionwhere.append(d501_15);
		}
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		D501Response d501Response = new D501Response();
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_D501");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D501_01");

			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			d501Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VD501 vd501 = null;
			List<VD501> vd501s = new ArrayList<VD501>();
			while (resultSet.next()) {

				Long d50101 = resultSet.getLong("D501_01");
				String d50102 = resultSet.getString("D501_02");
				String d50102Zh = resultSet.getString("D501_02_Zh");
				String d50103 = resultSet.getString("D501_03");
				String d50104 = resultSet.getString("D501_04");
				long d50105 = resultSet.getLong("D501_05");
				String d50106 = resultSet.getString("D501_06");
				String d50107 = resultSet.getString("D501_07");
				String d50108 = resultSet.getString("D501_08");
				String d50109 = resultSet.getString("D501_09");
				String d50109Zh = resultSet.getString("D501_09_ZH");
				String d50110 = resultSet.getString("D501_10");
				String d50111 = resultSet.getString("D501_11");
				Date d50112 = resultSet.getDate("D501_12");
				String d50113 = resultSet.getString("D501_13");
				String d50114 = resultSet.getString("D501_14");
				String d50114Zh = resultSet.getString("D501_14_ZH");
				long d50115 = resultSet.getLong("D501_15");
				long d50116 = resultSet.getLong("D501_16");
				String d50117 = resultSet.getString("D501_17");
				String d50118 = resultSet.getString("D501_18");
				String d50119 = resultSet.getString("D501_19");
				String d50120 = resultSet.getString("D501_20");

				String d50121 = resultSet.getString("D501_21");
				String d50122 = resultSet.getString("D501_22");
				String d50123 = resultSet.getString("D501_23");
				String d50124 = resultSet.getString("D501_24");
				String d50125 = resultSet.getString("D501_25");
				String d50126 = resultSet.getString("D501_26");
				String d50127 = resultSet.getString("D501_27");
				String d50128 = resultSet.getString("D501_28");
				String d50129 = resultSet.getString("D501_29");
				String d50130 = resultSet.getString("D501_30");

				String d50131 = resultSet.getString("D501_31");
				String d50132 = resultSet.getString("D501_32");
				String d50133 = resultSet.getString("D501_33");
				String d50134 = resultSet.getString("D501_34");
				String d50135 = resultSet.getString("D501_35");
				String d50136 = resultSet.getString("D501_36");
				String d50137 = resultSet.getString("D501_37");
				String d50138 = resultSet.getString("D501_38");
				String d50139 = resultSet.getString("D501_39");
				String d50140 = resultSet.getString("D501_40");

				String d50141 = resultSet.getString("D501_41");
				String d50142 = resultSet.getString("D501_42");
				String d50143 = resultSet.getString("D501_43");
				String d50144 = resultSet.getString("D501_44");
				String d50145 = resultSet.getString("D501_45");
				String d50146 = resultSet.getString("D501_46");
				String d50147 = resultSet.getString("D501_47");
				String d50148 = resultSet.getString("D501_48");
				String d50149 = resultSet.getString("D501_49");
				String d50150 = resultSet.getString("D501_50");

				vd501 = new VD501();

				vd501.setD50101(d50101);
				vd501.setD50102(d50102);
				vd501.setD50102Zh(d50102Zh);
				vd501.setD50103(d50103);
				vd501.setD50104(d50104);
				vd501.setD50105(d50105);
				vd501.setD50106(d50106);
				vd501.setD50107(d50107);
				vd501.setD50108(d50108);
				vd501.setD50109(d50109);
				vd501.setD50109Zh(d50109Zh);
				vd501.setD50110(d50110);
				vd501.setD50111(d50111);
				vd501.setD50112(d50112);
				vd501.setD50113(d50113);
				vd501.setD50114(d50114);
				vd501.setD50114Zh(d50114Zh);
				vd501.setD50115(d50115);
				vd501.setD50116(d50116);
				vd501.setD50117(d50117);
				vd501.setD50118(d50118);
				vd501.setD50119(d50119);
				vd501.setD50120(d50120);
				vd501.setD50121(d50121);
				vd501.setD50122(d50122);
				vd501.setD50123(d50123);
				vd501.setD50124(d50124);
				vd501.setD50125(d50125);
				vd501.setD50126(d50126);
				vd501.setD50127(d50127);
				vd501.setD50128(d50128);
				vd501.setD50129(d50129);
				vd501.setD50130(d50130);
				vd501.setD50131(d50131);
				vd501.setD50132(d50132);
				vd501.setD50133(d50133);
				vd501.setD50134(d50134);
				vd501.setD50135(d50135);
				vd501.setD50136(d50136);
				vd501.setD50137(d50137);
				vd501.setD50138(d50138);
				vd501.setD50139(d50139);
				vd501.setD50140(d50140);
				vd501.setD50141(d50141);
				vd501.setD50142(d50142);
				vd501.setD50143(d50143);
				vd501.setD50144(d50144);
				vd501.setD50145(d50145);
				vd501.setD50146(d50146);
				vd501.setD50147(d50147);
				vd501.setD50148(d50148);
				vd501.setD50149(d50149);
				vd501.setD50150(d50150);

				vd501s.add(vd501);
			}
			d501Response.setvD501(vd501);
			d501Response.setVd501s(vd501s);
		} catch (Exception e) {
			e.printStackTrace();
			d501Response.setErrorMessage("保存失败");
		} finally {
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
				e.printStackTrace();
			}
		}
		return d501Response;
	}
}
