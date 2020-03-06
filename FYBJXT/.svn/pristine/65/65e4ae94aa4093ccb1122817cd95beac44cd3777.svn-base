package com.xyw.medical.swjc.ycfsw.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;

import com.xyw.medical.swjc.model.Sw301Response;
import com.xyw.medical.swjc.model.Sw303;
import com.xyw.medical.swjc.model.Sw303Response;
import com.xyw.medical.swjc.model.Sw304;
import com.xyw.medical.swjc.model.Sw304Request;
import com.xyw.medical.swjc.model.Sw304Response;
import com.xyw.medical.swjc.model.VSw304;
import com.xyw.medical.swjc.ycfsw.dao.Sw304Dao;
import com.xyw.sys.util.StringUtil;

public class Sw304DaoImpl implements Sw304Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public Sw304Response saveSw304(Sw304 sw304) {
		boolean status = true;
		Sw304Response sw304Response = new Sw304Response();
		try {
			Session session=sessionFactory.getCurrentSession();
			Object[] sw304Fields=(Object[]) session.createSQLQuery("select sw304_58,sw304_59ZH from " +
					"v_sw304 where sw304_07=?" ).setParameter(0, sw304.getSw30407())
							.uniqueResult();
			if(sw304Fields!=null)
			{
				status = false;
				sw304Response.setErrorMessage("该信息已经被" + sw304Fields[1]
						+ "于"
						+ new DateTime(sw304Fields[0]).toString("yyyy-MM-dd")
						+ "登记过档案！");
			}
			
			if(status)
			{
//				sw304Response=SetCode(sw304, session);
//				if(sw304Response.isState())
//				{
//					sw304 =sw304Response.getSw304();
//					session.save(sw304);
//					sw304Response.setPromptMessage("保存成功");
//				}
				session.save(sw304);
				sw304Response.setPromptMessage("保存成功");
			}
		} catch (Exception e) {
			status=false;
			sw304Response.setErrorMessage(e.getMessage());
		}
		sw304Response.setState(status);
		return sw304Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Sw304Response querySw304(Sw304Request sw304Request) {
		boolean state=true;
		Sw304 sw304=sw304Request.getSw304();
		String sw30459=sw304.getSw30459();
		Date timeDate=sw304Request.getTimeStr();
		Date timeEnDate=sw304Request.getTimeEnd();
		String suffixSql=sw304Request.getSuffixSql();
		Sw304Response sw304Response = new Sw304Response();
		int pageSize = sw304Request.getParameterPagesize();
		int pageIndex = sw304Request.getParameterPageindex();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		try {
			if (!StringUtil.isBlankString(sw304.getSw30404())) {
				parameterConditionwhere.append("and sw304_04 " + sw304.getSw30404());
			}
			if (!StringUtil.isBlankString(sw304.getSw30405())) {
				parameterConditionwhere.append("and sw304_05 " + sw304.getSw30405());
			}
			
			if (!StringUtil.isBlankString(sw304.getSw30407())) {
				parameterConditionwhere.append("and sw304_07 " + sw304.getSw30407());
			}
			
			if (!StringUtil.isBlankString(sw304.getSw30410())) {
				parameterConditionwhere.append("and sw304_10 " + sw304.getSw30410());
			}
			
			if (!StringUtil.isBlankString(sw304.getSw30413())) {
				parameterConditionwhere.append("and sw304_13 " + sw304.getSw30413());
			}
			
			if (!StringUtil.isBlankString(sw304.getSw30414())) {
				parameterConditionwhere.append("and sw304_14 " + sw304.getSw30414());
			}
			
			if (!StringUtil.isBlankString(sw304.getSw30415())) {
				parameterConditionwhere.append("and sw304_15 " + sw304.getSw30415());
			}
			if (!StringUtil.isBlankString(sw304.getSw30416())) {
				parameterConditionwhere.append("and sw304_16 " + sw304.getSw30416());
			}
			
			if (!StringUtil.isBlankString(sw304.getSw30441())) {
				parameterConditionwhere.append("and sw304_41 " + sw304.getSw30441());
			}
	
			if (!StringUtil.isBlankString(suffixSql)) {
				parameterConditionwhere.append(suffixSql);
			}
			//医疗机构
			if (!StringUtil.isBlankString(sw30459)) {
				if (sw30459.length() == 14) {
					parameterConditionwhere.append(" and sw304_59 = '");
					parameterConditionwhere.append(sw30459);
					parameterConditionwhere.append("'");
				} else {
					parameterConditionwhere.append(" and sw304_59 like '");
					parameterConditionwhere.append(sw30459);
					parameterConditionwhere.append("%'");
				}
			}
			Session session=sessionFactory.getCurrentSession();
			
			Object rowCount = session.createQuery("select count(*) from v_sw304 t where  1=1 "+parameterConditionwhere).uniqueResult();

			List<VSw304> vSw304s=(List<VSw304>) session.createSQLQuery("select * from v_sw304 where 1=1 "
								+parameterConditionwhere
								.append("order by sw304_42,sw304_01").toString())
								.addEntity(VSw304.class)
								.setFirstResult((pageIndex - 1) * pageSize)
								.setMaxResults(pageSize).list();
			

			sw304Response.setRowCount(Long.valueOf(rowCount.toString()));
			sw304Response.setvSw304s(vSw304s);

		} catch (Exception e) {
			state=false;
			sw304Response.setErrorMessage(e.getMessage());
		}
		sw304Response.setState(state);
		return sw304Response;
	}
	
