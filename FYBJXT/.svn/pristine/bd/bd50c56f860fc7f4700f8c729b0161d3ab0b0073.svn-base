package com.xyw.medical.birth.report.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.birth.model.VD307;

public class CsyxzmqfsqbService {
	private DataSource dataSource;
	
	public VD307 queryVD307(String d307_01,ServletContext servletContext){
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		VD307 vd307 = null;
		
		StringBuffer sql = new StringBuffer("select * from v_d307 t where 1=1 ");
		if(d307_01 != null){
			sql.append(" and t.D307_01 ="+d307_01 );
		}
//		if(d307_06 != null){
//			sql.append(" and t.D307_06 ='"+d307_06+"'" );
//		}
//		if(d307_08 != null){
//			sql.append(" and t.D307_08 ='"+d307_08+"'" );
//		}
		
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			resultSet = preparedStatement.executeQuery();
			vd307 = new VD307();
			
			while (resultSet.next()) {
				long d30701 =resultSet.getLong("D307_01");
				String d30702 =resultSet.getString("D307_02");
				String d30703 =resultSet.getString("D307_03");
				Date d30704 =resultSet.getDate("D307_04");
				String d30705 =resultSet.getString("D307_05");
				String d30706 =resultSet.getString("D307_06");
				String d30707 =resultSet.getString("D307_07");
				String d30708 =resultSet.getString("D307_08");
				String d30709 =resultSet.getString("D307_09");
				String d30710 =resultSet.getString("D307_10");
				String d30711 =resultSet.getString("D307_11");
				String d30712 =resultSet.getString("D307_12");
				String d30713 =resultSet.getString("D307_13");
				String d30714 =resultSet.getString("D307_14");
				String d30715 =resultSet.getString("D307_15");
				String d30716 =resultSet.getString("D307_16");
				String d30717 =resultSet.getString("D307_17");
				String d30718 =resultSet.getString("D307_18");
				String d30719 =resultSet.getString("D307_19");
				String d30720 =resultSet.getString("D307_20");
				String d30721 =resultSet.getString("D307_21");
				String d30722 =resultSet.getString("D307_22");
				Date d30723 =resultSet.getDate("D307_23");
				String d30724 =resultSet.getString("D307_24");
				String d30725 =resultSet.getString("D307_25");
				String d30726 =resultSet.getString("D307_26");
				String d30727 =resultSet.getString("D307_27");
				String d30728 =resultSet.getString("D307_28");
				String d30729 =resultSet.getString("D307_29");
				String d30730 =resultSet.getString("D307_30");
				String d30731 =resultSet.getString("D307_31");
				String d30732 =resultSet.getString("D307_32");
				String d30733 =resultSet.getString("D307_33");
				String d30734 =resultSet.getString("D307_34");
				String d30735 =resultSet.getString("D307_35");
				String d30736 =resultSet.getString("D307_36");
				String d30737 =resultSet.getString("D307_37");
				String d30738 =resultSet.getString("D307_38");
				String d30739 =resultSet.getString("D307_39");
				String d30740 =resultSet.getString("D307_40");
				String d30741 =resultSet.getString("D307_41");
				String d30742 =resultSet.getString("D307_42");
				String d30743 =resultSet.getString("D307_43");
				String d30744 =resultSet.getString("D307_44");
				String d30745 =resultSet.getString("D307_45");
				String d30746 =resultSet.getString("D307_46");
				String d30747 =resultSet.getString("D307_47");
				String d30748 =resultSet.getString("D307_48");
				String d30749 =resultSet.getString("D307_49");
				String d30750 =resultSet.getString("D307_50");
				
				String d30704Str =resultSet.getString("D307_04_Str");
				String d30723Str =resultSet.getString("D307_23_Str");
				String d30703Zh =resultSet.getString("D307_03_ZH");
				String d30705Zh =resultSet.getString("D307_05_ZH");
				String d30707Zh =resultSet.getString("D307_07_ZH");
				String d30709Zh =resultSet.getString("D307_09_ZH");
				String d30710Zh =resultSet.getString("D307_10_ZH");
				String d30713Zh =resultSet.getString("D307_13_ZH");
				String d30715Zh =resultSet.getString("D307_15_ZH");
				String d30716Zh =resultSet.getString("D307_16_ZH");
				String d30719Zh =resultSet.getString("D307_19_ZH");
				String d30720Zh =resultSet.getString("D307_20_ZH");
				String d30724Zh =resultSet.getString("D307_24_ZH");
				
				vd307.setD30701(d30701);
				vd307.setD30702(d30702);
				vd307.setD30703(d30703);
				vd307.setD30704(d30704);
				vd307.setD30705(d30705);
				vd307.setD30706(d30706);
				vd307.setD30707(d30707);
				vd307.setD30708(d30708);
				vd307.setD30709(d30709);
				vd307.setD30710(d30710);
				vd307.setD30711(d30711);
				vd307.setD30712(d30712);
				vd307.setD30713(d30713);
				vd307.setD30714(d30714);
				vd307.setD30715(d30715);
				vd307.setD30716(d30716);
				vd307.setD30717(d30717);
				vd307.setD30718(d30718);
				vd307.setD30719(d30719);
				vd307.setD30720(d30720);
				vd307.setD30721(d30721);
				vd307.setD30722(d30722);
				vd307.setD30723(d30723);
				vd307.setD30724(d30724);
				vd307.setD30725(d30725);
				vd307.setD30726(d30726);
				vd307.setD30727(d30727);
				vd307.setD30728(d30728);
				vd307.setD30729(d30729);
				vd307.setD30730(d30730);
				vd307.setD30731(d30731);
				vd307.setD30732(d30732);
				vd307.setD30733(d30733);
				vd307.setD30734(d30734);
				vd307.setD30735(d30735);
				vd307.setD30736(d30736);
				vd307.setD30737(d30737);
				vd307.setD30738(d30738);
				vd307.setD30739(d30739);
				vd307.setD30740(d30740);
				vd307.setD30741(d30741);
				vd307.setD30742(d30742);
				vd307.setD30743(d30743);
				vd307.setD30744(d30744);
				vd307.setD30745(d30745);
				vd307.setD30746(d30746);
				vd307.setD30747(d30747);
				vd307.setD30748(d30748);
				vd307.setD30749(d30749);
				vd307.setD30750(d30750);

				vd307.setD30704Str(d30704Str);
				vd307.setD30723Str(d30723Str);
				vd307.setD30703Zh(d30703Zh);
				vd307.setD30705Zh(d30705Zh);
				vd307.setD30707Zh(d30707Zh);
				vd307.setD30709Zh(d30709Zh);
				vd307.setD30710Zh(d30710Zh);
				vd307.setD30713Zh(d30713Zh);
				vd307.setD30715Zh(d30715Zh);
				vd307.setD30716Zh(d30716Zh);
				vd307.setD30719Zh(d30719Zh);
				vd307.setD30720Zh(d30720Zh);
				vd307.setD30724Zh(d30724Zh);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, resultSet);
		}
		return vd307;
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

