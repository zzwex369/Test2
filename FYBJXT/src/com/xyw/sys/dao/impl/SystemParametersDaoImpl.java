package com.xyw.sys.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.sys.dao.SystemParametersDao;
import com.xyw.sys.model.S900;
import com.xyw.sys.model.SystemParametersRequest;
import com.xyw.sys.model.SystemParametersResponse;
import com.xyw.sys.util.StringUtil;

public class SystemParametersDaoImpl implements SystemParametersDao {
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean getSystemParameter(String id, boolean defaultValue)
	{
		Session session = sessionFactory.getCurrentSession();
		String sql = "select t.S900_03 from S900 t where t.S900_01 = ?";
		
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setString(0, id);
		
		List<Object> list = sqlQuery.list();
		if(list != null)
		{
			Object obj = list.get(0);
			String temp = obj + "";
			if("1".equals(temp))
			{
				return true;
			}else
			{
				return false;
			}
		}else
		{
			return defaultValue;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public SystemParametersResponse queryS900(SystemParametersRequest systemParametersRequest) {
		SystemParametersResponse systemParametersResponse = new SystemParametersResponse();
		Session session = sessionFactory.getCurrentSession();
		
		String s90002 = systemParametersRequest.getS90002();
		String s90005 = systemParametersRequest.getS90005();
		
		StringBuffer sql = new StringBuffer();
		sql.append("select * from S900 t where 0=0");
		if(!StringUtil.isBlankString(s90002))
		{
			sql.append(" and t.S900_02 like '%");
			sql.append(s90002);
			sql.append("%'");
		}
		if(!StringUtil.isBlankString(s90005))
		{
			sql.append(" and t.S900_05 = '");
			sql.append(s90005);
			sql.append("'");
		}
		
		SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
		List<Object> listObj = sqlQuery.list();
		List<S900> listS900 = new ArrayList<S900>();
		if(listObj != null)
		{
			Iterator<Object> it = listObj.iterator();
			while(it.hasNext())
			{
				S900 s900 = new S900();
				Object[] objs = (Object[])it.next();
				s900.setS90001(objs[0] + "");
				s900.setS90002(objs[1] + "");
				s900.setS90003(objs[2] + "");
				s900.setS90004(objs[3] + "");
				s900.setS90005(objs[4] + "");
				
				listS900.add(s900);
			}
		}
		
		systemParametersResponse.setListS900(listS900);
		
		return systemParametersResponse;
	}
	
	@Override
	public SystemParametersResponse saveS900(S900 s900) {
		SystemParametersResponse systemParametersResponse = new SystemParametersResponse();
		Session session = sessionFactory.getCurrentSession();
		
		String sql = "update S900 t set t.s900_02 = ?, t.s900_03 = ?, t.s900_04 = ? where t.s900_01 = ?";
		
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setString(0, s900.getS90002());
		sqlQuery.setString(1, s900.getS90003());
		sqlQuery.setString(2, s900.getS90004());
		sqlQuery.setString(3, s900.getS90001());
		
		int row = sqlQuery.executeUpdate();
		if(row <= 0)
		{
			systemParametersResponse.setErrorMessage("保存失败!");
		}else
		{
			systemParametersResponse.setPromptMessage("保存成功!");
		}
		
		return systemParametersResponse;
	}

	@Override
	public String queryS900ById(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("select s900_03 from s900 where s900_01 = ?");
		sqlQuery.setString(0, id);
		String flag = (String)sqlQuery.uniqueResult();
		return flag;
	}
}
