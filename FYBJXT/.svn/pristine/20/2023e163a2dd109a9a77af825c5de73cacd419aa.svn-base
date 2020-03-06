package com.xyw.medical.fnbj.fngjasf.dao.impl;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.fnbj.fngjasf.dao.L304Dao;
import com.xyw.medical.fnbj.model.L304;
import com.xyw.medical.fnbj.model.L304Request;
import com.xyw.medical.fnbj.model.L304Response;

public class L304DaoImpl implements L304Dao {
	@Resource
	SessionFactory sessionFactory;
	@Resource
	private DataSource dataSource;
	@Override
	public L304Response saveL304(L304 l304) {
		boolean state=false;
		L304Response l304Response =new L304Response();
		try {
			if(l304!=null)
			{
				Session session=sessionFactory.getCurrentSession();
				session.save(l304);
				state=true;
				l304Response.setPromptMessage("保存成功");
			}
		} catch (Exception e) {
			l304Response.setErrorMessage(e.getMessage());
		}
		l304Response.setState(state);
		return l304Response;
	}
	
	
	
}
