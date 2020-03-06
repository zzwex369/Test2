package com.xyw.medical.birth.report.service;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.util.List;
import javax.servlet.ServletContext;
//import javax.sql.DataSource;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
import com.xyw.medical.birth.model.VD302;

public class CertificateChangeService {
	
	//private DataSource dataSource;
	
	public List<VD302> queryD302(String d302_26,String date_start,String date_end,ServletContext servletContext)
	{
		/*
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from v_d302 t where t.D302_26 like ? and t.D302_28 >= to_date(?,'YYYY-MM-DD') and t.D302_28 <= to_date(?,'YYYY-MM-DD')";
		
		List<VD302> listVD302 = null;
		VD302 vd302 = null;
		try{
			connection = this.dataSource.getConnection();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, d302_26 + "%");
			preparedStatement.setString(2, date_start);
			preparedStatement.setString(3, date_end);
			
			resultSet = preparedStatement.executeQuery();
			listVD302 = new ArrayList<VD302>();
			
			
			while(resultSet.next())
			{
				vd302 = new VD302();
				long d30201 = resultSet.getLong("D302_01");
				String d30202 = resultSet.getString("D302_02");
				String d30203 = resultSet.getString("D302_03");
				String d30203Zh = resultSet.getString("D302_03_ZH");
				String d30204 = resultSet.getString("D302_04");
				String d30205 = resultSet.getString("D302_05");
				String d30205Zh = resultSet.getString("D302_05_ZH");
				String d30206 = resultSet.getString("D302_06");
				int d30207 = resultSet.getInt("D302_07");
				double d30208 = resultSet.getDouble("D302_08");
				String d30209 = resultSet.getString("D302_09");
				String d30209Zh = resultSet.getString("D302_09_ZH");
				String d30210 = resultSet.getString("D302_10");
				String d30211 = resultSet.getString("D302_11");
				String d30212 = resultSet.getString("D302_12");
				String d30213 = resultSet.getString("D302_13");
				String d30214 = resultSet.getString("D302_14");
				String d30214Zh = resultSet.getString("D302_14_ZH");
				String d30215 = resultSet.getString("D302_15");
				String d30215Zh = resultSet.getString("D302_15_ZH");
				String d30216 = resultSet.getString("D302_16");
				String d30217 = resultSet.getString("D302_17");
				String d30218 = resultSet.getString("D302_18");
				String d30219 = resultSet.getString("D302_19");
				String d30219Zh = resultSet.getString("D302_19_ZH");
				String d30220 = resultSet.getString("D302_20");
				String d30220Zh = resultSet.getString("D302_20_ZH");
				String d30221 = resultSet.getString("D302_21");
				String d30222 = resultSet.getString("D302_22");
				String d30222Zh = resultSet.getString("D302_22_ZH");
				String d30223 = resultSet.getString("D302_23");
				String d30224 = resultSet.getString("D302_24");
				String d30224Zh = resultSet.getString("D302_24_ZH");
				String d30225 = resultSet.getString("D302_25");
				String d30226 = resultSet.getString("D302_26");
				String d30226Zh = resultSet.getString("D302_26_ZH");
				String d30227 = resultSet.getString("D302_27");
				String d30228 = resultSet.getString("D302_28");
				double d30229 = resultSet.getDouble("D302_29");
				String d30230 = resultSet.getString("D302_30");
				String d30231 = resultSet.getString("D302_31");
				String d30232 = resultSet.getString("D302_32");
				String d30232Zh = resultSet.getString("D302_32_ZH");
				String d30233 = resultSet.getString("D302_33");
				String d30233Zh = resultSet.getString("D302_33_ZH");
				String d30234 = resultSet.getString("D302_34");
				String d30235 = resultSet.getString("D302_35");
				String d30236 = resultSet.getString("D302_36");
				String d30237 = resultSet.getString("D302_37");
				String d30238 = resultSet.getString("D302_38");
				String d30239 = resultSet.getString("D302_39");
				String d30240 = resultSet.getString("D302_40");
				String d30241 = resultSet.getString("D302_41");
				String d30242 = resultSet.getString("D302_42");
				String d30243 = resultSet.getString("D302_43");
				String d30243Zh = resultSet.getString("D302_43_ZH");
				
				vd302.setD30201(d30201);
				vd302.setD30202(d30202);
				vd302.setD30203(d30203);
				vd302.setD30203Zh(d30203Zh);
				vd302.setD30204(d30204.substring(0, 16));
				vd302.setD30205(d30205);
				vd302.setD30205Zh(d30205Zh);
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
				vd302.setD30222(d30222);
				vd302.setD30222Zh(d30222Zh);
				vd302.setD30223(d30223);
				vd302.setD30224(d30224);
				vd302.setD30224Zh(d30224Zh);
				vd302.setD30225(d30225);
				vd302.setD30226(d30226);
				vd302.setD30226Zh(d30226Zh);
				vd302.setD30227(d30227);
				vd302.setD30228(d30228.substring(0, 10));
				vd302.setD30229(d30229);
				vd302.setD30230(d30230);
				vd302.setD30231(d30231);
				vd302.setD30232(d30232);
				vd302.setD30232Zh(d30232Zh);
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
				vd302.setD30243Zh(d30243Zh);
				
				listVD302.add(vd302);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			this.close(connection, preparedStatement, resultSet);
		}
		
		return listVD302;
		*/
		return null;
	}
	
	/*private void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
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
	}*/
}
