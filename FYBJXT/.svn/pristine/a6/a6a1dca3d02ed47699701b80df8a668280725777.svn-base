package com.xyw.medical.etbj.screening.dao.impl;

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

import com.xyw.medical.etbj.model.E302;
import com.xyw.medical.etbj.model.VE302;
import com.xyw.medical.etbj.model.E302Request;
import com.xyw.medical.etbj.model.E302Response;
import com.xyw.medical.etbj.screening.dao.E302Dao;
import com.xyw.sys.util.StringUtil;

public class E302DaoImpl implements E302Dao {
	@Resource
	public SessionFactory sessionFactory;

	@Resource
	public DataSource dataSource;

	@Override
	public E302Response savaE302(E302 e302) {
		E302Response e302Response = new E302Response();
		long e302_02 = e302.getE30202();
		long e302_38 = e302.getE30238();
		String e302_08 = e302.getE30208();

		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {

			StringBuffer sql = new StringBuffer(
					"select * from E302 t where 1=1");
			if (e302_02 != 0) {
				sql.append(" and t.e302_02 = '" + e302_02 + "'");
			}
//			if (e302_38 != 0) {
//				sql.append(" and t.e302_38 = '" + e302_38 + "'");
//			}
			if (!StringUtil.isBlankString(e302_08)) {
				sql.append("and t.e302_08 ='" + e302_08 + "' ");
			}

			SQLQuery query = session.createSQLQuery(sql.toString());
			List<E302> e302s = query.addEntity(E302.class).list();
			if (e302s.size() > 0) {
				state = false;
				e302Response.setErrorMessage("重复保存！");
			}
		} catch (Exception e) {
			state = false;
			e302Response.setErrorMessage("保存出错! ");
			e.printStackTrace();
		}
		if (state) {
			try {
				session.save(e302);
				session.flush();
				session.refresh(e302);
			} catch (Exception e) {
				state = false;
				e302Response.setErrorMessage("保存出错! ");
				e.printStackTrace();
			}
		}

		e302Response.setState(state);
		return e302Response;
	}

	@Override
	public E302Response renewE302(E302 e302) {
		E302Response e302Response = new E302Response();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(e302);
		} catch (Exception e) {
			state = false;
			e302Response.setErrorMessage("修改失败！");
			e.printStackTrace();
		}

