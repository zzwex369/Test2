package com.xyw.medical.birth.childDeathReport.dao.impl;


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
import com.xyw.medical.birth.childDeathReport.dao.ChildDeathReportDao;
import com.xyw.medical.birth.model.D605;
import com.xyw.medical.birth.model.D605Response;
import com.xyw.medical.birth.model.D605Request;
import com.xyw.medical.birth.model.QueryChildRequest;
import com.xyw.medical.birth.model.QueryChildResponse;
import com.xyw.medical.birth.model.VD605;
import com.xyw.sys.util.StringUtil;

public class ChildDeathReportDaoImpl implements ChildDeathReportDao {
	
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private DataSource dataSource;
    private StringBuffer errorMessage;
	@Override
	public D605Response saveD605(D605Request d605Request) {
		QueryChildResponse queryChildResponse=new QueryChildResponse();
		D605Response d605Response = new D605Response();
		boolean state=true;
		Session session = this.sessionFactory.getCurrentSession();
		this.errorMessage = new StringBuffer();
		D605 d605 = d605Request.getD605();
		long result = (Long)session.save(d605);
		if(result > 0) {
			state=true;
			d605Response.setD60501(result);
		} else {
			state=false;
			
		}
		queryChildResponse.setState(state);
		return d605Response;
	}
	@Override
	public QueryChildResponse queryD605(QueryChildRequest queryChildRequest) {
		QueryChildResponse queryChildResponse =new QueryChildResponse();
		String d605_09_Q = queryChildRequest.getD605_09();
		String d605_04_Q = queryChildRequest.getD605_04();
		String d605_05_Q = queryChildRequest.getD605_05();
		String d605_30_Q = queryChildRequest.getD605_30();
		Date d60516Start = queryChildRequest.getD60516Start();
		Date d60516End = queryChildRequest.getD60516End();
		int parameterPageindex = queryChildRequest.getParameterPageindex();
		int parameterPagesize = queryChildRequest.getParameterPagesize();
		String flag = queryChildRequest.getFlag();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		if(!StringUtil.isBlankString(d605_30_Q)){
			if(d605_30_Q.length() == 14)
			{
				parameterConditionwhere.append(" and t.d605_30 = '");
				parameterConditionwhere.append(d605_30_Q);
				parameterConditionwhere.append("'");
			}else
			{
				parameterConditionwhere.append(" and t.d605_30 like '");
				parameterConditionwhere.append(d605_30_Q);
				parameterConditionwhere.append("%'");
			}
		}
		if(!StringUtil.isBlankString(d605_09_Q)){
			parameterConditionwhere.append(" and t.d605_09 like '%");
			parameterConditionwhere.append(d605_09_Q);
			parameterConditionwhere.append("%'");
		}
		if(!StringUtil.isBlankString(d605_04_Q)){
			parameterConditionwhere.append(" and t.d605_04 like '%");
			parameterConditionwhere.append(d605_04_Q);
			parameterConditionwhere.append("%'");
		}
		if(!StringUtil.isBlankString(d605_05_Q)){
			parameterConditionwhere.append(" and t.d605_05 like '%");
			parameterConditionwhere.append(d605_05_Q);
			parameterConditionwhere.append("%'");
		}
		if(d60516Start != null)
		{
			String d60516Start_p = simpleDateFormat.format(d60516Start);
			parameterConditionwhere.append( "and t.d605_16 >= to_date('" + d60516Start_p + "', 'yyyy-mm-dd')");
		}
		if(d60516End != null)
		{
			String d60516End_p = simpleDateFormat.format(d60516End);
			parameterConditionwhere.append(" and t.d605_16<=to_date('" + d60516End_p + "', 'yyyy-mm-dd')");
		}
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_D605");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D605_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			
			long rowCount = callableStatement.getLong(6);
			queryChildResponse.setRowCount(rowCount);
			queryChildResponse.setFlag(flag);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			
			VD605 vd605 = null;
			List<VD605> vd605s = new ArrayList<VD605>();
		
			while(resultSet.next()){
				long d60501 = resultSet.getLong("D605_01");
				String d60502 = resultSet.getString("D605_02");
				String d60503 = resultSet.getString("D605_03");
				String d60504 = resultSet.getString("D605_04");
				String d60505 = resultSet.getString("D605_05");
				String d60506 = resultSet.getString("D605_06");
				String d60507 = resultSet.getString("D605_07");
				String d60508 = resultSet.getString("D605_08");
				String d60509 = resultSet.getString("D605_09");
				String d60510 = resultSet.getString("D605_10");
				
				Date d60511 = resultSet.getTimestamp("D605_11");
				long d60512 = resultSet.getLong("D605_12");
				String d60513 = resultSet.getString("D605_13");
				long d60514 = resultSet.getLong("D605_14");
				String d60515 = resultSet.getString("D605_15");
				Date d60516 = resultSet.getTimestamp("D605_16");
				String d60517 = resultSet.getString("D605_17");
				String d60518 = resultSet.getString("D605_18");
				String d60519 = resultSet.getString("D605_19");
				String d60520 = resultSet.getString("D605_20");
				
				String d60521 = resultSet.getString("D605_21");
				String d60522 = resultSet.getString("D605_22");
				String d60523 = resultSet.getString("D605_23");
				String d60524 = resultSet.getString("D605_24");
				String d60525 = resultSet.getString("D605_25");
				String d60526 = resultSet.getString("D605_26");
				String d60527 = resultSet.getString("D605_27");
				String d60528 = resultSet.getString("D605_28");
				String d60529 = resultSet.getString("D605_29");
				String d60530 = resultSet.getString("D605_30");
				String d60531 = resultSet.getString("D605_31");
				Date d60532 = resultSet.getTimestamp("D605_32");
				String d60533=resultSet.getString("D605_33");
				
				String d60508ZH = resultSet.getString("D605_08_ZH");
				String d60510ZH = resultSet.getString("D605_10_ZH");
				String d60513ZH = resultSet.getString("D605_13_ZH");
				String d60515ZH = resultSet.getString("D605_15_ZH");
				String d60523ZH = resultSet.getString("D605_23_ZH");
				String d60525ZH = resultSet.getString("D605_25_ZH");
				String d60526ZH = resultSet.getString("D605_26_ZH");
				String d60527ZH = resultSet.getString("D605_27_ZH");
				String d60528ZH = resultSet.getString("D605_28_ZH");
				String d60529ZH = resultSet.getString("D605_29_ZH");
				String d60530ZH = resultSet.getString("D605_30_ZH");
				
				vd605 = new VD605();
				
				vd605.setD60501(d60501);
				vd605.setD60502(d60502);
				vd605.setD60503(d60503);
				vd605.setD60504(d60504);
				vd605.setD60505(d60505);
				vd605.setD60506(d60506);
				vd605.setD60507(d60507);
				vd605.setD60508(d60508);
				vd605.setD60509(d60509);
				vd605.setD60510(d60510);
				
				vd605.setD60511(d60511);
				vd605.setD60512(d60512);
				vd605.setD60513(d60513);
				vd605.setD60514(d60514);
				vd605.setD60515(d60515);
				vd605.setD60516(d60516);
				vd605.setD60517(d60517);
				vd605.setD60518(d60518);
				vd605.setD60519(d60519);
				vd605.setD60520(d60520);
				
				vd605.setD60521(d60521);
				vd605.setD60522(d60522);
				vd605.setD60523(d60523);
				vd605.setD60524(d60524);
				vd605.setD60525(d60525);
				vd605.setD60526(d60526);
				vd605.setD60527(d60527);
				vd605.setD60528(d60528);
				vd605.setD60529(d60529);
				vd605.setD60530(d60530);
				
				vd605.setD60531(d60531);
				vd605.setD60532(d60532);
				vd605.setD60533(d60533);
				
				vd605.setD60508ZH(d60508ZH);
				vd605.setD60510ZH(d60510ZH);
				vd605.setD60513ZH(d60513ZH);
				vd605.setD60515ZH(d60515ZH);
				vd605.setD60523ZH(d60523ZH);
				vd605.setD60525ZH(d60525ZH);
				vd605.setD60526ZH(d60526ZH);
				vd605.setD60527ZH(d60527ZH);
				vd605.setD60528ZH(d60528ZH);
				vd605.setD60529ZH(d60529ZH);
				vd605.setD60530ZH(d60530ZH);
				vd605s.add(vd605);
			}
			queryChildResponse.setD605s(vd605s);
		} catch (Exception e) {
			e.printStackTrace();
			queryChildResponse.setErrorMessage("查询失败！");
		}finally{
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
		return queryChildResponse;
	}
	@Override
	public QueryChildResponse renewD605Handler(D605 d605) {
		Session session =sessionFactory.getCurrentSession();
		QueryChildResponse queryChildResponse=new QueryChildResponse();
		boolean state=true;
		try
		{
			session.saveOrUpdate(d605);
			queryChildResponse.setPromptMessage("修改成功！");
		}catch(Exception e)
		{
			e.printStackTrace();
			queryChildResponse.setErrorMessage("修改失败!");
			state=false;
		}
		queryChildResponse.setState(state);
		return queryChildResponse;
	}
	@Override
	public QueryChildResponse deleteD605(QueryChildRequest queryChildRequest) {
		QueryChildResponse queryChildResponse=null;
		long d60501=queryChildRequest.getD605_01();
		queryChildResponse=new QueryChildResponse();
		Session session=sessionFactory.getCurrentSession();
		D605 d605=new D605();
		d605.setD60501(d60501);
		session.delete(d605);
		queryChildResponse.setPromptMessage("删除成功！");
		return queryChildResponse;
	}
}
