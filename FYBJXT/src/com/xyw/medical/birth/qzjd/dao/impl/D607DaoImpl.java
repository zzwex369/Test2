package com.xyw.medical.birth.qzjd.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;
import oracle.jdbc.OracleTypes;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.birth.model.D607;
import com.xyw.medical.birth.model.D607Request;
import com.xyw.medical.birth.model.D607Response;
import com.xyw.medical.birth.model.VD607;
import com.xyw.medical.birth.qzjd.dao.D607Dao;
import com.xyw.sys.util.StringUtil;

public class D607DaoImpl implements D607Dao {

	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;

	@Override
	public D607Response saveD607(D607 d607) {
		D607Response d607Response = new D607Response();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			StringBuffer sql = new StringBuffer(
					"select * from D607 t where 1=1 ");
			if (d607.getD60720() != null) {
				sql.append(" and t.d607_20='" + d607.getD60720() + "' ");
			}
			SQLQuery query = session.createSQLQuery(sql.toString());
			int d607size = query.addEntity(D607.class).list().size();
			if (d607size > 0) {
				state = false;
				d607Response.setErrorMessage("重复保存！");
			}
		} catch (Exception e) {
			state = false;
			d607Response.setErrorMessage("保存失败!");
			e.printStackTrace();
		}
		if (state) {
			try {
				session.save(d607);
				d607Response.setPromptMessage("保存成功！");
			} catch (Exception e) {
				e.printStackTrace();
				d607Response.setErrorMessage("保存失败!");
				state = false;
			}
		}
		d607Response.setState(state);
		return d607Response;
	}

	@Override
	public D607Response queryD607(D607Request d607Request) {
		D607Response d607Response = new D607Response();
		D607 d607 = d607Request.getD607();
		String d60702_ = d607.getD60702();
		String d60704_ = d607.getD60704();
		String d60714_ = d607.getD60714();
		String d60720_ = d607.getD60720();
		int parameterPageindex = d607Request.getParameterPageindex();
		int parameterPagesize = d607Request.getParameterPagesize();
		StringBuffer d607sql = new StringBuffer();
		if (!StringUtil.isBlankString(d60702_)) {
			d607sql.append(" and t.d607_02 = '");
			d607sql.append(d60702_);
			d607sql.append("'");
		}
		if (!StringUtil.isBlankString(d60704_)) {
			d607sql.append(" and t.d607_04 = '");
			d607sql.append(d60704_);
			d607sql.append("'");
		}
		if (!StringUtil.isBlankString(d60714_)) {
			d607sql.append(" and t.d607_14 = '");
			d607sql.append(d60714_);
			d607sql.append("'");
		}
		if (!StringUtil.isBlankString(d60720_)) {
			d607sql.append(" and t.d607_20 = '");
			d607sql.append(d60720_);
			d607sql.append("'");
		}

		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_D607");
			callableStatement.setString(4, d607sql.toString());
			callableStatement.setString(5, "t.d607_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			d607Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);

			VD607 vd607 = null;
			List<VD607> vd607s = new ArrayList<VD607>();

			while (resultSet.next()) {
				long d60701 = resultSet.getLong("D607_01");
				String d60702 = resultSet.getString("D607_02");
				Date d60703 = resultSet.getDate("D607_03");
				String d60703_str = resultSet.getString("D607_03_STR");
				String d60704 = resultSet.getString("D607_04");
				String d60705 = resultSet.getString("D607_05");
				String d60706 = resultSet.getString("D607_06");
				String d60707 = resultSet.getString("D607_07");
				String d60708 = resultSet.getString("D607_08");
				Date d60709 = resultSet.getDate("D607_09");
				String d60709_str = resultSet.getString("D607_09_STR");
				String d60710 = resultSet.getString("D607_10");
				String d60711 = resultSet.getString("D607_11");
				String d60712 = resultSet.getString("D607_12");
				String d60713 = resultSet.getString("D607_13");
				String d60714 = resultSet.getString("D607_14");
				Date d60715 = resultSet.getDate("D607_15");
				String d60715_str = resultSet.getString("D607_15_STR");
				String d60716 = resultSet.getString("D607_16");
				String d60717 = resultSet.getString("D607_17");
				String d60718 = resultSet.getString("D607_18");
				String d60719 = resultSet.getString("D607_19");
				String d60720 = resultSet.getString("D607_20");
				String d60721 = resultSet.getString("D607_21");
				String d60722 = resultSet.getString("D607_22");
				Date d60723 = resultSet.getDate("D607_23");
				String d60723_str = resultSet.getString("D607_23_STR");
				String d60724 = resultSet.getString("D607_24");
				String d60725 = resultSet.getString("D607_25");
				String d60726 = resultSet.getString("D607_26");
				String d60727 = resultSet.getString("D607_27");
				String d60728 = resultSet.getString("D607_28");
				String d60729 = resultSet.getString("D607_29");
				String d60730 = resultSet.getString("D607_30");
				String d60731 = resultSet.getString("D607_31");
				String d60732 = resultSet.getString("D607_32");
				String d60733 = resultSet.getString("D607_33");
				String d60734 = resultSet.getString("D607_34");
				String d60735 = resultSet.getString("D607_35");
				String d60736 = resultSet.getString("D607_36");
				String d60737 = resultSet.getString("D607_37");
				String d60738 = resultSet.getString("D607_38");
				String d60739 = resultSet.getString("D607_39");
				String d60740 = resultSet.getString("D607_40");
				String d60705ZH = resultSet.getString("D607_05_ZH");
				String d60706ZH = resultSet.getString("D607_06_ZH");
				String d60707ZH = resultSet.getString("D607_07_ZH");
				String d60711ZH = resultSet.getString("D607_11_ZH");
				String d60712ZH = resultSet.getString("D607_12_ZH");
				String d60713ZH = resultSet.getString("D607_13_ZH");
				String d60717ZH = resultSet.getString("D607_17_ZH");
				String d60718ZH = resultSet.getString("D607_18_ZH");
				String d60719ZH = resultSet.getString("D607_19_ZH");
				String d60729ZH = resultSet.getString("D607_29_ZH");

				vd607 = new VD607();
				vd607.setD60701(d60701);
				vd607.setD60702(d60702);
				vd607.setD60703(d60703);
				vd607.setD60703_str(d60703_str);
				vd607.setD60704(d60704);
				vd607.setD60705(d60705);
				vd607.setD60706(d60706);
				vd607.setD60707(d60707);
				vd607.setD60708(d60708);
				vd607.setD60709(d60709);
				vd607.setD60709_str(d60709_str);
				vd607.setD60710(d60710);
				vd607.setD60711(d60711);
				vd607.setD60712(d60712);
				vd607.setD60713(d60713);
				vd607.setD60714(d60714);
				vd607.setD60715(d60715);
				vd607.setD60715_str(d60715_str);
				vd607.setD60716(d60716);
				vd607.setD60717(d60717);
				vd607.setD60718(d60718);
				vd607.setD60719(d60719);
				vd607.setD60720(d60720);
				vd607.setD60721(d60721);
				vd607.setD60722(d60722);
				vd607.setD60723(d60723);
				vd607.setD60723_str(d60723_str);
				vd607.setD60724(d60724);
				vd607.setD60725(d60725);
				vd607.setD60726(d60726);
				vd607.setD60727(d60727);
				vd607.setD60728(d60728);
				vd607.setD60729(d60729);
				vd607.setD60730(d60730);
				vd607.setD60731(d60731);
				vd607.setD60732(d60732);
				vd607.setD60733(d60733);
				vd607.setD60734(d60734);
				vd607.setD60735(d60735);
				vd607.setD60736(d60736);
				vd607.setD60737(d60737);
				vd607.setD60738(d60738);
				vd607.setD60739(d60739);
				vd607.setD60740(d60740);
				vd607.setD60705ZH(d60705ZH);
				vd607.setD60706ZH(d60706ZH);
				vd607.setD60707ZH(d60707ZH);
				vd607.setD60711ZH(d60711ZH);
				vd607.setD60712ZH(d60712ZH);
				vd607.setD60713ZH(d60713ZH);
				vd607.setD60717ZH(d60717ZH);
				vd607.setD60718ZH(d60718ZH);
				vd607.setD60719ZH(d60719ZH);
				vd607.setD60729ZH(d60729ZH);

				vd607s.add(vd607);
			}
			d607Response.setVd607s(vd607s);
		} catch (SQLException e) {
			e.printStackTrace();
			d607Response.setErrorMessage("查询失败！");
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
				e.printStackTrace();
			}
		}
		return d607Response;
	}

	@Override
	public D607Response updateD607New(D607 d607) {
		Session session = this.sessionFactory.getCurrentSession();
		D607Response d607Response = new D607Response();
		boolean state = true;
		try {
			session.saveOrUpdate(d607);
			d607Response.setState(state);
			d607Response.setPromptMessage("修改成功");
		} catch (Exception e) {
			state = false;
			d607Response.setState(state);
			d607Response.setErrorMessage("修改失败");
			e.printStackTrace();
		}
		return d607Response;
	}

	@Override
	public D607Response deleteD607(D607Request d607Request) {
		D607Response d607Response = new D607Response();
		D607 d607 = d607Request.getD607();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(d607);

			d607Response.setPromptMessage("删除成功");
		} catch (HibernateException e) {
			e.printStackTrace();

			d607Response.setErrorMessage("删除失败");
		}
		return d607Response;
	}

}
