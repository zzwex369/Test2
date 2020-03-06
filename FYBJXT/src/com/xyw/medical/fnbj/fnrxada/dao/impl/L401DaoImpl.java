package com.xyw.medical.fnbj.fnrxada.dao.impl;

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

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.fnbj.fnrxada.dao.L401Dao;

import com.xyw.medical.fnbj.model.L401;
import com.xyw.medical.fnbj.model.L401Response;
import com.xyw.medical.fnbj.model.L401Request;
import com.xyw.medical.fnbj.model.VL401;
import com.xyw.sys.util.StringUtil;


public class L401DaoImpl implements L401Dao {

@Resource
private SessionFactory sessionFactory;

@Resource
private DataSource dataSource;

	@Override
	public L401Response saveL401(L401Request l401Request) {
		L401Response l401Response=new L401Response();
		L401Response _l401Response=null;
		L401 l401=l401Request.getL401();
		String l40103=l401.getl40103();
		String l40104=l401.getl40104();		
		try {			
			if(l40104!=null){
				Session session=sessionFactory.getCurrentSession();
				String l40102=(String) session.createSQLQuery("select t.l401_02 from l401 t where t.l401_03=? and t.l401_04=?")
							      	.setString(0,l40103).setString(1,l40104).uniqueResult();
				if(l40102!=null){
					l401Response.setState(false);
					l401Response.setErrorMessage("该信息已经登记过档案");
					return l401Response;
				}			
				_l401Response=SetCode(l401.getl40113(), session);
				if(!_l401Response.isState())return _l401Response;
				L401 _401=_l401Response.getL401();
				l401.setl40114(_401.getl40114());
				l401.setl40115(_401.getl40115());
				l401.setl40116(_401.getl40116());
				session.save(l401);			
				l401Response.setState(true);
				l401Response.setPromptMessage("保存成功");
				return l401Response;
			}
			l401Response.setState(false);
			l401Response.setErrorMessage("证件号不能为空");
			return l401Response;
		} catch (Exception e) {
			e.printStackTrace();
			l401Response.setState(false);
			l401Response.setErrorMessage("保存异常");
		}
		return  l401Response;
	}

	@Override
	public L401Response delL401(L401Request l401Request) {
		L401Response l401Response=new L401Response();
		long l40101=l401Request.getL40101();
		try {			
			if(l40101!=0){				
				Session session=sessionFactory.getCurrentSession();
				L401 _l401=(L401) session.get(L401.class, l40101);
				Number l40201=(Number) session.createSQLQuery("select t.l402_02 from l402 t where t.l402_02="+l40101).uniqueResult();			
				if(_l401!=null){
					if(l40201 !=null){
						l401Response.setState(false);
						l401Response.setErrorMessage("乳腺癌检查信息已经登记，无法删除");
						return l401Response;	
					}else{
						session.delete(_l401);
						l401Response.setState(true);
						l401Response.setPromptMessage("删除成功");
						return l401Response;
					}
				}					
			}else{
				l401Response.setState(false);
				l401Response.setErrorMessage("删除失败");				
			}
		} catch (Exception e) {
			e.printStackTrace();
			l401Response.setState(false);
			l401Response.setErrorMessage("删除异常");
		}
		return  l401Response;
	}

	@Override
	public L401Response renewL401(L401Request l401Request) {
		L401Response l401Response=new L401Response();
		L401 l401=l401Request.getL401();
		try {
			if(l401!=null){
				Session session=sessionFactory.getCurrentSession();
				session.saveOrUpdate(l401);
				l401Response.setState(true);
				l401Response.setPromptMessage("更新成功");
				return l401Response;
			}
			l401Response.setState(false);
			l401Response.setPromptMessage("对象为空");
		} catch (Exception e) {
			e.printStackTrace();
			l401Response.setState(false);
			l401Response.setErrorMessage("更新异常");
		}
		return  l401Response;
	}

