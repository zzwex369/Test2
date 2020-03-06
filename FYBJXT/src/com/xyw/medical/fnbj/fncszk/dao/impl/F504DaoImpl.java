package com.xyw.medical.fnbj.fncszk.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.fnbj.fncszk.dao.F504Dao;
import com.xyw.medical.fnbj.model.F502;
import com.xyw.medical.fnbj.model.F504;
import com.xyw.medical.fnbj.model.F504Request;
import com.xyw.medical.fnbj.model.F504Response;
import com.xyw.medical.fnbj.model.VF504;
import com.xyw.sys.util.StringUtil;

public class F504DaoImpl implements F504Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public F504Response delF504(F504Request f504Request) {
		F504 f504=f504Request.getF504();
		String flag=f504Request.getFlag();//这里用来提示 信息
		F504Response f504Response = new F504Response();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();	
		try {
			F502 f502=(F502) session.get(F502.class, f504.getF50402());
			f502.setF50240("2");
			f502.setF50241("2");
			session.delete(f504);
			f504Response.setPromptMessage(flag+"成功! ");
		} catch (Exception e) {
			f504Response.setErrorMessage(e.getMessage()+","+flag+"失败! ");
			e.printStackTrace();
			state = false;
		}
		f504Response.setState(state);
		return f504Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public F504Response queryF504(F504Request f504Request) {
		F504Response f504Response = new F504Response();
		F504 f504 = f504Request.getF504();
		String f50401 = f504.getF50401();
		String f50402 = f504.getF50402();
		String f50403 = f504.getF50403();
		String f50406 = f504.getF50406();
		String f50415 = f504.getF50415();
		String f50416 = f504.getF50416();
		Date timeStr_ = f504Request.getTimeStr();
		Date timeEnd_ = f504Request.getTimeEnd();
		Map<String, Object> fieldMap = f504Request.getFieldMap();
		String institutionCode = fieldMap.get("institutionCode").toString();
		String institutionCodeField = fieldMap.get("institutionCodeField").toString();
		String f50203 = fieldMap.get("f50203")==null?"":fieldMap.get("f50203").toString();
		String f50204 = fieldMap.get("f50204")==null?"":fieldMap.get("f50204").toString();
		String dateField = fieldMap.get("dateField")==null?"":fieldMap.get("dateField").toString();

		int pageIndex = f504Request.getParameterPageindex();
		int pageSize = f504Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		

		if (!StringUtil.isBlankString(f50203)) {
			parameterConditionwhere.append("and t.f502_03 ='" + f50203 + "' ");
		}
		if (!StringUtil.isBlankString(f50204)) {
			parameterConditionwhere.append("and t.f502_04 ='" + f50204 + "' ");
		}

		if (!StringUtil.isBlankString(f50401)) {
			parameterConditionwhere.append("and t.f504_01 ='" + f50401 + "' ");
		}
		if (!StringUtil.isBlankString(f50402)) {
			parameterConditionwhere.append("and t.f504_02 ='" + f50402 + "' ");
		}
		if (!StringUtil.isBlankString(f50403)) {
			parameterConditionwhere.append("and t.f504_03 ='" + f50403 + "' ");
		}
		if (!StringUtil.isBlankString(f50406)) {
			parameterConditionwhere.append("and t.f504_06 ='" + f50406 + "' ");
		}
		if (!StringUtil.isBlankString(f50415)) {
			parameterConditionwhere.append("and t.f504_15 ='" + f50415 + "' ");
		}
		if (!StringUtil.isBlankString(f50416)) {
			parameterConditionwhere.append("and t.f504_16 ='" + f50416 + "' ");
		}

		if (timeStr_ != null) {
			String timeStr = sdf.format(timeStr_);
			parameterConditionwhere.append(" and " + dateField + " >= to_date('"
					+ timeStr + "','yyyy-mm-dd')");
		}
		if (timeEnd_ != null) {
			String timeEnd = sdf.format(timeEnd_);
			parameterConditionwhere.append(" and " + dateField + " <=to_date('"
					+ timeEnd + "','yyyy-mm-dd')");
		}
		if (!StringUtil.isBlankString(institutionCode)) {
			if (institutionCode.length() == 14) {
				parameterConditionwhere.append(" and " + institutionCodeField
						+ " = '");
				parameterConditionwhere.append(institutionCode);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and " + institutionCodeField
						+ " like '");
				parameterConditionwhere.append(institutionCode);
				parameterConditionwhere.append("%'");
			}
		}
		boolean state = true;
		try {
			Session session = sessionFactory.getCurrentSession();
			Object rowCount = session.createSQLQuery("select count(*) from v_f504 t where  1=1 "+parameterConditionwhere).uniqueResult();

			List<VF504> vf504s = (List<VF504>) session.createSQLQuery(
					"select * from v_f504 t where 1=1 "
							+ parameterConditionwhere.append(
									"order by f504_05,f504_01").toString())
					.addEntity(VF504.class).setFirstResult(
							(pageIndex - 1) * pageSize).setMaxResults(pageSize)
					.list();

			f504Response.setRowCount(Long.valueOf(rowCount.toString()));
			f504Response.setVf504s(vf504s);
		} catch (Exception e) {
			state = false;
			f504Response.setErrorMessage(e.getMessage());
		}
		f504Response.setState(state);
		return f504Response;
	}

	@Override
	public F504Response saveOrF504(F504Request f504Request) {
		F504 f504=f504Request.getF504();
		String flag=f504Request.getFlag();//这里用来提示 信息
		F504Response f504Response = new F504Response();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();	
		try {
			F502 f502=(F502) session.get(F502.class, f504.getF50402());
			f502.setF50240(f504.getF50415());
			f502.setF50241(f504.getF50416());
			session.saveOrUpdate(f504);
			f504Response.setPromptMessage(flag+"成功! ");
		} catch (Exception e) {
			f504Response.setErrorMessage(e.getMessage()+","+flag+"失败! ");
			e.printStackTrace();
			state = false;
		}
		f504Response.setState(state);
		return f504Response;
	}

}
