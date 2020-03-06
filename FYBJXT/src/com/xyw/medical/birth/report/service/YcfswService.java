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

import com.xyw.medical.ycfsw.model.VD604;


public class YcfswService {
private DataSource dataSource;
	
	public VD604 queryD604(String d604_01, String d604_04,String d604_06,ServletContext servletContext) {
		
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		VD604 vd604 = null;
		
		StringBuffer sql = new StringBuffer("select * from v_d604 t where 1=1 ");
		
		if(d604_01 != null){
			sql.append(" and t.D604_01 ="+d604_01 );
		}
		if(d604_04 != null){
			sql.append(" and t.D604_04 ='"+d604_04+"'" );
		}
		if(d604_06 != null){
			sql.append(" and t.D604_06 ='"+d604_06+"'" );
		}
		
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			resultSet = preparedStatement.executeQuery();
			vd604 = new VD604();
			List<VD604> vd604s = new ArrayList<VD604>();
			while(resultSet.next()) {
				
				long d60401 = resultSet.getLong("D604_01");
				long d60402 = resultSet.getLong("D604_02");
				String d60403 = resultSet.getString("D604_03");
				String d60404 = resultSet.getString("D604_04");
				Date d60405 = resultSet.getDate("D604_05");
				String d60406 = resultSet.getString("D604_06");
				String d60407 = resultSet.getString("D604_07");
				String d60408 = resultSet.getString("D604_08");
				Short d60409 = resultSet.getShort("D604_09");
				String d60410 = resultSet.getString("D604_10");
				
				String d60411 = resultSet.getString("D604_11");
				String d60412 = resultSet.getString("D604_12");
				String d60413 = resultSet.getString("D604_13");
				String d60414 = resultSet.getString("D604_14");
				String d60415 = resultSet.getString("D604_15");
				Byte d60416 = resultSet.getByte("D604_16");
				Byte d60417 = resultSet.getByte("D604_17");
				Byte d60418 = resultSet.getByte("D604_18");
				Date d60419 = resultSet.getDate("D604_19");
				Date d60420 = resultSet.getDate("D604_20");
				
				Date d60421 = resultSet.getDate("D604_21");
				String d60422 = resultSet.getString("D604_22");
				String d60423 = resultSet.getString("D604_23");
				String d60424 = resultSet.getString("D604_24");
				String d60425 = resultSet.getString("D604_25");
				String d60426 = resultSet.getString("D604_26");
				String d60427 = resultSet.getString("D604_27");
				Byte d60428 = resultSet.getByte("D604_28");
				Byte d60429 = resultSet.getByte("D604_29");
				String d60430 = resultSet.getString("D604_30");
				
				String d60431 = resultSet.getString("D604_31");
				String d60432 = resultSet.getString("D604_32");
				String d60433 = resultSet.getString("D604_33");
				String d60434 = resultSet.getString("D604_34");
				String d60435 = resultSet.getString("D604_35");
				String d60436 = resultSet.getString("D604_36");
				String d60437 = resultSet.getString("D604_37");
				String d60438 = resultSet.getString("D604_38");
				String d60439 = resultSet.getString("D604_39");
				String d60440 = resultSet.getString("D604_40");
				
				String d60441 = resultSet.getString("D604_41");
				String d60442 = resultSet.getString("D604_42");
				String d60443 = resultSet.getString("D604_43");
				String d60444 = resultSet.getString("D604_44");
				String d60445 = resultSet.getString("D604_45");
				String d60446 = resultSet.getString("D604_46");
				String d60447 = resultSet.getString("D604_47");
				String d60448 = resultSet.getString("D604_48");
				String d60449 = resultSet.getString("D604_49");
				String d60450 = resultSet.getString("D604_50");
				
				String d60451 = resultSet.getString("D604_51");
				String d60452 = resultSet.getString("D604_52");
				Date d60453 = resultSet.getDate("D604_53");
				String d60454 = resultSet.getString("D604_54");
				String d60455 = resultSet.getString("D604_55");
				String d60456 = resultSet.getString("D604_56");
				String d60457 = resultSet.getString("D604_57");
				String d60458 = resultSet.getString("D604_58");
				String d60459 = resultSet.getString("D604_59");
				String d60460 = resultSet.getString("D604_60");
				
				String d60461 = resultSet.getString("D604_61");
				String d60462 = resultSet.getString("D604_62");
				String d60463 = resultSet.getString("D604_63");
				String d60464 = resultSet.getString("D604_64");
				String d60465 = resultSet.getString("D604_65");
				String d60466 = resultSet.getString("D604_66");
				String d60467 = resultSet.getString("D604_67");
				String d60468 = resultSet.getString("D604_68");
				String d60469 = resultSet.getString("D604_69");
				String d60470 = resultSet.getString("D604_70");
				
				String d60471 = resultSet.getString("D604_71");
				String d60472 = resultSet.getString("D604_72");
				String d60473 = resultSet.getString("D604_73");
				String d60474 = resultSet.getString("D604_74");
				String d60475 = resultSet.getString("D604_75");
				String d60476 = resultSet.getString("D604_76");
				String d60477 = resultSet.getString("D604_77");
				String d60478 = resultSet.getString("D604_78");
				String d60479 = resultSet.getString("D604_79");
				String d60480 = resultSet.getString("D604_80");
				
				String d60410Zh = resultSet.getString("D604_10_ZH");
				String d60411Zh = resultSet.getString("D604_11_ZH");
				String d60412Zh = resultSet.getString("D604_12_ZH");
				String d60413Zh = resultSet.getString("D604_13_ZH");
				String d60415Zh = resultSet.getString("D604_15_ZH");
				String d60422Zh = resultSet.getString("D604_22_ZH");
				String d60423Zh = resultSet.getString("D604_23_ZH");
				String d60424Zh = resultSet.getString("D604_24_ZH");
				String d60434Zh = resultSet.getString("D604_34_ZH");
				String d60436Zh = resultSet.getString("D604_36_ZH");
				String d60438Zh = resultSet.getString("D604_38_ZH");
				String d60439Zh = resultSet.getString("D604_39_ZH");
				String d60440Zh = resultSet.getString("D604_40_ZH");
				String d60441Zh = resultSet.getString("D604_41_ZH");
				String d60442Zh = resultSet.getString("D604_42_ZH");
				String d60443Zh = resultSet.getString("D604_43_ZH");
				String d60444Zh = resultSet.getString("D604_44_ZH");
				String d60445Zh = resultSet.getString("D604_45_ZH");
				String d60446Zh = resultSet.getString("D604_46_ZH");
				String d60447Zh = resultSet.getString("D604_47_ZH");
				String d60448Zh = resultSet.getString("D604_48_ZH");
				String d60449Zh = resultSet.getString("D604_49_ZH");
				String d60451Zh = resultSet.getString("D604_51_ZH");
				String d60453Zh = resultSet.getString("D604_53_ZH");
				
				vd604.setD60401(d60401);
				vd604.setD60402(d60402);
				vd604.setD60403(d60403);
				vd604.setD60404(d60404);
				vd604.setD60405(d60405);
				vd604.setD60406(d60406);
				vd604.setD60407(d60407);
				vd604.setD60408(d60408);
				vd604.setD60409(d60409);
				vd604.setD60410(d60410);
				
				vd604.setD60411(d60411);
				vd604.setD60412(d60412);
				vd604.setD60413(d60413);
				vd604.setD60414(d60414);
				vd604.setD60415(d60415);
				vd604.setD60416(d60416);
				vd604.setD60417(d60417);
				vd604.setD60418(d60418);
				vd604.setD60419(d60419);
				vd604.setD60420(d60420);
				
				vd604.setD60421(d60421);
				vd604.setD60422(d60422);
				vd604.setD60423(d60423);
				vd604.setD60424(d60424);
				vd604.setD60425(d60425);
				vd604.setD60426(d60426);
				vd604.setD60427(d60427);
				vd604.setD60428(d60428);
				vd604.setD60429(d60429);
				vd604.setD60430(d60430);
				
				vd604.setD60431(d60431);
				vd604.setD60432(d60432);
				vd604.setD60433(d60433);
				vd604.setD60434(d60434);
				vd604.setD60435(d60435);
				vd604.setD60436(d60436);
				vd604.setD60437(d60437);
				vd604.setD60438(d60438);
				vd604.setD60439(d60439);
				vd604.setD60440(d60440);
				
				vd604.setD60441(d60441);
				vd604.setD60442(d60442);
				vd604.setD60443(d60443);
				vd604.setD60444(d60444);
				vd604.setD60445(d60445);
				vd604.setD60446(d60446);
				vd604.setD60447(d60447);
				vd604.setD60448(d60448);
				vd604.setD60449(d60449);
				vd604.setD60450(d60450);
				
				vd604.setD60451(d60451);
				vd604.setD60452(d60452);
				vd604.setD60453(d60453);
				vd604.setD60454(d60454);
				vd604.setD60455(d60455);
				vd604.setD60456(d60456);
				vd604.setD60457(d60457);
				vd604.setD60458(d60458);
				vd604.setD60459(d60459);
				vd604.setD60460(d60460);
				
				vd604.setD60461(d60461);
				vd604.setD60462(d60462);
				vd604.setD60463(d60463);
				vd604.setD60464(d60464);
				vd604.setD60465(d60465);
				vd604.setD60466(d60466);
				vd604.setD60467(d60467);
				vd604.setD60468(d60468);
				vd604.setD60469(d60469);
				vd604.setD60470(d60470);
				
				vd604.setD60461(d60471);
				vd604.setD60462(d60472);
				vd604.setD60463(d60473);
				vd604.setD60464(d60474);
				vd604.setD60465(d60475);
				vd604.setD60466(d60476);
				vd604.setD60467(d60477);
				vd604.setD60468(d60478);
				vd604.setD60469(d60479);
				vd604.setD60470(d60480);
				
				vd604.setD60410Zh(d60410Zh);
				vd604.setD60411Zh(d60411Zh);
				vd604.setD60412Zh(d60412Zh);
				vd604.setD60413Zh(d60413Zh);
				vd604.setD60415Zh(d60415Zh);
				vd604.setD60422Zh(d60422Zh);
				vd604.setD60423Zh(d60423Zh);
				vd604.setD60424Zh(d60424Zh);
				vd604.setD60434Zh(d60434Zh);
				vd604.setD60436Zh(d60436Zh);
				vd604.setD60438Zh(d60438Zh);
				vd604.setD60439Zh(d60439Zh);
				vd604.setD60440Zh(d60440Zh);
				vd604.setD60441Zh(d60441Zh);
				vd604.setD60442Zh(d60442Zh);
				vd604.setD60443Zh(d60443Zh);
				vd604.setD60444Zh(d60444Zh);
				vd604.setD60445Zh(d60445Zh);
				vd604.setD60446Zh(d60446Zh);
				vd604.setD60447Zh(d60447Zh);
				vd604.setD60448Zh(d60448Zh);
				vd604.setD60449Zh(d60449Zh);
				vd604.setD60451Zh(d60451Zh);
				vd604.setD60453Zh(d60453Zh);
				
				
				vd604s.add(vd604);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, resultSet);
		}
		return vd604;
	}
	
	public List<VD604> queryListVD604(String d604_11,String date_start, String date_end, ServletContext servletContext) {
		
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		VD604 vd604 = null;
		List<VD604> vd604List = null;
		
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement("select * from v_d604 t where t.D604_11 = ? and t.D604_13 >= to_date(?,'YYYY-MM-DD') and t.D604_13 <= to_date(?,'YYYY-MM-DD')");
			preparedStatement.setString(1, d604_11);
			preparedStatement.setString(2, date_start);
			preparedStatement.setString(3, date_end);
			resultSet = preparedStatement.executeQuery();
			
			vd604List = new ArrayList<VD604>();
			while(resultSet.next()) {
				vd604 = new VD604();
				long d60401 = resultSet.getLong("D604_01");
				long d60402 = resultSet.getLong("D604_02");
				String d60403 = resultSet.getString("D604_03");
				String d60404 = resultSet.getString("D604_04");
				Date d60405 = resultSet.getDate("D604_05");
				String d60406 = resultSet.getString("D604_06");
				String d60407 = resultSet.getString("D604_07");
				String d60408 = resultSet.getString("D604_08");
				Short d60409 = resultSet.getShort("D604_09");
				String d60410 = resultSet.getString("D604_10");
				
				String d60411 = resultSet.getString("D604_11");
				String d60412 = resultSet.getString("D604_12");
				String d60413 = resultSet.getString("D604_13");
				String d60414 = resultSet.getString("D604_14");
				String d60415 = resultSet.getString("D604_15");
				Byte d60416 = resultSet.getByte("D604_16");
				Byte d60417 = resultSet.getByte("D604_17");
				Byte d60418 = resultSet.getByte("D604_18");
				Date d60419 = resultSet.getDate("D604_19");
				Date d60420 = resultSet.getDate("D604_20");
				
				Date d60421 = resultSet.getDate("D604_21");
				String d60422 = resultSet.getString("D604_22");
				String d60423 = resultSet.getString("D604_23");
				String d60424 = resultSet.getString("D604_24");
				String d60425 = resultSet.getString("D604_25");
				String d60426 = resultSet.getString("D604_26");
				String d60427 = resultSet.getString("D604_27");
				Byte d60428 = resultSet.getByte("D604_28");
				Byte d60429 = resultSet.getByte("D604_29");
				String d60430 = resultSet.getString("D604_30");
				
				String d60431 = resultSet.getString("D604_31");
				String d60432 = resultSet.getString("D604_32");
				String d60433 = resultSet.getString("D604_33");
				String d60434 = resultSet.getString("D604_34");
				String d60435 = resultSet.getString("D604_35");
				String d60436 = resultSet.getString("D604_36");
				String d60437 = resultSet.getString("D604_37");
				String d60438 = resultSet.getString("D604_38");
				String d60439 = resultSet.getString("D604_39");
				String d60440 = resultSet.getString("D604_40");
				
				String d60441 = resultSet.getString("D604_41");
				String d60442 = resultSet.getString("D604_42");
				String d60443 = resultSet.getString("D604_43");
				String d60444 = resultSet.getString("D604_44");
				String d60445 = resultSet.getString("D604_45");
				String d60446 = resultSet.getString("D604_46");
				String d60447 = resultSet.getString("D604_47");
				String d60448 = resultSet.getString("D604_48");
				String d60449 = resultSet.getString("D604_49");
				String d60450 = resultSet.getString("D604_50");
				
				String d60451 = resultSet.getString("D604_51");
				String d60452 = resultSet.getString("D604_52");
				Date d60453 = resultSet.getDate("D604_53");
				String d60454 = resultSet.getString("D604_54");
				String d60455 = resultSet.getString("D604_55");
				String d60456 = resultSet.getString("D604_56");
				String d60457 = resultSet.getString("D604_57");
				String d60458 = resultSet.getString("D604_58");
				String d60459 = resultSet.getString("D604_59");
				String d60460 = resultSet.getString("D604_60");
				
				String d60461 = resultSet.getString("D604_61");
				String d60462 = resultSet.getString("D604_62");
				String d60463 = resultSet.getString("D604_63");
				String d60464 = resultSet.getString("D604_64");
				String d60465 = resultSet.getString("D604_65");
				String d60466 = resultSet.getString("D604_66");
				String d60467 = resultSet.getString("D604_67");
				String d60468 = resultSet.getString("D604_68");
				String d60469 = resultSet.getString("D604_69");
				String d60470 = resultSet.getString("D604_70");
				
				String d60471 = resultSet.getString("D604_71");
				String d60472 = resultSet.getString("D604_72");
				String d60473 = resultSet.getString("D604_73");
				String d60474 = resultSet.getString("D604_74");
				String d60475 = resultSet.getString("D604_75");
				String d60476 = resultSet.getString("D604_76");
				String d60477 = resultSet.getString("D604_77");
				String d60478 = resultSet.getString("D604_78");
				String d60479 = resultSet.getString("D604_79");
				String d60480 = resultSet.getString("D604_80");
				
				String d60410Zh = resultSet.getString("D604_10_ZH");
				String d60411Zh = resultSet.getString("D604_11_ZH");
				String d60412Zh = resultSet.getString("D604_12_ZH");
				String d60413Zh = resultSet.getString("D604_13_ZH");
				String d60415Zh = resultSet.getString("D604_15_ZH");
				String d60419Zh = resultSet.getString("D604_19_ZH");
				String d60422Zh = resultSet.getString("D604_20_ZH");
				String d60420Zh = resultSet.getString("D604_21_ZH");
				String d60421Zh = resultSet.getString("D604_22_ZH");
				String d60423Zh = resultSet.getString("D604_23_ZH");
				String d60424Zh = resultSet.getString("D604_24_ZH");
				String d60434Zh = resultSet.getString("D604_34_ZH");
				String d60436Zh = resultSet.getString("D604_36_ZH");
				String d60438Zh = resultSet.getString("D604_38_ZH");
				String d60439Zh = resultSet.getString("D604_39_ZH");
				String d60440Zh = resultSet.getString("D604_40_ZH");
				String d60441Zh = resultSet.getString("D604_41_ZH");
				String d60442Zh = resultSet.getString("D604_42_ZH");
				String d60443Zh = resultSet.getString("D604_43_ZH");
				String d60444Zh = resultSet.getString("D604_44_ZH");
				String d60445Zh = resultSet.getString("D604_45_ZH");
				String d60446Zh = resultSet.getString("D604_46_ZH");
				String d60447Zh = resultSet.getString("D604_47_ZH");
				String d60448Zh = resultSet.getString("D604_48_ZH");
				String d60449Zh = resultSet.getString("D604_49_ZH");
				
				vd604.setD60401(d60401);
				vd604.setD60402(d60402);
				vd604.setD60403(d60403);
				vd604.setD60404(d60404);
				vd604.setD60405(d60405);
				vd604.setD60406(d60406);
				vd604.setD60407(d60407);
				vd604.setD60408(d60408);
				vd604.setD60409(d60409);
				vd604.setD60410(d60410);
				
				vd604.setD60411(d60411);
				vd604.setD60412(d60412);
				vd604.setD60413(d60413);
				vd604.setD60414(d60414);
				vd604.setD60415(d60415);
				vd604.setD60416(d60416);
				vd604.setD60417(d60417);
				vd604.setD60418(d60418);
				vd604.setD60419(d60419);
				vd604.setD60420(d60420);
				
				vd604.setD60421(d60421);
				vd604.setD60422(d60422);
				vd604.setD60423(d60423);
				vd604.setD60424(d60424);
				vd604.setD60425(d60425);
				vd604.setD60426(d60426);
				vd604.setD60427(d60427);
				vd604.setD60428(d60428);
				vd604.setD60429(d60429);
				vd604.setD60430(d60430);
				
				vd604.setD60431(d60431);
				vd604.setD60432(d60432);
				vd604.setD60433(d60433);
				vd604.setD60434(d60434);
				vd604.setD60435(d60435);
				vd604.setD60436(d60436);
				vd604.setD60437(d60437);
				vd604.setD60438(d60438);
				vd604.setD60439(d60439);
				vd604.setD60440(d60440);
				
				vd604.setD60441(d60441);
				vd604.setD60442(d60442);
				vd604.setD60443(d60443);
				vd604.setD60444(d60444);
				vd604.setD60445(d60445);
				vd604.setD60446(d60446);
				vd604.setD60447(d60447);
				vd604.setD60448(d60448);
				vd604.setD60449(d60449);
				vd604.setD60450(d60450);
				
				vd604.setD60451(d60451);
				vd604.setD60452(d60452);
				vd604.setD60453(d60453);
				vd604.setD60454(d60454);
				vd604.setD60455(d60455);
				vd604.setD60456(d60456);
				vd604.setD60457(d60457);
				vd604.setD60458(d60458);
				vd604.setD60459(d60459);
				vd604.setD60460(d60460);
				
				vd604.setD60461(d60461);
				vd604.setD60462(d60462);
				vd604.setD60463(d60463);
				vd604.setD60464(d60464);
				vd604.setD60465(d60465);
				vd604.setD60466(d60466);
				vd604.setD60467(d60467);
				vd604.setD60468(d60468);
				vd604.setD60469(d60469);
				vd604.setD60470(d60470);
				
				vd604.setD60461(d60471);
				vd604.setD60462(d60472);
				vd604.setD60463(d60473);
				vd604.setD60464(d60474);
				vd604.setD60465(d60475);
				vd604.setD60466(d60476);
				vd604.setD60467(d60477);
				vd604.setD60468(d60478);
				vd604.setD60469(d60479);
				vd604.setD60470(d60480);
				
				vd604.setD60410Zh(d60410Zh);
				vd604.setD60411Zh(d60411Zh);
				vd604.setD60412Zh(d60412Zh);
				vd604.setD60413Zh(d60413Zh);
				vd604.setD60415Zh(d60415Zh);
				vd604.setD60419Zh(d60419Zh);
				vd604.setD60420Zh(d60420Zh);
				vd604.setD60421Zh(d60421Zh);
				vd604.setD60422Zh(d60422Zh);
				vd604.setD60423Zh(d60423Zh);
				vd604.setD60424Zh(d60424Zh);
				vd604.setD60434Zh(d60434Zh);
				vd604.setD60436Zh(d60436Zh);
				vd604.setD60438Zh(d60438Zh);
				vd604.setD60439Zh(d60439Zh);
				vd604.setD60440Zh(d60440Zh);
				vd604.setD60441Zh(d60441Zh);
				vd604.setD60442Zh(d60442Zh);
				vd604.setD60443Zh(d60443Zh);
				vd604.setD60444Zh(d60444Zh);
				vd604.setD60445Zh(d60445Zh);
				vd604.setD60446Zh(d60446Zh);
				vd604.setD60447Zh(d60447Zh);
				vd604.setD60448Zh(d60448Zh);
				vd604.setD60449Zh(d60449Zh);
				
				vd604List.add(vd604);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, resultSet);
		}
		return vd604List;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return age;
	}

}
