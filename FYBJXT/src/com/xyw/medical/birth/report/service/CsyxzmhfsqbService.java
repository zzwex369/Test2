package com.xyw.medical.birth.report.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.birth.model.VD306;

public class CsyxzmhfsqbService {
	private DataSource dataSource;
	
	public VD306 queryVD306(String d306_01,String d306_03,ServletContext servletContext){
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		VD306 vd306 = null;
		
		StringBuffer sql = new StringBuffer("select * from v_d306 t where 1=1 ");
		if(d306_01 != null){
			sql.append(" and t.D306_01 ="+d306_01 );
		}
		if(d306_03 != null){
			sql.append(" and t.D306_03 ='"+d306_03+"'" );
		}
		
		try {
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			resultSet = preparedStatement.executeQuery();
			vd306 = new VD306();
			
			while (resultSet.next()) {
				long d30601 =resultSet.getLong("D306_01");
				long d30602 =resultSet.getLong("D306_02");
				String d30603 =resultSet.getString("D306_03");
				String d30604 =resultSet.getString("D306_04");
				String d30605 =resultSet.getString("D306_05");
				String d30606 =resultSet.getString("D306_06");
				String d30607 =resultSet.getString("D306_07");
				String d30608 =resultSet.getString("D306_08");
				String d30609 =resultSet.getString("D306_09");
				String d30610 =resultSet.getString("D306_10");
				String d30611 =resultSet.getString("D306_11");
				String d30612 =resultSet.getString("D306_12");
				String d30613 =resultSet.getString("D306_13");
				String d30614 =resultSet.getString("D306_14");
				String d30615 =resultSet.getString("D306_15");
				String d30616 =resultSet.getString("D306_16");
				String d30617 =resultSet.getString("D306_17");
				String d30618 =resultSet.getString("D306_18");
				String d30619 =resultSet.getString("D306_19");
				String d30620 =resultSet.getString("D306_20");
				String d30621 =resultSet.getString("D306_21");
				String d30622 =resultSet.getString("D306_22");
				Date d30623 =resultSet.getDate("D306_23");
				String d30624 =resultSet.getString("D306_24");
				String d30625 =resultSet.getString("D306_25");
				String d30626 =resultSet.getString("D306_26");
				String d30627 =resultSet.getString("D306_27");
				String d30628 =resultSet.getString("D306_28");
				String d30629 =resultSet.getString("D306_29");
				String d30630 =resultSet.getString("D306_30");
				String d30631 =resultSet.getString("D306_31");
				String d30632 =resultSet.getString("D306_32");
				String d30633 =resultSet.getString("D306_33");
				String d30634 =resultSet.getString("D306_34");
				String d30635 =resultSet.getString("D306_35");
				String d30636 =resultSet.getString("D306_36");
				String d30637 =resultSet.getString("D306_37");
				String d30638 =resultSet.getString("D306_38");
				String d30639 =resultSet.getString("D306_39");
				String d30640 =resultSet.getString("D306_40");
				
				String d30105 =resultSet.getString("D301_05");
				String d30131 =resultSet.getString("D301_31");
				String d30605Zh =resultSet.getString("D306_05_ZH");
				String d30607Zh =resultSet.getString("D306_07_ZH");
				String d30610Zh =resultSet.getString("D306_10_ZH");
				String d30611Zh =resultSet.getString("D306_11_ZH");
				String d30613Zh =resultSet.getString("D306_13_ZH");
				String d30614Zh =resultSet.getString("D306_14_ZH");
				String d30615Zh =resultSet.getString("D306_15_ZH");
				String d30616Zh =resultSet.getString("D306_16_ZH");
				String d30617Zh =resultSet.getString("D306_17_ZH");
				String d30618Zh =resultSet.getString("D306_18_ZH");
				String d30619Zh =resultSet.getString("D306_19_ZH");
				String d30621Zh =resultSet.getString("D306_21_ZH");
				String d30622Zh =resultSet.getString("D306_22_ZH");
				String d30623Str =resultSet.getString("D306_23_Str");
				
				vd306.setD30601(d30601);
				vd306.setD30602(d30602);
				vd306.setD30603(d30603);
				vd306.setD30604(d30604);
				vd306.setD30605(d30605);
				vd306.setD30606(d30606);
				vd306.setD30607(d30607);
				vd306.setD30608(d30608);
				vd306.setD30609(d30609);
				vd306.setD30610(d30610);
				vd306.setD30611(d30611);
				vd306.setD30612(d30612);
				vd306.setD30613(d30613);
				vd306.setD30614(d30614);
				vd306.setD30615(d30615);
				vd306.setD30616(d30616);
				vd306.setD30617(d30617);
				vd306.setD30618(d30618);
				vd306.setD30619(d30619);
				vd306.setD30620(d30620);
				vd306.setD30621(d30621);
				vd306.setD30622(d30622);
				vd306.setD30623(d30623);
				vd306.setD30624(d30624);
				vd306.setD30625(d30625);
				vd306.setD30626(d30626);
				vd306.setD30627(d30627);
				vd306.setD30628(d30628);
				vd306.setD30629(d30629);
				vd306.setD30630(d30630);
				vd306.setD30631(d30631);
				vd306.setD30632(d30632);
				vd306.setD30633(d30633);
				vd306.setD30634(d30634);
				vd306.setD30635(d30635);
				vd306.setD30636(d30636);
				vd306.setD30637(d30637);
				vd306.setD30638(d30638);
				vd306.setD30639(d30639);
				vd306.setD30640(d30640);
				
				vd306.setD30105(d30105);
				vd306.setD30131(d30131);
				vd306.setD30618Zh(d30618Zh);
				vd306.setD30605Zh(d30605Zh);
				vd306.setD30607Zh(d30607Zh);
				vd306.setD30610Zh(d30610Zh);
				vd306.setD30611Zh(d30611Zh);
				vd306.setD30613Zh(d30613Zh);
				vd306.setD30614Zh(d30614Zh);
				vd306.setD30615Zh(d30615Zh);
				vd306.setD30616Zh(d30616Zh);
				vd306.setD30617Zh(d30617Zh);
				vd306.setD30618Zh(d30618Zh);
				vd306.setD30619Zh(d30619Zh);
				vd306.setD30621Zh(d30621Zh);
				vd306.setD30622Zh(d30622Zh);
				vd306.setD30623Str(d30623Str);
			}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				this.close(connection, preparedStatement, resultSet);
			}
		return vd306;
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


