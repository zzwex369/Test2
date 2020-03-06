package com.xyw.medical.etbj.etsl.slda.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.etbj.etsl.model.E701;
import com.xyw.medical.etbj.etsl.model.E701Request;
import com.xyw.medical.etbj.etsl.model.E701Response;
import com.xyw.medical.etbj.etsl.model.VE701;
import com.xyw.medical.etbj.etsl.slda.dao.E701Dao;
import com.xyw.sys.util.StringUtil;

@Transactional
public class E701DaoImpl implements E701Dao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public E701Response saveE701(E701 e701) {
		E701Response resp = new E701Response();
		Session session = sessionFactory.getCurrentSession();
		String name = e701.getE70106();
		Object[] list = (Object[]) session.createSQLQuery("select e701_31,e701_33 from e701 where e701_06 = '"+name+"' and (e701_19 = '"+e701.getE70119()+"' or e701_23 = '"+e701.getE70123()+"')").uniqueResult();
		if (list != null && list[0] != null) {
			resp.setFalg(false);
			Object uniqueResult = session.createSQLQuery("select d101_02 from d101 where d101_01 = '"+list[0]+"'").uniqueResult();
			VE701 ve701 = new VE701();
			ve701.setE70131_zh(uniqueResult.toString());
			ve701.setE70133Str(new DateTime(list[1]).toString("yyyy-MM-dd"));
			resp.setVe701(ve701);
			resp.setState(1);
			return resp;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(new Date());
		String e701_04 = (String)session.createSQLQuery("select max(e701_04) from e701 where substr(e701_05,1,4) = '"+year+"' and e701_15 ='"+e701.getE70115()+"'").uniqueResult();
		e701_04 = e701_04==null?"0":e701_04;
		int i = Integer.parseInt(e701_04)+1;
		e701_04 = String .valueOf(i);
		e701_04 = "00000".substring(0,5-e701_04.length())+e701_04;
		String e701_05 = year+e701.getE70115()+e701_04;
		e701.setE70104(e701_04);
		e701.setE70105(e701_05);
		e701.setE70134("0,0,0,0,0,0,0,0,0,0,0,0,0");
		session.save(e701);
		session.flush();
		resp.setFalg(true);
		return resp;
	}

