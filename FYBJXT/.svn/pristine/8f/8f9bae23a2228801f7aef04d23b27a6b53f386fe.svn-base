package com.xyw.medical.rws.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.rws.dao.RwsDao;
import com.xyw.medical.rws.model.Rws;
import com.xyw.medical.rws.model.RwsRequest;
import com.xyw.medical.rws.model.RwsResponse;
import com.xyw.sys.util.StringUtil;

@Transactional
public class RwsDaoImpl implements RwsDao{
	 
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public RwsResponse addRws(Rws rws) {
		RwsResponse resp = new RwsResponse();
		Session session = sessionFactory.getCurrentSession();
		Integer rws02 = rws.getRws02();
		String rws03 = rws.getRws03();
		String rws05 = rws.getRws05();
		String rws06 = rws.getRws06();
		List<?> list = session.createSQLQuery("select rws_01 from rws where rws_02 = '"+rws02.toString()+"' and rws_05 = '"+rws05+"' and rws_03 = '"+rws03+"' and rws_06 = '"+rws06+"'").list();
		if(list.size()>0){
			resp.setState(false);
			resp.setErrorMessage("该年份的任务数已经保存过,不能重复保存");
			return resp;
		}
		session.save(rws);
		session.flush();
		resp.setState(true);
		return resp;
	}

	@Override
	public RwsResponse deleteRws(RwsRequest rwsRequest) {
		RwsResponse resp = new RwsResponse();
		Session session = sessionFactory.getCurrentSession();
		String rws01 = rwsRequest.getRws01();
		session.createSQLQuery("delete rws where rws_01 = ?").setString(0, rws01).executeUpdate();
		session.flush();
		resp.setState(true);
		return resp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public RwsResponse queryRws(RwsRequest rwsRequest) {
		RwsResponse resp = new RwsResponse();
		Session session = sessionFactory.getCurrentSession();
		String rws03 = rwsRequest.getRws03();
		String rws06 = rwsRequest.getRws06();
		String rws08 = rwsRequest.getRws08();
		int parameterPageindex = rwsRequest.getParameterPageindex();
		int parameterPagesize = rwsRequest.getParameterPagesize();
		int rws02Str = rwsRequest.getRws02Str();
		int rws02End = rwsRequest.getRws02End();
		StringBuilder str = new StringBuilder();
		if(!StringUtil.isBlankString(rws08)) {
			str.append("rws_08");
			if (rws08.length() == 14) {
				str.append(" = '"+rws08+"' and ");
			} else {
				str.append(" like '"+rws08+"%' and ");
			}
		}
		str.append("rws_02>= "+rws02Str+" and rws_02<="+rws02End+" and ");
		str.append("rws_06 = '"+rws06+"' and rws_03 = '"+rws03+"'");
		Object rowCount = session.createSQLQuery("select count(*) from rws where "+str+"").uniqueResult();
		if(Long.valueOf(rowCount.toString())<=0){
			resp.setState(true);
			resp.setRowCount(0L);
			resp.setRwss(null);
			return resp;
		}
		List<Rws> rwss=(List<Rws>) session.createSQLQuery("select * from rws where "
				+str
				.toString()+"")
				.addEntity(Rws.class)
				.setFirstResult((parameterPageindex - 1) * parameterPagesize)
				.setMaxResults(parameterPagesize).list();
		resp.setState(true);
		resp.setRowCount(Long.valueOf(rowCount.toString()));
		resp.setRwss(rwss);
		return resp;
	}

	@Override
	public RwsResponse updateRws(Rws rws) {
		RwsResponse resp = new RwsResponse();
		Session session = sessionFactory.getCurrentSession();
		int size = session.createSQLQuery("select rws_01 from rws where rws_02 = '"+rws
				.getRws02()+"' and rws_05 = '"+rws.getRws05()+"' and rws_03 = '"+rws.getRws03()+"' and rws_06 = '"+rws.getRws06()+"' and rws_01 != '"+rws.getRws01()+"'").list().size();
		if(size>0){
			resp.setState(true);
			resp.setErrorMessage("已存在同一年份的任务数,请核对信息!");
			return resp;
		}
		session.update(rws);
		session.flush();
		return resp;
	}

}
