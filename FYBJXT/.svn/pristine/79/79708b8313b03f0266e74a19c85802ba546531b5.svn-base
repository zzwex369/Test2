package com.xyw.medical.fnbj.fngjatpzk.dao.impl;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.fnbj.fngjatpzk.dao.L303Dao;
import com.xyw.medical.fnbj.model.L303;
import com.xyw.medical.fnbj.model.L303Request;
import com.xyw.medical.fnbj.model.L303Response;

public class L303DaoImpl implements L303Dao {
	@Resource
	SessionFactory sessionFactory;
	@Resource
	private DataSource dataSource;
	@Override
	public L303Response saveL303(L303 l303) {
		boolean state=false;
		L303Response l303Response =new L303Response();
		try {
			if(l303!=null)
			{
				Session session=sessionFactory.getCurrentSession();
				session.save(l303);
				state=true;
				l303Response.setPromptMessage("保存成功");
			}
		} catch (Exception e) {
			l303Response.setErrorMessage(e.getMessage());
		}
		l303Response.setState(state);
		return l303Response;
	}

}
