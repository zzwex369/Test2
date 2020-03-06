package com.xyw.medical.fnbj.fnbjcssq.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;

import com.xyw.medical.fnbj.fnbjcssq.dao.F501Dao;
import com.xyw.medical.fnbj.model.F501;
import com.xyw.medical.fnbj.model.F501Request;
import com.xyw.medical.fnbj.model.F501Response;
import com.xyw.medical.fnbj.model.VF501;
import com.xyw.sys.util.StringUtil;
import com.xyw.sys.util.TimeSwitch;

public class F501DaoImpl implements F501Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;

	@SuppressWarnings("unchecked")
	@Override
	public F501Response saveF501(F501 f501) {
		F501Response f501Response = new F501Response();
		String f50105 = f501.getF50105();
		boolean state = true;

		Session session = sessionFactory.getCurrentSession();
		try {

			Object[] f501Fields = (Object[]) session.createSQLQuery(
					"select max(f501_28),max(f501_26_zh) from v_f501 t where t.f501_05 ='" + f50105 + "'")
					.uniqueResult();

			if (f501Fields[0]!= null) {
				Date f50128 = (Date) f501Fields[0];
				String monthStr = (String) session.createSQLQuery(
						"select c101_02 from C101 where c101_01='4'")
						.uniqueResult();
				int month = TimeSwitch.getMonthSpace(f50128, new Date());
				if (month < Integer.parseInt(monthStr)) {
					state = false;
					f501Response.setErrorMessage("该信息已经被" + f501Fields[1] + "于"
							+ new DateTime(f50128).toString("yyyy-MM-dd")
							+ "登记过档案！信息登记未超过半年");
				}
			}
		} catch (Exception e) {
			f501Response.setErrorMessage(e.getMessage());
			state = false;
		}
		if (state) {
			try {
				f501Response = setCode(f501.getF50134(), session);
				F501 f501_ = f501Response.getF501();
				f501.setF50141(f501_.getF50141());
				f501.setF50144(f501_.getF50144());
				session.save(f501);
				session.flush();
				session.refresh(f501);
				f501Response.setF50101(f501.getF50101());
			} catch (Exception e) {
				f501Response.setErrorMessage(e.getMessage());
				state = false;
			}
		}
		f501Response.setState(state);
		return f501Response;
	}

	private F501Response setCode(String d20101, Session session) {
		F501Response f501Response = new F501Response();
		F501 f501 = new F501();
		int i = 0;
		f501Response.setState(false);
		try {
			if (d20101 != null) {
				String d20109 = (String) session.createSQLQuery(
						"select t.d201_06 from d201_ms t where t.d201_01=?")
						.setString(0, d20101).uniqueResult();
				if (d20109 != null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
					String year = sdf.format(new Date());
					String maxF501_44 = (String) session
							.createSQLQuery(
									"select max(t.F501_44) from F501 t where t.F501_34 = ? and  substr(t.F501_41,1,4)=?")
							.setString(0, d20101).setString(1, year)
							.uniqueResult();// 查询E504_62的最大值，接下来根据其最大值加1
					maxF501_44 = maxF501_44 != null ? maxF501_44 : "0";
					i = Integer.parseInt(maxF501_44) + 1;
					String str_m = String.valueOf(i);
					String str = "00000";
					str_m = str.substring(0, 5 - str_m.length()) + str_m;
					String f50141 = year + d20109 + str_m;
					f501.setF50141(f50141);
					f501.setF50144(str_m);
					f501Response.setF501(f501);
					f501Response.setPromptMessage("创建档案号成功");
				} else {
					f501Response.setErrorMessage("无法得到地区编码");
					return f501Response;
				}
			} else {
				f501Response.setErrorMessage("地址为空");
				return f501Response;
			}

		} catch (Exception e) {
			f501Response.setState(false);
			f501Response.setErrorMessage("档案编码异常");
		}
		return f501Response;

	}

	@SuppressWarnings("unchecked")
	@Override
	public F501Response renewF501(F501 f501) {
		F501Response f501Response = new F501Response();

		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		List<Object> listF502 = null;
		try {
			StringBuffer sql = new StringBuffer(
					"select * from f502 t where t.f502_02 ='"
							+ f501.getF50101() + "'");
			SQLQuery sqlQuery = session.createSQLQuery(sql.toString());

			listF502 = sqlQuery.list();
			if (listF502.size() > 0) {
				f501Response.setErrorMessage("产前超声筛查报告已保存，不能修改!");
				state = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			f501Response.setErrorMessage("保存失败！");
			state = false;
		}
		if (state) {
			try {
				session.saveOrUpdate(f501);
				session.flush();
				session.refresh(f501);
			} catch (Exception e) {
				f501Response.setErrorMessage(e.getMessage());
				state = false;
			}
		}
		f501Response.setState(state);
		return f501Response;
	}

	@Override
	public F501Response queryF501(F501Request f501Request) {
		F501Response f501Response = new F501Response();
		String flag = f501Request.getFlag();
		String f50101_ = f501Request.getF50101();
		String f50103_ = f501Request.getF50103();
		String f50105_ = f501Request.getF50105();
		String f50126_ = f501Request.getF50126();
		String f50129_ = f501Request.getF50129();
		String f50107_ = f501Request.getF50107();
		String f50147_ = f501Request.getF50147();
		Date timeStr_ = f501Request.getTimeStr();
		Date timeEnd_ = f501Request.getTimeEnd();
		int parameterPageindex = f501Request.getParameterPageindex();
		int parameterPagesize = f501Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();

		if (!StringUtil.isBlankString(f50101_)) {
			parameterConditionwhere.append("and t.f501_01 ='" + f50101_ + "' ");
		}
		if (!StringUtil.isBlankString(f50103_)) {
			parameterConditionwhere.append("and t.f501_03 ='" + f50103_ + "' ");
		}
		if (!StringUtil.isBlankString(f50105_)) {
			parameterConditionwhere.append("and t.f501_05 ='" + f50105_ + "' ");
		}
		if (!StringUtil.isBlankString(f50129_)) {
			parameterConditionwhere.append("and t.f501_29 ='" + f50129_ + "' ");
		}
		if (!StringUtil.isBlankString(f50107_)) {
			parameterConditionwhere.append("and t.f501_07 ='" + f50107_ + "' ");
		}

		if (!StringUtil.isBlankString(f50147_)) {
			parameterConditionwhere.append("and t.f501_47 ='" + f50147_ + "' ");
		}

		if (timeStr_ != null) {
			String timeStr = sdf.format(timeStr_);
			parameterConditionwhere.append(" and t.f501_25_str >= '" + timeStr
					+ "'");
		}
		if (timeEnd_ != null) {
			String timeEnd = sdf.format(timeEnd_);
			parameterConditionwhere.append(" and t.f501_25_str <= '" + timeEnd
					+ "'");
		}

		if (!StringUtil.isBlankString(f50126_)) {
			if (f50126_.length() == 14) {
				parameterConditionwhere.append(" and t.f501_26 = '");
				parameterConditionwhere.append(f50126_);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.f501_26 like '");
				parameterConditionwhere.append(f50126_);
				parameterConditionwhere.append("%'");
			}
		}

		boolean state = true;
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_F501");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.f501_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			f501Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VF501 vf501 = null;
			List<VF501> vf501s = new ArrayList<VF501>();
			while (resultSet.next()) {
				String f50101 = resultSet.getString("F501_01");
				long f50102 = resultSet.getLong("F501_02");
				String f50103 = resultSet.getString("F501_03");
				String f50104 = resultSet.getString("F501_04");
				String f50105 = resultSet.getString("F501_05");
				Date f50106 = resultSet.getDate("F501_06");
				String f50107 = resultSet.getString("F501_07");
				double f50108 = resultSet.getDouble("F501_08");
				String f50109 = resultSet.getString("F501_09");
				String f50110 = resultSet.getString("F501_10");
				String f50111 = resultSet.getString("F501_11");
				String f50112 = resultSet.getString("F501_12");
				Date f50113 = resultSet.getDate("F501_13");
				String f50114 = resultSet.getString("F501_14");
				long f50115 = resultSet.getLong("F501_15");
				String f50116 = resultSet.getString("F501_16");
				Date f50117 = resultSet.getDate("F501_17");
				long f50118 = resultSet.getLong("F501_18");
				String f50119 = resultSet.getString("F501_19");
				String f50120 = resultSet.getString("F501_20");
				String f50121 = resultSet.getString("F501_21");
				String f50122 = resultSet.getString("F501_22");
				String f50123 = resultSet.getString("F501_23");
				String f50124 = resultSet.getString("F501_24");
				Date f50125 = resultSet.getDate("F501_25");
				String f50126 = resultSet.getString("F501_26");
				String f50127 = resultSet.getString("F501_27");
				Date f50128 = resultSet.getDate("F501_28");
				String f50129 = resultSet.getString("F501_29");
				String f50130 = resultSet.getString("F501_30");
				long f50131 = resultSet.getLong("F501_31");
				String f50132 = resultSet.getString("F501_32");
				String f50133 = resultSet.getString("F501_33");
				String f50134 = resultSet.getString("F501_34");
				String f50135 = resultSet.getString("F501_35");
				long f50136 = resultSet.getLong("F501_36");
				long f50137 = resultSet.getLong("F501_37");
				String f50139 = resultSet.getString("F501_39");
				Date f50140 = resultSet.getDate("F501_40");
				String f50141 = resultSet.getString("F501_41");
				String f50142 = resultSet.getString("F501_42");
				String f50144 = resultSet.getString("F501_44");
				String f50145 = resultSet.getString("F501_45");
				String f50146 = resultSet.getString("F501_46");
				String f50147 = resultSet.getString("F501_47");
				Date f50148 = resultSet.getDate("F501_48");
				String f50149 = resultSet.getString("F501_49");
				String f50152 = resultSet.getString("F501_52");
				String f50106Str = resultSet.getString("F501_06_Str");
				String f50113Str = resultSet.getString("F501_13_Str");
				String f50117Str = resultSet.getString("F501_17_Str");
				String f50125Str = resultSet.getString("F501_25_Str");
				String f50128Str = resultSet.getString("F501_28_Str");

				String f50104Zh = resultSet.getString("F501_04_ZH");
				String f50109Zh = resultSet.getString("F501_09_ZH");
				String f50110Zh = resultSet.getString("F501_10_ZH");
				String f50111Zh = resultSet.getString("F501_11_ZH");
				String f50112Zh = resultSet.getString("F501_12_ZH");
				String f50114Zh = resultSet.getString("F501_14_ZH");
				String f50119Zh = resultSet.getString("F501_19_ZH");
				String f50120Zh = resultSet.getString("F501_20_ZH");
				String f50126Zh = resultSet.getString("F501_26_ZH");

				vf501 = new VF501();
				vf501.setF50101(f50101);
				vf501.setF50102(f50102);
				vf501.setF50103(f50103);
				vf501.setF50104(f50104);
				vf501.setF50104Zh(f50104Zh);
				vf501.setF50105(f50105);
				vf501.setF50106(f50106);
				vf501.setF50106Str(f50106Str);
				vf501.setF50107(f50107);
				vf501.setF50108(f50108);
				vf501.setF50109(f50109);
				vf501.setF50109Zh(f50109Zh);
				vf501.setF50110(f50110);
				vf501.setF50110Zh(f50110Zh);
				vf501.setF50111(f50111);
				vf501.setF50111Zh(f50111Zh);
				vf501.setF50112(f50112);
				vf501.setF50112Zh(f50112Zh);
				vf501.setF50113(f50113);
				vf501.setF50113Str(f50113Str);
				vf501.setF50114(f50114);
				vf501.setF50114Zh(f50114Zh);
				vf501.setF50115(f50115);
				vf501.setF50116(f50116);
				vf501.setF50117(f50117);
				vf501.setF50117Str(f50117Str);
				vf501.setF50118(f50118);
				vf501.setF50119(f50119);
				vf501.setF50119Zh(f50119Zh);
				vf501.setF50120(f50120);
				vf501.setF50120Zh(f50120Zh);
				vf501.setF50121(f50121);
				vf501.setF50122(f50122);
				vf501.setF50123(f50123);
				vf501.setF50124(f50124);
				vf501.setF50125(f50125);
				vf501.setF50125Str(f50125Str);
				vf501.setF50126(f50126);
				vf501.setF50126Zh(f50126Zh);
				vf501.setF50127(f50127);
				vf501.setF50128(f50128);
				vf501.setF50128Str(f50128Str);
				vf501.setF50129(f50129);
				vf501.setF50130(f50130);
				vf501.setF50131(f50131);
				vf501.setF50132(f50132);
				vf501.setF50133(f50133);
				vf501.setF50134(f50134);
				vf501.setF50135(f50135);
				vf501.setF50136(f50136);
				vf501.setF50137(f50137);
				vf501.setF50139(f50139);
				vf501.setF50140(f50140);
				vf501.setF50141(f50141);
				vf501.setF50142(f50142);
				vf501.setF50144(f50144);
				vf501.setF50145(f50145);
				vf501.setF50146(f50146);
				vf501.setF50147(f50147);
				vf501.setF50148(f50148);
				vf501.setF50149(f50149);
				vf501.setF50152(f50152);
				vf501s.add(vf501);
			}
			f501Response.setVf501s(vf501s);
			f501Response.setState(state);
		} catch (Exception e) {
			f501Response.setErrorMessage("查询失败！");
			f501Response.setState(false);
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

			}
		}
		return f501Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public F501Response deleteF501(F501Request f501Request) {
		F501Response f501Response = new F501Response();
		String f50101 = f501Request.getF50101();

		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		List<Object> listF502 = null;
		try {
			StringBuffer sql = new StringBuffer(
					"select * from f502 t where t.f502_02 ='" + f50101 + "'");
			SQLQuery sqlQuery = session.createSQLQuery(sql.toString());

			listF502 = sqlQuery.list();
			if (listF502.size() > 0) {
				f501Response.setErrorMessage("产前超声筛查报告已保存，不能删除!");
				state = false;
			}
		} catch (Exception e) {
			f501Response.setErrorMessage("删除失败！");
			e.printStackTrace();
			state = false;
		}
		if (state) {
			try {
				F501 f501 = new F501();
				f501.setF50101(f50101);
				session.delete(f501);
			} catch (Exception e) {
				f501Response.setErrorMessage("删除失败！");
				state = false;
			}
		}
		f501Response.setState(state);
		return f501Response;
	}

}
