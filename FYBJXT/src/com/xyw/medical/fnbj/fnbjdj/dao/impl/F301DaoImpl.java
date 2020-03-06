package com.xyw.medical.fnbj.fnbjdj.dao.impl;

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

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.joda.time.DateTime;

import com.xyw.medical.etbj.model.E301;
import com.xyw.medical.fnbj.fnbjdj.dao.F301Dao;
import com.xyw.medical.fnbj.model.F301;
import com.xyw.medical.fnbj.model.F301Request;
import com.xyw.medical.fnbj.model.F301Response;
import com.xyw.medical.fnbj.model.VF301;
import com.xyw.sys.util.StringUtil;

public class F301DaoImpl implements F301Dao{
	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;

	@SuppressWarnings("unchecked")
	@Override
	public F301Response saveF301(F301 f301) {
		F301Response f301Response = new F301Response();
		
		String f30102 = f301.getF30102();
		String f30105 = f301.getF30105();

		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try {
			StringBuffer sql = new StringBuffer(
					"select t.f301_32,t.f301_49 from F301 t where (t.f301_50 != 1 or t.f301_50 is null) ");
			if (!StringUtil.isBlankString(f30105)) {
				sql.append("and t.f301_05 ='" + f30105 + "' ");
			}else{
				throw new RuntimeException("身份证号为空或null");
			}
			SQLQuery query = session.createSQLQuery(sql.toString());
			Object[] f301s = (Object[]) query.uniqueResult();
			if (f301s != null && f301s[0] != null) {
				state = false;
				Object uniqueResult = session.createSQLQuery("select d101_02 from d101 where d101_01 = '"+f301s[0]+"'").uniqueResult();
				f301Response.setErrorMessage("该信息已经被" + uniqueResult.toString() + "于"
						+ new DateTime(f301s[1]).toString("yyyy-MM-dd")
						+ "登记过档案！不能重复登记");	
			}
		} catch (Exception e) {
			state = false;
			f301Response.setErrorMessage("保存出错! ");
			e.printStackTrace();
		}
		if (state) {
			try {
				Date DateTemp = new Date();
				f301.setF30149(DateTemp);
				session.save(f301);
				session.flush();
				session.refresh(f301);
			} catch (Exception e) {
				state = false;
				f301Response.setErrorMessage("保存出错! ");
				e.printStackTrace();
			}
		}
		if(state){//如果保存成功将档案编号保存到错误信息中，传输到页面显示出来
			f301Response.setErrorMessage(f301.getF30117());
		}
		f301Response.setState(state);
		return f301Response;
	}

