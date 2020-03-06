package com.xyw.medical.birth.report.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.birth.model.VD603;

public class MybjkhService {

	private DataSource dataSource;
	
	private SessionFactory sessionFactory;
	
	public List<VD603> queryD603(String d603_02,String date_start,String date_end,ServletContext servletContext){
		
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from v_d603 t where t.d603_02 like ? and t.D603_15 >= to_date(?,'YYYY-MM-DD') and t.D603_15 <= to_date(?,'YYYY-MM-DD') order by t.D603_02_ZH");
		VD603 vd603 = null;
		List<VD603> vd603s = new ArrayList<VD603>();
		
		try{
			connection = this.dataSource.getConnection();
			
			preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setString(1, "%" + d603_02 + "%");
			preparedStatement.setString(2, date_start);
			preparedStatement.setString(3, date_end);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				vd603 = new VD603();
				
				long d60301 = resultSet.getLong("D603_01");
				String d60302 = resultSet.getString("D603_02");
				String d60302Zh = resultSet.getString("D603_02_ZH");
				String d60303 = resultSet.getString("D603_03");
				String d60304 = resultSet.getString("D603_04");
				String d60304Zh = resultSet.getString("D603_04_ZH");
				String d60305 = resultSet.getString("D603_05");
				int d60306 = resultSet.getInt("D603_06");
				String d60307 = resultSet.getString("D603_07");
				String d60307Zh = resultSet.getString("D603_07_ZH");
				String d60308 = resultSet.getString("D603_08");
				String d60308Zh = resultSet.getString("D603_08_ZH");
				String d60309 = resultSet.getString("D603_09");
				String d60309Zh = resultSet.getString("D603_09_ZH");
				int d60310 = resultSet.getInt("D603_10");
				Date d60311 = resultSet.getDate("D603_11");
				String d60312 = resultSet.getString("D603_12");
				String d60312Zh = resultSet.getString("D603_12_ZH");
				String d60313 = resultSet.getString("D603_13");
				String d60313Zh = resultSet.getString("D603_13_ZH");
				String d60314 = resultSet.getString("D603_14");
				Date d60315 = resultSet.getDate("D603_15");
				String d60316 = resultSet.getString("D603_16");
				String d60316Zh = resultSet.getString("D603_16_ZH");
				
				vd603.setD60301(d60301);
				vd603.setD60302(d60302);
				vd603.setD60302Zh(d60302Zh);
				vd603.setD60303(d60303);
				vd603.setD60304(d60304);
				vd603.setD60304Zh(d60304Zh);
				vd603.setD60305(d60305);
				vd603.setD60306(d60306);
				vd603.setD60307(d60307);
				vd603.setD60307Zh(d60307Zh);
				vd603.setD60308(d60308);
				vd603.setD60308Zh(d60308Zh);
				vd603.setD60309(d60309);
				vd603.setD60309Zh(d60309Zh);
				vd603.setD60310(d60310);
				String d60311_str = simpleDateFormat.format(d60311);
				vd603.setD60311(d60311_str);
				vd603.setD60312(d60312);
				vd603.setD60312Zh(d60312Zh);
				vd603.setD60313(d60313);
				vd603.setD60313Zh(d60313Zh);
				vd603.setD60314(d60314);
				String d60315_str = simpleDateFormat.format(d60315);
				vd603.setD60315(d60315_str);
				vd603.setD60316(d60316);
				vd603.setD60316Zh(d60316Zh);
				
				vd603s.add(vd603);
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally
		{
			this.close(connection, preparedStatement, resultSet);
		}
		
		return vd603s;
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
