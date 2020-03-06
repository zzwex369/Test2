package com.xyw.medical.swjc.etsw.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;

import com.xyw.medical.etbj.model.E504;
import com.xyw.medical.etbj.model.E505Response;
import com.xyw.medical.etbj.model.VE505AndVE504;
import com.xyw.medical.fnbj.model.L301;
import com.xyw.medical.fnbj.model.L301Response;
import com.xyw.medical.swjc.etsw.dao.Sw301Dao;
import com.xyw.medical.swjc.model.Sw301Request;
import com.xyw.medical.swjc.model.Sw301Response;
import com.xyw.medical.swjc.model.Sw301;
import com.xyw.medical.swjc.model.Sw303;
import com.xyw.medical.swjc.model.Sw303Response;
import com.xyw.medical.swjc.model.VSw301;
import com.xyw.sys.util.StringUtil;

public class Sw301DaoImpl implements Sw301Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public Sw301Response saveSw301(Sw301 sw301) {
		boolean status = true;
		Sw301Response sw301Response = new Sw301Response();
		try {
			Session session=sessionFactory.getCurrentSession();
			Object[] sw301Fields=(Object[]) session.createSQLQuery("select sw301_42,sw301_43ZH from v_sw301 where sw301_09=? and sw301_16=?")
							.setParameter(0, sw301.getSw30109()).setParameter(1, sw301.getSw30116())
							.uniqueResult();
			if(sw301Fields!=null)
			{
				
				status = false;
				sw301Response.setErrorMessage("该信息已经被" + sw301Fields[1]
						+ "于"
						+ new DateTime(sw301Fields[0]).toString("yyyy-MM-dd")
						+ "登记过档案！");
			}
			
			if(status)
			{
				sw301Response=SetCode(sw301, session);
				if(sw301Response.isState())
				{
					sw301 =sw301Response.getSw301();
					session.save(sw301);
					sw301Response.setPromptMessage("保存成功");
				}
			}
		} catch (Exception e) {
			status=false;
			sw301Response.setErrorMessage(e.getMessage());
		}
		sw301Response.setState(status);
		return sw301Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Sw301Response querySw301(Sw301Request sw301Request) {
		boolean state=true;
		Sw301 sw301=sw301Request.getSw301();
		Date timeDate=sw301Request.getTimeStr();
		Date timeEnDate=sw301Request.getTimeEnd();
		String suffixSql=sw301Request.getSuffixSql();
		Sw301Response sw301Response = new Sw301Response();
		int pageSize = sw301Request.getParameterPagesize();
		int pageIndex = sw301Request.getParameterPageindex();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		try {
			String sw30143=sw301.getSw30143();
			if (!StringUtil.isBlankString(sw301.getSw30105())) {
				parameterConditionwhere.append("and sw301_05 " + sw301.getSw30105());
			}
			
			if (!StringUtil.isBlankString(sw301.getSw30106())) {
				parameterConditionwhere.append("and sw301_06 " + sw301.getSw30106());
			}
			
			if (!StringUtil.isBlankString(sw301.getSw30107())) {
				parameterConditionwhere.append("and sw301_07 " + sw301.getSw30107());
			}
			
			if (!StringUtil.isBlankString(sw301.getSw30109())) {
				parameterConditionwhere.append("and sw301_09 " + sw301.getSw30109());
			}
			
			if (!StringUtil.isBlankString(sw301.getSw30110())) {
				parameterConditionwhere.append("and sw301_10 " + sw301.getSw30110());
			}
			if (!StringUtil.isBlankString(sw301.getSw30112())) {
				parameterConditionwhere.append("and sw301_12 " + sw301.getSw30112());
			}
			
			if (!StringUtil.isBlankString(sw301.getSw30113())) {
				parameterConditionwhere.append("and sw301_13 " + sw301.getSw30113());
			}
			
			if (!StringUtil.isBlankString(sw301.getSw30114())) {
				parameterConditionwhere.append("and sw301_14 " + sw301.getSw30114());
			}
			
			if (!StringUtil.isBlankString(sw301.getSw30115())) {
				parameterConditionwhere.append("and sw301_15 " + sw301.getSw30115());
			}
			
			if (!StringUtil.isBlankString(sw301.getSw30130())) {
				parameterConditionwhere.append("and sw301_30 " + sw301.getSw30130());
			}
	
			if (!StringUtil.isBlankString(suffixSql)) {
				parameterConditionwhere.append(suffixSql);
			}
			//医疗机构
			if (!StringUtil.isBlankString(sw30143)) {
				if (sw30143.length() == 14) {
					parameterConditionwhere.append(" and sw301_43 = '");
					parameterConditionwhere.append(sw30143);
					parameterConditionwhere.append("'");
				} else {
					parameterConditionwhere.append(" and sw301_43 like '");
					parameterConditionwhere.append(sw30143);
					parameterConditionwhere.append("%'");
				}
			}
			Session session=sessionFactory.getCurrentSession();
			
			Object rowCount = session.createQuery("select count(*) from v_sw301 t where  1=1 "+parameterConditionwhere).uniqueResult();

			List<VSw301> vSw301s=(List<VSw301>) session.createSQLQuery("select * from v_sw301 where 1=1 "
								+parameterConditionwhere
								.append("order by sw301_42,sw301_01").toString())
								.addEntity(VSw301.class)
								.setFirstResult((pageIndex - 1) * pageSize)
								.setMaxResults(pageSize).list();
			

			sw301Response.setRowCount(Long.valueOf(rowCount.toString()));
			sw301Response.setvSw301s(vSw301s);

		} catch (Exception e) {
			state=false;
			sw301Response.setErrorMessage(e.getMessage());
		}
		sw301Response.setState(state);
		return sw301Response;
	}
	
	
	
	

