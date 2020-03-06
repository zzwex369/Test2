package com.xyw.medical.etbj.etsl.etsljc.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import oracle.sql.SQLUtil;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xyw.medical.etbj.etsl.etsljc.dao.E702Dao;
import com.xyw.medical.etbj.etsl.model.E701;
import com.xyw.medical.etbj.etsl.model.E702;
import com.xyw.medical.etbj.etsl.model.E702Request;
import com.xyw.medical.etbj.etsl.model.E702Response;
import com.xyw.medical.etbj.etsl.model.E703;
import com.xyw.medical.etbj.etsl.model.VE702;
import com.xyw.sys.util.ExceptionCollection;
import com.xyw.sys.util.SqlUtil;
import com.xyw.sys.util.StringUtil;

@Repository("e702Dao")
@Scope("prototype")
public class E702DaoImpl implements E702Dao {
	@Resource
	private SessionFactory sessionFactory;

	private String[][] resultList = { { "2", "1", "0" }, { "4", "4", "3" } };// 标志结果集
	private static final String[] e70208 = { "0", "1", "3", "6", "8", "12",
			"14", "16", "18", "20", "24", "28", "32" };// 月龄

	/**
	 * 为档案中的检查标志赋值
	 *  
	 * @param session
	 * @param flag
	 *            月龄下标
	 * @param method
	 *            0 修改 1 添加 2 删除 转诊需要用 添加 标志
	 * @param e702
	 */
	private void setE70134(Session session, String flag, String method,
			E702 e702, String... arg) {
		E701 e701 = (E701) session.get(E701.class, e702.getE70202());
		String[] e70134Arr = e701.getE70134().split(",");

		if ("0".equals(method) && !e702.getE70208().equals(arg[0])) {// 验证修改状态下
			// 更新档案检查标志
			int oldX = getFlag(arg[0]);
			e70134Arr[oldX] = "0";
		}

		String result = setCheckType(e70134Arr, flag,
				"2".equals(method) ? method : "1", e702.getE70209(), e702
						.getE70260());
		if (result != null) {
			e701.setE70134(result);
			session.update(e701);
		}
		if ("1".equals(method) && "2".equals(e702.getE70209()))
			setE70325(session, e702);
	}

	private void setE70325(Session session, E702 e702) {
		E703 e703 = (E703) session.createSQLQuery(
				"select * from e703 where e703_03=?").addEntity(E703.class)
				.setParameter(0, e702.getE70203()).uniqueResult();
		e703.setE70325("1");
		session.update(e703);
	}

	private int getFlag(String target) {
		int flag = 0;
		for (int i = 0; i < e70208.length; i++) {
			if (e70208[i].equals(target)) {
				flag = i;
				break;
			}
		}
		return flag;
	}

	/**
	 * 检查是否需要更新检查标志
	 * 
	 * @param e70134
	 *            月龄检查标志
	 * @param idx
	 *            月龄下标
	 * @param method
	 *            0 修改 1 添加 2 删除
	 * @param checkType
	 *            1 初筛 2 转诊
	 * @param resultStr
	 *            2 异常 3 无异常
	 * @return null 或者 字符串
	 */

	private String setCheckType(String[] e70134Arr, String idx, String method,
			String checkType, String resultStr) {
		String val = e70134Arr[Integer.parseInt(idx)];
		int result = "1".equals(method) ? Integer.parseInt(resultStr) : -1;
		String[] resultVal = resultList[Integer.parseInt(checkType) - 1];// {"1","2","0"}
		if (val.equals(resultVal[result != -1 ? result - 2 : 2]))// 是否一致 返回null
			return null;
		e70134Arr[Integer.parseInt(idx)] = resultVal[result != -1 ? result - 2
				: 2];// 覆盖原标志
		return StringUtils.join(e70134Arr, ",");
	}

