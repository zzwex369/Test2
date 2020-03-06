package com.xyw.medical.birth.report.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.birth.model.VD301;
import com.xyw.medical.birth.report.model.VD301S;
import com.xyw.medical.birth.report.model.VD301T;

public class PrintBirthInfoService {
	
	private DataSource dataSource;

	public VD301 queryD301(String d301_10, ServletContext servletContext) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		VD301 vd301 = null;
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement("select t.* from V_D301 t where t.D301_10 = ?");
			preparedStatement.setString(1, d301_10);
			resultSet = preparedStatement.executeQuery();
			vd301 = new VD301();
			if(resultSet.next()) {
				long d30101 = resultSet.getLong("d301_01");
				String d30102 = resultSet.getString("d301_02");
				String d30103 = resultSet.getString("d301_03");
				String d30103Zh = resultSet.getString("d301_03_ZH");
				String d30104= resultSet.getString("d301_04");
				String d30105 = resultSet.getString("d301_05");
				String d30106 = resultSet.getString("d301_06");
				int d30107 = resultSet.getInt("d301_07");
				double d30108 = resultSet.getDouble("d301_08");
				String d30109 = resultSet.getString("d301_09");
				String d30109Zh = resultSet.getString("d301_09_ZH");
				String d30110 = resultSet.getString("d301_10");
				String d30111 = resultSet.getString("d301_11");
				String d30112 = resultSet.getString("d301_12");
				String d30113String = resultSet.getString("d301_13");
				String d30113 = "";
				if(d30113String != null && !"".equals(d30113String))
				{
					String d30113Year = d30113String.substring(0, 4);
					d30113 = String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(d30113Year));
				}
				String d30114 = resultSet.getString("d301_14");
				String d30114Zh = resultSet.getString("d301_14_ZH");
				String d30115 = resultSet.getString("d301_15");
				String d30115Zh = resultSet.getString("d301_15_ZH");
				String d30116 = resultSet.getString("d301_16");
				String d30117 = resultSet.getString("d301_17");
				String d30118String = resultSet.getString("d301_18");
				String d30118 = "";
				if(d30118String != null && !"".equals(d30118String))
				{
					String d30118Year = d30118String.substring(0, 4);
					d30118 = String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(d30118Year));
				}
				String d30119 = resultSet.getString("d301_19");
				String d30119Zh = resultSet.getString("d301_19_ZH");
				String d30120 = resultSet.getString("d301_20");
				String d30120Zh = resultSet.getString("d301_20_ZH");
				String d30121 = resultSet.getString("d301_21");
				String d30122Zh = resultSet.getString("d301_22_ZH");
				String d30122 = resultSet.getString("d301_22");
				String d30123 = resultSet.getString("d301_23");
				String d30124 = resultSet.getString("d301_24");
				String d30124Zh = resultSet.getString("d301_24_ZH");
				String d30125 = resultSet.getString("d301_25");
				String d30126 = resultSet.getString("d301_26");
				String d30126Zh = resultSet.getString("d301_26_ZH");
				String d30127 = resultSet.getString("d301_27");
				String d30128 = resultSet.getString("d301_28");
				double d30129 = resultSet.getDouble("d301_29");
				String d30130 = resultSet.getString("d301_30");
				String d30130Zh = resultSet.getString("d301_30_ZH");
				String d30131 = resultSet.getString("d301_31");
				
				String d30132 = resultSet.getString("d301_32");
				String d30133 = resultSet.getString("d301_33");
				String d30134 = resultSet.getString("d301_34");
				String d30135 = resultSet.getString("d301_35");
				String d30136 = resultSet.getString("d301_36");
				String d30137 = resultSet.getString("d301_37");
				String d30138 = resultSet.getString("d301_38");
				String d30139 = resultSet.getString("d301_39");
				String d30140 = resultSet.getString("d301_40");
				String d30141 = resultSet.getString("d301_41");
				String d30142 = resultSet.getString("d301_42");
				String d30143 = resultSet.getString("d301_43");
				String d30144 = resultSet.getString("d301_44");
				String d30145 = resultSet.getString("d301_45");
				String d30146 = resultSet.getString("d301_46");
				String d30147 = resultSet.getString("d301_47");
				String d30148 = resultSet.getString("d301_48");
				String d30149 = resultSet.getString("d301_49");
				String d30150 = resultSet.getString("d301_50");
				String d30151 = resultSet.getString("d301_51");
				String d30152 = resultSet.getString("d301_52");
				String d30153 = resultSet.getString("d301_53");
				String d30154 = resultSet.getString("d301_54");
				String d30155 = resultSet.getString("d301_55");
				long d30156 = resultSet.getLong("d301_56");
				long d30157 = resultSet.getLong("d301_57");
				String d30158 = resultSet.getString("d301_58");
				String d30159 = resultSet.getString("d301_59");
				String d30160 = resultSet.getString("d301_60");
				String d30161 = resultSet.getString("d301_61");
				String d30162 = resultSet.getString("d301_62");
				String d30163 = resultSet.getString("d301_63");
				String d30164 = resultSet.getString("d301_64");
				String d30165 = resultSet.getString("d301_65");
				String d30166 = resultSet.getString("d301_66");
				String d30167 = resultSet.getString("d301_67");
				String d30168 = resultSet.getString("d301_68");
				String d30169 = resultSet.getString("d301_69");
				String d30170 = resultSet.getString("d301_70");
				
				vd301.setD30101(d30101);
				vd301.setD30102(d30102);
				vd301.setD30103(d30103);
				vd301.setD30103Zh(d30103Zh);
				vd301.setD30104(d30104);
				vd301.setD30105(d30105);
				vd301.setD30106(d30106);
				vd301.setD30107(d30107);
				vd301.setD30108(d30108);
				vd301.setD30109(d30109);
				vd301.setD30109Zh(d30109Zh);
				vd301.setD30110(d30110);
				vd301.setD30111(d30111);
				vd301.setD30112(d30112);
				vd301.setD30113(d30113);
				vd301.setD30114(d30114);
				vd301.setD30114Zh(d30114Zh);
				vd301.setD30115(d30115);
				vd301.setD30115Zh(d30115Zh);
				vd301.setD30116(d30116);
				vd301.setD30117(d30117);
				vd301.setD30118(d30118);
				vd301.setD30119(d30119);
				vd301.setD30119Zh(d30119Zh);
				vd301.setD30120(d30120);
				vd301.setD30120Zh(d30120Zh);
				vd301.setD30121(d30121);
				vd301.setD30122(d30122);
				vd301.setD30122Zh(d30122Zh);
				vd301.setD30123(d30123);
				vd301.setD30124(d30124);
				vd301.setD30124Zh(d30124Zh);
				vd301.setD30125(d30125);
				vd301.setD30126(d30126);
				vd301.setD30126Zh(d30126Zh);
				vd301.setD30127(d30127);
				vd301.setD30128(d30128);
				vd301.setD30129(d30129);
				vd301.setD30130(d30130);
				vd301.setD30130Zh(d30130Zh);
				vd301.setD30131(d30131);
				vd301.setD30132(d30132);
				vd301.setD30133(d30133);
				vd301.setD30134(d30134);
				vd301.setD30135(d30135);
				vd301.setD30136(d30136);
				
				vd301.setD30137(d30137);
				vd301.setD30138(d30138);
				vd301.setD30139(d30139);
				vd301.setD30140(d30140);
				vd301.setD30141(d30141);
				vd301.setD30142(d30142);
				vd301.setD30143(d30143);
				vd301.setD30144(d30144);
				vd301.setD30145(d30145);
				vd301.setD30146(d30146);
				vd301.setD30147(d30147);
				vd301.setD30148(d30148);
				vd301.setD30149(d30149);
				vd301.setD30150(d30150);
				vd301.setD30151(d30151);
				vd301.setD30152(d30152);
				vd301.setD30153(d30153);
				vd301.setD30154(d30154);
				vd301.setD30155(d30155);
				vd301.setD30156(d30156);
				vd301.setD30157(d30157);
				vd301.setD30158(d30158);
				vd301.setD30159(d30159);
				vd301.setD30160(d30160);
				vd301.setD30161(d30161);
				vd301.setD30162(d30162);
				vd301.setD30163(d30163);
				vd301.setD30164(d30164);
				vd301.setD30165(d30165);
				vd301.setD30166(d30166);
				vd301.setD30167(d30167);
				vd301.setD30168(d30168);
				vd301.setD30169(d30169);
				vd301.setD30170(d30170);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, resultSet);
		}
		return vd301;
	}
	
	
	public VD301S queryD301S(String d301S_10, ServletContext servletContext) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		VD301S vd301S = null;
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement("select t.* from V_D301 t where t.D301_10 = ?");
			preparedStatement.setString(1, d301S_10);
			resultSet = preparedStatement.executeQuery();
			vd301S = new VD301S();
			if(resultSet.next()) {
				long d30101S = resultSet.getLong("d301_01");
				String d30102S = resultSet.getString("d301_02");
				String d30103S = resultSet.getString("d301_03");
				String d30103ZhS = resultSet.getString("d301_03_ZH");
				String d30104S = resultSet.getString("d301_04");
				String d30105S = resultSet.getString("d301_05");
				String d30105ZhS= resultSet.getString("d301_05_ZH");
				String d30106S = resultSet.getString("d301_06");
				int d30107S = resultSet.getInt("d301_07");
				double d30108S = resultSet.getDouble("d301_08");
				String d30109S = resultSet.getString("d301_09");
				String d30109ZhS = resultSet.getString("d301_09_ZH");
				String d30110S = resultSet.getString("d301_10");
				String d30111S = resultSet.getString("d301_11");
				String d30112S = resultSet.getString("d301_12");
				String d30113String = resultSet.getString("d301_13");
				String d30113S = "";
				if(d30113String != null && !"".equals(d30113String))
				{
					String d30113Year = d30113String.substring(0, 4);
					d30113S = String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(d30113Year));
				}
				String d30114S = resultSet.getString("d301_14");
				String d30114ZhS = resultSet.getString("d301_14_ZH");
				String d30115S = resultSet.getString("d301_15");
				String d30115ZhS = resultSet.getString("d301_15_ZH");
				String d30116S = resultSet.getString("d301_16");
				String d30117S = resultSet.getString("d301_17");
				String d30118String = resultSet.getString("d301_18");
				String d30118S = "";
				if(d30118String != null && !"".equals(d30118String))
				{
					String d30118Year = d30118String.substring(0, 4);
					d30118S = String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(d30118Year));
				}
				String d30119S = resultSet.getString("d301_19");
				String d30119ZhS = resultSet.getString("d301_19_ZH");
				String d30120S= resultSet.getString("d301_20");
				String d30120ZhS = resultSet.getString("d301_20_ZH");
				String d30121S = resultSet.getString("d301_21");
				String d30122ZhS = resultSet.getString("d301_22_ZH");
				String d30122S = resultSet.getString("d301_22");
				String d30123S = resultSet.getString("d301_23");
				String d30124S = resultSet.getString("d301_24");
				String d30124ZhS = resultSet.getString("d301_24_ZH");
				String d30125S = resultSet.getString("d301_25");
				String d30126S = resultSet.getString("d301_26");
				String d30126ZhS = resultSet.getString("d301_26_ZH");
				String d30127S = resultSet.getString("d301_27");
				String d30128S = resultSet.getString("d301_28");
				double d30129S = resultSet.getDouble("d301_29");
				String d30130S = resultSet.getString("d301_30");
				String d30130ZhS = resultSet.getString("d301_30_ZH");
				String d30131S = resultSet.getString("d301_31");
				
				String d30132S = resultSet.getString("d301_32");
				String d30133S = resultSet.getString("d301_33");
				String d30134S = resultSet.getString("d301_34");
				String d30135S = resultSet.getString("d301_35");
				String d30136S = resultSet.getString("d301_36");
				String d30137S = resultSet.getString("d301_37");
				String d30138S = resultSet.getString("d301_38");
				String d30139S = resultSet.getString("d301_39");
				String d30140S = resultSet.getString("d301_40");
				String d30141S = resultSet.getString("d301_41");
				String d30142S = resultSet.getString("d301_42");
				String d30143S = resultSet.getString("d301_43");
				String d30144S = resultSet.getString("d301_44");
				String d30145S = resultSet.getString("d301_45");
				String d30146S = resultSet.getString("d301_46");
				String d30147S = resultSet.getString("d301_47");
				String d30148S = resultSet.getString("d301_48");
				String d30149S = resultSet.getString("d301_49");
				String d30150S = resultSet.getString("d301_50");
				String d30151S = resultSet.getString("d301_51");
				String d30152S = resultSet.getString("d301_52");
				String d30153S = resultSet.getString("d301_53");
				String d30154S = resultSet.getString("d301_54");
				String d30155S = resultSet.getString("d301_55");
				String d30156S = resultSet.getString("d301_56");
				String d30157S = resultSet.getString("d301_57");
				String d30158S = resultSet.getString("d301_58");
				String d30159S = resultSet.getString("d301_59");
				String d30160S = resultSet.getString("d301_60");
				String d30161S = resultSet.getString("d301_61");
				String d30162S = resultSet.getString("d301_62");
				String d30163S = resultSet.getString("d301_63");
				String d30164S = resultSet.getString("d301_64");
				String d30165S = resultSet.getString("d301_65");
				String d30166S = resultSet.getString("d301_66");
				String d30167S = resultSet.getString("d301_67");
				String d30168S = resultSet.getString("d301_68");
				String d30169S = resultSet.getString("d301_69");
				String d30170S = resultSet.getString("d301_70");
				
				vd301S.setD30101S(d30101S);
				vd301S.setD30102S(d30102S);
				vd301S.setD30103S(d30103S);
				vd301S.setD30103ZhS(d30103ZhS);
				vd301S.setD30104S(d30104S);
				vd301S.setD30105S(d30105S);
				vd301S.setD30105ZhS(d30105ZhS);
				vd301S.setD30106S(d30106S);
				vd301S.setD30107S(d30107S);
				vd301S.setD30108S(d30108S);
				vd301S.setD30109S(d30109S);
				vd301S.setD30109ZhS(d30109ZhS);
				vd301S.setD30110S(d30110S);
				vd301S.setD30111S(d30111S);
				vd301S.setD30112S(d30112S);
				vd301S.setD30113S(d30113S);
				vd301S.setD30114S(d30114S);
				vd301S.setD30114ZhS(d30114ZhS);
				vd301S.setD30115S(d30115S);
				vd301S.setD30115ZhS(d30115ZhS);
				vd301S.setD30116S(d30116S);
				vd301S.setD30117S(d30117S);
				vd301S.setD30118S(d30118S);
				vd301S.setD30119S(d30119S);
				vd301S.setD30119ZhS(d30119ZhS);
				vd301S.setD30120S(d30120S);
				vd301S.setD30120ZhS(d30120ZhS);
				vd301S.setD30121S(d30121S);
				vd301S.setD30122S(d30122S);
				vd301S.setD30122ZhS(d30122ZhS);
				vd301S.setD30123S(d30123S);
				vd301S.setD30124S(d30124S);
				vd301S.setD30124ZhS(d30124ZhS);
				vd301S.setD30125S(d30125S);
				vd301S.setD30126S(d30126S);
				vd301S.setD30126ZhS(d30126ZhS);
				vd301S.setD30127S(d30127S);
				vd301S.setD30128S(d30128S);
				vd301S.setD30129S(d30129S);
				vd301S.setD30130S(d30130S);
				vd301S.setD30130ZhS(d30130ZhS);
				vd301S.setD30131S(d30131S);
				vd301S.setD30132S(d30132S);
				vd301S.setD30133S(d30133S);
				vd301S.setD30134S(d30134S);
				vd301S.setD30135S(d30135S);
				vd301S.setD30136S(d30136S);
				
				vd301S.setD30137S(d30137S);
				vd301S.setD30138S(d30138S);
				vd301S.setD30139S(d30139S);
				vd301S.setD30140S(d30140S);
				vd301S.setD30141S(d30141S);
				vd301S.setD30142S(d30142S);
				vd301S.setD30143S(d30143S);
				vd301S.setD30144S(d30144S);
				vd301S.setD30145S(d30145S);
				vd301S.setD30146S(d30146S);
				vd301S.setD30147S(d30147S);
				vd301S.setD30148S(d30148S);
				vd301S.setD30149S(d30149S);
				vd301S.setD30150S(d30150S);
				vd301S.setD30151S(d30151S);
				vd301S.setD30152S(d30152S);
				vd301S.setD30153S(d30153S);
				vd301S.setD30154S(d30154S);
				vd301S.setD30155S(d30155S);
				vd301S.setD30156S(d30156S);
				vd301S.setD30157S(d30157S);
				vd301S.setD30158S(d30158S);
				vd301S.setD30159S(d30159S);
				vd301S.setD30160S(d30160S);
				vd301S.setD30161S(d30161S);
				vd301S.setD30162S(d30162S);
				vd301S.setD30163S(d30163S);
				vd301S.setD30164S(d30164S);
				vd301S.setD30165S(d30165S);
				vd301S.setD30166S(d30166S);
				vd301S.setD30167S(d30167S);
				vd301S.setD30168S(d30168S);
				vd301S.setD30169S(d30169S);
				vd301S.setD30170S(d30170S);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, resultSet);
		}
		return vd301S;
	}
	
	
	public VD301T queryD301T(String d301_10, ServletContext servletContext) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		VD301T vd301T = null;
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement("select t.* from V_D301 t where t.D301_10 = ?");
			preparedStatement.setString(1, d301_10);
			resultSet = preparedStatement.executeQuery();
			vd301T = new VD301T();
			if(resultSet.next()) {
				long d30101T = resultSet.getLong("d301_01");
				String d30102T = resultSet.getString("d301_02");
				String d30103T = resultSet.getString("d301_03");
				String d30103ZhT = resultSet.getString("d301_03_ZH");
				String d30104T= resultSet.getString("d301_04");
				String d30105T = resultSet.getString("d301_05");
				String d30105ZhT = resultSet.getString("d301_05_ZH");
				String d30106T = resultSet.getString("d301_06");
				int d30107T = resultSet.getInt("d301_07");
				double d30108T = resultSet.getDouble("d301_08");
				String d30109T = resultSet.getString("d301_09");
				String d30109ZhT = resultSet.getString("d301_09_ZH");
				String d30110T = resultSet.getString("d301_10");
				String d30111T = resultSet.getString("d301_11");
				String d30112T = resultSet.getString("d301_12");
				String d30113String = resultSet.getString("d301_13");
				String d30113T = "";
				if(d30113String != null && !"".equals(d30113String))
				{
					String d30113Year = d30113String.substring(0, 4);
					d30113T = String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(d30113Year));
				}
				String d30114T = resultSet.getString("d301_14");
				String d30114ZhT = resultSet.getString("d301_14_ZH");
				String d30115T = resultSet.getString("d301_15");
				String d30115ZhT = resultSet.getString("d301_15_ZH");
				String d30116T = resultSet.getString("d301_16");
				String d30117T = resultSet.getString("d301_17");
				String d30118String = resultSet.getString("d301_18");
				String d30118T = "";
				if(d30118String != null && !"".equals(d30118String))
				{
					String d30118Year = d30118String.substring(0, 4);
					d30118T = String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(d30118Year));
				}
				String d30119T = resultSet.getString("d301_19");
				String d30119ZhT = resultSet.getString("d301_19_ZH");
				String d30120T = resultSet.getString("d301_20");
				String d30120ZhT = resultSet.getString("d301_20_ZH");
				String d30121T = resultSet.getString("d301_21");
				String d30122ZhT = resultSet.getString("d301_22_ZH");
				String d30122T = resultSet.getString("d301_22");
				String d30123T = resultSet.getString("d301_23");
				String d30124T = resultSet.getString("d301_24");
				String d30124ZhT = resultSet.getString("d301_24_ZH");
				String d30125T = resultSet.getString("d301_25");
				String d30126T = resultSet.getString("d301_26");
				String d30126ZhT = resultSet.getString("d301_26_ZH");
				String d30127T = resultSet.getString("d301_27");
				String d30128T = resultSet.getString("d301_28");
				double d30129T = resultSet.getDouble("d301_29");
				String d30130T = resultSet.getString("d301_30");
				String d30130ZhT = resultSet.getString("d301_30_ZH");
				String d30131T = resultSet.getString("d301_31");
				
				String d30132T = resultSet.getString("d301_32");
				String d30133T = resultSet.getString("d301_33");
				String d30134T = resultSet.getString("d301_34");
				String d30135T = resultSet.getString("d301_35");
				String d30136T = resultSet.getString("d301_36");
				String d30137T = resultSet.getString("d301_37");
				String d30138T = resultSet.getString("d301_38");
				String d30139T = resultSet.getString("d301_39");
				String d30140T = resultSet.getString("d301_40");
				String d30141T = resultSet.getString("d301_41");
				String d30142T = resultSet.getString("d301_42");
				String d30143T = resultSet.getString("d301_43");
				String d30144T = resultSet.getString("d301_44");
				String d30145T = resultSet.getString("d301_45");
				String d30146T = resultSet.getString("d301_46");
				String d30147T = resultSet.getString("d301_47");
				String d30148T = resultSet.getString("d301_48");
				String d30149T = resultSet.getString("d301_49");
				String d30150T = resultSet.getString("d301_50");
				String d30151T = resultSet.getString("d301_51");
				String d30152T = resultSet.getString("d301_52");
				String d30153T = resultSet.getString("d301_53");
				String d30154T = resultSet.getString("d301_54");
				String d30155T = resultSet.getString("d301_55");
				String d30156T = resultSet.getString("d301_56");
				String d30157T = resultSet.getString("d301_57");
				String d30158T = resultSet.getString("d301_58");
				String d30159T = resultSet.getString("d301_59");
				String d30160T = resultSet.getString("d301_60");
				String d30161T = resultSet.getString("d301_61");
				String d30162T = resultSet.getString("d301_62");
				String d30163T = resultSet.getString("d301_63");
				String d30164T = resultSet.getString("d301_64");
				String d30165T = resultSet.getString("d301_65");
				String d30166T = resultSet.getString("d301_66");
				String d30167T = resultSet.getString("d301_67");
				String d30168T = resultSet.getString("d301_68");
				String d30169T = resultSet.getString("d301_69");
				String d30170T = resultSet.getString("d301_70");
				
				vd301T.setD30101T(d30101T);
				vd301T.setD30102T(d30102T);
				vd301T.setD30103T(d30103T);
				vd301T.setD30103ZhT(d30103ZhT);
				vd301T.setD30104T(d30104T);
				vd301T.setD30105T(d30105T);
				vd301T.setD30105ZhT(d30105ZhT);
				vd301T.setD30106T(d30106T);
				vd301T.setD30107T(d30107T);
				vd301T.setD30108T(d30108T);
				vd301T.setD30109T(d30109T);
				vd301T.setD30109ZhT(d30109ZhT);
				vd301T.setD30110T(d30110T);
				vd301T.setD30111T(d30111T);
				vd301T.setD30112T(d30112T);
				vd301T.setD30113T(d30113T);
				vd301T.setD30114T(d30114T);
				vd301T.setD30114ZhT(d30114ZhT);
				vd301T.setD30115T(d30115T);
				vd301T.setD30115ZhT(d30115ZhT);
				vd301T.setD30116T(d30116T);
				vd301T.setD30117T(d30117T);
				vd301T.setD30118T(d30118T);
				vd301T.setD30119T(d30119T);
				vd301T.setD30119ZhT(d30119ZhT);
				vd301T.setD30120T(d30120T);
				vd301T.setD30120ZhT(d30120ZhT);
				vd301T.setD30121T(d30121T);
				vd301T.setD30122T(d30122T);
				vd301T.setD30122ZhT(d30122ZhT);
				vd301T.setD30123T(d30123T);
				vd301T.setD30124T(d30124T);
				vd301T.setD30124ZhT(d30124ZhT);
				vd301T.setD30125T(d30125T);
				vd301T.setD30126T(d30126T);
				vd301T.setD30126ZhT(d30126ZhT);
				vd301T.setD30127T(d30127T);
				vd301T.setD30128T(d30128T);
				vd301T.setD30129T(d30129T);
				vd301T.setD30130T(d30130T);
				vd301T.setD30130ZhT(d30130ZhT);
				vd301T.setD30131T(d30131T);
				vd301T.setD30132T(d30132T);
				vd301T.setD30133T(d30133T);
				vd301T.setD30134T(d30134T);
				vd301T.setD30135T(d30135T);
				vd301T.setD30136T(d30136T);
				
				vd301T.setD30137T(d30137T);
				vd301T.setD30138T(d30138T);
				vd301T.setD30139T(d30139T);
				vd301T.setD30140T(d30140T);
				vd301T.setD30141T(d30141T);
				vd301T.setD30142T(d30142T);
				vd301T.setD30143T(d30143T);
				vd301T.setD30144T(d30144T);
				vd301T.setD30145T(d30145T);
				vd301T.setD30146T(d30146T);
				vd301T.setD30147T(d30147T);
				vd301T.setD30148T(d30148T);
				vd301T.setD30149T(d30149T);
				vd301T.setD30150T(d30150T);
				vd301T.setD30151T(d30151T);
				vd301T.setD30152T(d30152T);
				vd301T.setD30153T(d30153T);
				vd301T.setD30154T(d30154T);
				vd301T.setD30155T(d30155T);
				vd301T.setD30156T(d30156T);
				vd301T.setD30157T(d30157T);
				vd301T.setD30158T(d30158T);
				vd301T.setD30159T(d30159T);
				vd301T.setD30160T(d30160T);
				vd301T.setD30161T(d30161T);
				vd301T.setD30162T(d30162T);
				vd301T.setD30163T(d30163T);
				vd301T.setD30164T(d30164T);
				vd301T.setD30165T(d30165T);
				vd301T.setD30166T(d30166T);
				vd301T.setD30167T(d30167T);
				vd301T.setD30168T(d30168T);
				vd301T.setD30169T(d30169T);
				vd301T.setD30170T(d30170T);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, resultSet);
		}
		return vd301T;
	}
	
	
	public List<String> getAreaName(String areaCode, ServletContext servletContext) {
		
		List<String> listAreaName = new ArrayList<String>();
		String priviceCode = areaCode.substring(0, 2);
		String cityCode = areaCode.substring(0, 4);
		String countyCode = areaCode.substring(0, 6);
		String townCode = areaCode.substring(0, 9);
		
		List<String> strs = new ArrayList<String>();
		strs.add(priviceCode);
		strs.add(cityCode);
		strs.add(countyCode);
		strs.add(townCode);
		
		
		
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			String sql = "select t.D201_04 from D201 t where t.D201_01 = ?";
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			for(int i = 0; i < strs.size(); i++) {
				preparedStatement.setString(1, strs.get(i));
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					String d201_04 = resultSet.getString("D201_04");
					listAreaName.add(d201_04);
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, resultSet);
		}
		return listAreaName;
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
