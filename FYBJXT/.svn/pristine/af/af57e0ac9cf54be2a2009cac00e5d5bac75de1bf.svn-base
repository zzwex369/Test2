package com.xyw.medical.birth.report.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.birth.model.VD401;

public class CertificateAbandService {
	private DataSource dataSource;
	
	public List<VD401> queryVD401(String d401_12,String date_start,String date_end,String flag,ServletContext servletContext)
	{
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from v_d401 t where t.D401_12 like ? and t.D401_08 >= to_date(?,'YYYY-MM-DD') and t.D401_08 <= to_date(?,'YYYY-MM-DD')");
		if("print".equals(flag) || "printExcel".equals(flag))
		{
			sql.append(" and t.d401_06 in (1,2)");
		}else if("lose".equals(flag) || "loseExcel".equals(flag))
		{
			sql.append(" and t.d401_06 not in (1,2)");
		}
		sql.append(" order by t.D401_10_ZH,t.D401_08");
		List<VD401> listVD401 = null;
		VD401 vd401 = null;
		try{
			connection = this.dataSource.getConnection();
			
			preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setString(1, "%"+d401_12+"%" );
			preparedStatement.setString(2, date_start);
			preparedStatement.setString(3, date_end);
			resultSet = preparedStatement.executeQuery();
			listVD401 = new ArrayList<VD401>();
			while(resultSet.next())
			{
				vd401 = new VD401();
				long d40101 = resultSet.getLong("D401_01");
				String d40102 = resultSet.getString("D401_02");
				String d40103 = resultSet.getString("D401_03");
				//String d40103Zh = resultSet.getString("D401_03_ZH");
				Date d40104 = resultSet.getDate("D401_04");
				String d40105 = resultSet.getString("D401_05");
				String d40106 = resultSet.getString("D401_06");
				String d40106Zh = resultSet.getString("D401_06_ZH");
				String d40107 = resultSet.getString("D401_07");
				Date d40108 = resultSet.getDate("D401_08");
				String d40109 = resultSet.getString("D401_09");
				String d40110 = resultSet.getString("D401_10");
				String d40110Zh = resultSet.getString("D401_10_ZH");
				String d40111 = resultSet.getString("D401_11");
				String d40112 = resultSet.getString("D401_12");
				String d40112Zh = resultSet.getString("D401_12_ZH");
				String d40113 = resultSet.getString("D401_13");
				String d40113Zh = resultSet.getString("D401_13_ZH");
				String d40115 = resultSet.getString("D401_15");
				Date d40116 = resultSet.getDate("D401_16");
				String d40117 = resultSet.getString("D401_17");
				String d40118 = resultSet.getString("D401_18");
				String d40119 = resultSet.getString("D401_19");
				String d40120 = resultSet.getString("D401_20");
				String d40121 = resultSet.getString("D401_21");
				String d40122 = resultSet.getString("D401_22");
				Date d40123 = resultSet.getDate("D401_23");
				
				vd401.setD40101(d40101);
				vd401.setD40102(d40102);
				vd401.setD40103(d40103);
				//vd401.setD40103Zh(d40103Zh);
				vd401.setD40104(d40104);
				vd401.setD40105(d40105);
				vd401.setD40106(d40106);
				vd401.setD40106Zh(d40106Zh);
				vd401.setD40107(d40107);
				vd401.setD40108(d40108);
				vd401.setD40109(d40109);
				vd401.setD40110(d40110);
				vd401.setD40110Zh(d40110Zh);
				vd401.setD40111(d40111);
				vd401.setD40112(d40112);
				vd401.setD40112Zh(d40112Zh);
				vd401.setD40113(d40113);
				vd401.setD40113Zh(d40113Zh);
				vd401.setD40115(d40115);
				vd401.setD40116(d40116);
				vd401.setD40117(d40117);
				vd401.setD40118(d40118);
				vd401.setD40119(d40119);
				vd401.setD40120(d40120);
				vd401.setD40121(d40121);
				vd401.setD40122(d40122);
				vd401.setD40123(d40123);
				
				listVD401.add(vd401);
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally
		{
			this.close(connection, preparedStatement, resultSet);
		}
		
		return listVD401;
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
