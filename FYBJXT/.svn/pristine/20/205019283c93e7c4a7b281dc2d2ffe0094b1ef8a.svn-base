package com.xyw.medical.etbj.etlbsc.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;

import com.xyw.medical.etbj.etlbsc.dao.E601Dao;
import com.xyw.medical.etbj.model.E601;
import com.xyw.medical.etbj.model.E601Request;
import com.xyw.medical.etbj.model.E601Response;
import com.xyw.medical.etbj.model.VE601;
import com.xyw.sys.util.MsCountryCode;
import com.xyw.sys.util.StringUtil;
import com.xyw.sys.util.TimeSwitch;

public class E601DaoImpl implements E601Dao {
	@Resource
	private DataSource dataSource;
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public E601Response deleteE601(E601 e601) {
		E601Response e601Response = new E601Response();
		e601Response.setState(false);
		try {
			if (e601.getE60101() != null) {
				Session session = sessionFactory.getCurrentSession();
				E601 _e601 = (E601) session.get(E601.class, e601.getE60101());
				if (_e601 != null) {
					session.delete(_e601);
					e601Response.setState(true);
					e601Response.setPromptMessage("删除成功");
					return e601Response;
				}
			}
			e601Response.setErrorMessage("删除失败");
		} catch (Exception e) {
			e601Response.setState(false);
			e601Response.setErrorMessage("删除异常");
		}
		return e601Response;
	}