	@Override
	public L401Response queryL401(L401Request l401Request) {
		L401Response l401Response=new L401Response();
		String flag=l401Request.getFlag();
		int parameterPageIndex=l401Request.getParameterPageindex();
		int parameterPagesize=l401Request.getParameterPagesize();
		Date timeDate=l401Request.getTimeStr();
		Date timeEnDate=l401Request.getTimeEnd();
		L401 l401=l401Request.getL401();
		String l40117=l401.getl40117();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		if ("true".equals(flag)) {
			String l40102=l401.getl40102();
			String l40104=l401.getl40104();
			if (!StringUtil.isBlankString(l40102)) {
				parameterConditionwhere
						.append("and t.l401_02='" + l40102 + "'");
			}
			if (!StringUtil.isBlankString(l40104)) {
				parameterConditionwhere
						.append("and t.l401_04='" + l40104 + "'");
			}
		}
		if ("false".equals(flag)) {
			if (timeDate != null) {
				parameterConditionwhere.append("and t.l401_19Str >='"
						+ sdf.format(timeDate) + "'");
			}
			if (timeEnDate != null) {
				parameterConditionwhere.append("and t.l401_19Str <= '"
						+ sdf.format(timeEnDate) + "'");
			}
		}
		if (!StringUtil.isBlankString(l40117)) {
			if (l40117.length() == 14) {
				parameterConditionwhere.append(" and t.l401_17 = '");
				parameterConditionwhere.append(l40117);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.l401_17 like '");
				parameterConditionwhere.append(l40117);
				parameterConditionwhere.append("%'");
			}
		}
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageIndex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "v_l401");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.l401_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			if(rowCount==0){
				l401Response.setState(false);
				l401Response.setErrorMessage("暂无数据");
				return l401Response;
			}
			l401Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VL401 vl401 = null;
			List<VL401> vl401s = new ArrayList<VL401>();
			while (resultSet.next()) {
				vl401=new VL401();
				vl401.setL40101(resultSet.getLong("L401_01"));
				vl401.setL40102(resultSet.getString("L401_02"));
				vl401.setL40103(resultSet.getString("L401_03"));
				vl401.setL40104(resultSet.getString("L401_04"));
				vl401.setL40105(resultSet.getDate("L401_05"));
				vl401.setL40106(resultSet.getShort("L401_06"));
				vl401.setL40107(resultSet.getString("L401_07"));
				vl401.setL40108(resultSet.getString("L401_08"));
				vl401.setL40109(resultSet.getString("L401_09"));
				vl401.setL40110(resultSet.getString("L401_10"));
				vl401.setL40111(resultSet.getString("L401_11"));
				vl401.setL40112(resultSet.getString("L401_12"));
				vl401.setL40113(resultSet.getString("L401_13"));
				vl401.setL40114(resultSet.getString("L401_14"));
				vl401.setL40115(resultSet.getString("L401_15"));
				vl401.setL40116(resultSet.getString("L401_16"));
				vl401.setL40117(resultSet.getString("L401_17"));
				vl401.setL40118(resultSet.getString("L401_18"));
				vl401.setL40119(resultSet.getDate("L401_19"));
				vl401.setL40120(resultSet.getString("L401_20"));
				vl401.setL40103zh(resultSet.getString("L401_03Zh"));
				vl401.setL40107zh(resultSet.getString("L401_07Zh"));
				vl401.setL40108zh(resultSet.getString("L401_08Zh"));
				vl401.setL40109zh(resultSet.getString("L401_09Zh"));
				vl401.setL40111zh(resultSet.getString("L401_11Zh"));
				vl401.setL40113zh(resultSet.getString("L401_13Zh"));
				vl401.setL40117zh(resultSet.getString("L401_17Zh"));
				vl401.setL40105str(resultSet.getString("L401_05Str"));
				vl401.setL40119str(resultSet.getString("L401_19Str"));
				vl401s.add(vl401);
				}
			l401Response.setState(true);
			l401Response.setPromptMessage("查询成功");
			l401Response.setVl401s(vl401s);
			
			}catch (Exception e) {
				e.getStackTrace();
				l401Response.setState(false);
				l401Response.setErrorMessage("查询失败");
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
		return  l401Response;
	}
	
	/*制作档案编码*/
	private L401Response SetCode(String d20101,Session session) {
		L401 l401=new L401();
		L401Response l401Response=new L401Response();
		int i=0;
		l401Response.setState(false);
		try {
			if(d20101!=null){
				String d20109=(String) session.createSQLQuery("select t.d201_09 from d201 t where t.d201_01=?")
				.setString(0,d20101).uniqueResult();
				if(d20109!=null){
					String maxL40115=(String) session.createSQLQuery("select max(t.l401_15) from L401 t where t.l401_13 = ?")
					.setString(0,d20101).uniqueResult();
					maxL40115 = maxL40115!= null?maxL40115:"0";
					i=Integer.parseInt(maxL40115)+1;
					String str_m = String.valueOf(i);
					String str = "00000";
					str_m = str.substring(0, 5 - str_m.length()) + str_m;
					l401.setl40114(d20109);
					l401.setl40115(str_m);
					l401.setl40116(d20109+str_m);
					l401Response.setL401(l401);
					l401Response.setState(true);
					l401Response.setPromptMessage("保存档案编码成功");
				}else{				
					l401Response.setErrorMessage("无法得到地区编码");
					return l401Response;
				}
			}else{
				l401Response.setErrorMessage("地址为空");
				return l401Response;
			}
		} catch (Exception e) {
			e.printStackTrace();
			l401Response.setState(false);
			l401Response.setErrorMessage("档案编码异常");
		}		
		return l401Response;
	}
	

}
