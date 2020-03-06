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

import com.xyw.medical.birth.model.VD305;

public class CsyxzmBfDJBService {

	private DataSource dataSource;
	
	public VD305 queryVD305(String d305_02,String d305_34,ServletContext servletContext){
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from v_d305 t where t.d305_02 = ? and t.d305_34 = ?");
		VD305 vd305 = null;
		try{
			connection = this.dataSource.getConnection();
			
			preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setString(1, d305_02);
			preparedStatement.setString(2, d305_34);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				vd305 = new VD305();
				long d30501 = resultSet.getLong("D305_01");
				String d30502 = resultSet.getString("D305_02");
				String d30503 = resultSet.getString("D305_03");
				String d30503_Zh = resultSet.getString("D305_03_ZH");
				String d30504 = resultSet.getString("D305_04");
				String d30505 = resultSet.getString("D305_05");
				int d30506 = resultSet.getInt("D305_06");
				int d30507 = resultSet.getInt("D305_07");
				double d30508 = resultSet.getDouble("D305_08");
				double d30509 = resultSet.getDouble("D305_09");
				String d30510 = resultSet.getString("D305_10");
				String d30511 = resultSet.getString("D305_11");
				String d30511_Zh = resultSet.getString("D305_11_ZH");
				String d30512 = resultSet.getString("D305_12");
				Date d30513 = resultSet.getDate("D305_13");
				String d30514 = resultSet.getString("D305_14");
				String d30515 = resultSet.getString("D305_15");
				String d30516 = resultSet.getString("D305_16");
				String d30517 = resultSet.getString("D305_17");
				String d30517_Zh = resultSet.getString("D305_17_Zh");
				String d30518 = resultSet.getString("D305_18");
				String d30519 = resultSet.getString("D305_19");
				String d30519_Zh = resultSet.getString("D305_19_ZH");
				String d30520 = resultSet.getString("D305_20");
				String d30520_Zh = resultSet.getString("D305_20_ZH");
				String d30521 = resultSet.getString("D305_21");
				String d30522 = resultSet.getString("D305_22");
				String d30523 = resultSet.getString("D305_23");
				String d30523_Zh = resultSet.getString("D305_23_ZH");
				String d30524 = resultSet.getString("D305_24");
				String d30525 = resultSet.getString("D305_25");
				String d30525_Zh = resultSet.getString("D305_25_ZH");
				String d30526 = resultSet.getString("D305_26");
				String d30526_Zh = resultSet.getString("D305_26_ZH");
				String d30527 = resultSet.getString("D305_27");
				String d30528 = resultSet.getString("D305_28");
				String d30529 = resultSet.getString("D305_29");
				String d30529_Zh = resultSet.getString("D305_29_ZH");
				String d30530 = resultSet.getString("D305_30");
				String d30530_Zh = resultSet.getString("D305_30_ZH");
				String d30531 = resultSet.getString("D305_31");
				String d30532 = resultSet.getString("D305_32");
				String d30532_Zh = resultSet.getString("D305_32_ZH");
				String d30533 = resultSet.getString("D305_33");
				String d30534 = resultSet.getString("D305_34");
				Date d30535 = resultSet.getDate("D305_35");
				String d30536 = resultSet.getString("D305_36");
				String d30536_Zh = resultSet.getString("D305_36_ZH");
				Date d30537 = resultSet.getDate("D305_37");
				String d30538 = resultSet.getString("D305_38");
				String d30538_Zh = resultSet.getString("D305_38_ZH");
				
				vd305.setD30501(d30501);
				vd305.setD30502(d30502);
				vd305.setD30503(d30503);
				vd305.setD30503_Zh(d30503_Zh);
				vd305.setD30504(d30504);
				vd305.setD30505(d30505);
				vd305.setD30506(d30506);
				vd305.setD30507(d30507);
				vd305.setD30508(d30508);
				vd305.setD30509(d30509);
				vd305.setD30510(d30510);
				vd305.setD30511(d30511);
				vd305.setD30511_Zh(d30511_Zh);
				vd305.setD30512(d30512);
				String d30513_str = simpleDateFormat.format(d30513);
				vd305.setD30513(d30513_str);
				vd305.setD30514(d30514);
				vd305.setD30515(d30515);
				vd305.setD30516(d30516);
				vd305.setD30517(d30517);
				vd305.setD30517_Zh(d30517_Zh);
				vd305.setD30518(d30518);
				vd305.setD30519(d30519);
				vd305.setD30519_Zh(d30519_Zh);
				vd305.setD30520(d30520);
				vd305.setD30520_Zh(d30520_Zh);
				vd305.setD30521(d30521);
				vd305.setD30522(d30522);
				vd305.setD30523(d30523);
				vd305.setD30523_Zh(d30523_Zh);
				vd305.setD30524(d30524);
				vd305.setD30525(d30525);
				vd305.setD30525_Zh(d30525_Zh);
				vd305.setD30526(d30526);
				vd305.setD30526_Zh(d30526_Zh);
				vd305.setD30527(d30527);
				vd305.setD30528(d30528);
				vd305.setD30529(d30529);
				vd305.setD30529_Zh(d30529_Zh);
				vd305.setD30530(d30530);
				vd305.setD30530_Zh(d30530_Zh);
				vd305.setD30531(d30531);
				vd305.setD30532(d30532);
				vd305.setD30532_Zh(d30532_Zh);
				vd305.setD30533(d30533);
				vd305.setD30534(d30534);
				String d30535_str = simpleDateFormat.format(d30535);
				vd305.setD30535(d30535_str);
				vd305.setD30536(d30536);
				vd305.setD30536_Zh(d30536_Zh);
				String d30537_str = simpleDateFormat.format(d30537);
				vd305.setD30537(d30537_str);
				vd305.setD30538(d30538);
				vd305.setD30538_Zh(d30538_Zh);
				
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally
		{
			this.close(connection, preparedStatement, resultSet);
		}
		
		return vd305;
	}
	public List<VD305> queryListVD305(String d305_36, String date_start,String date_end,ServletContext servletContext){
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from v_d305 t where t.D305_36 like ? and t.D305_37 >= to_date(?,'YYYY-MM-DD') and t.D305_37 <= to_date(?,'YYYY-MM-DD')");
		VD305 vd305 = null;
		List<VD305> vd305s = new ArrayList<VD305>();
		try{
			connection = this.dataSource.getConnection();
			
			preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setString(1, "%" + d305_36 + "%");
			preparedStatement.setString(2, date_start);
			preparedStatement.setString(3, date_end);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				vd305 = new VD305();
				long d30501 = resultSet.getLong("D305_01");
				String d30502 = resultSet.getString("D305_02");
				String d30503 = resultSet.getString("D305_03");
				String d30503_Zh = resultSet.getString("D305_03_ZH");
				Date d30504 = resultSet.getDate("D305_04");
				String d30505 = resultSet.getString("D305_05");
				String d30505_Zhx = resultSet.getString("D305_05_ZHx");
				int d30506 = resultSet.getInt("D305_06");
				int d30507 = resultSet.getInt("D305_07");
				double d30508 = resultSet.getDouble("D305_08");
				double d30509 = resultSet.getDouble("D305_09");
				String d30510 = resultSet.getString("D305_10");
				String d30511 = resultSet.getString("D305_11");
				String d30511_Zh = resultSet.getString("D305_11_ZH");
				String d30512 = resultSet.getString("D305_12");
				Date d30513 = resultSet.getDate("D305_13");
				String d30514 = resultSet.getString("D305_14");
				String d30515 = resultSet.getString("D305_15");
				String d30516 = resultSet.getString("D305_16");
				String d30517 = resultSet.getString("D305_17");
				String d30517_Zh = resultSet.getString("D305_17_Zh");
				String d30518 = resultSet.getString("D305_18");
				String d30519 = resultSet.getString("D305_19");
				String d30519_Zh = resultSet.getString("D305_19_ZH");
				String d30520 = resultSet.getString("D305_20");
				String d30520_Zh = resultSet.getString("D305_20_ZH");
				String d30521 = resultSet.getString("D305_21");
				String d30522 = resultSet.getString("D305_22");
				String d30523 = resultSet.getString("D305_23");
				String d30523_Zh = resultSet.getString("D305_23_ZH");
				String d30524 = resultSet.getString("D305_24");
				String d30525 = resultSet.getString("D305_25");
				String d30525_Zh = resultSet.getString("D305_25_ZH");
				String d30526 = resultSet.getString("D305_26");
				String d30526_Zh = resultSet.getString("D305_26_ZH");
				String d30527 = resultSet.getString("D305_27");
				String d30528 = resultSet.getString("D305_28");
				String d30529 = resultSet.getString("D305_29");
				String d30529_Zh = resultSet.getString("D305_29_ZH");
				String d30530 = resultSet.getString("D305_30");
				String d30530_Zh = resultSet.getString("D305_30_ZH");
				String d30531 = resultSet.getString("D305_31");
				String d30532 = resultSet.getString("D305_32");
				String d30532_Zh = resultSet.getString("D305_32_ZH");
				String d30533 = resultSet.getString("D305_33");
				String d30534 = resultSet.getString("D305_34");
				Date d30535 = resultSet.getDate("D305_35");
				String d30536 = resultSet.getString("D305_36");
				String d30536_Zh = resultSet.getString("D305_36_ZH");
				Date d30537 = resultSet.getDate("D305_37");
				String d30538 = resultSet.getString("D305_38");
				String d30538_Zh = resultSet.getString("D305_38_ZH");
				String d30540 = resultSet.getString("D305_40");
				Date d30541 = resultSet.getDate("D305_41");
				
				vd305.setD30501(d30501);
				vd305.setD30502(d30502);
				vd305.setD30503(d30503);
				vd305.setD30503_Zh(d30503_Zh);
				String d30504_str = simpleDateFormat.format(d30504);
				vd305.setD30504(d30504_str);
				vd305.setD30505(d30505);
				vd305.setD30505_Zhx(d30505_Zhx);
				vd305.setD30506(d30506);
				vd305.setD30507(d30507);
				vd305.setD30508(d30508);
				vd305.setD30509(d30509);
				vd305.setD30510(d30510);
				vd305.setD30511(d30511);
				vd305.setD30511_Zh(d30511_Zh);
				vd305.setD30512(d30512);
				String d30513_str = simpleDateFormat.format(d30513);
				vd305.setD30513(d30513_str);
				vd305.setD30514(d30514);
				vd305.setD30515(d30515);
				vd305.setD30516(d30516);
				vd305.setD30517(d30517);
				vd305.setD30517_Zh(d30517_Zh);
				vd305.setD30518(d30518);
				vd305.setD30519(d30519);
				vd305.setD30519_Zh(d30519_Zh);
				vd305.setD30520(d30520);
				vd305.setD30520_Zh(d30520_Zh);
				vd305.setD30521(d30521);
				vd305.setD30522(d30522);
				vd305.setD30523(d30523);
				vd305.setD30523_Zh(d30523_Zh);
				vd305.setD30524(d30524);
				vd305.setD30525(d30525);
				vd305.setD30525_Zh(d30525_Zh);
				vd305.setD30526(d30526);
				vd305.setD30526_Zh(d30526_Zh);
				vd305.setD30527(d30527);
				vd305.setD30528(d30528);
				vd305.setD30529(d30529);
				vd305.setD30529_Zh(d30529_Zh);
				vd305.setD30530(d30530);
				vd305.setD30530_Zh(d30530_Zh);
				vd305.setD30531(d30531);
				vd305.setD30532(d30532);
				vd305.setD30532_Zh(d30532_Zh);
				vd305.setD30533(d30533);
				vd305.setD30534(d30534);
				String d30535_str = simpleDateFormat.format(d30535);
				vd305.setD30535(d30535_str);
				vd305.setD30536(d30536);
				vd305.setD30536_Zh(d30536_Zh);
				String d30537_str = simpleDateFormat.format(d30537);
				vd305.setD30537(d30537_str);
				vd305.setD30538(d30538);
				vd305.setD30538_Zh(d30538_Zh);
				vd305.setD30540(d30540);
				if(d30541 != null){
					String d30541_str = simpleDateFormat.format(d30541);
					vd305.setD30541(d30541_str);
				}
				
				vd305s.add(vd305);
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally
		{
			this.close(connection, preparedStatement, resultSet);
		}
		
		return vd305s;
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
