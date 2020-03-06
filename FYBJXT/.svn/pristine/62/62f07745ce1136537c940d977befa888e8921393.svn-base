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

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.birth.model.VD304;

public class CertificateFirstDJBService {
	
	private DataSource dataSource;
	
	public VD304 queryD304(String d304_01, String d304_02,String d304_18,String d304_24,String fm,ServletContext servletContext) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		VD304 vd304 = null;
		
		StringBuffer sql = new StringBuffer("select * from v_d304 t where 1=1 ");
		if(d304_01 != null){
			sql.append(" and t.D304_01 ="+d304_01 );
		}
		if(d304_02 !=null){
			sql.append(" and t.D304_02 ='"+d304_02+"'" );
		}
		if(fm.equals("1") && !d304_24.equals("null")){
			sql.append(" and t.D304_24 ='"+d304_24+"'" );
		}else if(fm.equals("2") && !d304_18.equals("null")){
			sql.append(" and t.D304_18 ='"+d304_18+"'" );
		}else{
			if(!d304_18.equals("null") && d304_18 != null){
				sql.append(" and t.D304_18 ='"+d304_18+"'" );
			}
			if(!d304_24.equals("null") && d304_24 != null){
				sql.append(" and t.D304_24 ='"+d304_24+"'" );
			}
		}
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			resultSet = preparedStatement.executeQuery();
			vd304 = new VD304();
			while(resultSet.next()) {
				long d30401 = resultSet.getLong("D304_01");
				String d30402 = resultSet.getString("D304_02");
				String d30403 = resultSet.getString("D304_03");
				Date d30404 = resultSet.getTimestamp("D304_04");
				String d30405 = resultSet.getString("D304_05");
				int d30406 = resultSet.getInt("D304_06");
				int d30407 = resultSet.getInt("D304_07");
				double d30408 = resultSet.getDouble("D304_08");
				double d30409 = resultSet.getDouble("D304_09");
				String d30410 = resultSet.getString("D304_10");
				String d30411 = resultSet.getString("D304_11");
				String d30412 = resultSet.getString("D304_12");
				Date d30413 = resultSet.getDate("D304_13");
				String d30414 = resultSet.getString("D304_14");
				String d30415 = resultSet.getString("D304_15");
				String d30416 = resultSet.getString("D304_16");
				String d30417 = resultSet.getString("D304_17");
				String d30418 = resultSet.getString("D304_18");
				String d30419 = resultSet.getString("D304_19");
				String d30420 = resultSet.getString("D304_20");
				String d30421 = resultSet.getString("D304_21");
				String d30422 = resultSet.getString("D304_22");
				String d30423 = resultSet.getString("D304_23");
				String d30424 = resultSet.getString("D304_24");
				String d30425 = resultSet.getString("D304_25");
				String d30426 = resultSet.getString("D304_26");
				String d30427 = resultSet.getString("D304_27");
				String d30428 = resultSet.getString("D304_28");
				String d30429 = resultSet.getString("D304_29");
				String d30430 = resultSet.getString("D304_30");
				String d30431 = resultSet.getString("D304_31");
				Date d30434 = resultSet.getDate("D304_34");
				Date d30435 = resultSet.getDate("D304_35");
				
				String d30403Zh = resultSet.getString("D304_03_ZH");
				String d30405Zh = resultSet.getString("D304_05_ZH");
				String d30411Zh = resultSet.getString("D304_11_ZH");
				String d30417Zh = resultSet.getString("D304_17_ZH");
				String d30419Zh = resultSet.getString("D304_19_ZH");
				String d30420Zh = resultSet.getString("D304_20_ZH");
				String d30423Zh = resultSet.getString("D304_23_ZH");
				String d30425Zh = resultSet.getString("D304_25_ZH");
				String d30426Zh = resultSet.getString("D304_26_ZH");
				String d30429Zh = resultSet.getString("D304_29_ZH");
				String d30430Zh = resultSet.getString("D304_30_ZH");
				vd304.setD30401(d30401);
				vd304.setD30402(d30402);
				vd304.setD30403(d30403);
				if(d30404!=null){
					SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
					String d30404str111 = format.format(d30404);
					vd304.setD30404(d30404str111);
				}
				vd304.setD30405(d30405);
				vd304.setD30406(d30406);
				vd304.setD30407(d30407);
				vd304.setD30408(d30408);
				vd304.setD30409(d30409);
				vd304.setD30410(d30410);
				vd304.setD30411(d30411);
				vd304.setD30412(d30412);
				if(d30413!=null){
					SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
					String d30413str123 = format.format(d30413);
					vd304.setD30413(d30413str123);
				}
				vd304.setD30414(d30414);
				vd304.setD30415(d30415);
				vd304.setD30416(d30416);
				vd304.setD30417(d30417);
				vd304.setD30418(d30418);
				vd304.setD30419(d30419);
				vd304.setD30420(d30420);
				vd304.setD30421(d30421);
				vd304.setD30422(d30422);
				vd304.setD30423(d30423);
				vd304.setD30424(d30424);
				vd304.setD30425(d30425);
				vd304.setD30426(d30426);
				vd304.setD30427(d30427);
				vd304.setD30428(d30428);
				vd304.setD30429(d30429);
				vd304.setD30430(d30430);
				vd304.setD30431(d30431);
				
				vd304.setD30403Zh(d30403Zh);
				vd304.setD30405Zh(d30405Zh);
				vd304.setD30411Zh(d30411Zh);
				vd304.setD30417Zh(d30417Zh);
				vd304.setD30419Zh(d30419Zh);
				vd304.setD30420Zh(d30420Zh);
				vd304.setD30423Zh(d30423Zh);
				vd304.setD30425Zh(d30425Zh);
				vd304.setD30426Zh(d30426Zh);
				vd304.setD30429Zh(d30429Zh);
				vd304.setD30430Zh(d30430Zh);
				
				if(d30434!=null){
					vd304.setMotherage(this.getAge(d30434, d30404));
				}
				if(d30435!=null){
					vd304.setFatherage(this.getAge(d30435, d30404));
				}
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, resultSet);
		}
		return vd304;
	}
	
	public List<VD304> queryListVD304(String d304_11,String date_start, String date_end, ServletContext servletContext) {
		
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		VD304 vd304 = null;
		List<VD304> vd304List = null;
		
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement("select * from v_d304 t where t.D304_11 = ? and t.D304_13 >= to_date(?,'YYYY-MM-DD') and t.D304_13 <= to_date(?,'YYYY-MM-DD')");
			preparedStatement.setString(1, d304_11);
			preparedStatement.setString(2, date_start);
			preparedStatement.setString(3, date_end);
			resultSet = preparedStatement.executeQuery();
			
			vd304List = new ArrayList<VD304>();
			while(resultSet.next()) {
				vd304 = new VD304();
				long d30401 = resultSet.getLong("D304_01");
				String d30402 = resultSet.getString("D304_02");
				String d30403 = resultSet.getString("D304_03");
				Date d30404 = resultSet.getTimestamp("D304_04");
				String d30405 = resultSet.getString("D304_05");
				int d30406 = resultSet.getInt("D304_06");
				int d30407 = resultSet.getInt("D304_07");
				double d30408 = resultSet.getDouble("D304_08");
				double d30409 = resultSet.getDouble("D304_09");
				String d30410 = resultSet.getString("D304_10");
				String d30411 = resultSet.getString("D304_11");
				String d30412 = resultSet.getString("D304_12");
				Date d30413 = resultSet.getDate("D304_13");
				String d30414 = resultSet.getString("D304_14");
				String d30415 = resultSet.getString("D304_15");
				String d30416 = resultSet.getString("D304_16");
				String d30417 = resultSet.getString("D304_17");
				String d30418 = resultSet.getString("D304_18");
				String d30419 = resultSet.getString("D304_19");
				String d30420 = resultSet.getString("D304_20");
				String d30421 = resultSet.getString("D304_21");
				String d30422 = resultSet.getString("D304_22");
				String d30423 = resultSet.getString("D304_23");
				String d30424 = resultSet.getString("D304_24");
				String d30425 = resultSet.getString("D304_25");
				String d30426 = resultSet.getString("D304_26");
				String d30427 = resultSet.getString("D304_27");
				String d30428 = resultSet.getString("D304_28");
				String d30429 = resultSet.getString("D304_29");
				String d30430 = resultSet.getString("D304_30");
				String d30431 = resultSet.getString("D304_31");
				Date d30434 = resultSet.getDate("D304_34");
				Date d30435 = resultSet.getDate("D304_35");
				
				String d30403Zh = resultSet.getString("D304_03_ZH");
				String d30405Zh = resultSet.getString("D304_05_ZH");
				String d30411Zh = resultSet.getString("D304_11_ZH");
				String d30417Zh = resultSet.getString("D304_17_ZH");
				String d30419Zh = resultSet.getString("D304_19_ZH");
				String d30420Zh = resultSet.getString("D304_20_ZH");
				String d30423Zh = resultSet.getString("D304_23_ZH");
				String d30425Zh = resultSet.getString("D304_25_ZH");
				String d30426Zh = resultSet.getString("D304_26_ZH");
				String d30429Zh = resultSet.getString("D304_29_ZH");
				String d30430Zh = resultSet.getString("D304_30_ZH");
				
				vd304.setD30401(d30401);
				vd304.setD30402(d30402);
				vd304.setD30403(d30403);
				if(d30404!=null){
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					String d30404str = format.format(d30404);
					vd304.setD30404(d30404str);
				}
				vd304.setD30405(d30405);
				vd304.setD30406(d30406);
				vd304.setD30407(d30407);
				vd304.setD30408(d30408);
				vd304.setD30409(d30409);
				vd304.setD30410(d30410);
				vd304.setD30411(d30411);
				vd304.setD30412(d30412);
				if(d30413!=null){
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					String d30413str = format.format(d30413);
					vd304.setD30413(d30413str);
				}
				vd304.setD30414(d30414);
				vd304.setD30415(d30415);
				vd304.setD30416(d30416);
				vd304.setD30417(d30417);
				vd304.setD30418(d30418);
				vd304.setD30419(d30419);
				vd304.setD30420(d30420);
				vd304.setD30421(d30421);
				vd304.setD30422(d30422);
				vd304.setD30423(d30423);
				vd304.setD30424(d30424);
				vd304.setD30425(d30425);
				vd304.setD30426(d30426);
				vd304.setD30427(d30427);
				vd304.setD30428(d30428);
				vd304.setD30429(d30429);
				vd304.setD30430(d30430);
				vd304.setD30431(d30431);
				
				vd304.setD30403Zh(d30403Zh);
				vd304.setD30405Zh(d30405Zh);
				vd304.setD30411Zh(d30411Zh);
				vd304.setD30417Zh(d30417Zh);
				vd304.setD30419Zh(d30419Zh);
				vd304.setD30420Zh(d30420Zh);
				vd304.setD30423Zh(d30423Zh);
				vd304.setD30425Zh(d30425Zh);
				vd304.setD30426Zh(d30426Zh);
				vd304.setD30429Zh(d30429Zh);
				vd304.setD30430Zh(d30430Zh);
				
				if(d30434!=null){
					vd304.setMotherage(this.getAge(d30434, d30404));
				}
				if(d30435!=null){
					vd304.setFatherage(this.getAge(d30435, d30404));
				}
				
				vd304List.add(vd304);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, resultSet);
		}
		return vd304List;
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
	
	private String getAge(Date dateStart,Date dateEnd){
		String age = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String startime = format.format(dateStart);
			String endtime = format.format(dateEnd);
			int startyy = Integer.parseInt(startime.substring(0, 4));
			int endyy = Integer.parseInt(endtime.substring(0, 4));
			int startMM = Integer.parseInt(startime.substring(5, 7));
			int endMM = Integer.parseInt(endtime.substring(5, 7));
			int startdd = Integer.parseInt(startime.substring(8, 10));
			int enddd = Integer.parseInt(endtime.substring(8, 10));
			if(startMM > endMM || startMM == endMM && startdd > enddd){
				age = String.valueOf((endyy - startyy) - 1);
			}else{
				age = String.valueOf(endyy - startyy);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return age;
	}
}
