package com.xyw.medical.fnbj.fnbjxqsq.dao.impl;

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

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;

import com.xyw.medical.fnbj.fnbjxqsq.dao.F601Dao;
import com.xyw.medical.fnbj.model.F601;
import com.xyw.medical.fnbj.model.F601Request;
import com.xyw.medical.fnbj.model.F601Response;
import com.xyw.medical.fnbj.model.F602;
import com.xyw.medical.fnbj.model.VF601;
import com.xyw.sys.util.StringUtil;
import com.xyw.sys.util.TimeSwitch;

public class F601DaoImpl implements F601Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;

	@SuppressWarnings("unchecked")
	@Override
	public F601Response saveF601(F601 f601) {
		F601Response f601Response = new F601Response();
		String f60104 = f601.getF60104();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {

			Object[] f601Fields = (Object[]) session.createSQLQuery(
					"select max(f601_34),max(f601_29_zh) from v_f601 t where f601_04 ='" + f60104 + "'")
					.uniqueResult();
			if (f601Fields[0]!= null) {
				Date f60134 = (Date) f601Fields[0];
				String monthStr = (String) session.createSQLQuery(
						"select c101_02 from C101 where c101_01='5'")
						.uniqueResult();
				int month = TimeSwitch.getMonthSpace(f60134, new Date());
				if (month < Integer.parseInt(monthStr)) {
					state = false;
					f601Response.setErrorMessage("该信息已经被" + f601Fields[1] + "于"
							+ new DateTime(f60134).toString("yyyy-MM-dd")
							+ "登记过档案！信息登记未超过半年");
				}
			}
		} catch (Exception e) {
			f601Response.setErrorMessage("保存失败! ");
			e.printStackTrace();
			state = false;
		}
		if (state) {
			try {
				if (f601.getF60155() == null)
					f601.setF60155(getF60155());
				session.save(f601);
				session.flush();
				session.refresh(f601);
				VF601 vf601 = (VF601) session
						.get(VF601.class, f601.getF60101());
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("vf601", vf601);
				f601Response.setF601Map(map);
				f601Response.setPromptMessage("保存成功! ");
			} catch (Exception e) {
				f601Response.setErrorMessage("保存失败! ");
				e.printStackTrace();
				state = false;
			}
		}
		f601Response.setState(state);
		return f601Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public F601Response renewF601(F601 f601) {
		F601Response f601Response = new F601Response();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			StringBuffer sql = new StringBuffer(
					"select t.f602_01 from f602 t where t.f602_02 ='"
							+ f601.getF60101() + "'");
			String f60201 = (String) session.createSQLQuery(sql.toString())
					.uniqueResult();
			if (f60201 != null) {
				f601Response.setErrorMessage("血清学检查报告已保存，不能修改!");
				state = false;
			}
		} catch (Exception e) {
			f601Response.setErrorMessage("保存失败! ");
			e.printStackTrace();
			state = false;
		}
		if (state) {
			try {

				session.update(f601);
				session.flush();
				session.refresh(f601);
				f601Response.setPromptMessage("修改成功! ");
			} catch (Exception e) {
				f601Response.setErrorMessage("保存失败! ");
				e.printStackTrace();
				state = false;
			}
		}
		f601Response.setState(state);
		return f601Response;
	}

	@Override
	public F601Response queryF601(F601Request f601Request) {
		F601Response f601Response = new F601Response();
		String flag = f601Request.getFlag();
		F601 f601 = f601Request.getF601();
		String f60103_ = f601.getF60103();
		String f60104_ = f601.getF60104();
		String f60129_ = f601.getF60129();
		String f60131_ = f601.getF60131();
		String f60159_ = f601.getF60159();
		Date timeStr_ = f601Request.getTimeStr();
		Date timeEnd_ = f601Request.getTimeEnd();
		List<String> list = f601Request.getF60101List();// 用来传递字段名称
		int parameterPageindex = f601Request.getParameterPageindex();
		int parameterPagesize = f601Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();

		if ("true".equals(flag)) {
			if (!StringUtil.isBlankString(f60103_)) {
				parameterConditionwhere.append("and t.f601_03 ='" + f60103_
						+ "' ");
			}
			if (!StringUtil.isBlankString(f60104_)) {
				parameterConditionwhere.append("and t.f601_04 ='" + f60104_
						+ "' ");
			}

		} else if ("false".equals(flag)) {

			if (!StringUtil.isBlankString(f60159_)) {
				parameterConditionwhere.append("and t.f601_59 ='" + f60159_
						+ "' ");
			}
			if (timeStr_ != null) {
				String timeStr = sdf.format(timeStr_);
				parameterConditionwhere.append(" and to_char(" + list.get(0)
						+ ",'yyyy-mm-dd') >= '" + timeStr + "'");
			}
			if (timeEnd_ != null) {
				String timeEnd = sdf.format(timeEnd_);
				parameterConditionwhere.append(" and to_char(" + list.get(0)
						+ ",'yyyy-mm-dd') <= '" + timeEnd + "'");
			}

		}
		if (!StringUtil.isBlankString(f60129_)) {
			if (f60129_.length() == 14) {
				parameterConditionwhere.append(" and t.f601_29 = '");
				parameterConditionwhere.append(f60129_);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.f601_29 like '");
				parameterConditionwhere.append(f60129_);
				parameterConditionwhere.append("%'");
			}
		}
		if (!StringUtil.isBlankString(f60131_)) {
			if (f60131_.length() == 14) {
				parameterConditionwhere.append(" and t.f601_31 = '");
				parameterConditionwhere.append(f60131_);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.f601_31 like '");
				parameterConditionwhere.append(f60131_);
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
			callableStatement.setString(3, "V_F601");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.f601_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			f601Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VF601 vf601 = null;
			List<VF601> vf601s = new ArrayList<VF601>();
			while (resultSet.next()) {
				String f60101 = resultSet.getString("F601_01");
				String f60102 = resultSet.getString("F601_02");
				String f60103 = resultSet.getString("F601_03");
				String f60104 = resultSet.getString("F601_04");
				Date f60105 = resultSet.getDate("F601_05");
				String f60106 = resultSet.getString("F601_06");
				String f60107 = resultSet.getString("F601_07");
				String f60108 = resultSet.getString("F601_08");
				String f60109 = resultSet.getString("F601_09");
				double f60110 = resultSet.getDouble("F601_10");
				String f60111 = resultSet.getString("F601_11");
				String f60112 = resultSet.getString("F601_12");
				String f60113 = resultSet.getString("F601_13");
				Date f60114 = resultSet.getDate("F601_14");
				String f60115 = resultSet.getString("F601_15");
				Date f60116 = resultSet.getDate("F601_16");
				int f60117 = resultSet.getInt("F601_17");
				String f60118 = resultSet.getString("F601_18");
				String f60119 = resultSet.getString("F601_19");
				String f60120 = resultSet.getString("F601_20");
				Date f60121 = resultSet.getDate("F601_21");
				String f60122 = resultSet.getString("F601_22");
				String f60123 = resultSet.getString("F601_23");
				String f60124 = resultSet.getString("F601_24");
				String f60125 = resultSet.getString("F601_25");
				Date f60126 = resultSet.getDate("F601_26");
				String f60127 = resultSet.getString("F601_27");
				String f60128 = resultSet.getString("F601_28");
				String f60129 = resultSet.getString("F601_29");
				String f60130 = resultSet.getString("F601_30");
				String f60131 = resultSet.getString("F601_31");
				Date f60132 = resultSet.getDate("F601_32");
				String f60133 = resultSet.getString("F601_33");
				Date f60134 = resultSet.getDate("F601_34");
				String f60135 = resultSet.getString("F601_35");
				short f60136 = resultSet.getShort("F601_36");
				String f60137 = resultSet.getString("F601_37");
				String f60138 = resultSet.getString("F601_38");
				String f60139 = resultSet.getString("F601_39");
				String f60140 = resultSet.getString("F601_40");
				String f60141 = resultSet.getString("F601_41");
				Byte f60142 = resultSet.getByte("F601_42");
				String f60143 = resultSet.getString("F601_43");
				String f60144 = resultSet.getString("F601_44");
				String f60145 = resultSet.getString("F601_45");
				Date f60146 = resultSet.getDate("F601_46");
				String f60147 = resultSet.getString("F601_47");
				byte f60148 = resultSet.getByte("F601_48");
				byte f60149 = resultSet.getByte("F601_49");
				String f60150 = resultSet.getString("F601_50");
				String f60151 = resultSet.getString("F601_51");
				String f60152 = resultSet.getString("F601_52");
				String f60153 = resultSet.getString("F601_53");
				String f60154 = resultSet.getString("F601_54");
				String f60155 = resultSet.getString("F601_55");
				String f60156 = resultSet.getString("F601_56");
				Date f60157 = resultSet.getDate("F601_57");
				String f60158 = resultSet.getString("F601_58");
				String f60159 = resultSet.getString("F601_59");
				Date f60160 = resultSet.getDate("F601_60");
				String f60161 = resultSet.getString("F601_61");
				String f60162 = resultSet.getString("F601_62");
				String f60163 = resultSet.getString("F601_63");
				String f60164 = resultSet.getString("F601_64");
				String f60165 = resultSet.getString("F601_65");
				Date f60166 = resultSet.getDate("F601_66");
				String f60167 = resultSet.getString("F601_67");
				String f60168 = resultSet.getString("F601_68");
				String f60169 = resultSet.getString("F601_69");
				String f60170 = resultSet.getString("F601_70");
				Date f60171 = resultSet.getDate("F601_71");
				String f60172 = resultSet.getString("F601_72");
				String f60173 = resultSet.getString("F601_73");
				String f60174 = resultSet.getString("F601_74");
				Date f60175 = resultSet.getDate("F601_75");
				String f60176 = resultSet.getString("F601_76");
				String f60177 = resultSet.getString("F601_77");
				String f60178 = resultSet.getString("F601_78");
				String f60179 = resultSet.getString("F601_79");
				String f60187 = resultSet.getString("F601_87");
				String f60188 = resultSet.getString("F601_88");
				String f60189 = resultSet.getString("F601_89");
				String sysdateStr = resultSet.getString("sysdate_Str");

				String f60107Zh = resultSet.getString("F601_07_ZH");
				String f60108Zh = resultSet.getString("F601_08_ZH");
				String f60111Zh = resultSet.getString("F601_11_ZH");
				String f60112Zh = resultSet.getString("F601_12_ZH");
				String f60113Zh = resultSet.getString("F601_13_ZH");
				String f60115Zh = resultSet.getString("F601_15_ZH");
				String f60119Zh = resultSet.getString("F601_19_ZH");
				String f60122Zh = resultSet.getString("F601_22_ZH");
				String f60123Zh = resultSet.getString("F601_23_ZH");
				String f60125Zh = resultSet.getString("F601_25_ZH");
				String f60105Str = resultSet.getString("F601_05_Str");
				String f60126Str = resultSet.getString("F601_26_Str");
				String f60132Str = resultSet.getString("F601_32_Str");
				String f60129Zh = resultSet.getString("F601_29_ZH");
				String f60131Zh = resultSet.getString("F601_31_ZH");
				String f60135Zh = resultSet.getString("F601_35_ZH");
				String f60159Zh = resultSet.getString("F601_59_ZH");

				vf601 = new VF601();
				vf601.setF60101(f60101);
				vf601.setF60102(f60102);
				vf601.setF60103(f60103);
				vf601.setF60104(f60104);
				vf601.setF60105(f60105);
				vf601.setF60106(f60106);
				vf601.setF60107(f60107);
				vf601.setF60107Zh(f60107Zh);
				vf601.setF60108(f60108);
				vf601.setF60108Zh(f60108Zh);
				vf601.setF60109(f60109);
				vf601.setF60110(f60110);
				vf601.setF60111(f60111);
				vf601.setF60111Zh(f60111Zh);
				vf601.setF60112(f60112);
				vf601.setF60112Zh(f60112Zh);
				vf601.setF60113(f60113);
				vf601.setF60113Zh(f60113Zh);
				vf601.setF60114(f60114);
				vf601.setF60115(f60115);
				vf601.setF60115Zh(f60115Zh);
				vf601.setF60116(f60116);
				vf601.setF60117(f60117);
				vf601.setF60118(f60118);
				vf601.setF60119(f60119);
				vf601.setF60119Zh(f60119Zh);
				vf601.setF60120(f60120);
				vf601.setF60121(f60121);
				vf601.setF60122(f60122);
				vf601.setF60122Zh(f60122Zh);
				vf601.setF60123(f60123);
				vf601.setF60123Zh(f60123Zh);
				vf601.setF60124(f60124);
				vf601.setF60125(f60125);
				vf601.setF60125Zh(f60125Zh);
				vf601.setF60126(f60126);
				vf601.setF60105Str(f60105Str);
				vf601.setF60126Str(f60126Str);
				vf601.setF60132Str(f60132Str);
				vf601.setSysdateStr(sysdateStr);
				vf601.setF60127(f60127);
				vf601.setF60128(f60128);
				vf601.setF60129(f60129);
				vf601.setF60129Zh(f60129Zh);
				vf601.setF60130(f60130);
				vf601.setF60131(f60131);
				vf601.setF60131Zh(f60131Zh);
				vf601.setF60132(f60132);
				vf601.setF60133(f60133);
				vf601.setF60134(f60134);
				vf601.setF60135(f60135);
				vf601.setF60135Zh(f60135Zh);
				vf601.setF60159Zh(f60159Zh);
				vf601.setF60136(f60136);
				vf601.setF60137(f60137);
				vf601.setF60138(f60138);
				vf601.setF60139(f60139);
				vf601.setF60140(f60140);
				vf601.setF60141(f60141);
				vf601.setF60142(f60142);
				vf601.setF60143(f60143);
				vf601.setF60144(f60144);
				vf601.setF60145(f60145);
				vf601.setF60146(f60146);
				vf601.setF60147(f60147);
				vf601.setF60148(f60148);
				vf601.setF60149(f60149);
				vf601.setF60150(f60150);
				vf601.setF60151(f60151);
				vf601.setF60152(f60152);
				vf601.setF60153(f60153);
				vf601.setF60154(f60154);
				vf601.setF60155(f60155);
				vf601.setF60156(f60156);
				vf601.setF60157(f60157);
				vf601.setF60158(f60158);
				vf601.setF60159(f60159);
				vf601.setF60160(f60160);
				vf601.setF60161(f60161);
				vf601.setF60162(f60162);
				vf601.setF60163(f60163);
				vf601.setF60164(f60164);
				vf601.setF60165(f60165);
				vf601.setF60166(f60166);
				vf601.setF60167(f60167);
				vf601.setF60168(f60168);
				vf601.setF60169(f60169);
				vf601.setF60170(f60170);
				vf601.setF60171(f60171);
				vf601.setF60172(f60172);
				vf601.setF60173(f60173);
				vf601.setF60174(f60174);
				vf601.setF60175(f60175);
				vf601.setF60176(f60176);
				vf601.setF60177(f60177);
				vf601.setF60178(f60178);
				vf601.setF60179(f60179);
				vf601.setF60187(f60187);
				vf601.setF60188(f60188);
				vf601.setF60189(f60189);
				vf601s.add(vf601);
			}
			f601Response.setVf601s(vf601s);
			f601Response.setState(true);
		} catch (Exception e) {
			f601Response.setErrorMessage("查询失败! ");
			e.printStackTrace();
			f601Response.setState(false);
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
		return f601Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public F601Response deleteF601(F601Request f601Request) {
		F601Response f601Response = new F601Response();
		String d60101 = f601Request.getF601().getF60101();

		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		List<Object> listF602 = null;
		try {
			StringBuffer sql = new StringBuffer(
					"select * from f602 t where t.f602_02 ='" + d60101 + "'");
			SQLQuery sqlQuery = session.createSQLQuery(sql.toString());

			listF602 = sqlQuery.list();
			if (listF602.size() > 0) {
				f601Response.setErrorMessage("血清学检查报告已保存，不能修改!");
				state = false;
			}
		} catch (Exception e) {
			f601Response.setErrorMessage("删除失败! ");
			e.printStackTrace();
			state = false;
		}
		if (state) {
			try {
				F601 f601 = new F601();
				f601.setF60101(d60101);
				session.delete(f601);
			} catch (Exception e) {
				f601Response.setErrorMessage("删除失败! ");
				e.printStackTrace();
				state = false;
			}
		}
		f601Response.setState(state);
		return f601Response;
	}

	@Override
	public F601Response renewF601(F601Request f601Request) {
		F601Response f601Response = new F601Response();
		F601 _f601 = f601Request.getF601();
		Date f60157 = _f601.getF60157();
		String f60158 = _f601.getF60158();
		String f60159 = _f601.getF60159();
		Date f60160 = _f601.getF60160();
		String f60161 = _f601.getF60161();
		String f60162 = _f601.getF60162();
		String f60163 = _f601.getF60163();
		String f60164 = _f601.getF60164();
		String f60165 = _f601.getF60165();
		Date f60166 = _f601.getF60166();
		List<String> list = f601Request.getF60101List();
		F601 f601 = null;
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			int count = 0;
			int fail = 0;// 邮寄失败计数器
			for (String f60101 : list) {
				f601 = (F601) session.get(F601.class, f60101);
				if (f601 != null) {
					count++;
					if ("2".equals(f60159)) {
						f601.setF60157(f60157);
						f601.setF60158(f60158);
					} else if ("3".equals(f60159)) {
						f601.setF60160(f60160);
						f601.setF60161(f60161);
						f601.setF60162(f60162);
						f601.setF60163(f60163);
						f601.setF60164(f60164);
						f601.setF60177(setF60177(f60163, session));
					} else if ("4".equals(f60159)) {
						f601.setF60161(f60161);
						f601.setF60165(f60165);
						f601.setF60166(f60166);

					}
					f601.setF60159(f60159);
					session.saveOrUpdate(f601);
					session.flush();
					session.refresh(f601);
					saveF602(f601, session);
					if (count % 20 == 0)
						session.clear();
				} else {
					fail++;
				}
			}
			String message = null;
			if (fail == 0) {
				if ("2".equals(f60159))
					message = "邮寄成功";
				else if ("3".equals(f60159)) {
					message = "已审核成功";
				} else if ("4".equals(f60159))
					message = "退回成功";
			} else {
				if ("2".equals(f60159))
					message = "邮寄成功" + (list.size() - fail) + "条，" + "邮寄失败"
							+ fail + "条";
				else if ("3".equals(f60159))
					message = "已审核成功" + (list.size() - fail) + "条，" + "已审核失败"
							+ fail + "条";
				else if ("4".equals(f60159))
					message = "退回成功" + (list.size() - fail) + "条，" + "退回成功失败"
							+ fail + "条";

			}
			f601Response.setPromptMessage(message);

		} catch (Exception e) {
			state = false;
			f601Response.setErrorMessage(e.getMessage());
		}
		f601Response.setState(state);
		return f601Response;
	}

	/**
	 * 设置血卡编号
	 * 
	 * @return String
	 */
	private synchronized String getF60155() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(new Date()).substring(2);
		String length = "000001";
		Session session = sessionFactory.getCurrentSession();
		String f60155 = (String) session.createSQLQuery(
				"select max(substr(t.f601_55,3)) from f601 t where t.f601_55 like '"
						+ year + "______'").uniqueResult();
		if (f60155 != null) {
			String num = String.valueOf(Integer.parseInt(f60155) + 1);
			f60155 = year + length.substring(0, 6 - num.length()) + num;
		} else
			f60155 = year + length;
		return f60155;
	}

	/**
	 * 审核保存f602
	 * 
	 */
	@SuppressWarnings("unused")
	private void saveF602(F601 f601, Session session) {
		try {
			if ("3".equals(f601.getF60159())) {
				String f60201 = (String) session.createSQLQuery(
						"select f602_01 from f602 where f602_02='"
								+ f601.getF60101() + "'").uniqueResult();
				if (f60201 != null)
					return;
				F602 f602 = new F602();
				f602.setF60202(f601.getF60101());
				f602.setF60203(f601.getF60103());
				f602.setF60204(f601.getF60104());
				// f602.setF60206(f601.getF60177());
				f602.setF60205(f601.getF60155());
				f602.setF60230(f601.getF60177());
				session.save(f602);
				session.flush();
				session.refresh(f602);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 生成样本号 格式 yyyymmdd+4位流水
	 * 
	 * @return
	 */
	private String setF60177(String f60163, Session session) {
		String dateString = new SimpleDateFormat("yyMMdd").format(new Date());
		String length = "0001";
		String f60177 = (String) session.createSQLQuery(
				"select max(substr(t.f601_77,7)) "
						+ "from f601 t where t.f601_77 like '" + dateString
						+ "____' and t.f601_63=" + f60163).uniqueResult();
		if (f60177 != null) {
			String num = String.valueOf(Integer.parseInt(f60177) + 1);
			f60177 = dateString + length.substring(0, 4 - num.length()) + num;
		} else
			f60177 = dateString + length;
		return f60177;
	}

	@SuppressWarnings("unchecked")
	@Override
	public F601Response queryF601Excel(F601Request f601Request) {
		boolean state = false;
		String message = null;
		String flag = f601Request.getFlag();
		F601 f601 = f601Request.getF601();
		String f60103 = f601.getF60103();
		String f60104 = f601.getF60104();
		String f60129 = f601.getF60129();
		// String f60129 = "41130200000008";
		Date timeStr = f601Request.getTimeStr();
		Date timeEnd = f601Request.getTimeEnd();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		F601Response f601Response = new F601Response();
		try {
			Session session = sessionFactory.getCurrentSession();
			StringBuffer sql = new StringBuffer(
					"select t.* from v_f601 t where t.F601_29='" + f60129
							+ "' and t.F601_59='3'");
			if ("false".equals(flag)) {
				sql.append("and to_char(t.F601_60,'yyyy-mm-dd')>='"
						+ sdf.format(timeStr) + "'"
						+ " and to_char(t.F601_60,'yyyy-mm-dd')<='"
						+ sdf.format(timeEnd) + "'");
			} else if ("true".equals(flag)) {

				if (!StringUtil.isBlankString(f60103)) {
					sql.append(" and t.F601_03 ='" + f60103 + "'");
				}
				if (!StringUtil.isBlankString(f60104)) {
					sql.append(" and t.F601_04 ='" + f60104 + "'");
				}
			}
			sql.append(" order by t.F601_77");
			f601Response.setSessionInfo(sql.toString());
			List<VF601> list = session.createSQLQuery(sql.toString())
					.addEntity(VF601.class).list();
			int count = list.size();
			if (count > 0) {
				message = "查询到" + count + "数据";
				f601Response.setVf601s(list);
			} else
				message = "暂无数据";
			state = true;
			f601Response.setRowCount(count);
			f601Response.setPromptMessage(message);

		} catch (Exception e) {
			message = e.getMessage();
			f601Response.setErrorMessage(message);
		}
		f601Response.setState(state);
		return f601Response;
	}

	@Override
	public F601Response queryByF60155(String f60155) {
		F601Response f601Response = new F601Response();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			VF601 vf601 = (VF601) session.createSQLQuery(
					"select t.* from v_f601 t where t.F601_55=?").addEntity(
					VF601.class).setString(0, f60155).uniqueResult();
			if (vf601 != null) {
				f601Response.setRowCount(1);
				List<VF601> vf601s = new ArrayList<VF601>();
				vf601s.add(vf601);
				f601Response.setVf601s(vf601s);
			} else
				f601Response.setRowCount(0);
		} catch (Exception e) {
			state = false;
			f601Response.setErrorMessage(e.getMessage());
		}
		f601Response.setState(state);
		return f601Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public F601Response queryRevocationF601(F601Request f601Request) {
		boolean state = false;
		F601 f601 = f601Request.getF601();
		String f60103 = f601.getF60103();
		String f60104 = f601.getF60104();
		String f60109 = f601.getF60109();
		String f60129 = f601.getF60129();
		String flag = f601Request.getFlag();
		Date timeStart = f601Request.getTimeStr();
		Date timeEnd = f601Request.getTimeEnd();
		F601Response f601Response = new F601Response();
		int pageIndex = f601Request.getParameterPageindex();
		int pageSize = f601Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();

		if ("true".equals(flag)) {
			if (!StringUtil.isBlankString(f60103)) {
				parameterConditionwhere.append("and f1.f601_03='" + f60103
						+ "'");
			}
			if (!StringUtil.isBlankString(f60104)) {
				parameterConditionwhere.append("and f1.f601_04='" + f60104
						+ "'");
			}
			if (!StringUtil.isBlankString(f60109)) {
				parameterConditionwhere.append("and f1.f601_09='" + f60109
						+ "'");
			}
		}

		if ("false".equals(flag)) {
			if (timeStart != null) {
				parameterConditionwhere
						.append("and to_char(f1.f601_26,'yyyy-mm-dd') >='"
								+ sdf.format(timeStart) + "'");
			}
			if (timeEnd != null) {
				parameterConditionwhere
						.append("and to_char(f1.f601_26,'yyyy-mm-dd') <= '"
								+ sdf.format(timeEnd) + "'");
			}
		}

		if (!StringUtil.isBlankString(f60129)) {
			if (f60129.length() == 14) {
				parameterConditionwhere.append(" and f1.f601_29 = '");
				parameterConditionwhere.append(f60129);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and f1.f601_29 like '");
				parameterConditionwhere.append(f60129);
				parameterConditionwhere.append("%'");
			}
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			List<String> f60104List = session
					.createSQLQuery(
							"select f601_04 from f601 f1 "
									+ "where f601_59='4' and not exists (select f601_04 from f601 f2 where "
									+ "f1.f601_04=f2.f601_04 and f601_59! ='4')"
									+ parameterConditionwhere
									+ " group by f601_04").setFirstResult(
							(pageIndex - 1) * pageSize).setMaxResults(pageSize)
					.list();

			if (f60104List.size() > 0) {
				VF601 vf601 = null;
				List<VF601> vf601s = new ArrayList<VF601>();
				for (String _f60104 : f60104List) {

					vf601 = (VF601) session
							.createSQLQuery(
									"select * from v_f601 a "
											+ "where f601_04 = '"
											+ _f60104
											+ "' and f601_34="
											+ "(select  max(f601_34) from v_f601 t where f601_04 = "
											+ "'" + _f60104 + "' )and rownum=1")
							.addEntity(VF601.class).uniqueResult();
					vf601s.add(vf601);

				}
				state = true;
				f601Response.setVf601s(vf601s);
				f601Response.setRowCount(f60104List.size());
				f601Response.setPromptMessage("查询成功");

			} else {
				f601Response.setErrorMessage("暂无数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			f601Response.setErrorMessage("查询失败");
		}
		f601Response.setState(state);
		return f601Response;
	}

	/**
	 * 以前的查询方法无法多次重用
	 */
	@SuppressWarnings("unchecked")
	@Override
	public F601Response queryF601_(F601Request f601Request) {
		boolean state = true;
		F601 f601 = f601Request.getF601();
		String f60103_ = f601.getF60103();
		String f60104_ = f601.getF60104();
		String f60129_ = f601.getF60129();
		String f60131_ = f601.getF60131();
		String f60159_ = f601.getF60159();
		Date timeStr_ = f601Request.getTimeStr();
		Date timeEnd_ = f601Request.getTimeEnd();
		F601Response f601Response = new F601Response();
		List<String> list = f601Request.getF60101List();// 用来传递字段名称
		int pageIndex = f601Request.getParameterPageindex();
		int pageSize = f601Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Session session = sessionFactory.getCurrentSession();
		StringBuffer parameterConditionwhere = new StringBuffer();
		try {

			if (!StringUtil.isBlankString(f60103_)) {
				parameterConditionwhere.append("and t.f601_03 ='" + f60103_
						+ "' ");
			}
			if (!StringUtil.isBlankString(f60104_)) {
				parameterConditionwhere.append("and t.f601_04 ='" + f60104_
						+ "' ");
			}

			if (!StringUtil.isBlankString(f60159_)) {
				parameterConditionwhere.append("and t.f601_59 ='" + f60159_
						+ "' ");
			}
			if (timeStr_ != null) {
				String timeStr = sdf.format(timeStr_);
				parameterConditionwhere.append(" and to_char(" + list.get(0)
						+ ",'yyyy-mm-dd') >= '" + timeStr + "'");
			}
			if (timeEnd_ != null) {
				String timeEnd = sdf.format(timeEnd_);
				parameterConditionwhere.append(" and to_char(" + list.get(0)
						+ ",'yyyy-mm-dd') <= '" + timeEnd + "'");
			}

			if (!StringUtil.isBlankString(f60129_)) {
				if (f60129_.length() == 14) {
					parameterConditionwhere.append(" and t.f601_29 = '");
					parameterConditionwhere.append(f60129_);
					parameterConditionwhere.append("'");
				} else {
					parameterConditionwhere.append(" and t.f601_29 like '");
					parameterConditionwhere.append(f60129_);
					parameterConditionwhere.append("%'");
				}
			}

			if (!StringUtil.isBlankString(f60131_)) {
				if (f60131_.length() == 14) {
					parameterConditionwhere.append(" and t.f601_31 = '");
					parameterConditionwhere.append(f60131_);
					parameterConditionwhere.append("'");
				} else {
					parameterConditionwhere.append(" and t.f601_31 like '");
					parameterConditionwhere.append(f60131_);
					parameterConditionwhere.append("%'");
				}
			}

			Object rowCount = session.createSQLQuery(
					"select count(*) from v_f601 t where 1=1 "
							+ parameterConditionwhere.toString())
					.uniqueResult();
			List<VF601> vf601s = (List<VF601>) session.createSQLQuery(
					"select * from v_f601 t where 1=1 "
							+ parameterConditionwhere.append(
									"order by f601_34,f601_01").toString())
					.addEntity(VF601.class).setFirstResult(
							(pageIndex - 1) * pageSize).setMaxResults(pageSize)
					.list();
			f601Response.setRowCount(Long.valueOf(rowCount.toString()));
			f601Response.setVf601s(vf601s);
		} catch (Exception e) {
			state = false;
			f601Response.setErrorMessage(e.getMessage());
		}
		f601Response.setState(state);
		return f601Response;
	}

}
