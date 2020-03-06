package com.xyw.medical.etbj.etjcdj.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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

import com.xyw.medical.etbj.etjcdj.dao.E304Dao;
import com.xyw.medical.etbj.model.E304;
import com.xyw.medical.etbj.model.E304Request;
import com.xyw.medical.etbj.model.E304Response;
import com.xyw.medical.etbj.model.VE304;
import com.xyw.sys.util.StringUtil;

public class E304DaoImpl implements E304Dao {

	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;

	@Override
	public E304Response saveE304(E304 e304) {
		E304Response e304Response = new E304Response();
		String e304_02 = e304.getE30402();
		String e304_03 = e304.getE30403();
		String e304_50 = e304.getE30450();
		

		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		StringBuffer sql = new StringBuffer(
					"select max(e304_51_str),max(e304_45_zh) from v_e304 t where 1=1 ");
		if (e304_02 != "" || e304_02 != null) {
				sql.append(" and t.e304_02='" + e304_02 + "' ");
		}
		if (!StringUtil.isBlankString(e304_03)) {
				sql.append(" and t.e304_03='" + e304_03 + "' ");
		}
		if(!StringUtil.isBlankString(e304_50)){
				sql.append(" and t.e304_50='" + e304.getE30450() + "' ");
		}

		Object[] e304Fields = (Object[])session.createSQLQuery(sql.toString())
									.uniqueResult();
		if (e304Fields[0]!= null) {
				state = false;
				e304Response.setErrorMessage("该信息已经被" + e304Fields[1]
							+ "于"+e304Fields[0]+ "登记过检查信息，不能重复登记！");
				
		}
		
		if (state) {
			try {
				session.save(e304);
				session.flush();
				session.refresh(e304);
			} catch (Exception e) {
				e.printStackTrace();
				e304Response.setErrorMessage("保存失败!");
				state = false;
			}
		}

		e304Response.setState(state);
		return e304Response;
	}

	
	@Override
	public E304Response queryE304H(E304Request e304Request) {
		E304Response e304Response = new E304Response();
			Session session = sessionFactory.getCurrentSession();
			E304 e305 = (E304) session.get(E304.class, e304Request.getE304().getE30401());
			e304Response.setE304(e305);
		return e304Response;
	}

	@Override
	public E304Response updateE304(E304 e304) {
		boolean state = true;
		StringBuffer errorMessage=new StringBuffer();
		E304Response e304Response = new E304Response();
		Session session = this.sessionFactory.getCurrentSession();
		try {
			List e30401s=session.createSQLQuery("select e304_01 from e304" +
					" where e304_02=? and e304_03=? and e304_50=?")
					.setParameter(0, e304.getE30402())
					.setParameter(1, e304.getE30403())
					.setParameter(2, e304.getE30450())
					.list();
			if(e30401s.size()>1){
				state=false;
				e304Response.setState(state);
				errorMessage.append("修改失败,数据异常！ ");
			}else if(e30401s.size()==1){
				if(Long.parseLong(e30401s.get(0).toString())!=e304.getE30401()){
					state=false;
					errorMessage.append("修改失败,存在相同的月龄信息，不能修改!！ ");	
				}
			}
			if(state)
				session.saveOrUpdate(e304);
		} catch (Exception e) {
			state=false;
			errorMessage.append("修改失败! ");
		}
		e304Response.setState(state);
		e304Response.setErrorMessage(errorMessage.toString());
		return e304Response;
	}

