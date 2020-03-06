package com.xyw.medical.fnbj.birthcard.dao.impl;

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

import com.xyw.medical.fnbj.birthcard.dao.F304Dao;
import com.xyw.medical.fnbj.model.F304;
import com.xyw.medical.fnbj.model.F304Request;
import com.xyw.medical.fnbj.model.F304Response;
import com.xyw.medical.fnbj.model.VF304;
import com.xyw.sys.util.StringUtil;

public class F304DaoImpl implements F304Dao {
	@Resource
	public SessionFactory sessionFactory;

	@Resource
	public DataSource dataSource;

	@SuppressWarnings("unchecked")
	@Override
	public F304Response saveF304(F304 f304) {
		F304Response f304Response = new F304Response();
		long f304_02 = f304.getF30402();
		String f304_05 = f304.getF30405();
		String f304_10 = f304.getF30410();
		String f304_11 = f304.getF30411();
		String f304_12 = f304.getF30412();

		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			StringBuffer sql = new StringBuffer(
					"select * from F304 t where 1=1 ");
			if (f304_02 != 0) {
				sql.append("and t.f304_02 ='" + f304_02 + "' ");
			}
			if (!StringUtil.isBlankString(f304_05)) {
				sql.append("and t.f304_05 ='" + f304_05 + "' ");
			}
			if (!StringUtil.isBlankString(f304_10)) {
				sql.append("and t.f304_10 ='" + f304_10 + "' ");
			}
			if (!StringUtil.isBlankString(f304_11)) {
				sql.append("and t.f304_11 ='" + f304_11 + "' ");
			}
			if (!StringUtil.isBlankString(f304_12)) {
				sql.append("and t.f304_12 ='" + f304_12 + "' ");
			}
			SQLQuery query = session.createSQLQuery(sql.toString());
			List<F304> f304s = query.addEntity(F304.class).list();
			if (f304s.size() > 0) {
				state = false;
				f304Response.setErrorMessage("重复保存！");
			}
		} catch (Exception e) {
			state = false;
			f304Response.setErrorMessage("保存出错! ");
			e.printStackTrace();
		}
		if (state) {
			try {
				session.save(f304);
				session.flush();
				session.refresh(f304);
			} catch (Exception e) {
				state = false;
				f304Response.setErrorMessage("保存出错! ");
				e.printStackTrace();
			}
		}

