package com.xyw.medical.birth.certificateDJB.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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

import com.xyw.medical.birth.certificateDJB.dao.BirthCertificateDJBDao;
import com.xyw.medical.birth.model.D304;
import com.xyw.medical.birth.model.QueryBirthRequest;
import com.xyw.medical.birth.model.QueryBirthResponse;
import com.xyw.medical.birth.model.VD304;
import com.xyw.sys.util.StringUtil;

public class BirthCertificateDJBDaoImpl implements BirthCertificateDJBDao {

    @Resource
	private DataSource dataSource;
    
	@Resource
	private SessionFactory sessionFactory;
    
	@Override
	public QueryBirthResponse saveFirstBirthCertificateDJB(D304 d304) {
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try{
			StringBuffer sql = new StringBuffer("select * from D304 t where 1=1 ");
			if(d304.getD30416() != null){
				sql.append(" and t.d304_16='"+ d304.getD30416() +"' ");
			}
			if(d304.getD30418() != null){
				sql.append(" and t.d304_18='"+ d304.getD30418() +"' ");
			}
			if(d304.getD30422() != null){
				sql.append(" and t.d304_22='"+ d304.getD30422() +"' ");
			}
			if(d304.getD30424() != null){
				sql.append(" and t.d304_24='"+ d304.getD30424() +"' ");
			}
			if(d304.getD30404() != null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String d30404str = sdf.format(d304.getD30404());
				sql.append(" and t.d304_04=to_date('"+ d30404str +"','yyyy-MM-dd HH24:mi:ss') ");
			}
			if(d304.getD30411() != null){
				sql.append(" and t.d304_11 ='"+ d304.getD30411() + "' ");
			}
			SQLQuery query = session.createSQLQuery(sql.toString());
			int d304size = query.addEntity(D304.class).list().size();
			if(d304size>0){
				state = false;
				queryBirthResponse.setErrorMessage("重复保存！");
			}
		}catch(Exception e){
			state = false;
			queryBirthResponse.setErrorMessage("保存失败！");
			e.printStackTrace();
		}
		if(state){
			try {
				session.save(d304);
				queryBirthResponse.setPromptMessage("保存成功！");
			} catch (Exception e) {
				e.printStackTrace();
				queryBirthResponse.setErrorMessage("保存失败！");
				state = false;
			}
		}
		queryBirthResponse.setState(state);
		return queryBirthResponse;
	}