	@SuppressWarnings("unchecked")
	//@Override
	public E701Response queryE701_(E701Request e701Request) {
		E701Response resp = new E701Response();
		Session session = sessionFactory.getCurrentSession();
		String jigou = e701Request.getJigou();
		String e701_06 = e701Request.getE701().getE70106();
		String e701_08 = e701Request.getE701().getE70108();
		Date e70133_str = e701Request.getE70133_str();
		Date e70133_end = e701Request.getE70133_end();
		Integer parameterPageindex = e701Request.getParameterPageindex();
		Integer parameterPagesize = e701Request.getParameterPagesize();
		String parent_name = e701Request.getParent_name();
		String parent_idcard = e701Request.getParent_idcard();
		String parent_phone = e701Request.getParent_phone();
		StringBuilder strcount = new StringBuilder();
		StringBuilder str = new StringBuilder();
		strcount.append("select count(e701_01) from e701 where ");
		str.append("select g.*,S301_01.s_02 e70107_zh,S301_03.s_02 e70110_zh,S301_04.s_02 e70111_zh from (select rownum r, e.* from e701 e where ");
		if(!StringUtil.isBlankString(jigou)) {
			strcount.append("e701_31 like '"+jigou+"%' and ");
			str.append("e.e701_31 like '"+jigou+"%' and ");
		}
		if(!StringUtil.isBlankString(e701_06)) {
			strcount.append("e701_06='"+e701_06+"' and ");
			str.append("e.e701_06='"+e701_06+"' and ");
		}
		if(!StringUtil.isBlankString(e701_08)) {
			strcount.append("e701_08='"+e701_08+"' and ");
			str.append("e.e701_08='"+e701_08+"' and ");
		}
		if(!StringUtil.isBlankString(parent_name)) {
			strcount.append("(e701_17='"+parent_name+"' or e701_21 = '"+parent_name+"') and ");
			str.append("(e.e701_17='"+parent_name+"' or e.e701_21 = '"+parent_name+"') and ");
		}
		if(!StringUtil.isBlankString(parent_idcard)) {
			strcount.append("(e701_19='"+parent_idcard+"' or e701_23= '"+parent_idcard+"') and ");
			str.append("(e.e701_19='"+parent_idcard+"' or e.e701_23 = '"+parent_idcard+"') and ");
		}
		if(!StringUtil.isBlankString(parent_phone)) {
			strcount.append("(e701_20='"+parent_phone+"' or e701_30= '"+parent_phone+"') and ");
			str.append("(e.e701_20='"+parent_phone+"' or e.e701_30= '"+parent_phone+"')  and ");
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(e70133_str!=null) {
			String s1 = format.format(e70133_str);
			strcount.append("to_char(e701_33,'yyyy-mm-dd')>= '"+s1+"' and ");
			str.append("to_char(e.e701_33,'yyyy-mm-dd')>= '"+s1+"' and ");
		}
		if(e70133_end!=null) {
			String s1 = format.format(e70133_end);
			strcount.append("to_char(e701_33,'yyyy-mm-dd')<= '"+s1+"' and ");
			str.append("to_char(e.e701_33,'yyyy-mm-dd')<= '"+s1+"' and ");
		}
		strcount.append("1=1");
		str.append("rownum<="+(parameterPageindex+parameterPagesize-1)+")"+" g left join S301_01 on g.e701_07 = S301_01.s_01 left join S301_03 on g.e701_10 = S301_03.s_01 left join S301_04 on g.e701_11 = S301_04.s_01 where r>="+parameterPageindex);
		System.out.println(strcount.toString());
		System.out.println(str.toString());
		List<?> list = session.createSQLQuery(strcount.toString()).list();
		long i = Long.parseLong(list.get(0).toString());
		if(i==0){
			resp.setFalg(true);
			resp.setState(3);
			resp.setRowCount(0);
			resp.setVe701s(null);
			return resp;
		}
		List<VE701> lists = session.createSQLQuery(str.toString()).addEntity(VE701.class).list();
		resp.setRowCount(i);
		resp.setVe701s(lists);
		resp.setFalg(true);
		return resp;
	}


	@SuppressWarnings("unchecked")
	@Override
	public E701Response queryE701(E701Request e701Request) {
		E701Response resp = new E701Response();
		Session session = sessionFactory.getCurrentSession();
		String jigou = e701Request.getJigou();
		String e701_06 = e701Request.getE701().getE70106();
		String e701_08 = e701Request.getE701().getE70108();
		Date e70133_str = e701Request.getE70133_str();
		Date e70133_end = e701Request.getE70133_end();
		Integer parameterPageindex = e701Request.getParameterPageindex();
		Integer parameterPagesize = e701Request.getParameterPagesize();
		String parent_name = e701Request.getParent_name();
		String parent_idcard = e701Request.getParent_idcard();
		String parent_phone = e701Request.getParent_phone();
		StringBuilder str = new StringBuilder();
		if(!StringUtil.isBlankString(jigou)) {
			str.append("e701_31");
			if (jigou.length() == 14) {
				str.append(" = '"+jigou+"' and ");
			} else {
				str.append(" like '"+jigou+"%' and ");
			}
		}
		if(!StringUtil.isBlankString(e701_06)) {
			str.append("e701_06='"+e701_06+"' and ");
		}
		if(!StringUtil.isBlankString(e701_08)) {
			str.append("e701_08='"+e701_08+"' and ");
		}
		if(!StringUtil.isBlankString(parent_name)) {
			str.append("(e701_17='"+parent_name+"' or e701_21 = '"+parent_name+"') and ");
		}
		if(!StringUtil.isBlankString(parent_idcard)) {
			str.append("(e701_19='"+parent_idcard+"' or e701_23 = '"+parent_idcard+"') and ");
		}
		if(!StringUtil.isBlankString(parent_phone)) {
			str.append("(e701_20='"+parent_phone+"' or e701_30= '"+parent_phone+"')  and ");
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(e70133_str!=null) {
			String s1 = format.format(e70133_str);
			str.append("to_char(e701_33,'yyyy-mm-dd')>= '"+s1+"' and ");
		}
		if(e70133_end!=null) {
			String s1 = format.format(e70133_end);
			str.append("to_char(e701_33,'yyyy-mm-dd')<= '"+s1+"' and ");
		}
	//	System.out.println(str.toString());
		Object rowCount = session.createSQLQuery("select count(*) from V_E701 where "+str+"1=1").uniqueResult();
		if(Long.valueOf(rowCount.toString())<=0){
			resp.setFalg(true);
			resp.setRowCount(0);
			resp.setState(3);
			resp.setVe701s(null);
			return resp;
		}
		List<VE701> ve701s=(List<VE701>) session.createSQLQuery("select * from V_E701 where "
				+str
				.toString()+"1=1")
				.addEntity(VE701.class)
				.setFirstResult((parameterPageindex - 1) * parameterPagesize)
				.setMaxResults(parameterPagesize).list();
		resp.setFalg(true);
		resp.setRowCount(Long.valueOf(rowCount.toString()));
		resp.setVe701s(ve701s);
		return resp;
	}

	@Override
	public E701Response updateE701(E701 e701) {
		E701Response resp = new E701Response();
		Session session = sessionFactory.getCurrentSession();
		Object num = session.createSQLQuery("select count(e702_01) from e702 where e702_02 = '"+e701.getE70101()+"'").uniqueResult();
		int size = session.createSQLQuery("select e704_01 from e704 where e704_02 = '"+e701.getE70101()+"'").list().size();
		if(Long.valueOf(num.toString())>0){
			resp.setFalg(false);
			resp.setState(4);
			return resp;
		}
		if(size>0){
			resp.setFalg(false);
			resp.setState(5);
			return resp;
		}
		E701 e = (E701) session.get(E701.class, e701.getE70101());
		if(e==null){
			resp.setFalg(false);
			resp.setState(3);
			return resp;
		}
		//e70102, e70104, e70105, e70114, e70133, e70134, e70135
		String[] strs = {"e70102","e70104","e70105","e70133","e70134","e70135"};
		BeanUtils.copyProperties(e701, e, strs);
		session.update(e);
		session.flush();
		resp.setFalg(true);
		return resp;
	}

	@Override
	public E701Response deleteE701(E701Request e701Request) {
		E701Response resp = new E701Response();
		Session session = sessionFactory.getCurrentSession();
		String sid = e701Request.getZhujian();
		Object num = session.createSQLQuery("select count(e702_01) from e702 where e702_02 = '"+sid+"'").uniqueResult();
		int size = session.createSQLQuery("select e704_01 from e704 where e704_02 = '"+sid+"'").list().size();
		if(Long.valueOf(num.toString())>0){
			resp.setFalg(false);
			resp.setState(4);
			return resp;
		}
		if(size>0){
			resp.setFalg(false);
			resp.setState(5);
			return resp;
		}
		String sql = "delete e701 where e701_01=?";
		int i = session.createSQLQuery(sql).setString(0, sid).executeUpdate();
		session.flush();
		if(i==0) {
			resp.setFalg(false);
			resp.setState(3);
		}else {
			resp.setFalg(true);
		}
		return resp;
	}



}