		f304Response.setState(state);
		return f304Response;
	}

	@Override
	public F304Response renewF304(F304 f304) {
		F304Response f304Response = new F304Response();

		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(f304);
		} catch (Exception e) {
			state = false;
			f304Response.setErrorMessage("修改失败！");
			e.printStackTrace();
		}

		f304Response.setState(state);
		return f304Response;
	}

	@Override
	public F304Response queryF304(F304Request f304Request) {
		Date f30403Start_ = f304Request.getF30403Start();
		Date f30403End_ = f304Request.getF30403End();
		long f304_02 = f304Request.getF30402();
		String f304_08 = f304Request.getF30408();
		String f304_10 = f304Request.getF30410();
		String f304_12 = f304Request.getF30412();
		
		String flag = f304Request.getFlag();
		int parameterPageindex = f304Request.getParameterPageindex();
		int parameterPagesize = f304Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		F304Response f304Response = new F304Response();
		StringBuffer sql = new StringBuffer();
		if (f304_02 != 0) {
			sql.append(" and t.f304_02 = '" + f304_02 + "'");
		}
		if (f30403Start_ != null) {
			String f30403Start = sdf.format(f30403Start_);
			sql.append(" and t.f304_03_str >= '" + f30403Start + "'");
		}
		if (f30403End_ != null) {
			String f30403End = sdf.format(f30403End_);
			sql.append(" and t.f304_03_str <= '" + f30403End + "'");

		}
		if (!StringUtil.isBlankString(f304_10)) {
			sql.append("and t.f304_10 ='" + f304_10 + "' ");
		}
		if (!StringUtil.isBlankString(f304_12)) {
			sql.append("and t.f304_12 ='" + f304_12 + "' ");
		}
		if (!StringUtil.isBlankString(f304_08)) {
			if (f304_08.length() == 14) {
				sql.append(" and t.f304_08 = '");
				sql.append(f304_08);
				sql.append("'");
			} else {
				sql.append(" and t.f304_08 like '");
				sql.append(f304_08);
				sql.append("%'");
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
			callableStatement.setString(3, "V_F304");
			callableStatement.setString(4, sql.toString());
			callableStatement.setString(5, "t.F304_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			f304Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);

			VF304 vf304 = null;
			List<VF304> vf304s = new ArrayList<VF304>();
			while (resultSet.next()) {
				long f30401 = resultSet.getLong("F304_01");
				long f30402 = resultSet.getLong("F304_02");
				Date f30403 = resultSet.getDate("F304_03");
				String f30404 = resultSet.getString("F304_04");
				String f30405 = resultSet.getString("F304_05");
				String f30406 = resultSet.getString("F304_06");
				String f30407 = resultSet.getString("F304_07");
				String f30408 = resultSet.getString("F304_08");
				String f30409 = resultSet.getString("F304_09");
				String f30410 = resultSet.getString("F304_10");
				String f30411 = resultSet.getString("F304_11");
				String f30412 = resultSet.getString("F304_12");
				String f30413 = resultSet.getString("F304_13");
				String f30414 = resultSet.getString("F304_14");
				String f30415 = resultSet.getString("F304_15");
				String f30416 = resultSet.getString("F304_16");
				String f30417 = resultSet.getString("F304_17");
				String f30418 = resultSet.getString("F304_18");
				String f30419 = resultSet.getString("F304_19");
				String f30420 = resultSet.getString("F304_20");
				String f30421 = resultSet.getString("F304_21");
				String f30422 = resultSet.getString("F304_22");
				String f30423 = resultSet.getString("F304_23");
				String f30424 = resultSet.getString("F304_24");
				String f30425 = resultSet.getString("F304_25");

				String f30403Str = resultSet.getString("F304_03_STR");
				String f30406Zh = resultSet.getString("F304_06_ZH");
				String f30408Zh = resultSet.getString("F304_08_ZH");
				String f30411Zh = resultSet.getString("F304_11_ZH");

				String f30117 = resultSet.getString("F301_17");
				String f30102 = resultSet.getString("F301_02");
				String f30104 = resultSet.getString("F301_04");
				String f30105 = resultSet.getString("F301_05");
				Date f30106 = resultSet.getDate("F301_06");
				String f30106Str = resultSet.getString("F301_06_Str");
				String f30113 = resultSet.getString("F301_13");
				String f30135 = resultSet.getString("F301_35");
				String f30135Zh = resultSet.getString("F301_35_ZH");

				vf304 = new VF304();
				vf304.setF30401(f30401);
				vf304.setF30402(f30402);
				vf304.setF30403(f30403);
				vf304.setF30404(f30404);
				vf304.setF30405(f30405);
				vf304.setF30406(f30406);
				vf304.setF30407(f30407);
				vf304.setF30408(f30408);
				vf304.setF30409(f30409);
				vf304.setF30410(f30410);
				vf304.setF30411(f30411);
				vf304.setF30412(f30412);
				vf304.setF30413(f30413);
				vf304.setF30414(f30414);
				vf304.setF30415(f30415);
				vf304.setF30416(f30416);
				vf304.setF30417(f30417);
				vf304.setF30418(f30418);
				vf304.setF30419(f30419);
				vf304.setF30420(f30420);
				vf304.setF30421(f30421);
				vf304.setF30422(f30422);
				vf304.setF30423(f30423);
				vf304.setF30424(f30424);
				vf304.setF30425(f30425);

				vf304.setF30403Str(f30403Str);
				vf304.setF30406Zh(f30406Zh);
				vf304.setF30408Zh(f30408Zh);
				vf304.setF30411Zh(f30411Zh);

				vf304.setF30117(f30117);
				vf304.setF30104(f30104);
				vf304.setF30105(f30105);
				vf304.setF30106(f30106);
				vf304.setF30106Str(f30106Str);
				vf304.setF30113(f30113);
				vf304.setF30135(f30135);
				vf304.setF30135Zh(f30135Zh);

				vf304s.add(vf304);
			}
			f304Response.setState(state);
			f304Response.setVf304s(vf304s);
		} catch (Exception e) {
			f304Response.setState(false);
			f304Response.setErrorMessage("查询失败！");
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return f304Response;
	}

	@Override
	public F304Response deleteF304(F304Request f304Request) {
		F304Response f304Response = new F304Response();
		long f30401 = f304Request.getF30401();

//		StringBuffer sql6 = new StringBuffer(
//				"select * from V_F306 t where 1=1 and t.f306_02 ='" + f30401
//						+ "'");

		try {
			Session session = sessionFactory.getCurrentSession();
//			SQLQuery query6 = session.createSQLQuery(sql6.toString());
//			int size6 = query6.list().size();
//			if (size6 > 0) {
//				f304Response.setErrorMessage("已填过随访登记 ，不能再删除！");
//				return f304Response;
//			}

			F304 f304 = new F304();
			f304.setF30401(f30401);
			session.delete(f304);
			f304Response.setPromptMessage("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			f304Response.setPromptMessage("删除失败！");
		}
		return f304Response;
	}

}
