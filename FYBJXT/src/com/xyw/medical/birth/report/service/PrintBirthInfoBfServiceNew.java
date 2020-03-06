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

import com.xyw.medical.birth.report.model.VD303;

public class PrintBirthInfoBfServiceNew {
	
	private DataSource dataSource;

	public VD303 queryD303(String d303_10, ServletContext servletContext) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		VD303 vd303 = null;
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement("select t.* from V_D303 t where t.D303_10 = ?");
			preparedStatement.setString(1, d303_10);
			resultSet = preparedStatement.executeQuery();
			SimpleDateFormat simpleDateFormatFull = null;
			SimpleDateFormat simpleDateFormatShort = null;
			SimpleDateFormat simpleDateFormatYear = null;
			vd303 = new VD303();
			if(resultSet.next()) {
				simpleDateFormatFull = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				simpleDateFormatShort = new SimpleDateFormat("yyyy-MM-dd");
				simpleDateFormatYear = new SimpleDateFormat("yyyy");
				long d30301 = resultSet.getLong("d303_01");
				String d30302 = resultSet.getString("d303_02");
				String d30303 = resultSet.getString("d303_03");
				String d30303Zh = resultSet.getString("d303_03_ZH");
				Timestamp d30304Date = resultSet.getTimestamp("d303_04");
				String d30304 = "";
				if(d30304Date != null)
				{
					d30304 = simpleDateFormatFull.format(d30304Date);
				}
				String d30305 = resultSet.getString("d303_05");
				String d30306 = resultSet.getString("d303_06");
				int d30307 = resultSet.getInt("d303_07");
				double d30308 = resultSet.getDouble("d303_08");
				String d30309 = resultSet.getString("d303_09");
				String d30309Zh = resultSet.getString("d303_09_ZH");
				String d30310 = resultSet.getString("d303_10");
				String d30311 = resultSet.getString("d303_11");
				String d30312 = resultSet.getString("d303_12");
				Date d30313Date = resultSet.getDate("d303_13");
				String d30313 = "";
				Calendar cal = Calendar.getInstance();
				cal.setTime(d30304Date);
				int d30304Year = cal.get(Calendar.YEAR);
				if(d30313Date != null)
				{
					String d30313Year = simpleDateFormatYear.format(d30313Date);
					d30313 = String.valueOf(d30304Year - Integer.parseInt(d30313Year));
				}
				String d30314 = resultSet.getString("d303_14");
				String d30314Zh = resultSet.getString("d303_14_ZH");
				String d30315 = resultSet.getString("d303_15");
				String d30315Zh = resultSet.getString("d303_15_ZH");
				String d30316 = resultSet.getString("d303_16");
				String d30317 = resultSet.getString("d303_17");
				Date d30318Date = resultSet.getDate("d303_18");
				String d30318 = "";
				if(d30318Date != null)
				{
					String d30318Year = simpleDateFormatYear.format(d30318Date);
					d30318 = String.valueOf(d30304Year - Integer.parseInt(d30318Year));
				}
				String d30319 = resultSet.getString("d303_19");
				String d30319Zh = resultSet.getString("d303_19_ZH");
				String d30320 = resultSet.getString("d303_20");
				String d30320Zh = resultSet.getString("d303_20_ZH");
				String d30321 = resultSet.getString("d303_21");
//				String d30321Zh = resultSet.getString("d303_21_ZH");
				String d30322Zh = resultSet.getString("d303_22_ZH");
				String d30322 = resultSet.getString("d303_22");
				String d30323 = resultSet.getString("d303_23");
				String d30324 = resultSet.getString("d303_24");
				String d30324Zh = resultSet.getString("d303_24_ZH");
				String d30325 = resultSet.getString("d303_25");
				String d30326 = resultSet.getString("d303_26");
				String d30326Zh = resultSet.getString("d303_26_ZH");
				String d30327 = resultSet.getString("d303_27");
				Date d30328Date = resultSet.getDate("d303_28");
				String d30328 = "";
				if(d30328Date != null)
				{
					d30328 = simpleDateFormatShort.format(d30328Date);
				}
				double d30329 = resultSet.getDouble("d303_29");
				String d30330 = resultSet.getString("d303_30");
				String d30331 = resultSet.getString("d303_31");
				
				String d30332 = resultSet.getString("d303_32");
				String d30333 = resultSet.getString("d303_33");
				String d30333Zh = resultSet.getString("d303_33_ZH");
				String d30334 = resultSet.getString("d303_34");
				String d30335 = resultSet.getString("d303_35");
				String d30336 = resultSet.getString("d303_36");
				String d30337 = resultSet.getString("d303_37");
				String d30338 = resultSet.getString("d303_38");
				String d30339 = resultSet.getString("d303_39");
				String d30340 = resultSet.getString("d303_40");
				String d30341 = resultSet.getString("d303_41");
				String d30342 = resultSet.getString("d303_42");
				String d30343 = resultSet.getString("d303_43");
				String d30344 = resultSet.getString("d303_44");
				String d30345 = resultSet.getString("d303_45");
				String d30346 = resultSet.getString("d303_46");
				String d30347 = resultSet.getString("d303_47");
				String d30348 = resultSet.getString("d303_48");
				String d30349 = resultSet.getString("d303_49");
				String d30350 = resultSet.getString("d303_50");
				String d30351 = resultSet.getString("d303_51");
				String d30352 = resultSet.getString("d303_52");
//				String d30352Zh = resultSet.getString("d303_52_ZH");
				String d30353 = resultSet.getString("d303_53");
				String d30354 = resultSet.getString("d303_54");
				String d30355 = resultSet.getString("d303_55");
				String d30356 = resultSet.getString("d303_56");
				String d30357 = resultSet.getString("d303_57");
				String d30358 = resultSet.getString("d303_58");
				String d30359 = resultSet.getString("d303_59");
				String d30360 = resultSet.getString("d303_60");
				String d30361 = resultSet.getString("d303_61");
				String d30362 = resultSet.getString("d303_62");
				String d30363 = resultSet.getString("d303_63");
				String d30364 = resultSet.getString("d303_64");
				String d30365 = resultSet.getString("d303_65");
				String d30366 = resultSet.getString("d303_66");
				String d30367 = resultSet.getString("d303_67");
				String d30368 = resultSet.getString("d303_68");
				String d30369 = resultSet.getString("d303_69");
				String d30370 = resultSet.getString("d303_70");
				
				vd303.setD30301(d30301);
				vd303.setD30302(d30302);
				vd303.setD30303(d30303);
				vd303.setD30303Zh(d30303Zh);
				vd303.setD30304(d30304);
				vd303.setD30305(d30305);
				vd303.setD30306(d30306);
				vd303.setD30307(d30307);
				vd303.setD30308(d30308);
				vd303.setD30309(d30309);
				vd303.setD30309Zh(d30309Zh);
				vd303.setD30310(d30310);
				vd303.setD30311(d30311);
				vd303.setD30312(d30312);
				vd303.setD30313(d30313);
				vd303.setD30314(d30314);
				vd303.setD30314Zh(d30314Zh);
				vd303.setD30315(d30315);
				vd303.setD30315Zh(d30315Zh);
				vd303.setD30316(d30316);
				vd303.setD30317(d30317);
				vd303.setD30318(d30318);
				vd303.setD30319(d30319);
				vd303.setD30319Zh(d30319Zh);
				vd303.setD30320(d30320);
				vd303.setD30320Zh(d30320Zh);
				vd303.setD30321(d30321);
//				if(d30348 == null)
//				{
//					vd303.setD30321Zh(d30321Zh);
//				}
//				else
//				{
//					vd303.setD30321Zh(d30321Zh + d30348);
//				}
				vd303.setD30322(d30322);
				vd303.setD30322Zh(d30322Zh);
				vd303.setD30323(d30323);
				vd303.setD30324(d30324);
				vd303.setD30324Zh(d30324Zh);
				vd303.setD30325(d30325);
				vd303.setD30326(d30326);
				vd303.setD30326Zh(d30326Zh);
				vd303.setD30327(d30327);
				vd303.setD30328(d30328);
				vd303.setD30329(d30329);
				vd303.setD30330(d30330);
				vd303.setD30331(d30331);
				vd303.setD30332(d30332);
				vd303.setD30333(d30333);
				vd303.setD30333Zh(d30333Zh);
				vd303.setD30334(d30334);
				vd303.setD30335(d30335);
				vd303.setD30336(d30336);
				
				vd303.setD30337(d30337);
				vd303.setD30338(d30338);
				vd303.setD30339(d30339);
				vd303.setD30340(d30340);
				vd303.setD30341(d30341);
				vd303.setD30342(d30342);
				vd303.setD30343(d30343);
				vd303.setD30344(d30344);
				vd303.setD30345(d30345);
				vd303.setD30346(d30346);
				vd303.setD30347(d30347);
				vd303.setD30348(d30348);
				vd303.setD30349(d30349);
				vd303.setD30350(d30350);
				vd303.setD30351(d30351);
				vd303.setD30352(d30352);
//				if(d30353 == null)
//				{
//					vd303.setD30352Zh(d30352Zh);
//				}
//				else
//				{
//					vd303.setD30352Zh(d30352Zh + d30353);
//				}
				vd303.setD30353(d30353);
				vd303.setD30354(d30354);
				vd303.setD30355(d30355);
				vd303.setD30356(d30356);
				vd303.setD30357(d30357);
				vd303.setD30358(d30358);
				vd303.setD30359(d30359);
				vd303.setD30360(d30360);
				vd303.setD30361(d30361);
				vd303.setD30362(d30362);
				vd303.setD30363(d30363);
				vd303.setD30364(d30364);
				vd303.setD30365(d30365);
				vd303.setD30366(d30366);
				vd303.setD30367(d30367);
				vd303.setD30368(d30368);
				vd303.setD30369(d30369);
				vd303.setD30370(d30370);
				
				long d30301S = resultSet.getLong("d303_01");
				String d30302S = resultSet.getString("d303_02");
				String d30303S = resultSet.getString("d303_03");
				String d30303ZhS = resultSet.getString("d303_03_ZH");
				Timestamp d30304SDate= resultSet.getTimestamp("d303_04");
				String d30304S = "";
				if(d30304SDate != null)
				{
					d30304S = simpleDateFormatFull.format(d30304SDate);
				}
				String d30305S = resultSet.getString("d303_05");
				String d30305ZhS= resultSet.getString("d303_05_ZH");
				String d30306S = resultSet.getString("d303_06");
				int d30307S = resultSet.getInt("d303_07");
				double d30308S = resultSet.getDouble("d303_08");
				String d30309S = resultSet.getString("d303_09");
				String d30309ZhS = resultSet.getString("d303_09_ZH");
				String d30310S = resultSet.getString("d303_10");
				String d30311S = resultSet.getString("d303_11");
				String d30312S = resultSet.getString("d303_12");
				Date d30313SDate = resultSet.getDate("d303_13");
				String d30313S = "";
				if(d30313SDate != null)
				{
					String d30313Year = simpleDateFormatYear.format(d30313SDate);
					d30313S = String.valueOf(d30304Year - Integer.parseInt(d30313Year));
				}
				String d30314S = resultSet.getString("d303_14");
				String d30314ZhS = resultSet.getString("d303_14_ZH");
				String d30315S = resultSet.getString("d303_15");
				String d30315ZhS = resultSet.getString("d303_15_ZH");
				String d30316S = resultSet.getString("d303_16");
				String d30317S = resultSet.getString("d303_17");
				Date d30318SDate = resultSet.getDate("d303_18");
				String d30318S = "";
				if(d30318SDate != null)
				{
					String d30318Year = simpleDateFormatYear.format(d30318SDate);
					d30318S = String.valueOf(d30304Year - Integer.parseInt(d30318Year));
				}
				String d30319S = resultSet.getString("d303_19");
				String d30319ZhS = resultSet.getString("d303_19_ZH");
				String d30320S= resultSet.getString("d303_20");
				String d30320ZhS = resultSet.getString("d303_20_ZH");
				String d30321S = resultSet.getString("d303_21");
//				String d30321ZhS = resultSet.getString("d303_21_ZH");
				String d30322ZhS = resultSet.getString("d303_22_ZH");
				String d30322S = resultSet.getString("d303_22");
				String d30323S = resultSet.getString("d303_23");
				String d30324S = resultSet.getString("d303_24");
				String d30324ZhS = resultSet.getString("d303_24_ZH");
				String d30325S = resultSet.getString("d303_25");
				String d30326S = resultSet.getString("d303_26");
				String d30326ZhS = resultSet.getString("d303_26_ZH");
				String d30327S = resultSet.getString("d303_27");
				Date d30328SDate = resultSet.getDate("d303_28");
				String d30328S = "";
				if(d30328SDate != null)
				{
					d30328S = simpleDateFormatShort.format(d30328SDate);
				}
				double d30329S = resultSet.getDouble("d303_29");
				String d30330S = resultSet.getString("d303_30");
				String d30331S = resultSet.getString("d303_31");
				
				String d30332S = resultSet.getString("d303_32");
				String d30333S = resultSet.getString("d303_33");
				String d30334S = resultSet.getString("d303_34");
				String d30335S = resultSet.getString("d303_35");
				String d30336S = resultSet.getString("d303_36");
				String d30337S = resultSet.getString("d303_37");
				String d30338S = resultSet.getString("d303_38");
				String d30339S = resultSet.getString("d303_39");
				String d30340S = resultSet.getString("d303_40");
				String d30341S = resultSet.getString("d303_41");
				String d30342S = resultSet.getString("d303_42");
				String d30343S = resultSet.getString("d303_43");
				String d30344S = resultSet.getString("d303_44");
				String d30345S = resultSet.getString("d303_45");
				String d30346S = resultSet.getString("d303_46");
				String d30347S = resultSet.getString("d303_47");
				String d30348S = resultSet.getString("d303_48");
				String d30349S = resultSet.getString("d303_49");
				String d30350S = resultSet.getString("d303_50");
				String d30351S = resultSet.getString("d303_51");
				String d30352S = resultSet.getString("d303_52");
				String d30353S = resultSet.getString("d303_53");
				String d30354S = resultSet.getString("d303_54");
				String d30355S = resultSet.getString("d303_55");
				String d30356S = resultSet.getString("d303_56");
				String d30357S = resultSet.getString("d303_57");
				String d30358S = resultSet.getString("d303_58");
				String d30359S = resultSet.getString("d303_59");
				String d30360S = resultSet.getString("d303_60");
				String d30361S = resultSet.getString("d303_61");
				String d30362S = resultSet.getString("d303_62");
				String d30363S = resultSet.getString("d303_63");
				String d30364S = resultSet.getString("d303_64");
				String d30365S = resultSet.getString("d303_65");
				String d30366S = resultSet.getString("d303_66");
				String d30367S = resultSet.getString("d303_67");
				String d30368S = resultSet.getString("d303_68");
				String d30369S = resultSet.getString("d303_69");
				String d30370S = resultSet.getString("d303_70");
				
				vd303.setD30301S(d30301S);
				vd303.setD30302S(d30302S);
				vd303.setD30303S(d30303S);
				vd303.setD30303ZhS(d30303ZhS);
				vd303.setD30304S(d30304S);
				vd303.setD30305S(d30305S);
				vd303.setD30305ZhS(d30305ZhS);
				vd303.setD30306S(d30306S);
				vd303.setD30307S(d30307S);
				vd303.setD30308S(d30308S);
				vd303.setD30309S(d30309S);
				vd303.setD30309ZhS(d30309ZhS);
				vd303.setD30310S(d30310S);
				vd303.setD30311S(d30311S);
				vd303.setD30312S(d30312S);
				vd303.setD30313S(d30313S);
				vd303.setD30314S(d30314S);
				vd303.setD30314ZhS(d30314ZhS);
				vd303.setD30315S(d30315S);
				vd303.setD30315ZhS(d30315ZhS);
				vd303.setD30316S(d30316S);
				vd303.setD30317S(d30317S);
				vd303.setD30318S(d30318S);
				vd303.setD30319S(d30319S);
				vd303.setD30319ZhS(d30319ZhS);
				vd303.setD30320S(d30320S);
				vd303.setD30320ZhS(d30320ZhS);
				vd303.setD30321S(d30321S);
//				if(d30348S == null)
//				{
//					vd303.setD30321ZhS(d30321ZhS);
//				}
//				else
//				{
//					vd303.setD30321ZhS(d30321ZhS + d30348S);
//				}
				vd303.setD30322S(d30322S);
				vd303.setD30322ZhS(d30322ZhS);
				vd303.setD30323S(d30323S);
				vd303.setD30324S(d30324S);
				vd303.setD30324ZhS(d30324ZhS);
				vd303.setD30325S(d30325S);
				vd303.setD30326S(d30326S);
				vd303.setD30326ZhS(d30326ZhS);
				vd303.setD30327S(d30327S);
				vd303.setD30328S(d30328S);
				vd303.setD30329S(d30329S);
				vd303.setD30330S(d30330S);
				vd303.setD30331S(d30331S);
				vd303.setD30332S(d30332S);
				vd303.setD30333S(d30333S);
				vd303.setD30334S(d30334S);
				vd303.setD30335S(d30335S);
				vd303.setD30336S(d30336S);
				
				vd303.setD30337S(d30337S);
				vd303.setD30338S(d30338S);
				vd303.setD30339S(d30339S);
				vd303.setD30340S(d30340S);
				vd303.setD30341S(d30341S);
				vd303.setD30342S(d30342S);
				vd303.setD30343S(d30343S);
				vd303.setD30344S(d30344S);
				vd303.setD30345S(d30345S);
				vd303.setD30346S(d30346S);
				vd303.setD30347S(d30347S);
				vd303.setD30348S(d30348S);
				vd303.setD30349S(d30349S);
				vd303.setD30350S(d30350S);
				vd303.setD30351S(d30351S);
				vd303.setD30352S(d30352S);
				vd303.setD30353S(d30353S);
				vd303.setD30354S(d30354S);
				vd303.setD30355S(d30355S);
				vd303.setD30356S(d30356S);
				vd303.setD30357S(d30357S);
				vd303.setD30358S(d30358S);
				vd303.setD30359S(d30359S);
				vd303.setD30360S(d30360S);
				vd303.setD30361S(d30361S);
				vd303.setD30362S(d30362S);
				vd303.setD30363S(d30363S);
				vd303.setD30364S(d30364S);
				vd303.setD30365S(d30365S);
				vd303.setD30366S(d30366S);
				vd303.setD30367S(d30367S);
				vd303.setD30368S(d30368S);
				vd303.setD30369S(d30369S);
				vd303.setD30370S(d30370S);
				
				long d30301T = resultSet.getLong("d303_01");
				String d30302T = resultSet.getString("d303_02");
				String d30303T = resultSet.getString("d303_03");
				String d30303ZhT = resultSet.getString("d303_03_ZH");
				String d30304T = "";
				if(d30304Date != null)
				{
					d30304T = simpleDateFormatFull.format(d30304Date);
				}
				String d30305T = resultSet.getString("d303_05");
				String d30305ZhT = resultSet.getString("d303_05_ZH");
				String d30306T = resultSet.getString("d303_06");
				int d30307T = resultSet.getInt("d303_07");
				double d30308T = resultSet.getDouble("d303_08");
				String d30309T = resultSet.getString("d303_09");
				String d30309ZhT = resultSet.getString("d303_09_ZH");
				String d30310T = resultSet.getString("d303_10");
				String d30311T = resultSet.getString("d303_11");
				String d30312T = resultSet.getString("d303_12");
				String d30313T = "";
				if(d30313Date != null)
				{
					String d30313Year = simpleDateFormatYear.format(d30313Date);
					d30313T = String.valueOf(d30304Year - Integer.parseInt(d30313Year));
				}
				String d30314T = resultSet.getString("d303_14");
				String d30314ZhT = resultSet.getString("d303_14_ZH");
				String d30315T = resultSet.getString("d303_15");
				String d30315ZhT = resultSet.getString("d303_15_ZH");
				String d30316T = resultSet.getString("d303_16");
				String d30317T = resultSet.getString("d303_17");
				String d30318T = "";
				if(d30318Date != null)
				{
					String d30318Year = simpleDateFormatYear.format(d30318Date);
					d30318T = String.valueOf(d30304Year - Integer.parseInt(d30318Year));
				}
				String d30319T = resultSet.getString("d303_19");
				String d30319ZhT = resultSet.getString("d303_19_ZH");
				String d30320T = resultSet.getString("d303_20");
				String d30320ZhT = resultSet.getString("d303_20_ZH");
				String d30321T = resultSet.getString("d303_21");
//				String d30321ZhT = resultSet.getString("d303_21_ZH");
				String d30322ZhT = resultSet.getString("d303_22_ZH");
				String d30322T = resultSet.getString("d303_22");
				String d30323T = resultSet.getString("d303_23");
				String d30324T = resultSet.getString("d303_24");
				String d30324ZhT = resultSet.getString("d303_24_ZH");
				String d30325T = resultSet.getString("d303_25");
				String d30326T = resultSet.getString("d303_26");
				String d30326ZhT = resultSet.getString("d303_26_ZH");
				String d30327T = resultSet.getString("d303_27");
				String d30328T = "";
				if(d30328Date != null)
				{
					d30328T = simpleDateFormatShort.format(d30328Date);
				}
				double d30329T = resultSet.getDouble("d303_29");
				String d30330T = resultSet.getString("d303_30");
				String d30331T = resultSet.getString("d303_31");
				
				String d30332T = resultSet.getString("d303_32");
				String d30333T = resultSet.getString("d303_33");
				String d30334T = resultSet.getString("d303_34");
				String d30335T = resultSet.getString("d303_35");
				String d30336T = resultSet.getString("d303_36");
				String d30337T = resultSet.getString("d303_37");
				String d30338T = resultSet.getString("d303_38");
				String d30339T = resultSet.getString("d303_39");
				String d30340T = resultSet.getString("d303_40");
				String d30341T = resultSet.getString("d303_41");
				String d30342T = resultSet.getString("d303_42");
				String d30343T = resultSet.getString("d303_43");
				String d30344T = resultSet.getString("d303_44");
				String d30345T = resultSet.getString("d303_45");
				String d30346T = resultSet.getString("d303_46");
				String d30347T = resultSet.getString("d303_47");
				String d30348T = resultSet.getString("d303_48");
				String d30349T = resultSet.getString("d303_49");
				String d30350T = resultSet.getString("d303_50");
				String d30351T = resultSet.getString("d303_51");
				String d30352T = resultSet.getString("d303_52");
				String d30353T = resultSet.getString("d303_53");
				String d30354T = resultSet.getString("d303_54");
				String d30355T = resultSet.getString("d303_55");
				String d30356T = resultSet.getString("d303_56");
				String d30357T = resultSet.getString("d303_57");
				String d30358T = resultSet.getString("d303_58");
				String d30359T = resultSet.getString("d303_59");
				String d30360T = resultSet.getString("d303_60");
				String d30361T = resultSet.getString("d303_61");
				String d30362T = resultSet.getString("d303_62");
				String d30363T = resultSet.getString("d303_63");
				String d30364T = resultSet.getString("d303_64");
				String d30365T = resultSet.getString("d303_65");
				String d30366T = resultSet.getString("d303_66");
				String d30367T = resultSet.getString("d303_67");
				String d30368T = resultSet.getString("d303_68");
				String d30369T = resultSet.getString("d303_69");
				String d30370T = resultSet.getString("d303_70");
				
				vd303.setD30301T(d30301T);
				vd303.setD30302T(d30302T);
				vd303.setD30303T(d30303T);
				vd303.setD30303ZhT(d30303ZhT);
				vd303.setD30304T(d30304T);
				vd303.setD30305T(d30305T);
				vd303.setD30305ZhT(d30305ZhT);
				vd303.setD30306T(d30306T);
				vd303.setD30307T(d30307T);
				vd303.setD30308T(d30308T);
				vd303.setD30309T(d30309T);
				vd303.setD30309ZhT(d30309ZhT);
				vd303.setD30310T(d30310T);
				vd303.setD30311T(d30311T);
				vd303.setD30312T(d30312T);
				vd303.setD30313T(d30313T);
				vd303.setD30314T(d30314T);
				vd303.setD30314ZhT(d30314ZhT);
				vd303.setD30315T(d30315T);
				vd303.setD30315ZhT(d30315ZhT);
				vd303.setD30316T(d30316T);
				vd303.setD30317T(d30317T);
				vd303.setD30318T(d30318T);
				vd303.setD30319T(d30319T);
				vd303.setD30319ZhT(d30319ZhT);
				vd303.setD30320T(d30320T);
				vd303.setD30320ZhT(d30320ZhT);
				vd303.setD30321T(d30321T);
//				if(d30348T == null)
//				{
//					vd303.setD30321ZhT(d30321ZhT);
//				}
//				else
//				{
//					vd303.setD30321ZhT(d30321ZhT + d30348T);
//				}
				vd303.setD30322T(d30322T);
				vd303.setD30322ZhT(d30322ZhT);
				vd303.setD30323T(d30323T);
				vd303.setD30324T(d30324T);
				vd303.setD30324ZhT(d30324ZhT);
				vd303.setD30325T(d30325T);
				vd303.setD30326T(d30326T);
				vd303.setD30326ZhT(d30326ZhT);
				vd303.setD30327T(d30327T);
				vd303.setD30328T(d30328T);
				vd303.setD30329T(d30329T);
				vd303.setD30330T(d30330T);
				vd303.setD30331T(d30331T);
				vd303.setD30332T(d30332T);
				vd303.setD30333T(d30333T);
				vd303.setD30334T(d30334T);
				vd303.setD30335T(d30335T);
				vd303.setD30336T(d30336T);
				
				vd303.setD30337T(d30337T);
				vd303.setD30338T(d30338T);
				vd303.setD30339T(d30339T);
				vd303.setD30340T(d30340T);
				vd303.setD30341T(d30341T);
				vd303.setD30342T(d30342T);
				vd303.setD30343T(d30343T);
				vd303.setD30344T(d30344T);
				vd303.setD30345T(d30345T);
				vd303.setD30346T(d30346T);
				vd303.setD30347T(d30347T);
				vd303.setD30348T(d30348T);
				vd303.setD30349T(d30349T);
				vd303.setD30350T(d30350T);
				vd303.setD30351T(d30351T);
				vd303.setD30352T(d30352T);
				vd303.setD30353T(d30353T);
				vd303.setD30354T(d30354T);
				vd303.setD30355T(d30355T);
				vd303.setD30356T(d30356T);
				vd303.setD30357T(d30357T);
				vd303.setD30358T(d30358T);
				vd303.setD30359T(d30359T);
				vd303.setD30360T(d30360T);
				vd303.setD30361T(d30361T);
				vd303.setD30362T(d30362T);
				vd303.setD30363T(d30363T);
				vd303.setD30364T(d30364T);
				vd303.setD30365T(d30365T);
				vd303.setD30366T(d30366T);
				vd303.setD30367T(d30367T);
				vd303.setD30368T(d30368T);
				vd303.setD30369T(d30369T);
				vd303.setD30370T(d30370T);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, resultSet);
		}
		return vd303;
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