	@Override
	public E601Response queryE601(E601Request e601Request) {
		E601Response e601Response = new E601Response();
		E601 e601 = e601Request.getE601();
		String e60103 = e601.getE60103();
		String e60104 = e601.getE60104();
		String e60109 = e601.getE60109();
		String e60116 = e601.getE60116();
		String e60136 = e601.getE60136();
		String e60147 = e601.getE60147();
		String e60157 = e601.getE60157();
		String e60159 = e601.getE60159();
		String dateField = e601Request.getDateField();
		Date timeStart = e601Request.getTimeStr();
		Date timeEnd = e601Request.getTimeEnd();
		int parameterPageindex = e601Request.getParameterPageindex();
		int parameterPagesize = e601Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		if (!StringUtil.isBlankString(e60103)) {
			parameterConditionwhere.append("and t.e601_03='" + e60103 + "'");
		}
		if (!StringUtil.isBlankString(e60104)) {
			parameterConditionwhere.append("and t.e601_04='" + e60104 + "'");
		}
		if (!StringUtil.isBlankString(e60109)) {
			parameterConditionwhere.append("and t.e601_09='" + e60109 + "'");
		}
		if (!StringUtil.isBlankString(e60116)) {
			parameterConditionwhere.append("and t.e601_16='" + e60116 + "'");
		}
		if (!StringUtil.isBlankString(e60136)) {
			parameterConditionwhere.append("and t.e601_36='" + e60136 + "'");
		}

		if (!StringUtil.isBlankString(e60157)) {
			parameterConditionwhere.append("and t.e601_57='" + e60157 + "'");
		}

		if (!StringUtil.isBlankString(e60159)) {
			parameterConditionwhere.append("and t.e601_59='" + e60159 + "'");
		}

		if (timeStart != null) {
			parameterConditionwhere
					.append("and to_char("+dateField+",'yyyy-mm-dd') >='"
							+ sdf.format(timeStart) + "'");
		}
		if (timeEnd != null) {
			parameterConditionwhere
					.append("and to_char("+dateField+",'yyyy-mm-dd') <= '"
							+ sdf.format(timeEnd) + "'");
		}

		if (!StringUtil.isBlankString(e60147)) {
			if (e60147.length() == 14) {
				parameterConditionwhere.append(" and t.e601_47 = '");
				parameterConditionwhere.append(e60147);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.e601_47 like '");
				parameterConditionwhere.append(e60147);
				parameterConditionwhere.append("%'");
			}
		}
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_E601");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.e601_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			e601Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VE601 ve601 = null;
			List<VE601> ve601s = new ArrayList<VE601>();

			while (resultSet.next()) {
				ve601 = new VE601();
				ve601.setE60101(resultSet.getString("E601_01"));
				ve601.setE60102(resultSet.getLong("E601_02"));
				ve601.setE60103(resultSet.getString("E601_03"));
				ve601.setE60104(resultSet.getString("E601_04"));
				ve601.setE60105(resultSet.getDate("E601_05"));
				ve601.setE60106(resultSet.getString("E601_06"));
				ve601.setE60107(resultSet.getString("E601_07"));
				ve601.setE60108(resultSet.getString("E601_08"));
				ve601.setE60109(resultSet.getString("E601_09"));
				ve601.setE60110(resultSet.getString("E601_10"));
				ve601.setE60111(resultSet.getString("E601_11"));
				ve601.setE60112(resultSet.getByte("E601_12"));
				ve601.setE60113(resultSet.getByte("E601_13"));
				ve601.setE60114(resultSet.getString("E601_14"));
				ve601.setE60115(resultSet.getString("E601_15"));
				ve601.setE60116(resultSet.getString("E601_16"));
				ve601.setE60117(resultSet.getString("E601_17"));
				ve601.setE60118(resultSet.getDate("E601_18"));
				ve601.setE60119(resultSet.getString("E601_19"));
				ve601.setE60120(resultSet.getString("E601_20"));
				ve601.setE60121(resultSet.getString("E601_21"));
				ve601.setE60122(resultSet.getString("E601_22"));
				ve601.setE60123(resultSet.getString("E601_23"));
				ve601.setE60124(resultSet.getString("E601_24"));
				ve601.setE60125(resultSet.getString("E601_25"));
				ve601.setE60126(resultSet.getDate("E601_26"));
				ve601.setE60127(resultSet.getString("E601_27"));
				ve601.setE60128(resultSet.getString("E601_28"));
				ve601.setE60129(resultSet.getString("E601_29"));
				ve601.setE60130(resultSet.getString("E601_30"));
				ve601.setE60131(resultSet.getString("E601_31"));
				ve601.setE60132(resultSet.getString("E601_32"));
				ve601.setE60133(resultSet.getString("E601_33"));
				ve601.setE60134(resultSet.getDate("E601_34"));
				ve601.setE60135(resultSet.getDate("E601_35"));
				ve601.setE60136(resultSet.getString("E601_36"));
				ve601.setE60137(resultSet.getDate("E601_37"));
				ve601.setE60138(resultSet.getString("E601_38"));
				ve601.setE60139(resultSet.getDate("E601_39"));
				ve601.setE60140(resultSet.getString("E601_40"));
				ve601.setE60141(resultSet.getString("E601_41"));
				ve601.setE60142(resultSet.getString("E601_42"));
				ve601.setE60143(resultSet.getString("E601_43"));
				ve601.setE60144(resultSet.getString("E601_44"));
				ve601.setE60145(resultSet.getDate("E601_45"));
				ve601.setE60146(resultSet.getString("E601_46"));
				ve601.setE60147(resultSet.getString("E601_47"));
				ve601.setE60148(resultSet.getString("E601_48"));
				ve601.setE60149(resultSet.getString("E601_49"));
				ve601.setE60150(resultSet.getString("E601_50"));
				ve601.setE60151(resultSet.getString("E601_51"));
				ve601.setE60152(resultSet.getString("E601_52"));
				ve601.setE60153(resultSet.getString("E601_53"));
				ve601.setE60157(resultSet.getString("E601_57"));
				ve601.setE60159(resultSet.getString("E601_59"));
				ve601.setE60169(resultSet.getString("E601_69"));

				ve601.setE60136Zh(resultSet.getString("E601_36_ZH"));
				ve601.setE60140Zh(resultSet.getString("E601_40_ZH"));
				ve601.setE60147Zh(resultSet.getString("E601_47_ZH"));
				ve601.setE60105Str(resultSet.getString("E601_05Str"));
				ve601.setE60118Str(resultSet.getString("E601_18Str"));
				ve601.setE60126Str(resultSet.getString("E601_26Str"));
				ve601.setE60134Str(resultSet.getString("E601_34Str"));
				ve601.setE60135Str(resultSet.getString("E601_35Str"));
				ve601.setE60137Str(resultSet.getString("E601_37Str"));
				ve601.setE60139Str(resultSet.getString("E601_39Str"));
				ve601.setE60145Str(resultSet.getString("E601_45Str"));
				ve601.setE60150(resultSet.getString("E601_50"));
				ve601.setE60151(resultSet.getString("E601_51"));
				ve601.setE60152(resultSet.getString("E601_52"));
				ve601.setE60153(resultSet.getString("E601_53"));

				ve601s.add(ve601);
			}
			e601Response.setState(true);
			e601Response.setPromptMessage("查询成功");
			e601Response.setVe601s(ve601s);
		} catch (Exception e) {
			e601Response.setState(false);
			e601Response.setErrorMessage("查询失败");
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return e601Response;
	}