	@Override
	public F301Response renewF301(F301 f301) {
		F301Response f301Response = new F301Response();
		long f30101 = f301.getF30101();
		String f30102 = f301.getF30102();
		String f30105 = f301.getF30105();
		
		Session session = sessionFactory.getCurrentSession();
		boolean state = true;
		
		StringBuffer sql2 = new StringBuffer("select t.f302_01 from F302 t where 1=1 and t.f302_02 ='" + f30101 + "'");
		StringBuffer sql3 = new StringBuffer("select t.f303_01 from F303 t where 1=1 and t.f303_02 ='" + f30101 + "'");
		StringBuffer sql4 = new StringBuffer("select t.f304_01 from F304 t where 1=1 and t.f304_02 ='" + f30101 + "'");
		StringBuffer sql5 = new StringBuffer("select t.f305_01 from F305 t where 1=1 and t.f305_02 ='" + f30101 + "'");
		StringBuffer sql6 = new StringBuffer("select t.f306_01 from F306 t where 1=1 and t.f306_02 ='" + f30101 + "'");
		StringBuffer sql7 = new StringBuffer("select t.f307_01 from F307 t where 1=1 and t.f307_33 ='" + f30101 + "'");
		
		StringBuffer sqle1 = new StringBuffer("select t.e301_01 from E301 t where 1=1 and t.e301_02 ='" + f30101 + "'");
		StringBuffer sqle2 = new StringBuffer("select t.e302_01 from E302 t where 1=1 and t.e302_38 ='" + f30101 + "'");
	//	StringBuffer sqle4 = new StringBuffer("select * from V_E304 t where 1=1 and t.e304_40 ='" + f30101 + "'");
		
		StringBuffer sqld6 = new StringBuffer("select t.d606_01 from D606 t where 1=1 and t.d606_62 ='" + f30101 + "'");
		
		StringBuffer f501 = new StringBuffer("select t.f501_01 from F501 t where 1=1 and t.f501_02 ='" + f30101 + "'");

		try {
			SQLQuery query2 = session.createSQLQuery(sql2.toString());
			int size2 = query2.list().size();

			SQLQuery query3 = session.createSQLQuery(sql3.toString());
			int size3 = query3.list().size();

			SQLQuery query4 = session.createSQLQuery(sql4.toString());
			int size4 = query4.list().size();

			SQLQuery query5 = session.createSQLQuery(sql5.toString());
			int size5 = query5.list().size();

			SQLQuery query6 = session.createSQLQuery(sql6.toString());
			int size6 = query6.list().size();
			
			SQLQuery query7 = session.createSQLQuery(sql7.toString());
			int size7 = query7.list().size();

			//SQLQuery querye1 = session.createSQLQuery(sqle1.toString()).addScalar("t.E301_18",StandardBasicTypes.STRING);
			SQLQuery querye1 = session.createSQLQuery(sqle1.toString());
			int sizee1 = querye1.list().size();

			SQLQuery querye2 = session.createSQLQuery(sqle2.toString());
			int sizee2 = querye2.list().size();
			
	//		SQLQuery querye4 = session.createSQLQuery(sqle4.toString());
	//		int sizee4 = querye4.list().size();

			SQLQuery queryd6 = session.createSQLQuery(sqld6.toString());
			int sized6 = queryd6.list().size();
			
			SQLQuery querydf501 = session.createSQLQuery(f501.toString());
			int sizedf501 = querydf501.list().size();

			StringBuffer mess = new StringBuffer();
			if (size2 > 0 || size3 > 0 || size4 > 0 || size5 > 0 || size6 > 0 || size7 > 0
					|| sizee1 > 0 || sizee2 > 0 || sized6 > 0 || sizedf501 >0) {
				mess.append("已填过");
				if (sizedf501 > 0)
					mess.append("产前超声筛查申请  ");
				if (size2 > 0)
					mess.append("围产保健  ");
				if (size3 > 0)
					mess.append("妇女检查  ");
				if (size4 > 0)
					mess.append("生育联系卡  ");
				if (size5 > 0)
					mess.append("随访登记  ");
				if (size6 > 0)
					mess.append("产前教育  ");
				if (size7 > 0)
					mess.append("产后访视  ");
				if (sizee1 > 0)
					mess.append("儿童档案  ");
				if (sizee2 > 0)
					mess.append("新生儿疾病筛查表  ");
//				if (sizee4 > 0)
//					mess.append("儿童健康检查  ");
				if (sized6 > 0)
					mess.append("缺陷儿登记卡  ");
				
				mess.append("，不能修改！");
				f301Response.setErrorMessage(mess.toString());
				state = false;
				f301Response.setState(state);
				return f301Response;
			}
			
			int sizef = session.createSQLQuery("select t.f301_01 from F301 t where t.f301_05 = '"+f30105+"' and (t.f301_50 != 1 or t.f301_50 is null) and t.f301_01 != '"+f30101+"'").list().size();
			if(sizef>0){
				state = false;
				f301Response.setErrorMessage("已存在相同证件证号的档案,请核对信息!");
			}
			
		} catch (Exception e) {
			state = false;
			e.printStackTrace();
			f301Response.setErrorMessage("保存失败！");
		}
		if(state){
			try {
				session.saveOrUpdate(f301);
			} catch (Exception e) {
				state = false;
				e.printStackTrace();
				f301Response.setErrorMessage("保存失败！");
			}
		}
		
		f301Response.setState(state);
		return f301Response;
	}


