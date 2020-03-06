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

import com.xyw.medical.fnbj.model.VL301;

public class FngjadaService {
	
	private DataSource dataSource;

	public VL301 queryL301(String l301_01,ServletContext servletContext){
		WebApplicationContext webApplicationContext =WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource =(DataSource) webApplicationContext.getBean("dataSource");	
		Connection connection =null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet =null;
		VL301 vl301 = null;
		
		StringBuffer sql = new StringBuffer("select * from v_l301 t where 1=1 ");
		if(l301_01 != null){
			sql.append(" and t.L301_01 ="+l301_01);
		}
		try {
			connection=this.dataSource.getConnection();
			preparedStatement=connection.prepareCall(sql.toString());
			resultSet=preparedStatement.executeQuery();
			vl301=new VL301();
			while (resultSet.next()) {
				String l30101 = resultSet.getString("L301_01");
				String l30102 = resultSet.getString("L301_02");
				String l30103 = resultSet.getString("L301_03");
				String l30104 = resultSet.getString("L301_04");
				Date l30105 = resultSet.getTimestamp("L301_05");
				short l30106 = resultSet.getShort("L301_06");
				String l30107 = resultSet.getString("L301_07");
				String l30108 = resultSet.getString("L301_08");
				String l30109 = resultSet.getString("L301_09");
				String l30110 = resultSet.getString("L301_10");
				String l30111 = resultSet.getString("L301_11");
				String l30112 = resultSet.getString("L301_12");
				String l30113 = resultSet.getString("L301_13");
				String l30114 = resultSet.getString("L301_14");
				String l30115 = resultSet.getString("L301_15");
				String l30116 = resultSet.getString("L301_16");
				String l30117 = resultSet.getString("L301_17");
				String l30118 = resultSet.getString("L301_18");
				Date l30119 = resultSet.getTimestamp("L301_19");
				
				String l30103zh = resultSet.getString("L301_03ZH");
				String l30107zh = resultSet.getString("L301_07ZH");
				String l30108zh = resultSet.getString("L301_08ZH");
				String l30109zh = resultSet.getString("L301_09ZH");
				String l30111zh = resultSet.getString("L301_11ZH");
				String l30113zh = resultSet.getString("L301_13ZH");
				String l30117zh = resultSet.getString("L301_17ZH");
				String l30105str = resultSet.getString("L301_05STR");
				String l30119str = resultSet.getString("L301_19STR");
				
				vl301.setL30101(l30101);
				vl301.setL30102(l30102);
				vl301.setL30103(l30103);
				vl301.setL30104(l30104);
				vl301.setL30105(l30105);
				vl301.setL30106(l30106);
				vl301.setL30107(l30107);
				vl301.setL30108(l30108);
				vl301.setL30109(l30109);
				vl301.setL30110(l30110);
				vl301.setL30111(l30111);
				vl301.setL30112(l30112);
				vl301.setL30113(l30113);
				vl301.setL30114(l30114);
				vl301.setL30115(l30115);
				vl301.setL30116(l30116);
				vl301.setL30117(l30117);
				vl301.setL30118(l30118);
				vl301.setL30119(l30119);
				vl301.setL30103zh(l30103zh);
				vl301.setL30107zh(l30107zh);
				vl301.setL30108zh(l30108zh);
				vl301.setL30109zh(l30109zh);
				vl301.setL30111zh(l30111zh);
				vl301.setL30113zh(l30113zh);
				vl301.setL30117zh(l30117zh);
				vl301.setL30105str(l30105str);
				vl301.setL30119str(l30119str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(connection,preparedStatement,resultSet);
		}		
		return vl301;
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
