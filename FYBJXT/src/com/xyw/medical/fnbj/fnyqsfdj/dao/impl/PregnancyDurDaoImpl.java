package com.xyw.medical.fnbj.fnyqsfdj.dao.impl;

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

import com.xyw.medical.fnbj.fnyqsfdj.dao.PregnancyDurDao;
import com.xyw.medical.fnbj.model.F305;
import com.xyw.medical.fnbj.model.F305Request;
import com.xyw.medical.fnbj.model.F305Response;
import com.xyw.medical.fnbj.model.VF305;
import com.xyw.sys.util.StringUtil;

public class PregnancyDurDaoImpl implements PregnancyDurDao {
	@Resource
	private SessionFactory sessionFactory;
	private StringBuffer errorMessage;
	@Resource
	private DataSource dataSource;

	@Override
	public F305Response queryF305(F305Request f305Request) {
		F305Response f305Response = new F305Response();
		String f30102 = f305Request.getF30102();
		String f30105 = f305Request.getF30105();
		String f30113 = f305Request.getF30113();
		int parameterPageindex = f305Request.getParameterPageindex();
		int parameterPagesize = f305Request.getParameterPagesize();
		String flag = f305Request.getFlag();
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();

		if (f30102 != null && !"".equals(f30102)) {
			parameterConditionwhere.append(" and t.f301_02 = '" + f30102 + "'");
		}
		if (f30105 != null && !"".equals(f30105)) {
			parameterConditionwhere.append(" and t.f301_05 = '" + f30105 + "'");
		}
		if (f30113 != null && !"".equals(f30113)) {
			parameterConditionwhere.append(" and t.f301_13 = '" + f30113 + "'");
		}
		boolean state = true;
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_F301");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.F301_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			f305Response.setRowCount(rowCount);
			f305Request.setFlag(flag);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VF305 vf305 = null;
			List<VF305> vf305s = new ArrayList<VF305>();
			while (resultSet.next()) {
				// long f30501 = resultSet.getLong("F305_01");
				// long f30502 = resultSet.getLong("F305_02");
				// Date f30503 = resultSet.getDate("F305_03");
				// Date f30504 = resultSet.getDate("F305_04");
				// String f30505 = resultSet.getString("F305_05");
				// String f30506 = resultSet.getString("F305_06");
				// String f30507 = resultSet.getString("F305_07");
				// String f30508 = resultSet.getString("F305_08");
				// String f30509 = resultSet.getString("F305_09");
				// String f30510 = resultSet.getString("F305_10");
				// String f30511 = resultSet.getString("F305_11");
				// Date f30512 = resultSet.getDate("F305_12");
				// String f30513 = resultSet.getString("F305_13");
				// String f30514 = resultSet.getString("F305_14");
				// String f30515 = resultSet.getString("F305_15");
				// String f30516 = resultSet.getString("F305_16");
				// String f30517 = resultSet.getString("F305_17");
				// String f30518 = resultSet.getString("F305_18");
				// String f30519 = resultSet.getString("F305_19");
				// String f30520 = resultSet.getString("F305_20");

				String f30102ZH = resultSet.getString("F301_02");
				String f30104 = resultSet.getString("F301_04");
				String f30105ZH = resultSet.getString("F301_05");
				String f30106 = resultSet.getString("F301_06");
				String f30112 = resultSet.getString("F301_12");
				String f30131 = resultSet.getString("F301_31");
				String f30117 = resultSet.getString("F301_17");
				long f30502 = resultSet.getLong("F301_01");
				// String f30503Str = resultSet.getString("f305_03_str");
				// String f30504Str = resultSet.getString("f305_04_str");
				// String f30508Zh = resultSet.getString("f305_08_zh");

				vf305 = new VF305();
				// vf305.setF30501(f30501);
				// vf305.setF30502(f30502);
				// vf305.setF30503(f30503);
				// vf305.setF30504(f30504);
				// vf305.setF30505(f30505);
				// vf305.setF30506(f30506);
				// vf305.setF30507(f30507);
				// vf305.setF30508(f30508);
				// vf305.setF30509(f30509);
				// vf305.setF30510(f30510);
				// vf305.setF30511(f30511);
				// vf305.setF30512(f30512);
				// vf305.setF30513(f30513);
				// vf305.setF30514(f30514);
				// vf305.setF30515(f30515);
				// vf305.setF30516(f30516);
				// vf305.setF30517(f30517);
				// vf305.setF30518(f30518);
				// vf305.setF30519(f30519);
				// vf305.setF30520(f30520);
				//
				// vf305.setF30503Str(f30503Str);
				// vf305.setF30504Str(f30504Str);
				// vf305.setF30508Zh(f30508Zh);

				vf305.setF30102(f30102ZH);
				vf305.setF30104(f30104);
				vf305.setF30105(f30105ZH);
				vf305.setF30106(f30106);
				vf305.setF30112(f30112);
				vf305.setF30117(f30117);
				vf305.setF30131(f30131);
				vf305.setF30502(f30502);

				vf305s.add(vf305);
			}
			if (rowCount==0) {
				f305Response.setErrorMessage("暂无数据！");
			}
			f305Response.setState(state);
			f305Response.setVf305s(vf305s);
		} catch (Exception e) {
			e.printStackTrace();
			f305Response.setState(false);
			f305Response.setErrorMessage("查询失败！");
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
		return f305Response;

	}

