package com.xyw.medical.swjc.csqxrqjc.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;

import com.xyw.medical.fnbj.model.L301;
import com.xyw.medical.fnbj.model.L301Response;
import com.xyw.medical.swjc.csqxrqjc.dao.Sw303Dao;
import com.xyw.medical.swjc.model.Sw301Response;
import com.xyw.medical.swjc.model.Sw303;
import com.xyw.medical.swjc.model.Sw303Request;
import com.xyw.medical.swjc.model.Sw303Response;
import com.xyw.medical.swjc.model.VSw303;
import com.xyw.sys.util.StringUtil;

public class Sw303DaoImpl implements Sw303Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public Sw303Response saveSw303(Sw303 sw303) {
		boolean status = true;
		Sw303Response sw303Response = new Sw303Response();
		try {
			Session session=sessionFactory.getCurrentSession();
			Object[] sw303Fields=(Object[]) session.createSQLQuery("select sw303_83,sw303_84ZH from " +
					"v_sw303 where sw303_05=? and sw303_09=? and sw303_85=?")
							.setParameter(0, sw303.getSw30305()).setParameter(1, sw303.getSw30309())
							.setParameter(2, sw303.getSw30385()).uniqueResult();
			if(sw303Fields!=null)
			{
				status = false;
				sw303Response.setErrorMessage("该信息已经被" + sw303Fields[1]
						+ "于"
						+ new DateTime(sw303Fields[0]).toString("yyyy-MM-dd")
						+ "登记过档案！");
			}
			if(status)
			{
//				sw303Response=SetCode(sw303, session);
//				if(sw303Response.isState())
//				{
//					sw303 =sw303Response.getSw303();
//					session.save(sw303);
//					sw303Response.setPromptMessage("保存成功");
//				}
				session.save(sw303);
				sw303Response.setPromptMessage("保存成功");
			}
		} catch (Exception e) {
			status=false;
			sw303Response.setErrorMessage(e.getMessage());
		}
		sw303Response.setState(status);
		return sw303Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Sw303Response querySw303(Sw303Request sw303Request) {
		boolean state=true;
		Sw303 sw303=sw303Request.getSw303();
		String sw30384=sw303.getSw30384();
		Date timeDate=sw303Request.getTimeStr();
		Date timeEnDate=sw303Request.getTimeEnd();
		String suffixSql=sw303Request.getSuffixSql();
		Sw303Response sw303Response = new Sw303Response();
		int pageSize = sw303Request.getParameterPagesize();
		int pageIndex = sw303Request.getParameterPageindex();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		try {
			if (!StringUtil.isBlankString(sw303.getSw30302())) {
				parameterConditionwhere.append("and sw303_02 " + sw303.getSw30302());
			}
			if (!StringUtil.isBlankString(sw303.getSw30303())) {
				parameterConditionwhere.append("and sw303_03 " + sw303.getSw30303());
			}
			
			if (!StringUtil.isBlankString(sw303.getSw30305())) {
				parameterConditionwhere.append("and sw303_05 " + sw303.getSw30305());
			}
			if (!StringUtil.isBlankString(sw303.getSw30308())) {
				parameterConditionwhere.append("and sw303_08 " + sw303.getSw30308());
			}
			
			if (!StringUtil.isBlankString(sw303.getSw30311())) {
				parameterConditionwhere.append("and sw303_11 " + sw303.getSw30311());
			}
			if (!StringUtil.isBlankString(sw303.getSw30312())) {
				parameterConditionwhere.append("and sw303_12 " + sw303.getSw30312());
			}
			
			if (!StringUtil.isBlankString(sw303.getSw30313())) {
				parameterConditionwhere.append("and sw303_13 " + sw303.getSw30313());
			}
			
			if (!StringUtil.isBlankString(sw303.getSw30314())) {
				parameterConditionwhere.append("and sw303_14 " + sw303.getSw30314());
			}
			
			if (!StringUtil.isBlankString(sw303.getSw30316())) {
				parameterConditionwhere.append("and sw303_16 " + sw303.getSw30316());
			}
			if (!StringUtil.isBlankString(sw303.getSw30319())) {
				parameterConditionwhere.append("and sw303_19 " + sw303.getSw30319());
			}
			
			if (!StringUtil.isBlankString(sw303.getSw30321())) {
				parameterConditionwhere.append("and sw303_21 " + sw303.getSw30321());
			}
			
			if (!StringUtil.isBlankString(sw303.getSw30324())) {
				parameterConditionwhere.append("and sw303_24 " + sw303.getSw30324());
			}
			if (!StringUtil.isBlankString(sw303.getSw30325())) {
				parameterConditionwhere.append("and sw303_25 " + sw303.getSw30325());
			}
			if (!StringUtil.isBlankString(suffixSql)) {
				parameterConditionwhere.append(suffixSql);
			}
			
			//医疗机构
			if (!StringUtil.isBlankString(sw30384)) {
				if (sw30384.length() == 14) {
					parameterConditionwhere.append(" and sw303_84 = '");
					parameterConditionwhere.append(sw30384);
					parameterConditionwhere.append("'");
				} else {
					parameterConditionwhere.append(" and sw303_84 like '");
					parameterConditionwhere.append(sw30384);
					parameterConditionwhere.append("%'");
				}
			}
			Session session=sessionFactory.getCurrentSession();
			
			Object rowCount = session.createQuery("select count(*) from v_sw303 t where  1=1 "+parameterConditionwhere).uniqueResult();

			List<VSw303> vSw303s=(List<VSw303>) session.createSQLQuery("select * from v_sw303 where 1=1 "
								+parameterConditionwhere
								.append("order by sw303_42,sw303_01").toString())
								.addEntity(VSw303.class)
								.setFirstResult((pageIndex - 1) * pageSize)
								.setMaxResults(pageSize).list();
			

			sw303Response.setRowCount(Long.valueOf(rowCount.toString()));
			sw303Response.setvSw303s(vSw303s);

		} catch (Exception e) {
			state=false;
			sw303Response.setErrorMessage(e.getMessage());
		}
		sw303Response.setState(state);
		return sw303Response;
	}
	
