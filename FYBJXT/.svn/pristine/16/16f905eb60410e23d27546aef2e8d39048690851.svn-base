package com.xyw.medical.birth.report.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.birth.model.VD502;

public class CertificateRegistService {
	
	private DataSource dataSource;
	
	public List<VD502> queryD502(String d502_02, String date_start, String date_end, ServletContext servletContext) {
		
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from v_d502 t where t.D502_02 = ? and t.D502_05 >= to_date(?,'YYYY-MM-DD') and t.D502_05 <= to_date(?,'YYYY-MM-DD')";
		
		List<VD502> vd502List = null;
		
		try {
			connection = this.dataSource.getConnection();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, d502_02);
			preparedStatement.setString(2, date_start);
			preparedStatement.setString(3, date_end);
			
			resultSet = preparedStatement.executeQuery();
			
			VD502 vd502 = null;
			
			vd502List = new ArrayList<VD502>();
			
			while(resultSet.next()) {
				
				long d50201 = resultSet.getLong("D502_01");
				String d50202 = resultSet.getString("D502_02");
				String d50202Zh = resultSet.getString("D502_02_ZH");
				String d50203 = resultSet.getString("D502_03");
				int d50204 = resultSet.getInt("D502_04");
				Date d50205 = resultSet.getDate("D502_05");
				int d50206 = resultSet.getInt("D502_06");
				String d50207 = resultSet.getString("D502_07");
				String d50207Zh = resultSet.getString("D502_07_ZH");
				String d50208 = resultSet.getString("D502_08");
				String d50209 = resultSet.getString("D502_09");
				String d50210 = resultSet.getString("D502_10");
				
				vd502 = new VD502();
				vd502.setD50201(d50201);
				vd502.setD50202(d50202);
				vd502.setD50202Zh(d50202Zh);
				vd502.setD50203(d50203);
				vd502.setD50204(d50204);
				vd502.setD50205(d50205);
				vd502.setD50206(d50206);
				vd502.setD50207(d50207);
				vd502.setD50207Zh(d50207Zh);
				vd502.setD50208(d50208);
				vd502.setD50209(d50209);
				vd502.setD50210(d50210);
				vd502List.add(vd502);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, resultSet);
		}
		return vd502List;
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