	@Override
	public F301Response queryF301(F301Request f301Request) {
		boolean state = true;
		F301Response f301Response = new F301Response();
		Date f30131Start_ = f301Request.getF30131Start();//建卡起始日期
		Date f30131End_ = f301Request.getF30131End();//建卡结束日期
		
		Date f30149Start_ = f301Request.getF30149Start();//录入起始日期
		Date f30149End_ = f301Request.getF30149End();//录入结束日期
			
		String f301_02 = f301Request.getF30102();//产妇姓名
		String f301_05 = f301Request.getF30105();//产妇身份证号码
		String f301_13 = f301Request.getF30113();//
		String f301_17 = f301Request.getF30117();//保健卡号
		String f301_18 = f301Request.getF30118();//丈夫姓名
		String f301_21 = f301Request.getF30121();//丈夫身份证号
		String f301_32_p = f301Request.getF30132();//建卡单位
		String f301_35 = f301Request.getF30135();//产妇现住地址
		String f301_36 = f301Request.getF30136();//产妇户口地址
		String f301_46 = f301Request.getF30146();//产妇户口地址
		
		
		//-------------分页str--------------
		int parameterPageindex = f301Request.getParameterPageindex();
		int parameterPagesize = f301Request.getParameterPagesize();
		String flag = f301Request.getFlag();
		//-------------分页end----------------
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/*StringBuffer parameterConditionwhere = new StringBuffer();*/
		StringBuffer sql = new StringBuffer();
		
		if("gwdj".equals(f301Request.getFromto())) {
			String jigou = f301Request.getJigou();
			sql.append(" and t.f301_32 like '"+jigou+"%'");
			sql.append(" and exists(select 1 from f303 where f303.f303_02=t.f301_01) and not exists (select 1 from f308 where f308.f308_02 = t.f301_01)");
		}
		
		
		//建卡时间
		if (f30131Start_ != null) {
			String f30131Start = sdf.format(f30131Start_);
			sql.append(" and t.f301_31_str >='" + f30131Start + "' ");
		}
		if (f30131End_ != null) {
			String f30131End = sdf.format(f30131End_);
			sql.append(" and t.f301_31_Str <='" + f30131End + "' ");
		}
		//产妇姓名
		if (!StringUtil.isBlankString(f301_02)) {
			sql.append(" and t.f301_02='" + f301_02 + "' ");
		}
		//产妇身份证号码
		if (!StringUtil.isBlankString(f301_05)) {
			sql.append(" and t.f301_05='" + f301_05 + "' ");
		}
		//产妇联系方式
		if (!StringUtil.isBlankString(f301_13)) {
			sql.append(" and t.f301_13 = '" + f301_13 + "'");
		}
		//保健卡号
		if (!StringUtil.isBlankString(f301_17)) {
			sql.append(" and t.f301_17='" + f301_17 + "' ");
		}
		//丈夫姓名
		if (!StringUtil.isBlankString(f301_18)) {
			sql.append(" and t.f301_18='" + f301_18 + "' ");
		}
		//丈夫身份证号码
		if (!StringUtil.isBlankString(f301_21)) {
			sql.append(" and t.f301_21='" + f301_21 + "' ");
		}

		//产妇户口地址
		if(!StringUtil.isBlankString(f301_36)){
			sql.append(" and t.f301_36 like '" + f301_36 +"%' ");
		}
		//产妇现住地址
		if(!StringUtil.isBlankString(f301_35)){
			sql.append(" and t.f301_35 like '" + f301_35 +"%' ");
		}
		
 		//录入时间
		if(f30149Start_ != null){
			String f30149Start = sdf.format(f30149Start_);
			sql.append(" and t.f301_49_str >='" + f30149Start + "'");
		}
		
		if(f30149End_ != null){
			String f30149End = sdf.format(f30149End_);
			sql.append(" and t.f301_49_str <='" + f30149End + "'"); 
		}
		
		//建档单位
		if (!StringUtil.isBlankString(f301_32_p)) {
			if (f301_32_p.length() == 14) {
				sql.append(" and t.f301_32 = '");
				sql.append(f301_32_p);
				sql.append("'");
			} else {
				sql.append(" and t.f301_32 like '");
				sql.append(f301_32_p);
				sql.append("%'");
			}
		}
		//是否发放母子手册
		if(!StringUtil.isBlankString(f301_46)){
			if("1".equals(f301_46)){
				sql.append(" and t.f301_46='" + f301_46 + "' ");
			}else if("2".equals(f301_46)){
				sql.append(" and t.f301_46='" + f301_46 + "' ");
			}
		}
	//	sql.append(" and (t.f301_50 is null or t.f301_50 != '1')");
		
	//	System.out.println(sql.toString());
		
		/*if (f30131Start_ != null) {
			String f30131Start = sdf.format(f30131Start_);
			parameterConditionwhere.append(" and t.f301_31_str >= '"
					+ f30131Start + "'");
		}
		if (f30131End_ != null) {
			String f30131End = sdf.format(f30131End_);
			parameterConditionwhere.append(" and t.f301_31_str <= '"
					+ f30131End + "'");
		}
		if (!StringUtil.isBlankString(f301_02)) {
			parameterConditionwhere
					.append(" and t.f301_02 = '" + f301_02 + "'");
		}
		if (!StringUtil.isBlankString(f301_05)) {
			parameterConditionwhere
					.append(" and t.f301_05 = '" + f301_05 + "'");
		}
		if (!StringUtil.isBlankString(f301_17)) {
			parameterConditionwhere
					.append(" and t.f301_17 = '" + f301_17 + "'");
		}
		if (!StringUtil.isBlankString(f301_18)) {
			parameterConditionwhere
					.append(" and t.f301_18 = '" + f301_18 + "'");
		}
		if (!StringUtil.isBlankString(f301_21)) {
			parameterConditionwhere
					.append(" and t.f301_21 = '" + f301_21 + "'");
		}
		if (!StringUtil.isBlankString(f301_32_p)) {
			if (f301_32_p.length() == 14) {
				parameterConditionwhere.append(" and t.f301_32 = '");
				parameterConditionwhere.append(f301_32_p);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.f301_32 like '");
				parameterConditionwhere.append(f301_32_p);
				parameterConditionwhere.append("%'");
			}
		}*/


		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_F301");
			callableStatement.setString(4, sql.toString());
			callableStatement.setString(5, "t.F301_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			if(rowCount<1){
				f301Response.setPromptMessage("此人档案不存在，请检查！");
			}
			f301Response.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			
			//******************************************************
			//******************************************************
			//System.out.println(sql.toString());
			//******************************************************
			//******************************************************
			
			VF301 vf301 = null;
			List<VF301> vf301s = new ArrayList<VF301>();
			while (resultSet.next()) {
				long f30101 = resultSet.getLong("F301_01");
				String f30102 = resultSet.getString("F301_02");
				String f30103 = resultSet.getString("F301_03");
				String f30104 = resultSet.getString("F301_04");
				String f30105 = resultSet.getString("F301_05");
				Date f30106 = resultSet.getDate("F301_06");
				String f30107 = resultSet.getString("F301_07");
				String f30108 = resultSet.getString("F301_08");
				String f30109 = resultSet.getString("F301_09");
				String f30110 = resultSet.getString("F301_10");
				String f30111 = resultSet.getString("F301_11");
				String f30112 = resultSet.getString("F301_12");
				String f30113 = resultSet.getString("F301_13");
				String f30114 = resultSet.getString("F301_14");
				String f30115 = resultSet.getString("F301_15");
				String f30116 = resultSet.getString("F301_16");
				String f30117 = resultSet.getString("F301_17");
				String f30118 = resultSet.getString("F301_18");
				String f30119 = resultSet.getString("F301_19");
				String f30120 = resultSet.getString("F301_20");
				String f30121 = resultSet.getString("F301_21");
				Date f30122 = resultSet.getDate("F301_22");
				String f30123 = resultSet.getString("F301_23");
				String f30124 = resultSet.getString("F301_24");
				String f30125 = resultSet.getString("F301_25");
				String f30126 = resultSet.getString("F301_26");
				String f30127 = resultSet.getString("F301_27");
				String f30128 = resultSet.getString("F301_28");
				String f30129 = resultSet.getString("F301_29");
				String f30130 = resultSet.getString("F301_30");
				Date f30131 = resultSet.getDate("F301_31");
				String f30132 = resultSet.getString("F301_32");
				String f30133 = resultSet.getString("F301_33");
				String f30134 = resultSet.getString("F301_34");
				String f30135 = resultSet.getString("F301_35");
				String f30136 = resultSet.getString("F301_36");
				String f30137 = resultSet.getString("F301_37");
				String f30138 = resultSet.getString("F301_38");
				String f30139 = resultSet.getString("F301_39");
				String f30140 = resultSet.getString("F301_40");
				String f30141 = resultSet.getString("F301_41");
				String f30142 = resultSet.getString("F301_42");
				String f30143 = resultSet.getString("F301_43");
				String f30144 = resultSet.getString("F301_44");
				String f30145 = resultSet.getString("F301_45");
				String f30146 = resultSet.getString("F301_46");
				String f30147 = resultSet.getString("F301_47");
				long f30148 = resultSet.getLong("F301_48");
				Date f30149 = resultSet.getDate("F301_49");
				String f30150 = resultSet.getString("F301_50");
				String f30151 = resultSet.getString("F301_51");
				String f30152 = resultSet.getString("F301_52");
				String f30153 = resultSet.getString("F301_53");
				Date f30154 = resultSet.getDate("F301_54");
				String f30155 = resultSet.getString("F301_55");
				String f30156 = resultSet.getString("F301_56");
				String f30157 = resultSet.getString("F301_57");
				String f30161 = resultSet.getString("F301_61");
				String f30169 = resultSet.getString("F301_69");
	

				String f30103Zh = resultSet.getString("F301_03_ZH");
				String f30104Zh = resultSet.getString("F301_04_ZH");
				String f30106Str = resultSet.getString("F301_06_Str");
				String f30108Zh = resultSet.getString("F301_08_ZH");
				String f30109Zh = resultSet.getString("F301_09_ZH");
				String f30111Zh = resultSet.getString("F301_11_ZH");
				String f30112Zh = resultSet.getString("F301_12_ZH");
				String f30114Zh = resultSet.getString("F301_14_ZH");
				String f30115Zh = resultSet.getString("F301_15_ZH");
				String f30116Zh = resultSet.getString("F301_16_ZH");
				String f30119Zh = resultSet.getString("F301_19_ZH");
				String f30120Zh = resultSet.getString("F301_20_ZH");
				String f30122Str = resultSet.getString("F301_22_Str");
				String f30124Zh = resultSet.getString("F301_24_ZH");
				String f30125Zh = resultSet.getString("F301_25_ZH");
				String f30127Zh = resultSet.getString("F301_27_ZH");
				String f30129Zh = resultSet.getString("F301_29_ZH");
				String f30130Zh = resultSet.getString("F301_30_ZH");
				String f30131Str = resultSet.getString("F301_31_Str");
				String f30132Zh = resultSet.getString("F301_32_ZH");
				String f30134Zh = resultSet.getString("F301_34_ZH");
				String f30135Zh = resultSet.getString("F301_35_ZH");
				String f30136Zh = resultSet.getString("F301_36_ZH");
				String f30138Zh = resultSet.getString("F301_38_ZH");
				String f30139Zh = resultSet.getString("F301_39_ZH");
				String f30149Str = resultSet.getString("F301_49_Str");
				String f30150Zh = resultSet.getString("F301_50_ZH");
				

				vf301 = new VF301();
				vf301.setF30101(f30101);
				vf301.setF30102(f30102);
				vf301.setF30103(f30103);
				vf301.setF30104(f30104);
				vf301.setF30105(f30105);
				vf301.setF30106(f30106);
				vf301.setF30107(f30107);
				vf301.setF30108(f30108);
				vf301.setF30109(f30109);
				vf301.setF30110(f30110);
				vf301.setF30111(f30111);
				vf301.setF30112(f30112);
				vf301.setF30113(f30113);
				vf301.setF30114(f30114);
				vf301.setF30115(f30115);
				vf301.setF30116(f30116);
				vf301.setF30117(f30117);
				vf301.setF30118(f30118);
				vf301.setF30119(f30119);
				vf301.setF30120(f30120);
				vf301.setF30121(f30121);
				vf301.setF30122(f30122);
				vf301.setF30123(f30123);
				vf301.setF30124(f30124);
				vf301.setF30125(f30125);
				vf301.setF30126(f30126);
				vf301.setF30127(f30127);
				vf301.setF30128(f30128);
				vf301.setF30129(f30129);
				vf301.setF30130(f30130);
				vf301.setF30131(f30131);
				vf301.setF30132(f30132);
				vf301.setF30133(f30133);
				vf301.setF30134(f30134);
				vf301.setF30135(f30135);
				vf301.setF30136(f30136);
				vf301.setF30137(f30137);
				vf301.setF30138(f30138);
				vf301.setF30139(f30139);
				vf301.setF30140(f30140);
				vf301.setF30141(f30141);
				vf301.setF30142(f30142);
				vf301.setF30143(f30143);
				vf301.setF30144(f30144);
				vf301.setF30145(f30145);
				vf301.setF30146(f30146);
				vf301.setF30147(f30147);
				vf301.setF30148(f30148);
				vf301.setF30149(f30149);
				vf301.setF30150(f30150);
				vf301.setF30151(f30151);
				vf301.setF30152(f30152);
				vf301.setF30153(f30153);
				vf301.setF30154(f30154);
				vf301.setF30155(f30155);
				vf301.setF30156(f30156);
				vf301.setF30157(f30157);
				vf301.setF30161(f30161);
				vf301.setF30169(f30169);
				

				vf301.setF30103Zh(f30103Zh);
				vf301.setF30104Zh(f30104Zh);
				vf301.setF30106Str(f30106Str);
				vf301.setF30108Zh(f30108Zh);
				vf301.setF30109Zh(f30109Zh);
				vf301.setF30111Zh(f30111Zh);
				vf301.setF30112Zh(f30112Zh);
				vf301.setF30114Zh(f30114Zh);
				vf301.setF30115Zh(f30115Zh);
				vf301.setF30116Zh(f30116Zh);
				vf301.setF30119Zh(f30119Zh);
				vf301.setF30120Zh(f30120Zh);
				vf301.setF30122Str(f30122Str);
				vf301.setF30124Zh(f30124Zh);
				vf301.setF30125Zh(f30125Zh);
				vf301.setF30127Zh(f30127Zh);
				vf301.setF30129Zh(f30129Zh);
				vf301.setF30130Zh(f30130Zh);
				vf301.setF30131Str(f30131Str);
				vf301.setF30132Zh(f30132Zh);
				vf301.setF30134Zh(f30134Zh);
				vf301.setF30135Zh(f30135Zh);
				vf301.setF30136Zh(f30136Zh);
				vf301.setF30138Zh(f30138Zh);
				vf301.setF30139Zh(f30139Zh);
				vf301.setF30149Str(f30149Str);
				vf301.setF30150Zh(f30150Zh);
				
				vf301s.add(vf301);
			}
			f301Response.setState(state);
			f301Response.setVf301s(vf301s);
		} catch (Exception e) {
			e.printStackTrace();
			f301Response.setState(false);
			f301Response.setErrorMessage("查询失败！");
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return f301Response;
	}