	@Override
	public Sw303Response delSw303(String sw30301) {
		Sw303Response sw303Response = new Sw303Response();
		boolean state = false;
		try {
			if (!StringUtil.isBlankString(sw30301)) {
				Session session = sessionFactory.getCurrentSession();
				Sw303 sw303 = (Sw303) session.get(Sw303.class, sw30301);
				if(sw303!=null){
					session.delete(sw303);
					state = true;
				}
			}
			sw303Response.setErrorMessage("删除失败！");
		}catch (Exception e) {
			state=false;
			sw303Response.setErrorMessage(e.getMessage());
		}
		sw303Response.setState(state);
		return sw303Response;
	}

	@Override
	public Sw303Response renewSw303(Sw303 sw303) {
		boolean state = false;
		Sw303Response sw303Response = new Sw303Response();
		try {
			if (sw303 != null) {
				Session session = sessionFactory.getCurrentSession();
				session.saveOrUpdate(sw303);
				state = true;
				sw303Response.setPromptMessage("更新成功");
			}
		} catch (Exception e) {
			sw303Response.setErrorMessage(e.getMessage());
		}
		sw303Response.setState(state);
		return sw303Response;
	}

	
	/* 制作建卡编号 */
	private Sw303Response SetCode(Sw303 sw303, Session session) {
		int i = 0;
		Sw303Response sw303Response = new Sw303Response();
		sw303Response.setState(false);
		try {
			String sw30344=sw303.getSw30344();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String year = sdf.format(new Date()).substring(2);
			String maxSw30346 = (String) session
						.createSQLQuery(
								"select max(sw303_46) from sw303 t where sw303_44 = ? and  substr(sw303_46,1,2)=?")
						.setString(0,sw30344).setString(1, year)
						.uniqueResult();
			maxSw30346 = maxSw30346 != null ? maxSw30346 : "0";
			i = Integer.parseInt(maxSw30346) + 1;
			String str_m = String.valueOf(i);
			String str = "00000";
			str_m = str.substring(0, 5 - str_m.length()) + str_m;
			String sw30305 = year + sw30344 + str_m;
			sw303.setSw30305(sw30305);
			sw303.setSw30346(str_m);
			sw303Response.setSw303(sw303);
			sw303Response.setState(true);
			sw303Response.setPromptMessage("保存建册编号成功");	
		} catch (Exception e) {
			sw303Response.setState(false);
			sw303Response.setErrorMessage("建册编号异常"+e.getMessage());
		}
		return sw303Response;
	}

	

	
}
