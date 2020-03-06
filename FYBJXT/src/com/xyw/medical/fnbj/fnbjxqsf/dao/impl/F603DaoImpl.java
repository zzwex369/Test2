package com.xyw.medical.fnbj.fnbjxqsf.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.etbj.model.VE505AndVE504;
import com.xyw.medical.fnbj.fnbjxqsf.dao.F603Dao;
import com.xyw.medical.fnbj.model.F601;
import com.xyw.medical.fnbj.model.F603;
import com.xyw.medical.fnbj.model.F603Request;
import com.xyw.medical.fnbj.model.F603Response;
import com.xyw.medical.fnbj.model.VF603;
import com.xyw.sys.util.StringUtil;

public class F603DaoImpl implements F603Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public F603Response saveF603(F603 f603) {
		Boolean flag = false;
		F603Response f603Response = new F603Response();
		Session session = sessionFactory.getCurrentSession();
		try {
			if (f603 != null) {
				String f60302 = f603.getF60302();
				String f60303 = f603.getF60303();
				String f60304 = f603.getF60304();
				String f60301 = (String) session
						.createSQLQuery(
								"select t.f603_01 from f603 t where t.f603_03=? and t.f603_04=? ")
						.setString(0, f60303).setString(1, f60304)
						.uniqueResult();
				if (!StringUtil.isBlankString(f60301)) {
					f603Response.setErrorMessage("保存重复，请联系客服！");
				} else {
					if (StringUtil.isBlankString(f60302)) {// 无档案登记随访
						String f60101 = (String) session
								.createSQLQuery(
										"select t.f601_01 from f601 t where t.f601_03=? and t.f601_04=? ")
								.setString(0, f60303).setString(1, f60304)
								.uniqueResult();
						if (f60101 != null)
							f603Response.setErrorMessage("该信息存在档案！，请联系客服！");
						else
							flag = true;
					} else {// 有档案登记随访
						F601 f601 = (F601) session.get(F601.class, f60302);
						if (f601 != null) {
							flag = true;
							f601.setF60187("1");
							session.update(f601);
						} else {
							f603Response.setErrorMessage("档案不存在，请联系客服！");
						}
					}
				}
				if (flag) {
					session.save(f603);
					f603Response.setPromptMessage("保存成功");
				}
			}

		} catch (Exception e) {
			flag = false;
			f603Response.setErrorMessage(e.getMessage());
		}
		f603Response.setState(flag);
		return f603Response;
	}

	@Override
	public F603Response deleteF603(F603Request f603Request) throws Exception {
		F603Response f603Response = new F603Response();
		String d60301 = f603Request.getF60301();
		Object[] paramsArr = null;
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			StringBuffer sql = new StringBuffer(
					"select t.f603_02,t.f603_04 from f603 t where t.f603_01 ='"
							+ d60301 + "'");
			paramsArr = (Object[]) session.createSQLQuery(sql.toString())
					.uniqueResult();
			if (paramsArr.length < 1) {
				f603Response.setErrorMessage("不存在随访信息，不能删除!");
				state = false;
			}
		} catch (Exception e) {
			f603Response.setErrorMessage("删除失败! ");
			e.printStackTrace();
			state = false;
		}
		if (state) {
			F603 f603 = new F603();
			f603.setF60301(d60301);
			session.delete(f603);
			if (paramsArr[0] != null) {
				F601 f601 = (F601) session.get(F601.class, paramsArr[0]
						.toString());
				if (f601 != null) {
					f601.setF60187("2");
					session.update(f601);

				} else
					throw new RuntimeException("删除失败!档案不存在请联系客服！ ");
			}
			f603Response.setPromptMessage("删除成功！");
		}
		f603Response.setState(state);
		return f603Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public F603Response queryF603(F603Request f603Request) {
		String field = null;
		F603Response f603Response = new F603Response();
		F603 f603 = f603Request.getF603();
		String f60303 = f603.getF60303();
		String f60304 = f603.getF60304();
		String f60321 = f603.getF60321();
		String f60322 = f603.getF60322();
		HashMap<String, Object> paramHashMap = f603Request.getParamMap();

		int pageIndex = f603Request.getParameterPageindex();
		int pageSize = f603Request.getParameterPagesize();
		StringBuffer parameterConditionwhere = new StringBuffer();

		if (!StringUtil.isBlankString(f60303)) {
			parameterConditionwhere.append("and t.f603_03 ='" + f60303 + "' ");
		}
		if (!StringUtil.isBlankString(f60304)) {
			parameterConditionwhere.append("and t.f603_04 ='" + f60304 + "' ");
		}

		if (!StringUtil.isBlankString(f60321)) {
			parameterConditionwhere.append("and t.f603_21 ='" + f60321 + "' ");
		}

		if (!StringUtil.isBlankString(f60322)) {
			parameterConditionwhere.append("and t.f603_22 ='" + f60322 + "' ");
		}
		field = paramHashMap.get("dateField").toString();
		if (!StringUtil.isBlankString(field)) {
			String timeStr = paramHashMap.get("timeStr").toString();
			String timeEnd = paramHashMap.get("timeEnd").toString();
			parameterConditionwhere.append(" and to_char(" + field
					+ ",'yyyy-mm-dd') >= '" + timeStr + "'");

			parameterConditionwhere.append(" and to_char(" + field
					+ ",'yyyy-mm-dd') <= '" + timeEnd + "'");
		}

		field = paramHashMap.get("institutionField").toString();
		if (!StringUtil.isBlankString(field)) {
			String institution = paramHashMap.get("institution").toString();
			if (institution.length() == 14) {
				parameterConditionwhere.append(" and " + field + " = '");
				parameterConditionwhere.append(institution);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and " + field + " like '");
				parameterConditionwhere.append(institution);
				parameterConditionwhere.append("%'");
			}
		}
		boolean state = true;
		try {
			Session session = sessionFactory.getCurrentSession();

			Object rowCount = session.createSQLQuery(
					"select count(*) from v_f603 t where 1=1 "
							+ parameterConditionwhere.toString())
					.uniqueResult();
			List<VF603> vf603s = (List<VF603>) session.createSQLQuery(
					"select * from v_f603 t where  1=1 "
							+ parameterConditionwhere.append(
									"order by f603_25,f603_01").toString())
					.addEntity(VF603.class).setFirstResult(
							(pageIndex - 1) * pageSize).setMaxResults(pageSize)
					.list();

			f603Response.setRowCount(Long.valueOf(rowCount.toString()));
			f603Response.setVf603s(vf603s);
		} catch (Exception e) {
			state = false;
			f603Response.setErrorMessage(e.getMessage());
			e.printStackTrace();
		}
		f603Response.setState(state);
		return f603Response;
	}

	@Override
	public F603Response renewF603(F603 f603) {
		F603Response f603Response = new F603Response();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			StringBuffer sql = new StringBuffer(
					"select t.f603_03 from f603 t where t.f603_01 ='"
							+ f603.getF60301() + "'");
			String f60303 = (String) session.createSQLQuery(sql.toString())
					.uniqueResult();
			if (f60303 == null) {
				f603Response.setErrorMessage("不存在随访信息，不能修改!");
				state = false;
			}
		} catch (Exception e) {
			f603Response.setErrorMessage("保存失败! ");
			e.printStackTrace();
			state = false;
		}
		if (state) {
			try {

				session.update(f603);
				session.flush();
				session.refresh(f603);
				f603Response.setPromptMessage("修改成功! ");
			} catch (Exception e) {
				f603Response.setErrorMessage("保存失败! ");
				e.printStackTrace();
				state = false;
			}
		}
		f603Response.setState(state);
		return f603Response;
	}

}
