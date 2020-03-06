package com.xyw.medical.etbj.hearingScreening.dao.impl;

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

import com.xyw.medical.etbj.hearingScreening.dao.E501Dao;
import com.xyw.medical.etbj.model.E501;
import com.xyw.medical.etbj.model.E501Request;
import com.xyw.medical.etbj.model.E501Response;
import com.xyw.medical.etbj.model.E502;
import com.xyw.medical.etbj.model.VE501;
import com.xyw.sys.util.StringUtil;

/**
 * @author libo 创建时间：Jun 17, 2017 11:45:43 AM
 */
public class E501DaoImpl implements E501Dao {
	@Resource
	private DataSource dataSource;
	@Resource
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public E501Response saveE501(E501 e501) {
		E501Response e501Response = new E501Response();
		e501Response.setState(false);
		e501Response.setErrorMessage("重复保存");
		Session session = sessionFactory.getCurrentSession();
		try {
			if (e501 != null) {
				List<E501> list = null;
				if (e501.getE50102() != 0) {
					list = session.createSQLQuery(
							"select * from E501 e where e.e501_02=?")
							.addEntity(E501.class).setParameter(0,
									e501.getE50102()).list();
				} else {
					SQLQuery sqlQuery = session
							.createSQLQuery(
									"select * from E501 e where e.e501_04=? and e.e501_06=? and e.e501_07=? and e.e501_19=?")
							.addEntity(E501.class);
					list = sqlQuery.setString(0, e501.getE50104()).setString(1,
							e501.getE50106()).setString(2, e501.getE50107())
							.setString(3, e501.getE50119()).list();
				}
				if (list.size() > 0) {
					return e501Response;
				}
				session.save(e501);
				session.flush();
				session.refresh(e501);
				e501Response.setState(true);
				e501Response.setPromptMessage("保存成功");
				return e501Response;
			}
		} catch (Exception e) {
			e501Response.setErrorMessage("保存异常");
		}
		return e501Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E501Response queryHearingScreening(String e50103, String e50104) {
		E501Response e501Response = new E501Response();
		e501Response.setState(false);
		e501Response.setErrorMessage("查询失败");
		StringBuffer sql = new StringBuffer("select t.*	 from v_e501  t where 1=1");
		if (!StringUtil.isBlankString(e50103)) {
			sql.append("and t.e501_03 like '"
							+ e50103 + "%'");
		}
		if (!StringUtil.isBlankString(e50104)) {
			sql.append(" and t.e501_04 = '" + e50104 + "'");
			List<VE501> ve501s = null;
			try {
				Session session=sessionFactory.getCurrentSession();
				ve501s=session.createSQLQuery(sql.toString()).addEntity(VE501.class).list();
			} catch (Exception e) {
				e501Response.setErrorMessage("查询信息异常");
				e.printStackTrace();
				// TODO: handle exception
			} 
			if (ve501s.size() < 1) {
				e501Response.setErrorMessage("暂无数据");
				return e501Response;
			}
			e501Response.setVe501(ve501s);
			e501Response.setState(true);
			e501Response.setPromptMessage("查询成功");
		}
		return e501Response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E501Response deleteE501(E501Request e501Request) {
		E501Response e501Response = new E501Response();
		e501Response.setState(false);
		E501 e501 = new E501();
		try {
			e501.setE50101(e501Request.getE50101());
			Session session = sessionFactory.getCurrentSession();
			E501 _e501 = (E501) session.get(E501.class, e501.getE50101());
			List listE502=session.createSQLQuery("select * from E502 t where t.e502_02=?").addEntity(E502.class).setLong(0, e501.getE50101()).list();
			List listE503=session.createSQLQuery("select * from E503 t where t.e503_02=?").addEntity(E502.class).setLong(0, e501.getE50101()).list();
			if (_e501 == null) {
				e501Response.setErrorMessage("记录不存在");
				return e501Response;
			}
			if (listE502.size()>0) {
				e501Response.setErrorMessage("登记过复查表，无法删除");
				return e501Response;
			}
			if (listE503.size()>0) {
				e501Response.setErrorMessage("登记过听力障碍表，无法删除");
				return e501Response;
			}
			session.delete(_e501);
			e501Response.setState(true);
			e501Response.setPromptMessage("删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e501Response.setState(false);
			e501Response.setErrorMessage("删除异常");
		}
		return e501Response;
	}

	@Override
	public E501Response queryE501(E501Request e501Request) {
		E501Response e501Response = new E501Response();
		E501 e501 = e501Request.getE501();
		String e50103 = e501.getE50103();
		String e50104 = e501.getE50104();
		String e50106 = e501.getE50106();
		String e50119 = e501.getE50119();
		String e50120 = e501.getE50120();
		String flag = e501Request.getFlag();
		Date timeStart = e501Request.getTimeStr();
		Date timeEnd = e501Request.getTimeEnd();
		int parameterPageindex = e501Request.getParameterPageindex();
		int parameterPagesize = e501Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		if ("true".equals(flag)) {
			if (!StringUtil.isBlankString(e50103)) {
				parameterConditionwhere
						.append("and t.e501_03='" + e50103 + "'");
			}
			if (!StringUtil.isBlankString(e50104)) {
				parameterConditionwhere
						.append("and t.e501_04='" + e50104 + "'");
			}
			if (!StringUtil.isBlankString(e50106)) {
				parameterConditionwhere
						.append("and t.e501_06='" + e50106 + "'");
			}
			if (!StringUtil.isBlankString(e50120)) {
				parameterConditionwhere
						.append("and t.e501_20='" + e50120 + "'");
			}
		}
		if ("false".equals(flag)) {
			if (timeStart != null) {
				parameterConditionwhere.append("and t.e501_22_str >='"
						+ sdf.format(timeStart) + "'");
			}
			if (timeEnd != null) {
				parameterConditionwhere.append("and t.e501_22_str <= '"
						+ sdf.format(timeEnd) + "'");
			}
		}
		if (!StringUtil.isBlankString(e50119)) {
			if (e50119.length() == 14) {
				parameterConditionwhere.append(" and t.e501_19 = '");
				parameterConditionwhere.append(e50119);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.e501_19 like '");
				parameterConditionwhere.append(e50119);
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
			callableStatement.setString(3, "V_E501");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.e501_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			e501Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VE501 ve501 = null;
			List<VE501> ve501s = new ArrayList<VE501>();
			while (resultSet.next()) {
				ve501 = new VE501();
				ve501.setE50101(resultSet.getLong("E501_01"));
				ve501.setE50102(resultSet.getLong("E501_02"));
				ve501.setE50103(resultSet.getString("E501_03"));
				ve501.setE50104(resultSet.getString("E501_04"));
				ve501.setE50105(resultSet.getString("E501_05"));
				ve501.setE50106(resultSet.getString("E501_06"));
				ve501.setE50107(resultSet.getString("E501_07"));
				ve501.setE50108(resultSet.getString("E501_08"));
				ve501.setE50109(resultSet.getString("E501_09"));
				ve501.setE50110(resultSet.getDouble("E501_10"));
				ve501.setE50111(resultSet.getString("E501_11"));
				ve501.setE50112(resultSet.getString("E501_12"));
				ve501.setE50113(resultSet.getString("E501_13"));
				ve501.setE50114(resultSet.getString("E501_14"));
				ve501.setE50115(resultSet.getString("E501_15"));
				ve501.setE50116(resultSet.getString("E501_16"));
				ve501.setE50117(resultSet.getString("E501_17"));
				ve501.setE50118(resultSet.getDate("E501_18"));
				ve501.setE50119(resultSet.getString("E501_19"));
				ve501.setE50120(resultSet.getString("E501_20"));
				ve501.setE50121(resultSet.getString("E501_21"));
				ve501.setE50122(resultSet.getDate("E501_22"));
				ve501.setE50123(resultSet.getString("E501_23"));
				ve501.setE50124(resultSet.getString("E501_24"));
				ve501.setE50107Zh(resultSet.getString("E501_07_Zh"));
				ve501.setE50108Str(resultSet.getString("E501_08_Str"));
				ve501.setE50111Zh(resultSet.getString("E501_11_Zh"));
				ve501.setE50112Zh(resultSet.getString("E501_12_Zh"));
				ve501.setE50113Zh(resultSet.getString("E501_13_Zh"));
				ve501.setE50114Zh(resultSet.getString("E501_14_Zh"));
				ve501.setE50115Zh(resultSet.getString("E501_15_Zh"));
				ve501.setE50116Zh(resultSet.getString("E501_16_Zh"));
				ve501.setE50119Zh(resultSet.getString("E501_19_Zh"));
				ve501.setE50123Zh(resultSet.getString("E501_23_Zh"));
				ve501.setE50124Zh(resultSet.getString("E501_24_Zh"));
				ve501.setE50118Str(resultSet.getString("E501_18_Str"));
				ve501.setE50122Str(resultSet.getString("E501_22_Str"));
				ve501.setD60102Zh(resultSet.getString("D601_02_Zh"));
				ve501.setD60166Zh(resultSet.getString("D601_66_Zh"));
				ve501.setD60194Zh(resultSet.getString("D601_94_Zh"));
				ve501s.add(ve501);
			}
			e501Response.setState(true);
			e501Response.setPromptMessage("查询成功");
			e501Response.setVe501(ve501s);
		} catch (Exception e) {
			e501Response.setState(false);
			e501Response.setErrorMessage("查询失败");
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
		return e501Response;
	}

	@Override
	public E501Response renewE501(E501 e501) {
		E501Response e501Response = new E501Response();
		try {
			if (e501 != null) {
				Session session = sessionFactory.getCurrentSession();
				session.saveOrUpdate(e501);
				session.flush();
				session.refresh(e501);
				e501Response.setState(true);
				e501Response.setPromptMessage("更新成功");
			} else {
				e501Response.setState(false);
				e501Response.setErrorMessage("数据为空");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e501Response.setState(false);
			e501Response.setErrorMessage("更新失败");
		}
		return e501Response;
	}
}