package com.xyw.medical.fnbj.fnsydj.dao.impl;

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

import com.xyw.medical.fnbj.fnsydj.dao.PrenatalEduDao;
import com.xyw.medical.fnbj.model.F306;
import com.xyw.medical.fnbj.model.F306Request;
import com.xyw.medical.fnbj.model.F306Response;
import com.xyw.medical.fnbj.model.VF306;
import com.xyw.sys.util.StringUtil;

public class PrenatalEduDaoImpl implements PrenatalEduDao {
	@Resource
	private SessionFactory sessionFactory;
	private StringBuffer errorMessage;
	@Resource
	private DataSource dataSource;

	@Override
	public F306Response queryF306(F306Request f306Request) {
		F306Response f306Response = new F306Response();
		String f30102 = f306Request.getF30102();
		String f30105 = f306Request.getF30105();
		int parameterPageindex = f306Request.getParameterPageindex();
		int parameterPagesize = f306Request.getParameterPagesize();
		String flag = f306Request.getFlag();
		StringBuffer parameterConditionwhere = new StringBuffer();

		if (f30102 != null && !"".equals(f30102)) {
			parameterConditionwhere.append(" and t.f301_02 = '" + f30102 + "'");
		}
		if (f30105 != null && !"".equals(f30102)) {
			parameterConditionwhere.append(" and t.f301_05 = '" + f30105 + "'");
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
			callableStatement.setString(3, "V_F301");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.F301_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			f306Response.setRowCount(rowCount);
			f306Request.setFlag(flag);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VF306 vf306 = null;
			List<VF306> vf306s = new ArrayList<VF306>();
			while (resultSet.next()) {
				// long f30601 = resultSet.getLong("F306_01");
				// long f30602 = resultSet.getLong("F306_02");
				// Date f30603 = resultSet.getDate("F306_03");
				// Date f30604 = resultSet.getDate("F306_04");
				// String f30605 = resultSet.getString("F306_05");
				// String f30606 = resultSet.getString("F306_06");
				// String f30607 = resultSet.getString("F306_07");
				// String f30608 = resultSet.getString("F306_08");
				// String f30609 = resultSet.getString("F306_09");
				// String f30610 = resultSet.getString("F306_10");
				// String f30611 = resultSet.getString("F306_11");
				// Date f30612 = resultSet.getDate("F306_12");
				// String f30613 = resultSet.getString("F306_13");
				// String f30614 = resultSet.getString("F306_14");
				// String f30615 = resultSet.getString("F306_15");
				// String f30616 = resultSet.getString("F306_16");
				// String f30617 = resultSet.getString("F306_17");
				// String f30618 = resultSet.getString("F306_18");
				// String f30619 = resultSet.getString("F306_19");
				// String f30620 = resultSet.getString("F306_20");

				String f30102ZH = resultSet.getString("F301_02");
				String f30104 = resultSet.getString("F301_04");
				String f30105ZH = resultSet.getString("F301_05");
				String f30106 = resultSet.getString("F301_06");
				String f30112 = resultSet.getString("F301_12");
				String f30131 = resultSet.getString("F301_31");
				String f30117 = resultSet.getString("F301_17");
				long f30602 = resultSet.getLong("F301_01");
				// String f30603Str = resultSet.getString("f306_03_str");
				// String f30604Str = resultSet.getString("f306_04_str");
				// String f30608Zh = resultSet.getString("f306_08_zh");

				vf306 = new VF306();
				// vf306.setF30601(f30601);
				// vf306.setF30602(f30602);
				// vf306.setF30603(f30603);
				// vf306.setF30604(f30604);
				// vf306.setF30605(f30605);
				// vf306.setF30606(f30606);
				// vf306.setF30607(f30607);
				// vf306.setF30608(f30608);
				// vf306.setF30609(f30609);
				// vf306.setF30610(f30610);
				// vf306.setF30611(f30611);
				// vf306.setF30612(f30612);
				// vf306.setF30613(f30613);
				// vf306.setF30614(f30614);
				// vf306.setF30615(f30615);
				// vf306.setF30616(f30616);
				// vf306.setF30617(f30617);
				// vf306.setF30618(f30618);
				// vf306.setF30619(f30619);
				// vf306.setF30620(f30620);
				//
				// vf306.setF30603Str(f30603Str);
				// vf306.setF30604Str(f30604Str);
				// vf306.setF30608Zh(f30608Zh);

				vf306.setF30102(f30102ZH);
				vf306.setF30104(f30104);
				vf306.setF30105(f30105ZH);
				vf306.setF30106(f30106);
				vf306.setF30112(f30112);
				vf306.setF30117(f30117);
				vf306.setF30131(f30131);
				vf306.setF30602(f30602);

				vf306s.add(vf306);
			}
			f306Response.setState(state);
			f306Response.setVf306s(vf306s);
		} catch (Exception e) {
			e.printStackTrace();
			f306Response.setState(false);
			f306Response.setErrorMessage("查询失败！");
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
		return f306Response;

	}

	@Override
	public F306Response queryVF306(F306Request f306Request) {
		F306Response f306Response = new F306Response();
		String f30102 = f306Request.getF30102();
		String f30105 = f306Request.getF30105();
		String jigou = f306Request.getJigou();
		String timeStart = f306Request.getTimeStr();
		String timeEnd = f306Request.getTimeEnd();
		int parameterPageindex = f306Request.getParameterPageindex();
		int parameterPagesize = f306Request.getParameterPagesize();
		String flag = f306Request.getFlag();
		StringBuffer parameterConditionwhere = new StringBuffer();

		if (f30102 != null && !"".equals(f30102)) {
			parameterConditionwhere.append(" and t.f301_02 = '" + f30102 + "'");
		}
		if (f30105 != null && !"".equals(f30105)) {
			parameterConditionwhere.append(" and t.f301_05 = '" + f30105 + "'");
		}
		if (jigou != null && !"".equals(jigou)) {
			parameterConditionwhere.append(" and t.f306_10 like '" + jigou
					+ "%'");
		}
		if (timeStart != null && !"".equals(timeStart)) {
			parameterConditionwhere
					.append(" and to_char(t.f306_03,'yyyy-MM-dd') >= '"
							+ timeStart + "'");
		}
		if (timeEnd != null && !"".equals(timeEnd)) {
			parameterConditionwhere
					.append(" and to_char(t.f306_03,'yyyy-MM-dd') <= '"
							+ timeEnd + "'");
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
			callableStatement.setString(3, "V_F306");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.F306_01");   //F301_05
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			f306Response.setRowCount(rowCount);
			f306Request.setFlag(flag);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VF306 vf306 = null;
			List<VF306> vf306s = new ArrayList<VF306>();
			while (resultSet.next()) {
				long f30601 = resultSet.getLong("F306_01");
				long f30602 = resultSet.getLong("F306_02");
				Date f30603 = resultSet.getDate("F306_03");
				//Date f30604 = resultSet.getDate("F306_04");
				Date f30605 = resultSet.getDate("F306_05");
				String f30606 = resultSet.getString("F306_06");
				String f30607 = resultSet.getString("F306_07");
				String f30608 = resultSet.getString("F306_08");
				String f30609 = resultSet.getString("F306_09");
				String f30610 = resultSet.getString("F306_10");
				String f30611 = resultSet.getString("F306_11");
				String f30612 = resultSet.getString("F306_12");
				String f30613 = resultSet.getString("F306_13");
				String f30614 = resultSet.getString("F306_14");
				Date f30615 = resultSet.getDate("F306_15");

				String f30102ZH = resultSet.getString("F301_02");
				String f30104 = resultSet.getString("F301_04");
				String f30105ZH = resultSet.getString("F301_05");
				String f30106 = resultSet.getString("F301_06");
				String f30112 = resultSet.getString("F301_12");
				String f30131 = resultSet.getString("F301_31");
				String f30117 = resultSet.getString("F301_17");
				String f30610Zh = resultSet.getString("F306_10_ZH");
				String f30607Zh = resultSet.getString("F306_07_ZH");
				String f30603Str = resultSet.getString("F306_03_STR");
				//String f30604Str = resultSet.getString("F306_04_STR");
				String f30605Str = resultSet.getString("F306_05_STR");
				String f30615Str = resultSet.getString("F306_15_STR");
				vf306 = new VF306();
				vf306.setF30601(f30601);
				vf306.setF30602(f30602);
				vf306.setF30603(f30603);
				//vf306.setF30604(f30604);
				vf306.setF30605(f30605);
				vf306.setF30606(f30606);
				vf306.setF30607(f30607);
				vf306.setF30608(f30608);
				vf306.setF30609(f30609);
				vf306.setF30610(f30610);
				vf306.setF30611(f30611);
				vf306.setF30612(f30612);
				vf306.setF30613(f30613);
				vf306.setF30614(f30614);
				vf306.setF30615(f30615);

				vf306.setF30102(f30102ZH);
				vf306.setF30104(f30104);
				vf306.setF30105(f30105ZH);
				vf306.setF30106(f30106);
				vf306.setF30112(f30112);
				vf306.setF30117(f30117);
				vf306.setF30131(f30131);
				vf306.setF30603Str(f30603Str);
				//vf306.setF30604Str(f30604Str);
				vf306.setF30605Str(f30605Str);
				vf306.setF30615Str(f30615Str);
				vf306.setF30607Zh(f30607Zh);
				vf306.setF30610Zh(f30610Zh);

				vf306s.add(vf306);
			}
			f306Response.setState(state);
			f306Response.setVf306s(vf306s);
		} catch (Exception e) {
			e.printStackTrace();
			f306Response.setState(false);
			f306Response.setErrorMessage("查询失败！");
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
		return f306Response;
	}

	@Override
	@SuppressWarnings("unchecked")
	public F306Response saveF306(F306 f306) {
		F306Response f306Response = new F306Response();
		long f30602 =f306.getF30602();
		String f30607 = f306.getF30607();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String f30603 = sdf.format(f306.getF30603());
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			StringBuffer sql = new StringBuffer("select * from F306 t where 1=1 ");
			if(f30602 !=0){
				sql.append("and t.f306_02 ='" + f30602 + "' ");
			}
			if (!StringUtil.isBlankString(f30607)) {
				sql.append("and t.f306_07 ='" + f30607 + "' ");
			}
			if (f30603 != null) {
				sql.append("and t.f306_03 = to_date('" + f30603+ "','yyyy-MM-dd')");
			}
			SQLQuery query = session.createSQLQuery(sql.toString());
			List<F306> f306s = query.addEntity(F306.class).list();
			if (f306s.size() > 0) {
				state = false;
				f306Response.setErrorMessage("重复保存！");
			}
		} catch (Exception e) {
			state = false;
			f306Response.setErrorMessage("保存出错! ");
			e.printStackTrace();
		}
		if (state) {
			try {
				session.save(f306);
				session.flush();
				session.refresh(f306);
			} catch (Exception e) {
				state = false;
				f306Response.setErrorMessage("保存出错! ");
				e.printStackTrace();
			}
		}

		f306Response.setState(state);
		return f306Response;
	}

	@Override
	public F306Response updateF306(F306 f306) {
		F306Response f306Response = new F306Response();
		Session session = sessionFactory.getCurrentSession();
		boolean state = true;
		try {
			session.saveOrUpdate(f306);
			f306Response.setPromptMessage("修改成功！");
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage.append(e.getMessage());
			f306Response.setErrorMessage(errorMessage.toString());
			state = false;
		}
		f306Response.setState(state);
		return f306Response;
	}

	@Override
	public F306Response deleteF306(F306Request f306Request) {
		F306Response f306Response = new F306Response();
		long f30601 = Long.parseLong(f306Request.getF30601());
		try {
			Session session = sessionFactory.getCurrentSession();
			F306 f306 = new F306();
			f306.setF30601(f30601);
			session.delete(f306);
			f306Response.setPromptMessage("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			f306Response.setErrorMessage("删除失败！");
		}

		return f306Response;
	}
}
