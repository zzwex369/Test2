package com.xyw.medical.etbj.etsl.slsf.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.etbj.etsl.model.E704;
import com.xyw.medical.etbj.etsl.model.E704Request;
import com.xyw.medical.etbj.etsl.model.E704Response;
import com.xyw.medical.etbj.etsl.model.VE704;
import com.xyw.medical.etbj.etsl.slsf.dao.E704Dao;
import com.xyw.sys.util.StringUtil;

@Transactional
public class E704DaoImpl implements E704Dao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public E704Response saveE704(E704 e704) {
		E704Response resp = new E704Response();
		Session session = sessionFactory.getCurrentSession();
		session.save(e704);
		session.flush();
		resp.setFalg(true);
		return resp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E704Response queryE704(E704Request e704Request) {
		E704Response resp = new E704Response();
		Session session = sessionFactory.getCurrentSession();
		String e70403 = e704Request.getE70403();
		String e70404 = e704Request.getE70404();
		String jigou = e704Request.getJigou();
		Integer parameterPageindex = e704Request.getParameterPageindex();
		Integer parameterPagesize = e704Request.getParameterPagesize();
		Date e70406str = e704Request.getE70406_str();
		Date e70406end = e704Request.getE70406_end();
		Date e70416str = e704Request.getE70416_str();
		Date e70416end = e704Request.getE70416_end();
		StringBuilder str = new StringBuilder();
		if(!StringUtil.isBlankString(e70403)){
			str.append("and e704_03 = '"+e70403+"'");
		}
		if(!StringUtil.isBlankString(e70404)){
			str.append("and e704_04 = '"+e70404+"'");
		}
		if(!StringUtil.isBlankString(jigou)){
			str.append("and e704_15");
			if (jigou.length() == 14) {
				str.append(" = '"+jigou+"'");
			} else {
				str.append(" like '"+jigou+"%'");
			}
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (e70406str!=null) {
			String s1 = format.format(e70406str);
			str.append("and to_char(e704_06,'yyyy-mm-dd')>= '"+s1+"'");
		}
		if (e70406end!=null) {
			String s1 = format.format(e70406end);
			str.append("and to_char(e704_06,'yyyy-mm-dd')<= '"+s1+"'");
		}
		if (e70416str!=null) {
			String s1 = format.format(e70416str);
			str.append("and to_char(e704_16,'yyyy-mm-dd')>= '"+s1+"'");
		}
		if (e70416end!=null) {
			String s1 = format.format(e70416end);
			str.append("and to_char(e704_16,'yyyy-mm-dd')<= '"+s1+"'");
		}
		Object rowCount = session.createSQLQuery("select count(*) from V_E704 where  1=1 "+str).uniqueResult();
		if(Long.valueOf(rowCount.toString())<=0){
			resp.setFalg(true);
			resp.setRowCount(0);
			resp.setState(3);
			resp.setVe704s(null);
			return resp;
		}
		List<VE704> ve704s=(List<VE704>) session.createSQLQuery("select * from V_E704 where 1=1 "
							+str
							.toString())
							.addEntity(VE704.class)
							.setFirstResult((parameterPageindex - 1) * parameterPagesize)
							.setMaxResults(parameterPagesize).list();
		resp.setFalg(true);
		resp.setRowCount(Long.valueOf(rowCount.toString()));
		resp.setVe704s(ve704s);
		return resp;
	}

	@Override
	public E704Response deleteE704(E704Request e704Request) {
		E704Response resp = new E704Response();
		Session session = sessionFactory.getCurrentSession();
		String zhujian = e704Request.getZhujian();
		session.createSQLQuery("delete e704 where e704_01 = '"+zhujian+"'").executeUpdate();
		resp.setFalg(true);
		return resp;
	}

	@Override
	public E704Response updateE704(E704 e704) {
		E704Response resp = new E704Response();
		Session session = sessionFactory.getCurrentSession();
		session.update(e704);
		session.flush();
		resp.setFalg(true);
		return resp;
	}

}
