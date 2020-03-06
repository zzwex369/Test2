package com.xyw.medical.etbj.etsl.slzz.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.etbj.etsl.model.E703;
import com.xyw.medical.etbj.etsl.model.E703Request;
import com.xyw.medical.etbj.etsl.model.E703Response;
import com.xyw.medical.etbj.etsl.model.VE703;
import com.xyw.medical.etbj.etsl.slzz.dao.E703Dao;
import com.xyw.sys.util.StringUtil;

@Transactional
public class E703DaoImpl implements E703Dao{

	private static final String[] yueling = {"0","1","3","6","8","12","14","16","18","20","24","28","32"};
	
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public E703Response saveE703(E703Request e703Request) {
		E703Response resp = new E703Response();
		Session session = sessionFactory.getCurrentSession();
		E703 e703 = e703Request.getE703();
		List<String> list = session.createSQLQuery("select e701_34 from e701 where e701_01 = '"+e703.getE70302()+"'").list();
		String str = create70134(e703Request.getE70208(), list.get(0), "3");
		session.createSQLQuery("update e701 set e701_34 = '"+str+"' where e701_01 = '"+e703.getE70302()+"'").executeUpdate();
		e703.setE70325("2");
		session.save(e703);
		session.flush();
		resp.setFalg(true);
		return resp;
	}

	//0,0,0,0,0,0,0,0,0,0,0,0,0
	/*private String create70134(String source, String target, String rep){
		StringBuilder strBuilder = new StringBuilder(target);
		int i = Integer.parseInt(source);
		strBuilder.replace(2*i, 2*i+1, rep);
		return strBuilder.toString();
	}*/

	private String create70134(String source, String target, String rep){
		StringBuilder strBuilder = new StringBuilder(target);
		for(int i=0;i<=yueling.length-1;i++){
			if(yueling[i].equals(source)){
				strBuilder.replace(2*i, 2*i+1, rep);
				return strBuilder.toString();
			}
		}
		throw new RuntimeException("不合法的月龄");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E703Response deleteE703(E703Request e703Request) {
		E703Response resp = new E703Response();
		Session session = sessionFactory.getCurrentSession();
		E703 e703 = e703Request.getE703();
		List<String> list = session.createSQLQuery("select e701_34 from e701 where e701_01 = '"+e703.getE70302()+"'").list();
		String old = list.get(0);
		String e70208 = (String) session.createSQLQuery("select e702_08 from e702 where e702_01 = '"+e703.getE70303()+"'").list().get(0);
		String str = create70134(e70208, old, "2");
		session.createSQLQuery("update e701 set e701_34 = '"+str+"' where e701_01 = '"+e703.getE70302()+"'").executeUpdate();
		session.createSQLQuery("delete e703 where e703_01 = '"+e703Request.getZhujian()+"'").executeUpdate();
		session.flush();
		resp.setFalg(true);
		return resp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E703Response queryE703(E703Request e703Request) {
		E703Response resp = new E703Response();
		Session session = sessionFactory.getCurrentSession();
		String e703_05 = e703Request.getE703().getE70305();
		String e703_08 = e703Request.getE703().getE70308();
		Date e70318_str = e703Request.getE70318_str();
		Date e70318_end = e703Request.getE70318_end();
		Integer parameterPageindex = e703Request.getParameterPageindex();
		Integer parameterPagesize = e703Request.getParameterPagesize();
		String parent_name = e703Request.getParent_name();
		String parent_idcard = e703Request.getParent_idcard();
		String parent_phone = e703Request.getParent_phone();
		String jigou = e703Request.getJigou();
		StringBuilder str = new StringBuilder();
		if (!StringUtil.isBlankString(e703_05)) {
			str.append("and t.e703_05 ='" + e703_05+"'");
		}
		if (!StringUtil.isBlankString(e703_08)) {
			str.append("and t.e703_08 ='" + e703_08+"'");
		}
		if (!StringUtil.isBlankString(parent_name)) {
			str.append("and (t.e703_09 ='" + parent_name+"' or t.e703_11 = '"+parent_name+"')");
		}
		if (!StringUtil.isBlankString(parent_idcard)) {
			str.append("and (t.e703_10 ='" + parent_idcard+"' or t.e703_10 ='"+parent_idcard+"')");
		}
		if (!StringUtil.isBlankString(parent_phone)) {
			str.append("and t.e703_13 ='" + parent_phone+"'");
		}
		if (!StringUtil.isBlankString(jigou)) {
			str.append("and t.e703_16");
			if (jigou.length() == 14) {
				str.append(" = '" + jigou+"'");
			} else {
				str.append(" like '" + jigou+"%'");
			}
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (e70318_str!=null) {
			String s1 = format.format(e70318_str);
			str.append("and to_char(t.e703_18,'yyyy-mm-dd')>= '"+s1+"'");
		}
		if (e70318_end!=null) {
			String s1 = format.format(e70318_end);
			str.append("and to_char(t.e703_18,'yyyy-mm-dd')<= '"+s1+"'");
		}
		Object rowCount = session.createSQLQuery("select count(*) from V_E703 t where  1=1 "+str).uniqueResult();
		if(Long.valueOf(rowCount.toString())<=0){
			resp.setFalg(true);
			resp.setRowCount(0);
			resp.setState(3);
			resp.setVe703s(null);
			return resp;
		}
		List<VE703> ve703s=(List<VE703>) session.createSQLQuery("select * from V_E703 t where 1=1 "
							+str
							.toString())
							.addEntity(VE703.class)
							.setFirstResult((parameterPageindex - 1) * parameterPagesize)
							.setMaxResults(parameterPagesize).list();
		resp.setFalg(true);
		resp.setRowCount(Long.valueOf(rowCount.toString()));
		resp.setVe703s(ve703s);
		return resp;
	}

	@Override
	public E703Response updateE703(E703 e703) {
		E703Response resp = new E703Response();
		Session session = sessionFactory.getCurrentSession();
		if("1".equals(e703.getE70325())){
			resp.setFalg(false);
			resp.setState(4);
			return resp;
		}
		session.update(e703);
		session.flush();
		resp.setFalg(true);
		return resp;
	}
	
	
	
}
