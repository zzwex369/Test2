package com.xyw.medical.qfrwh.dao.impl;

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

import com.xyw.medical.qfrwh.dao.SignerDao;
import com.xyw.medical.qfrwh.model.S301_10;
import com.xyw.medical.qfrwh.model.S301_10Reponse;
import com.xyw.medical.qfrwh.model.S301_10Request;
import com.xyw.medical.qfrwh.model.VS301_10;
import com.xyw.sys.util.StringUtil;

public class SignerDaoImpl implements SignerDao{
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private DataSource dataSource;
	
	@Override
	public S301_10Reponse save(S301_10Request s301_10Request) {
		
		S301_10Reponse s301_10Reponse = new S301_10Reponse();
		
		S301_10 s301_10 = s301_10Request.getS301_10();
		String qfrxm  = s301_10.getS3011002();
		String szyy = s301_10.getS3011003();
		if(StringUtil.isBlankString(qfrxm)){
			s301_10Reponse.setErrorMessage("签发人姓名不能为空！");
			return s301_10Reponse;
		}
		if(StringUtil.isBlankString(szyy)){
			s301_10Reponse.setErrorMessage("所在医院不能为空！");
			return s301_10Reponse;
		}
		

		Session session = this.sessionFactory.getCurrentSession();
		
		try{
			s301_10.setS3011001("0");
			String resultS = (String)session.save(s301_10);
			if(resultS != null) {
				s301_10Reponse.setPromptMessage("保存成功");
			} else {
				s301_10Reponse.setErrorMessage("保存失败");
			}
		}catch(Exception e){
			e.printStackTrace();
			s301_10Reponse.setErrorMessage("保存失败");
		}
		return s301_10Reponse;
	}

	@Override
	public S301_10Reponse find(S301_10Request s301_10Request) {
		 S301_10Reponse s301_10Reponse = new S301_10Reponse();
		 S301_10 s301_10 = s301_10Request.getS301_10();
		 String s02 = s301_10.getS3011002();
		 String s03 = s301_10.getS3011003();
		 String s04 = s301_10.getS3011004();
		 String s05 = s301_10.getS3011005();
		 int parameterPageindex = s301_10Request.getPageIndex();
			int parameterPagesize = s301_10Request.getPageSize();

//			if(parameterPageindex == 0) {
//				parameterPageindex = 1;
//			}
			StringBuffer parameterConditionwhere = new StringBuffer();
			if(!StringUtil.isBlankString(s02)){
				parameterConditionwhere.append(" and t.s_02 like '%" + s02 + "%'");
			}
			if(!StringUtil.isBlankString(s04)){
				parameterConditionwhere.append(" and t.s_04 like '%" + s04 + "%'");
			}
			if(!StringUtil.isBlankString(s05)){
				parameterConditionwhere.append(" and t.s_05 ='" + s05 + "'");
			}
			
			if (!StringUtil.isBlankString(s03)) {
				if (s03.length() == 14) {
					parameterConditionwhere.append(" and t.s_03 = '");
					parameterConditionwhere.append(s03);
					parameterConditionwhere.append("'");
				} else {
					parameterConditionwhere.append(" and t.s_03 like '");
					parameterConditionwhere.append(s03);
					parameterConditionwhere.append("%'");
				}
			}
			Connection connection = null;
			CallableStatement callableStatement = null;
			try {
				connection = this.dataSource.getConnection();
				callableStatement = connection
						.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

				callableStatement.setInt(1, parameterPageindex);
				callableStatement.setInt(2, parameterPagesize);
				callableStatement.setString(3, "V_S301_10");
				callableStatement.setString(4, parameterConditionwhere.toString());
				callableStatement.setString(5, "t.S_01");

				callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
				callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
				callableStatement.execute();
				long rowCount = callableStatement.getLong(6);
				s301_10Reponse.setRowCount(rowCount);
				ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
				VS301_10 vS301_10  = null;
				List<VS301_10> vS301_10s = new ArrayList<VS301_10>();
				while (resultSet.next()) {
					

					String vs3011001 = resultSet.getString("S_01");
					String vs3011002 = resultSet.getString("S_02");
					String vs3011003 = resultSet.getString("S_03");
					String vs3011004 = resultSet.getString("S_04");
					String vs3011005 = resultSet.getString("S_05");
					String vs3011006 = resultSet.getString("S_06");
					byte [] vs3011007 = resultSet.getBytes("S_07");
					String vs3011003_ZH = resultSet.getString("S_03_ZH");
					
		              vS301_10 = new VS301_10();
		
		              vS301_10.setS3011001(vs3011001);
		              vS301_10.setS3011002(vs3011002);
		              vS301_10.setS3011003(vs3011003);
		              vS301_10.setS3011004(vs3011004);
		              vS301_10.setS3011005(vs3011005);
		              vS301_10.setS3011006(vs3011006);
		              vS301_10.setS3011007(vs3011007);
		              vS301_10.setS3011003_zh(vs3011003_ZH);
					
					
		              vS301_10s.add(vS301_10);
				}
				s301_10Reponse.setVs301_10s(vS301_10s);
			} catch (Exception e) {
				s301_10Reponse.setErrorMessage("查询失败!");
				e.printStackTrace();
			} finally {
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
			return s301_10Reponse;
	}

	@Override
	public S301_10Reponse update(S301_10Request s301_10Request) {
		S301_10Reponse s301_10Reponse = new S301_10Reponse();
		S301_10 s301_10 = s301_10Request.getS301_10();
		
		String s3011001 = s301_10.getS3011001();
		String s3011002 = s301_10.getS3011002();
		String s3011003 = s301_10.getS3011003();
		
		try {
			if(StringUtil.isBlankString(s3011001)){
				s301_10Reponse.setErrorMessage("编码不能为空！");
				return s301_10Reponse;
			}
			if(StringUtil.isBlankString(s3011002)){
				s301_10Reponse.setErrorMessage("姓名不能为空！");
				return s301_10Reponse;
			}
			if(StringUtil.isBlankString(s3011003)){
				s301_10Reponse.setErrorMessage("所在医院编码不能为空！");
				return s301_10Reponse;
			}
			Session session = sessionFactory.getCurrentSession();
			session.update(s301_10);
			s301_10Reponse.setPromptMessage("修改成功");
		} catch (Exception e) {
			s301_10Reponse.setErrorMessage(e.getMessage());
		}
		return s301_10Reponse;
	}

	@Override
	public S301_10Reponse del(S301_10Request s301_10Request) {
		S301_10Reponse s301_10Reponse = new S301_10Reponse();
		String id = s301_10Request.getS301_10().getS3011001();
		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			S301_10 s301_10 = (S301_10)session.get(S301_10.class, id);
			session.delete(s301_10);
			s301_10Reponse.setPromptMessage("删除成功！");
		} catch (Exception e){
			s301_10Reponse.setErrorMessage("删除失败！");
		}
		return s301_10Reponse;
	}

}
