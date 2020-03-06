package com.xyw.medical.fnbj.report.service;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.fnbj.model.VL401;

public class FnrxadaService {
	
	private DataSource dataSource;
//	,String l401_02,String l401_04
	public VL401 queryL401(long l401_01,ServletContext servletContext){
		WebApplicationContext webApplicationContext =WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource =(DataSource) webApplicationContext.getBean("dataSource");	
		Connection connection =null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet =null;
		VL401 vl401 = null;
		
		StringBuffer sql = new StringBuffer("select * from v_l401 t where 1=1 ");
		if(l401_01 != 0){
			sql.append(" and t.L401_01 ="+l401_01);
		}
		
		try {
			connection=this.dataSource.getConnection();
			preparedStatement=connection.prepareCall(sql.toString());
			resultSet=preparedStatement.executeQuery();
			vl401=new VL401();
			while (resultSet.next()) {
				long l40101 = resultSet.getLong("L401_01");
				String l40102 = resultSet.getString("L401_02");
				String l40103 = resultSet.getString("L401_03");
				String l40104 = resultSet.getString("L401_04");
				Date l40105 = resultSet.getTimestamp("L401_05");
				short l40106 = resultSet.getShort("L401_06");
				String l40107 = resultSet.getString("L401_07");
				String l40108 = resultSet.getString("L401_08");
				String l40109 = resultSet.getString("L401_09");
				String l40110 = resultSet.getString("L401_10");
				String l40111 = resultSet.getString("L401_11");
				String l40112 = resultSet.getString("L401_12");
				String l40113 = resultSet.getString("L401_13");
				String l40114 = resultSet.getString("L401_14");
				String l40115 = resultSet.getString("L401_15");
				String l40116 = resultSet.getString("L401_16");
				String l40117 = resultSet.getString("L401_17");
				String l40118 = resultSet.getString("L401_18");
				Date l40119 = resultSet.getTimestamp("L401_19");
				
				String l40103zh = resultSet.getString("L401_03ZH");
				String l40107zh = resultSet.getString("L401_07ZH");
				String l40108zh = resultSet.getString("L401_08ZH");
				String l40109zh = resultSet.getString("L401_09ZH");
				String l40111zh = resultSet.getString("L401_11ZH");
				String l40113zh = resultSet.getString("L401_13ZH");
				String l40117zh = resultSet.getString("L401_17ZH");
				String l40105str = resultSet.getString("L401_05STR");
				String l40119str = resultSet.getString("L401_19STR");
				
				vl401.setL40101(l40101);
				vl401.setL40102(l40102);
				vl401.setL40103(l40103);
				vl401.setL40104(l40104);
				vl401.setL40105(l40105);
				vl401.setL40106(l40106);
				vl401.setL40107(l40107);
				vl401.setL40108(l40108);
				vl401.setL40109(l40109);
				vl401.setL40110(l40110);
				vl401.setL40111(l40111);
				vl401.setL40112(l40112);
				vl401.setL40113(l40113);
				vl401.setL40114(l40114);
				vl401.setL40115(l40115);
				vl401.setL40116(l40116);
				vl401.setL40117(l40117);
				vl401.setL40118(l40118);
				vl401.setL40119(l40119);
				vl401.setL40103zh(l40103zh);
				vl401.setL40107zh(l40107zh);
				vl401.setL40108zh(l40108zh);
				vl401.setL40109zh(l40109zh);
				vl401.setL40111zh(l40111zh);
				vl401.setL40113zh(l40113zh);
				vl401.setL40117zh(l40117zh);
				vl401.setL40105str(l40105str);
				vl401.setL40119str(l40119str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close(connection,preparedStatement,resultSet);
		}		
		return vl401;
	}
	private void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		try {
			if(resultSet != null) {
				resultSet.close();
				resultSet = null;
			}
			if(preparedStatement != null) {
				preparedStatement.close();
				preparedStatement = null;
			}
			if(connection != null) {
				connection.close();
				connection = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
