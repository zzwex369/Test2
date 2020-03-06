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

import com.xyw.medical.birth.model.VD301;


public class CertificateFamilyService {
	private DataSource dataSource;
	
	public List<VD301> queryVd301(String areaCode, String queryType, String date_start, String date_end, ServletContext servletContext){
		

		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "";
		if("homeType".equals(queryType))
		{
			sql = "select * from v_d301 t where t.D301_05 like ? and to_date(t.D301_28,'YYYY-MM-DD') >= to_date(?,'YYYY-MM-DD') and to_date(t.D301_28,'YYYY-MM-DD') <= to_date(?,'YYYY-MM-DD') order by t.D301_21";
		}else
		{
			sql = "select * from v_d301 t where t.D301_31 like ? and to_date(t.D301_28,'YYYY-MM-DD') >= to_date(?,'YYYY-MM-DD') and to_date(t.D301_28,'YYYY-MM-DD') <= to_date(?,'YYYY-MM-DD') order by t.D301_21";
		}
		VD301 vd301 = null;
		List<VD301> vd301List = null;
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, areaCode + "%");
			preparedStatement.setString(2, date_start);
			preparedStatement.setString(3, date_end);
			
			resultSet = preparedStatement.executeQuery();
			vd301List = new ArrayList<VD301>();
			while(resultSet.next()) {
				long d30101 = resultSet.getLong("D301_01");
				String d30102 = resultSet.getString("D301_02");
				String d30103 = resultSet.getString("D301_03");
				String d30103Zh = resultSet.getString("D301_03_ZH");
				String d30104 = resultSet.getString("d301_04");
				String d30105 = resultSet.getString("D301_05");
				String d30105Zh = resultSet.getString("D301_05_ZH");
				String d30106 = resultSet.getString("D301_06");
				int d30107 = resultSet.getInt("D301_07");
				float d30108 = resultSet.getFloat("D301_08");
				String d30109 = resultSet.getString("D301_09");
				String d30109Zh = resultSet.getString("D301_09_ZH");
				String d30110 = resultSet.getString("D301_10");
				String d30111 = resultSet.getString("D301_11");
				String d30112 = resultSet.getString("D301_12");
				String d30113 = resultSet.getString("D301_13");
				String d30114 = resultSet.getString("D301_14");
				String d30114Zh = resultSet.getString("D301_14_ZH");
				String d30115 = resultSet.getString("D301_15");
				String d30115Zh = resultSet.getString("D301_15_ZH");
				String d30116 = resultSet.getString("D301_16");
				String d30117 = resultSet.getString("D301_17");
				String d30118 = resultSet.getString("D301_18");
				String d30119 = resultSet.getString("D301_19");
				String d30119Zh = resultSet.getString("D301_19_ZH");
				String d30120 = resultSet.getString("D301_20");
				String d30120Zh = resultSet.getString("D301_20_ZH");
				String d30121 = resultSet.getString("D301_21");
				String d30122 = resultSet.getString("D301_22");
				String d30122Zh = resultSet.getString("D301_22_ZH");
				String d30123 = resultSet.getString("D301_23");
				String d30124 = resultSet.getString("D301_24");
				String d30124Zh = resultSet.getString("D301_24_ZH");
				String d30125 = resultSet.getString("D301_25");
				String d30126 = resultSet.getString("D301_26");
				String d30126Zh = resultSet.getString("D301_26_ZH");
				String d30127 = resultSet.getString("D301_27");
				String d30128 = resultSet.getString("D301_28");
				float d30129 = resultSet.getFloat("D301_29");
				
				String d30130 = resultSet.getString("D301_30");
				String d30130Zh = resultSet.getString("D301_30_ZH");
				String d30131 = resultSet.getString("D301_31");
				String d30131Zh = resultSet.getString("D301_31_ZH");
				String d30132 = resultSet.getString("D301_32");
				String d30133 = resultSet.getString("D301_33");
				String d30134 = resultSet.getString("D301_34");
				//String d30134Zh = resultSet.getString("D301_34_ZH");
				String d30135 = resultSet.getString("D301_35");
				//String d30135Zh = resultSet.getString("D301_35_ZH");
				String d30136 = resultSet.getString("D301_36");
				String d30137 = resultSet.getString("D301_37");
				//String d30137Zh = resultSet.getString("D301_37_ZH");
				String d30138 = resultSet.getString("D301_38");
				//String d30138Zh = resultSet.getString("D301_38_ZH");
				String d30139 = resultSet.getString("D301_39");
				String d30140 = resultSet.getString("D301_40");
				long d30141 = resultSet.getLong("D301_41");
				String d30143 = resultSet.getString("D301_43");
				
				vd301 = new VD301();
				vd301.setD30101(d30101);
				vd301.setD30102(d30102);
				vd301.setD30103(d30103);
				vd301.setD30103Zh(d30103Zh);
				vd301.setD30104(d30104);
				vd301.setD30105(d30105);
				vd301.setD30105Zh(d30105Zh);
				vd301.setD30105Zh(d30105Zh);
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
				vd301.setD30131Zh(d30131Zh);
				vd301.setD30132(d30132);
				vd301.setD30133(d30133);
				vd301.setD30134(d30134);
				vd301.setD30135(d30135);
				vd301.setD30136(d30136);
				vd301.setD30137(d30137);
				vd301.setD30138(d30138);
				vd301.setD30139(d30139);
				vd301.setD30140(d30140);
				vd301.setD30141(String.valueOf(d30141));
				vd301.setD30143(d30143);
				
				vd301List.add(vd301);
			}
		} catch (Exception e) {
			
		}
		return vd301List;
	}
}