	@Override
	public E601Response renewE601(E601 e601) {
		E601Response e601Response = new E601Response();
		Session session = sessionFactory.getCurrentSession();
		try {
			if (e601 != null) {
				E601 _e601 = (E601) session.get(E601.class, e601.getE60101());
				if (_e601 != null) {
					String[] code = MsCountryCode.setCountryCode(e601
							.getE60108(), e601.getE60149(), session);
					e601.setE60154(code[0]);
					e601.setE60155(code[1]);
					session.clear();
					session.saveOrUpdate(e601);
					session.flush();
					session.refresh(e601);
					e601Response.setState(true);
					e601Response.setPromptMessage("更新成功");
				} else {
					e601Response.setState(false);
					e601Response.setErrorMessage("不存在这条数据");
				}
			} else {
				e601Response.setState(false);
				e601Response.setErrorMessage("数据为空");
			}

		} catch (Exception e) {

			e.printStackTrace();
			e601Response.setState(false);
			e601Response.setErrorMessage("更新失败");
		}
		return e601Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E601Response saveE601(E601 e601) {
		boolean state = true;
		Object[] e601Fields =null;
		String e60130=e601.getE60130();
		String e60131=e601.getE60131();
		E601Response e601Response = new E601Response();
		Session session = sessionFactory.getCurrentSession();
		try {
			if (e601 != null) {
				 e601Fields = (Object[]) session.createSQLQuery(
						"select max(e601_34),max(e601_47_zh) from v_e601 "
								+ "where e601_03=? and e601_04=?").setString(0,
						e601.getE60103()).setString(1, e601.getE60104())
						.uniqueResult();
				if (e601Fields[0]!= null) {
					Date e60134 = (Date) e601Fields[0];
					String monthStr = (String) session.createSQLQuery(
							"select c101_02 from C101 where c101_01='2'")
							.uniqueResult();
					int month = TimeSwitch.getMonthSpace(e60134, new Date());
					if (month < Integer.parseInt(monthStr)) {
						state = false;
						e601Response.setErrorMessage("该信息已经被" + e601Fields[1]
								+ "于"
								+ new DateTime(e60134).toString("yyyy-MM-dd")
								+ "登记过档案！信息登记未超过半年");
					}
				}
				if(state&&!StringUtil.isBlankString(e60130))
				{
						e601Fields=(Object[]) session.createSQLQuery("select e601_34str," +
						"e601_47_zh from v_e601 t where e601_30=?").setParameter(0,e60130).uniqueResult();
					if (e601Fields != null) {
						state = false;
						e601Response.setErrorMessage("该两病编号已经被" + e601Fields[1]
								+ "于"
								+ e601Fields[1]
								+ "登记！");
						}
					
				}
				if(state&&!StringUtil.isBlankString(e60131))
				{
						e601Fields=(Object[]) session.createSQLQuery("select e601_34str," +
						"e601_47_zh from v_e601 t where e601_31=?").setParameter(0, e60131).uniqueResult();
					if (e601Fields != null) {
						state = false;
						e601Response.setErrorMessage("该多病病编号已经被" + e601Fields[1]
								+ "于"
								+ e601Fields[1]
								+ "登记！");
						}
					
				}
				
			}
			if (state) {
				session.save(e601);
				session.flush();
				session.refresh(e601);
				e601Response.setPromptMessage("保存成功");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("e60101", e601.getE60101());
				e601Response.setE601Map(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			e601Response.setErrorMessage("保存异常" + e.getMessage());
		}
		e601Response.setState(state);
		return e601Response;
	}

	@Override
	public E601Response renewE601(E601Request e601Request) {
		boolean state = true;
		E601Response e601Response = new E601Response();
		Session session = sessionFactory.getCurrentSession();
		try {
			List<String> list = e601Request.getE60101List();
			E601 e601 = e601Request.getE601();
			String e60136 = e601.getE60136();
			Date e60137 = e601.getE60137();
			String e60138 = e601.getE60138();
			Date e60139 = e601.getE60139();
			String e60140 = e601.getE60140();
			String e60141 = e601.getE60141();
			String e60142 = e601.getE60142();
			String e60143 = e601.getE60143();
			String e60144 = e601.getE60144();
			Date e60145 = e601.getE60145();
			int count = 0;
			int fail = 0;// 邮寄失败计数器
			for (String e60101 : list) {
				e601 = (E601) session.get(E601.class, e60101);
				if (e601 != null) {
					count++;
					if ("2".equals(e60136)) {
						e601.setE60137(e60137);
						e601.setE60138(e60138);

					} else if ("3".equals(e60136)) {
						e601.setE60139(e60139);
						e601.setE60140(e60140);
						e601.setE60141(e60141);
						e601.setE60142(e60142);
						e601.setE60143(e60143);
					} else if ("4".equals(e60136)) {
						e601.setE60144(e60144);
						e601.setE60145(e60145);

					}
					e601.setE60136(e60136);
					session.saveOrUpdate(e601);
					session.flush();
					session.refresh(e601);
					if (count % 20 == 0)
						session.clear();
				} else
					fail++;

			}
			String message = null;
			if (fail == 0) {
				if ("2".equals(e60136))
					message = "邮寄成功";
				else if ("3".equals(e60136))
					message = "已审核成功";
				else if ("4".equals(e60136))
					message = "退回成功";
			} else {
				if ("2".equals(e60136))
					message = "邮寄成功" + (list.size() - fail) + "条，" + "邮寄失败"
							+ fail + "条";
				else if ("3".equals(e60136))
					message = "已审核成功" + (list.size() - fail) + "条，" + "已审核失败"
							+ fail + "条";
				else if ("4".equals(e60136))
					message = "退回成功" + (list.size() - fail) + "条，" + "退回成功失败"
							+ fail + "条";
			}
			e601Response.setPromptMessage(message);
		} catch (Exception e) {
			e601Response.setErrorMessage(e.getMessage());
		}

		e601Response.setState(state);
		return e601Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E601Response queryRevocationE601(E601Request e601Request) {
		boolean state = false;
		E601 e601 = e601Request.getE601();
		String e60103 = e601.getE60103();
		String e60104 = e601.getE60104();
		String e60109 = e601.getE60109();
		String e60147 = e601.getE60147();
		Date timeStart = e601Request.getTimeStr();
		Date timeEnd = e601Request.getTimeEnd();
		E601Response e601Response = new E601Response();
		int pageIndex = e601Request.getParameterPageindex();
		int pageSize = e601Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();

			if (!StringUtil.isBlankString(e60103)) {
				parameterConditionwhere.append("and e1.e601_03='" + e60103
						+ "'");
			}
			if (!StringUtil.isBlankString(e60104)) {
				parameterConditionwhere.append("and e1.e601_04='" + e60104
						+ "'");
			}
			if (!StringUtil.isBlankString(e60109)) {
				parameterConditionwhere.append("and e1.e601_09='" + e60109
						+ "'");
			}

	
			if (timeStart != null) {
				parameterConditionwhere
						.append("and to_char(e1.e601_34,'yyyy-mm-dd') >='"
								+ sdf.format(timeStart) + "'");
			}
			if (timeEnd != null) {
				parameterConditionwhere
						.append("and to_char(e1.e601_34,'yyyy-mm-dd') <= '"
								+ sdf.format(timeEnd) + "'");
			}

	

		if (!StringUtil.isBlankString(e60147)) {
			if (e60147.length() == 14) {
				parameterConditionwhere.append(" and e1.e601_47 = '");
				parameterConditionwhere.append(e60147);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and e1.e601_47 like '");
				parameterConditionwhere.append(e60147);
				parameterConditionwhere.append("%'");
			}
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			List<String> e60104List = session
					.createSQLQuery(
							"select e601_04 from e601 e1 "
									+ "where e601_36='4' and not exists (select e601_04 from e601 e2 where "
									+ "e1.e601_04=e2.e601_04 and e601_36! ='4')"
									+ parameterConditionwhere
									+ " group by e601_04").setFirstResult(
							(pageIndex - 1) * pageSize).setMaxResults(pageSize)
					.list();

			if (e60104List.size() > 0) {
				VE601 ve601 = null;
				List<VE601> ve601s = new ArrayList<VE601>();
				for (String _e60104 : e60104List) {
					ve601 = new VE601();
					Object[] object = (Object[]) session
							.createSQLQuery(
									"select * from v_e601 a "
											+ "where e601_04 = '"
											+ _e60104
											+ "' and E601_34="
											+ "(select  max(e601_34) from v_e601 t where e601_04 = "
											+ "'" + _e60104 + "' )and rownum=1")
							.uniqueResult();

					ve601.setE60103((String) object[2]);
					ve601.setE60104((String) object[3]);
					ve601.setE60106((String) object[5]);
					ve601.setE60107((String) object[6]);
					ve601.setE60108((String) object[7]);
					ve601.setE60109((String) object[8]);
					ve601.setE60110((String) object[9]);
					ve601.setE60111((String) object[10]);
					ve601.setE60114((String) object[13]);
					ve601.setE60115((String) object[14]);
					ve601.setE60116((String) object[15]);
					ve601.setE60117((String) object[16]);
					ve601.setE60119((String) object[18]);
					ve601.setE60120((String) object[19]);
					ve601.setE60121((String) object[20]);
					ve601.setE60122((String) object[21]);
					ve601.setE60123((String) object[22]);
					ve601.setE60124((String) object[23]);
					ve601.setE60125((String) object[24]);
					ve601.setE60127((String) object[26]);
					ve601.setE60128((String) object[27]);
					ve601.setE60129((String) object[28]);
					ve601.setE60133((String) object[32]);
					ve601.setE60144((String) object[43]);
					ve601.setE60146((String) object[45]);
					ve601.setE60147((String) object[46]);
					ve601.setE60148((String) object[47]);
					ve601.setE60149((String) object[48]);
					ve601.setE60150((String) object[49]);
					ve601.setE60151((String) object[50]);
					ve601.setE60152((String) object[51]);
					ve601.setE60153((String) object[52]);
					ve601.setE60129Zh((String) object[80]);
					ve601.setE60136Zh((String) object[81]);
					ve601.setE60105Str((String) object[91]);
					ve601.setE60118Str((String) object[92]);
					ve601.setE60126Str((String) object[93]);
					ve601.setE60145Str((String) object[98]);
					ve601.setE60102(((BigDecimal) object[1]).longValue());
					ve601.setE60112(((BigDecimal) object[11]).byteValue());
					ve601.setE60113(((BigDecimal) object[12]).byteValue());
					ve601s.add(ve601);

				}
				state = true;
				e601Response.setVe601s(ve601s);
				e601Response.setRowCount(e60104List.size());
				e601Response.setPromptMessage("查询成功");

			} else {
				e601Response.setErrorMessage("暂无数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			e601Response.setErrorMessage("查询失败");
		}
		e601Response.setState(state);
		return e601Response;
	}

	@Override
	public E601Response queryE60130(String e60130) {
		boolean state = false;
		E601Response e601Response = new E601Response();
		try {
			Session session = sessionFactory.getCurrentSession();
			String _e60130 = (String) session.createSQLQuery(
					"select e601_30 from e601 t " + "where e601_30 = '"
							+ e60130 + "' group by e601_30 "
							+ "having count(e601_30)>0").uniqueResult();
			if (_e60130 != null)
				e601Response.setErrorMessage("存在相同的两病编号，请从新输入！");
			else {
				state = true;
				e601Response.setPromptMessage("");
			}
		} catch (Exception e) {
			e.printStackTrace();
			e601Response.setErrorMessage("查询失败");
		}

		e601Response.setState(state);
		return e601Response;
	}

}
