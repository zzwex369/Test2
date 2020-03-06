package com.xyw.medical.etbj.ettlscdjb.dao.impl;

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

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;

import com.xyw.medical.etbj.ettlscdjb.dao.E504Dao;
import com.xyw.medical.etbj.model.E504;
import com.xyw.medical.etbj.model.E504Request;
import com.xyw.medical.etbj.model.E504Response;
import com.xyw.medical.etbj.model.E505;
import com.xyw.medical.etbj.model.VE504;
import com.xyw.sys.util.MsCountryCode;
import com.xyw.sys.util.StringUtil;
import com.xyw.sys.util.TimeSwitch;

public class E504DaoImpl implements E504Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;

	@Override
	public E504Response saveE504(E504 e504) {
		E504Response e504Response = new E504Response();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			Object[] e504Fields = (Object[]) session
					.createSQLQuery(
							"select max(e504_59),max(e504_57_zh) from v_e504 where e504_06=? and e504_07=?")
					.setString(0, e504.getE50406()).setString(1,
							e504.getE50407()).uniqueResult();
			if (e504Fields[0] != null) {
				Date e50459 = (Date) e504Fields[0];
				String monthStr = (String) session.createSQLQuery(
						"select c101_02 from C101 where c101_01='3'")
						.uniqueResult();
				int month = TimeSwitch.getMonthSpace(e50459, new Date());
				if (month < Integer.parseInt(monthStr)) {
					state = false;
					e504Response.setErrorMessage("该信息已经被" + e504Fields[1] + "于"
							+ new DateTime(e50459).toString("yyyy-MM-dd")
							+ "登记过档案！信息登记未超过半年");
				}

			}
			if (state) {
				e504Response = setCode(e504.getE50409(), session);
				E504 e504_ = e504Response.getE504();
				e504.setE50404(e504_.getE50404());
				e504.setE50462(e504_.getE50462());
				session.save(e504);
				session.flush();
				session.refresh(e504);
			}
		} catch (Exception e) {
			state = false;
			e.printStackTrace();
			e504Response.setErrorMessage("保存失败！" + e.getMessage());
		}
		e504Response.setState(state);
		return e504Response;
	}

	private E504Response setCode(String d20101, Session session) {
		E504Response e504Response = new E504Response();
		E504 e504 = new E504();
		int i = 0;
		e504Response.setState(false);
		try {
			if (d20101 != null) {
				String d20107 = (String) session.createSQLQuery(
						"select t.d201_07 from d201_ms t where t.d201_01=?")
						.setString(0, d20101).uniqueResult();
				if (d20107 != null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
					String year = sdf.format(new Date());
					String year_new = year.substring(2, 4);
					String maxE504_62 = (String) session
							.createSQLQuery(
									"select max(t.E504_62) from E504 t where t.E504_63 = ? and  substr(t.E504_04,1,2)=?")
							.setString(0, d20107).setString(1, year_new)
							.uniqueResult();// 查询E504_62的最大值，接下来根据其最大值加1
					maxE504_62 = maxE504_62 != null ? maxE504_62 : "0";
					i = Integer.parseInt(maxE504_62) + 1;
					String str_m = String.valueOf(i);
					String str = "000000";
					str_m = str.substring(0, 6 - str_m.length()) + str_m;
					String E50404 = year_new + d20107 + str_m;
					e504.setE50404(E50404);
					e504.setE50462(str_m);
					e504Response.setE504(e504);
					e504Response.setPromptMessage("创建档案号成功");
				} else {
					e504Response.setErrorMessage("无法得到地区编码");
					return e504Response;
				}
			} else {
				e504Response.setErrorMessage("地址为空");
				return e504Response;
			}

		} catch (Exception e) {
			e.printStackTrace();
			e504Response.setState(false);
			e504Response.setErrorMessage("档案编码异常");
		}
		return e504Response;

	}

	@Override
	public E504Response queryE504(E504Request e504Request) {
		E504Response e504Response = new E504Response();
		E504 _e504 = e504Request.getE504();
		int parameterPageIndex = e504Request.getParameterPageindex();
		int parameterPagesize = e504Request.getParameterPagesize();
		Date timeDate = e504Request.getTimeStr();
		Date timeEnDate = e504Request.getTimeEnd();
		String e504_06 = _e504.getE50406();// 母亲姓名
		String e504_07 = _e504.getE50407();// 母亲身份证号
		String e504_57 = _e504.getE50457();// 录入单位
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		parameterConditionwhere.append("and t.E504_65 is null ");
		if (!StringUtil.isBlankString(e504_06)) {
			parameterConditionwhere.append("and t.E504_06 ='" + e504_06 + "' ");
		}
		if (!StringUtil.isBlankString(e504_07)) {
			parameterConditionwhere.append("and t.E504_07 ='" + e504_07 + "' ");
		}
		if (!StringUtil.isBlankString(e504_57)) {
			if (e504_57.length() == 14) {
				parameterConditionwhere.append(" and t.E504_57 = '");
				parameterConditionwhere.append(e504_57);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.E504_57 like '");
				parameterConditionwhere.append(e504_57);
				parameterConditionwhere.append("%'");
			}
		}
		if (timeDate != null) {
			String timeStr = sdf.format(timeDate);
			parameterConditionwhere
					.append(" and to_char(t.E504_59,'yyyy-mm-dd') >= '"
							+ timeStr + "'");
		}
		if (timeEnDate != null) {
			String timeEnd = sdf.format(timeEnDate);
			parameterConditionwhere
					.append(" and to_char(t.E504_59,'yyyy-mm-dd') <= '"
							+ timeEnd + "'");
		}
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageIndex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_E504");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.E504_59");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			// if(rowCount==0){
			// e504Response.setState(false);
			// e504Response.setErrorMessage("暂无数据");
			// return e504Response;
			// }
			e504Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VE504 vE504 = null;
			List<VE504> vE504s = new ArrayList<VE504>();
			while (resultSet.next()) {
				vE504 = new VE504();
				vE504.setE50401(resultSet.getString("E504_01"));
				vE504.setE50402(resultSet.getString("E504_02"));
				vE504.setE50403(resultSet.getString("E504_03"));
				vE504.setE50404(resultSet.getString("E504_04"));
				vE504.setE50405(resultSet.getString("E504_05"));
				vE504.setE50406(resultSet.getString("E504_06"));
				vE504.setE50407(resultSet.getString("E504_07"));
				vE504.setE50408(resultSet.getString("E504_08"));
				vE504.setE50409(resultSet.getString("E504_09"));
				vE504.setE50410(resultSet.getString("E504_10"));
				vE504.setE50411(resultSet.getString("E504_11"));
				vE504.setE50412(resultSet.getString("E504_12"));
				vE504.setE50413(resultSet.getString("E504_13"));
				vE504.setE50414(resultSet.getDate("E504_14"));
				vE504.setE50415(resultSet.getString("E504_15"));
				vE504.setE50416(resultSet.getDouble("E504_16"));
				vE504.setE50417(resultSet.getDouble("E504_17"));
				vE504.setE50418(resultSet.getString("E504_18"));
				vE504.setE50419(resultSet.getString("E504_19"));
				vE504.setE50420(resultSet.getLong("E504_20"));
				vE504.setE50421(resultSet.getLong("E504_21"));
				vE504.setE50422(resultSet.getLong("E504_22"));
				vE504.setE50423(resultSet.getString("E504_23"));
				vE504.setE50424(resultSet.getString("E504_24"));
				vE504.setE50425(resultSet.getString("E504_25"));
				vE504.setE50426(resultSet.getString("E504_26"));
				vE504.setE50427(resultSet.getString("E504_27"));
				vE504.setE50428(resultSet.getString("E504_28"));
				vE504.setE50429(resultSet.getString("E504_29"));
				vE504.setE50430(resultSet.getString("E504_30"));
				vE504.setE50431(resultSet.getString("E504_31"));
				vE504.setE50432(resultSet.getString("E504_32"));
				vE504.setE50433(resultSet.getString("E504_33"));
				vE504.setE50434(resultSet.getString("E504_34"));
				vE504.setE50435(resultSet.getString("E504_35"));
				vE504.setE50436(resultSet.getString("E504_36"));
				vE504.setE50437(resultSet.getString("E504_37"));
				vE504.setE50438(resultSet.getString("E504_38"));
				vE504.setE50439(resultSet.getString("E504_39"));
				vE504.setE50440(resultSet.getString("E504_40"));
				vE504.setE50441(resultSet.getString("E504_41"));
				vE504.setE50442(resultSet.getString("E504_42"));
				vE504.setE50443(resultSet.getString("E504_43"));
				vE504.setE50444(resultSet.getString("E504_44"));
				vE504.setE50445(resultSet.getString("E504_45"));
				vE504.setE50446(resultSet.getString("E504_46"));
				vE504.setE50447(resultSet.getString("E504_47"));
				vE504.setE50448(resultSet.getString("E504_48"));
				vE504.setE50449(resultSet.getString("E504_49"));
				vE504.setE50450(resultSet.getString("E504_50"));
				vE504.setE50451(resultSet.getString("E504_51"));
				vE504.setE50452(resultSet.getString("E504_52"));
				vE504.setE50453(resultSet.getString("E504_53"));
				vE504.setE50454(resultSet.getString("E504_54"));
				vE504.setE50455(resultSet.getString("E504_55"));
				vE504.setE50456(resultSet.getString("E504_56"));
				vE504.setE50457(resultSet.getString("E504_57"));
				vE504.setE50458(resultSet.getString("E504_58"));
				vE504.setE50459(resultSet.getDate("E504_59"));
				vE504.setE50460(resultSet.getDate("E504_60"));
				vE504.setE50461(resultSet.getString("E504_61"));
				vE504.setE50462(resultSet.getString("E504_62"));
				vE504.setE50499(resultSet.getString("E504_99"));
				vE504.setE50409Zh(resultSet.getString("E504_09_ZH"));
				vE504.setE50415Zh(resultSet.getString("E504_15_ZH"));
				vE504.setE50457Zh(resultSet.getString("E504_57_ZH"));
				vE504.setE50461Zh(resultSet.getString("E504_61_ZH"));
				vE504.setE50459Str(resultSet.getString("E504_59_STR"));
				vE504s.add(vE504);
			}
			e504Response.setPromptMessage("查询成功");
			e504Response.setRowCount(rowCount);
			e504Response.setState(true);
			e504Response.setVe504(vE504s);

		} catch (Exception e) {
			e504Response.setErrorMessage("查询失败！");
			e504Response.setState(false);
			e.printStackTrace();

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
		return e504Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E504Response deleteE504(E504Request e504Request) {
		E504Response e504Response = new E504Response();
		boolean state = true;
		String e504_01 = e504Request.getE50401();
		try {
			Session session = sessionFactory.getCurrentSession();
			List<E505> list = session.createSQLQuery(
					"select e505_01 from e505 t where e505_02=?").setString(0,
					e504_01).list();
			if (list.size() > 0) {
				state = false;
				e504Response.setErrorMessage("存在检查信息无法删除，请联系客服人员");
			} else {

				E504 e504 = new E504();
				e504.setE50401(e504_01);
				session.delete(e504);
				e504Response.setPromptMessage("删除成功");
			}
		} catch (HibernateException e) {
			// e.printStackTrace();
			e504Response.setErrorMessage("删除失败！");
		}
		e504Response.setState(state);
		return e504Response;
	}

	@Override
	public E504Response renewE504(E504 e504) {
		E504Response e504Response = new E504Response();
		try {
			Session session = sessionFactory.getCurrentSession();
			String[] code = MsCountryCode.setCountryCode(e504.getE50409(), e504
					.getE50461(), session);
			e504.setE50463(code[0]);
			e504.setE50464(code[1]);
			session.saveOrUpdate(e504);
			session.flush();
			session.refresh(e504);
		} catch (Exception e) {
			e.printStackTrace();
			e504Response.setErrorMessage("更新失败!" + "/n" + e.getMessage());
		}
		return e504Response;
	}

}
