package com.xyw.medical.fnbj.fngwzz.dao.impl;

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

import com.xyw.medical.fnbj.fngwzz.dao.F310Dao;
import com.xyw.medical.fnbj.model.F310;
import com.xyw.medical.fnbj.model.F310Request;
import com.xyw.medical.fnbj.model.F310Response;
import com.xyw.medical.fnbj.model.VF310;
import com.xyw.sys.util.StringUtil;

public class F310DaoImpl implements F310Dao {

	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;
	private F310Response f310Response;
	@Override
	public F310Response deleteF310(F310Request f310Request) {
		boolean state = false;
		f310Response=new F310Response();
		try {
			Long f31001=f310Response.getF310().getF31001();
			if(f31001!=null){
				Session session=sessionFactory.getCurrentSession();
				F310 f310=(F310) session.get(F310.class, f31001);
				if(f310!=null){
					session.delete(f310);
					state=true;
					f310Response.setPromptMessage("删除成功");
				}else {
					f310Response.setErrorMessage("无法删除，不存在这条信息");
				}
			}else {
				f310Response.setErrorMessage("数据为空");
			}
		} catch (Exception e) {
			f310Response.setErrorMessage(e.getMessage());
		}
		f310Response.setState(state);
		return f310Response;
	}

	@Override
	public F310Response queryF310(F310Request F310Request) {
		f310Response=new F310Response();
		
		F310 f310=F310Request.getF310();
		String name=f310.getF31003();
		String card=f310.getF31006();
		String institutionCode=f310.getF31012();//机构
		String timeStr =F310Request.getTimeStr();
		String timeEnd =F310Request.getTimeEnd();
	    StringBuffer sql = new StringBuffer();
	    int parameterPageindex = F310Request.getParameterPageindex();
	    int parameterPagesize = F310Request.getParameterPagesize();
	    if(!StringUtil.isBlankString(name))
			sql.append(" and t.f310_03 = '"+ name +"' ");
		if(!StringUtil.isBlankString(card))
			sql.append(" and t.f310_06 = '"+ card +"' ");
		if (!StringUtil.isBlankString(institutionCode)) {
			if (institutionCode.length() == 14) {
				sql.append(" and t.f310_12 = '");
				sql.append(institutionCode);
				sql.append("'");
			} else {
				sql.append(" and t.f310_12 like '");
				sql.append(institutionCode);
				sql.append("%'");
			}
		}
		if(timeStr !=null){
//	    	String timeStr_ = sdf.format(timeStr);
	    	sql.append(" and to_char(F310_11,'yyyy-mm-dd') >= '"+ timeStr + "'");
	    }
	    if(timeEnd !=null){
//	    	String timeEnd_ = sdf.format(timeEnd);
	    	sql.append(" and to_char(F310_11,'yyyy-mm-dd') <= '"+ timeEnd + "'"); 
	    }
		boolean state =true;
		Connection connection =null;
		CallableStatement callableStatement =null;
		try {
			connection =this.dataSource.getConnection();
			callableStatement =connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
	    	callableStatement.setInt(2, parameterPagesize);
	    	callableStatement.setString(3, "V_F310");
	    	callableStatement.setString(4, sql.toString());
	    	callableStatement.setString(5, "t.F310_01");
	    	callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
	    	callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
	    	callableStatement.execute();
	    	
	    	long rowCount =callableStatement.getLong(6);
	    	f310Response.setRowCount(rowCount);
	    	ResultSet resultSet =(ResultSet)callableStatement.getObject(7);
	    	VF310 vf310=null;
	    	List<VF310> vf310s =new ArrayList<VF310>();
	    	while (resultSet.next()) {
	    		vf310=new VF310();
	    		vf310.setF31001(resultSet.getLong("F310_01"));
	    		vf310.setF31002(resultSet.getLong("F310_02"));
	    		vf310.setF31003(resultSet.getString("F310_03"));
	    		vf310.setF31004(resultSet.getDate("F310_04"));
	    		vf310.setF31005(resultSet.getString("F310_05"));
	    		vf310.setF31006(resultSet.getString("F310_06"));
	    		vf310.setF31007(resultSet.getString("F310_07"));
	    		vf310.setF31008(resultSet.getString("F310_08"));
	    		vf310.setF31009(resultSet.getString("F310_09"));
	    		vf310.setF31010(resultSet.getString("F310_10"));
	    		vf310.setF31011(resultSet.getDate("F310_11"));
	    		vf310.setF31012(resultSet.getString("F310_12"));
	    		vf310.setF31013(resultSet.getString("F310_13"));
	    		vf310.setF31014(resultSet.getString("F310_14"));
	    		vf310.setF31015(resultSet.getString("F310_15"));
	    		vf310.setF31016(resultSet.getDate("F310_16"));
	    		vf310.setF31017(resultSet.getString("F310_17"));
	    		vf310.setF31005zh(resultSet.getString("F310_05ZH"));
	    		vf310.setF31012zh(resultSet.getString("F310_12ZH"));
	    		vf310.setF31014zh(resultSet.getString("F310_14ZH"));
	    		vf310.setF31017zh(resultSet.getString("F310_17ZH"));
	    		vf310s.add(vf310);
	    	}
	    	f310Response.setVf310s(vf310s);
	    	f310Response.setPromptMessage("查询成功");
	    	}catch (Exception e) {
	    		state=false;
	    		f310Response.setErrorMessage(e.getMessage());
			}
	    	f310Response.setState(state);
		return f310Response;
	}


	@Override
	public F310Response renewF310(F310 f310) {
		boolean state = false;
		f310Response=new F310Response();
		try {
			Long f31001=f310.getF31001();
			if(f31001!=null){
				Session session=sessionFactory.getCurrentSession();
				F310 _f310=(F310) session.get(F310.class, f31001);
				if(_f310!=null){
				session.clear();
				session.saveOrUpdate(f310);
				state = true;
				f310Response.setPromptMessage("更新成功!");
			} else
				f310Response.setErrorMessage("不存在这条数据! ，无法更新");
		  }
		} catch (Exception e) {
			f310Response.setErrorMessage(e.getMessage());
		}
		f310Response.setState(state);
		return f310Response;
	}

	@Override
	public F310Response saveF310(F310 f310) {
		boolean state = false;
		f310Response=new F310Response();
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String f31011=sdf.format(f310.getF31011());
		try {
			String sql = "select t.f310_01,t.f310_17 from f310 t where t.f310_03=? and t.f310_06=? " +
						 "and to_char(F310_11,'yyyy-mm-dd') = ? ";
			F310 _f310 = (F310) session.createSQLQuery(sql).addEntity(F310.class)
						.setParameter(0,f310.getF31003()).setParameter(1, f310.getF31006())
						.setParameter(2, f31011).uniqueResult();
			if (_f310 != null)
				f310Response.setErrorMessage("已经存在这条数据! ，无法保存,转诊日期相同");
			else {
				session.save(f310);
				state = true;
				f310Response.setPromptMessage("保存成功！");
			}
		} catch (Exception e) {
			f310Response.setErrorMessage(e.getMessage());
		}
		f310Response.setState(state);
		return f310Response;
	}

		
}
