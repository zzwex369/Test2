package com.xyw.medical.birth.report.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.birth.report.model.BirthTemp;

public class CertificateBabyBirthService2 {
	private DataSource dataSource;
	
	public List<BirthTemp> queryReportGenderTemp(String date_start, String date_end, String areacode, ServletContext servletContext)
	{
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		CallableStatement callableStatement = null;
		List<BirthTemp> birthTemps = null;
		
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call reportBirth_package_two.birth_procedure_two(?, ?, ?, ?)}");
			callableStatement.setString(1, date_start);
			callableStatement.setString(2, date_end);
			callableStatement.setString(3, areacode);
			callableStatement.registerOutParameter(4, OracleTypes.CURSOR);
			callableStatement.execute();
			
			ResultSet resultSet = (ResultSet)callableStatement.getObject(4);
			birthTemps = new ArrayList<BirthTemp>();
			BirthTemp rgt = null;
			while(resultSet.next()) {
				rgt = new BirthTemp();
				
				rgt.setT01(resultSet.getLong("T_01"));
				rgt.setT02(resultSet.getLong("T_02"));
				rgt.setT03(resultSet.getLong("T_03"));
				rgt.setT04(resultSet.getString("T_04"));
				rgt.setT05(resultSet.getString("T_05"));
				rgt.setT06(resultSet.getLong("T_06"));
				rgt.setT07(resultSet.getLong("T_07"));
				rgt.setT08(resultSet.getLong("T_08"));
				rgt.setT09(resultSet.getLong("T_09"));
				rgt.setT10(resultSet.getLong("T_10"));
				rgt.setOther(resultSet.getLong("T_OTHER"));
				rgt.setTotal(resultSet.getLong("T_TOTAL"));
				rgt.setAreaCode(resultSet.getString("AREACODE"));
				rgt.setAreaCode_Zh(resultSet.getString("AREACODE_ZH"));
				birthTemps.add(rgt);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally 
		{
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
		return birthTemps;
	}
}