	@Override
	public E304Response deleteE304(E304Request e304Request) {
		E304Response e304Response = new E304Response();
		try {
			Session session = sessionFactory.getCurrentSession();
			E304 e304 = new E304();
			
			session.delete(e304Request.getE304());
			e304Response.setPromptMessage("删除成功！");
		} catch (HibernateException e) {
			e.printStackTrace();
			e304Response.setErrorMessage("删除失败！");
		}
		return e304Response;
	}

	
	@Override
	public E304Response queryE304(E304Request e304Request) {
		boolean state = true;
		
		E304Response e304Response = new E304Response();
		int count_e304_02 = (int) e304Request.getCount_e30402();
		E304 e304=e304Request.getE304();
		String e304_02 = e304.getE30402();
		String e304_02_start = e304Request.getE30402start();
		String e304_02_end = e304Request.getE30402end();
		
		String e304_03 = e304.getE30403();
		
		String e304_45 = e304.getE30445();

		String e304_49 = e304Request.getF301_02();
		String e304_50 = e304Request.getF301_05();
		
		
		Date e30114Start = e304Request.getE30405Start();
		Date e30114End = e304Request.getE30405End();
		
		Date e30451Start = e304Request.getE30451start();
		Date e30451End = e304Request.getE30451end();
		
		String flag = e304Request.getFlag();

		int parameterPageindex = e304Request.getParameterPageindex();
		int parameterPagesize = e304Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sql = new StringBuffer();
		
		if(e304_02_start != null && e304_02_end != null){
			count_e304_02 = 0;
		}
		
		if(e304_02 != null  && e304_02 != ""){
			sql.append(" and t.E304_02 = '" + e304_02 + "'");
		}
		if(e304_02_start != null  && e304_02_start != ""){
			sql.append(" and t.E304_02 >= " + e304_02_start);
		}
		if(e304_02_end != null  && e304_02 != ""){
			sql.append(" and t.E304_02 <= " + e304_02_end);
		}
		
		if(e304_03 != "" && e304_03 != null){
			sql.append(" and t.E304_03 = '" + e304_03 + "'");
		}
		if (count_e304_02 == 1) {
			sql.append("and to_number(t.e304_02) < 13");
		} else if (count_e304_02 == 2) {
			sql.append("and to_number(t.e304_02) < 21 and to_number(t.e304_02)>12");
		} else if (count_e304_02 == 3) {
			sql.append("and to_number(t.e304_02) > 20");
		}
		if(e304_49 != null && e304_49 != ""){
			sql.append(" and t.E304_49 = '" + e304_49 + "'");
		}
		if(e304_50 != null && e304_50 != ""){
			sql.append(" and t.E304_50 = '" + e304_50 + "'");
		}
		if(e30114Start != null){
			String e30404Start_ = sdf.format(e30114Start);
			sql.append(" and t.e304_04_Str >='" + e30404Start_ + "' ");
		}
		if(e30114End != null){
			String e30404End_ = sdf.format(e30114End);
			sql.append(" and t.e304_04_Str <='" + e30404End_ + "' ");
		}
		if(e30451Start != null){
			String e30451Start_ = sdf.format(e30451Start);
			sql.append(" and t.e304_51_Str >= '" + e30451Start_ +"'");
		}
		if(e30451End != null){
			String e30451End_ = sdf.format(e30451End);
			sql.append(" and t.e304_51_Str <= '" + e30451End_ +"'");
		}
		if (!StringUtil.isBlankString(e304_45)) {
			if (e304_45.length() == 14) {
				sql.append(" and t.e304_45 = '");
				sql.append(e304_45);
				sql.append("'");
			} else {
				sql.append(" and t.e304_45 like '");
				sql.append(e304_45);
				sql.append("%'");
			}
		}
	
		
		if(flag != null){
			if(flag.equals("et")){
				String e301_49 = e304.getE30449();
				String e301_50 = e304.getE30450();
				if (e301_49 != null) {
					sql.append(" and t.e304_49 ='" + e301_49 + "' ");
				}
				if (e301_50 != null) {
					sql.append(" and t.e304_50 ='" + e301_50 + "' ");
				}
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
			callableStatement.setString(3, "V_E304");
			callableStatement.setString(4, sql.toString());
			callableStatement.setString(5, "t.e304_04 desc");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			e304Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VE304 ve304 = null;
			List<VE304> ve304s = new ArrayList<VE304>();
			while (resultSet.next()) {
				long e30401 = resultSet.getLong("E304_01");
				String e30402 = resultSet.getString("E304_02");
				String e30403 = resultSet.getString("E304_03");
				Date e30404 = resultSet.getDate("E304_04");
				double e30405 = resultSet.getDouble("E304_05");
				double e30407 = resultSet.getDouble("e304_07");
				String e30434 = resultSet.getString("E304_34");
				Date e30437 = resultSet.getDate("E304_37");
				String e30438 = resultSet.getString("E304_38");
				long e30440 = resultSet.getLong("E304_40");
				
				String e30449 = resultSet.getString("E304_49");
				String e30450 = resultSet.getString("E304_50");
				Date   e30451 = resultSet.getDate("E304_51");
				String e30452 = resultSet.getString("E304_52");
				String e30402ZH = resultSet.getString("E304_02_ZH");
				String e30430ZH = resultSet.getString("E304_30_ZH");
				String e30431ZH = resultSet.getString("E304_31_ZH");
				String e30433ZH = resultSet.getString("E304_33_ZH");
				String e30445ZH = resultSet.getString("E304_45_ZH");
				String e30404_Str = resultSet.getString("E304_04_Str");
				String e30437_Str = resultSet.getString("E304_37_Str");
				ve304 = new VE304();
				ve304.setE30401(e30401);
				ve304.setE30402(e30402);
				ve304.setE30403(e30403);
				ve304.setE30404(e30404);
				ve304.setE30405(e30405);
				ve304.setE30407(e30407);
				ve304.setE30434(e30434);
				ve304.setE30437(e30437);
				ve304.setE30438(e30438);
				ve304.setE30440(e30440);
				
				ve304.setE30402ZH(e30402ZH);
				ve304.setE30431ZH(e30431ZH);
				ve304.setE30430ZH(e30430ZH);
				ve304.setE30433ZH(e30433ZH);
				ve304.setE30445ZH(e30445ZH);
				ve304.setE30404Str(e30404_Str);
				ve304.setE30437Str(e30437_Str);
				ve304.setE30449(e30449);
				ve304.setE30450(e30450);
				ve304.setE30451(e30451);
				ve304.setE30452(e30452);
				ve304s.add(ve304);
			}
			e304Response.setState(state);
			e304Response.setVe304s(ve304s);
		} catch (SQLException e) {
			e.printStackTrace();
			e304Response.setState(false);
			e304Response.setErrorMessage("查询失败！");
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

		return e304Response;
	}
	
	@Override
	public E304Response queryE304D(E304Request e304Request) {
		E304Response e304Response = new E304Response();
		long e304_40 = e304Request.getE304().getE30440();
		long count = e304Request.getCount_e30402();
		if (e304_40 > 0) {
			Connection connection = null;
			PreparedStatement callableStatement = null;
			try {
				StringBuffer sql = new StringBuffer("select * from v_e304 t where t.e304_40 ='"+ e304_40 + "'");
				if (count == 1) {
					sql.append(" and to_number(t.e304_02) < 13");
				} else if (count == 2) {
					sql.append(" and to_number(t.e304_02) < 21 and to_number(t.e304_02)>12");
				} else if (count == 3) {
					sql.append(" and to_number(t.e304_02) > 20");
				}
				sql.append(" order by t.e304_04 desc");

				connection = this.dataSource.getConnection();
				callableStatement = connection.prepareStatement(sql.toString());

				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.executeQuery();
				VE304 ve304 = null;
				List<VE304> ve304s = new ArrayList<VE304>();
				while(resultSet.next()){
					Long e30401 = resultSet.getLong("E304_01");
					String e30402 = resultSet.getString("E304_02");
					String e30403 = resultSet.getString("E304_03");
					String e30449 = resultSet.getString("E304_49");
					String e30404_Str = resultSet.getString("E304_04_Str");
					String e30445ZH = resultSet.getString("E304_45_ZH");
					ve304 = new VE304();

					ve304.setE30401(e30401);
					ve304.setE30402(e30402);
					ve304.setE30403(e30403);
					ve304.setE30449(e30449);
					ve304.setE30404Str(e30404_Str);
					ve304.setE30445ZH(e30445ZH);
					ve304s.add(ve304);
				}
				e304Response.setState(true);
				e304Response.setVe304s(ve304s);
			} catch (Exception e) {
				e.printStackTrace();
				e304Response.setState(false);
				e304Response.setErrorMessage("查询失败！");
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
		}
		return e304Response;
	}
	public E304Response queryE304All(E304Request e304Request) {
		E304Response e304Response = new E304Response();
		E304 e304=e304Request.getE304();
		String e30403_ = e304.getE30403();
		String e30449_ = e304.getE30449();
		String e30450_ = e304.getE30450();
		List<VE304> ve304s = new ArrayList<VE304>();
		VE304 ve304 = null;
		boolean state = true;
		try{
			Session session = sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<VE304> list = session
					.createSQLQuery("select * from V_E304 t where t.e304_03 ='"
							+ e30403_ + "' and t.e304_49='"+e30449_+"' and t.e304_50='"+e30450_+"'").addEntity(VE304.class).list();
			for(int i =0;i<list.size();i++){
				ve304 = new VE304();
				String e30402 = list.get(i).getE30402();
				String e30403 = list.get(i).getE30403();
				Date e30404 = list.get(i).getE30404();
				Double e30405 = list.get(i).getE30405();
				String e30406 = list.get(i).getE30406();
				Double e30407 = list.get(i).getE30407();
				String e30408 = list.get(i).getE30408();
				Double e30409 = list.get(i).getE30409();
				String e30410 = list.get(i).getE30410();
				String e30411 = list.get(i).getE30411();
				String e30412 = list.get(i).getE30412();
				Double e30413 = list.get(i).getE30413();
				Double e30414 = list.get(i).getE30414();
				String e30415 = list.get(i).getE30415();
				String e30416 = list.get(i).getE30416();
				String e30417 = list.get(i).getE30417();
				String e30418 = list.get(i).getE30418();
				String e30419 = list.get(i).getE30419();
				String e30420 = list.get(i).getE30420();
				String e30421 = list.get(i).getE30421();
				String e30422 = list.get(i).getE30422();
				String e30423 = list.get(i).getE30423();
				String e30424 = list.get(i).getE30424();
				String e30425 = list.get(i).getE30425();
				String e30426 = list.get(i).getE30426();
				long e30427 = list.get(i).getE30427();
				long e30428 = list.get(i).getE30428();
				long e30429 = list.get(i).getE30429();
				String e30430 = list.get(i).getE30430();
				String e30431 = list.get(i).getE30431();
				String e30432 = list.get(i).getE30432();
				String e30433 = list.get(i).getE30433();
				String e30434 = list.get(i).getE30434();
				String e30435 = list.get(i).getE30435();
				String e30436 = list.get(i).getE30436();
				Date e30437 = list.get(i).getE30437();
				String e30438 = list.get(i).getE30438();
				String e30439 = list.get(i).getE30439();
				long e30440 = list.get(i).getE30440();
				String e30441 = list.get(i).getE30441();
				String e30442 = list.get(i).getE30442();
				String e30443 = list.get(i).getE30443();
				String e30444 = list.get(i).getE30444();
				String e30445 = list.get(i).getE30445();
				String e30446 = list.get(i).getE30446();
				String e30447 = list.get(i).getE30447();
				String e30448 = list.get(i).getE30448();
				String e30449 = list.get(i).getE30449();
				String e30450 = list.get(i).getE30450();
				Date e30451 = list.get(i).getE30451();
				String e30452 = list.get(i).getE30452();
				String e30404_Str = list.get(i).getE30404Str();
				String e30445ZH = list.get(i).getE30445ZH();
				ve304.setE30402(e30402);
				ve304.setE30403(e30403);
				ve304.setE30404(e30404);
				ve304.setE30405(e30405);
				ve304.setE30406(e30406);
				ve304.setE30407(e30407);
				ve304.setE30408(e30408);
				ve304.setE30409(e30409);
				ve304.setE30410(e30410);
				ve304.setE30411(e30411);
				ve304.setE30412(e30412);
				ve304.setE30413(e30413);
				ve304.setE30414(e30414);
				ve304.setE30415(e30415);
				ve304.setE30416(e30416);
				ve304.setE30417(e30417);
				ve304.setE30418(e30418);
				ve304.setE30419(e30419);
				ve304.setE30420(e30420);
				ve304.setE30421(e30421);
				ve304.setE30422(e30422);
				ve304.setE30423(e30423);
				ve304.setE30424(e30424);
				ve304.setE30425(e30425);
				ve304.setE30426(e30426);
				ve304.setE30427(e30427);
				ve304.setE30428(e30428);
				ve304.setE30429(e30429);
				ve304.setE30430(e30430);
				ve304.setE30431(e30431);
				ve304.setE30432(e30432);
				ve304.setE30433(e30433);
				ve304.setE30434(e30434);
				ve304.setE30435(e30435);
				ve304.setE30436(e30436);
				ve304.setE30437(e30437);
				ve304.setE30438(e30438);
				ve304.setE30439(e30439);
				ve304.setE30440(e30440);
				ve304.setE30441(e30441);
				ve304.setE30442(e30442);
				ve304.setE30443(e30443);
				ve304.setE30444(e30444);
				ve304.setE30445(e30445);
				ve304.setE30446(e30446);
				ve304.setE30447(e30447);
				ve304.setE30448(e30448);
				ve304.setE30449(e30449);
				ve304.setE30450(e30450);
				ve304.setE30451(e30451);
				ve304.setE30452(e30452);
				ve304.setE30404Str(e30404_Str);
				ve304.setE30445ZH(e30445ZH);
				ve304s.add(ve304);
				
			}
			
		}catch(Exception e){
			state = false;
			e.printStackTrace();
		}
		e304Response.setVe304s(ve304s);
		e304Response.setState(state);
		return e304Response;
	}


	@Override
	public E304Response queryPhasesE304(E304Request e304Request) {
		boolean state = true;
		E304Response e304Response = new E304Response();
		String flag = e304Request.getFlag();
		String sqlSuffix = e304Request.getSql();
		E304 e304=e304Request.getE304();
		long e30401 = e304.getE30401();
		String e30402 = e304.getE30402();
		String e30403 = e304.getE30403();
		long e30440 = e304.getE30440();
		String e30445 = e304.getE30445();

		String e30449 = e304.getE30449();
		String e30450 = e304.getE30450();
		String e30457 = e304.getE30457();
		String e30458 = e304.getE30458();
		int pageIndex = e304Request.getParameterPageindex();
		int pageSize = e304Request.getParameterPagesize();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sql = new StringBuffer();
		if (e30401!=0) {
			sql.append(" and t.e304_01 = " + e30401 + "");
		}
		if (!StringUtil.isBlankString(e30402)) {
			sql.append(" and t.e304_02 = '" + e30402 + "'");
		}
		if (!StringUtil.isBlankString(e30403)) {
			sql.append(" and t.e304_03 = '" + e30403 + "'");
		}
		
		if (e30440!=0) {
			sql.append(" and t.e304_40 = " + e30440 + "");
		}
		
		if (!StringUtil.isBlankString(e30449)) {
			sql.append(" and t.e304_49 = '" + e30449 + "'");
		}
		
		if (!StringUtil.isBlankString(e30450)) {
			sql.append(" and t.e304_50 = '" + e30450 + "'");
		}
		if (!StringUtil.isBlankString(e30457)) {
			sql.append(" and t.e304_57 = '" + e30457 + "'");
		}
		
		if (!StringUtil.isBlankString(e30458)) {
			sql.append(" and t.e304_58 = '" + e30458 + "'");
		}
		if (!StringUtil.isBlankString(sqlSuffix)) {
			sql.append(sqlSuffix.toString());
		}
		
		if (!StringUtil.isBlankString(e30445)) {
			if (e30445.length() == 14) {
				sql.append(" and t.e304_45 = '");
				sql.append(e30445);
				sql.append("'");
			} else {
				sql.append(" and t.e304_45 like '");
				sql.append(e30445);
				sql.append("%'");
			}
		}
		try {
			Session session=sessionFactory.getCurrentSession();
			Object rowCount = session.createSQLQuery("select count(*) from v_e304 t where  1=1 "+sql).uniqueResult();

			List<VE304>ve304s=(List<VE304>) session.createSQLQuery("select * from v_e304 t where 1=1 "
					+sql
					.append("order by e304_51,e304_01").toString())
					.addEntity(VE304.class)
					.setFirstResult((pageIndex - 1) * pageSize)
					.setMaxResults(pageSize).list();
			state=true;
			e304Response.setRowCount(Long.valueOf(rowCount.toString()));
			e304Response.setVe304s(ve304s);
		} catch (Exception e) {
			state=false;
			e304Response.setErrorMessage(e.getMessage());
		}
		
		e304Response.setState(state);
		return e304Response;
	}
}

