package com.xyw.medical.birth.certificateRegist.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;
import oracle.jdbc.OracleTypes;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.xyw.medical.birth.certificateRegist.dao.CertificateRegistDao;
import com.xyw.medical.birth.model.D502;
import com.xyw.medical.birth.model.D502Request;
import com.xyw.medical.birth.model.D502Response;
import com.xyw.medical.birth.model.D505Request;
import com.xyw.medical.birth.model.D505Response;
import com.xyw.medical.birth.model.D506;
import com.xyw.medical.birth.model.D506Request;
import com.xyw.medical.birth.model.D506Response;
import com.xyw.medical.birth.model.Stock;
import com.xyw.medical.birth.model.StockRequest;
import com.xyw.medical.birth.model.StockResponse;
import com.xyw.medical.birth.model.VD502;
import com.xyw.medical.birth.model.VD505;
import com.xyw.medical.birth.model.VD506;
import com.xyw.sys.util.StringUtil;

public class CertificateRegistDaoImpl implements CertificateRegistDao {

	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;
	
	@Override
	@SuppressWarnings("unchecked")
	public D502Response saveD502(D502Request d502Request) {
		
		D502Response d502Response = new D502Response();
		
		Session session = this.sessionFactory.getCurrentSession();
		
		D502 d502 = d502Request.getD502();
		
		String d502_02 = d502.getD50202();
		String first = d502.getD50211();
		
		long d502_09 = Long.valueOf(d502.getD50209());
		long d502_10 = Long.valueOf(d502.getD50210());
		
		StringBuffer sqlS = new StringBuffer();
		sqlS.append("select count(0) from D502 t where t.d502_02 = ? and (? between t.d502_09 and t.d502_10 or ? between t.d502_09 and t.d502_10) and t.d502_11 = ?");
		SQLQuery sqlQueryS = session.createSQLQuery(sqlS.toString());
		sqlQueryS.setString(0, d502_02);
		sqlQueryS.setLong(1, d502_09);
		sqlQueryS.setLong(2, d502_10);
		sqlQueryS.setString(3, first);
		
		BigDecimal bd = (BigDecimal)sqlQueryS.uniqueResult();
		int bdInt = bd.intValue();
		
		if(bdInt >= 1) {
			d502Response.setErrorMessage("该号段范围包含已入库的号段,请检查分配查询以及入库查询!");
			return d502Response;
		}
		
		StringBuffer sql = new StringBuffer("select t.d501_01 from d501 t where t.d501_02 = ? and t.d501_06 = ? and ? >= to_number(t.d501_07) and ? <= to_number(t.d501_08)");
		SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
		
		sqlQuery.setString(0, d502_02);
		sqlQuery.setString(1, first);
		sqlQuery.setLong(2, d502_09);
		sqlQuery.setLong(3, d502_10);
		List<Long> list = null;
		if(d502.getD50212().length() != 2) {
			list = sqlQuery.list();
			if(list.size() != 1)
			{
				d502Response.setErrorMessage("该号段没有在分配范围!");
				return d502Response;
			}
			long d50213 = Long.valueOf(list.get(0) + "");
			
			d502.setD50213(d50213);
		} else {
			d502.setD50213(0);
		}
		
		if(d502.getD50205() == null) {
			d502.setD50205(new Date());
		}
		d502.setD50214("1");
		long result = (Long)session.save(d502);
		
		if(result > 0) {
			d502Response.setPromptMessage("入库成功!");
		} else {
			d502Response.setErrorMessage("入库失败!");
		}
		return d502Response;
	}

