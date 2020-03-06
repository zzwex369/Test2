package com.xyw.medical.etbj.reviewHearingScreening.dao.impl;

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

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.etbj.model.E502;
import com.xyw.medical.etbj.model.E502Request;
import com.xyw.medical.etbj.model.E502Response;
import com.xyw.medical.etbj.model.VE502;
import com.xyw.medical.etbj.reviewHearingScreening.dao.E502Dao;
import com.xyw.sys.util.StringUtil;

public class E502DaoImpl implements E502Dao {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private DataSource dataSource;

	@SuppressWarnings("unchecked")
	@Override
	public E502Response saveE502(E502 e502) {
		E502Response e502Response = new E502Response();
		e502Response.setState(false);
		try {
			if (e502 == null) {
				e502Response.setErrorMessage("非法传值");
				return e502Response;
			}
			Session session = sessionFactory.getCurrentSession();
			if (e502.getE50202() != 0) {
				List<E502> list = session.createSQLQuery(
						"select * from E502 e where e.e502_02=?").addEntity(
						E502.class).setLong(0, e502.getE50202()).list();
				if (list.size() > 0) {
					e502Response.setErrorMessage("保存重复");
					return e502Response;
				}
				session.save(e502);
				session.flush();
				session.refresh(e502);
				e502Response.setState(true);
				e502Response.setPromptMessage("保存成功");
			}
		} catch (Exception e) {
			e502Response.setState(false);
			e502Response.setErrorMessage("保存失败");
		}

		return e502Response;
	}

