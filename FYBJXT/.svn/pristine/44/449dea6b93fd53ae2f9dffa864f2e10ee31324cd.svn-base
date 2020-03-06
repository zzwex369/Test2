package com.xyw.medical.fnbj.fnrxsf.dao.impl;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.fnbj.fnrxsf.dao.L403Dao;
import com.xyw.medical.fnbj.model.L403;
import com.xyw.medical.fnbj.model.L403Request;
import com.xyw.medical.fnbj.model.L403Response;

public class L403DaoImpl implements L403Dao {
	@Resource
	SessionFactory sessionFactory;
	@Resource
	private DataSource dataSource;
	@Override
	public L403Response saveL403(L403 l403) {
		boolean state=false;
		L403Response l403Response =new L403Response();
		try {
			if(l403!=null)
			{
				Session session=sessionFactory.getCurrentSession();
				session.save(l403);
				state=true;
				l403Response.setPromptMessage("保存成功");
			}
		} catch (Exception e) {
			l403Response.setErrorMessage(e.getMessage());
		}
		l403Response.setState(state);
		return l403Response;
	}

}
