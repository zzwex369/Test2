package com.xyw.medical.birth.certificateAbandon.dao.impl;

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

import com.xyw.medical.birth.certificateAbandon.dao.AbandonCertificateDao;
import com.xyw.medical.birth.model.D401;
import com.xyw.medical.birth.model.D401Request;
import com.xyw.medical.birth.model.D401Response;
import com.xyw.medical.birth.model.VD401;
import com.xyw.sys.util.StringUtil;

public class AbandonCertificateDaoImpl implements AbandonCertificateDao {

	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private DataSource dataSource;
	
	@Override
	@SuppressWarnings("unchecked")
	public D401Response saveD401(D401Request d401Request) {
		D401Response d401Response = new D401Response();
		D401 d401 = d401Request.getD401();
		String d401_05 = d401.getD40105();
		String code = d401Request.getCode();//原签发单位
		
		String first = d401_05.substring(0, 1);
		long d40105 = Long.valueOf(d401_05.substring(1,d401_05.length()));
		
		String d401_10 = d401.getD40110();
		
		d401.setD40108(new Date());
		
		Session session = this.sessionFactory.getCurrentSession();
		
		StringBuffer sql = new StringBuffer("select t.d501_01 from d501 t where t.d501_02 = ? and t.d501_06 = ? and ? >= to_number(t.d501_07) and ? <= to_number(t.d501_08)");
		SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
		
		if(code != null){
			sqlQuery.setString(0, code);
		}else{
			sqlQuery.setString(0, d401_10);
		}
		sqlQuery.setString(1, first);
		sqlQuery.setLong(2, d40105);
		sqlQuery.setLong(3, d40105);
		
		List<Long> list = sqlQuery.list();
		if(list.size() != 1)
		{
			d401Response.setErrorMessage("作废失败!");
			return d401Response;
		}
		
		StringBuffer sqlA = new StringBuffer("select t.d401_01 from D401 t where t.d401_05 = ? ");
		SQLQuery sqlQueryA = session.createSQLQuery(sqlA.toString());
		
		sqlQueryA.setString(0, d401_05);
		
		List<Long> listA = sqlQueryA.list();
		if(listA.size() > 0)
		{
			d401Response.setErrorMessage("此证已经作废,不能重复作废!");
			return d401Response;
		}
		String sq = null;
		SQLQuery query = null;
		if ("1".equals(d401.getD40125())) {
			sq = "update D505 t set t.D505_05 = '5',t.D505_09 = ? where t.D505_03 = ?";
			query = session.createSQLQuery(sq);
			query.setString(0, new SimpleDateFormat("yyyyMMdd").format(new Date()));
			query.setString(1, d401_05);
		}else {
			sq = "update D505 t set t.D505_05 = '5' where t.D505_03 = ?";
			query = session.createSQLQuery(sq);
			query.setString(0, d401_05);
		}
		
		int row = query.executeUpdate();
		if(row <= 0)
		{
			d401Response.setErrorMessage("作废失败!");
			return d401Response;
		}
		
		long d40114 = Long.valueOf(list.get(0) + "");
		d401.setD40114(d40114);
		d401.setD40124("0");
		
		long result = (Long)session.save(d401);
		if(result > 0) {
			d401Response.setPromptMessage("作废成功!");
		} else {
			d401Response.setErrorMessage("作废失败!");
		}
		return d401Response;
	}

