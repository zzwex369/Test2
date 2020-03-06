package com.xyw.medical.birth.certificateRemain.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.birth.certificateRemain.dao.CertificateRemainDao;
import com.xyw.medical.birth.model.D504;
import com.xyw.medical.birth.model.D504Request;
import com.xyw.medical.birth.model.D504Response;
import com.xyw.sys.util.StringUtil;

public class CertificateRemainDaoImpl implements CertificateRemainDao{

	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private DataSource dataSource;
	
	@Override
	public D504Response queryD504(D504Request d504Request) {
		
		D504 d504_p = d504Request.getD504();
		
		String d504_02_p = d504_p.getD504_02();
		String d504_03_p = d504_p.getD504_03();
		int parameterPageindex = d504Request.getParameterPageindex();
		int parameterPagesize = d504Request.getParameterPagesize();
		
		StringBuffer parameterConditionwhere = new StringBuffer();
		
		if (!StringUtil.isBlankString(d504_02_p)) {
			parameterConditionwhere.append("and t.d504_02 = '");
			parameterConditionwhere.append(d504_02_p);
			parameterConditionwhere.append("'");
		}
		
		if (!StringUtil.isBlankString(d504_03_p)) {
			parameterConditionwhere.append("and t.d504_03 = '");
			parameterConditionwhere.append(d504_03_p);
			parameterConditionwhere.append("'");
		}
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		D504Response d504Response = new D504Response();
		List<D504> d504s = null;
		
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_D504");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D504_01");

			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			d504Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			D504 d504 = null;
			d504s = new ArrayList<D504>();
			while (resultSet.next()) {
				d504 = new D504();
				long d504_01 = resultSet.getLong("D504_01");
				String d504_02 = resultSet.getString("D504_02");
				String d504_02Zh = resultSet.getString("D504_02_ZH");
				String d504_03 = resultSet.getString("D504_03");
				long d504_04 = resultSet.getLong("D504_04");
				
				d504.setD504_01(d504_01);
				d504.setD504_02(d504_02);
				d504.setD504_02Zh(d504_02Zh);
				d504.setD504_03(d504_03);
				d504.setD504_04(d504_04);
				
				d504s.add(d504);
			}
			
		} catch(Exception e) {
			d504Response.setErrorMessage("查询失败!");
			e.printStackTrace();
			return d504Response;
		}
		d504Response.setPromptMessage("查询成功!");
		d504Response.setD504s(d504s);
		return d504Response;
	}

	@Override
	public D504Response saveD504(D504Request d504Request) {
	
		D504 d504 = d504Request.getD504();
		
		Session session = this.sessionFactory.getCurrentSession();
		
		D504Response d504Response = new D504Response();
		
		String sql = "insert into D504 t values(D504_01_SEQ.nextval, ?, ?, ?)";
		
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setString(0, d504.getD504_02());
		sqlQuery.setString(1, d504.getD504_03());
		sqlQuery.setLong(2, d504.getD504_04());
		
		int re = sqlQuery.executeUpdate();
		if(re > 0) {
			d504Response.setPromptMessage("保存成功!");
		} else {
			d504Response.setErrorMessage("保存失败!");
		}
				
		return d504Response;
	}
	
	@Override
	public D504Response updateD504(D504Request d504Request) {
		
		D504 d504 = d504Request.getD504();
		D504Response d504Response = new D504Response();
		
		Session session = sessionFactory.getCurrentSession();
		
		String sql = "update D504 t set t.d504_03 = ? , t.d504_04 = ? where t.d504_01 = ?";
		
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setString(0, d504.getD504_03());
		sqlQuery.setLong(1, d504.getD504_04());
		sqlQuery.setLong(2, d504.getD504_01());
		
		int result = sqlQuery.executeUpdate();
		
		if(result > 0)
		{
			d504Response.setPromptMessage("修改成功!");
		}else 
		{
			d504Response.setErrorMessage("修改失败!");
		}
		return d504Response;
	}
	@Override
	public D504Response validateRemain(D504Request d504Request) {
		D504 d504 = d504Request.getD504();
		
		D504Response d504Response = new D504Response();
		
		Session session = sessionFactory.getCurrentSession();
		
		String sql = "select count(t.d504_01) from D504 t where t.d504_02 = ? and t.d504_03 = ?";
		
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setString(0, d504.getD504_02());
		sqlQuery.setString(1, d504.getD504_03());
		
		Object cou = sqlQuery.uniqueResult();
		int count = 0;
		if(cou != null)
		{
			count = Integer.valueOf(cou + "");
			if(count > 0)
			{
				d504Response.setErrorMessage(d504.getD504_03() + "年库存记录已经存在!");
			}
		}
		return d504Response;
	}
	
}
