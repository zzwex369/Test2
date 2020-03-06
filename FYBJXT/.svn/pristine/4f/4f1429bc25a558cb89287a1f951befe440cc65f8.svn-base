package com.xyw.medical.fnbj.fnbjcssf.dao.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.fnbjcssf.dao.F503Dao;
import com.xyw.medical.fnbj.model.F501;
import com.xyw.medical.fnbj.model.F503;
import com.xyw.medical.fnbj.model.F503Request;
import com.xyw.medical.fnbj.model.F503Response;
import com.xyw.medical.fnbj.model.VF503;
import com.xyw.sys.util.StringUtil;

public class F503DaoImpl implements F503Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public F503Response saveF503(F503 f503) {

		Boolean flag = false;
		F503Response f503Response = new F503Response();
		Session session = sessionFactory.getCurrentSession();
		try {
			if (f503 != null) {
				String f50302 = f503.getF50302();
				String f50303 = f503.getF50303();
				String f50304 = f503.getF50304();
				String f50301 = (String) session
						.createSQLQuery(
								"select t.f503_01 from f503 t where t.f503_03=? and t.f503_04=? and t.f503_05=? ")
						.setString(0, f50303).setString(1, f50304).setString(2,
								f503.getF50305()).uniqueResult();
				if (!StringUtil.isBlankString(f50301)) {
					f503Response.setErrorMessage("保存重复，请联系客服！");
				} else {
					if (StringUtil.isBlankString(f50302)) {// 无档案
						String f50101 = (String) session
								.createSQLQuery(
										"select t.f501_01 from f501 t where t.f501_03=? and t.f501_05=? ")
								.setString(0, f50303).setString(1, f50304)
								.uniqueResult();
						if (f50101 != null)
							f503Response.setErrorMessage("该信息存在档案！，请联系客服！");
						else
							flag = true;
					} else {
						F501 f501 = (F501) session.get(F501.class, f50302);
						if (f501 != null) {
							flag = true;
							f501.setF50152("1");
							session.update(f501);
							f503Response.setPromptMessage("保存成功");
						} else {
							f503Response.setErrorMessage("档案不存在，请联系客服！");
						}
					}
					if (flag) {
						session.save(f503);
						f503Response.setPromptMessage("保存成功");
					}
				}
			}

		} catch (Exception e) {
			flag = false;
			f503Response.setErrorMessage(e.getMessage());
		}
		f503Response.setState(flag);
		return f503Response;
	}

	@Override
	public F503Response deleteF503(F503Request f503Request) throws Exception {
		F503Response f503Response = new F503Response();
		String d50301 = f503Request.getF50301();
		Object[] paramsArr = null;
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			StringBuffer sql = new StringBuffer(
					"select t.f503_02,t.f503_04 from f503 t where t.f503_01 ='"
							+ d50301 + "'");
			paramsArr = (Object[]) session.createSQLQuery(sql.toString())
					.uniqueResult();
			if (paramsArr.length < 1) {
				f503Response.setErrorMessage("不存在随访信息，不能删除!");
				state = false;
			}
		} catch (Exception e) {
			f503Response.setErrorMessage("删除失败! ");
			e.printStackTrace();
			state = false;
		}
		if (state) {
			F503 f503 = new F503();
			f503.setF50301(d50301);
			session.delete(f503);
			if (paramsArr[0] != null) {
				F501 f501 = (F501) session.get(F501.class, paramsArr[0]
						.toString());
				if (f501 != null) {
					f501.setF50152("2");
					session.update(f501);

				} else
					throw new RuntimeException("删除失败!档案不存在请联系客服！ ");
			}
			f503Response.setPromptMessage("删除成功！");

		}
		f503Response.setState(state);
		return f503Response;
	}

	@Override
	public F503Response queryF503(F503Request f503Request) {
		String field = null;
		F503Response f503Response = new F503Response();
		F503 f503 = f503Request.getF503();
		String f50303 = f503.getF50303();
		String f50304 = f503.getF50304();
		String f50305 = f503.getF50305();
		String f50331 = f503.getF50331();
		String f50332 = f503.getF50332();
		HashMap<String, Object> paramHashMap = f503Request.getParamMap();

		int pageIndex = f503Request.getParameterPageindex();
		int pageSize = f503Request.getParameterPagesize();
		StringBuffer parameterConditionwhere = new StringBuffer();

		if (!StringUtil.isBlankString(f50303)) {
			parameterConditionwhere.append("and t.f503_03 ='" + f50303 + "' ");
		}
		if (!StringUtil.isBlankString(f50304)) {
			parameterConditionwhere.append("and t.f503_04 ='" + f50304 + "' ");
		}
		if (!StringUtil.isBlankString(f50305)) {
			parameterConditionwhere.append("and t.f503_05 ='" + f50305 + "' ");
		}

		if (!StringUtil.isBlankString(f50331)) {
			parameterConditionwhere.append("and t.f503_31 ='" + f50331 + "' ");
		}

		if (!StringUtil.isBlankString(f50332)) {
			parameterConditionwhere.append("and t.f503_32 ='" + f50332 + "' ");
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
					"select count(*) from v_f503 t where 1=1 "
							+ parameterConditionwhere.toString())
					.uniqueResult();
			List<VF503> vf503s = (List<VF503>) session.createSQLQuery(
					"select * from v_f503  t where 1=1 "
							+ parameterConditionwhere.append(
									"order by f503_37,f503_01").toString())
					.addEntity(VF503.class).setFirstResult(
							(pageIndex - 1) * pageSize).setMaxResults(pageSize)
					.list();

			f503Response.setRowCount(Long.valueOf(rowCount.toString()));
			f503Response.setVf503s(vf503s);
		} catch (Exception e) {
			e.printStackTrace();
			state = false;
			f503Response.setErrorMessage(e.getMessage());
		}
		f503Response.setState(state);
		return f503Response;
	}

	@Override
	public F503Response renewF503(F503 f503) {
		F503Response f503Response = new F503Response();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			StringBuffer sql = new StringBuffer(
					"select t.f503_03 from f503 t where t.f503_01 ='"
							+ f503.getF50301() + "'");
			String f50303 = (String) session.createSQLQuery(sql.toString())
					.uniqueResult();
			if (f50303 == null) {
				f503Response.setErrorMessage("不存在随访信息，不能修改!");
				state = false;
			}
		} catch (Exception e) {
			f503Response.setErrorMessage("保存失败! ");
			e.printStackTrace();
			state = false;
		}
		if (state) {
			try {

				session.update(f503);
				session.flush();
				session.refresh(f503);
				f503Response.setPromptMessage("修改成功! ");
			} catch (Exception e) {
				f503Response.setErrorMessage("保存失败! ");
				e.printStackTrace();
				state = false;
			}
		}
		f503Response.setState(state);
		return f503Response;
	}

}
