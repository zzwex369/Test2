package com.xyw.medical.birth.report.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.birth.report.model.Fmqktj;

public class FmqktjService {
	@Resource
	private DataSource dataSource;

	public List<Fmqktj> queryfmqktj(String date_start, String date_end, String areaCode, String sexflag, String areaFlag, String timeFlag, String jiwei,ServletContext servletContext)
	{
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		CallableStatement callableStatement = null;
		List<Fmqktj> fmqktjs = null;
		
		StringBuffer sql = new StringBuffer("");
		// 1按分娩日期统计，2按保存日期统计
		if("1".equals(timeFlag)){
			sql.append(" t.d601_03 >= to_date('"+ date_start +"','yyyy-MM-dd') and t.d601_03 <= to_date('"+ date_end +"','yyyy-MM-dd')");
		} else {
			sql.append(" t.d601_60 >= to_date('"+ date_start +"','yyyy-MM-dd') and t.d601_60 <= to_date('"+ date_end +"','yyyy-MM-dd')");
		}
		
		if(jiwei !=null && !"null".equals(jiwei) && !"".equals(jiwei)){
			sql.append(" and 1= "+jiwei+" ");
		}
		
		// 1按男方统计，2按女方统计
		if("1".equals(sexflag)){
			// 1按家庭地址统计，2按户口地址统计
			if("1".equals(areaFlag)){
				sql.append(" and t.d601_97 ");
			} else {
				sql.append(" and t.d601_98 ");
			}
		} else {
			if("1".equals(areaFlag)){
				sql.append(" and t.d601_95 ");
			} else {
				sql.append(" and t.d601_96 ");
			}
		}
		
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call fmqktj_package.fmqktj_procedure(?, ?, ?)}");
			
			callableStatement.setString(1, areaCode);
			callableStatement.setString(2, sql.toString());
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.execute();
			ResultSet resultSet = (ResultSet)callableStatement.getObject(3);
			fmqktjs = new ArrayList<Fmqktj>();
			Fmqktj fmqktj = null;
			while(resultSet.next()) {
				fmqktj = new Fmqktj();
				fmqktj.setAredCodeZh(resultSet.getString("AREDCODE_ZH"));
				fmqktj.setTotal(resultSet.getLong("TOTAL"));
				fmqktj.setTotal_boy(resultSet.getLong("TOTAL_BOY"));
				fmqktj.setTotal_girl(resultSet.getLong("TOTAL_GIRL"));
				fmqktj.setFirst_boy(resultSet.getLong("FIRST_BOY"));
				fmqktj.setFirst_girl(resultSet.getLong("FIRST_GIRL"));
				fmqktj.setSecond_boy(resultSet.getLong("SECOND_BOY"));
				fmqktj.setSecond_girl(resultSet.getLong("SECOND_GIRL"));
				fmqktj.setThird_boy(resultSet.getLong("THIRD_BOY"));
				fmqktj.setThird_girl(resultSet.getLong("THIRD_GIRL"));
				fmqktj.setOther_boy(resultSet.getLong("OTHER_BOY"));
				fmqktj.setOther_girl(resultSet.getLong("OTHER_GIRL"));
				
				fmqktjs.add(fmqktj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(callableStatement != null) {
					callableStatement.close();
					callableStatement = null;
				}
				if(connection != null) {
					connection.close();
					connection = null;
				}
			} catch(Exception e) {
				
			}
		}
		return fmqktjs;
	}
}
