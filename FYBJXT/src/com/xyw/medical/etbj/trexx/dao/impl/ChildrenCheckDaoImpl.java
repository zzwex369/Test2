package com.xyw.medical.etbj.trexx.dao.impl;

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

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.etbj.model.E303;
import com.xyw.medical.etbj.model.E303Request;
import com.xyw.medical.etbj.model.E303Response;
import com.xyw.medical.etbj.model.VE303;
import com.xyw.medical.etbj.trexx.dao.ChildrenCheckDao;
import com.xyw.sys.util.StringUtil;

public class ChildrenCheckDaoImpl implements ChildrenCheckDao {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private DataSource dataSource;

	@Override
	public E303Response saveE303(E303 e303) {
		E303Response e303Response = new E303Response();
		 long e303_02 =e303.getE30302();
		// Date e303_05 =e303.getE30305();

		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			StringBuffer sql = new StringBuffer("select * from E303 t where 1=1 ");
//			if (e303.getE30319() != null) {
//				sql.append(" and t.e303_19='" + e303.getE30319() + "' ");
//			}
			if(e303_02 !=0){
				sql.append(" and t.e303_02='" + e303_02 + "' ");
			}
			SQLQuery query = session.createSQLQuery(sql.toString());
			int e303size = query.addEntity(E303.class).list().size();
			if (e303size > 0) {
				state = false;
				e303Response.setErrorMessage("重复保存！");
			}
		} catch (Exception e) {
			state = false;
			e303Response.setErrorMessage("保存失败!");
			e.printStackTrace();
		}
		if (state) {
			try {
				session.save(e303);
				e303Response.setPromptMessage("保存成功！");
			} catch (Exception e) {
				e.printStackTrace();
				e303Response.setErrorMessage("保存失败!");
				state = false;
			}
		}
		e303Response.setState(state);
		return e303Response;
	}

	@Override
	public E303Response queryE303(E303Request e303Request) {
		E303Response e303Response = new E303Response();
		// long e303_02 =e303Request.getE30302();//这个字段前台没有传过来=============
		String e303_03 = e303Request.getE30303();// 儿童姓名
		String e303_13 = e303Request.getE30313();// 检查机构
		Date e30306Start = e303Request.getE30306Start();// 开始时间
		Date e30306End = e303Request.getE30306End();// 结束时间
		String e303_19 = e303Request.getE30319();
		int parameterPageindex = e303Request.getParameterPageindex();
		int parameterPagesize = e303Request.getParameterPagesize();
		String f301_02 = e303Request.getF30102();// 产妇姓名
		String f301_05 = e303Request.getF30105();// 产妇身份证号
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sql = new StringBuffer();
		if (!StringUtil.isBlankString(e303_03)) {
			sql.append(" and t.e303_03='" + e303_03 + "' ");
		}
		if (e30306Start != null) {
			String timeStart = sdf.format(e30306Start);
			sql.append(" and t.e303_06_Str >='" + timeStart + "' ");
		}
		if (!StringUtil.isBlankString(e303_13)) {
			sql.append(" and t.e303_13 like'" + e303_13 + "%' ");
		}
		if (e30306End != null) {
			String timeEnd = sdf.format(e30306End);
			sql.append(" and t.e303_06_Str <='" + timeEnd + "' ");
		}
		if (!StringUtil.isBlankString(e303_19)) {
			sql.append(" and t.e303_19='" + e303_19 + "' ");
		}
		if (!StringUtil.isBlankString(f301_02)) {
			sql.append(" and t.f301_02='" + f301_02 + "' ");
		}
		if (!StringUtil.isBlankString(f301_05)) {
			sql.append(" and t.f301_05='" + f301_05 + "' ");
		}

		boolean state = true;
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_E303");
			callableStatement.setString(4, sql.toString());
			callableStatement.setString(5, "t.e303_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			System.out.println(sql.toString());
			long rowCount = callableStatement.getLong(6);
			e303Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VE303 ve303 = null;
			List<VE303> ve303s = new ArrayList<VE303>();
			while (resultSet.next()) {
				long e30301 = resultSet.getLong("E303_01");
				long e30302 = resultSet.getLong("E303_02");
				String e30303 = resultSet.getString("E303_03");
				String e30304 = resultSet.getString("E303_04");
				Date e30305 = resultSet.getDate("E303_05");
				Date e30306 = resultSet.getDate("E303_06");
				String e30307 = resultSet.getString("e303_07");
				String e30308 = resultSet.getString("E303_08");
				String e30309 = resultSet.getString("E303_09");
				String e30310 = resultSet.getString("E303_10");
				String e30311 = resultSet.getString("E303_11");
				Date e30312 = resultSet.getDate("E303_12");
				String e30313 = resultSet.getString("E303_13");
				String e30314 = resultSet.getString("E303_14");
				String e30315 = resultSet.getString("E303_15");
				String e30316 = resultSet.getString("E303_16");
				String e30317 = resultSet.getString("E303_17");
				Date e30318 = resultSet.getDate("E303_18");
				String e30319 = resultSet.getString("E303_19");
				String e30320 = resultSet.getString("E303_20");
				String e30321 = resultSet.getString("E303_21");
				String e30322 = resultSet.getString("E303_22");
				String e30323 = resultSet.getString("E303_23");
				String e30324 = resultSet.getString("E303_24");
				String e30325 = resultSet.getString("E303_25");
				String e30326 = resultSet.getString("E303_26");
				String e30327 = resultSet.getString("E303_27");
				String e30328 = resultSet.getString("E303_28");
				String e30329 = resultSet.getString("E303_29");
				String e30330 = resultSet.getString("E303_30");
				String e30331 = resultSet.getString("E303_31");
				String e30332 = resultSet.getString("E303_32");
				String e30333 = resultSet.getString("E303_33");
				String e30334 = resultSet.getString("E303_34");
				String e30335 = resultSet.getString("E303_35");
				String e30336 = resultSet.getString("E303_36");
				String e30337 = resultSet.getString("E303_37");
				String e30338 = resultSet.getString("E303_38");
				String e30339 = resultSet.getString("E303_39");
				String e30340 = resultSet.getString("E303_40");
				String e30341 = resultSet.getString("E303_41");
				String e30342 = resultSet.getString("E303_42");
				String e30343 = resultSet.getString("E303_43");
				String e30344 = resultSet.getString("E303_44");
				String e30345 = resultSet.getString("E303_45");
				String e30346 = resultSet.getString("E303_46");
				String e30347 = resultSet.getString("E303_47");
				String e30348 = resultSet.getString("E303_48");
				String e30349 = resultSet.getString("E303_49");
				String e30350 = resultSet.getString("E303_50");

				String e30304Zh = resultSet.getString("E303_04_ZH");
				String e30305Str = resultSet.getString("E303_05_Str");
				String e30306Str = resultSet.getString("E303_06_Str");
				String e30312Str = resultSet.getString("E303_12_Str");
				String e30313Zh = resultSet.getString("E303_13_ZH");
				String e30315Zh = resultSet.getString("E303_15_ZH");
				String e30316Zh = resultSet.getString("E303_16_ZH");
				String e30318Str = resultSet.getString("E303_18_Str");

				String f30102 = resultSet.getString("F301_02");
				String f30105 = resultSet.getString("F301_05");
				String f30118 = resultSet.getString("F301_18");
				String f30121 = resultSet.getString("F301_21");

				String e30126 = resultSet.getString("E301_26");
				String e30127 = resultSet.getString("E301_27");
				ve303 = new VE303();
				ve303.setE30301(e30301);
				ve303.setE30302(e30302);
				ve303.setE30303(e30303);
				ve303.setE30304(e30304);
				ve303.setE30305(e30305);
				ve303.setE30306(e30306);
				ve303.setE30307(e30307);
				ve303.setE30308(e30308);
				ve303.setE30309(e30309);
				ve303.setE30310(e30310);
				ve303.setE30311(e30311);
				ve303.setE30312(e30312);
				ve303.setE30313(e30313);
				ve303.setE30314(e30314);
				ve303.setE30315(e30315);
				ve303.setE30316(e30316);
				ve303.setE30317(e30317);
				ve303.setE30318(e30318);
				ve303.setE30319(e30319);
				ve303.setE30320(e30320);
				ve303.setE30321(e30321);
				ve303.setE30322(e30322);
				ve303.setE30323(e30323);
				ve303.setE30324(e30324);
				ve303.setE30325(e30325);
				ve303.setE30326(e30326);
				ve303.setE30327(e30327);
				ve303.setE30328(e30328);
				ve303.setE30329(e30329);
				ve303.setE30330(e30330);
				ve303.setE30331(e30331);
				ve303.setE30332(e30332);
				ve303.setE30333(e30333);
				ve303.setE30334(e30334);
				ve303.setE30335(e30335);
				ve303.setE30336(e30336);
				ve303.setE30337(e30337);
				ve303.setE30338(e30338);
				ve303.setE30339(e30339);
				ve303.setE30340(e30340);
				ve303.setE30341(e30341);
				ve303.setE30342(e30342);
				ve303.setE30343(e30343);
				ve303.setE30344(e30344);
				ve303.setE30345(e30345);
				ve303.setE30346(e30346);
				ve303.setE30347(e30347);
				ve303.setE30348(e30348);
				ve303.setE30349(e30349);
				ve303.setE30350(e30350);

				ve303.setE30304Zh(e30304Zh);
				ve303.setE30305Str(e30305Str);
				ve303.setE30306Str(e30306Str);
				ve303.setE30312Str(e30312Str);
				ve303.setE30313Zh(e30313Zh);
				ve303.setE30315Zh(e30315Zh);
				ve303.setE30316Zh(e30316Zh);
				ve303.setE30318Str(e30318Str);

				ve303.setF30102(f30102);
				ve303.setF30105(f30105);
				ve303.setF30118(f30118);
				ve303.setF30121(f30121);

				ve303.setE30126(e30126);
				ve303.setE30127(e30127);
				ve303s.add(ve303);
			}
			e303Response.setState(state);
			e303Response.setVe303s(ve303s);
		} catch (SQLException e) {
			e.printStackTrace();
			e303Response.setState(false);
			e303Response.setErrorMessage("查询失败！");
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

		return e303Response;
	}

	@Override
	public E303Response updateE303(E303 e303) {
		boolean state = true;
		E303Response e303Response = new E303Response();
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(e303);
		} catch (Exception e) {
			e303Response.setState(false);
			e303Response.setErrorMessage("修改失败! ");
			e.printStackTrace();
		}
		e303Response.setState(state);
		return e303Response;
	}

	@Override
	public E303Response deleteE303(E303Request e303Request) {
		E303Response e303Response = new E303Response();
		long e303_01 = e303Request.getE30301();
		long e303_02 = e303Request.getE30302();
		// String e303_03 =e303Request.getE30303();
		// Date e303_05 =e303Request.getE30305();
		// String e303_13 =e303Request.getE30313();
		// String e303_17 =e303Request.getE30317();
		try {
			Session session = this.sessionFactory.getCurrentSession();

			E303 e303 = new E303();
			e303.setE30301(e303_01);
			e303.setE30302(e303_02);
			session.delete(e303);
			e303Response.setPromptMessage("删除成功！");
		} catch (HibernateException e) {
			e.printStackTrace();
			e303Response.setErrorMessage("删除失败！");
		}
		return e303Response;
	}
}
