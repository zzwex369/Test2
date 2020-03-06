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

import com.xyw.medical.birth.report.model.ReportGenderTemp;

public class CertificateBabySexService
{
	private DataSource dataSource;
	
	public List<ReportGenderTemp> queryReportGenderTemp(String year, String institution, String institutionType,ServletContext servletContext)
	{
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		CallableStatement callableStatement = null;
		List<ReportGenderTemp> listReportGenderTemp = null;
		
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call reportGender_package.birthGender_procedure(?, ?, ?, ?)}");
			callableStatement.setString(1, year);
			callableStatement.setString(2, institutionType);
			callableStatement.setString(3, institution);
			callableStatement.registerOutParameter(4, OracleTypes.CURSOR);
			callableStatement.execute();
			
			ResultSet resultSet = (ResultSet)callableStatement.getObject(4);
			listReportGenderTemp = new ArrayList<ReportGenderTemp>();
			
			while(resultSet.next()) {
				ReportGenderTemp rgt = new ReportGenderTemp();
				rgt.setInstitution(resultSet.getString("institution"));
				rgt.setInstitutionZH(resultSet.getString("institutionZh"));
				rgt.setBoy(resultSet.getInt("boy"));
				rgt.setGirl(resultSet.getInt("girl"));
				rgt.setPercent_boy(resultSet.getString("percent_boy"));
				rgt.setPercent_girl(resultSet.getString("percent_girl"));
				rgt.setTotal(resultSet.getInt("total"));
				rgt.setSe(resultSet.getInt("se"));
				
				listReportGenderTemp.add(rgt);
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
		return listReportGenderTemp;
	}
}
