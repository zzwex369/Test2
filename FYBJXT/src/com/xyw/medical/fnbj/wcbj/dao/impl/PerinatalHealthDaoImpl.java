package com.xyw.medical.fnbj.wcbj.dao.impl;

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

import com.xyw.medical.fnbj.model.F302;
import com.xyw.medical.fnbj.model.F302Request;
import com.xyw.medical.fnbj.model.F302Response;
import com.xyw.medical.fnbj.model.VF302;
import com.xyw.medical.fnbj.wcbj.dao.PerinatalHealthDao;
import com.xyw.sys.util.StringUtil;

public class PerinatalHealthDaoImpl implements PerinatalHealthDao {

	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;

	@SuppressWarnings("unchecked")
	@Override
	public F302Response saveF302(F302 f302) {
		F302Response f302Response = new F302Response();
		long f30202 = f302.getF30202();
		String f30203 = f302.getF30203();
		String f30204 = f302.getF30204();
		String f30205 = f302.getF30205();
		String f30207 = f302.getF30207();   //保健卡号
		Date f30252 =f302.getF30252();   //建册日期
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			StringBuffer sql = new StringBuffer("select * from F302 t where 1=1 ");
			if (f30202 > 0) {
				sql.append("and t.f302_02 ='" + f30202 + "' ");
			}
			if (!StringUtil.isBlankString(f30203)) {
				sql.append("and t.f302_03 ='" + f30203 + "' ");
			}
			if (!StringUtil.isBlankString(f30204)) {
				sql.append("and t.f302_04 ='" + f30204 + "' ");
			}
			if (!StringUtil.isBlankString(f30205)) {
				sql.append("and t.f302_05 ='" + f30205 + "' ");
			}
//			if (!StringUtil.isBlankString(f30207)) {
//				sql.append("and t.f302_07 ='" + f30207 + "' ");
//			}
			if (f30252 != null) {
				String f30252_ = sdf.format(f30252);
				sql.append(" and to_char(t.f302_52,'yyyy-MM-dd') ='" + f30252_ + "' ");
			}
			SQLQuery query = session.createSQLQuery(sql.toString());
			List<F302> f302s = query.addEntity(F302.class).list();
			if (f302s.size() > 0) {
				state = false;
				f302Response.setErrorMessage("重复保存！");
			}
		} catch (Exception e) {
			state = false;
			f302Response.setErrorMessage("保存出错! ");
			e.printStackTrace();
		}
		if (state) {
			try {
				Date systemTime =new Date();
				f302.setF30259(systemTime);
				session.save(f302);
				session.flush();
				session.refresh(f302);
			} catch (Exception e) {
				state = false;
				f302Response.setErrorMessage("保存出错! ");
				e.printStackTrace();
			}
		}