		e302Response.setState(state);
		return e302Response;
	}

	@Override
	public E302Response deleteE302(E302Request e302Request) {
		E302Response e302Response = new E302Response();
		long e30201 = e302Request.getE30201();

		try {
			Session session = sessionFactory.getCurrentSession();
			E302 e302 = new E302();
			e302.setE30201(e30201);
			session.delete(e302);
			e302Response.setPromptMessage("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			e302Response.setPromptMessage("删除失败！");
		}
		return e302Response;
	}

	@Override
	public E302Response queryE302(E302Request e302Request) {
		E302Response e302Response = new E302Response();
		long e30201_ = e302Request.getE30201();
		long e30202_ = e302Request.getE30202();
		String e30208_ = e302Request.getE30208();
		String e30237_ = e302Request.getE30237();
		long e30238_ = e302Request.getE30238();
		Date e30231Start_ = e302Request.getE30231Start();
		Date e30231End_ = e302Request.getE30231End();

		String flag = e302Request.getFlag();
		int parameterPageindex = e302Request.getParameterPageindex();
		int parameterPagesize = e302Request.getParameterPagesize();

		String e30103_ = e302Request.getE30103();
		String e30113_ = e302Request.getE30113();
		String e30117_ = e302Request.getE30117();
		String e30102_ = e302Request.getF30102();
		String e30105_ = e302Request.getF30105();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		StringBuffer sql = new StringBuffer();
		if (e30202_ != 0) {
			sql.append(" and t.e302_02 = '" + e30202_ + "'");
		}
		if (!StringUtil.isBlankString(e30208_)) {
			sql.append("and t.e302_08 ='" + e30208_ + "' ");
		}
		if (e30238_ != 0) {
			sql.append(" and t.e302_38 = '" + e30238_ + "'");
		}
		if (e30231Start_ != null) {
			String e30231Start = sdf.format(e30231Start_);
			sql.append(" and t.e302_31_str >= '" + e30231Start + "'");
		}
		if (e30231End_ != null) {
			String e30231End = sdf.format(e30231End_);
			sql.append(" and t.e302_31_str <= '" + e30231End + "'");

		}
		if (!StringUtil.isBlankString(e30237_)) {
			if (e30237_.length() == 14) {
				sql.append(" and t.e302_37 = '");
				sql.append(e30237_);
				sql.append("'");
			} else {
				sql.append(" and t.e302_37 like '");
				sql.append(e30237_);
				sql.append("%'");
			}
		}
		if (!StringUtil.isBlankString(e30103_)) {
			sql.append("and t.e301_03 ='" + e30103_ + "' ");
		}
		if (!StringUtil.isBlankString(e30113_)) {
			sql.append("and t.e301_13 ='" + e30113_ + "' ");
		}
		if (!StringUtil.isBlankString(e30117_)) {
			sql.append("and t.e301_17 ='" + e30117_ + "' ");
		}
		if (!StringUtil.isBlankString(e30102_)) {
			sql.append("and t.e301_02 ='" + e30102_ + "' ");
		}
		if (!StringUtil.isBlankString(e30105_)) {
			sql.append("and t.e301_05 ='" + e30105_ + "' ");
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
			callableStatement.setString(3, "V_E302");
			callableStatement.setString(4, sql.toString());
			callableStatement.setString(5, "t.E302_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			e302Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);

			VE302 ve302 = null;
			List<VE302> ve302s = new ArrayList<VE302>();
			while (resultSet.next()) {
				long e30201 = resultSet.getLong("E302_01");
				long e30202 = resultSet.getLong("E302_02");
				String e30203 = resultSet.getString("E302_03");
				Date e30204 = resultSet.getDate("E302_04");
				String e30205 = resultSet.getString("E302_05");
				String e30206 = resultSet.getString("E302_06");
				String e30207 = resultSet.getString("E302_07");
				String e30208 = resultSet.getString("E302_08");
				Date e30209 = resultSet.getDate("E302_09");
				String e30210 = resultSet.getString("E302_10");
				String e30211 = resultSet.getString("E302_11");
				String e30212 = resultSet.getString("E302_12");
				String e30213 = resultSet.getString("E302_13");
				String e30214 = resultSet.getString("E302_14");
				Date e30215 = resultSet.getDate("E302_15");
				String e30216 = resultSet.getString("E302_16");
				String e30217 = resultSet.getString("E302_17");
				String e30218 = resultSet.getString("E302_18");
				String e30219 = resultSet.getString("E302_19");
				String e30220 = resultSet.getString("E302_20");
				Date e30221 = resultSet.getDate("E302_21");
				String e30222 = resultSet.getString("E302_22");
				String e30223 = resultSet.getString("E302_23");
				String e30224 = resultSet.getString("E302_24");
				Date e30225 = resultSet.getDate("E302_25");
				String e30226 = resultSet.getString("E302_26");
				String e30227 = resultSet.getString("E302_27");
				String e30228 = resultSet.getString("E302_28");
				String e30229 = resultSet.getString("E302_29");
				String e30230 = resultSet.getString("E302_30");
				Date e30231 = resultSet.getDate("E302_31");
				String e30232 = resultSet.getString("E302_32");
				String e30233 = resultSet.getString("E302_33");
				String e30234 = resultSet.getString("E302_34");
				String e30235 = resultSet.getString("E302_35");
				String e30236 = resultSet.getString("E302_36");
				String e30237 = resultSet.getString("E302_37");
				long e30238 = resultSet.getLong("E302_38");
				String e30239 = resultSet.getString("E302_39");
				String e30240 = resultSet.getString("E302_40");
				String e30241 = resultSet.getString("E302_41");
				String e30242 = resultSet.getString("E302_42");
				String e30243 = resultSet.getString("E302_43");
				String e30244 = resultSet.getString("E302_44");
				String e30245 = resultSet.getString("E302_45");
				String e30246 = resultSet.getString("E302_46");
				String e30247 = resultSet.getString("E302_47");
				String e30248 = resultSet.getString("E302_48");
				String e30249 = resultSet.getString("E302_49");
				String e30250 = resultSet.getString("E302_50");

				String e30204Str = resultSet.getString("E302_04_Str");
				String e30207Zh = resultSet.getString("E302_07_ZH");
				String e30209Str = resultSet.getString("E302_09_Str");
				String e30213Zh = resultSet.getString("E302_13_ZH");
				String e30215Str = resultSet.getString("E302_15_Str");
				String e30219Zh = resultSet.getString("E302_19_ZH");
				String e30221Str = resultSet.getString("E302_21_Str");
				String e30224Zh = resultSet.getString("E302_24_ZH");
				String e30225Str = resultSet.getString("E302_25_Str");
				String e30228Zh = resultSet.getString("E302_28_ZH");
				String e30231Str = resultSet.getString("E302_31_Str");
				String e30237Zh = resultSet.getString("E302_37_ZH");

				String e30103 = resultSet.getString("E301_03");
				String e30104 = resultSet.getString("E301_04");
				String e30104Zh = resultSet.getString("E301_04_ZH");
				String e30105 = resultSet.getString("E301_05");
				Date e30106 = resultSet.getDate("E301_06");
				String e30106Str = resultSet.getString("e301_06_Str");
				String e30113 = resultSet.getString("E301_13");
				String e30117 = resultSet.getString("E301_17");

				String f30102 = resultSet.getString("F301_02");
				String f30104 = resultSet.getString("F301_04");
				String f30105 = resultSet.getString("F301_05");
				Date f30106 = resultSet.getDate("F301_06");
				String f30106Str = resultSet.getString("F301_06_Str");
				String f30113 = resultSet.getString("F301_13");
				String f30135 = resultSet.getString("F301_35");
				String f30135Zh = resultSet.getString("F301_35_ZH");

				ve302 = new VE302();
				ve302.setE30201(e30201);
				ve302.setE30202(e30202);
				ve302.setE30203(e30203);
				ve302.setE30204(e30204);
				ve302.setE30205(e30205);
				ve302.setE30206(e30206);
				ve302.setE30207(e30207);
				ve302.setE30208(e30208);
				ve302.setE30209(e30209);
				ve302.setE30210(e30210);
				ve302.setE30211(e30211);
				ve302.setE30212(e30212);
				ve302.setE30213(e30213);
				ve302.setE30214(e30214);
				ve302.setE30215(e30215);
				ve302.setE30216(e30216);
				ve302.setE30217(e30217);
				ve302.setE30218(e30218);
				ve302.setE30219(e30219);
				ve302.setE30220(e30220);
				ve302.setE30221(e30221);
				ve302.setE30222(e30222);
				ve302.setE30223(e30223);
				ve302.setE30224(e30224);
				ve302.setE30225(e30225);
				ve302.setE30226(e30226);
				ve302.setE30227(e30227);
				ve302.setE30228(e30228);
				ve302.setE30229(e30229);
				ve302.setE30230(e30230);
				ve302.setE30231(e30231);
				ve302.setE30232(e30232);
				ve302.setE30233(e30233);
				ve302.setE30234(e30234);
				ve302.setE30235(e30235);
				ve302.setE30236(e30236);
				ve302.setE30237(e30237);
				ve302.setE30238(e30238);
				ve302.setE30239(e30239);
				ve302.setE30240(e30240);
				ve302.setE30241(e30241);
				ve302.setE30242(e30242);
				ve302.setE30243(e30243);
				ve302.setE30244(e30244);
				ve302.setE30245(e30245);
				ve302.setE30246(e30246);
				ve302.setE30247(e30247);
				ve302.setE30248(e30248);
				ve302.setE30249(e30249);
				ve302.setE30250(e30250);

				ve302.setE30204Str(e30204Str);
				ve302.setE30207Zh(e30207Zh);
				ve302.setE30209Str(e30209Str);
				ve302.setE30213Zh(e30213Zh);
				ve302.setE30215Str(e30215Str);
				ve302.setE30219Zh(e30219Zh);
				ve302.setE30221Str(e30221Str);
				ve302.setE30224Zh(e30224Zh);
				ve302.setE30225Str(e30225Str);
				ve302.setE30228Zh(e30228Zh);
				ve302.setE30231Str(e30231Str);
				ve302.setE30237Zh(e30237Zh);

				ve302.setE30103(e30103);
				ve302.setE30104(e30104);
				ve302.setE30104Zh(e30104Zh);
				ve302.setE30105(e30105);
				ve302.setE30106(e30106);
				ve302.setE30106Str(e30106Str);
				ve302.setE30113(e30113);
				ve302.setE30117(e30117);

				ve302.setF30102(f30102);
				ve302.setF30104(f30104);
				ve302.setF30105(f30105);
				ve302.setF30106(f30106);
				ve302.setF30106Str(f30106Str);
				ve302.setF30113(f30113);
				ve302.setF30135(f30135);
				ve302.setF30135Zh(f30135Zh);

				ve302s.add(ve302);
			}
			e302Response.setState(state);
			e302Response.setVe302s(ve302s);
		} catch (Exception e) {
			e.printStackTrace();
			e302Response.setState(false);
			e302Response.setErrorMessage("查询失败！");
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
		return e302Response;
	}

}