	@Override
	public Sw301Response delSw301(String sw30101) {
		Sw301Response sw301Response = new Sw301Response();
		boolean state = false;
		try {
			if (!StringUtil.isBlankString(sw30101)) {
				Session session = sessionFactory.getCurrentSession();
				Sw301 sw301 = (Sw301) session.get(Sw301.class, sw30101);
				if(sw301!=null){
					session.delete(sw301);
					state = true;
				}
			}
			sw301Response.setErrorMessage("删除失败！");
		}catch (Exception e) {
			state=false;
			sw301Response.setErrorMessage(e.getMessage());
		}
		sw301Response.setState(state);
		return sw301Response;
	}

	@Override
	public Sw301Response renewSw301(Sw301 sw301) {
		boolean state = false;
		Sw301Response sw301Response = new Sw301Response();
		try {
			if (sw301 != null) {
				Session session = sessionFactory.getCurrentSession();
				session.saveOrUpdate(sw301);
				state = true;
				sw301Response.setPromptMessage("更新成功");
			}
		} catch (Exception e) {
			sw301Response.setErrorMessage(e.getMessage());
		}
		sw301Response.setState(state);
		return sw301Response;
	}

	/* 制作建卡编号 */
	private Sw301Response SetCode(Sw301 sw301, Session session) {
		int i = 0;
		Sw301Response sw301Response = new Sw301Response();
		sw301Response.setState(false);
		try {
			String sw30144=sw301.getSw30144();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String year = sdf.format(new Date()).substring(2);
			String maxSw30146 = (String) session
						.createSQLQuery(
								"select max(sw301_46) from sw301 t where sw301_44 = ? and  substr(sw301_46,1,2)=?")
						.setString(0,sw30144).setString(1, year)
						.uniqueResult();
			maxSw30146 = maxSw30146 != null ? maxSw30146 : "0";
			i = Integer.parseInt(maxSw30146) + 1;
			String str_m = String.valueOf(i);
			String str = "00000";
			str_m = str.substring(0, 5 - str_m.length()) + str_m;
			String sw30105 = year + sw30144 + str_m;
			sw301.setSw30105(sw30105);
			sw301.setSw30146(str_m);
			sw301Response.setSw301(sw301);
			sw301Response.setState(true);
			sw301Response.setPromptMessage("保存建册编号成功");	
		} catch (Exception e) {
			sw301Response.setState(false);
			sw301Response.setErrorMessage("建册编号异常"+e.getMessage());
		}
		return sw301Response;
	}
	
}
