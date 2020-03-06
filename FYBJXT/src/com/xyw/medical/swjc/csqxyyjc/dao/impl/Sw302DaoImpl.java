package com.xyw.medical.swjc.csqxyyjc.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;

import com.xyw.medical.swjc.csqxyyjc.dao.Sw302Dao;
import com.xyw.medical.swjc.model.Sw302;
import com.xyw.medical.swjc.model.Sw302Request;
import com.xyw.medical.swjc.model.Sw302Response;
import com.xyw.medical.swjc.model.VSw302;
import com.xyw.sys.util.StringUtil;

public class Sw302DaoImpl implements Sw302Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public Sw302Response saveSw302(Sw302 sw302) {
		boolean status = true;
		Sw302Response sw302Response = new Sw302Response();
		try {
			Session session=sessionFactory.getCurrentSession();
			Object[] sw302Fields=(Object[]) session.createSQLQuery("select sw302_81,sw302_82ZH from " +
					"v_sw302 where sw302_06=? and sw302_09=? and sw302_84=?")
							.setParameter(0, sw302.getSw30206()).setParameter(1, sw302.getSw30209())
							.setParameter(2, sw302.getSw30284()).uniqueResult();
			if(sw302Fields!=null)
			{
				status = false;
				sw302Response.setErrorMessage("该信息已经被" + sw302Fields[1]
						+ "于"
						+ new DateTime(sw302Fields[0]).toString("yyyy-MM-dd")
						+ "登记过档案！");
			}
			if(status)
			{
//				sw302Response=SetCode(sw302, session);
//				if(sw302Response.isState())
//				{
//					sw302 =sw302Response.getSw302();
//					session.save(sw302);
//					sw302Response.setPromptMessage("保存成功");
//				}
				session.save(sw302);
				sw302Response.setPromptMessage("保存成功");
			}
		} catch (Exception e) {
			status=false;
			sw302Response.setErrorMessage(e.getMessage());
		}
		sw302Response.setState(status);
		return sw302Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Sw302Response query(Sw302Request sw302Request) {
		boolean state=true;
		Sw302 sw302=sw302Request.getSw302();
		String sw30282=sw302.getSw30282();
		Date timeDate=sw302Request.getTimeStr();
		Date timeEnDate=sw302Request.getTimeEnd();
		String suffixSql=sw302Request.getSuffixSql();
		Sw302Response sw302Response = new Sw302Response();
		int pageSize = sw302Request.getParameterPagesize();
		int pageIndex = sw302Request.getParameterPageindex();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		try {
			if (!StringUtil.isBlankString(sw302.getSw30205())) {
				parameterConditionwhere.append("and sw302_05 " + sw302.getSw30205());
			}
			
			if (!StringUtil.isBlankString(sw302.getSw30206())) {
				parameterConditionwhere.append("and sw302_06 " + sw302.getSw30206());
			}
			
			if (!StringUtil.isBlankString(sw302.getSw30207())) {
				parameterConditionwhere.append("and sw302_07 " + sw302.getSw30207());
			}
			
			if (!StringUtil.isBlankString(sw302.getSw30209())) {
				parameterConditionwhere.append("and sw302_09 " + sw302.getSw30209());
			}
			
			if (!StringUtil.isBlankString(sw302.getSw30211())) {
				parameterConditionwhere.append("and sw302_11 " + sw302.getSw30211());
			}
			if (!StringUtil.isBlankString(sw302.getSw30212())) {
				parameterConditionwhere.append("and sw302_12 " + sw302.getSw30212());
			}
			
			if (!StringUtil.isBlankString(sw302.getSw30217())) {
				parameterConditionwhere.append("and sw302_17 " + sw302.getSw30217());
			}
			
			if (!StringUtil.isBlankString(sw302.getSw30220())) {
				parameterConditionwhere.append("and sw302_20 " + sw302.getSw30220());
			}
			
			if (!StringUtil.isBlankString(sw302.getSw30224())) {
				parameterConditionwhere.append("and sw302_24 " + sw302.getSw30224());
			}
			if (!StringUtil.isBlankString(sw302.getSw30225())) {
				parameterConditionwhere.append("and sw302_25 " + sw302.getSw30224());
			}
	
			if (!StringUtil.isBlankString(suffixSql)) {
				parameterConditionwhere.append(suffixSql);
			}
			if (!StringUtil.isBlankString(sw30282)) {
				if (sw30282.length() == 14) {
					parameterConditionwhere.append(" and sw302_82 = '");
					parameterConditionwhere.append(sw30282);
					parameterConditionwhere.append("'");
				} else {
					parameterConditionwhere.append(" and sw302_82 like '");
					parameterConditionwhere.append(sw30282);
					parameterConditionwhere.append("%'");
				}
			}
			
			Session session=sessionFactory.getCurrentSession();
			
			Object rowCount = session.createQuery("select count(*) from v_sw302 t where  1=1 "+parameterConditionwhere).uniqueResult();

			List<VSw302> vSw302s=(List<VSw302>) session.createSQLQuery("select * from v_sw302 where 1=1 "
								+parameterConditionwhere
								.append("order by sw302_81,sw302_01").toString())
								.addEntity(VSw302.class)
								.setFirstResult((pageIndex - 1) * pageSize)
								.setMaxResults(pageSize).list();
			

			sw302Response.setRowCount(Long.valueOf(rowCount.toString()));
			sw302Response.setvSw302s(vSw302s);

		} catch (Exception e) {
			state=false;
			sw302Response.setErrorMessage(e.getMessage());
		}
		sw302Response.setState(state);
		return sw302Response;
	}
	
