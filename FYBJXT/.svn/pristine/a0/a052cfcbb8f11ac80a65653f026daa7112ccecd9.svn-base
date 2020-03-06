package com.xyw.medical.fnbj.fngwfxpg.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.fnbj.fngwfxpg.dao.F309Dao;
import com.xyw.medical.fnbj.model.F309;
import com.xyw.medical.fnbj.model.F309Request;
import com.xyw.medical.fnbj.model.F309Response;
import com.xyw.medical.fnbj.model.VF309;
import com.xyw.sys.util.StringUtil;

public class F309DaoImpl implements F309Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;
	private F309Response f309Response;
	
	@Override
	public F309Response deleteF309(F309Request f309Request) {
		boolean state = false;
		f309Response=new F309Response();
		try {
			Long f30901=f309Request.getF309().getF30901();
			if(f30901!=null){
				Session session=sessionFactory.getCurrentSession();
				F309 f309=(F309) session.get(F309.class, f30901);
				if(f309!=null){
					session.delete(f309);
					state=true;
					f309Response.setPromptMessage("删除成功");
				}else {
					f309Response.setErrorMessage("无法删除，不存在这条信息");
				}
			}else {
				f309Response.setErrorMessage("数据为空");
			}
		} catch (Exception e) {
			f309Response.setErrorMessage(e.getMessage());
		}
		f309Response.setState(state);
		return f309Response;
	}

	@Override
	public F309Response queryF309(F309Request F309Request) {
		f309Response=new F309Response();		
		F309 f309=F309Request.getF309();
		String name=f309.getF30903();
		String card=f309.getF30906();
		String institutionCode=f309.getF30913();//机构
		String timeStr =F309Request.getTimeStr();
		String timeEnd =F309Request.getTimeEnd();
	    StringBuffer sql = new StringBuffer();
	    int parameterPageindex = F309Request.getParameterPageindex();
	    int parameterPagesize = F309Request.getParameterPagesize();
	    if(!StringUtil.isBlankString(name))
			sql.append(" and t.f309_03 = '"+ name +"' ");
		if(!StringUtil.isBlankString(card))
			sql.append(" and t.f309_06 = '"+ card +"' ");
		if (!StringUtil.isBlankString(institutionCode)) {
			if (institutionCode.length() == 14) {
				sql.append(" and t.f309_13 = '");
				sql.append(institutionCode);
				sql.append("'");
			} else {
				sql.append(" and t.f309_13 like '");
				sql.append(institutionCode);
				sql.append("%'");
			}
		}
		if(timeStr !=null){
//	    	String timeStr_ = sdf.format(timeStr);
	    	sql.append(" and to_char(F309_14,'yyyy-mm-dd') >= '"+ timeStr + "'");
	    }
	    if(timeEnd !=null){
//	    	String timeEnd_ = sdf.format(timeEnd);
	    	sql.append(" and to_char(F309_14,'yyyy-mm-dd') <= '"+ timeEnd + "'"); 
	    }
		boolean state =true;
		Connection connection =null;
		CallableStatement callableStatement =null;
		try {
			connection =this.dataSource.getConnection();
			callableStatement =connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
	    	callableStatement.setInt(2, parameterPagesize);
	    	callableStatement.setString(3, "V_F309");
	    	callableStatement.setString(4, sql.toString());
	    	callableStatement.setString(5, "t.F309_01");
	    	callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
	    	callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
	    	callableStatement.execute();
	    	
	    	long rowCount =callableStatement.getLong(6);
	    	f309Response.setRowCount(rowCount);
	    	ResultSet resultSet =(ResultSet)callableStatement.getObject(7);
	    	VF309 vf309=null;
	    	List<VF309> vf309s =new ArrayList<VF309>();
	    	while (resultSet.next()) {
	    		vf309=new VF309();
	    		vf309.setF30901(resultSet.getLong("F309_01"));
	    		vf309.setF30902(resultSet.getLong("F309_02"));
	    		vf309.setF30903(resultSet.getString("F309_03"));
	    		vf309.setF30904(resultSet.getDate("F309_04"));
	    		vf309.setF30905(resultSet.getString("F309_05"));
	    		vf309.setF30906(resultSet.getString("F309_06"));
	    		vf309.setF30907(resultSet.getString("F309_07"));
	    		vf309.setF30908(resultSet.getString("F309_08"));
	    		vf309.setF30909(resultSet.getString("F309_09"));
	    		vf309.setF30910(resultSet.getString("F309_10"));
	    		vf309.setF30911(resultSet.getDate("F309_11"));
	    		vf309.setF30912(resultSet.getString("F309_12"));
	    		vf309.setF30913(resultSet.getString("F309_13"));
	    		vf309.setF30914(resultSet.getDate("F309_14"));
	    		vf309.setF30905zh(resultSet.getString("F309_05ZH"));
	    		vf309.setF30909zh(resultSet.getString("F309_09ZH"));
	    		vf309.setF30913zh(resultSet.getString("F309_13ZH"));
	    		vf309s.add(vf309);
	    	}
	    	f309Response.setVf309s(vf309s);
	    	f309Response.setPromptMessage("查询成功");
	    	}catch (Exception e) {
	    		state=false;
				f309Response.setErrorMessage(e.getMessage());
			}
	    	f309Response.setState(state);
		return f309Response;
	}


	@Override
	public F309Response renewF309(F309 f309) {
		boolean state = false;
		f309Response=new F309Response();
		try {
			Long f30901=f309.getF30901();
			if(f30901!=null){
				Session session=sessionFactory.getCurrentSession();
				F309 _f309=(F309) session.get(F309.class, f30901);
				if(_f309!=null){
				session.clear();
				session.saveOrUpdate(f309);
				state = true;
				f309Response.setPromptMessage("更新成功!");
			} else
				f309Response.setErrorMessage("不存在这条数据! ，无法更新");
		  }
		} catch (Exception e) {
			f309Response.setErrorMessage(e.getMessage());
		}
		f309Response.setState(state);
		return f309Response;
	}

	@Override
	public F309Response saveF309(F309 f309) {
		boolean state = false;
		f309Response=new F309Response();
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String f30911=sdf.format(f309.getF30911());
		String f30914=sdf.format(f309.getF30914());
		try {
			String sql = "select t.f309_01 from f309 t where t.f309_03=? and t.f309_06=? " +
					"and to_char(F309_11,'yyyy-mm-dd') = ? and to_char(F309_14,'yyyy-mm-dd') = ?";
			BigDecimal id = (BigDecimal) session.createSQLQuery(sql)
						.setParameter(0,f309.getF30903()).setParameter(1, f309.getF30906())
						.setParameter(2, f30911).setParameter(3, f30914).uniqueResult();
			if (id != null)
				f309Response.setErrorMessage("已经存在这条数据! ，无法保存");
			else {
				session.save(f309);
				state = true;
				f309Response.setPromptMessage("保存成功！");
			}
		} catch (Exception e) {
			f309Response.setErrorMessage(e.getMessage());
		}
		f309Response.setState(state);
		return f309Response;
	}

}
