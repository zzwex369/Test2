package com.xyw.medical.fnbj.report.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.fnbj.model.VF502;

@SuppressWarnings("all")
public class FnbjcsbgService {

	private DataSource dataSource;


	public VF502 queryVF502(String id, ServletContext servletContext) {

		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource) webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		VF502 vf502=null;		
		try{
			connection = this.dataSource.getConnection();
			pStatement = connection
					.prepareStatement("select * from v_f502 t where t.f502_01 = ?");
			pStatement.setString(1, id);
			rs = pStatement.executeQuery();								
			if (rs.next()){					
				String f50203 = rs.getString("F502_03");
				String f50204 = rs.getString("F502_04");
				String f50205Zh= rs.getString("F502_05_ZH");
				int f50206 = rs.getInt("F502_06");
				String f50207 = rs.getString("F502_07");
				String f50208 = rs.getString("F502_08");
				String f50209 = rs.getString("F502_09");
				Double f50210 = rs.getDouble("F502_10");
				Double f50211 = rs.getDouble("F502_11");
				int f50212 = rs.getInt("F502_12");
				String f50230 = rs.getString("F502_30");
				Double f50213 = rs.getDouble("F502_13");
				int f50214 = rs.getInt("F502_14");
				String f50215 = rs.getString("F502_15");
				String f50216 = rs.getString("F502_16");
				String f50217Zh= rs.getString("F502_17_ZH");
				String f50225Zh= rs.getString("F502_25_ZH");
				Double f50218 = rs.getDouble("F502_18");
				Double f50219 = rs.getDouble("F502_19");
				String f50220 = rs.getString("F502_20");
				String f50221 = rs.getString("F502_21");
				String f50222 = rs.getString("F502_22");
				String f50223 = rs.getString("F502_23");
				Date f50224 = rs.getDate("F502_24");
				String f50225 = rs.getString("F502_25");
				String f50226 = rs.getString("F502_26");
				String f50233 = rs.getString("F502_33");
				String f50234 = rs.getString("F502_34");
				String f50235 = rs.getString("F502_35");
				
				vf502 =new VF502();				
				vf502.setF50203(f50203);//姓名
				vf502.setF50204(f50204);//身份证号
				vf502.setF50206(f50206);//年龄
				vf502.setF50207(f50207);//电话
				vf502.setF50208(f50208);//临床诊断
				vf502.setF50209(f50209);//超生号
				vf502.setF50210(f50210);//头臀径
				vf502.setF50211(f50211);//双顶径
				vf502.setF50212(f50212);//孕周
				vf502.setF50230(f50230);//孕周天
				vf502.setF50213(f50213);//NT
				vf502.setF50214(f50214);//心率
				vf502.setF50215(f50215);//颅骨光环
				vf502.setF50216(f50216);//是否可见
				vf502.setF50205Zh(f50205Zh);//性别
				
				vf502.setF50217Zh(f50217Zh);//胎盘位置
				vf502.setF50218(f50218);//胎盘厚度
				vf502.setF50219(f50219);//胎盘深度
				vf502.setF50220(f50220);//胎盘深度
				vf502.setF50221(f50221);//宫内胎儿发育如孕周
				vf502.setF50222(f50222);//报告医生
				vf502.setF50223(f50223);//审核医生
				vf502.setF50224(f50224);//报告时间
				vf502.setF50225(f50225);//报告单位
				vf502.setF50225Zh(f50225Zh);
				vf502.setF50226(f50226);//组织机构代码
				vf502.setF50233(f50233);
				vf502.setF50234(f50234);
				vf502.setF50235(f50235);
				
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		return vf502;
	}

}