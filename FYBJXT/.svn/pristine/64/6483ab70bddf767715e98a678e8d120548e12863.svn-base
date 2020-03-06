package com.xyw.medical.fnbj.fnlasz.dao.impl;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.fnbj.fnlasz.dao.L305Dao;
import com.xyw.medical.fnbj.model.F601Response;
import com.xyw.medical.fnbj.model.L305;
import com.xyw.medical.fnbj.model.L305Request;
import com.xyw.medical.fnbj.model.L305Response;

public class L305DaoImpl implements L305Dao {
	@Resource
	SessionFactory sessionFactory;
	@Resource
	private DataSource dataSource;
	@Override
	public L305Response saveL305(L305 f305) {
		boolean state=false;
		L305Response l305Response =new L305Response();
		try {
			if(f305!=null)
			{
				Session session=sessionFactory.getCurrentSession();
				String id=(String) session.createSQLQuery("select t.l305_01 from l305 t where t.l305_02=? and t.l305_04=?")
									.setInteger(0, f305.getL30502()).setString(1, f305.getL30504()).uniqueResult();
				if(id==null)
				{
					session.save(f305);
					state=true;
					l305Response.setPromptMessage("保存成功");
					
				}else 
					l305Response.setErrorMessage("此机构设置日期重复");
				
			}
		} catch (Exception e) {
			l305Response.setErrorMessage(e.getMessage());
		}
		l305Response.setState(state);
		return l305Response;
	}

}
