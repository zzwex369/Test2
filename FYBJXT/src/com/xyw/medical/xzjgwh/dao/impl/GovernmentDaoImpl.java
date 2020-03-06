package com.xyw.medical.xzjgwh.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.birth.model.D402Request;
import com.xyw.medical.birth.model.D402Response;
import com.xyw.medical.birth.model.VD402;
import com.xyw.medical.xzjgwh.dao.GovernmentDao;
import com.xyw.medical.xzjgwh.model.D201;
import com.xyw.medical.xzjgwh.model.D201Request;
import com.xyw.medical.xzjgwh.model.D201Response;
import com.xyw.medical.xzjgwh.model.VD201;
import com.xyw.sys.util.StringUtil;

public class GovernmentDaoImpl implements GovernmentDao {

	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private DataSource dataSource;
	
	private StringBuffer sql;
	
	@Override
	public D201Response save(D201Request d201Request) {
		
		D201Response d201Response = new D201Response();
		
		D201 d201 = d201Request.getD201();
		//String d20102 = d201.getD20102();
		String d20104 = d201.getD20104();
		String d20105 = d201.getD20105();
		
		if(StringUtil.isBlankString(d20104)){
			d201Response.setErrorMessage("行政区划简称不能为空！");
			return d201Response;
		}
		if(StringUtil.isBlankString(d20105)){
			d201Response.setErrorMessage("行政区划全称不能为空！");
			return d201Response;
		}
		
		String sqlA = "SELECT COUNT(*) FROM D201 T WHERE T.D201_05 = ?";

		//String sqlB = "SELECT COUNT(*) FROM D201 T WHERE T.D201_02 = ?";
		
		Session session = this.sessionFactory.getCurrentSession();
		
		SQLQuery sqlQuery = session.createSQLQuery(sqlA);
		sqlQuery.setString(0, d20105);
		Object obj = sqlQuery.uniqueResult();
		int result = Integer.valueOf((obj.toString()));
		if(result > 0) {
			d201Response.setErrorMessage("该地区已经存在!");
			return d201Response;
		}
		
		try{
			d201.setD20101("0");
			String resultS = (String)session.save(d201);
			if(resultS != null) {
				d201Response.setPromptMessage("保存成功");
			} else {
				d201Response.setErrorMessage("保存失败");
			}
		}catch(Exception e){
			d201Response.setErrorMessage("保存失败");
		}
		return d201Response;
	}

