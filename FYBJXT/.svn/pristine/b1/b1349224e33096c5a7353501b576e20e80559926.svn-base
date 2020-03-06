package com.xyw.medical.birth.hfsqb.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.birth.hfsqb.dao.D306Dao;
import com.xyw.medical.birth.model.D306;
import com.xyw.medical.birth.model.D306Request;
import com.xyw.medical.birth.model.D306Response;
import com.xyw.medical.birth.model.VD306;
import com.xyw.medical.birth.model.VD306_;
import com.xyw.sys.util.StringUtil;

public class D306DaoImpl implements D306Dao{
	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private DataSource dataSource;
	
	private StringBuffer hql;
	private StringBuffer errorMessage;

	@SuppressWarnings("unchecked")
	@Override
	public D306Response saveD306(D306 d306) {
		D306Response d306Response =new D306Response();
		boolean state =true;
		String d30603_ =d306.getD30603();
		String d30604_ =d306.getD30604();
		
		Session session =sessionFactory.getCurrentSession();
		try {
			String sql = "select t.d306_01 from D306 t where t.D306_03 = ? and t.d306_04 = ? ";
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setString(0, d30603_);
			sqlQuery.setString(1, d30604_);
			List<Object> list = sqlQuery.list();
			if(list.size() > 0)
			{
				state = false;
				d306Response.setErrorMessage("重复登记!");
			}
			
		} catch (Exception e) {
			state = false;
			d306Response.setErrorMessage("保存失败！");
			e.printStackTrace();
		}
		if(state){
			try {
				session.save(d306);
				session.flush();
				session.refresh(d306);
			} catch (Exception e) {
				state =false;
				d306Response.setErrorMessage("保存失败! ");
				e.printStackTrace();
			}
		}
		d306Response.setState(state);
		return d306Response;
	}

	@Override
	public D306Response updateD306(D306 d306) {
		D306Response d306Response =new D306Response();
		boolean state =true;
		long d30601 =d306.getD30601();
		Session session =sessionFactory.getCurrentSession();
		List<Object> listD301 = null;
		try {
			StringBuffer sql = new StringBuffer("select * from d301 t where (t.d301_42 ='1' or t.d301_42='3') and t.d301_57 ="+d30601);
			SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
			listD301 = sqlQuery.list();
			if(listD301.size() >0){
				d306Response.setErrorMessage("换发打印已保存，不能修改!");
				state = false;
			}
		} catch (Exception e) {
			state = false;
			d306Response.setErrorMessage("保存失败！");
			e.printStackTrace();
		}
		if(state){
			try {
				session.saveOrUpdate(d306);
			} catch (Exception e) {
				state =false;
				errorMessage.append(e.getMessage());
				d306Response.setErrorMessage(errorMessage.toString());
				e.printStackTrace();
			}
		}
		d306Response.setState(state);
		return d306Response;
	}

