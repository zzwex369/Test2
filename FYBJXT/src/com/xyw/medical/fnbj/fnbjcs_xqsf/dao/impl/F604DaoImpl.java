package com.xyw.medical.fnbj.fnbjcs_xqsf.dao.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.fnbj.fnbjcs_xqsf.dao.F604Dao;
import com.xyw.medical.fnbj.model.F501;
import com.xyw.medical.fnbj.model.F503;
import com.xyw.medical.fnbj.model.F503Response;
import com.xyw.medical.fnbj.model.F601;
import com.xyw.medical.fnbj.model.F601Response;
import com.xyw.medical.fnbj.model.F603;
import com.xyw.medical.fnbj.model.F603Response;
import com.xyw.medical.fnbj.model.F604;
import com.xyw.medical.fnbj.model.F604Request;
import com.xyw.medical.fnbj.model.F604Response;
import com.xyw.medical.fnbj.model.VF603;
import com.xyw.medical.fnbj.model.VF604;
import com.xyw.sys.util.StringUtil;

public class F604DaoImpl implements F604Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public F604Response saveF604(F604 f604) {
		Boolean flag = false;
		F604Response f604Response = new F604Response();
		Session session = sessionFactory.getCurrentSession();
		try {
			if (f604 != null) {
				String f60402 = f604.getF60402();
				String f60403 = f604.getF60403();
				String f60404 = f604.getF60404();
				String f60405 = f604.getF60405();
				String f60401 = (String) session
						.createSQLQuery(
								"select t.f604_01 from f604 t where t.f604_04=? and t.f604_05=? ")
						.setString(0, f60404).setString(1, f60405)
						.uniqueResult();
				if (!StringUtil.isBlankString(f60401)) {
					f604Response.setErrorMessage("保存重复，请联系客服！");
				} else {
					if (StringUtil.isBlankString(f60402)) {// 无档案登记随访
						String f60101 = (String) session
								.createSQLQuery(
										"select t.f601_01 from f601 t where t.f601_03=? and t.f601_04=? ")
								.setString(0, f60404).setString(1, f60405)
								.uniqueResult();
						if (f60101 != null)
							f604Response.setErrorMessage("该信息存在档案！，请联系客服！");
						else {
							String f50101 = (String) session
									.createSQLQuery(
											"select t.f501_01 from f501 t where t.f501_03=? and t.f501_05=? ")
									.setString(0, f60404).setString(1, f60405)
									.uniqueResult();
							if (f50101 != null)
								f604Response.setErrorMessage("该信息存在档案！，请联系客服！");
							else
								flag = true;
						}
					} else {// 有档案登记随访
						F501 f501 = (F501) session.get(F501.class, f60402);
						F601 f601 = (F601) session.get(F601.class, f60403);
						if (f601 != null && f501 != null) {
							flag = true;
							f501.setF50153("1");
							f601.setF60188("1");
							session.update(f601);
							session.update(f501);
						} else {
							f604Response.setErrorMessage("档案不存在，请联系客服！");
						}
					}
				}
				if (flag) {
					session.save(f604);
					f604Response.setPromptMessage("保存成功");
				}
			}

		} catch (Exception e) {
			flag = false;
			f604Response.setErrorMessage(e.getMessage());
		}
		f604Response.setState(flag);
		return f604Response;
	}

	@Override
	public F604Response deleteF604(F604Request f604Request) throws Exception {
		F604Response f604Response = new F604Response();
		String d60401 = f604Request.getF60401();
		Object[] paramsArr = null;
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			StringBuffer sql = new StringBuffer(
					"select t.f604_02,t.f604_03,t.f604_05 from f604 t where t.f604_01 ='"
							+ d60401 + "'");
			paramsArr = (Object[]) session.createSQLQuery(sql.toString())
					.uniqueResult();
			if (paramsArr.length < 1) {
				f604Response.setErrorMessage("不存在随访信息，不能删除!");
				state = false;
			}
		} catch (Exception e) {
			f604Response.setErrorMessage("删除失败! ");
			e.printStackTrace();
			state = false;
		}
		if (state) {
			F604 f604 = new F604();
			f604.setF60401(d60401);
			session.delete(f604);
			if (paramsArr[0] != null && paramsArr[1] != null) {
				F501 f501 = (F501) session.get(F501.class, paramsArr[0]
						.toString());
				F601 f601 = (F601) session.get(F601.class, paramsArr[1]
						.toString());
				if (f601 != null && f501 != null) {
					f501.setF50153("2");
					f601.setF60188("2");
					session.update(f601);
					session.update(f501);
				} else
					throw new RuntimeException("删除失败!档案不存在请联系客服！ ");
			}
			f604Response.setPromptMessage("删除成功！");

		}
		f604Response.setState(state);
		return f604Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public F604Response queryF604(F604Request f604Request) {
		String field = null;
		F604Response f604Response = new F604Response();
		F604 f604 = f604Request.getF604();
		String f60404 = f604.getF60404();
		String f60405 = f604.getF60405();
		String f60453 = f604.getF60453();
		String f60454 = f604.getF60454();
		HashMap<String, Object> paramHashMap = f604Request.getParamMap();

		int pageIndex = f604Request.getParameterPageindex();
		int pageSize = f604Request.getParameterPagesize();
		StringBuffer parameterConditionwhere = new StringBuffer();

		if (!StringUtil.isBlankString(f60404)) {
			parameterConditionwhere.append("and t.f604_04 ='" + f60404 + "' ");
		}
		if (!StringUtil.isBlankString(f60405)) {
			parameterConditionwhere.append("and t.f604_05 ='" + f60405 + "' ");
		}

		if (!StringUtil.isBlankString(f60453)) {
			parameterConditionwhere.append("and t.f604_53 ='" + f60453 + "' ");
		}

		if (!StringUtil.isBlankString(f60454)) {
			parameterConditionwhere.append("and t.f604_54 ='" + f60454 + "' ");
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
					"select count(*) from v_f604 t where 1=1 "
							+ parameterConditionwhere.toString())
					.uniqueResult();
			List<VF604> vf604s = (List<VF604>) session.createSQLQuery(
					"select * from v_f604 t where 1=1 "
							+ parameterConditionwhere.append(
									"order by f604_57,f604_01").toString())
					.addEntity(VF604.class).setFirstResult(
							(pageIndex - 1) * pageSize).setMaxResults(pageSize)
					.list();

			f604Response.setRowCount(Long.valueOf(rowCount.toString()));
			f604Response.setVf604s(vf604s);
		} catch (Exception e) {
			state = false;
			f604Response.setErrorMessage(e.getMessage());
		}
		f604Response.setState(state);
		return f604Response;
	}

	@Override
	public F604Response renewF604(F604 f604) {

		F604Response f604Response = new F604Response();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			StringBuffer sql = new StringBuffer(
					"select t.f604_04 from f604 t where t.f604_01 ='"
							+ f604.getF60401() + "'");
			String f60404 = (String) session.createSQLQuery(sql.toString())
					.uniqueResult();
			if (f60404 == null) {
				f604Response.setErrorMessage("不存在随访信息，不能修改!");
				state = false;
			}
		} catch (Exception e) {
			f604Response.setErrorMessage("保存失败! ");
			e.printStackTrace();
			state = false;
		}
		if (state) {
			try {

				session.update(f604);
				session.flush();
				session.refresh(f604);
				f604Response.setPromptMessage("修改成功! ");
			} catch (Exception e) {
				f604Response.setErrorMessage("保存失败! ");
				e.printStackTrace();
				state = false;
			}
		}
		f604Response.setState(state);
		return f604Response;
	}

}
