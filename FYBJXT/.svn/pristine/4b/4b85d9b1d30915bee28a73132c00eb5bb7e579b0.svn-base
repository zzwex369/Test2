package com.xyw.medical.birth.report.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.birth.report.model.VD302;

public class PrintBirthInfoHfServiceNew {
	
	private DataSource dataSource;

	public VD302 queryD302(String d302_10, ServletContext servletContext) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		VD302 vd302 = null;
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement("select t.* from V_D302 t where t.D302_10 = ?");
			preparedStatement.setString(1, d302_10);
			resultSet = preparedStatement.executeQuery();
			SimpleDateFormat simpleDateFormatFull = null;
			SimpleDateFormat simpleDateFormatShort = null;
			SimpleDateFormat simpleDateFormatYear = null;
			vd302 = new VD302();
			if(resultSet.next()) {
				simpleDateFormatFull = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				simpleDateFormatShort = new SimpleDateFormat("yyyy-MM-dd");
				simpleDateFormatYear = new SimpleDateFormat("yyyy");
				long d30201 = resultSet.getLong("d302_01");
				String d30202 = resultSet.getString("d302_02");
				String d30203 = resultSet.getString("d302_03");
				String d30203Zh = resultSet.getString("d302_03_ZH");
				Timestamp d30204Time = resultSet.getTimestamp("d302_04");
				Calendar cal = Calendar.getInstance();
				cal.setTime(d30204Time);
				int d30204Year = cal.get(Calendar.YEAR);
				String d30204 = "";
				if(d30204Time != null)
				{
					d30204 = simpleDateFormatFull.format(d30204Time);
				}
				String d30205 = resultSet.getString("d302_05");
				String d30206 = resultSet.getString("d302_06");
				int d30207 = resultSet.getInt("d302_07");
				double d30208 = resultSet.getDouble("d302_08");
				String d30209 = resultSet.getString("d302_09");
				String d30209Zh = resultSet.getString("d302_09_ZH");
				String d30210 = resultSet.getString("d302_10");
				String d30211 = resultSet.getString("d302_11");
				String d30212 = resultSet.getString("d302_12");
				Date d30213Date = resultSet.getDate("d302_13");
				String d30213 = "";
				if(d30213Date != null)
				{
					String d30213Year = simpleDateFormatYear.format(d30213Date);
					d30213 = String.valueOf(d30204Year - Integer.parseInt(d30213Year));
				}
				String d30214 = resultSet.getString("d302_14");
				String d30214Zh = resultSet.getString("d302_14_ZH");
				String d30215 = resultSet.getString("d302_15");
				String d30215Zh = resultSet.getString("d302_15_ZH");
				String d30216 = resultSet.getString("d302_16");
				String d30217 = resultSet.getString("d302_17");
				Date d30218Date = resultSet.getDate("d302_18");
				String d30218 = "";
				if(d30218Date != null)
				{
					String d30218Year = simpleDateFormatYear.format(d30218Date);
					d30218 = String.valueOf(d30204Year - Integer.parseInt(d30218Year));
				}
				String d30219 = resultSet.getString("d302_19");
				String d30219Zh = resultSet.getString("d302_19_ZH");
				String d30220 = resultSet.getString("d302_20");
				String d30220Zh = resultSet.getString("d302_20_ZH");
				String d30221 = resultSet.getString("d302_21");
//				String d30221Zh = resultSet.getString("d302_21_ZH");
				String d30222Zh = resultSet.getString("d302_22_ZH");
				String d30222 = resultSet.getString("d302_22");
				String d30223 = resultSet.getString("d302_23");
				String d30224 = resultSet.getString("d302_24");
				String d30224Zh = resultSet.getString("d302_24_ZH");
				String d30225 = resultSet.getString("d302_25");
				String d30226 = resultSet.getString("d302_26");
				String d30226Zh = resultSet.getString("d302_26_ZH");
				String d30227 = resultSet.getString("d302_27");
				Date d30228Date = resultSet.getDate("d302_28");
				String d30228 = "";
				if(d30228Date != null)
				{
					d30228 = simpleDateFormatShort.format(d30228Date);
				}
				double d30229 = resultSet.getDouble("d302_29");
				String d30230 = resultSet.getString("d302_30");
				String d30231 = resultSet.getString("d302_31");
				
				String d30232 = resultSet.getString("d302_32");
				String d30233 = resultSet.getString("d302_33");
				String d30233Zh = resultSet.getString("d302_33_ZH");
				String d30234 = resultSet.getString("d302_34");
				String d30235 = resultSet.getString("d302_35");
				String d30236 = resultSet.getString("d302_36");
				String d30237 = resultSet.getString("d302_37");
				String d30238 = resultSet.getString("d302_38");
				String d30239 = resultSet.getString("d302_39");
				String d30240 = resultSet.getString("d302_40");
				String d30241 = resultSet.getString("d302_41");
				String d30242 = resultSet.getString("d302_42");
				String d30243 = resultSet.getString("d302_43");
				String d30244 = resultSet.getString("d302_44");
				String d30245 = resultSet.getString("d302_45");
				String d30246 = resultSet.getString("d302_46");
				String d30247 = resultSet.getString("d302_47");
				String d30248 = resultSet.getString("d302_48");
				String d30249 = resultSet.getString("d302_49");
				String d30250 = resultSet.getString("d302_50");
				String d30251 = resultSet.getString("d302_51");
				String d30252 = resultSet.getString("d302_52");
//				String d30252Zh = resultSet.getString("d302_52_ZH");
				String d30253 = resultSet.getString("d302_53");
				String d30254 = resultSet.getString("d302_54");
				String d30255 = resultSet.getString("d302_55");
				String d30256 = resultSet.getString("d302_56");
				String d30257 = resultSet.getString("d302_57");
				String d30258 = resultSet.getString("d302_58");
				String d30259 = resultSet.getString("d302_59");
				String d30260 = resultSet.getString("d302_60");
				String d30261 = resultSet.getString("d302_61");
				String d30262 = resultSet.getString("d302_62");
				String d30263 = resultSet.getString("d302_63");
				String d30264 = resultSet.getString("d302_64");
				String d30265 = resultSet.getString("d302_65");
				String d30266 = resultSet.getString("d302_66");
				String d30267 = resultSet.getString("d302_67");
				String d30268 = resultSet.getString("d302_68");
				String d30269 = resultSet.getString("d302_69");
				String d30270 = resultSet.getString("d302_70");
				
				vd302.setD30201(d30201);
				vd302.setD30202(d30202);
				vd302.setD30203(d30203);
				vd302.setD30203Zh(d30203Zh);
				vd302.setD30204(d30204);
				vd302.setD30205(d30205);
				vd302.setD30206(d30206);
				vd302.setD30207(d30207);
				vd302.setD30208(d30208);
				vd302.setD30209(d30209);
				vd302.setD30209Zh(d30209Zh);
				vd302.setD30210(d30210);
				vd302.setD30211(d30211);
				vd302.setD30212(d30212);
				vd302.setD30213(d30213);
				vd302.setD30214(d30214);
				vd302.setD30214Zh(d30214Zh);
				vd302.setD30215(d30215);
				vd302.setD30215Zh(d30215Zh);
				vd302.setD30216(d30216);
				vd302.setD30217(d30217);
				vd302.setD30218(d30218);
				vd302.setD30219(d30219);
				vd302.setD30219Zh(d30219Zh);
				vd302.setD30220(d30220);
				vd302.setD30220Zh(d30220Zh);
				vd302.setD30221(d30221);
//				if(d30248 == null) {
//					vd302.setD30221Zh(d30221Zh);
//				} else {
//					vd302.setD30221Zh(d30221Zh + d30248);
//				}
				vd302.setD30222(d30222);
				vd302.setD30222Zh(d30222Zh);
				vd302.setD30223(d30223);
				vd302.setD30224(d30224);
				vd302.setD30224Zh(d30224Zh);
				vd302.setD30225(d30225);
				vd302.setD30226(d30226);
				vd302.setD30226Zh(d30226Zh);
				vd302.setD30227(d30227);
				vd302.setD30228(d30228);
				vd302.setD30229(d30229);
				vd302.setD30230(d30230);
				vd302.setD30231(d30231);
				vd302.setD30232(d30232);
				vd302.setD30233(d30233);
				vd302.setD30233Zh(d30233Zh);
				vd302.setD30234(d30234);
				vd302.setD30235(d30235);
				vd302.setD30236(d30236);
				
				vd302.setD30237(d30237);
				vd302.setD30238(d30238);
				vd302.setD30239(d30239);
				vd302.setD30240(d30240);
				vd302.setD30241(d30241);
				vd302.setD30242(d30242);
				vd302.setD30243(d30243);
				vd302.setD30244(d30244);
				vd302.setD30245(d30245);
				vd302.setD30246(d30246);
				vd302.setD30247(d30247);
				vd302.setD30248(d30248);
				vd302.setD30249(d30249);
				vd302.setD30250(d30250);
				vd302.setD30251(d30251);
				vd302.setD30252(d30252);
//				if(d30253 == null)
//				{
//					vd302.setD30252Zh(d30252Zh);
//				}else
//				{
//					vd302.setD30252Zh(d30252Zh + d30253);
//				}
				vd302.setD30253(d30253);
				vd302.setD30254(d30254);
				vd302.setD30255(d30255);
				vd302.setD30256(d30256);
				vd302.setD30257(d30257);
				vd302.setD30258(d30258);
				vd302.setD30259(d30259);
				vd302.setD30260(d30260);
				vd302.setD30261(d30261);
				vd302.setD30262(d30262);
				vd302.setD30263(d30263);
				vd302.setD30264(d30264);
				vd302.setD30265(d30265);
				vd302.setD30266(d30266);
				vd302.setD30267(d30267);
				vd302.setD30268(d30268);
				vd302.setD30269(d30269);
				vd302.setD30270(d30270);
				
				long d30201S = resultSet.getLong("d302_01");
				String d30202S = resultSet.getString("d302_02");
				String d30203S = resultSet.getString("d302_03");
				String d30203ZhS = resultSet.getString("d302_03_ZH");
				String d30204S = "";
				
				if(d30204Time != null)
				{
					d30204S = simpleDateFormatFull.format(d30204Time);
				}
				String d30205S = resultSet.getString("d302_05");
				String d30205ZhS= resultSet.getString("d302_05_ZH");
				String d30206S = resultSet.getString("d302_06");
				int d30207S = resultSet.getInt("d302_07");
				double d30208S = resultSet.getDouble("d302_08");
				String d30209S = resultSet.getString("d302_09");
				String d30209ZhS = resultSet.getString("d302_09_ZH");
				String d30210S = resultSet.getString("d302_10");
				String d30211S = resultSet.getString("d302_11");
				String d30212S = resultSet.getString("d302_12");
				String d30213S = "";
				if(d30213Date != null)
				{
					String d30213Year = simpleDateFormatYear.format(d30213Date);
					d30213S = String.valueOf(d30204Year - Integer.parseInt(d30213Year));
				}
				String d30214S = resultSet.getString("d302_14");
				String d30214ZhS = resultSet.getString("d302_14_ZH");
				String d30215S = resultSet.getString("d302_15");
				String d30215ZhS = resultSet.getString("d302_15_ZH");
				String d30216S = resultSet.getString("d302_16");
				String d30217S = resultSet.getString("d302_17");
				String d30218S = "";
				if(d30218Date != null)
				{
					String d30218Year = simpleDateFormatYear.format(d30218Date);
					d30218S = String.valueOf(d30204Year - Integer.parseInt(d30218Year));
				}
				String d30219S = resultSet.getString("d302_19");
				String d30219ZhS = resultSet.getString("d302_19_ZH");
				String d30220S= resultSet.getString("d302_20");
				String d30220ZhS = resultSet.getString("d302_20_ZH");
				String d30221S = resultSet.getString("d302_21");
//				String d30221ZhS = resultSet.getString("d302_21_ZH");
				String d30222ZhS = resultSet.getString("d302_22_ZH");
				String d30222S = resultSet.getString("d302_22");
				String d30223S = resultSet.getString("d302_23");
				String d30224S = resultSet.getString("d302_24");
				String d30224ZhS = resultSet.getString("d302_24_ZH");
				String d30225S = resultSet.getString("d302_25");
				String d30226S = resultSet.getString("d302_26");
				String d30226ZhS = resultSet.getString("d302_26_ZH");
				String d30227S = resultSet.getString("d302_27");
				String d30228S = "";
				if(d30228Date != null)
				{
					d30228S = simpleDateFormatShort.format(d30228Date);
				}
				double d30229S = resultSet.getDouble("d302_29");
				String d30230S = resultSet.getString("d302_30");
				String d30231S = resultSet.getString("d302_31");
				
				String d30232S = resultSet.getString("d302_32");
				String d30233S = resultSet.getString("d302_33");
				String d30234S = resultSet.getString("d302_34");
				String d30235S = resultSet.getString("d302_35");
				String d30236S = resultSet.getString("d302_36");
				String d30237S = resultSet.getString("d302_37");
				String d30238S = resultSet.getString("d302_38");
				String d30239S = resultSet.getString("d302_39");
				String d30240S = resultSet.getString("d302_40");
				String d30241S = resultSet.getString("d302_41");
				String d30242S = resultSet.getString("d302_42");
				String d30243S = resultSet.getString("d302_43");
				String d30244S = resultSet.getString("d302_44");
				String d30245S = resultSet.getString("d302_45");
				String d30246S = resultSet.getString("d302_46");
				String d30247S = resultSet.getString("d302_47");
				String d30248S = resultSet.getString("d302_48");
				String d30249S = resultSet.getString("d302_49");
				String d30250S = resultSet.getString("d302_50");
				String d30251S = resultSet.getString("d302_51");
				String d30252S = resultSet.getString("d302_52");
//				String d30252ZhS = resultSet.getString("d302_52_ZH");
				String d30253S = resultSet.getString("d302_53");
				String d30254S = resultSet.getString("d302_54");
				String d30255S = resultSet.getString("d302_55");
				String d30256S = resultSet.getString("d302_56");
				String d30257S = resultSet.getString("d302_57");
				String d30258S = resultSet.getString("d302_58");
				String d30259S = resultSet.getString("d302_59");
				String d30260S = resultSet.getString("d302_60");
				String d30261S = resultSet.getString("d302_61");
				String d30262S = resultSet.getString("d302_62");
				String d30263S = resultSet.getString("d302_63");
				String d30264S = resultSet.getString("d302_64");
				String d30265S = resultSet.getString("d302_65");
				String d30266S = resultSet.getString("d302_66");
				String d30267S = resultSet.getString("d302_67");
				String d30268S = resultSet.getString("d302_68");
				String d30269S = resultSet.getString("d302_69");
				String d30270S = resultSet.getString("d302_70");
				
				vd302.setD30201S(d30201S);
				vd302.setD30202S(d30202S);
				vd302.setD30203S(d30203S);
				vd302.setD30203ZhS(d30203ZhS);
				vd302.setD30204S(d30204S);
				vd302.setD30205S(d30205S);
				vd302.setD30205ZhS(d30205ZhS);
				vd302.setD30206S(d30206S);
				vd302.setD30207S(d30207S);
				vd302.setD30208S(d30208S);
				vd302.setD30209S(d30209S);
				vd302.setD30209ZhS(d30209ZhS);
				vd302.setD30210S(d30210S);
				vd302.setD30211S(d30211S);
				vd302.setD30212S(d30212S);
				vd302.setD30213S(d30213S);
				vd302.setD30214S(d30214S);
				vd302.setD30214ZhS(d30214ZhS);
				vd302.setD30215S(d30215S);
				vd302.setD30215ZhS(d30215ZhS);
				vd302.setD30216S(d30216S);
				vd302.setD30217S(d30217S);
				vd302.setD30218S(d30218S);
				vd302.setD30219S(d30219S);
				vd302.setD30219ZhS(d30219ZhS);
				vd302.setD30220S(d30220S);
				vd302.setD30220ZhS(d30220ZhS);
				vd302.setD30221S(d30221S);
//				if(d30248S == null)
//				{
//					vd302.setD30221ZhS(d30221ZhS);
//				}
//				else
//				{
//					vd302.setD30221ZhS(d30221ZhS+d30248S);
//				}
				vd302.setD30222S(d30222S);
				vd302.setD30222ZhS(d30222ZhS);
				vd302.setD30223S(d30223S);
				vd302.setD30224S(d30224S);
				vd302.setD30224ZhS(d30224ZhS);
				vd302.setD30225S(d30225S);
				vd302.setD30226S(d30226S);
				vd302.setD30226ZhS(d30226ZhS);
				vd302.setD30227S(d30227S);
				vd302.setD30228S(d30228S);
				vd302.setD30229S(d30229S);
				vd302.setD30230S(d30230S);
				vd302.setD30231S(d30231S);
				vd302.setD30232S(d30232S);
				vd302.setD30233S(d30233S);
				vd302.setD30234S(d30234S);
				vd302.setD30235S(d30235S);
				vd302.setD30236S(d30236S);
				
				vd302.setD30237S(d30237S);
				vd302.setD30238S(d30238S);
				vd302.setD30239S(d30239S);
				vd302.setD30240S(d30240S);
				vd302.setD30241S(d30241S);
				vd302.setD30242S(d30242S);
				vd302.setD30243S(d30243S);
				vd302.setD30244S(d30244S);
				vd302.setD30245S(d30245S);
				vd302.setD30246S(d30246S);
				vd302.setD30247S(d30247S);
				vd302.setD30248S(d30248S);
				vd302.setD30249S(d30249S);
				vd302.setD30250S(d30250S);
				vd302.setD30251S(d30251S);
				vd302.setD30252S(d30252S);
//				if(d30253S == null)
//				{
//					vd302.setD30252ZhS(d30252ZhS);
//				}else
//				{
//					vd302.setD30252ZhS(d30252ZhS + d30253S);
//				}
				vd302.setD30253S(d30253S);
				vd302.setD30254S(d30254S);
				vd302.setD30255S(d30255S);
				vd302.setD30256S(d30256S);
				vd302.setD30257S(d30257S);
				vd302.setD30258S(d30258S);
				vd302.setD30259S(d30259S);
				vd302.setD30260S(d30260S);
				vd302.setD30261S(d30261S);
				vd302.setD30262S(d30262S);
				vd302.setD30263S(d30263S);
				vd302.setD30264S(d30264S);
				vd302.setD30265S(d30265S);
				vd302.setD30266S(d30266S);
				vd302.setD30267S(d30267S);
				vd302.setD30268S(d30268S);
				vd302.setD30269S(d30269S);
				vd302.setD30270S(d30270S);
				
				long d30201T = resultSet.getLong("d302_01");
				String d30202T = resultSet.getString("d302_02");
				String d30203T = resultSet.getString("d302_03");
				String d30203ZhT = resultSet.getString("d302_03_ZH");
				String d30204T = "";
				if(d30204Time != null)
				{
					d30204T = simpleDateFormatFull.format(d30204Time);
				}
				String d30205T = resultSet.getString("d302_05");
				String d30205ZhT = resultSet.getString("d302_05_ZH");
				String d30206T = resultSet.getString("d302_06");
				int d30207T = resultSet.getInt("d302_07");
				double d30208T = resultSet.getDouble("d302_08");
				String d30209T = resultSet.getString("d302_09");
				String d30209ZhT = resultSet.getString("d302_09_ZH");
				String d30210T = resultSet.getString("d302_10");
				String d30211T = resultSet.getString("d302_11");
				String d30212T = resultSet.getString("d302_12");
				String d30213T = "";
				if(d30213Date != null)
				{
					String d30213Year = simpleDateFormatYear.format(d30213Date);
					d30213T = String.valueOf(d30204Year - Integer.parseInt(d30213Year));
				}
				String d30214T = resultSet.getString("d302_14");
				String d30214ZhT = resultSet.getString("d302_14_ZH");
				String d30215T = resultSet.getString("d302_15");
				String d30215ZhT = resultSet.getString("d302_15_ZH");
				String d30216T = resultSet.getString("d302_16");
				String d30217T = resultSet.getString("d302_17");
				String d30218T = "";
				if(d30218Date != null)
				{
					String d30218Year = simpleDateFormatYear.format(d30218Date);
					d30218T = String.valueOf(d30204Year - Integer.parseInt(d30218Year));
				}
				String d30219T = resultSet.getString("d302_19");
				String d30219ZhT = resultSet.getString("d302_19_ZH");
				String d30220T = resultSet.getString("d302_20");
				String d30220ZhT = resultSet.getString("d302_20_ZH");
//				String d30221T = resultSet.getString("d302_21");
//				String d30221ZhT = resultSet.getString("d302_21_ZH");
				String d30222ZhT = resultSet.getString("d302_22_ZH");
				String d30222T = resultSet.getString("d302_22");
				String d30223T = resultSet.getString("d302_23");
				String d30224T = resultSet.getString("d302_24");
				String d30224ZhT = resultSet.getString("d302_24_ZH");
				String d30225T = resultSet.getString("d302_25");
				String d30226T = resultSet.getString("d302_26");
				String d30226ZhT = resultSet.getString("d302_26_ZH");
				String d30227T = resultSet.getString("d302_27");
				String d30228T = "";
				if(d30228Date != null)
				{
					d30228T = simpleDateFormatShort.format(d30228Date);
				}
				double d30229T = resultSet.getDouble("d302_29");
				String d30230T = resultSet.getString("d302_30");
				String d30231T = resultSet.getString("d302_31");
				
				String d30232T = resultSet.getString("d302_32");
				String d30233T = resultSet.getString("d302_33");
				String d30234T = resultSet.getString("d302_34");
				String d30235T = resultSet.getString("d302_35");
				String d30236T = resultSet.getString("d302_36");
				String d30237T = resultSet.getString("d302_37");
				String d30238T = resultSet.getString("d302_38");
				String d30239T = resultSet.getString("d302_39");
				String d30240T = resultSet.getString("d302_40");
				String d30241T = resultSet.getString("d302_41");
				String d30242T = resultSet.getString("d302_42");
				String d30243T = resultSet.getString("d302_43");
				String d30244T = resultSet.getString("d302_44");
				String d30245T = resultSet.getString("d302_45");
				String d30246T = resultSet.getString("d302_46");
				String d30247T = resultSet.getString("d302_47");
				String d30248T = resultSet.getString("d302_48");
				String d30249T = resultSet.getString("d302_49");
				String d30250T = resultSet.getString("d302_50");
				String d30251T = resultSet.getString("d302_51");
				String d30252T = resultSet.getString("d302_52");
//				String d30252ZhT = resultSet.getString("d302_52_ZH");
				String d30253T = resultSet.getString("d302_53");
				String d30254T = resultSet.getString("d302_54");
				String d30255T = resultSet.getString("d302_55");
				String d30256T = resultSet.getString("d302_56");
				String d30257T = resultSet.getString("d302_57");
				String d30258T = resultSet.getString("d302_58");
				String d30259T = resultSet.getString("d302_59");
				String d30260T = resultSet.getString("d302_60");
				String d30261T = resultSet.getString("d302_61");
				String d30262T = resultSet.getString("d302_62");
				String d30263T = resultSet.getString("d302_63");
				String d30264T = resultSet.getString("d302_64");
				String d30265T = resultSet.getString("d302_65");
				String d30266T = resultSet.getString("d302_66");
				String d30267T = resultSet.getString("d302_67");
				String d30268T = resultSet.getString("d302_68");
				String d30269T = resultSet.getString("d302_69");
				String d30270T = resultSet.getString("d302_70");
				
				vd302.setD30201T(d30201T);
				vd302.setD30202T(d30202T);
				vd302.setD30203T(d30203T);
				vd302.setD30203ZhT(d30203ZhT);
				vd302.setD30204T(d30204T);
				vd302.setD30205T(d30205T);
				vd302.setD30205ZhT(d30205ZhT);
				vd302.setD30206T(d30206T);
				vd302.setD30207T(d30207T);
				vd302.setD30208T(d30208T);
				vd302.setD30209T(d30209T);
				vd302.setD30209ZhT(d30209ZhT);
				vd302.setD30210T(d30210T);
				vd302.setD30211T(d30211T);
				vd302.setD30212T(d30212T);
				vd302.setD30213T(d30213T);
				vd302.setD30214T(d30214T);
				vd302.setD30214ZhT(d30214ZhT);
				vd302.setD30215T(d30215T);
				vd302.setD30215ZhT(d30215ZhT);
				vd302.setD30216T(d30216T);
				vd302.setD30217T(d30217T);
				vd302.setD30218T(d30218T);
				vd302.setD30219T(d30219T);
				vd302.setD30219ZhT(d30219ZhT);
				vd302.setD30220T(d30220T);
				vd302.setD30220ZhT(d30220ZhT);
//				if(d30248T == null)
//				{
//					vd302.setD30221T(d30221T);
//				}
//				else
//				{
//					vd302.setD30221ZhT(d30221ZhT + d30248T);
//				}
				vd302.setD30222T(d30222T);
				vd302.setD30222ZhT(d30222ZhT);
				vd302.setD30223T(d30223T);
				vd302.setD30224T(d30224T);
				vd302.setD30224ZhT(d30224ZhT);
				vd302.setD30225T(d30225T);
				vd302.setD30226T(d30226T);
				vd302.setD30226ZhT(d30226ZhT);
				vd302.setD30227T(d30227T);
				vd302.setD30228T(d30228T);
				vd302.setD30229T(d30229T);
				vd302.setD30230T(d30230T);
				vd302.setD30231T(d30231T);
				vd302.setD30232T(d30232T);
				vd302.setD30233T(d30233T);
				vd302.setD30234T(d30234T);
				vd302.setD30235T(d30235T);
				vd302.setD30236T(d30236T);
				
				vd302.setD30237T(d30237T);
				vd302.setD30238T(d30238T);
				vd302.setD30239T(d30239T);
				vd302.setD30240T(d30240T);
				vd302.setD30241T(d30241T);
				vd302.setD30242T(d30242T);
				vd302.setD30243T(d30243T);
				vd302.setD30244T(d30244T);
				vd302.setD30245T(d30245T);
				vd302.setD30246T(d30246T);
				vd302.setD30247T(d30247T);
				vd302.setD30248T(d30248T);
				vd302.setD30249T(d30249T);
				vd302.setD30250T(d30250T);
				vd302.setD30251T(d30251T);
				vd302.setD30252T(d30252T);
//				if(d30253T == null)
//				{
//					vd302.setD30252ZhT(d30252ZhT);
//				}else
//				{
//					vd302.setD30252ZhT(d30252ZhT + d30253T);
//				}
				vd302.setD30253T(d30253T);
				vd302.setD30254T(d30254T);
				vd302.setD30255T(d30255T);
				vd302.setD30256T(d30256T);
				vd302.setD30257T(d30257T);
				vd302.setD30258T(d30258T);
				vd302.setD30259T(d30259T);
				vd302.setD30260T(d30260T);
				vd302.setD30261T(d30261T);
				vd302.setD30262T(d30262T);
				vd302.setD30263T(d30263T);
				vd302.setD30264T(d30264T);
				vd302.setD30265T(d30265T);
				vd302.setD30266T(d30266T);
				vd302.setD30267T(d30267T);
				vd302.setD30268T(d30268T);
				vd302.setD30269T(d30269T);
				vd302.setD30270T(d30270T);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, resultSet);
		}
		return vd302;
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
