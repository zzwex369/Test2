package com.xyw.medical.jsywh.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.jsywh.dao.JsywhDao;
import com.xyw.medical.jsywh.model.S30109;
import com.xyw.medical.jsywh.model.S30109Request;
import com.xyw.medical.jsywh.model.S30109Response;
import com.xyw.medical.jsywh.model.VS30109;
import com.xyw.sys.util.StringUtil;

public class JsywhDaoImpl implements JsywhDao {
	
	@Resource
	public SessionFactory sessionFactory;
	
	@Resource
	public DataSource dataSource;
	
	public S30109Response find(S30109Request s30109Request){
		
		int parameterPageindex = s30109Request.getPageIndex();
		int parameterPagesize = s30109Request.getPageSize();
		String s3010902 = s30109Request.getS30109().getS3010902();
		String s3010903 = s30109Request.getS30109().getS3010903();
//		String systemCode = s30109Request.getSystemCode();
		StringBuffer parameterConditionwhere = new StringBuffer();
		if(!StringUtil.isBlankString(s3010902)){
			parameterConditionwhere.append(" and t.S_02='"+s3010902+"'");
		}
//		if(!StringUtil.isBlankString(systemCode)){
//			parameterConditionwhere.append(" and t.S_03='"+systemCode+"'");
//		}
		if(!StringUtil.isBlankString(s3010903)){
			parameterConditionwhere.append(" and t.S_03='"+s3010903+"'");
		}
		Connection connection = null;
		CallableStatement callableStatement = null;
		S30109Response s30109Response = new S30109Response();
		try {
			connection = dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?,?,?,?,?,?,?)}");
			
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_S301_09");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.S_01");
			
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			
			callableStatement.execute();
			
			long rowCount = callableStatement.getLong(6);
			s30109Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VS30109 vs30109 = null;
			List<VS30109> vs30109s = new ArrayList<VS30109>();
			while (resultSet.next()) {

				String s_01 = resultSet.getString("S_01");
				String s_02 = resultSet.getString("S_02");
				String s_03 = resultSet.getString("S_03");
				String s_03_ZH = resultSet.getString("S_03_ZH");
				

				vs30109 = new VS30109();

				vs30109.setS3010901(s_01);
				vs30109.setS3010902(s_02);
				vs30109.setS3010903(s_03);
				vs30109.setS30109Zh(s_03_ZH);

				vs30109s.add(vs30109);
			}
			s30109Response.setVS30109s(vs30109s);
		} catch (Exception e) {
			s30109Response.setErrorMessage("查询失败!");
			e.printStackTrace();
		}finally{
			try {
				if (callableStatement != null) {
					callableStatement.close();
					callableStatement = null;
				}
				if (connection != null) {
					connection.close();
					connection = null;
				}
			} catch (Exception e) {

			}
		}
		return s30109Response;
	}
	
	public S30109Response save(S30109Request s30109Request){
	
	    S30109Response s30109Response = new S30109Response();
	    S30109 s30109 = s30109Request.getS30109();
		//String s3010901 = s30109.getS3010901();

		Session session = this.sessionFactory.getCurrentSession();

		try{
			//前台传来的s3010901中的id为空，用触发器时id不能为空，所以随便放入一个数
			s30109.setS3010901("0");
			String resultS = (String)session.save(s30109);
			if(resultS != null) {
				s30109Response.setPromptMessage("保存成功");
			} else {
				s30109Response.setErrorMessage("保存失败");
			}
		}catch(Exception e){
			e.printStackTrace();
			s30109Response.setErrorMessage("保存失败");
		}
		
		
	
		
		return s30109Response;
	}
	public S30109Response del(S30109Request s30109Request){
		
	    S30109Response s30109Response = new S30109Response();
	    //S30109 s30109 = s30109Request.getS30109();
		String id = s30109Request.getS30109().getS3010901();
	//	String s3010902 = s30109.getS3010902();
	//	String s3010903 = s30109.getS3010903();
		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			S30109 s30109 = (S30109)session.get(S30109.class, id);
			session.delete(s30109);
			s30109Response.setPromptMessage("删除成功！");
		} catch (Exception e){
			s30109Response.setErrorMessage("删除失败！");
		}
		
		return s30109Response;
	}
	public S30109Response update(S30109Request s30109Request) {
		S30109Response s30109Response = new S30109Response();
	    S30109 s30109 = s30109Request.getS30109();
		String s3010901 = s30109.getS3010901();
		String s3010902 = s30109.getS3010902();
		String s3010903 = s30109.getS3010903();
		
		String strSql = "update S301_09 t set t.s_02 = ?, t.s_03 = ? where t.s_01 = ?";
		Session session = this.sessionFactory.getCurrentSession();
		SQLQuery sQLQuery = session.createSQLQuery(strSql);
		
		sQLQuery.setString(0, s3010902);
		sQLQuery.setString(1, s3010903);
		sQLQuery.setString(2, s3010901);
		
		int results = sQLQuery.executeUpdate();
		if(results > 0){
			//if(d20101.length() != 12) {
			//	String strSQLSub = "update D201 t set t.D201_05 = ? || t.D201_04 where t.D201_02 = ?";
			//	SQLQuery sqlQueryA = session.createSQLQuery(strSQLSub);
			//	sqlQueryA.setString(0, d20105);
			//	sqlQueryA.setString(1, d20101);
			//	int resultA = sqlQueryA.executeUpdate();
			//	if(resultA > 0) {
			//		d201Response.setPromptMessage("修改成功");
			//	} else {
			//		d201Response.setErrorMessage("修改失败");
			//	}
			//} else {
			s30109Response.setPromptMessage("修改成功");
			//}
		}else{
			s30109Response.setErrorMessage("修改失败");
		}
		return s30109Response;
	}
	
}
