package com.xyw.medical.common.et.yey.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.common.et.yey.dao.E705Dao;
import com.xyw.medical.common.et.yey.model.E705;
import com.xyw.medical.common.et.yey.model.E705Request;
import com.xyw.medical.common.et.yey.model.E705Response;
import com.xyw.medical.common.et.yey.model.VE705;

@Repository("e705Dao")
@Scope("prototype")
@Transactional
public class E705DaoImpl implements E705Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public E705Response deleteE705(E705Request e705Request) {
		boolean state = false;
		E705Response e705Response = new E705Response();
		String e70504 = e705Request.getE70504();
		Session session = sessionFactory.getCurrentSession();
		Object count = session.createSQLQuery(
				"select count(*) from e702 where e702_04=?").setParameter(0,
				e70504).uniqueResult();
		if(!"0".equals(count.toString()))
			e705Response.setErrorMessage("该幼儿园已经使用，无法删除！");
		else {
			session.delete(session.get(E705.class, e705Request.getE70501()));
			state=true;
			e705Response.setPromptMessage("删除成功");
		}
		e705Response.setState(state);
		return e705Response;
	}

	@Override
	public E705Response queryE705(E705Request e705Request) {
		E705 e705 = e705Request.getE705();
		String e70511=e705.getE70511();
		Date timeStr = e705Request.getTimeStr();
		Date timeEnd = e705Request.getTimeEnd();
		E705Response e705Response = new E705Response();
		int pageIndex = e705Request.getParameterPageindex();
		int pageSize = e705Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sb = new StringBuffer();
		if (timeStr != null) {
			sb.append(" and to_char(e705_13,'yyyy-mm-dd') >= '"
					+ sdf.format(timeStr) + "'");

			sb.append(" and to_char(e705_13,'yyyy-mm-dd') <= '"
					+ sdf.format(timeEnd) + "'");
		}

		sb.append(" and e705_11 ");
		if (e70511.length() == 14) {
			sb.append("='"+e70511+"'");
		} else {
			sb.append("like '"+e70511+"%'");
		}
		Session session = sessionFactory.getCurrentSession();
		String sql = " from v_e705 t where  1=1 " + sb.toString();
		Object rowCount = session.createSQLQuery("select count(*)" + sql)
		.uniqueResult();

		sql += sb.append(" order by e705_13").toString();
		
		List<VE705> ve705s = (List<VE705>) session.createSQLQuery(
				"select *" + sql).addEntity(VE705.class).setFirstResult(
				(pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
		
		e705Response.setRowCount(Long.valueOf(rowCount.toString()));
		e705Response.setVe705s(ve705s);
		return e705Response;
	}

	@Override
	public E705Response renewE705(E705Request e705Request) {
		String errorMessage=null;
		boolean state = false;
		E705 e705 = e705Request.getE705();
		E705Response e705Response = new E705Response();
		Session session = sessionFactory.getCurrentSession();
		E705 oldE7058=(E705) session.get(E705.class, e705.getE70501());
		if(oldE7058==null)
			errorMessage="没有这条信息无法修改！";
		else{
			errorMessage=hasSameName(session,e705,"修改");
			if(errorMessage==null){
				session.clear();
				session.update(e705);
				session.flush();
				session.refresh(e705);
				state=true;
				e705Response.setErrorMessage("修改成功！");
			}
		}
		e705Response.setState(state);
		e705Response.setErrorMessage(errorMessage);
		return e705Response;
	}

	@Override
	public E705Response saveE705(E705Request e705Request) {
		String errorMessage=null;
		boolean state = false;
		E705 e705 = e705Request.getE705();
		E705Response e705Response = new E705Response();
		Session session = sessionFactory.getCurrentSession();
		errorMessage=hasSameName(session,e705,"保存");
		if(errorMessage==null){
			e705.setE70504(getE70504(e705.getE70511(),session));
			session.save(e705);
			state=true;
		}
		e705Response.setState(state);
		e705Response.setErrorMessage(errorMessage);
		return e705Response;
	}

	private String hasSameName(Session session,E705 e705,String suffixMessage) {
		String message=null;
		Object count =session.createSQLQuery("select count(*) from e705 where e705_03=? " +
		"and e705_05=?").setParameter(0, e705.getE70503())
		.setParameter(1, e705.getE70505())
		.uniqueResult();
		if(Integer.parseInt(count.toString())>1)
			message="该幼儿园已经被其他机构登记，无法"+suffixMessage+"！";
		return message;
	}
	
	private String getE70504(String e70511,Session session) {
		Object count =session.createSQLQuery("select max(substr(e705_04,15))+1 from e705 where substr(e705_11,0,6)=?")
		.setParameter(0, e70511.substring(0, 6)).uniqueResult();
		String e70504=count!=null?("0000".substring(count.toString().length())+count):"0001";
		return e70511+e70504;
	}
}
