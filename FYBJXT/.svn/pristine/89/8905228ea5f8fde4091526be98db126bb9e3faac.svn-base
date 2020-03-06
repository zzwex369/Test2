package com.xyw.medical.birth.report.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.birth.report.model.ReportTemp;

public class CencusService {
	
	private DataSource dataSource;
	
	private SessionFactory sessionFactory;

	public List<ReportTemp> queryReportTemp(String year, String institution, String institutionType,ServletContext servletContext) {
		
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		CallableStatement callableStatement = null;
		ReportTemp reportTemp = null;
		List<ReportTemp> listReportTemp = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call report_package.cencusByYear_procedure(?, ?,?,?)}");
			callableStatement.setString(1, year);
			callableStatement.setString(2, institutionType);
			callableStatement.setString(3, institution);
			callableStatement.registerOutParameter(4, OracleTypes.CURSOR);
			callableStatement.execute();
			
			ResultSet resultSet = (ResultSet)callableStatement.getObject(4);
			listReportTemp = new ArrayList<ReportTemp>();
			while(resultSet.next()) {
				
				reportTemp = new ReportTemp();
				reportTemp.setT01(resultSet.getInt("t_01"));
				reportTemp.setT02(resultSet.getInt("t_02"));
				reportTemp.setT03(resultSet.getInt("t_03"));
				reportTemp.setT04(resultSet.getInt("t_04"));
				reportTemp.setT05(resultSet.getInt("t_05"));
				reportTemp.setT06(resultSet.getInt("t_06"));
				reportTemp.setT07(resultSet.getInt("t_07"));
				reportTemp.setT08(resultSet.getInt("t_08"));
				reportTemp.setT09(resultSet.getInt("t_09"));
				reportTemp.setT10(resultSet.getInt("t_10"));
				reportTemp.setT11(resultSet.getInt("t_11"));
				reportTemp.setT12(resultSet.getInt("t_12"));
				reportTemp.setT13(resultSet.getInt("t_13"));
				reportTemp.setT14(resultSet.getInt("t_14"));
				reportTemp.setT15(resultSet.getInt("t_15"));
				reportTemp.setT16(resultSet.getInt("t_16"));
				reportTemp.setT17(resultSet.getInt("t_17"));
				reportTemp.setT18(resultSet.getInt("t_18"));
				reportTemp.setT19(resultSet.getInt("t_19"));
				reportTemp.setT20(resultSet.getInt("t_20"));
				reportTemp.setT21(resultSet.getInt("t_21"));
				reportTemp.setT22(resultSet.getInt("t_22"));
				reportTemp.setT23(resultSet.getInt("t_23"));
				reportTemp.setT24(resultSet.getInt("t_24"));
				reportTemp.setYear(resultSet.getString("year"));
				reportTemp.setInstitution(resultSet.getString("institution"));
				reportTemp.setInstitutionZh(resultSet.getString("institutionzh"));
				
				listReportTemp.add(reportTemp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(callableStatement != null) {
					callableStatement.close();
					callableStatement = null;
				}
				if(connection != null) {
					connection.close();
					connection = null;
				}
			} catch(Exception e) {
				
			}
		}
		return listReportTemp;
	}
	
	public String getInstitutionName(String institution, String institutionType, ServletContext servletContext){
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.sessionFactory = (SessionFactory)webApplicationContext.getBean("sessionFactory");
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			SQLQuery sqlQuery = null;
			String institutionName = null;
			if ("8".equals(institutionType)) {
				sqlQuery = session
						.createSQLQuery("select t.D101_02 from D101 t where t.d101_01 = (select t1.D101_11 from D101 t1 where t1.D101_01 = ?)");
				sqlQuery.setString(0, institution);
				institutionName = (String) sqlQuery.uniqueResult();
				return institutionName;
			} else {
				sqlQuery = session
						.createSQLQuery("select t.D101_02 from D101 t where t.d101_01 = ?");
				sqlQuery.setString(0, institution);
				institutionName = (String) sqlQuery.uniqueResult();
				return institutionName;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
