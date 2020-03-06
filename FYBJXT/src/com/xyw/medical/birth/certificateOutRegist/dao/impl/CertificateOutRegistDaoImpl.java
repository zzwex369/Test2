package com.xyw.medical.birth.certificateOutRegist.dao.impl;

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

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.birth.certificateOutRegist.dao.CertificateOutRegistDao;
import com.xyw.medical.birth.model.D503;
import com.xyw.medical.birth.model.D503Request;
import com.xyw.medical.birth.model.D503Response;
import com.xyw.medical.birth.model.VD503;
import com.xyw.sys.util.StringUtil;

public class CertificateOutRegistDaoImpl implements CertificateOutRegistDao {

	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;
	
	@Override
	public D503Response saveD503(D503Request d503Request) {
		D503Response d503Response = new D503Response();
		D503 d503 = d503Request.getD503();
		d503.setD50305(new Date());
		Session session = this.sessionFactory.getCurrentSession();
		long result = (Long)session.save(d503);
		if(result > 0) {
			d503Response.setPromptMessage("出库成功!");
		} else {
			d503Response.setErrorMessage("出库失败!");
		}
		return d503Response;
	}

	@Override
	public D503Response queryD503(D503Request d503Request) {
		D503 d503 = d503Request.getD503();
		String d503_02_p = d503.getD50302();
		Date d503_05_p = d503.getD50305();
		Date d503_05_end_p = d503.getD50305End();
		
		String d503_11_p = d503.getD50311();
		String institutionCode = d503Request.getInstitutionCode();
		int parameterPageindex = d503Request.getParameterPageindex();
		int parameterPagesize = d503Request.getParameterPagesize();

		StringBuffer parameterConditionwhere = new StringBuffer();

		if (!StringUtil.isBlankString(d503_02_p)) {
			parameterConditionwhere.append(" and t.d503_02 = '");
			parameterConditionwhere.append(d503_02_p);
			parameterConditionwhere.append("'");
		} else {
			parameterConditionwhere.append(" and t.d503_02 in (select t.D101_01 from D101 t where t.D101_11 = '" + institutionCode +"' or t.D101_01 ='" + institutionCode + "')");
		}

		if (!StringUtil.isBlankString(d503_11_p)) {
			parameterConditionwhere.append(" and t.d503_11 = '");
			parameterConditionwhere.append(d503_11_p);
			parameterConditionwhere.append("'");
		}
		
		if (d503_05_p != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String d503_05_text = simpleDateFormat.format(d503_05_p);
			parameterConditionwhere.append(" and t.d503_05 >= to_date('" + d503_05_text + "', 'yyyy-mm-dd')");
		}

		if (d503_05_end_p != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String d503_05_end_text = simpleDateFormat.format(d503_05_end_p);
			parameterConditionwhere.append(" and t.d503_05 <= to_date('" + d503_05_end_text + "', 'yyyy-mm-dd')");
		}
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		D503Response d503Response = new D503Response();
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_D503");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D503_01");

			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			d503Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VD503 vd503 = null;
			List<VD503> vd503s = new ArrayList<VD503>();
			while (resultSet.next()) {

				Long d50301 = resultSet.getLong("D503_01");
				String d50302 = resultSet.getString("D503_02");
				String d50302Zh = resultSet.getString("D503_02_Zh");
				String d50303 = resultSet.getString("D503_03");
				long d50304 = resultSet.getLong("D503_04");
				Date d50305 = resultSet.getDate("D503_05");
				long d50306 = resultSet.getLong("D503_06");
				String d50307 = resultSet.getString("D503_07");
				String d50307Zh = resultSet.getString("D503_07_Zh");
				String d50308 = resultSet.getString("D503_08");
				String d50309 = resultSet.getString("D503_09");
				String d50310 = resultSet.getString("D503_10");

				String d50311 = resultSet.getString("D503_11");
				String d50312 = resultSet.getString("D503_12");
				String d50313 = resultSet.getString("D503_13");
				String d50314 = resultSet.getString("D503_14");
				String d50315 = resultSet.getString("D503_15");
				String d50316 = resultSet.getString("D503_16");
				String d50317 = resultSet.getString("D503_17");
				String d50318 = resultSet.getString("D503_18");
				String d50319 = resultSet.getString("D503_19");
				String d50320 = resultSet.getString("D503_20");

				String d50321 = resultSet.getString("D503_21");
				String d50322 = resultSet.getString("D503_22");
				String d50323 = resultSet.getString("D503_23");
				String d50324 = resultSet.getString("D503_24");
				String d50325 = resultSet.getString("D503_25");
				String d50326 = resultSet.getString("D503_26");
				String d50327 = resultSet.getString("D503_27");
				String d50328 = resultSet.getString("D503_28");
				String d50329 = resultSet.getString("D503_29");
				String d50330 = resultSet.getString("D503_30");

				String d50331 = resultSet.getString("D503_31");
				String d50332 = resultSet.getString("D503_32");
				String d50333 = resultSet.getString("D503_33");
				String d50334 = resultSet.getString("D503_34");
				String d50335 = resultSet.getString("D503_35");
				String d50336 = resultSet.getString("D503_36");
				String d50337 = resultSet.getString("D503_37");
				String d50338 = resultSet.getString("D503_38");
				String d50339 = resultSet.getString("D503_39");
				String d50340 = resultSet.getString("D503_40");

				String d50341 = resultSet.getString("D503_41");
				String d50342 = resultSet.getString("D503_42");
				String d50343 = resultSet.getString("D503_43");
				String d50344 = resultSet.getString("D503_44");
				String d50345 = resultSet.getString("D503_45");
				String d50346 = resultSet.getString("D503_46");
				String d50347 = resultSet.getString("D503_47");
				String d50348 = resultSet.getString("D503_48");
				String d50349 = resultSet.getString("D503_49");
				String d50350 = resultSet.getString("D503_50");

				vd503 = new VD503();

				vd503.setD50301(d50301);
				vd503.setD50302(d50302);
				vd503.setD50302Zh(d50302Zh);
				vd503.setD50303(d50303);
				vd503.setD50304(d50304);
				vd503.setD50305(d50305);
				vd503.setD50306(d50306);
				vd503.setD50307(d50307);
				vd503.setD50307Zh(d50307Zh);
				vd503.setD50308(d50308);
				vd503.setD50309(d50309);
				vd503.setD50310(d50310);
				vd503.setD50311(d50311);
				vd503.setD50312(d50312);
				vd503.setD50313(d50313);
				vd503.setD50314(d50314);
				vd503.setD50315(d50315);
				vd503.setD50316(d50316);
				vd503.setD50317(d50317);
				vd503.setD50318(d50318);
				vd503.setD50319(d50319);
				vd503.setD50320(d50320);
				vd503.setD50321(d50321);
				vd503.setD50322(d50322);
				vd503.setD50323(d50323);
				vd503.setD50324(d50324);
				vd503.setD50325(d50325);
				vd503.setD50326(d50326);
				vd503.setD50327(d50327);
				vd503.setD50328(d50328);
				vd503.setD50329(d50329);
				vd503.setD50330(d50330);
				vd503.setD50331(d50331);
				vd503.setD50332(d50332);
				vd503.setD50333(d50333);
				vd503.setD50334(d50334);
				vd503.setD50335(d50335);
				vd503.setD50336(d50336);
				vd503.setD50337(d50337);
				vd503.setD50338(d50338);
				vd503.setD50339(d50339);
				vd503.setD50340(d50340);
				vd503.setD50341(d50341);
				vd503.setD50342(d50342);
				vd503.setD50343(d50343);
				vd503.setD50344(d50344);
				vd503.setD50345(d50345);
				vd503.setD50346(d50346);
				vd503.setD50347(d50347);
				vd503.setD50348(d50348);
				vd503.setD50349(d50349);
				vd503.setD50350(d50350);

				vd503s.add(vd503);
			}
			d503Response.setVd503s(vd503s);
		} catch (Exception e) {
			d503Response.setErrorMessage("查询失败");
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
		return d503Response;
	}
}