	@Override
	public D401Response queryD401(D401Request d401Request) {
		D401 d401 = d401Request.getD401();
		String d401_02_p = d401.getD40102();
		String d401_05_p = d401.getD40105();
		Date d401_08_p = d401.getD40108();
		Date d401_08_end_p = d401.getD40108_end();
		String d401_10_p = d401.getD40110();
		long d401_14_p = d401.getD40114();
		String d401_24 = d401.getD40124();
		String d401_13_p = d401.getD40113();
		int parameterPageindex = d401Request.getParameterPageindex();
		int parameterPagesize = d401Request.getParameterPagesize();

		StringBuffer parameterConditionwhere = new StringBuffer();

		if (!StringUtil.isBlankString(d401_02_p)) {
			parameterConditionwhere.append(" and t.d401_02 = '");
			parameterConditionwhere.append(d401_02_p);
			parameterConditionwhere.append("'");
		}
		
		if (!StringUtil.isBlankString(d401_10_p)) {
			parameterConditionwhere.append(" and t.d401_10 like '");
			parameterConditionwhere.append(d401_10_p);
			parameterConditionwhere.append("%'");
		}

		if (!StringUtil.isBlankString(d401_05_p)) {
			parameterConditionwhere.append(" and t.d401_05 = '");
			parameterConditionwhere.append(d401_05_p);
			parameterConditionwhere.append("'");
		}
		
		if (!StringUtil.isBlankString(d401_13_p)) {
			parameterConditionwhere.append(" and t.d401_13 like '");
			parameterConditionwhere.append(d401_13_p);
			parameterConditionwhere.append("%'");
		}
		
		if (d401_08_p != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String d401_08_text = simpleDateFormat.format(d401_08_p);
			parameterConditionwhere.append(" and t.d401_08 >= to_date('" + d401_08_text + "', 'yyyy-mm-dd')");
		}

		if (d401_08_end_p != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String d401_08_end_text = simpleDateFormat.format(d401_08_end_p);
			parameterConditionwhere.append(" and t.d401_08 <= to_date('" + d401_08_end_text + "', 'yyyy-mm-dd')");
		}
		
		if(d401_14_p > 0) {
			parameterConditionwhere.append("and t.d401_14 = ");
			parameterConditionwhere.append(d401_14_p);
		}
		if(!StringUtil.isBlankString(d401_24))
		{
			parameterConditionwhere.append("and t.d401_24 = '");
			parameterConditionwhere.append(d401_24);
			parameterConditionwhere.append("'");
		}
		Connection connection = null;
		CallableStatement callableStatement = null;
		D401Response d401Response = new D401Response();
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_D401");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D401_01");

			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			d401Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VD401 vd401 = null;
			List<VD401> vd401s = new ArrayList<VD401>();
			while (resultSet.next()) {

				Long d40101 = resultSet.getLong("D401_01");
				String d40102 = resultSet.getString("D401_02");
				String d40103 = resultSet.getString("D401_03");
				String d40103Zh = resultSet.getString("D401_03_Zh");
				Date d40104 = resultSet.getDate("D401_04");
				String d40105 = resultSet.getString("D401_05");
				String d40106 = resultSet.getString("D401_06");
				String d40106Zh = resultSet.getString("D401_06_Zh");
				String d40107 = resultSet.getString("D401_07");
				Date d40108 = resultSet.getDate("D401_08");
				String d40109 = resultSet.getString("D401_09");
				String d40110 = resultSet.getString("D401_10");
				String d40110Zh = resultSet.getString("D401_10_Zh");

				String d40111 = resultSet.getString("D401_11");
				String d40112 = resultSet.getString("D401_12");
				String d40112Zh = resultSet.getString("D401_12_Zh");
				String d40113 = resultSet.getString("D401_13");
				long d40114 = resultSet.getLong("D401_14");
				String d40115 = resultSet.getString("D401_15");
				Date d40116 = resultSet.getDate("D401_16");
				String d40117 = resultSet.getString("D401_17");
				String d40118 = resultSet.getString("D401_18");
				String d40119 = resultSet.getString("D401_19");
				String d40120 = resultSet.getString("D401_20");
				String d40121 = resultSet.getString("D401_21");
				String d40122 = resultSet.getString("D401_22");
				Date d40123 = resultSet.getDate("D401_23");
				String d40124 = resultSet.getString("D401_24");
				String d40124Zh = resultSet.getString("D401_24_Zh");
				String d40125 = resultSet.getString("D401_25");
				String d40126 = resultSet.getString("D401_26");
				String d40127 = resultSet.getString("D401_27");
				String d40128 = resultSet.getString("D401_28");
				String d40129 = resultSet.getString("D401_29");
				String d40130 = resultSet.getString("D401_30");

				String d40131 = resultSet.getString("D401_31");
				String d40132 = resultSet.getString("D401_32");
				String d40133 = resultSet.getString("D401_33");
				String d40134 = resultSet.getString("D401_34");
				String d40135 = resultSet.getString("D401_35");
				String d40136 = resultSet.getString("D401_36");
				String d40137 = resultSet.getString("D401_37");
				String d40138 = resultSet.getString("D401_38");
				String d40139 = resultSet.getString("D401_39");
				String d40140 = resultSet.getString("D401_40");
				
				vd401 = new VD401();

				vd401.setD40101(d40101);
				vd401.setD40102(d40102);
				vd401.setD40103(d40103);
				vd401.setD40103Zh(d40103Zh);
				vd401.setD40104(d40104);
				vd401.setD40105(d40105);
				vd401.setD40106(d40106);
				vd401.setD40106Zh(d40106Zh);
				vd401.setD40107(d40107);
				vd401.setD40108(d40108);
				vd401.setD40109(d40109);
				vd401.setD40110(d40110);
				vd401.setD40110Zh(d40110Zh);
				vd401.setD40111(d40111);
				vd401.setD40112(d40112);
				vd401.setD40112Zh(d40112Zh);
				vd401.setD40113(d40113);
				vd401.setD40114(d40114);
				vd401.setD40115(d40115);
				vd401.setD40116(d40116);
				vd401.setD40117(d40117);
				vd401.setD40118(d40118);
				vd401.setD40119(d40119);
				vd401.setD40120(d40120);
				vd401.setD40121(d40121);
				vd401.setD40122(d40122);
				vd401.setD40123(d40123);
				vd401.setD40124(d40124);
				vd401.setD40124Zh(d40124Zh);
				vd401.setD40125(d40125);
				vd401.setD40126(d40126);
				vd401.setD40127(d40127);
				vd401.setD40128(d40128);
				vd401.setD40129(d40129);
				vd401.setD40130(d40130);
				vd401.setD40131(d40131);
				vd401.setD40132(d40132);
				vd401.setD40133(d40133);
				vd401.setD40134(d40134);
				vd401.setD40135(d40135);
				vd401.setD40136(d40136);
				vd401.setD40137(d40137);
				vd401.setD40138(d40138);
				vd401.setD40139(d40139);
				vd401.setD40140(d40140);

				vd401s.add(vd401);
			}
			d401Response.setVd401s(vd401s);
		} catch (Exception e) {
			d401Response.setErrorMessage("查询失败");
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

			}
		}
		return d401Response;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public D401Response validateStockCertiticate(D401 d401) {
		String d40105 = d401.getD40105();
		String d40112 = d401.getD40112();
		boolean state = true;
		
		StringBuffer errorMessage = new StringBuffer();
		D401Response d401Response = new D401Response();
		
		String sql = "select * from D505 t where t.D505_03 = ? and t.D505_04 = ?";
		
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setString(0, d40105);
		sqlQuery.setString(1, d40112);
		
		List<Object> list = sqlQuery.list();
		
		if(list.size() > 0)
		{
			Object[] objD505 = (Object[])list.get(0);
			String d50505 = objD505[4] + "";
			String d50508 = objD505[7] + "";
			if(!"1".equals(d50505))
			{
				errorMessage.append("该证号已被使用!");
				state = false;
			}else if("1".equals(d50508))
			{
				errorMessage.append("该证号已经分配,没有作废权限!");
				state = false;
			}
		}else
		{
			errorMessage.append("该出生证号没有入库!");
			state = false;
		}
		
		String sqlD401 = "select count(*) from d401 t where t.d401_05 = ?";
		
		if(state)
		{
			SQLQuery query = session.createSQLQuery(sqlD401);
			query.setString(0, d40105);
			
			List<Object> listCount = query.list();
			
			if(listCount.size() > 0)
			{
				errorMessage.append("该证号已经作废!");
			}
		}
		
		
		return d401Response;
	}
	
	@Override
	public D401Response updateD401(VD401 vd401) {
		Session session = sessionFactory.getCurrentSession();
		D401Response d401Response = new D401Response();
		try {
			D401 d401 = (D401)session.get(D401.class, vd401.getD40101());
			
			d401.setD40115(vd401.getD40115());
			d401.setD40116(vd401.getD40116());
			d401.setD40117(vd401.getD40117());
			d401.setD40118(vd401.getD40118());
			d401.setD40119(vd401.getD40119());
			d401.setD40120(vd401.getD40120());
			d401.setD40121(vd401.getD40121());
			d401.setD40122(vd401.getD40122());
			d401.setD40123(vd401.getD40123());
			d401.setD40124("1");
			d401.setD40131(vd401.getD40131());
			
			session.update(d401);
			d401Response.setD401(d401);
			d401Response.setPromptMessage("处理成功!");
		} catch (Exception e) {
			d401Response.setErrorMessage("处理失败!");
		}
		
		return d401Response;
	}

	@Override
	@SuppressWarnings("unchecked")
	public D401Response validateD301Data(String idNumber) {
		Session session = sessionFactory.getCurrentSession();
		D401Response d401Response = new D401Response();
		
		StringBuffer sql = new StringBuffer("select t.d301_01 from D301 t where t.d301_10 = ? ");
		SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
		
		sqlQuery.setString(0, idNumber);
		
		List<Long> list = sqlQuery.list();
		if(list.size() > 0)
		{
			d401Response.setErrorMessage("此证已经使用,不能空白作废!");
			return d401Response;
		}
		return d401Response;
	}
}
