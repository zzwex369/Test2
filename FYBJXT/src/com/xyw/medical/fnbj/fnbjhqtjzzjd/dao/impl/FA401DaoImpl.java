package com.xyw.medical.fnbj.fnbjhqtjzzjd.dao.impl;

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

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import oracle.jdbc.OracleTypes;

import com.xyw.medical.fnbj.fnbjhqtjzzjd.dao.FA401Dao;
import com.xyw.medical.fnbj.model.F401;
import com.xyw.medical.fnbj.model.FA401;
import com.xyw.medical.fnbj.model.FA401Request;
import com.xyw.medical.fnbj.model.FA401Response;
import com.xyw.medical.fnbj.model.VFA401;
import com.xyw.sys.util.StringUtil;

public class FA401DaoImpl implements FA401Dao {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private DataSource dataSource;
	
	
	@Override
	public FA401Response queryFA401(FA401Request fA401Request) {
		FA401Response f401Response =new FA401Response();
		String F401_02 =fA401Request.getF40102();  //姓名
		//String F401_03 =fA401Request.getF40103();  //性别
		String F401_06 =fA401Request.getF40106();  //证号
		String F401_13 =fA401Request.getF40113();  //配偶姓名
		String F401_16 =fA401Request.getF40116();  //婚检编号
		String F401_94 =fA401Request.getF40194();  //配偶证号
		String F401_95 =fA401Request.getF40195();  //检查单位
		
		Date timeStr =fA401Request.getTimeStr();
	    Date timeEnd =fA401Request.getTimeEnd();
	    
	    StringBuffer sql = new StringBuffer();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    int parameterPageindex = fA401Request.getParameterPageindex();
	    int parameterPagesize = fA401Request.getParameterPagesize();
//	    if(F401_03.equals("1")){
//			sql.append(" and t.f401_03 = '"+ 1 +"' ");
//		}else if(F401_03.equals("2")){
//			sql.append(" and t.f401_03 = '"+ 2 +"' ");
//		}
	    if(!StringUtil.isBlankString(F401_02)){
			sql.append(" and t.f401_02 = '"+ F401_02 +"' ");
	    }
		if(!StringUtil.isBlankString(F401_06)){
			sql.append(" and t.f401_06 = '"+ F401_06 +"' ");
		}
		if(!StringUtil.isBlankString(F401_13)){
			sql.append(" and t.f401_13 = '"+ F401_13 +"' ");
		}
		if(!StringUtil.isBlankString(F401_16)){
			sql.append(" and t.f401_16 = '"+ F401_16 +"' ");
		}
		if(!StringUtil.isBlankString(F401_94)){
			sql.append(" and t.f401_94 = '"+ F401_94 +"' ");
		}
		if (!StringUtil.isBlankString(F401_95)) {
			if (F401_95.length() == 14) {
				sql.append(" and t.f401_95 = '");
				sql.append(F401_95);
				sql.append("'");
			} else {
				sql.append(" and t.f401_95 like '");
				sql.append(F401_95);
				sql.append("%'");
			}
		}
		if(timeStr !=null){
	    	String timeStr_ = sdf.format(timeStr);
	    	sql.append(" and t.f401_93_str >= '"+ timeStr_ + "'");
	    }
	    if(timeEnd !=null){
	    	String timeEnd_ = sdf.format(timeEnd);
	    	sql.append(" and t.f401_93_str <= '"+ timeEnd_ + "'"); 
	    }
		boolean state =true;
		Connection connection =null;
		CallableStatement callableStatement =null;
		try {
			connection =this.dataSource.getConnection();
			callableStatement =connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
	    	callableStatement.setInt(2, parameterPagesize);
	    	callableStatement.setString(3, "V_FA401");
	    	callableStatement.setString(4, sql.toString());
	    	callableStatement.setString(5, "t.F401_01");
	    	callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
	    	callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
	    	callableStatement.execute();
	    	
	    	long rowCount =callableStatement.getLong(6);
	    	f401Response.setRowCount(rowCount);
	    	ResultSet resultSet =(ResultSet)callableStatement.getObject(7);
	    	VFA401 vf401=null;
	    	List<VFA401> vf401s =new ArrayList<VFA401>();
	    	while (resultSet.next()) {
	    		long f40101 =resultSet.getLong("F401_01");
	    		String f40102 =resultSet.getString("F401_02");
	    		String f40103 =resultSet.getString("F401_03");
	    		String f40104 =resultSet.getString("F401_04");
	    		String f40105 =resultSet.getString("F401_05");
	    		String f40106 =resultSet.getString("F401_06");
	    		String f40107 =resultSet.getString("F401_07");
	    		String f40108 =resultSet.getString("F401_08");
	    		String f40109 =resultSet.getString("F401_09");
	    		String f40110 =resultSet.getString("F401_10");
	    		String f40111 =resultSet.getString("F401_11");
	    		String f40112 =resultSet.getString("F401_12");
	    		String f40113 =resultSet.getString("F401_13");
	    		String f40114 =resultSet.getString("F401_14");
	    		String f40115 =resultSet.getString("F401_15");
	    		String f40116 =resultSet.getString("F401_16");
	    		String f40117 =resultSet.getString("F401_17");
	    		String f40118 =resultSet.getString("F401_18");
	    		String f40119 =resultSet.getString("F401_19");
	    		String f40120 =resultSet.getString("F401_20");
	    		String f40121 =resultSet.getString("F401_21");
	    		String f40122 =resultSet.getString("F401_22");
	    		String f40123 =resultSet.getString("F401_23");
	    		String f40124 =resultSet.getString("F401_24");
	    		String f40125 =resultSet.getString("F401_25");
	    		long f40126 =resultSet.getLong("F401_26");
	    		String f40127 =resultSet.getString("F401_27");
	    		String f40128 =resultSet.getString("F401_28");
	    		String f40129 =resultSet.getString("F401_29");
	    		String f40130 =resultSet.getString("F401_30");
	    		long f40131 =resultSet.getLong("F401_31");
	    		long f40132 =resultSet.getLong("F401_32");
	    		String f40133 =resultSet.getString("F401_33");
	    		String f40134 =resultSet.getString("F401_34");
	    		String f40135 =resultSet.getString("F401_35");
	    		String f40136 =resultSet.getString("F401_36");
	    		String f40137 =resultSet.getString("F401_37");
	    		String f40138 =resultSet.getString("F401_38");
	    		String f40139 =resultSet.getString("F401_39");
	    		String f40140 =resultSet.getString("F401_40");
	    		String f40141 =resultSet.getString("F401_41");
	    		String f40142 =resultSet.getString("F401_42");
	    		String f40143 =resultSet.getString("F401_43");
	    		String f40144 =resultSet.getString("F401_44");
	    		String f40145 =resultSet.getString("F401_45");
	    		String f40146 =resultSet.getString("F401_46");
	    		String f40147 =resultSet.getString("F401_47");
	    		String f40148 =resultSet.getString("F401_48");
	    		String f40149 =resultSet.getString("F401_49");
	    		long f40150 =resultSet.getLong("F401_50");
	    		String f40151 =resultSet.getString("F401_51");
	    		String f40152 =resultSet.getString("F401_52");
	    		String f40153 =resultSet.getString("F401_53");
	    		String f40154 =resultSet.getString("F401_54");
	    		String f40155 =resultSet.getString("F401_55");
	    		String f40156 =resultSet.getString("F401_56");
	    		String f40157 =resultSet.getString("F401_57");
	    		String f40158 =resultSet.getString("F401_58");
	    		String f40159 =resultSet.getString("F401_59");
	    		String f40160 =resultSet.getString("F401_60");
	    		String f40161 =resultSet.getString("F401_61");
	    		String f40162 =resultSet.getString("F401_62");
	    		String f40163 =resultSet.getString("F401_63");
	    		String f40164 =resultSet.getString("F401_64");
	    		String f40165 =resultSet.getString("F401_65");
	    		String f40166 =resultSet.getString("F401_66");
	    		String f40167 =resultSet.getString("F401_67");
	    		String f40168 =resultSet.getString("F401_68");
	    		String f40169 =resultSet.getString("F401_69");
	    		String f40170 =resultSet.getString("F401_70");
	    		String f40171 =resultSet.getString("F401_71");
	    		String f40172 =resultSet.getString("F401_72");
	    		String f40173 =resultSet.getString("F401_73");
	    		String f40174 =resultSet.getString("F401_74");
	    		String f40175 =resultSet.getString("F401_75");
	    		String f40176 =resultSet.getString("F401_76");
	    		String f40177 =resultSet.getString("F401_77");
	    		String f40178 =resultSet.getString("F401_78");
	    		String f40179 =resultSet.getString("F401_79");
	    		String f40180 =resultSet.getString("F401_80");
	    		String f40181 =resultSet.getString("F401_81");
	    		String f40182 =resultSet.getString("F401_82");
	    		String f40183 =resultSet.getString("F401_83");
	    		String f40184 =resultSet.getString("F401_84");
	    		String f40185 =resultSet.getString("F401_85");
	    		String f40186 =resultSet.getString("F401_86");
	    		String f40187 =resultSet.getString("F401_87");
	    		String f40188 =resultSet.getString("F401_88");
	    		String f40189 =resultSet.getString("F401_89");
	    		String f40190 =resultSet.getString("F401_90");
	    		String f40191 =resultSet.getString("F401_91");
	    		String f40192 =resultSet.getString("F401_92");
	    		Date f40193 =resultSet.getDate("F401_93");
	    		String f40194 =resultSet.getString("F401_94");
	    		String f40195 =resultSet.getString("F401_95");
	    		String f40196 =resultSet.getString("F401_96");
	    		String f40197 =resultSet.getString("F401_97");
	    		String f40198 =resultSet.getString("F401_98");
	    		String f40199 =resultSet.getString("F401_99");
	    		String f401100 =resultSet.getString("F401_100");
	    		

	    		String f40110Zh =resultSet.getString("F401_10_ZH");

	    		String f40117Zh =resultSet.getString("F401_17_ZH");
	    		String f40121Zh =resultSet.getString("F401_21_ZH");
	    	    String f40193Str =resultSet.getString("F401_93_Str");
	    	    String f40195Zh =resultSet.getString("F401_95_ZH");

	    	    vf401 =new VFA401();
	    	    vf401.setF40101(f40101);
	    	    vf401.setF40102(f40102);
	    	    vf401.setF40103(f40103);
	    	    vf401.setF40104(f40104);
	    	    vf401.setF40105(f40105);
	    	    vf401.setF40106(f40106);
	    	    vf401.setF40107(f40107);
	    	    vf401.setF40108(f40108);
	    	    vf401.setF40109(f40109);
	    	    vf401.setF40110(f40110);
	    	    vf401.setF40111(f40111);
	    	    vf401.setF40112(f40112);
	    	    vf401.setF40113(f40113);
	    	    vf401.setF40114(f40114);
	    	    vf401.setF40115(f40115);
	    	    vf401.setF40116(f40116);
	    	    vf401.setF40117(f40117);
	    	    vf401.setF40118(f40118);
	    	    vf401.setF40119(f40119);
	    	    vf401.setF40120(f40120);
	    	    vf401.setF40121(f40121);
	    	    vf401.setF40122(f40122);
	    	    vf401.setF40123(f40123);
	    	    vf401.setF40124(f40124);
	    	    vf401.setF40125(f40125);
	    	    vf401.setF40126(f40126);
	    	    vf401.setF40127(f40127);
	    	    vf401.setF40128(f40128);
	    	    vf401.setF40129(f40129);
	    	    vf401.setF40130(f40130);
	    	    vf401.setF40131(f40131);
	    	    vf401.setF40132(f40132);
	    	    vf401.setF40133(f40133);
	    	    vf401.setF40134(f40134);
	    	    vf401.setF40135(f40135);
	    	    vf401.setF40136(f40136);
	    	    vf401.setF40137(f40137);
	    	    vf401.setF40138(f40138);
	    	    vf401.setF40139(f40139);
	    	    vf401.setF40140(f40140);
	    	    vf401.setF40141(f40141);
	    	    vf401.setF40142(f40142);
	    	    vf401.setF40143(f40143);
	    	    vf401.setF40144(f40144);
	    	    vf401.setF40145(f40145);
	    	    vf401.setF40146(f40146);
	    	    vf401.setF40147(f40147);
	    	    vf401.setF40148(f40148);
	    	    vf401.setF40149(f40149);
	    	    vf401.setF40150(f40150);
	    	    vf401.setF40151(f40151);
	    	    vf401.setF40152(f40152);
	    	    vf401.setF40153(f40153);
	    	    vf401.setF40154(f40154);
	    	    vf401.setF40155(f40155);
	    	    vf401.setF40156(f40156);
	    	    vf401.setF40157(f40157);
	    	    vf401.setF40158(f40158);
	    	    vf401.setF40159(f40159);
	    	    vf401.setF40160(f40160);
	    	    vf401.setF40161(f40161);
	    	    vf401.setF40162(f40162);
	    	    vf401.setF40163(f40163);
	    	    vf401.setF40164(f40164);
	    	    vf401.setF40165(f40165);
	    	    vf401.setF40166(f40166);
	    	    vf401.setF40167(f40167);
	    	    vf401.setF40168(f40168);
	    	    vf401.setF40169(f40169);
	    	    vf401.setF40170(f40170);
	    	    vf401.setF40171(f40171);
	    	    vf401.setF40172(f40172);
	    	    vf401.setF40173(f40173);
	    	    vf401.setF40174(f40174);
	    	    vf401.setF40175(f40175);
	    	    vf401.setF40176(f40176);
	    	    vf401.setF40177(f40177);
	    	    vf401.setF40178(f40178);
	    	    vf401.setF40179(f40179);
	    	    vf401.setF40180(f40180);
	    	    vf401.setF40181(f40181);
	    	    vf401.setF40182(f40182);
	    	    vf401.setF40183(f40183);
	    	    vf401.setF40184(f40184);
	    	    vf401.setF40185(f40185);
	    	    vf401.setF40186(f40186);
	    	    vf401.setF40187(f40187);
	    	    vf401.setF40188(f40188);
	    	    vf401.setF40189(f40189);
	    	    vf401.setF40190(f40190);
	    	    vf401.setF40191(f40191);
	    	    vf401.setF40192(f40192);
				vf401.setF40193(f40193);
	    	    vf401.setF40194(f40194);
	    	    vf401.setF40195(f40195);
	    	    vf401.setF40196(f40196);
	    	    vf401.setF40197(f40197);
	    	    vf401.setF40198(f40198);
	    	    vf401.setF40199(f40199);
	    	    vf401.setF401100(f401100);
	    	    
	    	    vf401.setF40110Zh(f40110Zh);
	    	    vf401.setF40117Zh(f40117Zh);
	    	    vf401.setF40121Zh(f40121Zh);
	    	    vf401.setF40193Str(f40193Str);
	    	    vf401.setF40195Zh(f40195Zh);
	    	    vf401s.add(vf401);
			}
	    	f401Response.setVf401s(vf401s);
		} catch (Exception e) {
			state =false;
			e.printStackTrace();
			f401Response.setErrorMessage("查询失败！");
		}finally{
			try {
				if (callableStatement != null) {
					callableStatement.close();
					callableStatement = null;
				}
//				if (connection != null) {
//					connection.close();
//					connection = null;
//				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		f401Response.setState(state);
		return f401Response;
	}

	@Override
	public FA401Response renewFA401(FA401 fA401) {
		FA401Response f401Response =new FA401Response();
	  boolean state = true;
	  Session session = sessionFactory.getCurrentSession();
	  try{
		  session.update(fA401);
		  F401 f401 = new F401();
		  	Long f40101 = fA401.getF40101();
			String f40102 = fA401.getF40102();
			String f40103 = fA401.getF40103();
			String f40104 = fA401.getF40104();
			String f40105 = fA401.getF40105();
			String f40106 = fA401.getF40106();
			String f40107 = fA401.getF40107();
			String f40108 = fA401.getF40108();
			String f40109 = fA401.getF40109();
			String f40110 = fA401.getF40110();
			String f40111 = fA401.getF40111();
			String f40112 = fA401.getF40112();
			String f40113 = fA401.getF40113();
			String f40114 = fA401.getF40114();
			String f40115 = fA401.getF40115();
			String f40116 = fA401.getF40116();
			String f40117 = fA401.getF40117();
			String f40118 = fA401.getF40118();
			String f40119 = fA401.getF40119();
			String f40120 = fA401.getF40120();
			
			String f40121 = fA401.getF40121();
			String f40122 = fA401.getF40122();
			String f40123 = fA401.getF40123();
			String f40124 = fA401.getF40124();
			String f40125 = fA401.getF40125();
			Long f40126 = fA401.getF40126();
			String f40127 = fA401.getF40127();
			String f40128 = fA401.getF40128();
			String f40129 = fA401.getF40129();
			String f40130 = fA401.getF40130();
			Double f40131 = fA401.getF40131();
			Double f40132 = fA401.getF40132();
			String f40133 = fA401.getF40133();
			String f40134 = fA401.getF40134();
			String f40135 = fA401.getF40135();
			String f40136 = fA401.getF40136();
			String f40137 = fA401.getF40137();
			String f40138 = fA401.getF40138();
			String f40139 = fA401.getF40139();
			String f40140 = fA401.getF40140();
			
			String f40141 = fA401.getF40141();
			String f40142 = fA401.getF40142();
			String f40143 = fA401.getF40143();
			String f40144 = fA401.getF40144();
			String f40145 = fA401.getF40145();
			String f40146 = fA401.getF40146();
			String f40147 = fA401.getF40147();
			String f40148 = fA401.getF40148();
			String f40149 = fA401.getF40149();
			Long f40150 = fA401.getF40150();
			String f40151 = fA401.getF40151();
			String f40152 = fA401.getF40152();
			String f40153 = fA401.getF40153();
			String f40154 = fA401.getF40154();
			String f40155 = fA401.getF40155();
			String f40156 = fA401.getF40156();
			String f40157 = fA401.getF40157();
			String f40158 = fA401.getF40158();
			String f40159 = fA401.getF40159();
			String f40160 = fA401.getF40160();
			
			String f40161 = fA401.getF40161();
			String f40162 = fA401.getF40162();
			String f40163 = fA401.getF40163();
			String f40164 = fA401.getF40164();
			String f40165 = fA401.getF40165();
			String f40166 = fA401.getF40166();
			String f40167 = fA401.getF40167();
			String f40168 = fA401.getF40168();
			String f40169 = fA401.getF40169();
			String f40170 = fA401.getF40170();
			String f40171 = fA401.getF40171();
			String f40172 = fA401.getF40172();
			String f40173 = fA401.getF40173();
			String f40174 = fA401.getF40174();
			String f40175 = fA401.getF40175();
			String f40176 = fA401.getF40176();
			String f40177 = fA401.getF40177();
			String f40178 = fA401.getF40178();
			String f40179 = fA401.getF40179();
			String f40180 = fA401.getF40180();
			
			String f40181 = fA401.getF40181();
			String f40182 = fA401.getF40182();
			String f40183 = fA401.getF40183();
			String f40184 = fA401.getF40184();
			String f40185 = fA401.getF40185();
			String f40186 = fA401.getF40186();
			String f40187 = fA401.getF40187();
			String f40188 = fA401.getF40188();
			String f40189 = fA401.getF40189();
			String f40190 = fA401.getF40190();
			String f40191 = fA401.getF40191();
			String f40192 = fA401.getF40192();
			Date f40193 = fA401.getF40193();
			String f40194 = fA401.getF40194();
			String f40195 = fA401.getF40195();
			String f40196 = fA401.getF40196();
			String f40197 = fA401.getF40197();
			String f40198 = fA401.getF40198();
			String f40199 = fA401.getF40199();
			String f401100 = fA401.getF401100();
			
			f401.setF40101(f40101);
			f401.setF40102(f40102);
			//System.out.println(f401+"---f401--");
			f401.setF40103(f40103);
		//	f401.setF40104(f40104.toString());
			//System.out.println(f401+"---f401--");
			f401.setF40105(f40105);
			f401.setF40106(f40106);
			f401.setF40107(f40107);
			f401.setF40108(f40108);
			f401.setF40109(f40109);
			f401.setF40110(f40110);			
			f401.setF40111(f40111);
			f401.setF40112(f40112);
			f401.setF40113(f40113);
			f401.setF40114(f40114);
			f401.setF40115(f40115);
			f401.setF40116(f40116);
			f401.setF40117(f40117);
			f401.setF40118(f40118);
			f401.setF40119(f40119);
			f401.setF40120(f40120);
			f401.setF40121(f40121);
			f401.setF40122(f40122);
			f401.setF40123(f40123);
			f401.setF40124(f40124);
			f401.setF40125(f40125);
			f401.setF40126(f40126.toString());
			f401.setF40127(f40127);
			f401.setF40128(f40128);
			f401.setF40129(f40129);
			f401.setF40130(f40130);
			
			f401.setF40131(f40131.toString());
			f401.setF40132(f40132.toString());
			f401.setF40133(f40133);
			f401.setF40134(f40134);
			f401.setF40135(f40135);
			f401.setF40136(f40136);
			f401.setF40137(f40137);
			f401.setF40138(f40138);
			f401.setF40139(f40139);
			f401.setF40140(f40140);
			f401.setF40141(f40141);
			f401.setF40142(f40142);
			f401.setF40143(f40143);
			f401.setF40144(f40144);
			f401.setF40145(f40145);
			f401.setF40146(f40146);
			f401.setF40147(f40147);
			f401.setF40148(f40148);
			f401.setF40149(f40149);
			f401.setF40150(f40150.toString());
			
			f401.setF40151(f40151);
			f401.setF40152(f40152);
			f401.setF40153(f40153);
			f401.setF40154(f40154);
			f401.setF40155(f40155);
			f401.setF40156(f40156);
			f401.setF40157(f40157);
			f401.setF40158(f40158);
			f401.setF40159(f40159);
			f401.setF40160(f40160);
			f401.setF40161(f40161);
			f401.setF40162(f40162);
			f401.setF40163(f40163);
			f401.setF40164(f40164);
			f401.setF40165(f40165);
			f401.setF40166(f40166);
			f401.setF40167(f40167);
			f401.setF40168(f40168);
			f401.setF40169(f40169);
			f401.setF40170(f40170);
			
			f401.setF40171(f40171);
			f401.setF40172(f40172);
			f401.setF40173(f40173);
			f401.setF40174(f40174);
			f401.setF40175(f40175);
			f401.setF40176(f40176);
			f401.setF40177(f40177);
			f401.setF40178(f40178);
			f401.setF40179(f40179);
			f401.setF40180(f40180);
			f401.setF40181(f40181);
			f401.setF40182(f40182);
			f401.setF40183(f40183);
			f401.setF40184(f40184);
			f401.setF40185(f40185);
			f401.setF40186(f40186);
			f401.setF40187(f40187);
			f401.setF40188(f40188);
			f401.setF40189(f40189);
			f401.setF40190(f40190);
			f401.setF40191(f40191);
			f401.setF40192(f40192);
			f401.setF40193(f40193);
			f401.setF40194(f40194);
			f401.setF40195(f40195);
			f401.setF40196(f40196);
			f401.setF40197(f40197);
			f401.setF40198(f40198);
			f401.setF40199(f40199);
			f401.setF401100(f401100);
			session.save(f401);
			//System.out.println(f401+"-------------");
	  }catch(Exception e){
		  state = false;
		  e.printStackTrace();
		  f401Response.setErrorMessage(e.getMessage());
		  
	  }
//	  finally{//如果用到sessionFactory.getCurrentSession()则不需要session.close(),如果用了会报错  sessionFactory.getCurrentSession()自己又关闭session和commit的方法
//		  try{
//			 if(session!=null){
//				 session.close();
//				 session = null;
//			 } 
//			  
//		  }catch(Exception e){
//			  e.printStackTrace();
//		  }
//	  }
	 
	  f401Response.setState(state);
	  //System.out.println(f401Response+"---------------");
		return f401Response;
	}

	@Override
	public FA401Response deleteFA401(FA401Request fA401Request) {
		FA401Response f401Response =new FA401Response();
		long f40101 = fA401Request.getF40101();
		Session session = sessionFactory.getCurrentSession();
		boolean state = true;
		try{
				FA401 fA401 = new FA401();
				fA401.setF40101(f40101);
				session.delete(fA401);
				f401Response.setPromptMessage("删除成功！");
		}catch(Exception e){
			state = false;
			e.printStackTrace();
			f401Response.setErrorMessage("删除失败！");
		}
		f401Response.setState(state);
		return f401Response;
	}

}