	@Override
	public D201Response find(D201Request d201Request) {
		D201 d201 = d201Request.getD201();
		String d20102_text = d201.getD20102();

		int parameterPageindex = d201Request.getPageIndex();
		int parameterPagesize = d201Request.getPageSize();

		if(parameterPageindex == 0) {
			parameterPageindex = 1;
		}
		
		StringBuffer parameterConditionwhere = new StringBuffer();
		if(d20102_text.length() == 9) {
			parameterConditionwhere.append(" and t.d201_01 = '" + d20102_text + "'");
		} else if(d20102_text.length() == 6) {
			parameterConditionwhere.append(" and t.d201_01 like '" + d20102_text + "___'");
		} else {
			parameterConditionwhere.append(" and t.d201_01 like '" + d20102_text + "__'");
		}
		
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		D201Response d201Response = new D201Response();
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_D201");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D201_01");

			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			d201Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VD201 vd201 = null;
			List<VD201> vd201s = new ArrayList<VD201>();
			while (resultSet.next()) {

				String d20101 = resultSet.getString("D201_01");
				String d20102 = resultSet.getString("D201_02");
				String d20103 = resultSet.getString("D201_03");
				String d20103Zh = resultSet.getString("D201_03_Zh");
				String d20104 = resultSet.getString("D201_04");
				String d20105 = resultSet.getString("D201_05");
				
				
				String d20106 = resultSet.getString("D201_06");
				String d20107 = resultSet.getString("D201_07");
				String d20108 = resultSet.getString("D201_08");
				String d20109 = resultSet.getString("D201_09");
				String d20110 = resultSet.getString("D201_10");

				String d20111 = resultSet.getString("D201_11");
				String d20112 = resultSet.getString("D201_12");
				String d20113 = resultSet.getString("D201_13");
				String d20114 = resultSet.getString("D201_14");
				String d20115 = resultSet.getString("D201_15");
				String d20116 = resultSet.getString("D201_16");
				String d20117 = resultSet.getString("D201_17");
				String d20118 = resultSet.getString("D201_18");
				String d20119 = resultSet.getString("D201_19");
				String d20120 = resultSet.getString("D201_20");

				String d20121 = resultSet.getString("D201_21");
				String d20122 = resultSet.getString("D201_22");
				String d20123 = resultSet.getString("D201_23");
				String d20124 = resultSet.getString("D201_24");
				String d20125 = resultSet.getString("D201_25");
				String d20126 = resultSet.getString("D201_26");
				String d20127 = resultSet.getString("D201_27");
				String d20128 = resultSet.getString("D201_28");
				String d20129 = resultSet.getString("D201_29");
				String d20130 = resultSet.getString("D201_30");

				vd201 = new VD201();

				vd201.setD20101(d20101);
				vd201.setD20102(d20102);
				vd201.setD20103(d20103);
				vd201.setD20103Zh(d20103Zh);
				vd201.setD20104(d20104);
				vd201.setD20105(d20105);
				vd201.setD20106(d20106);
				vd201.setD20107(d20107);
				vd201.setD20108(d20108);
				vd201.setD20109(d20109);
				vd201.setD20110(d20110);
				vd201.setD20111(d20111);
				vd201.setD20112(d20112);
				vd201.setD20113(d20113);
				vd201.setD20114(d20114);
				vd201.setD20115(d20115);
				vd201.setD20116(d20116);
				vd201.setD20117(d20117);
				vd201.setD20118(d20118);
				vd201.setD20119(d20119);
				vd201.setD20120(d20120);
				vd201.setD20121(d20121);
				vd201.setD20122(d20122);
				vd201.setD20123(d20123);
				vd201.setD20124(d20124);
				vd201.setD20125(d20125);
				vd201.setD20126(d20126);
				vd201.setD20127(d20127);
				vd201.setD20128(d20128);
				vd201.setD20129(d20129);
				vd201.setD20130(d20130);

				vd201s.add(vd201);
			}
			d201Response.setVd201s(vd201s);
		} catch (Exception e) {
			d201Response.setErrorMessage("查询失败!");
			e.printStackTrace();
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
		return d201Response;
	}

	@Override
	public D201Response findById(D201Request d201Request) {
		D201Response d201Response = new D201Response();
		
		String id = d201Request.getD201().getD20101();
		this.sql = new StringBuffer("from D201 t where 0=0");
		if(!StringUtil.isBlankString(id)){
			this.sql.append("and t.d20101 = '");
			this.sql.append(id);
			this.sql.append("'");
		}
		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(this.sql.toString());
			//SQLQuery s = session.createSQLQuery(this.sql.toString());
			D201 d201 = (D201)query.uniqueResult();
			//String d20104 = d201.getD20104();
			//String d20105 = d201.getD20105();
			
			d201Response.setD201(d201);
		}catch(Exception e){
			d201Response.setErrorMessage("查询失败");
		}
		return d201Response;
	}

	@Override
	public D201Response update(D201Request d201Request) {
		D201Response d201Response = new D201Response();
		
		D201 d201 = d201Request.getD201();
		
		String d20101 = d201.getD20101();
		//String d20102 = d201.getD20102();
		//String d20103 = d201.getD20103();
		String d20104 = d201.getD20104();
		String d20105 = d201.getD20105();
		
		String sql = "SELECT COUNT(*) FROM D201 T WHERE T.D201_05 = ?";
		Session session = this.sessionFactory.getCurrentSession();
		
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setString(0, d20105);
		Object obj = sqlQuery.uniqueResult();
		int result = Integer.valueOf((obj.toString()));
		if(result > 0) {
			d201Response.setErrorMessage("该地区已经存在!");
			return d201Response;
		}
		
		if(StringUtil.isBlankString(d20104)){
			d201Response.setErrorMessage("行政区划简称不能为空！");
			return d201Response;
		}
		if(StringUtil.isBlankString(d20105)){
			d201Response.setErrorMessage("行政区划全称不能为空！");
			return d201Response;
		}
		String strSql = "update D201 t set t.d201_04 = ?, t.d201_05 = ? where t.d201_01 = ?";
		
		SQLQuery sQLQuery = session.createSQLQuery(strSql);
		
		sQLQuery.setString(0, d20104);
		sQLQuery.setString(1, d20105);
		sQLQuery.setString(2, d20101);
		
		int results = sQLQuery.executeUpdate();
		if(results > 0){
			//if(d20101.length() != 12) {
			//	String strSQLSub = "update D201 t set t.D201_05 = ? || t.D201_04 where t.D201_02 = ?";
			//	SQLQuery sqlQueryA = session.createSQLQuery(strSQLSub);
			//	sqlQueryA.setString(0, d20105);
			//	sqlQueryA.setString(1, d20101);
			//	int resultA = sqlQueryA.executeUpdate();
			//	if(resultA > 0) {
			//		d201Response.setPromptMessage("修改成功");
			//	} else {
			//		d201Response.setErrorMessage("修改失败");
			//	}
			//} else {
				d201Response.setPromptMessage("修改成功");
			//}
		}else{
			d201Response.setErrorMessage("修改失败");
		}
		return d201Response;
	}

	@Override
	public D201Response del(D201Request d201Request) {
		D201Response d201Response = new D201Response();
		String id = d201Request.getD201().getD20101();
		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			D201 d201 = (D201)session.get(D201.class, id);
			session.delete(d201);
			d201Response.setPromptMessage("删除成功！");
		} catch (Exception e){
			d201Response.setErrorMessage("删除失败！");
		}
		return d201Response;
	}

	@Override
	public D402Response save2(D402Request d402Request) {
		
		D402Response d402Response = new D402Response();

		Session session = null;
		
		try{
			session = this.sessionFactory.getCurrentSession();
			session.save(d402Request.getD402());
			d402Response.setPromptMessage("保存成功");
		}catch(Exception e){
			d402Response.setErrorMessage("保存失败");
		}
		return d402Response;
	}

	@Override
	public D402Response find2(D402Request d402Request) {
		D402Response d402Response = new D402Response();
		VD402 vd402 = null;
		
		String _d402_02 = d402Request.getD402().getD402_02();
		String _d402_03 = d402Request.getD402().getD402_03();
		String _d402_10 = d402Request.getD402().getD402_10();
		String _d402_11 = d402Request.getD402().getD402_11();
		String _d402_19 = d402Request.getD402().getD402_19();
		//String _d402_20 = d402Request.getD402().getD402_20();
		Date _d402_12 = d402Request.getD402().getD402_12();
		Date _d402_12_end = d402Request.getD402().getD402_12_end();
		int parameterPageindex = d402Request.getParameterPageindex();
		int parameterPagesize = d402Request.getParameterPagesize();
		StringBuffer parameterConditionwhere = new StringBuffer();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		if(!StringUtil.isBlankString(_d402_02)){
			parameterConditionwhere.append(" and t.d402_02="+"'"+_d402_02+"'");
		}
		if(!StringUtil.isBlankString(_d402_03)){
			parameterConditionwhere.append(" and t.d402_03="+"'"+_d402_03+"'");
		}
		if(!StringUtil.isBlankString(_d402_10)){
			parameterConditionwhere.append(" and t.d402_10='"+_d402_10+"'");
		}
		if(!StringUtil.isBlankString(_d402_11)){
			parameterConditionwhere.append(" and t.d402_11 like '"+_d402_11+"%'");
		}
		if(_d402_12 != null){
			String _d402_12_ = simpleDateFormat.format(_d402_12);
			parameterConditionwhere.append(" and t.d402_12 >= "+"to_date('"+_d402_12_+"','yyyy-mm-dd')");
		}
		if(_d402_12_end != null){
			String _d402_12_end_ = simpleDateFormat.format(_d402_12_end);
			parameterConditionwhere.append(" and t.d402_12 <= "+"to_date('"+_d402_12_end_+"','yyyy-mm-dd')");
		}
		if(!StringUtil.isBlankString(_d402_19)){
			parameterConditionwhere.append(" and t.d402_19='"+_d402_19+"'");
		}
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			
			connection = dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			
			callableStatement.setString(3, "V_D402");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D402_01");
			
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER); 
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			
			d402Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			List<VD402> list = new ArrayList<VD402>();
			while (resultSet.next()) {
				vd402 = new VD402();
				long d40201 = resultSet.getLong("D402_01");
				String d40202 = resultSet.getString("D402_02");
				String d40203 = resultSet.getString("D402_03");
				String d40204 = resultSet.getString("D402_04");
				String d40205 = resultSet.getString("D402_05");
				String d40206 = resultSet.getString("D402_06");
				String d40207 = resultSet.getString("D402_07");
				String d40208 = resultSet.getString("D402_08");
				String d40209 = resultSet.getString("D402_09");
				String d40210 = resultSet.getString("D402_10");
				String d40210_Zh = resultSet.getString("D402_10_Zh");
				String d40211 = resultSet.getString("D402_11");
				String d40211_Zh = resultSet.getString("D402_11_Zh");
				Date d40212 = resultSet.getDate("D402_12");
				Date d40213 = resultSet.getDate("D402_13");
				String d40214 = resultSet.getString("D402_14");
				String d40215 = resultSet.getString("D402_15");
				String d40216 = resultSet.getString("D402_16");
				String d40217 = resultSet.getString("D402_17");
				Date d40218 = resultSet.getDate("D402_18");
				String d40219 = resultSet.getString("D402_19");
				String d40219_Zh = resultSet.getString("D402_19_Zh");
				String d40220 = resultSet.getString("D402_20");
				String d40220_Zh = resultSet.getString("D402_20_Zh");
				vd402.setD40201(d40201);
				vd402.setD40202(d40202);
				vd402.setD40203(d40203);
				vd402.setD40204(d40204);
				vd402.setD40205(d40205);
				vd402.setD40206(d40206);
				vd402.setD40207(d40207);
				vd402.setD40208(d40208);
				vd402.setD40209(d40209);
				vd402.setD40210(d40210);
				vd402.setD40210Zh(d40210_Zh);
				vd402.setD40211(d40211);
				vd402.setD40212(d40212);
				vd402.setD40211Zh(d40211_Zh);
				vd402.setD40213(d40213);
				vd402.setD40214(d40214);
				vd402.setD40215(d40215);
				vd402.setD40216(d40216);
				vd402.setD40217(d40217);
				vd402.setD40218(d40218);
				vd402.setD40219(d40219);
				vd402.setD40219Zh(d40219_Zh);
				vd402.setD40220(d40220);
				vd402.setD40220Zh(d40220_Zh);
				list.add(vd402);
					
			}
			
			d402Response.setVd402s(list);
		} catch (Exception e) {
			e.printStackTrace();
			d402Response.setErrorMessage("查询错误！");
		}finally{
			if (connection != null) {
				try {
					connection.close();
					connection = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (callableStatement != null) {
				try {
					callableStatement.close();
					callableStatement = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		} 
		return d402Response;
	}

	@Override
	public D402Response update2(D402Request d402Request) {
		D402Response d402Response = new D402Response();
		
		Session session = sessionFactory.getCurrentSession();
		String sql = "update D402 t set t.D402_10='1',t.D402_13=? where t.D402_03=? and t.D402_01=?";
		SQLQuery sqlquery = session.createSQLQuery(sql);
		sqlquery.setDate(0, d402Request.getD402().getD402_13());
		sqlquery.setString(1 ,d402Request.getD402().getD402_03());
		sqlquery.setLong(2, d402Request.getD402().getD402_01());
		int i =sqlquery.executeUpdate();
		if(i<=0){
			d402Response.setErrorMessage("审核出错！");
		}else{
			d402Response.setPromptMessage("审核成功！");
		}
		
		return d402Response;
	}
	@Override
	public D402Response chuliuupdate2(D402Request d402Request) {
		D402Response d402Response = new D402Response();
		
		Session session = sessionFactory.getCurrentSession();
		String sql = "update D402 t set t.D402_19='1',t.D402_16=?,t.D402_17=?,t.D402_18=? where t.D402_01=?";
		SQLQuery sqlquery = session.createSQLQuery(sql);
		sqlquery.setString(0, d402Request.getD402().getD402_16());
		sqlquery.setString(1 ,d402Request.getD402().getD402_17());
		sqlquery.setDate(2, d402Request.getD402().getD402_18());
		sqlquery.setLong(3, d402Request.getD402().getD402_01());
		int i =sqlquery.executeUpdate();
		if(i<=0){
			d402Response.setErrorMessage("处理出错！");
		}else{
			d402Response.setPromptMessage("处理成功！");
		}
		
		return d402Response;
	}

}