		f302Response.setState(state);
		return f302Response;
	}

	@Override
	public F302Response renewF302(F302 f302) {
		F302Response f302Response = new F302Response();
		Session session = sessionFactory.getCurrentSession();
		boolean state = true;
		try {
			session.saveOrUpdate(f302);
		} catch (Exception e) {
			state = false;
			e.printStackTrace();
			f302Response.setErrorMessage("修改失败！");
		}
		f302Response.setState(state);
		return f302Response;
	}


	@Override
	public F302Response queryF302(F302Request f302Request) {
		F302Response f302Response = new F302Response();
		Date f30253Start_ = f302Request.getF30253Start();
		Date f30253End_ = f302Request.getF30253End();
		Date f30259Start_ = f302Request.getF30259Start();
		Date f30259End_ = f302Request.getF30259End();
		long f302_02 = f302Request.getF30202();
		String f302_03 = f302Request.getF30203();
		String f302_05 = f302Request.getF30205();
		String f302_07 = f302Request.getF30207();
		String f302_50 = f302Request.getF30250();

		int parameterPageindex = f302Request.getParameterPageindex();
		int parameterPagesize = f302Request.getParameterPagesize();
		String flag = f302Request.getFlag();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		StringBuffer parameterConditionwhere = new StringBuffer();
		if (f30253Start_ != null) {
			String f30253Start = sdf.format(f30253Start_);
			parameterConditionwhere.append(" and t.f302_53_str >= '"
					+ f30253Start + "'");
		}
		if (f30253End_ != null) {
			String f30253End = sdf.format(f30253End_);
			parameterConditionwhere.append(" and t.f302_53_str <= '"
					+ f30253End + "'");
		}
		if (f30259Start_ != null) {
			String f30259Start = sdf.format(f30259Start_);
			parameterConditionwhere.append(" and t.f302_59_str >= '"
					+ f30259Start + "'");
		}
		if (f30259End_ != null) {
			String f30259End = sdf.format(f30259End_);
			parameterConditionwhere.append(" and t.f302_59_str <= '"
					+ f30259End + "'");
		}
		if (f302_02 != 0) {
			parameterConditionwhere
					.append(" and t.f302_02 = '" + f302_02 + "'");
		}
		if (!StringUtil.isBlankString(f302_03)) {
			parameterConditionwhere
					.append(" and t.f302_03 = '" + f302_03 + "'");
		}
		if (!StringUtil.isBlankString(f302_05)) {
			parameterConditionwhere
					.append(" and t.f302_05 = '" + f302_05 + "'");
		}
		if (!StringUtil.isBlankString(f302_07)) {
			parameterConditionwhere
					.append(" and t.f302_07 = '" + f302_07 + "'");
		}
		if (!StringUtil.isBlankString(f302_50)) {
			if (f302_50.length() == 14) {
				parameterConditionwhere.append(" and t.f302_50 = '");
				parameterConditionwhere.append(f302_50);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.f302_50 like '");
				parameterConditionwhere.append(f302_50);
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
			callableStatement.setString(3, "V_F302");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.F302_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			f302Response.setRowCount(rowCount);
			f302Response.setState(state);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VF302 vf302 = null;
			List<VF302> vf302s = new ArrayList<VF302>();
			while (resultSet.next()) {
				long f30201 = resultSet.getLong("F302_01");
				long f30202 = resultSet.getLong("F302_02");
				String f30203 = resultSet.getString("F302_03");
				String f30204 = resultSet.getString("F302_04");
				String f30205 = resultSet.getString("F302_05");
				long f30206 = resultSet.getLong("F302_06");
				String f30207 = resultSet.getString("F302_07");
				Date f30208 = resultSet.getDate("F302_08");
				long f30209 = resultSet.getLong("F302_09");
				String f30210 = resultSet.getString("F302_10");
				long f30211 = resultSet.getLong("F302_11");
				long f30212 = resultSet.getLong("F302_12");
				long f30213 = resultSet.getLong("F302_13");
				String f30214 = resultSet.getString("F302_14");
				String f30215 = resultSet.getString("F302_15");
				Date f30216 = resultSet.getDate("F302_16");
				long f30217 = resultSet.getLong("F302_17");
				long f30218 = resultSet.getLong("F302_18");
				long f30219 = resultSet.getLong("F302_19");
				long f30220 = resultSet.getLong("F302_20");
				long f30221 = resultSet.getLong("F302_21");
				long f30222 = resultSet.getLong("F302_22");
				long f30223 = resultSet.getLong("F302_23");
				long f30224 = resultSet.getLong("F302_24");
				long f30225 = resultSet.getLong("F302_25");
				long f30226 = resultSet.getLong("F302_26");
				long f30227 = resultSet.getLong("F302_27");
				long f30228 = resultSet.getLong("F302_28");
				long f30229 = resultSet.getLong("F302_29");
				Date f30230 = resultSet.getDate("F302_30");
				String f30231 = resultSet.getString("F302_31");
				Date f30232 = resultSet.getDate("F302_32");
				String f30233 = resultSet.getString("F302_33");
				String f30234 = resultSet.getString("F302_34");
				String f30235 = resultSet.getString("F302_35");
				String f30236 = resultSet.getString("F302_36");
				String f30237 = resultSet.getString("F302_37");
				String f30238 = resultSet.getString("F302_38");
				String f30239 = resultSet.getString("F302_39");
				String f30240 = resultSet.getString("F302_40");
				String f30241 = resultSet.getString("F302_41");
				String f30242 = resultSet.getString("F302_42");
				String f30243 = resultSet.getString("F302_43");
				String f30244 = resultSet.getString("F302_44");
				String f30245 = resultSet.getString("F302_45");
				String f30246 = resultSet.getString("F302_46");
				String f30247 = resultSet.getString("F302_47");
				String f30248 = resultSet.getString("F302_48");
				String f30249 = resultSet.getString("F302_49");
				String f30250 = resultSet.getString("F302_50");
				String f30251 = resultSet.getString("F302_51");
				Date f30252 = resultSet.getDate("F302_52");
				Date f30253 = resultSet.getDate("F302_53");
				long f30254 = resultSet.getLong("F302_54");
				String f30255 = resultSet.getString("F302_55");
				String f30256 = resultSet.getString("F302_56");
				String f30257 = resultSet.getString("F302_57");
				String f30258 = resultSet.getString("F302_58");
				Date f30259 = resultSet.getDate("F302_59");
				String f30260 = resultSet.getString("F302_60");
				String f30261 = resultSet.getString("F302_61");
				String f30262 = resultSet.getString("F302_62");
				String f30263 = resultSet.getString("F302_63");
				String f30264 = resultSet.getString("F302_64");
				String f30265 = resultSet.getString("F302_65");
				String f30266 = resultSet.getString("F302_66");
				String f30267 = resultSet.getString("F302_67");
				String f30268 = resultSet.getString("F302_68");
				String f30269 = resultSet.getString("F302_69");
				String f30270 = resultSet.getString("F302_70");

				String f30204Zh = resultSet.getString("F302_04_ZH");
				String f30208Str = resultSet.getString("F302_08_Str");
				String f30210Zh = resultSet.getString("F302_10_ZH");
				String f30214Zh = resultSet.getString("F302_14_ZH");
				String f30215Zh = resultSet.getString("F302_15_ZH");
				String f30216Str = resultSet.getString("F302_16_Str");
				String f30230Str = resultSet.getString("F302_30_Str");
				String f30232Str = resultSet.getString("F302_32_Str");
				String f30233Zh = resultSet.getString("F302_33_ZH");
				// String f30236Zh =resultSet.getString("F302_36_ZH");
				String f30238Zh = resultSet.getString("F302_38_ZH");
				String f30240Zh = resultSet.getString("F302_40_ZH");
				String f30242Zh = resultSet.getString("F302_42_ZH");
				// String f30245Zh =resultSet.getString("F302_45_ZH");
				// String f30248Zh =resultSet.getString("F302_48_ZH");
				String f30250Zh = resultSet.getString("F302_50_ZH");
				String f30252Str = resultSet.getString("F302_52_Str");
				String f30253Str = resultSet.getString("F302_53_Str");
				String f30256Zh = resultSet.getString("F302_56_ZH");
				String f30259Str = resultSet.getString("F302_59_Str");

				String f30108 = resultSet.getString("F301_08");
				String f30117 = resultSet.getString("F301_17");
				String f30102 = resultSet.getString("F301_02");
				String f30104 = resultSet.getString("F301_04");
				String f30105 = resultSet.getString("F301_05");
				Date f30106 = resultSet.getDate("F301_06");
				String f30106Str = resultSet.getString("F301_06_Str");
				String f30113 = resultSet.getString("F301_13");
				String f30135 = resultSet.getString("F301_35");
				String f30135Zh = resultSet.getString("F301_35_ZH");

				vf302 = new VF302();
				vf302.setF30201(f30201);
				vf302.setF30202(f30202);
				vf302.setF30203(f30203);
				vf302.setF30204(f30204);
				vf302.setF30205(f30205);
				vf302.setF30206(f30206);
				vf302.setF30207(f30207);
				vf302.setF30208(f30208);
				vf302.setF30209(f30209);
				vf302.setF30210(f30210);
				vf302.setF30211(f30211);
				vf302.setF30212(f30212);
				vf302.setF30213(f30213);
				vf302.setF30214(f30214);
				vf302.setF30215(f30215);
				vf302.setF30216(f30216);
				vf302.setF30217(f30217);
				vf302.setF30218(f30218);
				vf302.setF30219(f30219);
				vf302.setF30220(f30220);
				vf302.setF30221(f30221);
				vf302.setF30222(f30222);
				vf302.setF30223(f30223);
				vf302.setF30224(f30224);
				vf302.setF30225(f30225);
				vf302.setF30226(f30226);
				vf302.setF30227(f30227);
				vf302.setF30228(f30228);
				vf302.setF30229(f30229);
				vf302.setF30230(f30230);
				vf302.setF30231(f30231);
				vf302.setF30232(f30232);
				vf302.setF30233(f30233);
				vf302.setF30234(f30234);
				vf302.setF30235(f30235);
				vf302.setF30236(f30236);
				vf302.setF30237(f30237);
				vf302.setF30238(f30238);
				vf302.setF30239(f30239);
				vf302.setF30240(f30240);
				vf302.setF30241(f30241);
				vf302.setF30242(f30242);
				vf302.setF30243(f30243);
				vf302.setF30244(f30244);
				vf302.setF30245(f30245);
				vf302.setF30246(f30246);
				vf302.setF30247(f30247);
				vf302.setF30248(f30248);
				vf302.setF30249(f30249);
				vf302.setF30250(f30250);
				vf302.setF30251(f30251);
				vf302.setF30252(f30252);
				vf302.setF30253(f30253);
				vf302.setF30254(f30254);
				vf302.setF30255(f30255);
				vf302.setF30256(f30256);
				vf302.setF30257(f30257);
				vf302.setF30258(f30258);
				vf302.setF30259(f30259);
				vf302.setF30260(f30260);
				vf302.setF30261(f30261);
				vf302.setF30262(f30262);
				vf302.setF30263(f30263);
				vf302.setF30264(f30264);
				vf302.setF30265(f30265);
				vf302.setF30266(f30266);
				vf302.setF30267(f30267);
				vf302.setF30268(f30268);
				vf302.setF30269(f30269);
				vf302.setF30270(f30270);

				vf302.setF30204Zh(f30204Zh);
				vf302.setF30208Str(f30208Str);
				vf302.setF30210Zh(f30210Zh);
				vf302.setF30204Zh(f30204Zh);
				vf302.setF30208Str(f30208Str);
				vf302.setF30210Zh(f30210Zh);
				vf302.setF30214Zh(f30214Zh);
				vf302.setF30215Zh(f30215Zh);
				vf302.setF30216Str(f30216Str);
				vf302.setF30230Str(f30230Str);
				vf302.setF30232Str(f30232Str);
				vf302.setF30233Zh(f30233Zh);
				// vf302.setF30236Zh(f30236Zh);
				vf302.setF30238Zh(f30238Zh);
				vf302.setF30240Zh(f30240Zh);
				vf302.setF30242Zh(f30242Zh);
				// vf302.setF30245Zh(f30245Zh);
				// vf302.setF30248Zh(f30248Zh);
				vf302.setF30250Zh(f30250Zh);
				vf302.setF30252Str(f30252Str);
				vf302.setF30253Str(f30253Str);
				vf302.setF30256Zh(f30256Zh);

				vf302.setF30102(f30102);
				vf302.setF30108(f30108);
				vf302.setF30117(f30117);
				vf302.setF30104(f30104);
				vf302.setF30105(f30105);
				vf302.setF30106(f30106);
				vf302.setF30106Str(f30106Str);
				vf302.setF30113(f30113);
				vf302.setF30135(f30135);
				vf302.setF30135Zh(f30135Zh);

				vf302s.add(vf302);
			}
			f302Response.setState(state);
			f302Response.setVf302s(vf302s);
		} catch (Exception e) {
			e.printStackTrace();
			f302Response.setState(false);
			f302Response.setErrorMessage("查询失败！");
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

		return f302Response;
	}

//	@Override
//	public F302Response queryF302(F302Request f302Request) {
//		F302Response f302Response = new F302Response();
//		Date f30253Start_ = f302Request.getF30253Start();
//		Date f30253End_ = f302Request.getF30253End();
//		long f302_02 = f302Request.getF30202();
//		String f302_03 = f302Request.getF30203();
//		String f302_05 = f302Request.getF30205();
//		String f302_07 = f302Request.getF30207();
//		String f302_50 = f302Request.getF30250();
//
//		int parameterPageindex = f302Request.getParameterPageindex();
//		int parameterPagesize = f302Request.getParameterPagesize();
//		String flag = f302Request.getFlag();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//		StringBuffer parameterConditionwhere = new StringBuffer();
//		if (f30253Start_ != null) {
//			String f30253Start = sdf.format(f30253Start_);
//			parameterConditionwhere.append(" and t.f302_53_str >= '"
//					+ f30253Start + "'");
//		}
//		if (f30253End_ != null) {
//			String f30253End = sdf.format(f30253End_);
//			parameterConditionwhere.append(" and t.f302_53_str <= '"
//					+ f30253End + "'");
//		}
//		if (f302_02 != 0) {
//			parameterConditionwhere
//					.append(" and t.f302_02 = '" + f302_02 + "'");
//		}
//		if (!StringUtil.isBlankString(f302_03)) {
//			parameterConditionwhere
//					.append(" and t.f302_03 = '" + f302_03 + "'");
//		}
//		if (!StringUtil.isBlankString(f302_05)) {
//			parameterConditionwhere
//					.append(" and t.f302_05 = '" + f302_05 + "'");
//		}
//		if (!StringUtil.isBlankString(f302_07)) {
//			parameterConditionwhere
//					.append(" and t.f302_07 = '" + f302_07 + "'");
//		}
//		if (!StringUtil.isBlankString(f302_50)) {
//			if (f302_50.length() == 14) {
//				parameterConditionwhere.append(" and t.f302_50 = '");
//				parameterConditionwhere.append(f302_50);
//				parameterConditionwhere.append("'");
//			} else {
//				parameterConditionwhere.append(" and t.f302_50 like '");
//				parameterConditionwhere.append(f302_50);
//				parameterConditionwhere.append("%'");
//			}
//		}
//		boolean state = true;
//		Connection connection = null;
//		CallableStatement callableStatement = null;
//		try {
//			connection = this.dataSource.getConnection();
//			callableStatement = connection
//					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
//			callableStatement.setInt(1, parameterPageindex);
//			callableStatement.setInt(2, parameterPagesize);
//			callableStatement.setString(3, "V_F302");
//			callableStatement.setString(4, parameterConditionwhere.toString());
//			callableStatement.setString(5, "t.F302_01");
//			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
//			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
//			callableStatement.execute();
//
//			long rowCount = callableStatement.getLong(6);
//			f302Response.setRowCount(rowCount);
//			f302Response.setState(state);
//			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
//			VF302 vf302 = null;
//			List<VF302> vf302s = new ArrayList<VF302>();
//			while (resultSet.next()) {
//				long f30201 = resultSet.getLong("F302_01");
//				long f30202 = resultSet.getLong("F302_02");
//				String f30203 = resultSet.getString("F302_03");
//				String f30204 = resultSet.getString("F302_04");
//				String f30205 = resultSet.getString("F302_05");
//				long f30206 = resultSet.getLong("F302_06");
//				String f30207 = resultSet.getString("F302_07");
//				Date f30208 = resultSet.getDate("F302_08");
//				long f30209 = resultSet.getLong("F302_09");
//				String f30210 = resultSet.getString("F302_10");
//				long f30211 = resultSet.getLong("F302_11");
//				long f30212 = resultSet.getLong("F302_12");
//				long f30213 = resultSet.getLong("F302_13");
//				String f30214 = resultSet.getString("F302_14");
//				String f30215 = resultSet.getString("F302_15");
//				Date f30216 = resultSet.getDate("F302_16");
//				long f30217 = resultSet.getLong("F302_17");
//				long f30218 = resultSet.getLong("F302_18");
//				long f30219 = resultSet.getLong("F302_19");
//				long f30220 = resultSet.getLong("F302_20");
//				long f30221 = resultSet.getLong("F302_21");
//				long f30222 = resultSet.getLong("F302_22");
//				long f30223 = resultSet.getLong("F302_23");
//				long f30224 = resultSet.getLong("F302_24");
//				long f30225 = resultSet.getLong("F302_25");
//				long f30226 = resultSet.getLong("F302_26");
//				long f30227 = resultSet.getLong("F302_27");
//				long f30228 = resultSet.getLong("F302_28");
//				long f30229 = resultSet.getLong("F302_29");
//				Date f30230 = resultSet.getDate("F302_30");
//				String f30231 = resultSet.getString("F302_31");
//				Date f30232 = resultSet.getDate("F302_32");
//				String f30233 = resultSet.getString("F302_33");
//				String f30234 = resultSet.getString("F302_34");
//				String f30235 = resultSet.getString("F302_35");
//				String f30236 = resultSet.getString("F302_36");
//				String f30237 = resultSet.getString("F302_37");
//				String f30238 = resultSet.getString("F302_38");
//				String f30239 = resultSet.getString("F302_39");
//				String f30240 = resultSet.getString("F302_40");
//				String f30241 = resultSet.getString("F302_41");
//				String f30242 = resultSet.getString("F302_42");
//				String f30243 = resultSet.getString("F302_43");
//				String f30244 = resultSet.getString("F302_44");
//				String f30245 = resultSet.getString("F302_45");
//				String f30246 = resultSet.getString("F302_46");
//				String f30247 = resultSet.getString("F302_47");
//				String f30248 = resultSet.getString("F302_48");
//				String f30249 = resultSet.getString("F302_49");
//				String f30250 = resultSet.getString("F302_50");
//				String f30251 = resultSet.getString("F302_51");
//				Date f30252 = resultSet.getDate("F302_52");
//				Date f30253 = resultSet.getDate("F302_53");
//				long f30254 = resultSet.getLong("F302_54");
//				String f30255 = resultSet.getString("F302_55");
//				String f30256 = resultSet.getString("F302_56");
//				String f30257 = resultSet.getString("F302_57");
//				String f30258 = resultSet.getString("F302_58");
//				String f30259 = resultSet.getString("F302_59");
//				String f30260 = resultSet.getString("F302_60");
//				String f30261 = resultSet.getString("F302_61");
//				String f30262 = resultSet.getString("F302_62");
//				String f30263 = resultSet.getString("F302_63");
//				String f30264 = resultSet.getString("F302_64");
//				String f30265 = resultSet.getString("F302_65");
//				String f30266 = resultSet.getString("F302_66");
//				String f30267 = resultSet.getString("F302_67");
//				String f30268 = resultSet.getString("F302_68");
//				String f30269 = resultSet.getString("F302_69");
//				String f30270 = resultSet.getString("F302_70");
//
//				String f30204Zh = resultSet.getString("F302_04_ZH");
//				String f30208Str = resultSet.getString("F302_08_Str");
//				String f30210Zh = resultSet.getString("F302_10_ZH");
//				String f30214Zh = resultSet.getString("F302_14_ZH");
//				String f30215Zh = resultSet.getString("F302_15_ZH");
//				String f30216Str = resultSet.getString("F302_16_Str");
//				String f30230Str = resultSet.getString("F302_30_Str");
//				String f30232Str = resultSet.getString("F302_32_Str");
//				String f30233Zh = resultSet.getString("F302_33_ZH");
//				// String f30236Zh =resultSet.getString("F302_36_ZH");
//				String f30238Zh = resultSet.getString("F302_38_ZH");
//				String f30240Zh = resultSet.getString("F302_40_ZH");
//				String f30242Zh = resultSet.getString("F302_42_ZH");
//				// String f30245Zh =resultSet.getString("F302_45_ZH");
//				// String f30248Zh =resultSet.getString("F302_48_ZH");
//				String f30250Zh = resultSet.getString("F302_50_ZH");
//				String f30252Str = resultSet.getString("F302_52_Str");
//				String f30253Str = resultSet.getString("F302_53_Str");
//				String f30256Zh = resultSet.getString("F302_56_ZH");
//
//				String f30108 = resultSet.getString("F301_08");
//				String f30117 = resultSet.getString("F301_17");
//				String f30102 = resultSet.getString("F301_02");
//				String f30104 = resultSet.getString("F301_04");
//				String f30105 = resultSet.getString("F301_05");
//				Date f30106 = resultSet.getDate("F301_06");
//				String f30106Str = resultSet.getString("F301_06_Str");
//				String f30113 = resultSet.getString("F301_13");
//				String f30135 = resultSet.getString("F301_35");
//				String f30135Zh = resultSet.getString("F301_35_ZH");
//
//				vf302 = new VF302();
//				vf302.setF30201(f30201);
//				vf302.setF30202(f30202);
//				vf302.setF30203(f30203);
//				vf302.setF30204(f30204);
//				vf302.setF30205(f30205);
//				vf302.setF30206(f30206);
//				vf302.setF30207(f30207);
//				vf302.setF30208(f30208);
//				vf302.setF30209(f30209);
//				vf302.setF30210(f30210);
//				vf302.setF30211(f30211);
//				vf302.setF30212(f30212);
//				vf302.setF30213(f30213);
//				vf302.setF30214(f30214);
//				vf302.setF30215(f30215);
//				vf302.setF30216(f30216);
//				vf302.setF30217(f30217);
//				vf302.setF30218(f30218);
//				vf302.setF30219(f30219);
//				vf302.setF30220(f30220);
//				vf302.setF30221(f30221);
//				vf302.setF30222(f30222);
//				vf302.setF30223(f30223);
//				vf302.setF30224(f30224);
//				vf302.setF30225(f30225);
//				vf302.setF30226(f30226);
//				vf302.setF30227(f30227);
//				vf302.setF30228(f30228);
//				vf302.setF30229(f30229);
//				vf302.setF30230(f30230);
//				vf302.setF30231(f30231);
//				vf302.setF30232(f30232);
//				vf302.setF30233(f30233);
//				vf302.setF30234(f30234);
//				vf302.setF30235(f30235);
//				vf302.setF30236(f30236);
//				vf302.setF30237(f30237);
//				vf302.setF30238(f30238);
//				vf302.setF30239(f30239);
//				vf302.setF30240(f30240);
//				vf302.setF30241(f30241);
//				vf302.setF30242(f30242);
//				vf302.setF30243(f30243);
//				vf302.setF30244(f30244);
//				vf302.setF30245(f30245);
//				vf302.setF30246(f30246);
//				vf302.setF30247(f30247);
//				vf302.setF30248(f30248);
//				vf302.setF30249(f30249);
//				vf302.setF30250(f30250);
//				vf302.setF30251(f30251);
//				vf302.setF30252(f30252);
//				vf302.setF30253(f30253);
//				vf302.setF30254(f30254);
//				vf302.setF30255(f30255);
//				vf302.setF30256(f30256);
//				vf302.setF30257(f30257);
//				vf302.setF30258(f30258);
//				vf302.setF30259(f30259);
//				vf302.setF30260(f30260);
//				vf302.setF30261(f30261);
//				vf302.setF30262(f30262);
//				vf302.setF30263(f30263);
//				vf302.setF30264(f30264);
//				vf302.setF30265(f30265);
//				vf302.setF30266(f30266);
//				vf302.setF30267(f30267);
//				vf302.setF30268(f30268);
//				vf302.setF30269(f30269);
//				vf302.setF30270(f30270);
//
//				vf302.setF30204Zh(f30204Zh);
//				vf302.setF30208Str(f30208Str);
//				vf302.setF30210Zh(f30210Zh);
//				vf302.setF30204Zh(f30204Zh);
//				vf302.setF30208Str(f30208Str);
//				vf302.setF30210Zh(f30210Zh);
//				vf302.setF30214Zh(f30214Zh);
//				vf302.setF30215Zh(f30215Zh);
//				vf302.setF30216Str(f30216Str);
//				vf302.setF30230Str(f30230Str);
//				vf302.setF30232Str(f30232Str);
//				vf302.setF30233Zh(f30233Zh);
//				// vf302.setF30236Zh(f30236Zh);
//				vf302.setF30238Zh(f30238Zh);
//				vf302.setF30240Zh(f30240Zh);
//				vf302.setF30242Zh(f30242Zh);
//				// vf302.setF30245Zh(f30245Zh);
//				// vf302.setF30248Zh(f30248Zh);
//				vf302.setF30250Zh(f30250Zh);
//				vf302.setF30252Str(f30252Str);
//				vf302.setF30253Str(f30253Str);
//				vf302.setF30256Zh(f30256Zh);
//
//				vf302.setF30102(f30102);
//				vf302.setF30108(f30108);
//				vf302.setF30117(f30117);
//				vf302.setF30104(f30104);
//				vf302.setF30105(f30105);
//				vf302.setF30106(f30106);
//				vf302.setF30106Str(f30106Str);
//				vf302.setF30113(f30113);
//				vf302.setF30135(f30135);
//				vf302.setF30135Zh(f30135Zh);
//
//				vf302s.add(vf302);
//			}
//			f302Response.setState(state);
//			f302Response.setVf302s(vf302s);
//		} catch (Exception e) {
//			e.printStackTrace();
//			f302Response.setState(false);
//			f302Response.setErrorMessage("查询失败！");
//		} finally {
//			try {
//				if (callableStatement != null) {
//					callableStatement.close();
//					callableStatement = null;
//				}
//				if (connection != null) {
//					connection.close();
//					connection = null;
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return f302Response;
//	}

	@Override
	public F302Response deleteF302(F302Request f302Request) {
		F302Response f302Response = new F302Response();
		long f30201 = f302Request.getF30201();
		long f30202 = f302Request.getF30202();
		String f30203 = f302Request.getF30203();
		String f30204 = f302Request.getF30204();
		String f30205 = f302Request.getF30205();

		StringBuffer sql = new StringBuffer(
				"select * from V_F303 t where 1=1 and t.f303_03 ='" + f30201
						+ "'");
		if (f30202 != 0) {
			sql.append(" and t.f303_02 = '" + f30202 + "'");
		}
		if (f30203 != null) {
			sql.append(" and t.f303_05 = '" + f30203 + "'");
		}
		if (f30204 != null) {
			sql.append(" and t.f303_06 = '" + f30204 + "'");
		}
		if (f30205 != null) {
			sql.append(" and t.f303_07 = '" + f30205 + "'");
		}

		try {
			Session session = sessionFactory.getCurrentSession();
			SQLQuery query = session.createSQLQuery(sql.toString());
			int size = query.list().size();
			if (size > 0) {
				f302Response.setErrorMessage("已填过妇女检查 ，不能再删除！");
				return f302Response;
			}

			F302 f302 = new F302();
			f302.setF30201(f30201);
			session.delete(f302);
			f302Response.setPromptMessage("删除成功！");
		} catch (Exception e) {
			f302Response.setPromptMessage("删除失败！");
		}

		return f302Response;
	}

}