	@Override
	public F305Response queryVF305(F305Request f305Request) {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		F305Response f305Response = new F305Response();
		String f30102 = f305Request.getF30102();
		String f30105 = f305Request.getF30105();
		String jigou = f305Request.getJigou();
		String timeStart = f305Request.getTimeStr();
		String timeEnd = f305Request.getTimeEnd();
		int parameterPageindex = f305Request.getParameterPageindex();
		int parameterPagesize = f305Request.getParameterPagesize();
//		String flag = f305Request.getFlag();
		StringBuffer parameterConditionwhere = new StringBuffer();

		if (!StringUtil.isBlankString(f30102)) {
			parameterConditionwhere.append(" and t.f301_02 = '" + f30102 + "'");
		}
		if (!StringUtil.isBlankString(f30105)) {
			parameterConditionwhere.append(" and t.f301_05 = '" + f30105 + "'");
		}
		if (!StringUtil.isBlankString(jigou)) {
			parameterConditionwhere.append(" and t.f305_08 like '" + jigou+ "%'");
		}
		if (timeStart != null && !"".equals(timeStart)) {
			parameterConditionwhere.append(" and t.f305_03_str >= '"+ timeStart + "'");
		}
		if (timeEnd != null && !"".equals(timeEnd)) {
			parameterConditionwhere.append(" and t.f305_03_str <= '"+ timeEnd + "'");
		}

		boolean state = true;
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_F305");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.F305_01");           
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			f305Response.setRowCount(rowCount);
//			f305Request.setFlag(flag);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VF305 vf305 = null;
			List<VF305> vf305s = new ArrayList<VF305>();
			while (resultSet.next()) {
				long f30501 = resultSet.getLong("F305_01");
				long f30502 = resultSet.getLong("F305_02");
				Date f30503 = resultSet.getDate("F305_03");
				Date f30504 = resultSet.getDate("F305_04");
				String f30505 = resultSet.getString("F305_05");
				String f30506 = resultSet.getString("F305_06");
				String f30507 = resultSet.getString("F305_07");
				String f30508 = resultSet.getString("F305_08");
				String f30509 = resultSet.getString("F305_09");
				String f30510 = resultSet.getString("F305_10");
				String f30511 = resultSet.getString("F305_11");
				Date f30512 = resultSet.getDate("F305_12");
				String f30513 = resultSet.getString("F305_13");
				String f30514 = resultSet.getString("F305_14");
				String f30515 = resultSet.getString("F305_15");
				String f30516 = resultSet.getString("F305_16");
				String f30517 = resultSet.getString("F305_17");
				String f30518 = resultSet.getString("F305_18");
				String f30519 = resultSet.getString("F305_19");
				String f30520 = resultSet.getString("F305_20");

				String f30102ZH = resultSet.getString("F301_02");
				String f30104 = resultSet.getString("F301_04");
				String f30105ZH = resultSet.getString("F301_05");
				String f30106 = resultSet.getString("F301_06");
				String f30112 = resultSet.getString("F301_12");
				String f30131 = resultSet.getString("F301_31");
				String f30117 = resultSet.getString("F301_17");
				String f30503Str = resultSet.getString("f305_03_str");
				String f30504Str = resultSet.getString("f305_04_str");
				String f30512Str = resultSet.getString("f305_12_str");
				String f30508Zh = resultSet.getString("f305_08_zh");

				vf305 = new VF305();
				vf305.setF30501(f30501);
				vf305.setF30502(f30502);
				vf305.setF30503(f30503);
				vf305.setF30504(f30504);
				vf305.setF30505(f30505);
				vf305.setF30506(f30506);
				vf305.setF30507(f30507);
				vf305.setF30508(f30508);
				vf305.setF30509(f30509);
				vf305.setF30510(f30510);
				vf305.setF30511(f30511);
				vf305.setF30512(f30512);
				vf305.setF30513(f30513);
				vf305.setF30514(f30514);
				vf305.setF30515(f30515);
				vf305.setF30516(f30516);
				vf305.setF30517(f30517);
				vf305.setF30518(f30518);
				vf305.setF30519(f30519);
				vf305.setF30520(f30520);

				vf305.setF30503Str(f30503Str);
				vf305.setF30504Str(f30504Str);
				vf305.setF30512Str(f30512Str);
				vf305.setF30508Zh(f30508Zh);

				vf305.setF30102(f30102ZH);
				vf305.setF30104(f30104);
				vf305.setF30105(f30105ZH);
				vf305.setF30106(f30106);
				vf305.setF30112(f30112);
				vf305.setF30117(f30117);
				vf305.setF30131(f30131);
				vf305.setF30502(f30502);

				vf305s.add(vf305);
			}
			f305Response.setState(state);
			f305Response.setVf305s(vf305s);
		} catch (Exception e) {
			e.printStackTrace();
			f305Response.setState(false);
			f305Response.setErrorMessage("查询失败！");
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
		return f305Response;
	}

	@Override
	@SuppressWarnings("unchecked")
	public F305Response saveF305(F305 f305) {
		F305Response f305Response = new F305Response();
		long f30502 = f305.getF30502();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String f30503 = sdf.format(f305.getF30503());
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			StringBuffer sql = new StringBuffer("select * from F305 t where 1=1 ");
			if (f30502 !=0) {
				sql.append("and t.f305_02 ='" + f30502 + "' ");
			}
			if (f30503 != null) {
				sql.append("and t.f305_03 = to_date('" + f30503
						+ "','yyyy-MM-dd')");
			}
			SQLQuery query = session.createSQLQuery(sql.toString());
			List<F305> f305s = query.addEntity(F305.class).list();
			if (f305s.size() > 0) {
				state = false;
				f305Response.setErrorMessage("重复保存！");
			}
		} catch (Exception e) {
			state = false;
			f305Response.setErrorMessage("保存出错! ");
			e.printStackTrace();
		}
		if (state) {
			try {
				session.save(f305);
				session.flush();
				session.refresh(f305);
			} catch (Exception e) {
				state = false;
				f305Response.setErrorMessage("保存出错! ");
				e.printStackTrace();
			}
		}

		f305Response.setState(state);
		return f305Response;
	}

	@Override
	public F305Response updateF305(F305 f305) {
		F305Response f305Response = new F305Response();
		Session session = sessionFactory.getCurrentSession();
		boolean state = true;
		try {
			session.saveOrUpdate(f305);
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage.append(e.getMessage());
			f305Response.setErrorMessage(errorMessage.toString());
			state = false;
		}
		f305Response.setState(state);
		return f305Response;
	}

	@Override
	public F305Response deleteF305(F305Request f305Request) {
		F305Response f305Response = new F305Response();
		long f30501 = Long.parseLong(f305Request.getF30501());
		try {
			Session session = sessionFactory.getCurrentSession();
			F305 f305 = new F305();
			f305.setF30501(f30501);
			session.delete(f305);
			f305Response.setPromptMessage("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			f305Response.setErrorMessage("删除失败！");
		}

		return f305Response;
	}
}