	@Override
	public Sw302Response delSw302(String sw30201) {
		Sw302Response sw302Response = new Sw302Response();
		boolean state = false;
		try {
			if (!StringUtil.isBlankString(sw30201)) {
				Session session = sessionFactory.getCurrentSession();
				Sw302 sw302 = (Sw302) session.get(Sw302.class, sw30201);
				if(sw302!=null){
					session.delete(sw302);
					state = true;
				}
			}
			sw302Response.setErrorMessage("删除失败！");
		}catch (Exception e) {
			state=false;
			sw302Response.setErrorMessage(e.getMessage());
		}
		sw302Response.setState(state);
		return sw302Response;
	}

	@Override
	public Sw302Response renewSw302(Sw302 sw302) {
		boolean state = false;
		Sw302Response sw302Response = new Sw302Response();
		try {
			if (sw302 != null) {
				Session session = sessionFactory.getCurrentSession();
				session.saveOrUpdate(sw302);
				state = true;
				sw302Response.setPromptMessage("更新成功");
			}
		} catch (Exception e) {
			sw302Response.setErrorMessage(e.getMessage());
		}
		sw302Response.setState(state);
		return sw302Response;
	}
	
	/* 制作建卡编号 */
	private Sw302Response SetCode(Sw302 sw302, Session session) {
		int i = 0;
		Sw302Response sw302Response = new Sw302Response();
		sw302Response.setState(false);
		try {
			String sw30244=sw302.getSw30244();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String year = sdf.format(new Date()).substring(2);
			String maxSw30246 = (String) session
						.createSQLQuery(
								"select max(sw302_46) from sw302 t where sw302_44 = ? and  substr(sw302_46,1,2)=?")
						.setString(0,sw30244).setString(1, year)
						.uniqueResult();
			maxSw30246 = maxSw30246 != null ? maxSw30246 : "0";
			i = Integer.parseInt(maxSw30246) + 1;
			String str_m = String.valueOf(i);
			String str = "00000";
			str_m = str.substring(0, 5 - str_m.length()) + str_m;
			String sw30205 = year + sw30244 + str_m;
			sw302.setSw30205(sw30205);
			sw302.setSw30246(str_m);
			sw302Response.setSw302(sw302);
			sw302Response.setState(true);
			sw302Response.setPromptMessage("保存建册编号成功");	
		} catch (Exception e) {
			sw302Response.setState(false);
			sw302Response.setErrorMessage("建册编号异常"+e.getMessage());
		}
		return sw302Response;
	}

	


	
}