	@Override
	public F301Response deleteF301(F301Request f301Request){
		F301Response f301Response = new F301Response();
		long f30101 = f301Request.getF30101();
		String f30102 = f301Request.getF30102();
		String f30104 = f301Request.getF30104();
		String f30105 = f301Request.getF30105();

		StringBuffer sql2 = new StringBuffer("select t.f302_01 from F302 t where 1=1 and t.f302_02 ='" + f30101 + "'");
		StringBuffer sql3 = new StringBuffer("select t.f303_01 from F303 t where 1=1 and t.f303_02 ='" + f30101 + "'");
		StringBuffer sql4 = new StringBuffer("select t.f304_01 from F304 t where 1=1 and t.f304_02 ='" + f30101 + "'");
		StringBuffer sql5 = new StringBuffer("select t.f305_01 from F305 t where 1=1 and t.f305_02 ='" + f30101 + "'");
		StringBuffer sql6 = new StringBuffer("select t.f306_01 from F306 t where 1=1 and t.f306_02 ='" + f30101 + "'");
		StringBuffer sql7 = new StringBuffer("select t.f307_01 from F307 t where 1=1 and t.f307_33 ='" + f30101 + "'");
		
		StringBuffer sqle1 = new StringBuffer("select t.e301_01 from E301 t where 1=1 and t.e301_02 ='" + f30101 + "'");
//		StringBuffer sqle2 = new StringBuffer("select * from V_E302 t where 1=1 and t.e302_38 ='" + f30101 + "'");
//		StringBuffer sqle4 = new StringBuffer("select * from V_E304 t where 1=1 and t.e304_40 ='" + f30101 + "'");
		
		StringBuffer sqld6 = new StringBuffer("select t.d606_01 from D606 t where 1=1 and t.d606_62 ='" + f30101 + "'");
		
		StringBuffer f501 = new StringBuffer("select t.f501_01 from F501 t where 1=1 and t.f501_02 ='" + f30101 + "'");

		try {
			Session session = sessionFactory.getCurrentSession();
			SQLQuery query2 = session.createSQLQuery(sql2.toString());
			int size2 = query2.list().size();

			SQLQuery query3 = session.createSQLQuery(sql3.toString());
			int size3 = query3.list().size();

			SQLQuery query4 = session.createSQLQuery(sql4.toString());
			int size4 = query4.list().size();

			SQLQuery query5 = session.createSQLQuery(sql5.toString());
			int size5 = query5.list().size();

			SQLQuery query6 = session.createSQLQuery(sql6.toString());
			int size6 = query6.list().size();
			
			SQLQuery query7 = session.createSQLQuery(sql7.toString());
			int size7 = query7.list().size();

			SQLQuery querye1 = session.createSQLQuery(sqle1.toString());
			int sizee1 = querye1.list().size();

//			SQLQuery querye2 = session.createSQLQuery(sqle2.toString());
//			int sizee2 = querye2.list().size();
//			
//			SQLQuery querye4 = session.createSQLQuery(sqle4.toString());
//			int sizee4 = querye4.list().size();

			SQLQuery queryd6 = session.createSQLQuery(sqld6.toString());
			int sized6 = queryd6.list().size();
			
			SQLQuery querydf501 = session.createSQLQuery(f501.toString());
			int sizedf501 = querydf501.list().size();

			StringBuffer mess = new StringBuffer();
			if (size2 > 0 || size3 > 0 || size4 > 0 || size5 > 0 || size6 > 0 || size7 > 0
					|| sizee1 > 0 || sized6 > 0 || sizedf501 >0) {
				mess.append("已填过");
				if (sizedf501 > 0)
					mess.append("产前超声筛查申请  ");
				if (size2 > 0)
					mess.append("围产保健  ");
				if (size3 > 0)
					mess.append("妇女检查  ");
				if (size4 > 0)
					mess.append("生育联系卡  ");
				if (size5 > 0)
					mess.append("随访登记  ");
				if (size6 > 0)
					mess.append("产前教育  ");
				if (size7 > 0)
					mess.append("产后访视  ");
				if (sizee1 > 0)
					mess.append("儿童档案  ");
//				if (sizee2 > 0)
//					mess.append("新生儿疾病筛查表  ");
//				if (sizee4 > 0)
//					mess.append("儿童健康检查  ");
				if (sized6 > 0)
					mess.append("缺陷儿登记卡  ");
				
				mess.append("，不能删除！");
				f301Response.setErrorMessage(mess.toString());
				return f301Response;
			}

			F301 f301 = new F301();
			f301.setF30101(f30101);
			session.delete(f301);
			f301Response.setPromptMessage("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			f301Response.setErrorMessage("删除失败！");
		}

		return f301Response;
	}

	@Override
	public F301Response updateMate(F301 f301) {
		boolean state = true;
		F301Response f301Response = new F301Response();
		long f30101 = f301.getF30101();
		String f30118 = f301.getF30118();
		String f30120 = f301.getF30120();
		String f30121 = f301.getF30121();
		Date f30122 = f301.getF30122();
		String f30123 = f301.getF30123();
		String f30124 = f301.getF30124();
		String f30125 = f301.getF30125();
		String f30119 = f301.getF30119();
		String f30126 = f301.getF30126();
		String f30129 = f301.getF30129();
		String f30127 = f301.getF30127();
		String f30130 = f301.getF30130();
		String f30128 = f301.getF30128();
		String f30138 = f301.getF30138();
		String f30139 = f301.getF30139();
		String f30143 = f301.getF30143();
		String f30144 = f301.getF30144();
 		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("update f301 f set f.f301_18 = ? , f.f301_20 = ? , f.f301_21 = ? , f.f301_22 = ? , f.f301_23 = ? , f.f301_24 = ? , f.f301_25 = ? , f.f301_19 = ? , f.f301_26 = ? , f.f301_29 = ? , f.f301_27 = ? , f.f301_30 = ? , f.f301_28 = ? , f.f301_43 = ? , f.f301_44 = ? , f.f301_38 = ? , f.f301_39 = ? where f.f301_01 = ?");
		Object[] ob = {f30118 ,f30120 , f30121 , f30122 , f30123 , f30124 , f30125 , f30119 , f30126 , f30129 , f30127 , f30130 , f30128 , f30143 , f30144 , f30138, f30139, f30101};
		Type[] ty = {StandardBasicTypes.STRING,StandardBasicTypes.STRING,StandardBasicTypes.STRING,StandardBasicTypes.DATE,StandardBasicTypes.STRING,
				StandardBasicTypes.STRING,StandardBasicTypes.STRING,StandardBasicTypes.STRING,StandardBasicTypes.STRING,StandardBasicTypes.STRING,
				StandardBasicTypes.STRING,StandardBasicTypes.STRING,StandardBasicTypes.STRING,StandardBasicTypes.STRING,StandardBasicTypes.STRING,StandardBasicTypes.STRING,StandardBasicTypes.STRING,StandardBasicTypes.LONG};
		query.setParameters(ob,ty);
		if(state){
			try {
				query.executeUpdate();
			} catch (Exception e) {
				state = false;
				e.printStackTrace();
				f301Response.setErrorMessage("保存失败！");
			}
		}
		f301Response.setState(state);
		return f301Response;
	}

	/**
	 * 添加结案信息
	 */
	@Override
	public F301Response _renewF301(F301 f301) {
		boolean state=false;
		Long f30101=f301.getF30101();
		String f30150=f301.getF30150();
		String f30151=f301.getF30151();
		String f30152=f301.getF30152();
		String f30153=f301.getF30153();
		Date f30154=f301.getF30154();
		String f30155=f301.getF30155();
		F301Response f301Response = new F301Response();
		Session session = sessionFactory.getCurrentSession();
		try {
			int count=session.createSQLQuery("update f301 t set t.f301_50=? ,t.f301_51=? " +
									", t.f301_52=? , t.f301_53=? , t.f301_54=? " +
									", t.f301_55=? where t.f301_01=?")
									.setParameter(0, f30150)
									.setParameter(1, f30151)
									.setParameter(2, f30152)
									.setParameter(3, f30153)
									.setParameter(4, f30154)
									.setParameter(5, f30155)
									.setParameter(6, f30101)
									.executeUpdate();
			if(count==0)
				f301Response.setErrorMessage("保存结案信息失败");
			else if(count>1)
				f301Response.setErrorMessage("该妇女档案存在问题，请联系客服处理");
			else {
				state=true;
				f301Response.setPromptMessage("保存结案信息成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			f301Response.setErrorMessage(e.getMessage());
		}
		f301Response.setState(state);
		return f301Response;
	}
	
}
