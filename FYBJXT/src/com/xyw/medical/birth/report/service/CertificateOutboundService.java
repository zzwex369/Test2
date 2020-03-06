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

import com.xyw.medical.birth.model.VD503;

public class CertificateOutboundService {
	private DataSource dataSource;
	
	public List<VD503> queryVD503(String d503_02, String date_start, String date_end, ServletContext servletContext)
	{
		
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from v_d503 t where t.D503_02 like ? and t.D503_05 >= to_date(?,'YYYY-MM-DD') and t.D503_05 <= to_date(?,'YYYY-MM-DD')";
		
		List<VD503> listVD503 = null;
		VD503 vd503 = null;
		try
		{
			connection = this.dataSource.getConnection();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, d503_02 + "%");
			preparedStatement.setString(2, date_start);
			preparedStatement.setString(3, date_end);
			
			resultSet = preparedStatement.executeQuery();
			
			listVD503 = new ArrayList<VD503>();
			
			while(resultSet.next())
			{
				long d50301 = resultSet.getLong("D503_01");
				String d50302 = resultSet.getString("D503_02");
				String d50302Zh = resultSet.getString("D503_02_ZH");
				String d50303 = resultSet.getString("D503_03");
				int d50304 = resultSet.getInt("D503_04");
				Date d50305 = resultSet.getDate("D503_05");
				int d50306 = resultSet.getInt("D503_06");
				String d50307 = resultSet.getString("D503_07");
				String d50307Zh = resultSet.getString("D503_07_ZH");
				String d50308 = resultSet.getString("D503_08");
				String d50309 = resultSet.getString("D503_09");
				String d50310 = resultSet.getString("D503_10");
				
				vd503 = new VD503();
				vd503.setD50301(d50301);
				vd503.setD50302(d50302);
				vd503.setD50302Zh(d50302Zh);
				vd503.setD50303(d50303);
				vd503.setD50304(d50304);
				vd503.setD50305(d50305);
				vd503.setD50306(d50306);
				vd503.setD50307(d50307);
				vd503.setD50307Zh(d50307Zh);
				vd503.setD50308(d50308);
				vd503.setD50309(d50309);
				vd503.setD50310(d50310);
				
				listVD503.add(vd503);
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}finally
		{
			this.close(connection, preparedStatement, resultSet);
		}
		return listVD503;
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
