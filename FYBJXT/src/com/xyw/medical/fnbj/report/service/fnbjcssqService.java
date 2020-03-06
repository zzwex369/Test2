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

import com.xyw.medical.fnbj.model.VF501;

public class fnbjcssqService {
	private DataSource dataSource;
	
	public VF501 queryfnbj(String id, ServletContext servletContext) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource) webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		VF501 vf501 =null;
		try {
			connection = this.dataSource.getConnection();
			pStatement = connection.prepareStatement("select * from v_f501 t where t.f501_01=?");
			pStatement.setString(1, id);
			vf501 =new VF501();
			resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				String f50101 = resultSet.getString("F501_01");
				long f50102 = resultSet.getLong("F501_02");
				String f50103 = resultSet.getString("F501_03");
				String f50104 = resultSet.getString("F501_04");
				String f50105 = resultSet.getString("F501_05");
				Date f50106 = resultSet.getDate("F501_06");
				String f50107 = resultSet.getString("F501_07");
				double f50108 = resultSet.getDouble("F501_08");
				String f50109 = resultSet.getString("F501_09");
				String f50110 = resultSet.getString("F501_10");
				String f50111 = resultSet.getString("F501_11");
				String f50112 = resultSet.getString("F501_12");
				Date f50113 = resultSet.getDate("F501_13");
				String f50114 = resultSet.getString("F501_14");
				long f50115 = resultSet.getLong("F501_15");
				String f50116 = resultSet.getString("F501_16");
				Date f50117 = resultSet.getDate("F501_17");
				long f50118 = resultSet.getLong("F501_18");
				String f50119 = resultSet.getString("F501_19");
				String f50120 = resultSet.getString("F501_20");
				String f50121 = resultSet.getString("F501_21");
				String f50122 = resultSet.getString("F501_22");
				String f50123 = resultSet.getString("F501_23");
				String f50124 = resultSet.getString("F501_24");
				Date f50125 = resultSet.getDate("F501_25");
				String f50126 = resultSet.getString("F501_26");
				String f50127 = resultSet.getString("F501_27");
				Date f50128 = resultSet.getDate("F501_28");
				String f50129 = resultSet.getString("F501_29");
				String f50130 = resultSet.getString("F501_30");
				long f50131 = resultSet.getLong("F501_31");
				String f50132 = resultSet.getString("F501_32");
				String f50133 = resultSet.getString("F501_33");
				String f50134 = resultSet.getString("F501_34");
				String f50135 = resultSet.getString("F501_35");
				long f50136 = resultSet.getLong("F501_36");
				long f50137 = resultSet.getLong("F501_37");
				String f50138 = resultSet.getString("F501_38");
				String f50139 = resultSet.getString("F501_39");
				Date f50140 = resultSet.getDate("F501_40");

				String f50106Str =resultSet.getString("F501_06_Str");
				String f50113Str =resultSet.getString("F501_13_Str");
				String f50117Str =resultSet.getString("F501_17_Str");
				String f50125Str =resultSet.getString("F501_25_Str");
				String f50128Str =resultSet.getString("F501_28_Str");

				String f50104Zh =resultSet.getString("F501_04_ZH");
				String f50109Zh =resultSet.getString("F501_09_ZH");
				String f50110Zh =resultSet.getString("F501_10_ZH");
				String f50111Zh =resultSet.getString("F501_11_ZH");
				String f50112Zh =resultSet.getString("F501_12_ZH");
				String f50114Zh =resultSet.getString("F501_14_ZH");
				String f50119Zh =resultSet.getString("F501_19_ZH");
				String f50120Zh =resultSet.getString("F501_20_ZH");
				String f50126Zh =resultSet.getString("F501_26_ZH");
				
				vf501.setF50101(f50101);
				vf501.setF50102(f50102);
				vf501.setF50103(f50103);
				vf501.setF50104(f50104);
				vf501.setF50104Zh(f50104Zh);
				vf501.setF50105(f50105);
				vf501.setF50106(f50106);
				vf501.setF50106Str(f50106Str);
				vf501.setF50107(f50107);
				vf501.setF50108(f50108);
				vf501.setF50109(f50109);
				vf501.setF50109Zh(f50109Zh);
				vf501.setF50110(f50110);
				vf501.setF50110Zh(f50110Zh);
				vf501.setF50111(f50111);
				vf501.setF50111Zh(f50111Zh);
				vf501.setF50112(f50112);
				vf501.setF50112Zh(f50112Zh);
				vf501.setF50113(f50113);
				vf501.setF50113Str(f50113Str);
				vf501.setF50114(f50114);
				vf501.setF50114Zh(f50114Zh);
				vf501.setF50115(f50115);
				vf501.setF50116(f50116);
				vf501.setF50117(f50117);
				vf501.setF50117Str(f50117Str);
				vf501.setF50118(f50118);
				vf501.setF50119(f50119);
				vf501.setF50119Zh(f50119Zh);
				vf501.setF50120(f50120);
				vf501.setF50120Zh(f50120Zh);
				vf501.setF50121(f50121);
				vf501.setF50122(f50122);
				vf501.setF50123(f50123);
				vf501.setF50124(f50124);
				vf501.setF50125(f50125);
				vf501.setF50125Str(f50125Str);
				vf501.setF50126(f50126);
				vf501.setF50126Zh(f50126Zh);
				vf501.setF50127(f50127);
				vf501.setF50128(f50128);
				vf501.setF50128Str(f50128Str);
				vf501.setF50129(f50129);
				vf501.setF50130(f50130);
				vf501.setF50131(f50131);
				vf501.setF50132(f50132);
				vf501.setF50133(f50133);
				vf501.setF50134(f50134);
				vf501.setF50135(f50135);
				vf501.setF50136(f50136);
				vf501.setF50137(f50137);
				vf501.setF50138(f50138);
				vf501.setF50139(f50139);
				vf501.setF50140(f50140);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, pStatement, resultSet);
		}
		return vf501;
	}
	public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
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