	@Override
	public D502Response queryD502(D502Request d502Request) {
		D502 d502 = d502Request.getD502();
		
		String d502_02_p = d502.getD50202();
		Date d502_05_p = d502.getD50205();
		Date d502_05_end_p = d502.getD50205End();
		String d502_12_p = d502.getD50212();
		String d502_11_p = d502.getD50211();
		String institutionCode = d502Request.getInstitutionCode();
		
		int parameterPageindex = d502Request.getParameterPageindex();
		int parameterPagesize = d502Request.getParameterPagesize();

		StringBuffer parameterConditionwhere = new StringBuffer();

		if (!StringUtil.isBlankString(d502_02_p)) {
			parameterConditionwhere.append("and t.d502_02 = '");
			parameterConditionwhere.append(d502_02_p);
			parameterConditionwhere.append("'");
		} else {
			parameterConditionwhere.append(" and t.d502_02 in (select t.D101_01 from D101 t where t.D101_11 = '" + institutionCode +"' or t.D101_01 ='" + institutionCode + "')");
		}

		if (!StringUtil.isBlankString(d502_11_p)) {
			parameterConditionwhere.append(" and t.d502_11 = '");
			parameterConditionwhere.append(d502_11_p);
			parameterConditionwhere.append("'");
		}
		
		if (d502_05_p != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String d502_05_text = simpleDateFormat.format(d502_05_p);
			parameterConditionwhere.append(" and t.d502_05 >= to_date('" + d502_05_text + "', 'yyyy-mm-dd')");
		}

		if (d502_05_end_p != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String d502_05_end_text = simpleDateFormat.format(d502_05_end_p);
			parameterConditionwhere.append(" and t.d502_05 <= to_date('" + d502_05_end_text + "', 'yyyy-mm-dd')");
		}
		
		if(!StringUtil.isBlankString(d502_12_p)) {
			parameterConditionwhere.append("and t.d502_12 like '");
			parameterConditionwhere.append(d502_12_p);
			parameterConditionwhere.append("'");
		}
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		D502Response d502Response = new D502Response();
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_D502");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D502_01");

			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			d502Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VD502 vd502 = null;
			List<VD502> vd502s = new ArrayList<VD502>();
			while (resultSet.next()) {

				Long d50201 = resultSet.getLong("D502_01");
				String d50202 = resultSet.getString("D502_02");
				String d50202Zh = resultSet.getString("D502_02_Zh");
				String d50203 = resultSet.getString("D502_03");
				long d50204 = resultSet.getLong("D502_04");
				Date d50205 = resultSet.getDate("D502_05");
				long d50206 = resultSet.getLong("D502_06");
				String d50207 = resultSet.getString("D502_07");
				String d50207Zh = resultSet.getString("D502_07_Zh");
				String d50208 = resultSet.getString("D502_08");
				String d50209 = resultSet.getString("D502_09");
				String d50210 = resultSet.getString("D502_10");

				String d50211 = resultSet.getString("D502_11");
				String d50212 = resultSet.getString("D502_12");
				long d50213 = resultSet.getLong("D502_13");
				String d50214 = resultSet.getString("D502_14");
				String d50214Zh = resultSet.getString("D502_14_ZH");
				String d50215 = resultSet.getString("D502_15");
				String d50216 = resultSet.getString("D502_16");
				String d50217 = resultSet.getString("D502_17");
				String d50218 = resultSet.getString("D502_18");
				String d50219 = resultSet.getString("D502_19");
				String d50220 = resultSet.getString("D502_20");

				String d50221 = resultSet.getString("D502_21");
				String d50222 = resultSet.getString("D502_22");
				String d50223 = resultSet.getString("D502_23");
				String d50224 = resultSet.getString("D502_24");
				String d50225 = resultSet.getString("D502_25");
				String d50226 = resultSet.getString("D502_26");
				String d50227 = resultSet.getString("D502_27");
				String d50228 = resultSet.getString("D502_28");
				String d50229 = resultSet.getString("D502_29");
				String d50230 = resultSet.getString("D502_30");

				String d50231 = resultSet.getString("D502_31");
				String d50232 = resultSet.getString("D502_32");
				String d50233 = resultSet.getString("D502_33");
				String d50234 = resultSet.getString("D502_34");
				String d50235 = resultSet.getString("D502_35");
				String d50236 = resultSet.getString("D502_36");
				String d50237 = resultSet.getString("D502_37");
				String d50238 = resultSet.getString("D502_38");
				String d50239 = resultSet.getString("D502_39");
				String d50240 = resultSet.getString("D502_40");

				String d50241 = resultSet.getString("D502_41");
				String d50242 = resultSet.getString("D502_42");
				String d50243 = resultSet.getString("D502_43");
				String d50244 = resultSet.getString("D502_44");
				String d50245 = resultSet.getString("D502_45");
				String d50246 = resultSet.getString("D502_46");
				String d50247 = resultSet.getString("D502_47");
				String d50248 = resultSet.getString("D502_48");
				String d50249 = resultSet.getString("D502_49");
				String d50250 = resultSet.getString("D502_50");

				vd502 = new VD502();

				vd502.setD50201(d50201);
				vd502.setD50202(d50202);
				vd502.setD50202Zh(d50202Zh);
				vd502.setD50203(d50203);
				vd502.setD50204(d50204);
				vd502.setD50205(d50205);
				vd502.setD50206(d50206);
				vd502.setD50207(d50207);
				vd502.setD50207Zh(d50207Zh);
				vd502.setD50208(d50208);
				vd502.setD50209(d50209);
				vd502.setD50210(d50210);
				vd502.setD50211(d50211);
				vd502.setD50212(d50212);
				vd502.setD50213(d50213);
				vd502.setD50214(d50214);
				vd502.setD50214Zh(d50214Zh);
				vd502.setD50215(d50215);
				vd502.setD50216(d50216);
				vd502.setD50217(d50217);
				vd502.setD50218(d50218);
				vd502.setD50219(d50219);
				vd502.setD50220(d50220);
				vd502.setD50221(d50221);
				vd502.setD50222(d50222);
				vd502.setD50223(d50223);
				vd502.setD50224(d50224);
				vd502.setD50225(d50225);
				vd502.setD50226(d50226);
				vd502.setD50227(d50227);
				vd502.setD50228(d50228);
				vd502.setD50229(d50229);
				vd502.setD50230(d50230);
				vd502.setD50231(d50231);
				vd502.setD50232(d50232);
				vd502.setD50233(d50233);
				vd502.setD50234(d50234);
				vd502.setD50235(d50235);
				vd502.setD50236(d50236);
				vd502.setD50237(d50237);
				vd502.setD50238(d50238);
				vd502.setD50239(d50239);
				vd502.setD50240(d50240);
				vd502.setD50241(d50241);
				vd502.setD50242(d50242);
				vd502.setD50243(d50243);
				vd502.setD50244(d50244);
				vd502.setD50245(d50245);
				vd502.setD50246(d50246);
				vd502.setD50247(d50247);
				vd502.setD50248(d50248);
				vd502.setD50249(d50249);
				vd502.setD50250(d50250);

				vd502s.add(vd502);
			}
			d502Response.setVd502s(vd502s);
		} catch (Exception e) {
			d502Response.setErrorMessage("查询失败");
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
		return d502Response;
	}

	@Override
	public D505Response queryD505(D505Request d505Request) {
		D505Response d505Response = new D505Response();
		
		int parameterPageindex = d505Request.getParameterPageindex();
		int parameterPagesize = d505Request.getParameterPagesize();
		String d505_05_p = d505Request.getD505().getD505_05();
		long d505_02_p = d505Request.getD505().getD505_02();
		StringBuffer parameterConditionwhere = new StringBuffer();
		
		if(d505_02_p > 0) {
			parameterConditionwhere.append(" and t.d505_02 = ");
			parameterConditionwhere.append(d505_02_p);
		}
		
		if(!StringUtil.isBlankString(d505_05_p)) {
			parameterConditionwhere.append(" and t.d505_05 = '");
			parameterConditionwhere.append(d505_05_p);
			parameterConditionwhere.append("'");
		} else {
			parameterConditionwhere.append(" and t.d505_05 != '");
			parameterConditionwhere.append(1);
			parameterConditionwhere.append("'");
		}
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_D505");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D505_05,t.D505_03");

			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			d505Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VD505 vd505 = null;
			List<VD505> vd505s = new ArrayList<VD505>();
			while (resultSet.next()) {
				long d505_01 = resultSet.getLong("D505_01");
				long d505_02 = resultSet.getLong("D505_02");
				String d505_03 = resultSet.getString("D505_03");
				String d505_04 = resultSet.getString("D505_04");
				String d505_04Zh = resultSet.getString("D505_04_ZH");
				String d505_05 = resultSet.getString("D505_05");
				String d505_05Zh = resultSet.getString("D505_05_ZH");
				String d505_06 = resultSet.getString("D505_06");
				String d505_06Zh = resultSet.getString("D505_06_ZH");
				vd505 = new VD505();
				vd505.setD505_01(d505_01);
				vd505.setD505_02(d505_02);
				vd505.setD505_03(d505_03);
				vd505.setD505_04(d505_04);
				vd505.setD505_04Zh(d505_04Zh);
				vd505.setD505_05(d505_05);
				vd505.setD505_05Zh(d505_05Zh);
				vd505.setD505_06(d505_06);
				vd505.setD505_06Zh(d505_06Zh);
				vd505s.add(vd505);
			}
			d505Response.setVd505s(vd505s);
		}  catch (Exception e) {
			d505Response.setErrorMessage("查询失败");
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
		return d505Response;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public StockResponse queryCountD505(StockRequest stockRequest) {
		StockResponse stockResponse = new StockResponse();
		List<Stock> listStock = new ArrayList<Stock>();
		
		Stock stock = null;
		String institution = stockRequest.getInstitution();
		String timeStart = stockRequest.getTimeStart();
		String timeEnd = stockRequest.getTimeEnd();
		String useType = stockRequest.getUseType();
	
		
		Session session = sessionFactory.getCurrentSession();
		
		StringBuffer sql = new StringBuffer("select count(t.d505_03), t.D505_04_Zh,t.D505_04 from v_d505 t where 0 = 0");
		if(!StringUtil.isBlankString(useType))
		{
			sql.append(" and t.D505_05 = ?");
		}
		if(!StringUtil.isBlankString(timeStart))
		{
			sql.append(" and t.D505_07 > to_date(?, 'yyyy-mm-dd')");
		}
		if(!StringUtil.isBlankString(timeEnd))
		{
			sql.append(" and t.D505_07 < to_date(?, 'yyyy-mm-dd')");
		}
		if(!StringUtil.isBlankString(institution))
		{
			sql.append(" and (t.D505_04 in (select t.d101_01 from d101 t where t.d101_11 = ?)");
			sql.append(" or t.D505_04 = ?)");
		}
		sql.append("  group by t.D505_04_ZH,t.D505_04");
		
		
		SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
		int i = 0;
		sqlQuery.setString(i, useType);
		if(!StringUtil.isBlankString(timeStart))
		{
			i = i + 1;
			sqlQuery.setString(i, timeStart);
		}
		if(!StringUtil.isBlankString(timeEnd))
		{
			i = i + 1;
			sqlQuery.setString(i, timeEnd);
		}
		i = i + 1;
		sqlQuery.setString(i, institution);
		i = i + 1;
		sqlQuery.setString(i, institution);
		
		List<Object[]> list = sqlQuery.list();
		
		for(Object[] objs : list) {
			stock = new Stock();
			long count = Long.valueOf(objs[0] + "");
			String institutionName = objs[1] + "";
			String institutionCode = objs[2] + "";
			
			stock.setCount(count);
			stock.setInstitution(institutionName);
			stock.setInstitutionCode(institutionCode);
			
			listStock.add(stock);
		}
		
		stockResponse.setListStock(listStock);
		
		return stockResponse;
	}
	@Override
	public D506Response saveD506(D506Request d506Request) {
		
		D506Response d506Response = new D506Response();
		
		D506 d506 = d506Request.getD506();
		
		Session session = this.sessionFactory.getCurrentSession();
		
		SQLQuery sqlQuery = session.createSQLQuery("insert into D506(d506_01, d506_02, d506_03, d506_04, d506_05, d506_06, d506_07, d506_08, d506_09) values(D506_01_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		sqlQuery.setDouble(0, d506.getD506_02());
		sqlQuery.setString(1, d506.getD506_03());
		sqlQuery.setString(2, d506.getD506_04());
		sqlQuery.setString(3, d506.getD506_05());
		sqlQuery.setString(4, d506.getD506_06());
		sqlQuery.setString(5, d506.getD506_07());
		sqlQuery.setString(6, d506.getD506_08());
		sqlQuery.setDate(7, d506.getD506_09());
		
		int result = sqlQuery.executeUpdate();
		
		SQLQuery sqlQueryA = session.createSQLQuery("update D502 set d502_14 = '2' where d502_01 = ?");
		sqlQueryA.setLong(0, d506.getD506_02());
		int resultA = sqlQueryA.executeUpdate();
		
		if(result > 0 && resultA > 0) {
			d506Response.setPromptMessage("调剂成功!");
		} else {
			d506Response.setErrorMessage("调剂失败!");
		}
		
		return d506Response;
	}

	@Override
	public D506Response queryD506(D506Request d506Request) {
		D506 d506 = d506Request.getD506();
		String d506_03_p = d506.getD506_03();
		String d506_05_p = d506.getD506_05();
		String d506_08_p = d506.getD506_08();
		
		Date d506_09_Start = d506.getD506_09Start();
		Date d506_09_End = d506.getD506_09End();
		
		int parameterPageindex = d506Request.getParameterPageindex();
		int parameterPagesize = d506Request.getParameterPagesize();
		
		StringBuffer parameterConditionwhere = new StringBuffer();
		
		if (!StringUtil.isBlankString(d506_03_p)) {
			parameterConditionwhere.append(" and t.d506_03 = '");
			parameterConditionwhere.append(d506_03_p);
			parameterConditionwhere.append("'");
		}
		
		if (!StringUtil.isBlankString(d506_05_p)) {
			parameterConditionwhere.append(" and t.d506_05 = '");
			parameterConditionwhere.append(d506_05_p);
			parameterConditionwhere.append("'");
		}
		
		if (!StringUtil.isBlankString(d506_08_p)) {
			parameterConditionwhere.append(" and t.d506_08 = '");
			parameterConditionwhere.append(d506_08_p);
			parameterConditionwhere.append("'");
		}
		
		if (d506_09_Start != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String d506_09_text = simpleDateFormat.format(d506_09_Start);
			parameterConditionwhere.append(" and t.d506_09 >= to_date('" + d506_09_text + "', 'yyyy-mm-dd')");
		}

		if (d506_09_End != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String d506_09_End_text = simpleDateFormat.format(d506_09_End);
			parameterConditionwhere.append(" and t.d506_09 <= to_date('" + d506_09_End_text + "', 'yyyy-mm-dd')");
		}
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		D506Response d506Response = new D506Response();
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_D506");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D506_01");

			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			d506Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VD506 vd506 = null;
			List<VD506> vd506s = new ArrayList<VD506>();
			while (resultSet.next()) {
				vd506 = new VD506();
				long d506_01 = resultSet.getLong("D506_01");
				long d506_02 = resultSet.getLong("D506_02");
				String d506_03 = resultSet.getString("D506_03");
				String d506_03_Zh = resultSet.getString("D506_03_ZH");
				String d506_04 = resultSet.getString("D506_04");
				String d506_05 = resultSet.getString("D506_05");
				String d506_06 = resultSet.getString("D506_06");
				String d506_07 = resultSet.getString("D506_07");
				String d506_08 = resultSet.getString("D506_08");
				String d506_08_Zh = resultSet.getString("D506_08_ZH");
				Date d506_09 = resultSet.getDate("D506_09");
				long d506_10 = resultSet.getLong("D506_10");
				
				vd506.setD506_01(d506_01);
				vd506.setD506_02(d506_02);
				vd506.setD506_03(d506_03);
				vd506.setD506_03_Zh(d506_03_Zh);
				vd506.setD506_04(d506_04);
				vd506.setD506_05(d506_05);
				vd506.setD506_06(d506_06);
				vd506.setD506_07(d506_07);
				vd506.setD506_08(d506_08);
				vd506.setD506_08_Zh(d506_08_Zh);
				vd506.setD506_09(d506_09);
				vd506.setD506_10(d506_10);
				
				vd506s.add(vd506);
			}
			d506Response.setVd506s(vd506s);
		} catch(Exception e) {
			d506Response.setErrorMessage("查询失败!");
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
		return d506Response;
	}
	
	@Override
	public StockResponse queryStockDetail(StockRequest stockRequest) {
		StockResponse stockResponse = new StockResponse();
		
		String institution = stockRequest.getInstitution();
		String timeStart = stockRequest.getTimeStart();
		String timeEnd = stockRequest.getTimeEnd();
		String useType = stockRequest.getUseType();
		int parameterPageindex = stockRequest.getParameterPageindex();
		int parameterPagesize = stockRequest.getParameterPagesize();
		
		StringBuffer parameterConditionwhere = new StringBuffer();
		
		if(!StringUtil.isBlankString(institution))
		{
			parameterConditionwhere.append("and t.D505_04 = '");
			parameterConditionwhere.append(institution);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(useType))
		{
			parameterConditionwhere.append("and t.D505_05 = '");
			parameterConditionwhere.append(useType);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(timeStart))
		{
			parameterConditionwhere.append("and t.D505_07 > to_date('");
			parameterConditionwhere.append(timeStart);
			parameterConditionwhere.append("', 'yyyy-mm-dd')");
		}
		if(!StringUtil.isBlankString(timeEnd))
		{
			parameterConditionwhere.append("and t.D505_07 < to_date('");
			parameterConditionwhere.append(timeEnd);
			parameterConditionwhere.append("', 'yyyy-mm-dd')");
		}
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_D505");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D505_05,t.D505_03");

			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			stockResponse.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VD505 vd505 = null;
			List<VD505> vd505s = new ArrayList<VD505>();
			while (resultSet.next()) {
				long d505_01 = resultSet.getLong("D505_01");
				long d505_02 = resultSet.getLong("D505_02");
				String d505_03 = resultSet.getString("D505_03");
				String d505_04 = resultSet.getString("D505_04");
				String d505_04Zh = resultSet.getString("D505_04_ZH");
				String d505_05 = resultSet.getString("D505_05");
				String d505_05Zh = resultSet.getString("D505_05_ZH");
				String d505_06 = resultSet.getString("D505_06");
				String d505_06Zh = resultSet.getString("D505_06_ZH");
				vd505 = new VD505();
				vd505.setD505_01(d505_01);
				vd505.setD505_02(d505_02);
				vd505.setD505_03(d505_03);
				vd505.setD505_04(d505_04);
				vd505.setD505_04Zh(d505_04Zh);
				vd505.setD505_05(d505_05);
				vd505.setD505_05Zh(d505_05Zh);
				vd505.setD505_06(d505_06);
				vd505.setD505_06Zh(d505_06Zh);
				vd505s.add(vd505);
			}
			stockResponse.setListVd505(vd505s);
		}  catch (Exception e) {
			stockResponse.setErrorMessage("查询失败");
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
		
		return stockResponse;
	}
}
