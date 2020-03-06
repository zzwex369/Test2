package com.xyw.medical.birth.report.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.birth.model.VD605;

public class ChildDeathReportFirstService {
	private DataSource dataSource;

	public VD605 queryD605(String d605_01,ServletContext servletContext) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		VD605 vd605=null;
		StringBuffer sql= new StringBuffer("select * from v_d605 t where 1=1");
		if (d605_01!=null) {
			sql.append("and t.D605_01="+d605_01);
		}
//		if (d605_09!=null) {
//			sql.append("and t.D605_09 ='"+d605_09+"'");
//		}
//		if (d605_16!=null) {
//			sql.append("and t.D605_16 ='"+d605_16+"'");
//		}
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			resultSet = preparedStatement.executeQuery();
			vd605=new VD605();
			while (resultSet.next()) {
				long d60501 = resultSet.getLong("D605_01");
				String d60502 = resultSet.getString("D605_02");
				String d60503 = resultSet.getString("D605_03");
				String d60504 = resultSet.getString("D605_04");
				String d60505 = resultSet.getString("D605_05");
				String d60506 = resultSet.getString("D605_06");
				String d60507 = resultSet.getString("D605_07");
				String d60508 = resultSet.getString("D605_08");
				String d60509 = resultSet.getString("D605_09");
				String d60510 = resultSet.getString("D605_10");
				
				Date d60511 = resultSet.getTimestamp("D605_11");
				long d60512 = resultSet.getLong("D605_12");
				String d60513 = resultSet.getString("D605_13");
				long d60514 = resultSet.getLong("D605_14");
				String d60515 = resultSet.getString("D605_15");
				Date d60516 = resultSet.getTimestamp("D605_16");
				String d60517 = resultSet.getString("D605_17");
				String d60518 = resultSet.getString("D605_18");
				String d60519 = resultSet.getString("D605_19");
				String d60520 = resultSet.getString("D605_20");
				
				String d60521 = resultSet.getString("D605_21");
				String d60522 = resultSet.getString("D605_22");
				String d60523 = resultSet.getString("D605_23");
				String d60524 = resultSet.getString("D605_24");
				String d60525 = resultSet.getString("D605_25");
				String d60526 = resultSet.getString("D605_26");
				String d60527 = resultSet.getString("D605_27");
				String d60528 = resultSet.getString("D605_28");
				String d60529 = resultSet.getString("D605_29");
				String d60530 = resultSet.getString("D605_30");
				String d60531 = resultSet.getString("D605_31");
				Date d60532 = resultSet.getTimestamp("D605_32");
				String d60533=resultSet.getString("D605_33");
				
				String d60508ZH = resultSet.getString("D605_08_ZH");
				String d60510ZH = resultSet.getString("D605_10_ZH");
				String d60513ZH = resultSet.getString("D605_13_ZH");
				String d60515ZH = resultSet.getString("D605_15_ZH");
				String d60523ZH = resultSet.getString("D605_23_ZH");
				String d60525ZH = resultSet.getString("D605_25_ZH");
				String d60526ZH = resultSet.getString("D605_26_ZH");
				String d60527ZH = resultSet.getString("D605_27_ZH");
				String d60528ZH = resultSet.getString("D605_28_ZH");
				String d60529ZH = resultSet.getString("D605_29_ZH");
				String d60530ZH = resultSet.getString("D605_30_ZH");
				String d60503ZH = resultSet.getString("D605_03_ZH");
				
				vd605.setD60501(d60501);
				vd605.setD60502(d60502);
				vd605.setD60503(d60503);
				vd605.setD60504(d60504);
				vd605.setD60505(d60505);
				vd605.setD60506(d60506);
				vd605.setD60507(d60507);
				vd605.setD60508(d60508);
				vd605.setD60509(d60509);
				vd605.setD60510(d60510);
				
				vd605.setD60511(d60511);
				vd605.setD60512(d60512);
				vd605.setD60513(d60513);
				vd605.setD60514(d60514);
				vd605.setD60515(d60515);
				vd605.setD60516(d60516);
				vd605.setD60517(d60517);
				vd605.setD60518(d60518);
				vd605.setD60519(d60519);
				vd605.setD60520(d60520);
				
				vd605.setD60521(d60521);
				vd605.setD60522(d60522);
				vd605.setD60523(d60523);
				vd605.setD60524(d60524);
				vd605.setD60525(d60525);
				vd605.setD60526(d60526);
				vd605.setD60527(d60527);
				vd605.setD60528(d60528);
				vd605.setD60529(d60529);
				vd605.setD60530(d60530);
				vd605.setD60531(d60531);
				vd605.setD60532(d60532);
				vd605.setD60533(d60533);
				
				vd605.setD60508ZH(d60508ZH);
				vd605.setD60510ZH(d60510ZH);
				vd605.setD60513ZH(d60513ZH);
				vd605.setD60515ZH(d60515ZH);
				vd605.setD60523ZH(d60523ZH);
				vd605.setD60525ZH(d60525ZH);
				vd605.setD60526ZH(d60526ZH);
				vd605.setD60527ZH(d60527ZH);
				vd605.setD60528ZH(d60528ZH);
				vd605.setD60529ZH(d60529ZH);
				vd605.setD60530ZH(d60530ZH);
				vd605.setD60503ZH(d60503ZH);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, resultSet);
		}
		return vd605;
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
