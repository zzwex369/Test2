package com.xyw.medical.fnbj.fngjada.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.junit.Test;

import com.xyw.medical.fnbj.fngjada.dao.L301Dao;
import com.xyw.medical.fnbj.fngjadj.dao.L302Dao;
import com.xyw.medical.fnbj.fnrxajc.dao.L402Dao;
import com.xyw.medical.fnbj.model.L301;
import com.xyw.medical.fnbj.model.L301Request;
import com.xyw.medical.fnbj.model.L301Response;
import com.xyw.medical.fnbj.model.L302;
import com.xyw.medical.fnbj.model.L302Request;
import com.xyw.medical.fnbj.model.L302Response;
import com.xyw.medical.fnbj.model.L402;
import com.xyw.medical.fnbj.model.L402Request;
import com.xyw.medical.fnbj.model.L402Response;
import com.xyw.medical.fnbj.model.VL301;
import com.xyw.sys.util.StringUtil;
import com.xyw.sys.util.TimeSwitch;

public class L301DaoImpl implements L301Dao {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private DataSource dataSource;

	@Resource
	private L302Dao l302Dao;

	@Resource
	private L402Dao l402Dao;

	@Override
	public L301Response delL301(L301Request l301Request) {
		L301Response l301Response = new L301Response();
		boolean state = false;
		String l30101 = l301Request.getL30101();
		try {
			if (!StringUtil.isBlankString(l30101)) {
				Session session = sessionFactory.getCurrentSession();
				L301 _l301 = (L301) session.get(L301.class, l30101);
				String l30201 = (String) session.createSQLQuery(
						"select t.l302_01 from l302 t where t.l302_02=?")
						.setParameter(0, l30101).uniqueResult();
				if (_l301 != null) {
					if (l30201 != null) {
						l301Response.setErrorMessage("宫颈癌检查信息已经登记，无法删除");
					} else {
						String l30301 = (String) session
								.createSQLQuery(
										"select t.l303_01 from l303 t where t.l303_02=?")
								.setParameter(0, l30101).uniqueResult();
						if (l30301 != null)
							l301Response.setErrorMessage("乳腺癌检查信息已经登记，无法删除");
						else {
							session.delete(_l301);
							state = true;
							l301Response.setPromptMessage("删除成功");
						}
					}
				} else {
					l301Response.setErrorMessage("不存在这条信息");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			l301Response.setErrorMessage("删除异常");
		}
		l301Response.setState(state);
		return l301Response;
	}

	@Override
	public L301Response queryL301(L301Request l301Request) {
		L301Response l301Response = new L301Response();
		String flag = l301Request.getFlag();
		int parameterPageIndex = l301Request.getParameterPageindex();
		int parameterPagesize = l301Request.getParameterPagesize();
		Date timeDate = l301Request.getTimeStr();
		Date timeEnDate = l301Request.getTimeEnd();
		L301 l301 = l301Request.getL301();
		String l30102 = l301.getL30102();
		String l30104 = l301.getL30104();
		String l30110 = l301.getL30110();
		String l30117 = l301.getL30117();
		String l30129 = l301.getL30129();
		String l30130 = l301.getL30130();
		String l30133 = l301.getL30133();
		String l30134 = l301.getL30134();
		String l30137 = l301.getL30137();// 是否宫颈癌检查
		String l30138 = l301.getL30138();// 是否乳腺癌检查

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();

		if (!StringUtil.isBlankString(l30102)) {
			parameterConditionwhere.append("and t.l301_02='" + l30102 + "'");
		}
		if (!StringUtil.isBlankString(l30104)) {
			parameterConditionwhere.append("and t.l301_04='" + l30104 + "'");
		}
		if (!StringUtil.isBlankString(l30110)) {
			parameterConditionwhere.append("and t.l301_10='" + l30110 + "'");
		}
		if (!StringUtil.isBlankString(l30133)) {// 用于宫颈检查登记
			parameterConditionwhere.append("and t.l301_35 is null ");

		}

		if (!StringUtil.isBlankString(l30134)) {// 用于乳腺检查登记
			parameterConditionwhere.append("and t.l301_36 is null ");

		}
		
		if (!StringUtil.isBlankString(l30129)) {
			parameterConditionwhere.append("and t.l301_29='" + l30129 + "'");

		}
		
		if (!StringUtil.isBlankString(l30130)) {
			parameterConditionwhere.append("and t.l301_30='" + l30130 + "'");

		}

		if (!StringUtil.isBlankString(l30133)) {
			parameterConditionwhere.append("and t.l301_33='" + l30133 + "'");

		}

		if (!StringUtil.isBlankString(l30134)) {
			parameterConditionwhere.append("and t.l301_34='" + l30134 + "'");

		}

		if (!StringUtil.isBlankString(l30137)) {
			parameterConditionwhere.append("and t.l301_35 " + l30137);

		}

		if (!StringUtil.isBlankString(l30138)) {
			parameterConditionwhere.append("and t.l301_36 " + l30138);

		}
		
		if (!StringUtil.isBlankString(l30138)) {
			parameterConditionwhere.append("and t.l301_36 " + l30138);

		}

		if (timeDate != null) {
			parameterConditionwhere.append("and t.l301_19Str >='"
					+ sdf.format(timeDate) + "'");
		}
		if (timeEnDate != null) {
			parameterConditionwhere.append("and t.l301_19Str <= '"
					+ sdf.format(timeEnDate) + "'");
		}

		if (!StringUtil.isBlankString(l30117)) {
			if (l30117.length() == 14) {
				parameterConditionwhere.append(" and t.l301_17 = '");
				parameterConditionwhere.append(l30117);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.l301_17 like '");
				parameterConditionwhere.append(l30117);
				parameterConditionwhere.append("%'");
			}
		}

		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageIndex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "v_l301");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.l301_19");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			if (rowCount == 0) {
				l301Response.setState(false);
				l301Response.setErrorMessage("暂无数据");
				return l301Response;
			}
			l301Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VL301 vl301 = null;
			List<VL301> vl301s = new ArrayList<VL301>();
			while (resultSet.next()) {
				vl301 = new VL301();
				vl301.setL30101(resultSet.getString("L301_01"));
				vl301.setL30102(resultSet.getString("L301_02"));
				vl301.setL30103(resultSet.getString("L301_03"));
				vl301.setL30104(resultSet.getString("L301_04"));
				vl301.setL30105(resultSet.getDate("L301_05"));
				vl301.setL30106(resultSet.getShort("L301_06"));
				vl301.setL30107(resultSet.getString("L301_07"));
				vl301.setL30108(resultSet.getString("L301_08"));
				vl301.setL30109(resultSet.getString("L301_09"));
				vl301.setL30110(resultSet.getString("L301_10"));
				vl301.setL30111(resultSet.getString("L301_11"));
				vl301.setL30112(resultSet.getString("L301_12"));
				vl301.setL30113(resultSet.getString("L301_13"));
				vl301.setL30114(resultSet.getString("L301_14"));
				vl301.setL30115(resultSet.getString("L301_15"));
				vl301.setL30116(resultSet.getString("L301_16"));
				vl301.setL30117(resultSet.getString("L301_17"));
				vl301.setL30118(resultSet.getString("L301_18"));
				vl301.setL30119(resultSet.getDate("L301_19"));
				vl301.setL30120(resultSet.getString("L301_20"));
				vl301.setL30121(resultSet.getDate("L301_21"));
				vl301.setL30122(resultSet.getString("L301_22"));
				vl301.setL30124(resultSet.getString("L301_24"));
				vl301.setL30125(resultSet.getString("L301_25"));
				vl301.setL30126(resultSet.getString("L301_26"));
				vl301.setL30127(resultSet.getString("L301_27"));
				vl301.setL30128(resultSet.getString("L301_28"));
				vl301.setL30129(resultSet.getString("L301_29"));
				vl301.setL30130(resultSet.getString("L301_30"));
				vl301.setL30131(resultSet.getString("L301_31"));
				vl301.setL30132(resultSet.getString("L301_32"));
				vl301.setL30133(resultSet.getString("L301_33"));
				vl301.setL30134(resultSet.getString("L301_34"));
				vl301.setL30135(resultSet.getDate("L301_35"));
				vl301.setL30136(resultSet.getDate("L301_36"));
				vl301.setL30103zh(resultSet.getString("L301_03Zh"));
				vl301.setL30107zh(resultSet.getString("L301_07Zh"));
				vl301.setL30108zh(resultSet.getString("L301_08Zh"));
				vl301.setL30109zh(resultSet.getString("L301_09Zh"));
				vl301.setL30111zh(resultSet.getString("L301_11Zh"));
				vl301.setL30113zh(resultSet.getString("L301_13Zh"));
				vl301.setL30117zh(resultSet.getString("L301_17Zh"));
				vl301.setL30105str(resultSet.getString("L301_05Str"));
				vl301.setL30119str(resultSet.getString("L301_19Str"));
				vl301s.add(vl301);
			}
			l301Response.setState(true);
			l301Response.setPromptMessage("查询成功");
			l301Response.setVl301s(vl301s);

		} catch (Exception e) {
			e.getStackTrace();
			l301Response.setState(false);
			l301Response.setErrorMessage("查询失败");
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
					callableStatement = null;
				}
				if (connection != null) {
					connection.close();
					connection = null;
				}
			} catch (Exception e) {

			}
		}
		return l301Response;
	}

	@Override
	public L301Response renewL301(L301Request l301Request) {
		L301Response l301Response = new L301Response();
		L301 l301 = l301Request.getL301();
		try {
			if (l301 != null) {
				Session session = sessionFactory.getCurrentSession();
				session.saveOrUpdate(l301);
				l301Response.setState(true);
				l301Response.setPromptMessage("更新成功");
				return l301Response;
			}
			l301Response.setState(false);
			l301Response.setPromptMessage("对象为空");
		} catch (Exception e) {
			e.printStackTrace();
			l301Response.setState(false);
			l301Response.setErrorMessage("更新异常");
		}
		return l301Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public L301Response saveL301(L301Request l301Request) {
		boolean status = true;
		L301Response l301Response = new L301Response();
		L301Response _l301Response = null;
		L301 l301 = l301Request.getL301();
		String l30104 = l301.getL30104();
		try {
			if (l30104 != null) {
				Session session = sessionFactory.getCurrentSession();
				Object[] l301Fields = (Object[]) session
						.createSQLQuery(
								"select max(t.l301_19),max(t.l301_24) from l301 t where t.l301_04=?")
								.setString(0, l30104).uniqueResult();

				if (l301Fields[0]!= null) {
					Date l30119 = (Date) l301Fields[0];
					String monthStr = (String) session.createSQLQuery(
							"select c101_02 from C101 where c101_01='1'")
							.uniqueResult();
					int month = TimeSwitch.getMonthSpace(l30119, new Date());
					if (month < Integer.parseInt(monthStr)) {
						status = false;
						l301Response.setErrorMessage("该信息已经被" + l301Fields[1]
								+ "于"
								+ new DateTime(l30119).toString("yyyy-MM-dd")
								+ "登记过档案！信息登记未超过五年");
					}
				}
				if (status) {
					_l301Response = SetCode(l301.getL30113(), session);
					L301 _301 = _l301Response.getL301();
					l301.setL30114(_301.getL30114());
					l301.setL30115(_301.getL30115());
					l301.setL30116(_301.getL30116());
					session.save(l301);
					session.flush();
					session.refresh(l301);
					l301Response.setL30101(l301.getL30101());
					l301Response.setPromptMessage("保存成功");
				}
			} else {
				status = false;
				l301Response.setErrorMessage("证件号不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
			l301Response.setErrorMessage("保存异常");
		}
		l301Response.setState(status);
		return l301Response;
	}

	/* 制作档案编码 */
	private L301Response SetCode(String d20101, Session session) {
		int i = 0;
		L301 l301 = new L301();
		L301Response l301Response = new L301Response();
		l301Response.setState(false);
		try {
			if (d20101 != null) {
				String d20106 = (String) session.createSQLQuery(
						"select t.d201_06 from d201_ms t where t.d201_01=?")
						.setString(0, d20101).uniqueResult();
				if (d20106 != null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
					String year = sdf.format(new Date());
					String maxL30115 = (String) session
							.createSQLQuery(
									"select max(t.l301_15) from L301 t where t.l301_14 = ? and  substr(t.l301_16,1,4)=?")
							.setString(0, d20106).setString(1, year)
							.uniqueResult();
					maxL30115 = maxL30115 != null ? maxL30115 : "0";
					i = Integer.parseInt(maxL30115) + 1;
					String str_m = String.valueOf(i);
					String str = "00000";
					str_m = str.substring(0, 5 - str_m.length()) + str_m;
					String l30116 = year + d20106 + str_m;
					l301.setL30114(d20106);
					l301.setL30115(str_m);
					l301.setL30116(l30116);
					l301Response.setL301(l301);
					l301Response.setState(true);
					l301Response.setPromptMessage("保存档案编码成功");
				} else
					l301Response.setErrorMessage("无法得到地区编码");
			} else
				l301Response.setErrorMessage("地址为空");
		} catch (Exception e) {
			e.printStackTrace();
			l301Response.setState(false);
			l301Response.setErrorMessage("档案编码异常");
		}
		return l301Response;
	}

	@Override
	public L301Response finishCaseL301(L301 l301) {
		boolean state = true;
		String l30101 = l301.getL30101();// 档案主键
		Date l30136 = l301.getL30136();// 日期
		String l30137 = l301.getL30137();// 单位
		String l30138 = l301.getL30138();// 结案对象
		String l30139 = l301.getL30139();// 宫颈原因
		String l30140 = l301.getL30140();// 乳腺原因
		L302Response l302Response = null;
		L402Response l402Response = null;
		StringBuffer message = new StringBuffer();
		L301Response l301Response = new L301Response();
		Session session = sessionFactory.getCurrentSession();
		try {
			String[] types = l30138.split(",");
			L301 _L301 = (L301) session.get(L301.class, l30101);
			if (_L301 != null) {

				for (String type : types) {
					if ("gj".equals(type)) {
						L302 l302 = new L302();
						l302.setL30202(l30101);
						l302.setL302131(l30136);
						l302.setL302132(l30137);
						l302.setL302133(l30139);
						L302Request l302Request = new L302Request();
						l302Request.setFlag("99");
						l302Request.setL302(l302);
						l302Response = l302Dao.saveL302(l302Request);
						if (l302Response.isState()) {
							_L301.setL30135(l30136);
							message.append("宫颈癌结案成功,");
						} else
							message.append("宫颈癌结案失败,");
					} else if ("rx".equals(type)) {
						L402 l402 = new L402();
						l402.setL40202(l30101);
						l402.setL402147(l30136);
						l402.setL402148(l30137);
						l402.setL402149(l30140);
						L402Request l402Request = new L402Request();
						l402Request.setFlag("99");
						l402Request.setL402(l402);
						l402Response = l402Dao.saveL402(l402Request);
						if (l402Response.isState()) {
							_L301.setL30136(l30136);
							message.append("乳腺癌结案成功!");
						} else
							message.append("乳腺癌结案失败!");
					}
				}
				session.update(_L301);
				session.flush();
				l301Response.setPromptMessage(message.toString());
			} else {
				state = false;
				l301Response.setErrorMessage("不存在档案，无法结案！。请联系客服！");
			}

		} catch (Exception e) {
			state = false;
			l301Response.setErrorMessage(e.getMessage());
		}
		l301Response.setState(state);
		return l301Response;
	}

	@Test
	public void name() {
		Date nowDate = new Date();
		Date maxDate = new Date();
		maxDate.setYear(nowDate.getYear() + 5);
		System.out.println(maxDate);
	}
}
