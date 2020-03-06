package com.xyw.medical.etbj.etbjdj.dao.impl;

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
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.springframework.util.Assert;

import com.xyw.medical.etbj.etbjdj.dao.E301Dao;
import com.xyw.medical.etbj.model.E301;
import com.xyw.medical.etbj.model.E301Request;
import com.xyw.medical.etbj.model.E301Response;
import com.xyw.medical.etbj.model.VE301;
import com.xyw.sys.util.StringUtil;

public class E301DaoImpl implements E301Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;


	@Override
	public E301Response updateE301(E301 e301) {
		E301Response e301Response = new E301Response();
		long e301_01 = e301.getE30101();
		String e301_03 = e301.getE30103();
		String e301_26 = e301.getE30126();
		String e301_27 = e301.getE30127();
		
		boolean state = true;
		Session session = this.sessionFactory.getCurrentSession();
		
		StringBuffer sqle2 = new StringBuffer("select t.e302_01 from E302 t where 1=1 and t.e302_02 ='" + e301_01 + "'");
		StringBuffer sqle3 = new StringBuffer("select t.e303_01 from E303 t where 1=1 and t.e303_02 ='" + e301_01 + "'");
		StringBuffer sqle5 = new StringBuffer("select t.e305_01 from E305 t where 1=1 and t.e305_78 ='" + e301_01 + "'");
		StringBuffer sqld6 = new StringBuffer("select t.d606_01 from D606 t where 1=1 and t.d606_61 ='" + e301_01 + "'");
		StringBuffer sqle7 = new StringBuffer("select t.e304_01 from E304 t where 1=1 and t.e304_40 ='" + e301_01 + "'");
		StringBuffer sqle8 = new StringBuffer("select t.e701_01 from E701 t where 1=1 and t.e701_02 ='" + e301_01 + "'");
		try {
			SQLQuery query2 = session.createSQLQuery(sqle2.toString());
			int size2 = query2.list().size();

			SQLQuery query3 = session.createSQLQuery(sqle3.toString());
			int size3 = query3.list().size();
			
			SQLQuery query5 = session.createSQLQuery(sqle5.toString());
			int size5 = query5.list().size();

			SQLQuery query6 = session.createSQLQuery(sqld6.toString());
			int size6 = query6.list().size();

			SQLQuery query7 = session.createSQLQuery(sqle7.toString());
			int size7 = query7.list().size();
			
			SQLQuery query8 = session.createSQLQuery(sqle8.toString());
			int size8 = query8.list().size();
			StringBuffer mess = new StringBuffer();
			if (size2 > 0 || size3 > 0 || size5>0 || size6 > 0 || size7 > 0 || size8 > 0) {
				mess.append("已填过");
				if (size2 > 0)
					mess.append("新生儿疾病筛查表  ");
				if (size3 > 0)
					mess.append("体弱儿登记  ");
				if (size5 > 0)
					mess.append("新生儿家庭访视表  ");
				if (size6 > 0)
					mess.append("缺陷儿登记卡  ");
				if (size7 > 0)
					mess.append("儿童健康检查 ");
				if (size8 > 0)
					mess.append("儿童视力档案 ");
				mess.append("，不能修改！");

				e301Response.setErrorMessage(mess.toString());
				state =false;
				e301Response.setState(state);
				return e301Response;
			}
			int sizee = session.createSQLQuery("select t.e301_01 from e301 t where t.e301_03 = '"+e301_03+"' and t.e301_26 = '"+e301_26+"' and t.e301_27 = '"+e301_27+"' and t.e301_01 != '"+e301_01+"'").list().size();
			if(sizee>0){
				state = false;
				e301Response.setErrorMessage("已存在同一个母亲且儿童姓名相同的档案,请核对信息!");
			}
		} catch (HibernateException e) {
			e301Response.setErrorMessage("保存失败! ");
			e.printStackTrace();
			state =false;
		}
		if(state){
			try {
				session.saveOrUpdate(e301);
			} catch (Exception e) {
				e301Response.setErrorMessage("保存失败! ");
				e.printStackTrace();
				state =false;
			}
		}	
		
		e301Response.setState(state);
		return e301Response;
	}

	@Override
	public E301Response deleteE301(E301Request e301Request) {
		E301Response e301Response = new E301Response();
		long e301_01 = e301Request.getE30101();

		StringBuffer sqle2 = new StringBuffer("select t.e302_01 from E302 t where 1=1 and t.e302_02 ='" + e301_01 + "'");
		StringBuffer sqle3 = new StringBuffer("select t.e303_01 from E303 t where 1=1 and t.e303_02 ='" + e301_01 + "'");
		StringBuffer sqle5 = new StringBuffer("select t.e305_01 from E305 t where 1=1 and t.e305_78 ='" + e301_01 + "'");
		StringBuffer sqld6 = new StringBuffer("select t.d606_01 from D606 t where 1=1 and t.d606_61 ='" + e301_01 + "'");
		StringBuffer sqle4 = new StringBuffer("select t.e304_01 from E304 t where 1=1 and t.e304_40 ='" + e301_01 + "'");
		StringBuffer sqle8 = new StringBuffer("select t.e701_01 from E701 t where 1=1 and t.e701_02 ='" + e301_01 + "'");

		try {
			Session session = sessionFactory.getCurrentSession();
			SQLQuery query2 = session.createSQLQuery(sqle2.toString());
			int size2 = query2.list().size();

			SQLQuery query3 = session.createSQLQuery(sqle3.toString());
			int size3 = query3.list().size();
			
			SQLQuery query5 = session.createSQLQuery(sqle5.toString());
			int size5 = query5.list().size();

			SQLQuery query6 = session.createSQLQuery(sqld6.toString());
			int size6 = query6.list().size();

			SQLQuery query7 = session.createSQLQuery(sqle4.toString());
			int size7 = query7.list().size();
			
			SQLQuery query8 = session.createSQLQuery(sqle8.toString());
			int size8 = query8.list().size();
			StringBuffer mess = new StringBuffer();
			if (size2 > 0 || size3 > 0 || size5>0 || size6 > 0 || size7 > 0 || size8 > 0) {
				mess.append("已填过");
				if (size2 > 0)
					mess.append("新生儿疾病筛查表  ");
				if (size3 > 0)
					mess.append("体弱儿登记  ");
				if (size5 > 0)
					mess.append("新生儿家庭访视表  ");
				if (size6 > 0)
					mess.append("缺陷儿登记卡  ");
				if (size7 > 0)
					mess.append("儿童健康检查 ");
				if (size8 > 0)
					mess.append("儿童视力档案 ");
				mess.append("，不能删除！");

				e301Response.setErrorMessage(mess.toString());
				return e301Response;
			}

			E301 e301 = new E301();
			e301.setE30101(e301_01);
			session.delete(e301);
			e301Response.setPromptMessage("删除成功！");
		} catch (HibernateException e) {
			e.printStackTrace();
			e301Response.setErrorMessage("删除失败！");
		}
		return e301Response;
	}
	
	@Override
	public E301Response queryE301(E301Request e301Request) {
		boolean state = true;
		E301Response e301Response = new E301Response();
		long e301_01 = e301Request.getE30101();
		long e301_02 = e301Request.getE30102();
		String e301_03 = e301Request.getE30103();
		String e301_05 = e301Request.getE30105();
		
		String e301_09 = e301Request.getE30109();
		String e301_12 = e301Request.getE30112();
		
		String e301_13 = e301Request.getE30113();
		Date e300114Start = e301Request.getE30114Start();
		Date e30114End = e301Request.getE30114End();
		
		Date e30131Start = e301Request.getE30131Start();
		Date e30131End = e301Request.getE30131End();

		
		String e301_33 = e301Request.getE30133();
		String e301_17 = e301Request.getE30117();
		int parameterPageindex = e301Request.getParameterPageindex();
		int parameterPagesize = e301Request.getParameterPagesize();
		String flag = e301Request.getFlag();

		String f301_02 = e301Request.getF30102();
		String f301_05 = e301Request.getF30105();

		String e301_11 = e301Request.getE30111();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sql = new StringBuffer();
		if (e301_01 > 0) {
			sql.append(" and t.e301_01=" + e301_01);
		}
		
		if (e301_02 > 0) {
			sql.append(" and t.e301_02='" + e301_02 + "' ");
		}
		if (!StringUtil.isBlankString(e301_03)) {
			sql.append(" and t.e301_03='" + e301_03 + "' ");
		}
		if (!StringUtil.isBlankString(e301_05)) {
			sql.append(" and t.e301_05='" + e301_05 + "' ");
		}
		if(!StringUtil.isBlankString(e301_09)){
			sql.append(" and t.e301_09 like '" + e301_09 +"%' ");
		}
		if(!StringUtil.isBlankString(e301_12)){
			sql.append(" and t.e301_12 like '" + e301_12 +"%' ");
		}
		if (e300114Start != null) {
			String e300114Start_ = sdf.format(e300114Start);
			sql.append(" and t.e301_14_Str >='" + e300114Start_ + "' ");
		}
		if (!StringUtil.isBlankString(e301_13)) {
			sql.append(" and t.e301_13='" + e301_13 + "' ");
		}
		if (e30114End != null) {
			String e30114End_ = sdf.format(e30114End);
			sql.append(" and t.e301_14_Str <='" + e30114End_ + "' ");
		}
		if (!StringUtil.isBlankString(e301_17)) {
			sql.append(" and t.e301_17='" + e301_17 + "' ");
		}
		if(e30131Start != null){
			String e30131Start_ = sdf.format(e30131Start);
			sql.append(" and t.e301_31_str >='" + e30131Start_ + "'");
		}
		if(e30131End != null){
			String e30131End_ = sdf.format(e30131End);
			sql.append(" and t.e301_31_str <='" + e30131End_ + "'"); 
		}
		if (!StringUtil.isBlankString(e301_33)) {
			if (e301_33.length() == 14) {
				sql.append(" and t.e301_33 = '");
				sql.append(e301_33);
				sql.append("'");
			} else {
				sql.append(" and t.e301_33 like '");
				sql.append(e301_33);
				sql.append("%'");
			}
		}
		if (!StringUtil.isBlankString(f301_02)) {
			sql.append(" and t.e301_26='" + f301_02 + "' ");
		}
		if (!StringUtil.isBlankString(f301_05)) {
			sql.append(" and t.e301_27='" + f301_05 + "' ");
		}
		if (!StringUtil.isBlankString(e301_11)){
			sql.append(" and t.e301_11='" + e301_11 + "' ");		
		}
		


		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_E301");
			callableStatement.setString(4, sql.toString());
			callableStatement.setString(5, "t.e301_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			e301Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			
			VE301 ve301 = null;
			List<VE301> ve301s = new ArrayList<VE301>();
			while (resultSet.next()) {
				long e30101 = resultSet.getLong("E301_01");
				long e30102 = resultSet.getLong("E301_02");
				String e30103 = resultSet.getString("E301_03");
				String e30104 = resultSet.getString("E301_04");
				String e30105 = resultSet.getString("E301_05");
				Date e30106 = resultSet.getDate("E301_06");
				String e30107 = resultSet.getString("e301_07");
				String e30108 = resultSet.getString("E301_08");
				String e30109 = resultSet.getString("E301_09");
				String e30110 = resultSet.getString("E301_10");
				String e30111 = resultSet.getString("E301_11");
				String e30112 = resultSet.getString("E301_12");
				String e30113 = resultSet.getString("E301_13");
				Date e30114 = resultSet.getDate("E301_14");
				String e30115 = resultSet.getString("E301_15");
				String e30116 = resultSet.getString("E301_16");
				String e30117 = resultSet.getString("E301_17");
				String e30118 = resultSet.getString("E301_18");
				double e30119 = resultSet.getDouble("E301_19");
				//long e30119 = resultSet.getLong("E301_19");
				String e30120 = resultSet.getString("E301_20");
				String e30121 = resultSet.getString("E301_21");
				long e30122 = resultSet.getLong("E301_22");
				long e30123 = resultSet.getLong("E301_23");
				long e30124 = resultSet.getLong("E301_24");
				String e30125 = resultSet.getString("E301_25");
				String e30126 = resultSet.getString("E301_26");
				String e30127 = resultSet.getString("E301_27");
				String e30128 = resultSet.getString("E301_28");
				String e30129 = resultSet.getString("E301_29");
				String e30130 = resultSet.getString("E301_30");
				Date e30131 = resultSet.getDate("E301_31");
				String e30132 = resultSet.getString("E301_32");
				String e30133 = resultSet.getString("E301_33");
				String e30134 = resultSet.getString("E301_34");
				String e30135 = resultSet.getString("E301_35");
				String e30136 = resultSet.getString("E301_36");
				String e30137 = resultSet.getString("E301_37");
				String e30138 = resultSet.getString("E301_38");
				String e30139 = resultSet.getString("E301_39");
				String e30140 = resultSet.getString("E301_40");
				String e30141 = resultSet.getString("E301_41");
				String e30142 = resultSet.getString("E301_42");
				String e30143 = resultSet.getString("E301_43");
				String e30144 = resultSet.getString("E301_44");
				String e30145 = resultSet.getString("E301_45");
				String e30146 = resultSet.getString("E301_46");
				String e30147 = resultSet.getString("E301_47");
				String e30148 = resultSet.getString("E301_48");
				String e30149 = resultSet.getString("E301_49");
				String e30150 = resultSet.getString("E301_50");
				
				String e30104Zh = resultSet.getString("E301_04_ZH");
				String e30107Zh = resultSet.getString("E301_07_ZH");
				String e30106Str = resultSet.getString("E301_06_Str");
				String e30108Zh = resultSet.getString("E301_08_ZH");
				if(e30132 == null){e30132 = "";}
				String e30109Zh = resultSet.getString("E301_09_ZH");
						
				String e30112Zh = resultSet.getString("E301_12_ZH");
				String e30114Str = resultSet.getString("E301_14_Str");
				String e30116Zh = resultSet.getString("E301_16_ZH");
				String e30131Str = resultSet.getString("E301_31_Str");
				
				String f30102 = resultSet.getString("F301_02");
				String f30103 = resultSet.getString("F301_03");
				String f30104 = resultSet.getString("F301_04");
				String f30105 = resultSet.getString("F301_05");
				Date f30106 = resultSet.getDate("F301_06");
				String f30106Str = resultSet.getString("F301_06_Str");
				String f30108 = resultSet.getString("F301_08");
				String f30109 = resultSet.getString("F301_09");
				String f30113 = resultSet.getString("F301_13");
				String f30114 = resultSet.getString("F301_14");
				String f30118 = resultSet.getString("F301_18");
				String f30120 = resultSet.getString("F301_20");
				String f30121 = resultSet.getString("F301_21");
				Date f30122 = resultSet.getDate("F301_22");
				String f30122Str = resultSet.getString("F301_22_Str");
				String f30135 = resultSet.getString("F301_35");
				String f30147 = resultSet.getString("F301_47");
				
				String f30111 = resultSet.getString("F301_11");
				String f30127 = resultSet.getString("F301_27");
				String f30128 = resultSet.getString("F301_28");
				String f30107 = resultSet.getString("F301_07");
				String f30110 = resultSet.getString("F301_10");
				String f30123 = resultSet.getString("F301_23");
				String f30126 = resultSet.getString("F301_26");
				
				ve301 = new VE301();
				ve301.setE30101(e30101);
				ve301.setE30102(e30102);
				ve301.setE30103(e30103);
				ve301.setE30104(e30104);
				ve301.setE30105(e30105);
				ve301.setE30106(e30106);
				ve301.setE30107(e30107);
				ve301.setE30108(e30108);
				ve301.setE30109(e30109);
				ve301.setE30110(e30110);
				ve301.setE30111(e30111);
				ve301.setE30112(e30112);
				ve301.setE30113(e30113);
				ve301.setE30114(e30114);
				ve301.setE30115(e30115);
				ve301.setE30116(e30116);
				ve301.setE30117(e30117);
				ve301.setE30118(e30118);
				ve301.setE30119(e30119);
				ve301.setE30120(e30120);
				ve301.setE30121(e30121);
				ve301.setE30122(e30122);
				ve301.setE30123(e30123);
				ve301.setE30124(e30124);
				ve301.setE30125(e30125);
				ve301.setE30126(e30126);
				ve301.setE30127(e30127);
				ve301.setE30128(e30128);
				ve301.setE30129(e30129);
				ve301.setE30130(e30130);
				ve301.setE30131(e30131);
				ve301.setE30132(e30132);
				ve301.setE30133(e30133);
				ve301.setE30134(e30134);
				ve301.setE30135(e30135);
				ve301.setE30136(e30136);
				ve301.setE30137(e30137);
				ve301.setE30138(e30138);
				ve301.setE30139(e30139);
				ve301.setE30140(e30140);
				ve301.setE30141(e30141);
				ve301.setE30142(e30142);
				ve301.setE30143(e30143);
				ve301.setE30144(e30144);
				ve301.setE30145(e30145);
				ve301.setE30146(e30146);
				ve301.setE30147(e30147);
				ve301.setE30148(e30148);
				ve301.setE30149(e30149);
				ve301.setE30150(e30150);
				
				ve301.setE30104Zh(e30104Zh);
				ve301.setE30106Str(e30106Str);
				ve301.setE30107Zh(e30107Zh);
				ve301.setE30108Zh(e30108Zh);
				ve301.setE30109Zh(e30109Zh);
				ve301.setE30112Zh(e30112Zh);
				ve301.setE30114Str(e30114Str);
				ve301.setE30116Zh(e30116Zh);
				ve301.setE30131Str(e30131Str);
				
				ve301.setF30102(f30102);
				ve301.setF30103(f30103);
				ve301.setF30104(f30104);
				ve301.setF30105(f30105);
				ve301.setF30106(f30106);
				ve301.setF30106Str(f30106Str);
				ve301.setF30108(f30108);
				ve301.setF30109(f30109);
				ve301.setF30113(f30113);
				ve301.setF30114(f30114);
				ve301.setF30118(f30118);
				ve301.setF30120(f30120);
				ve301.setF30121(f30121);
				ve301.setF30122(f30122);
				ve301.setF30122Str(f30122Str);
				ve301.setF30135(f30135);
				ve301.setF30147(f30147);
				
				ve301.setF30111(f30111);
				ve301.setF30127(f30127);
				ve301.setF30128(f30128);
				ve301.setF30107(f30107);
				ve301.setF30110(f30110);
				ve301.setF30123(f30123);
				ve301.setF30126(f30126);
				ve301s.add(ve301);
			}
			e301Response.setState(state);
			e301Response.setVe301s(ve301s);
		} catch (SQLException e) {
			e.printStackTrace();
			e301Response.setState(false);
			e301Response.setErrorMessage("查询失败！");
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
				e.printStackTrace();
			}
		}

		return e301Response;
	}
	
	@Override
	public E301Response saveE301(E301 e301) {
		E301Response e301Response = new E301Response();
		
		
		String e30103 = e301.getE30103();
		String e30126 = e301.getE30126();
		String e30127 = e301.getE30127();
		
		
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
				SQLQuery query = session.createSQLQuery("select t.e301_33,t.e301_31 from E301 t where t.E301_03 = '"+e30103+"'"+" and t.E301_27 ='"+e30127+"'"+" and t.E301_26 ='"+e30126+"'");
				Object[] list1 = (Object[]) query.uniqueResult();
				if (list1 != null && list1[0] != null) {
					e301Response.setState(false);
					Object uniqueResult = session.createSQLQuery("select d101_02 from d101 where d101_01 = '"+list1[0]+"'").uniqueResult();
					e301Response.setErrorMessage("该信息已经被" + uniqueResult.toString() + "于"
							+ new DateTime(list1[1]).toString("yyyy-MM-dd")
							+ "登记过档案！不能重复登记");	
					return e301Response;
				}
			List list = session.createSQLQuery("select e.e301_25 from E301 e where e.e301_02 = '"+e301.getE30102()+"'").list();
			handleE30125(e301,list);
		} catch (Exception e) {
			state = false;
			e301Response.setErrorMessage("保存出错! ");
			e.printStackTrace();
		}
		
		if (state) {
			try {
				Date DateTemp = new Date();
				e301.setE30131(DateTemp);
				session.save(e301);
				session.flush();
				session.refresh(e301);
			} catch (Exception e) {
				e.printStackTrace();
				e301Response.setErrorMessage("保存失败!");
				state = false;
			}
		}
		
		e301Response.setState(state);
		return e301Response;
	}
	@Override
	public E301Response queryE301All(E301Request e301Request) {
		boolean state = true;
		Session session = this.sessionFactory.getCurrentSession();
		E301Response e301Response = new E301Response();
		List<VE301> list = new ArrayList<VE301>();
		VE301 ve301 = null;
		String e30117_ = e301Request.getE30117();
		String e30126_ = e301Request.getE30126();
		String e30127_ = e301Request.getE30127();
		String e30103 = null;
		try{
		StringBuffer sb = new StringBuffer(" select * from V_E301 t where 1=1");
		if (!StringUtil.isBlankString(e30117_)) {
			sb.append(" and t.e301_17='" + e30117_ + "' ");
		}
		if (!StringUtil.isBlankString(e30126_)) {
			sb.append(" and t.e301_26='" + e30126_ + "' ");
		}
		if (!StringUtil.isBlankString(e30127_)) {
			sb.append(" and t.e301_27='" + e30127_ + "' ");
		}
		List<VE301> ve = session.createSQLQuery(sb.toString()).addEntity(VE301.class).list();
		if(ve.size()<1){
			e301Response.setPromptMessage("此人档案不存在，请检查！");
		}
		for(int i=0;i<ve.size();i++){
			ve301 = new VE301();
			long e30101 = ve.get(i).getE30101();
			long e30102 = ve.get(i).getE30102();
			 e30103 = ve.get(i).getE30103();
			String e30104 = ve.get(i).getE30104();
			String e30105 = ve.get(i).getE30105();
			Date e30106 = ve.get(i).getE30106();
			String e30107 = ve.get(i).getE30107();
			String e30108 = ve.get(i).getE30108();
			String e30109 = ve.get(i).getE30109();
			String e30110 = ve.get(i).getE30110();;
			String e30111 = ve.get(i).getE30111();
			String e30112 = ve.get(i).getE30112();
			String e30113 = ve.get(i).getE30113();
			Date e30114 = ve.get(i).getE30114();
			String e30115 = ve.get(i).getE30115();
			String e30116 = ve.get(i).getE30116();
			String e30117= ve.get(i).getE30117();
			String e30118 = ve.get(i).getE30118();
			double e30119 = ve.get(i).getE30119();
			//long e30119 = resultSet.getLong("E301_19");
			String e30120 = ve.get(i).getE30120();
			String e30121 = ve.get(i).getE30121();;
			long e30122 = ve.get(i).getE30122();
			long e30123 = ve.get(i).getE30123();
			long e30124 = ve.get(i).getE30124();
			String e30125 = ve.get(i).getE30125();
			String e30126 = ve.get(i).getE30126();
			String e30127 = ve.get(i).getE30127();
			String e30128 = ve.get(i).getE30128();
			String e30129 = ve.get(i).getE30129();
			String e30130 = ve.get(i).getE30130();
			Date e30131 = ve.get(i).getE30131();
			String e30132 = ve.get(i).getE30132();
			String e30133 = ve.get(i).getE30133();
			String e30134 = ve.get(i).getE30134();
			String e30135 = ve.get(i).getE30135();
			String e30136 = ve.get(i).getE30136();
			String e30137 = ve.get(i).getE30137();
			String e30138 = ve.get(i).getE30138();
			String e30139 = ve.get(i).getE30139();
			String e30140 = ve.get(i).getE30140();
			String e30141 = ve.get(i).getE30141();
			String e30142 = ve.get(i).getE30142();
			String e30143 = ve.get(i).getE30143();
			String e30144 = ve.get(i).getE30144();
			String e30145 = ve.get(i).getE30145();
			String e30146 = ve.get(i).getE30146();
			String e30147 = ve.get(i).getE30147();
			String e30148 = ve.get(i).getE30148();
			String e30149 = ve.get(i).getE30149();
			String e30150 = ve.get(i).getE30150();
			
			String e30104Zh = ve.get(i).getE30104Zh();
			String e30107Zh = ve.get(i).getE30107Zh();
			String e30106Str = ve.get(i).getE30106Str();
			String e30108Zh = ve.get(i).getE30108Zh();
			if(e30132 == null){e30132 = "";}
			String e30109Zh = ve.get(i).getE30109Zh();
					
			String e30112Zh = ve.get(i).getE30112Zh();
			String e30114Str = ve.get(i).getE30114Str();
			String e30116Zh = ve.get(i).getE30116Zh();
			String e30131Str = ve.get(i).getE30131Str();
			
			String f30102 = ve.get(i).getF30102();
			String f30103 = ve.get(i).getF30103();
			String f30104 = ve.get(i).getF30104();
			String f30105 = ve.get(i).getF30105();
			Date f30106 = ve.get(i).getF30106();
			String f30106Str = ve.get(i).getF30106Str();
			String f30108 = ve.get(i).getF30108();
			String f30109 = ve.get(i).getF30109();
			String f30113 =ve.get(i).getF30113();
			String f30114 = ve.get(i).getF30114();
			String f30118 = ve.get(i).getF30118();
			String f30120 = ve.get(i).getF30120();
			String f30121 = ve.get(i).getF30121();
			Date f30122 =ve.get(i).getF30122();
			String f30122Str = ve.get(i).getF30122Str();
			String f30135 = ve.get(i).getF30135();
			String f30147 = ve.get(i).getF30147();
			
			String f30111 = ve.get(i).getF30111();
			String f30127 = ve.get(i).getF30127();
			String f30128 = ve.get(i).getF30128();
			ve301.setE30101(e30101);
			ve301.setE30102(e30102);
			ve301.setE30103(e30103);
			ve301.setE30104(e30104);
			ve301.setE30105(e30105);
			ve301.setE30106(e30106);
			ve301.setE30107(e30107);
			ve301.setE30108(e30108);
			ve301.setE30109(e30109);
			ve301.setE30110(e30110);
			ve301.setE30111(e30111);
			ve301.setE30112(e30112);
			ve301.setE30113(e30113);
			ve301.setE30114(e30114);
			ve301.setE30115(e30115);
			ve301.setE30116(e30116);
			ve301.setE30117(e30117);
			ve301.setE30118(e30118);
			ve301.setE30119(e30119);
			ve301.setE30120(e30120);
			ve301.setE30121(e30121);
			ve301.setE30122(e30122);
			ve301.setE30123(e30123);
			ve301.setE30124(e30124);
			ve301.setE30125(e30125);
			ve301.setE30126(e30126);
			ve301.setE30127(e30127);
			ve301.setE30128(e30128);
			ve301.setE30129(e30129);
			ve301.setE30130(e30130);
			ve301.setE30131(e30131);
			ve301.setE30132(e30132);
			ve301.setE30133(e30133);
			ve301.setE30134(e30134);
			ve301.setE30135(e30135);
			ve301.setE30136(e30136);
			ve301.setE30137(e30137);
			ve301.setE30138(e30138);
			ve301.setE30139(e30139);
			ve301.setE30140(e30140);
			ve301.setE30141(e30141);
			ve301.setE30142(e30142);
			ve301.setE30143(e30143);
			ve301.setE30144(e30144);
			ve301.setE30145(e30145);
			ve301.setE30146(e30146);
			ve301.setE30147(e30147);
			ve301.setE30148(e30148);
			ve301.setE30149(e30149);
			ve301.setE30150(e30150);
			
			ve301.setE30104Zh(e30104Zh);
			ve301.setE30106Str(e30106Str);
			ve301.setE30107Zh(e30107Zh);
			ve301.setE30108Zh(e30108Zh);
			ve301.setE30109Zh(e30109Zh);
			ve301.setE30112Zh(e30112Zh);
			ve301.setE30114Str(e30114Str);
			ve301.setE30116Zh(e30116Zh);
			ve301.setE30131Str(e30131Str);
			
			ve301.setF30102(f30102);
			ve301.setF30103(f30103);
			ve301.setF30104(f30104);
			ve301.setF30105(f30105);
			ve301.setF30106(f30106);
			ve301.setF30106Str(f30106Str);
			ve301.setF30108(f30108);
			ve301.setF30109(f30109);
			ve301.setF30113(f30113);
			ve301.setF30114(f30114);
			ve301.setF30118(f30118);
			ve301.setF30120(f30120);
			ve301.setF30121(f30121);
			ve301.setF30122(f30122);
			ve301.setF30122Str(f30122Str);
			ve301.setF30135(f30135);
			ve301.setF30147(f30147);
			
			ve301.setF30111(f30111);
			ve301.setF30127(f30127);
			ve301.setF30128(f30128);

			list.add(ve301);
		}
		}catch(Exception e){
			state =false;
			e.printStackTrace();
		}
		e301Response.setVe301s(list);
		e301Response.setState(state);
		e301Response.setE30103(e30103);
		return e301Response;
	}
	
	private void handleE30125(E301 e301, List<?> list){
		Assert.notNull(list, "处理多胞胎编号时查询出来的list不能是null");
		if(list.size()==0){
			e301.setE30125(e301.getE30125()+"00");
			return;
		}
		int max = 0;
		for(Object obj : list){
			if(obj==null)
				continue;
			String str = (String) obj;
			if(str.length()>18){
				String str_ = str.substring(18);
				int temp = Integer.valueOf(str_);
				if(temp>max){
					max = temp;
				}
			}
		}
		String e25 = max<9?e301.getE30125()+"0"+(max+1):e301.getE30125()+(max+1)+"";
		e301.setE30125(e25);
	}
}