	@Override
	public D306Response queryVD306s(D306Request d306Request) {
		D306Response d306Response =new D306Response();
		Date timeStr_ =d306Request.getTimeStr();
		Date timeEnd_ =d306Request.getTimeEnd();
		String d30603_ =d306Request.getD30603();
		String d30604_ =d306Request.getD30604();
		String d30606_ =d306Request.getD30606();
		String d30608_ =d306Request.getD30608();
		String d30622_ =d306Request.getD30622();
		
		String d30105_ =d306Request.getD30105();
		String d30131_ =d306Request.getD30131();
		String d30102_ =d306Request.getD30102();
		int parameterPageindex =d306Request.getParameterPageindex();
		int parameterPagesize =d306Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();

		if (!StringUtil.isBlankString(d30102_)) {
			parameterConditionwhere.append(" and t.d301_02 = '" + d30102_ + "'");
		}
		if (!StringUtil.isBlankString(d30603_)) {
			parameterConditionwhere.append(" and t.d306_03 = '" + d30603_ + "'");
		}
		if (!StringUtil.isBlankString(d30105_)) {
			parameterConditionwhere.append(" and t.d301_05 like '%" + d30105_ +"%'");
		}
		if (!StringUtil.isBlankString(d30131_)) {
			parameterConditionwhere.append(" and t.d301_31 like '%" + d30131_ +"%'");
		}
		if (!StringUtil.isBlankString(d30604_)) {
			parameterConditionwhere.append(" and t.d306_04 = '" + d30604_ + "'");
		}
		if (!StringUtil.isBlankString(d30606_)) {
			parameterConditionwhere.append(" and t.d306_06 = '" + d30606_ + "'");
		}
		if (!StringUtil.isBlankString(d30608_)) {
			parameterConditionwhere.append(" and t.d306_08 = '" + d30608_ + "'");
		}
		if (timeStr_ != null) {
			String timeStr = sdf.format(timeStr_);
			parameterConditionwhere.append(" and t.d306_23_str >= '"+ timeStr + "'");
		}
		if (timeEnd_ != null) {
			String timeEnd = sdf.format(timeEnd_);
			parameterConditionwhere.append(" and t.d306_23_str <= '"+ timeEnd + "'");
		}
		if (!StringUtil.isBlankString(d30622_)) {
			if (d30622_.length() == 14) {
				parameterConditionwhere.append(" and t.d306_22 = '");
				parameterConditionwhere.append(d30622_);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.d306_22 like '");
				parameterConditionwhere.append(d30622_);
				parameterConditionwhere.append("%'");
			}
		}

		boolean state =true;
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_D306");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D306_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			
			long rowCount = callableStatement.getLong(6);
			d306Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VD306 vd306 = null;
			List<VD306> vd306s = new ArrayList<VD306>();
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
				
				String d30102 = resultSet.getString("D301_02");
				String d30103 = resultSet.getString("D301_03");
				String d30104 = resultSet.getString("D301_04");
				String d30105Zh = resultSet.getString("D301_05_ZH");
				String d30106 = resultSet.getString("D301_06");
				int d30107 = resultSet.getInt("D301_07");
				double d30108 = resultSet.getDouble("D301_08");
				String d30109 = resultSet.getString("D301_09");
				String d30109Zh = resultSet.getString("D301_09_Zh");
				String d30110 = resultSet.getString("D301_10");
				String d30111 = resultSet.getString("D301_11");
				String d30112 = resultSet.getString("D301_12");
				String d30113 = resultSet.getString("D301_13");
				String d30114 = resultSet.getString("D301_14");
				String d30115 = resultSet.getString("D301_15");
				String d30116 = resultSet.getString("D301_16");
				String d30117 = resultSet.getString("D301_17");
				String d30118 = resultSet.getString("D301_18");
				String d30119 = resultSet.getString("D301_19");
				String d30120 = resultSet.getString("D301_20");
				String d30121 = resultSet.getString("D301_21");
				String d30122 = resultSet.getString("D301_22");
				String d30122Zh = resultSet.getString("D301_22_Zh");
				String d30123 = resultSet.getString("D301_23");
				String d30124 = resultSet.getString("D301_24");
				String d30124Zh = resultSet.getString("D301_24_Zh");
				String d30125 = resultSet.getString("D301_25");
				double d30129 = resultSet.getDouble("D301_29");
				String d30131Zh = resultSet.getString("D301_31_Zh");
				String d30132 = resultSet.getString("D301_32");
				String d30133 = resultSet.getString("D301_33");
				String d30134 = resultSet.getString("D301_34");
				String d30135 = resultSet.getString("D301_35");
				String d30136 = resultSet.getString("D301_36");
				String d30137 = resultSet.getString("D301_37");
				String d30137Zh = resultSet.getString("D301_37_Zh");
				String d30138 = resultSet.getString("D301_38");
				String d30138Zh = resultSet.getString("D301_38_Zh");
				String d30139 = resultSet.getString("D301_39");
				String d30140 = resultSet.getString("D301_40");
				String d30143 = resultSet.getString("D301_43");
				String d30147 = resultSet.getString("D301_47");
				String d30148 = resultSet.getString("D301_48");
				String d30153 = resultSet.getString("D301_53");
				String d30154 = resultSet.getString("D301_54");
				String d30155 = resultSet.getString("D301_55");
				String d30167 = resultSet.getString("D301_67");
				
				String d30127 = resultSet.getString("D301_27");
				
				String d30160 = resultSet.getString("D301_60");
				String d30161 = resultSet.getString("D301_61");
				String d30163 = resultSet.getString("D301_63");
				String d30164 = resultSet.getString("D301_64");
				
				vd306 =new VD306();
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
				
				vd306.setD30102(d30102);
				vd306.setD30103(d30103);
				vd306.setD30104(d30104);
				vd306.setD30106(d30106);
				vd306.setD30107(d30107);
				vd306.setD30108(d30108);
				vd306.setD30109(d30109);
				vd306.setD30109Zh(d30109Zh);
				vd306.setD30110(d30110);
				vd306.setD30111(d30111);
				vd306.setD30112(d30112);
				vd306.setD30113(d30113);
				vd306.setD30114(d30114);
				vd306.setD30115(d30115);
				vd306.setD30116(d30116);
				vd306.setD30117(d30117);
				vd306.setD30118(d30118);
				vd306.setD30119(d30119);
				vd306.setD30120(d30120);
				vd306.setD30121(d30121);
				vd306.setD30122(d30122);
				vd306.setD30122Zh(d30122Zh);
				vd306.setD30123(d30123);
				vd306.setD30124(d30124);
				vd306.setD30124Zh(d30124Zh);
				vd306.setD30125(d30125);
				vd306.setD30129(d30129);
				vd306.setD30132(d30132);
				vd306.setD30133(d30133);
				vd306.setD30134(d30134);
				vd306.setD30135(d30135);
				vd306.setD30136(d30136);
				vd306.setD30137(d30137);
				vd306.setD30137Zh(d30137Zh);
				vd306.setD30138(d30138);
				vd306.setD30138Zh(d30138Zh);
				vd306.setD30139(d30139);
				vd306.setD30140(d30140);
				vd306.setD30143(d30143);
				vd306.setD30147(d30147);
				vd306.setD30148(d30148);
				vd306.setD30105Zh(d30105Zh);
				vd306.setD30131Zh(d30131Zh);
				vd306.setD30127(d30127);
				vd306.setD30153(d30153);
				vd306.setD30154(d30154);
				vd306.setD30155(d30155);
				vd306.setD30167(d30167);
				
				vd306.setD30160(d30160);
				vd306.setD30161(d30161);
				vd306.setD30163(d30163);
				vd306.setD30164(d30164);
				vd306s.add(vd306);
			}
			d306Response.setVd306s(vd306s);
			d306Response.setState(state);
		}catch (Exception e) {
			d306Response.setState(false);
			d306Response.setErrorMessage("查询失败！");
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		return d306Response;
	}
	@Override
	public D306Response queryVD306s_new(D306Request d306Request) {
		D306Response d306Response =new D306Response();
		Date timeStr_ =d306Request.getTimeStr();
		Date timeEnd_ =d306Request.getTimeEnd();
		String d30603_ =d306Request.getD30603();
		String d30604_ =d306Request.getD30604();
		String d30606_ =d306Request.getD30606() ;
		String d30608_ =d306Request.getD30608();
		String d30622_ =d306Request.getD30622();
		long d30602_=d306Request.getD30602();
		
		String d30105_ =d306Request.getD30105();
		String d30131_ =d306Request.getD30131();
		String d30102_ =d306Request.getD30102();
		int parameterPageindex =d306Request.getParameterPageindex();
		int parameterPagesize =d306Request.getParameterPagesize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();

		if(d30602_ ==0){
			parameterConditionwhere.append(" and t.d306_02 = '" + d30602_ + "'");
		}
		if (!StringUtil.isBlankString(d30102_)) {
			parameterConditionwhere.append(" and t.d301_02 = '" + d30102_ + "'");
		}
		if (!StringUtil.isBlankString(d30603_)) {
			parameterConditionwhere.append(" and t.d306_03 = '" + d30603_ + "'");
		}
		if (!StringUtil.isBlankString(d30105_)) {
			parameterConditionwhere.append(" and t.d301_05 like '%" + d30105_ +"%'");
		}
		if (!StringUtil.isBlankString(d30131_)) {
			parameterConditionwhere.append(" and t.d301_31 like '%" + d30131_ +"%'");
		}
		if (!StringUtil.isBlankString(d30604_)) {
			parameterConditionwhere.append(" and t.d306_04 = '" + d30604_ + "'");
		}
		if (!StringUtil.isBlankString(d30606_)) {
			parameterConditionwhere.append(" and t.d306_06 = '" + d30606_ + "'");
		}
		if (!StringUtil.isBlankString(d30608_)) {
			parameterConditionwhere.append(" and t.d306_08 = '" + d30608_ + "'");
		}
		if (timeStr_ != null) {
			String timeStr = sdf.format(timeStr_);
			parameterConditionwhere.append(" and t.d306_23_str >= '"+ timeStr + "'");
		}
		if (timeEnd_ != null) {
			String timeEnd = sdf.format(timeEnd_);
			parameterConditionwhere.append(" and t.d306_23_str <= '"+ timeEnd + "'");
		}
		if (!StringUtil.isBlankString(d30622_)) {
			if (d30622_.length() == 14) {
				parameterConditionwhere.append(" and t.d306_22 = '");
				parameterConditionwhere.append(d30622_);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.d306_22 like '");
				parameterConditionwhere.append(d30622_);
				parameterConditionwhere.append("%'");
			}
		}

		boolean state =true;
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_D306");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D306_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			
			long rowCount = callableStatement.getLong(6);
			d306Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VD306 vd306 = null;
			List<VD306> vd306s = new ArrayList<VD306>();
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
				
				String d30102 = resultSet.getString("D301_02");
				String d30103 = resultSet.getString("D301_03");
				String d30104 = resultSet.getString("D301_04");
				String d30105Zh = resultSet.getString("D301_05_ZH");
				String d30106 = resultSet.getString("D301_06");
				int d30107 = resultSet.getInt("D301_07");
				double d30108 = resultSet.getDouble("D301_08");
				String d30109 = resultSet.getString("D301_09");
				String d30109Zh = resultSet.getString("D301_09_Zh");
				String d30110 = resultSet.getString("D301_10");
				String d30111 = resultSet.getString("D301_11");
				String d30112 = resultSet.getString("D301_12");
				String d30113 = resultSet.getString("D301_13");
				String d30114 = resultSet.getString("D301_14");
				String d30115 = resultSet.getString("D301_15");
				String d30116 = resultSet.getString("D301_16");
				String d30117 = resultSet.getString("D301_17");
				String d30118 = resultSet.getString("D301_18");
				String d30119 = resultSet.getString("D301_19");
				String d30120 = resultSet.getString("D301_20");
				String d30121 = resultSet.getString("D301_21");
				String d30122 = resultSet.getString("D301_22");
				String d30122Zh = resultSet.getString("D301_22_Zh");
				String d30123 = resultSet.getString("D301_23");
				String d30124 = resultSet.getString("D301_24");
				String d30124Zh = resultSet.getString("D301_24_Zh");
				String d30125 = resultSet.getString("D301_25");
				double d30129 = resultSet.getDouble("D301_29");
				String d30131Zh = resultSet.getString("D301_31_Zh");
				String d30132 = resultSet.getString("D301_32");
				String d30133 = resultSet.getString("D301_33");
				String d30134 = resultSet.getString("D301_34");
				String d30135 = resultSet.getString("D301_35");
				String d30136 = resultSet.getString("D301_36");
				String d30137 = resultSet.getString("D301_37");
				String d30137Zh = resultSet.getString("D301_37_Zh");
				String d30138 = resultSet.getString("D301_38");
				String d30138Zh = resultSet.getString("D301_38_Zh");
				String d30139 = resultSet.getString("D301_39");
				String d30140 = resultSet.getString("D301_40");
				String d30143 = resultSet.getString("D301_43");
				String d30147 = resultSet.getString("D301_47");
				String d30148 = resultSet.getString("D301_48");
				String d30153 = resultSet.getString("D301_53");
				String d30154 = resultSet.getString("D301_54");
				String d30155 = resultSet.getString("D301_55");
				String d30167 = resultSet.getString("D301_67");
				
				String d30127 = resultSet.getString("D301_27");
				
				String d30160 = resultSet.getString("D301_60");
				String d30161 = resultSet.getString("D301_61");
				String d30163 = resultSet.getString("D301_63");
				String d30164 = resultSet.getString("D301_64");
				
				vd306 =new VD306();
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
				
				vd306.setD30102(d30102);
				vd306.setD30103(d30103);
				vd306.setD30104(d30104);
				vd306.setD30106(d30106);
				vd306.setD30107(d30107);
				vd306.setD30108(d30108);
				vd306.setD30109(d30109);
				vd306.setD30109Zh(d30109Zh);
				vd306.setD30110(d30110);
				vd306.setD30111(d30111);
				vd306.setD30112(d30112);
				vd306.setD30113(d30113);
				vd306.setD30114(d30114);
				vd306.setD30115(d30115);
				vd306.setD30116(d30116);
				vd306.setD30117(d30117);
				vd306.setD30118(d30118);
				vd306.setD30119(d30119);
				vd306.setD30120(d30120);
				vd306.setD30121(d30121);
				vd306.setD30122(d30122);
				vd306.setD30122Zh(d30122Zh);
				vd306.setD30123(d30123);
				vd306.setD30124(d30124);
				vd306.setD30124Zh(d30124Zh);
				vd306.setD30125(d30125);
				vd306.setD30129(d30129);
				vd306.setD30132(d30132);
				vd306.setD30133(d30133);
				vd306.setD30134(d30134);
				vd306.setD30135(d30135);
				vd306.setD30136(d30136);
				vd306.setD30137(d30137);
				vd306.setD30137Zh(d30137Zh);
				vd306.setD30138(d30138);
				vd306.setD30138Zh(d30138Zh);
				vd306.setD30139(d30139);
				vd306.setD30140(d30140);
				vd306.setD30143(d30143);
				vd306.setD30147(d30147);
				vd306.setD30148(d30148);
				vd306.setD30105Zh(d30105Zh);
				vd306.setD30131Zh(d30131Zh);
				vd306.setD30127(d30127);
				vd306.setD30153(d30153);
				vd306.setD30154(d30154);
				vd306.setD30155(d30155);
				vd306.setD30167(d30167);
				
				vd306.setD30160(d30160);
				vd306.setD30161(d30161);
				vd306.setD30163(d30163);
				vd306.setD30164(d30164);
				vd306s.add(vd306);
			}
			d306Response.setVd306s(vd306s);
			d306Response.setState(state);
		}catch (Exception e) {
			d306Response.setState(false);
			d306Response.setErrorMessage("查询失败！");
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		return d306Response;
	}
	@Override
	public D306Response queryVD306(D306Request d306Request) {
		D306Response d306Response =new D306Response();
		String d30102_ =d306Request.getD30102();
		String d30603_ =d306Request.getD30603();
		String d30613_ =d306Request.getD30613();
		
		this.errorMessage = new StringBuffer();
		this.hql = new StringBuffer("from VD306 t where 1=1 ");   //"from v_d306 t where 1=1 where t.d301_02 = ？  and t.d306_03 =？ "
		if(!StringUtil.isBlankString(d30102_))
		{
			this.hql.append(" and t.d30102 = '" + d30102_ + "'");
		}
		if(!StringUtil.isBlankString(d30603_))
		{
			this.hql.append(" and t.d30603 = '" + d30603_ + "'");
		}
		if(!StringUtil.isBlankString(d30613_))
		{
			this.hql.append(" and t.d30613 = '" + d30613_ + "'");
		}
		Query query = null;
		Session session = null;
		VD306 vd306=null;
		try {
			session = sessionFactory.getCurrentSession();
			query = session.createQuery(this.hql.toString());
			vd306 =(VD306) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			this.errorMessage.append("查询失败!");
		}
		if(vd306 !=null){
			d306Response.setVd306(vd306);
			d306Response.setState(true);
		}else{
			d306Response.setState(false);
			this.errorMessage.append("没有相关信息!");
		}
		d306Response.setErrorMessage(this.errorMessage.toString());
		return d306Response;
	}
	
	@Override
	public D306Response queryVD306_new(D306Request d306Request) {
		D306Response d306Response =new D306Response();
		String d30604_ =d306Request.getD30604();
		String d30603_ =d306Request.getD30603();
		String d30613_ =d306Request.getD30613();
		long d30602_ =d306Request.getD30602();
		
		this.errorMessage = new StringBuffer();
		this.hql = new StringBuffer("from VD306_ t where 1=1 ");   //"from v_d306 t where 1=1 where t.d301_02 = ？  and t.d306_03 =？ "
		if(!StringUtil.isBlankString(d30604_))
		{
			this.hql.append(" and t.d30604 = '" + d30604_ + "'");
		}
		if(!StringUtil.isBlankString(d30603_))
		{
			this.hql.append(" and t.d30603 = '" + d30603_ + "'");
		}
		if(!StringUtil.isBlankString(d30613_))
		{
			this.hql.append(" and t.d30613 = '" + d30613_ + "'");
		}
		if(d30602_ ==0){
			this.hql.append(" and t.d30602 = '" + d30602_ + "'");
		}

		Query query = null;
		Session session = null;
		VD306_ vd306=null;
		try {
			session = sessionFactory.getCurrentSession();
			query = session.createQuery(this.hql.toString());
			vd306 =(VD306_) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			this.errorMessage.append("查询失败!");
		}
		if(vd306 !=null){
			d306Response.setVd306_(vd306);
			d306Response.setState(true);
		}else{
			d306Response.setState(false);
			this.errorMessage.append("没有相关信息!");
		}
		d306Response.setErrorMessage(this.errorMessage.toString());
		return d306Response;
	}

	@Override
	public D306Response deleteD306(D306Request d306Request) {
		boolean state =true;
		D306Response d306Response =new D306Response();
		long d30601 =d306Request.getD30601();
		
		Session session =sessionFactory.getCurrentSession();
		List<Object> listD301 = null;
		try {
			StringBuffer sql = new StringBuffer("select * from d301 t where (t.d301_42 ='1' or t.d301_42='3') and t.d301_57 ="+d30601);
			SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
			listD301 = sqlQuery.list();
			if(listD301.size() >0){
				d306Response.setErrorMessage("换发打印已保存，不能删除!");
				state = false;
			}
		} catch (Exception e) {
			state = false;
			d306Response.setErrorMessage("删除失败！");
			e.printStackTrace();
		}
		if(state){
			try {
				D306 d306 =new D306();
				d306.setD30601(d30601);
				session.delete(d306);
				d306Response.setPromptMessage("删除成功！");
			} catch (Exception e) {
				state =false;
				d306Response.setErrorMessage("删除失败！");
				e.printStackTrace();
			}
		}
		d306Response.setState(state);
		return d306Response;
	}
}


