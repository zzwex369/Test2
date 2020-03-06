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

public class CertificateBabyBirthService {

private DataSource dataSource;
	
	public List<ReportGenderTemp> queryReportGenderTemp(String date_start, String date_end, String institution, String institutionType,ServletContext servletContext)
	{
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		CallableStatement callableStatement = null;
		List<ReportGenderTemp> listReportGenderTemp = null;
		
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call reportBirth_package.birth_procedure(?, ?, ?, ?, ?)}");
			callableStatement.setString(1, date_start);
			callableStatement.setString(2, date_end);
			callableStatement.setString(3, institutionType);
			callableStatement.setString(4, institution);
			callableStatement.registerOutParameter(5, OracleTypes.CURSOR);
			callableStatement.execute();
			
			ResultSet resultSet = (ResultSet)callableStatement.getObject(5);
			listReportGenderTemp = new ArrayList<ReportGenderTemp>();
			ReportGenderTemp rgt = null;
			while(resultSet.next()) {
				rgt = new ReportGenderTemp();
				rgt.setInstitution(resultSet.getString("institution"));
				rgt.setInstitutionZH(resultSet.getString("institutionZh"));
				rgt.setBoy(resultSet.getInt("boy"));
				rgt.setGirl(resultSet.getInt("girl"));
				rgt.setTotal(resultSet.getInt("total"));
				rgt.setNativePlace(resultSet.getInt("local"));
				rgt.setOtherPlaces(resultSet.getInt("nonlocal"));
//				rgt.setAreaZH(resultSet.getString("areacodezh"));
				
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