	@SuppressWarnings("unchecked")
	@Override
	public E702Response saveE702(E702Request e702Request) {
		E702Response e702Response = new E702Response();
		E702 e702 = e702Request.getE702();
		String e70202 = e702.getE70202();
		String e70207 = e702.getE70207();
		String e70208 = e702.getE70208();
		String e70209 = e702.getE70209();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			if ("1".equals(e70209)) {
				Object[] e702Fields = (Object[]) session.createSQLQuery(
						"select e702_73,e702_71zh from v_e702 t where " +
						"e702_02 ='"+ e70202 + "' and e702_07 ='"+ e70207 + "'" +
						" and e702_08='" + e70208 + "' and e702_09='1'").uniqueResult();
				if (e702Fields != null && e702Fields[0] != null) {
					Date e70242 = (Date) e702Fields[0];
					state = false;
					e702Response.setErrorMessage("该信息已经被" + e702Fields[1] + "于"
							+ new DateTime(e70242).toString("yyyy-MM-dd")
							+ "登记过档案！不能重复登记相同的月龄信息");
				}
			}

		} catch (Exception e) {
			e702Response.setErrorMessage("保存失败! ");
			ExceptionCollection.saveD403(e, e702.getE70271(), "E702", e702
					.getE70201(), session);
			state = false;
		}
		if (state) {
			try {
				session.save(e702);
				// session.flush();
				// session.refresh(e702);
				e702Response.setE702(e702);
				e702Response.setPromptMessage("保存成功! ");
				setE70134(session, e702Request.getFlag(), "1", e702);
			} catch (Exception e) {
				e702Response.setErrorMessage("保存失败! ");
				ExceptionCollection.saveD403(e, e702.getE70241(), "E702", e702
						.getE70201(), session);
				state = false;
			}
		}
		e702Response.setState(state);
		return e702Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E702Response renewE702(E702Request e702Request) {
		E702 e702 = e702Request.getE702();
		E702Response e702Response = new E702Response();
		boolean state = true;
		String oldE70208 = null;
		String newE70208 = e702.getE70208();
		Session session = sessionFactory.getCurrentSession();
		try {

			oldE70208 = (String) session.createSQLQuery(
					"select e702_08 from e702 where e702_01=?").setParameter(0,
					e702.getE70201()).uniqueResult();
			if (StringUtil.isBlankString(oldE70208)) {
				e702Response.setErrorMessage("该信息不存在，不能修改!");
				state = false;
			}
		} catch (Exception e) {
			e702Response.setErrorMessage("保存失败! ");
			ExceptionCollection.saveD403(e, e702.getE70241(), "E702", e702
					.getE70201(), session);
			state = false;
		}
		if (state) {
			try {
				// 当修改月龄检查
				if (!oldE70208.equals(newE70208)) {
					// 验证是否存在相同月龄信息
					int size = session.createSQLQuery(
									"select e702_01 from e702 where e702_02=? and e702_08=? and e702_09=?")
							.setParameter(0, e702.getE70202()).setParameter(1,
									newE70208)
							.setParameter(2, e702.getE70209()).list().size();
					if (size > 0) {
						e702Response.setState(false);
						e702Response.setErrorMessage("存在相同的月龄信息，不能修改! ");
						return e702Response;
					}
				}

				session.clear();
				session.update(e702);
				session.flush();
				session.refresh(e702);
				e702Response.setPromptMessage("修改成功! ");
				setE70134(session, e702Request.getFlag(), "0", e702, oldE70208);
			} catch (Exception e) {
				e702Response.setErrorMessage("保存失败! ");
				ExceptionCollection.saveD403(e, e702.getE70241(), "E702", e702
						.getE70201(), session);
				state = false;
			}
		}
		e702Response.setState(state);
		return e702Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E702Response queryE702(E702Request e702Request) {
		E702Response e702Response = new E702Response();
		E702 e702 = e702Request.getE702();
		String institution = e702Request.getInstitution();
		String idCard = e702Request.getParent_idcard();
		String name = e702Request.getParent_name();
		String phone = e702Request.getParent_phone();
		String e70202 = e702.getE70202();
		String e70203 = e702.getE70203();
		String e70204 = e702.getE70204();
		String e70205 = e702.getE70205();
		String e70207 = e702.getE70207();
		String e70208 = e702.getE70208();
		String e70209 = e702.getE70209();
		String e70260 = e702.getE70260();
		String e70261 = e702.getE70261();
		int codeLength = e702Request.getCodeLength();
		String suffixSql = e702Request.getSuffixSql();
		Date timeStr = e702Request.getTimeStr();
		Date timeEnd = e702Request.getTimeEnd();
		Map<String, Object> fieldMap = e702Request.getFieldMap();
		String codeField = fieldMap.get("codeField").toString();
		int pageIndex = e702Request.getParameterPageindex();
		int pageSize = e702Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sb = new StringBuffer();
		if (!StringUtil.isBlankString(e70202)) {
			sb.append("and t.e702_02 ='" + e70202 + "' ");
		}

		if (!StringUtil.isBlankString(e70203)) {
			sb.append("and t.e702_03 ='" + e70203 + "' ");
		}
		if (!StringUtil.isBlankString(e70204)) {
			sb.append("and t.e702_04 ='" + e70204 + "' ");
		}
		if (!StringUtil.isBlankString(e70205)) {
			sb.append("and t.e702_05 ='" + e70205 + "' ");
		}
		if (!StringUtil.isBlankString(e70207)) {
			sb.append("and t.e702_07 ='" + e70207 + "' ");
		}
		if (!StringUtil.isBlankString(e70208)) {
			sb.append("and t.e702_08 ='" + e70208 + "' ");
		}
		if (!StringUtil.isBlankString(e70209)) {
			sb.append("and t.e702_09 ='" + e70209 + "' ");
		}
		if (!StringUtil.isBlankString(e70260)) {
			sb.append("and t.e702_60 ='" + e70260 + "' ");
		}
		if (!StringUtil.isBlankString(e70261)) {
			sb.append("and t.e702_61 ='" + e70261 + "' ");
		}
		if (!StringUtil.isBlankString(name)
				|| !StringUtil.isBlankString(idCard)
				|| !StringUtil.isBlankString(phone)) {
			sb.append("and( t.e701_17 ='" + name + "'" + " or t.e701_21 ='"
					+ name + "'" + " or t.e701_19 ='" + idCard + "'"
					+ " or t.e701_23 ='" + idCard + "'" + " or t.e701_20 ='"
					+ phone + "'" + " or t.e701_30 ='" + phone + "'" + " )");
		}

		if (!StringUtil.isBlankString(suffixSql))
			sb.append(suffixSql);

		if (timeStr != null) {
			String dateField = fieldMap.get("dateField").toString();
			sb.append(" and to_char(" + dateField + ",'yyyy-mm-dd') >= '"
					+ sdf.format(timeStr) + "'");

			sb.append(" and to_char(" + dateField + ",'yyyy-mm-dd') <= '"
					+ sdf.format(timeEnd) + "'");
		}

		if (!StringUtil.isBlankString(institution)) {

			if (institution.length() == codeLength) {
				sb.append(" and " + codeField + " = '");
				sb.append(institution);
				sb.append("'");
			} else {
				sb.append(" and " + codeField + " like '");
				sb.append(institution);
				sb.append("%'");
			}
		}
		Session session = sessionFactory.getCurrentSession();

		StringBuffer sql = new StringBuffer(" from v_e702_q t where  1=1 " );
		sql.append(sb.toString());
		try {
			Object rowCount = session.createSQLQuery("select count(*)" + sql)
					.uniqueResult();

			sql.append(" order by e702_73").toString();
			sql.insert(0, "select *");
			String fullSql=	SqlUtil.Querybetch(sql.toString(), pageSize, pageIndex);
			List<VE702> ve702s = (List<VE702>) session.createSQLQuery(
					fullSql).addEntity(VE702.class).list();

			e702Response.setRowCount(Long.valueOf(rowCount.toString()));
			e702Response.setVe702s(ve702s);
		} catch (Exception e) {
			e.printStackTrace();
			e702Response.setErrorMessage("查询失败! ");
			ExceptionCollection.saveD403(e, null, "E702", sql.toString(), session);
		}
		return e702Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E702Response deleteE702(E702Request e702Request) {
		E702Response e702Response = new E702Response();
		boolean state = true;
		E702 e702 = null;
		String e70301 = null;
		boolean isRecheck = false;
		String e70201 = e702Request.getE70201();
		Session session = sessionFactory.getCurrentSession();
		try {
			e702 = (E702) session.get(E702.class, e70201);
			if (e702 == null) {
				e702Response.setErrorMessage("该信息不存在，不能删除!");
				state = false;
			} else {
				isRecheck = "2".equals(e702.getE70209());
				e70301 = (String) session.createSQLQuery(
						"select e703_01 from e703 where e703_03=?")
						.setParameter(0, isRecheck ? e702.getE70203() : e70201)
						.uniqueResult();
				if (!StringUtil.isBlankString(e70301) && !isRecheck) {
					state = false;
					e702Response.setErrorMessage("已存在转诊信息，无法删除 ");
				}
			}

		} catch (Exception e) {
			e702Response.setErrorMessage("删除失败! ");
			ExceptionCollection.saveD403(e, null, "E702", e70201, session);
			state = false;
		}
		if (state) {
			try {
				if (isRecheck) {
					E703 e703 = (E703) session.get(E703.class, e70301);
					e703.setE70325("2");
					session.update(e703);
				}
				session.delete(e702);
				setE70134(session, Integer.toString(getFlag(e702.getE70208())),
						"2", e702);
			} catch (Exception e) {
				e702Response.setErrorMessage("删除失败! ");
				ExceptionCollection.saveD403(e, null, "E702", e70201, session);
				state = false;
			}
		}
		e702Response.setState(state);
		return e702Response;
	}

	@Override
	public E702Response getE702(String e70201) {
		E702Response e702Response = new E702Response();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		if (state) {
			try {
				E702 e702 = (E702) session.get(E702.class, e70201);
				e702Response.setE702(e702);
			} catch (Exception e) {
				// e702Response.setErrorMessage("删除失败! ");
				ExceptionCollection
						.saveD403(e, e70201, "E702", e70201, session);
				state = false;
			}
		}
		e702Response.setState(state);
		return e702Response;
	}

}
