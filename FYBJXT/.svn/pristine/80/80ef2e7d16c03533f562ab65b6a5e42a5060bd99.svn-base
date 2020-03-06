package com.xyw.medical.birth.report.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.birth.model.VD303;

public class CertificateReplaceService {
	private DataSource dataSource;
	
	public List<VD303> queryVD303(String d303_26,String date_start,String date_end,ServletContext servletContext)
	{
		
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from v_d303 t where t.D303_26 like ? and t.D303_28 >= to_date(?,'YYYY-MM-DD') and t.D303_28 <= to_date(?,'YYYY-MM-DD')";
		
		List<VD303> listVD303 = null;
		VD303 vd303 = null;
		try{
			connection = this.dataSource.getConnection();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, d303_26+ "%");
			preparedStatement.setString(2, date_start);
			preparedStatement.setString(3, date_end);
			
			resultSet = preparedStatement.executeQuery();
			listVD303 = new ArrayList<VD303>();
			
			while(resultSet.next())
			{
				vd303 = new VD303();
				long d30301 = resultSet.getLong("D303_01");
				String d30302 = resultSet.getString("D303_02");
				String d30303 = resultSet.getString("D303_03");
				String d30303Zh = resultSet.getString("D303_03_ZH");
				String d30304_ = resultSet.getString("D303_04");
				String d30304 = d30304_.substring(0, 16);
				String d30305 = resultSet.getString("D303_05");
				String d30305Zh = resultSet.getString("D303_05_ZH");
				String d30306 = resultSet.getString("D303_06");
				int d30307 = resultSet.getInt("D303_07");
				double d30308 = resultSet.getDouble("D303_08");
				String d30309 = resultSet.getString("D303_09");
				String d30309Zh = resultSet.getString("D303_09_ZH");
				String d30310 = resultSet.getString("D303_10");
				String d30311 = resultSet.getString("D303_11");
				String d30312 = resultSet.getString("D303_12");
				String d30313 = resultSet.getString("D303_13");
				String d30314 = resultSet.getString("D303_14");
				String d30314Zh = resultSet.getString("D303_14_ZH");
				String d30315 = resultSet.getString("D303_15");
				String d30315Zh = resultSet.getString("D303_15_ZH");
				String d30316 = resultSet.getString("D303_16");
				String d30317 = resultSet.getString("D303_17");
				String d30318 = resultSet.getString("D303_18");
				String d30319 = resultSet.getString("D303_19");
				String d30319Zh = resultSet.getString("D303_19_ZH");
				String d30320 = resultSet.getString("D303_20");
				String d30320Zh = resultSet.getString("D303_20_ZH");
				String d30321 = resultSet.getString("D303_21");
				String d30322 = resultSet.getString("D303_22");
				String d30322Zh = resultSet.getString("D303_22_ZH");
				String d30323 = resultSet.getString("D303_23");
				String d30324 = resultSet.getString("D303_24");
				String d30324Zh = resultSet.getString("D303_24_ZH");
				String d30325 = resultSet.getString("D303_25");
				String d30326 = resultSet.getString("D303_26");
				String d30326Zh = resultSet.getString("D303_26_ZH");
				String d30327 = resultSet.getString("D303_27");
				String d30328_ = resultSet.getString("D303_28");
				String d30328 = d30328_.substring(0, 10);
				double d30329 = resultSet.getDouble("D303_29");
				String d30330 = resultSet.getString("D303_30");
				String d30331 = resultSet.getString("D303_31");
				String d30332 = resultSet.getString("D303_32");
				String d30332Zh = resultSet.getString("D303_32_ZH");
				String d30333 = resultSet.getString("D303_33");
				String d30333Zh = resultSet.getString("D303_33_ZH");
				String d30334 = resultSet.getString("D303_34");
				String d30335 = resultSet.getString("D303_35");
				String d30336 = resultSet.getString("D303_36");
				String d30337 = resultSet.getString("D303_37");
				String d30338 = resultSet.getString("D303_38");
				String d30339 = resultSet.getString("D303_39");
				String d30340 = resultSet.getString("D303_40");
				String d30341 = resultSet.getString("D303_41");
				String d30342 = resultSet.getString("D303_42");
				String d30343Zh = resultSet.getString("D303_43_ZH");
				
				vd303.setD30301(d30301);
				vd303.setD30302(d30302);
				vd303.setD30303(d30303);
				vd303.setD30303Zh(d30303Zh);
				vd303.setD30304(d30304);
				vd303.setD30305(d30305);
				vd303.setD30305Zh(d30305Zh);
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
				vd303.setD30332Zh(d30332Zh);
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
				vd303.setD30343Zh(d30343Zh);
				
				listVD303.add(vd303);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			this.close(connection, preparedStatement, resultSet);
		}
		
		return listVD303;
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
