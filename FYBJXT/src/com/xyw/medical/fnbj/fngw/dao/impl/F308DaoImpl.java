package com.xyw.medical.fnbj.fngw.dao.impl;

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

import com.xyw.medical.fnbj.fngw.dao.F308Dao;
import com.xyw.medical.fnbj.model.F303;
import com.xyw.medical.fnbj.model.F308;
import com.xyw.medical.fnbj.model.F308Request;
import com.xyw.medical.fnbj.model.F308Response;
import com.xyw.medical.fnbj.model.VF308;
import com.xyw.sys.util.StringUtil;

public class F308DaoImpl implements F308Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;
	private F308Response f308Response;

	@Override
	public F308Response deleteF308(F308Request f308Request) {
		boolean state = false;
		f308Response = new F308Response();
		long f30801 = f308Request.getF308().getF30801();
		Session session = sessionFactory.getCurrentSession();
		try {
			F308 f308 = (F308) session.get(F308.class, f30801);
			BigDecimal f30901=(BigDecimal) session.createSQLQuery("select t.f309_01 from f309 t where t.f309_02=?").setParameter(0, f30801).uniqueResult();
			BigDecimal f31001=(BigDecimal) session.createSQLQuery("select t.f310_01 from f310 t where t.f310_02=?").setParameter(0, f30801).uniqueResult();
			if (f308 != null) {
				if(f30901!=null)
					f308Response.setErrorMessage("已经登记过孕产妇妊娠风险评估分级表信息!，无法删除 ");
				else if(f31001!=null) {
					f308Response.setErrorMessage("已经登记过高危转诊单表信息!，无法删除 ");
				}else{
					session.delete(f308);
					state = true;
					//F308Response _f308Response=saveOrUpdateF303(_f308,session,"delete");不去关联初检复检
					//String message=_f308Response.isState()?_f308Response.getPromptMessage():_f308Response.getErrorMessage();
					f308Response.setPromptMessage("删除成功!");					
				}
			} else
				f308Response.setErrorMessage("不存在这条数据!，无法删除 ");

		} catch (Exception e) {
			f308Response.setErrorMessage("删除失败! ");
			e.printStackTrace();
		}
		f308Response.setState(state);
		return f308Response;
	}

	@Override
	public F308Response queryF308(F308Request f308Request) {
		f308Response = new F308Response();
		
		F308 f308=f308Request.getF308();
		String name=f308.getF30803();
		String card=f308.getF30805();
		String institutionCode=f308.getF30816();//机构
		String timeStr =f308Request.getTimeStr();
		String timeEnd =f308Request.getTimeEnd();
	    StringBuffer sql = new StringBuffer();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    int parameterPageindex = f308Request.getParameterPageindex();
	    int parameterPagesize = f308Request.getParameterPagesize();
	    if(!StringUtil.isBlankString(name))
			sql.append(" and t.f308_03 = '"+ name +"' ");
		if(!StringUtil.isBlankString(card))
			sql.append(" and t.f308_05 = '"+ card +"' ");
		if (!StringUtil.isBlankString(institutionCode)) {
			if (institutionCode.length() == 14) {
				sql.append(" and t.f308_16 = '");
				sql.append(institutionCode);
				sql.append("'");
			} else {
				sql.append(" and t.f308_16 like '");
				sql.append(institutionCode);
				sql.append("%'");
			}
		}
		if(timeStr !=null){
//	    	String timeStr_ = sdf.format(timeStr);
	    	sql.append(" and to_char(F308_17,'yyyy-mm-dd') >= '"+ timeStr + "'");
	    }
	    if(timeEnd !=null){
//	    	String timeEnd_ = sdf.format(timeEnd);
	    	sql.append(" and to_char(F308_17,'yyyy-mm-dd') <= '"+ timeEnd + "'"); 
	    }
		boolean state =true;
		Connection connection =null;
		CallableStatement callableStatement =null;
		try {
			connection =this.dataSource.getConnection();
			callableStatement =connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
	    	callableStatement.setInt(2, parameterPagesize);
	    	callableStatement.setString(3, "V_F308");
	    	callableStatement.setString(4, sql.toString());
	    	callableStatement.setString(5, "t.F308_01");
	    	callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
	    	callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
	    	callableStatement.execute();
	    	
	    	long rowCount =callableStatement.getLong(6);
	    	f308Response.setRowCount(rowCount);
	    	ResultSet resultSet =(ResultSet)callableStatement.getObject(7);
	    	VF308 vf308=null;
	    	List<VF308> vf308s =new ArrayList<VF308>();
	    	while (resultSet.next()) {
	    		vf308=new VF308();
	    		vf308.setF30801(resultSet.getLong("F308_01"));
	    		vf308.setF30802(resultSet.getLong("F308_02"));
	    		vf308.setF30803(resultSet.getString("F308_03"));
	    		vf308.setF30804(resultSet.getString("F308_04"));
	    		vf308.setF30805(resultSet.getString("F308_05"));
	    		vf308.setF30806(resultSet.getString("F308_06"));
	    		vf308.setF30807(resultSet.getDate("F308_07"));
	    		vf308.setF30808(resultSet.getString("F308_08"));
	    		vf308.setF30809(resultSet.getString("F308_09"));
	    		vf308.setF30810(resultSet.getString("F308_10"));
	    		vf308.setF30811(resultSet.getString("F308_11"));
	    		vf308.setF30812(resultSet.getString("F308_12"));
	    		vf308.setF30813(resultSet.getString("F308_13"));
	    		vf308.setF30814(resultSet.getString("F308_14"));
	    		vf308.setF30815(resultSet.getString("F308_15"));
	    		vf308.setF30816(resultSet.getString("F308_16"));
	    		vf308.setF30817(resultSet.getDate("F308_17"));
	    		vf308.setF30804Zh(resultSet.getString("F308_04_ZH"));
	    		vf308.setF30811Zh(resultSet.getString("F308_11_ZH"));
	    		vf308.setF30812Zh(resultSet.getString("F308_12_ZH"));
	    		vf308.setF30813Zh(resultSet.getString("F308_13_ZH"));
	    		vf308.setF30816Zh(resultSet.getString("F308_16_ZH"));
	    		vf308s.add(vf308);
	    	}
	    	f308Response.setVf308s(vf308s);
	    	f308Response.setPromptMessage("查询成功");
	    	}catch (Exception e) {
	    		state=false;
				e.printStackTrace();
				f308Response.setErrorMessage("查询异常");
			}
	    	f308Response.setState(state);
		return f308Response;
	}

	@Override
	public F308Response renewF308(F308 f308) {
		boolean state = false;
		f308Response = new F308Response();
		Session session = sessionFactory.getCurrentSession();
		try {
			F308 _f308 = (F308) session.get(F308.class, f308.getF30801());
			if (_f308 != null) {
				session.clear();
				session.saveOrUpdate(f308);
				//F308Response _f308Response=saveOrUpdateF303(f308,session,"save");档案不去关联初检复检
				state = true;
				//String message=_f308Response.isState()?_f308Response.getPromptMessage():_f308Response.getErrorMessage();
				f308Response.setPromptMessage("更新成功!");
			} else
				f308Response.setErrorMessage("不存在这条数据! ，无法更新");

		} catch (Exception e) {
			f308Response.setErrorMessage("更新失败 ");
			e.printStackTrace();
		}
		f308Response.setState(state);
		return f308Response;
	}

	@Override
	/**
	 * 判断是否保存重复
	 * 分为产前产后
	 */
	public F308Response saveF308(F308 f308) {
		boolean state = false;
		f308Response = new F308Response();
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select t.f308_01 from f308 t where t.f308_03=? and t.f308_06=? ";
			BigDecimal id = (BigDecimal) session.createSQLQuery(sql).setParameter(0,
					f308.getF30803()).setParameter(1, f308.getF30806()).uniqueResult();
			if (id != null)
				f308Response.setErrorMessage("已经存在这条数据! ，无法保存");
			else {
				session.save(f308);
				//F308Response _f308Response=saveOrUpdateF303(f308,session,"save");不去关联初检复检
				state = true;
				//String message=_f308Response.isState()?_f308Response.getPromptMessage():_f308Response.getErrorMessage();
				f308Response.setPromptMessage("保存成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			f308Response.setErrorMessage("保存异常！");
		}
		f308Response.setState(state);
		return f308Response;
	}

	@Override
	/**
	 * 查询是否存在档案，
	 */
	public F308Response queryByF301Id(long f301_id) {
		boolean state = false;
		f308Response = new F308Response();
		Session session = sessionFactory.getCurrentSession();
		try {
			F308 f308 = (F308) session.createSQLQuery(
					"select t.* from f308 t where t.f308_02=?")
					.addEntity(F308.class).setParameter(0, f301_id).uniqueResult();
			if (f308!=null) {
				state=true;
				session.clear();
				f308Response.setF308(f308);
				f308Response.setPromptMessage("高危档案已经存在");
			}else
				f308Response.setPromptMessage("高危档案不存在");
		} catch (Exception e) {
			e.printStackTrace();
			f308Response.setErrorMessage("查询异常！");
		}
		f308Response.setState(state);
		return f308Response;
	}
	
	@SuppressWarnings("unchecked")
	public F308Response saveOrUpdateF303(F308 f308,Session session,String status) {
		f308Response=new F308Response();
		try {
				List<F303> list=session.createSQLQuery("select t.* from f303 t where t.f303_02=?")
				.addEntity(F303.class).setParameter(0, f308.getF30802()).list();
				int i=0;
				for(F303 f303:list){
					i++;
					if("save".equals(status))
					{
						f303.setF30310("1");
						f303.setF30311(Short.parseShort("1"));
						//f303.setF30312(f308.getF30813());
						//f303.setF30313(f308.getF30814());						
					}else {
						f303.setF30311(Short.parseShort("2"));
					}
					session.saveOrUpdate(f303);
					 if (i % 10 == 0) {  
				           session.flush();  
				           session.clear();  
				      }  
				}
				f308Response.setState(true);
				f308Response.setPromptMessage("初检复检信息更新成功");
		} catch (Exception e) {
			f308Response.setState(false);
			f308Response.setErrorMessage(e.getMessage());
		}
		return f308Response;
	}

}