	@Override
	public E502Response deleteE502(E502Request e502Request) {
		E502Response e502Response = new E502Response();
		E502 e502 = new E502();
		try {
			e502.setE50201(e502Request.getE50201());
			Session session = sessionFactory.getCurrentSession();
			E502 _e502 = (E502) session.get(E502.class, e502.getE50201());
			if (_e502 == null) {
				e502Response.setState(false);
				e502Response.setErrorMessage("记录不存在");
				return e502Response;
			}
			session.delete(_e502);
			e502Response.setState(true);
			e502Response.setPromptMessage("删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e502Response.setState(false);
			e502Response.setErrorMessage("删除异常");
			e.printStackTrace();
		}
		return e502Response;
	}

	@Override
	public E502Response queryE502(E502Request e502Request) {
		E502Response e502Response = new E502Response();
		E502 e502_ = e502Request.getE502();
		String e50205 = e502_.getE50205();
		String e50206 = e502_.getE50206();
		String e50208 = e502_.getE50208();
		String e50209 = e502_.getE50209();
		String e50231 = e502_.getE50231();
		String flag = e502Request.getFlag();
		Date timeStr_ = e502Request.getTimeStr();
		Date timeEnd_ = e502Request.getTimeEnd();
		int parameterPageindex = e502Request.getParameterPageindex();
		int parameterPagesize = e502Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		if ("true".equals(flag)) {
			if (!StringUtil.isBlankString(e50205)) {
				parameterConditionwhere.append("and t.e502_05 ='" + e50205
						+ "' ");
			}
			if (!StringUtil.isBlankString(e50206)) {
				parameterConditionwhere.append("and t.e502_06 ='" + e50206
						+ "' ");
			}
			if (!StringUtil.isBlankString(e50208)) {
				parameterConditionwhere.append("and t.e502_08 ='" + e50208
						+ "' ");
			}
			if (!StringUtil.isBlankString(e50209)) {
				parameterConditionwhere.append("and t.e502_08 ='" + e50209
						+ "' ");
			}
		}
		if ("false".equals(flag)) {
			if (timeStr_ != null) {
				String timeStr = sdf.format(timeStr_);
				parameterConditionwhere.append(" and t.e502_34_str >= '"
						+ timeStr + "'");
			}
			if (timeEnd_ != null) {
				String timeEnd = sdf.format(timeEnd_);
				parameterConditionwhere.append(" and t.e502_34_str <= '"
						+ timeEnd + "'");
			}
		}
		if (!StringUtil.isBlankString(e50231)) {
			if (e50231.length() == 14) {
				parameterConditionwhere.append(" and t.e502_31 = '");
				parameterConditionwhere.append(e50231);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.e502_31 like '");
				parameterConditionwhere.append(e50231);
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
			callableStatement.setString(3, "V_E502");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.e502_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			e502Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VE502 ve502 = null;
			List<VE502> ve502s = new ArrayList<VE502>();
			while (resultSet.next()) {
				ve502 = new VE502(
								resultSet.getLong("E502_01"),
								resultSet.getLong("E502_02"), 
								resultSet.getLong("E502_03"),
								resultSet.getString("E502_04"),
								resultSet.getString("E502_05"),
								resultSet.getString("E502_06"), 
								resultSet.getShort("E502_07"),
							    resultSet.getString("E502_08"), 
							    resultSet.getString("E502_09"),
								resultSet.getShort("E502_10"),
								resultSet.getString("E502_11"),
								resultSet.getString("E502_12"),
								resultSet.getString("E502_13"),
						    	resultSet.getString("E502_14"),
								resultSet.getString("E502_15"),
								resultSet.getString("E502_16"),
								resultSet.getDouble("E502_17"),
								resultSet.getString("E502_18"),
								resultSet.getString("E502_19"),
								resultSet.getString("E502_20"),
								resultSet.getString("E502_21"),
								resultSet.getString("E502_22"),
								resultSet.getString("E502_23"),
								resultSet.getString("E502_24"),
								resultSet.getString("E502_25"),
								resultSet.getShort("E502_26"),
								resultSet.getString("E502_27"),
								resultSet.getString("E502_28"),
								resultSet.getString("E502_29"),
								resultSet.getDate("E502_30"),
								resultSet.getString("E502_31"),
								resultSet.getString("E502_32"),
								resultSet.getString("E502_33"),
								resultSet.getDate("E502_34"),
								resultSet.getString("E502_35"),
								resultSet.getString("E502_36"),
								resultSet.getString("E502_37"),
								resultSet.getString("E502_38"),
								resultSet.getString("E502_39"),
								resultSet.getString("E502_40"),
								resultSet.getString("E502_41"),
								resultSet.getString("E502_42"),
								resultSet.getString("E502_43"),
								resultSet.getString("E502_44"),
								resultSet.getString("E502_45"),
								resultSet.getString("E502_46"),
								resultSet.getString("E502_47"),
								resultSet.getString("E502_48"),
								resultSet.getString("E502_49"),
								resultSet.getString("E502_50"),
								resultSet.getString("E502_18_Zh"),
								resultSet.getString("E502_21_Zh"),
								resultSet.getString("E502_22_Zh"),
								resultSet.getString("E502_23_Zh"),
								resultSet.getString("E502_24_Zh"),
								resultSet.getString("E502_27_Zh"), 
								resultSet.getString("E502_31_Zh"),
								resultSet.getString("E502_15_Str"),
								resultSet.getString("E502_30_Str"),
								resultSet.getString("E502_34_Str"));
				ve502s.add(ve502);
			}
			e502Response.setVe502(ve502s);
			e502Response.setState(true);
			e502Response.setPromptMessage("查询成功");
		} catch (Exception e) {
			// TODO: handle exception
			e502Response.setState(false);
			e502Response.setErrorMessage("查询失败");
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
		return e502Response;
	}

	@Override
	public E502Response renewE502(E502 e502) {
		E502Response e502Response = new E502Response();
		try {
			if (e502 != null) {
				Session session = sessionFactory.getCurrentSession();
				session.saveOrUpdate(e502);
				session.flush();
				session.refresh(e502);
				e502Response.setState(true);
				e502Response.setPromptMessage("更新成功");
			} else {
				e502Response.setState(false);
				e502Response.setErrorMessage("数据为空");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e502Response.setState(false);
			e502Response.setErrorMessage("更新失败");
		}
		return e502Response;
	}

}