	@Override
	public QueryBirthResponse queryFirstBirthCertificateDJB(
			QueryBirthRequest queryBirthRequest) {
		String _d304_05 = queryBirthRequest.getD304_05();
		String _d304_11 = queryBirthRequest.getD304_11();
		Date _d304_13End = queryBirthRequest.getD304_13End();
		Date _d304_13Start = queryBirthRequest.getD304_13Start();
		String _d304_16 = queryBirthRequest.getD304_16();
		String _d304_18 = queryBirthRequest.getD304_18();
		String _d304_22 = queryBirthRequest.getD304_22();
		String _d304_24 = queryBirthRequest.getD304_24();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		int parameterPageindex = queryBirthRequest.getParameterPageindex();
		int parameterPagesize = queryBirthRequest.getParameterPagesize();
		
		StringBuffer parameterConditionwhere = new StringBuffer();
		
		if(!StringUtil.isBlankString(_d304_05)){
			parameterConditionwhere.append(" and t.d304_05 like '");
			parameterConditionwhere.append(_d304_05);
			parameterConditionwhere.append("%'");
		}
//		if(!StringUtil.isBlankString(_d304_11))
//		{
//			parameterConditionwhere.append(" and t.d304_11 like '");
//			parameterConditionwhere.append(_d304_11);
//			parameterConditionwhere.append("%'");
//		}
		if(_d304_13Start != null)
		{
			String d30413Start = simpleDateFormat.format(_d304_13Start);
			parameterConditionwhere.append(" and t.d304_13 >= to_date('" + d30413Start + "', 'yyyy-mm-dd')");
		}
		if(_d304_13End != null)
		{
			String d30413End = simpleDateFormat.format(_d304_13End);
			parameterConditionwhere.append(" and t.d304_13 <= to_date('" + d30413End + "', 'yyyy-mm-dd')");
		}
		if(!StringUtil.isBlankString(_d304_16))
		{
			parameterConditionwhere.append(" and t.d304_16 = '");
			parameterConditionwhere.append(_d304_16);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d304_18))
		{
			parameterConditionwhere.append(" and t.d304_18 = '");
			parameterConditionwhere.append(_d304_18);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d304_22))
		{
			parameterConditionwhere.append(" and t.d304_22 = '");
			parameterConditionwhere.append(_d304_22);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d304_24))
		{
			parameterConditionwhere.append(" and t.d304_24 = '");
			parameterConditionwhere.append(_d304_24);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d304_11))
		{
			if(_d304_11.length() == 14)
			{
				parameterConditionwhere.append(" and t.d304_11 = '");
				parameterConditionwhere.append(_d304_11);
				parameterConditionwhere.append("'");
			}else
			{
				parameterConditionwhere.append(" and t.d304_11 like '");
				parameterConditionwhere.append(_d304_11);
				parameterConditionwhere.append("%'");
			}
		}
		Connection connection = null;
		CallableStatement callableStatement = null;
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		boolean state = true;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			
			callableStatement.setString(3, "V_D304");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D304_01");
			
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			
			queryBirthResponse.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VD304 vd304 =null;
			List<VD304> listVD304 = new ArrayList<VD304>();
			
			while (resultSet.next()) {
				long d30401 = resultSet.getLong("D304_01");
				String d30402 = resultSet.getString("D304_02");
				String d30403 = resultSet.getString("D304_03");
				Date d30404 = resultSet.getTimestamp("D304_04");
				String d30405 = resultSet.getString("D304_05");
				int d30406 = resultSet.getInt("D304_06");
				int d30407 = resultSet.getInt("D304_07");
				double d30408 = resultSet.getDouble("D304_08");
				double d30409 = resultSet.getDouble("D304_09");
				String d30410 = resultSet.getString("D304_10");
				String d30411 = resultSet.getString("D304_11");
				String d30412 = resultSet.getString("D304_12");
				Date d30413 = resultSet.getDate("D304_13");
				String d30414 = resultSet.getString("D304_14");
				String d30415 = resultSet.getString("D304_15");
				String d30416 = resultSet.getString("D304_16");
				String d30417 = resultSet.getString("D304_17");
				String d30418 = resultSet.getString("D304_18");
				String d30419 = resultSet.getString("D304_19");
				String d30420 = resultSet.getString("D304_20");
				String d30421 = resultSet.getString("D304_21");
				String d30422 = resultSet.getString("D304_22");
				String d30423 = resultSet.getString("D304_23");
				String d30424 = resultSet.getString("D304_24");
				String d30425 = resultSet.getString("D304_25");
				String d30426 = resultSet.getString("D304_26");
				String d30427 = resultSet.getString("D304_27");
				String d30428 = resultSet.getString("D304_28");
				String d30429 = resultSet.getString("D304_29");
				String d30430 = resultSet.getString("D304_30");
				String d30431 = resultSet.getString("D304_31");
				long d30432 = resultSet.getLong("D304_32");
				String d30433 = resultSet.getString("D304_33");
				Date d30434 = resultSet.getDate("D304_34");
				Date d30435 = resultSet.getDate("D304_35");
				String d30438 = resultSet.getString("D304_38");
				String d30439 = resultSet.getString("D304_39");
				String d30445 = resultSet.getString("D304_45");
				String d60166 = resultSet.getString("d601_66");
				String d60192 = resultSet.getString("d601_92");
				String d60193 = resultSet.getString("d601_93");
				String d60194 = resultSet.getString("d601_94");
				
				String d30403Zh = resultSet.getString("D304_03_ZH");
				String d30405Zh = resultSet.getString("D304_05_ZH");
				String d30411Zh = resultSet.getString("D304_11_ZH");
				String d30417Zh = resultSet.getString("D304_17_ZH");
				String d30419Zh = resultSet.getString("D304_19_ZH");
				String d30420Zh = resultSet.getString("D304_20_ZH");
				String d30423Zh = resultSet.getString("D304_23_ZH");
				String d30425Zh = resultSet.getString("D304_25_ZH");
				String d30426Zh = resultSet.getString("D304_26_ZH");
				String d30429Zh = resultSet.getString("D304_29_ZH");
				String d30430Zh = resultSet.getString("D304_30_ZH");
				String d30434Zh = resultSet.getString("D304_34_ZH");
				String d30435Zh = resultSet.getString("D304_35_ZH");
				
				vd304 = new VD304();
				
				vd304.setD30401(d30401);
				vd304.setD30402(d30402);
				vd304.setD30403(d30403);
				if(d30404!=null){
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH：mm");
					String d30404str = format.format(d30404);
					vd304.setD30404(d30404str);
				}
				vd304.setD30405(d30405);
				vd304.setD30406(d30406);
				vd304.setD30407(d30407);
				vd304.setD30408(d30408);
				vd304.setD30409(d30409);
				vd304.setD30410(d30410);
				vd304.setD30411(d30411);
				vd304.setD30412(d30412);
				if(d30413!=null){
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					String d30413str = format.format(d30413);
					vd304.setD30413(d30413str);
				}
				vd304.setD30414(d30414);
				vd304.setD30415(d30415);
				vd304.setD30416(d30416);
				vd304.setD30417(d30417);
				vd304.setD30418(d30418);
				vd304.setD30419(d30419);
				vd304.setD30420(d30420);
				vd304.setD30421(d30421);
				vd304.setD30422(d30422);
				vd304.setD30423(d30423);
				vd304.setD30424(d30424);
				vd304.setD30425(d30425);
				vd304.setD30426(d30426);
				vd304.setD30427(d30427);
				vd304.setD30428(d30428);
				vd304.setD30429(d30429);
				vd304.setD30430(d30430);
				vd304.setD30431(d30431);
				vd304.setD30432(d30432);
				vd304.setD30433(d30433);
				vd304.setD30434(d30434);
				vd304.setD30435(d30435);
				vd304.setD30438(d30438);
				vd304.setD30439(d30439);
				vd304.setD30445(d30445);
				
				vd304.setD30403Zh(d30403Zh);
				vd304.setD30405Zh(d30405Zh);
				vd304.setD30411Zh(d30411Zh);
				vd304.setD30417Zh(d30417Zh);
				vd304.setD30419Zh(d30419Zh);
				vd304.setD30420Zh(d30420Zh);
				vd304.setD30423Zh(d30423Zh);
				vd304.setD30425Zh(d30425Zh);
				vd304.setD30426Zh(d30426Zh);
				vd304.setD30429Zh(d30429Zh);
				vd304.setD30430Zh(d30430Zh);
				vd304.setD30434Zh(d30434Zh);
				vd304.setD30435Zh(d30435Zh);
				
				vd304.setD60166(d60166);
				vd304.setD60192(d60192);
				vd304.setD60193(d60193);
				vd304.setD60194(d60194);
				
				if(d30434!=null){
					vd304.setMotherage(this.getAge(d30434, d30404));
				}
				if(d30435!=null){
					vd304.setFatherage(this.getAge(d30435, d30404));
				}
				
			    listVD304.add(vd304);
			}
			if(listVD304.size() <= 0) {
				if(!"refresh".equals(queryBirthRequest.getFlag())){
					queryBirthResponse.setErrorMessage("没有相关信息！");
					state = false;
				}
			} else {
				queryBirthResponse.setListVD304(listVD304);
			}
			queryBirthResponse.setState(state);
		} catch (Exception e) {
			e.printStackTrace();
			state = false;
			queryBirthResponse.setErrorMessage("查询失败！");
			queryBirthResponse.setState(state);
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

			}
		}
		return queryBirthResponse;
	}
	
	private String getAge(Date dateStart,Date dateEnd){
		String age = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		int start = Integer.parseInt(format.format(dateStart));
		int end = Integer.parseInt(format.format(dateEnd));
		age = String.valueOf(end-start);
		return age;
	}

	@Override
	public QueryBirthResponse updateFirstBirthCertificateDJB(D304 d304) {
		Session session = this.sessionFactory.getCurrentSession();
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		boolean state =true;
		long d30401 = d304.getD30401();
		
		try {
			String sql = "select * from v_d301 t where t.d301_42 ='0' and t.d301_57 ='"+d30401+"' ";
			SQLQuery query = session.createSQLQuery(sql);
			int size = query.list().size();
			if(size>0){
				queryBirthResponse.setErrorMessage("出生证首发打印已保存，不能修改！");
				state = false;
			}
		} catch (Exception e) {
			state = false;
			queryBirthResponse.setErrorMessage("修改失败！");
			e.printStackTrace();
		}
		if(state){
			try {
				session.saveOrUpdate(d304);
			} catch (Exception e) {
				queryBirthResponse.setErrorMessage("修改失败！");
				e.printStackTrace();
				state = false;
			}
		}
		
		queryBirthResponse.setState(state);
		return queryBirthResponse;
	}

	@Override
	public QueryBirthResponse deleteFirstBirthCertificateDJB(
			QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = null;
		long d30401 = queryBirthRequest.d304_01;
		String sql = "select * from v_d301 t where t.d301_42 ='0' and t.d301_57 ='"+d30401+"' ";
		try {
			queryBirthResponse = new QueryBirthResponse();
			Session session = this.sessionFactory.getCurrentSession();
			SQLQuery query = session.createSQLQuery(sql);
			int size = query.list().size();
			if(size>0){
				queryBirthResponse.setErrorMessage("出生证首发打印已保存，不能删除！");
				return queryBirthResponse;
			}
			D304 d304 = new D304();
			d304.setD30401(d30401);
			session.delete(d304);
			queryBirthResponse.setPromptMessage("删除成功！");
		} catch (HibernateException e) {
			queryBirthResponse.setErrorMessage("删除失败！");
			e.printStackTrace();
		}
		
		return queryBirthResponse;
	}
	
	

}