	@Override
	public Sw304Response delSw304(String sw30401) {
		Sw304Response sw304Response = new Sw304Response();
		boolean state = false;
		try {
			if (!StringUtil.isBlankString(sw30401)) {
				Session session = sessionFactory.getCurrentSession();
				Sw304 sw304 = (Sw304) session.get(Sw304.class, sw30401);
				if(sw304!=null){
					session.delete(sw304);
					state = true;
				}
			}
			sw304Response.setErrorMessage("删除失败！");
		}catch (Exception e) {
			state=false;
			sw304Response.setErrorMessage(e.getMessage());
		}
		sw304Response.setState(state);
		return sw304Response;
	}

	@Override
	public Sw304Response renewSw304(Sw304 sw304) {
		boolean state = false;
		Sw304Response sw304Response = new Sw304Response();
		try {
			if (sw304 != null) {
				Session session = sessionFactory.getCurrentSession();
				session.saveOrUpdate(sw304);
				state = true;
				sw304Response.setPromptMessage("更新成功");
			}
		} catch (Exception e) {
			sw304Response.setErrorMessage(e.getMessage());
		}
		sw304Response.setState(state);
		return sw304Response;
	}
	
	/* 制作建卡编号 */
	private Sw304Response SetCode(Sw304 sw304, Session session) {
		int i = 0;
		Sw304Response sw304Response = new Sw304Response();
		sw304Response.setState(false);
		try {
			String sw30444=sw304.getSw30444();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String year = sdf.format(new Date()).substring(2);
			String maxSw30446 = (String) session
						.createSQLQuery(
								"select max(sw304_46) from sw304 t where sw304_44 = ? and  substr(sw304_46,1,2)=?")
						.setString(0,sw30444).setString(1, year)
						.uniqueResult();
			maxSw30446 = maxSw30446 != null ? maxSw30446 : "0";
			i = Integer.parseInt(maxSw30446) + 1;
			String str_m = String.valueOf(i);
			String str = "00000";
			str_m = str.substring(0, 5 - str_m.length()) + str_m;
			String sw30405 = year + sw30444 + str_m;
			sw304.setSw30405(sw30405);
			sw304.setSw30446(str_m);
			sw304Response.setSw304(sw304);
			sw304Response.setState(true);
			sw304Response.setPromptMessage("保存建册编号成功");	
		} catch (Exception e) {
			sw304Response.setState(false);
			sw304Response.setErrorMessage("建册编号异常"+e.getMessage());
		}
		return sw304Response;
	}

	


	
}
