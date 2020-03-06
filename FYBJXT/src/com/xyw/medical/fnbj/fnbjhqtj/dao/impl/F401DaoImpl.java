package com.xyw.medical.fnbj.fnbjhqtj.dao.impl;

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

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.fnbj.fnbjhqtj.dao.F401Dao;
import com.xyw.medical.fnbj.model.F401;
import com.xyw.medical.fnbj.model.F401Request;
import com.xyw.medical.fnbj.model.F401Response;
import com.xyw.medical.fnbj.model.VF401;
import com.xyw.sys.util.StringUtil;

public class F401DaoImpl implements F401Dao{
	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private DataSource dataSource;
	
	

	@SuppressWarnings("unchecked")
	@Override
	public F401Response saveF401(F401 f401) {
		F401Response f401Response =new F401Response();
		String F401_02 =f401.getF40102();  //姓名
		String F401_06 =f401.getF40106();  //证号
		String F401_13 =f401.getF40113();  //配偶姓名
		String F401_94 =f401.getF40194();  //配偶证号
		
		boolean state =true;
		Session session =sessionFactory.getCurrentSession();
		try {
			StringBuffer sql =new StringBuffer("select * from f401 t where 1=1 ");
			if(!StringUtil.isBlankString(F401_02)){
				sql.append(" and t.f401_02 = '"+ F401_02 +"' ");
			}
			if(!StringUtil.isBlankString(F401_06)){
				sql.append(" and t.f401_06 = '"+ F401_06 +"' ");
			}
			if(!StringUtil.isBlankString(F401_13)){
				sql.append(" and t.f401_13 = '"+ F401_13 +"' ");
			}
			if(!StringUtil.isBlankString(F401_94)){
				sql.append(" and t.f401_94 = '"+ F401_94 +"' ");
			}
			SQLQuery query =session.createSQLQuery(sql.toString());
			List<F401> f401s =query.addEntity(F401.class).list();
			if(f401s.size() >0){
				state = false;
				f401Response.setErrorMessage("重复保存！");
			}
		} catch (Exception e) {
			state = false;
			f401Response.setErrorMessage("保存出错! ");
			e.printStackTrace();
		}
		if(state){
			try {
				session.save(f401);
				session.flush();
				session.refresh(f401);
				f401Response.setF40101(f401.getF40101());
			} catch (Exception e) {
				state = false;
				f401Response.setErrorMessage("保存出错! ");
				e.printStackTrace();
			}
		}
		
		f401Response.setState(state);
		return f401Response;
	}

	@Override
	public F401Response renewF401(F401 f401) {
		F401Response f401Response =new F401Response();
		boolean state =true;
		Session session =sessionFactory.getCurrentSession();
		try {
			session.update(f401);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			state =false;
			f401Response.setErrorMessage(e.getMessage());
		}
		
		f401Response.setState(state);
		return f401Response;
	}

	@Override
	public F401Response queryF401(F401Request f401Request) {
		F401Response f401Response =new F401Response();
		String F401_02 =f401Request.getF40102();  //姓名
		String F401_03 =f401Request.getF40103();  //性别
		String F401_06 =f401Request.getF40106();  //证号
		String F401_13 =f401Request.getF40113();  //配偶姓名
		String F401_16 =f401Request.getF40116();  //婚检编号
		String F401_94 =f401Request.getF40194();  //配偶证号
		String F401_95 =f401Request.getF40195();  //检查单位
		
		Date timeStr =f401Request.getTimeStr();
	    Date timeEnd =f401Request.getTimeEnd();
	    
	    StringBuffer sql = new StringBuffer();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    int parameterPageindex = f401Request.getParameterPageindex();
	    int parameterPagesize = f401Request.getParameterPagesize();
	    if(F401_03.equals("1")){
			sql.append(" and t.f401_03 = '"+ 1 +"' ");
		}else if(F401_03.equals("2")){
			sql.append(" and t.f401_03 = '"+ 2 +"' ");
		}
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
	    	callableStatement.setString(3, "V_F401");
	    	callableStatement.setString(4, sql.toString());
	    	callableStatement.setString(5, "t.F401_01");
	    	callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
	    	callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
	    	callableStatement.execute();
	    	
	    	long rowCount =callableStatement.getLong(6);
	    	f401Response.setRowCount(rowCount);
	    	ResultSet resultSet =(ResultSet)callableStatement.getObject(7);
	    	VF401 vf401=null;
	    	List<VF401> vf401s =new ArrayList<VF401>();
	    	while (resultSet.next()) {
	    		long f40101 =resultSet.getLong("F401_01");
	    		String f40102 =resultSet.getString("F401_02");
	    		String f40103 =resultSet.getString("F401_03");
	    		Date f40104 =resultSet.getDate("F401_04");
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
	    		String f40126 =resultSet.getString("F401_26");
	    		String f40127 =resultSet.getString("F401_27");
	    		String f40128 =resultSet.getString("F401_28");
	    		String f40129 =resultSet.getString("F401_29");
	    		String f40130 =resultSet.getString("F401_30");
	    		String f40131 =resultSet.getString("F401_31");
	    		String f40132 =resultSet.getString("F401_32");
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
	    		String f40150 =resultSet.getString("F401_50");
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
	    		Date f401101 =resultSet.getDate("F401_101");
	    		String f401102 =resultSet.getString("F401_102");
	    		String f401103 =resultSet.getString("F401_103");
	    		
//	    	    String f40103Zh =resultSet.getString("F401_03_ZH");
//	    		String f40105Zh =resultSet.getString("F401_05_ZH");
//	    		String f40107Zh =resultSet.getString("F401_07_ZH");
//	    		String f40108Zh =resultSet.getString("F401_08_ZH");
	    		String f40104Str =resultSet.getString("F401_04_Str");
	    		String f40110Zh =resultSet.getString("F401_10_ZH");
//	    		String f40114Zh =resultSet.getString("F401_14_ZH");
//	    		String f40115Zh =resultSet.getString("F401_15_ZH");
	    		String f40117Zh =resultSet.getString("F401_17_ZH");
	    		String f40121Zh =resultSet.getString("F401_21_ZH");
//	    		String f40123Zh =resultSet.getString("F401_23_ZH");
//	    		String f40125Zh =resultSet.getString("F401_25_ZH");
//	    		String f40129Zh =resultSet.getString("F401_29_ZH");
//	    		String f40134Zh =resultSet.getString("F401_34_ZH");
//	    		String f40136Zh =resultSet.getString("F401_36_ZH");
//	    		String f40138Zh =resultSet.getString("F401_38_ZH");
//	    		String f40140Zh =resultSet.getString("F401_40_ZH");
//	    		String f40143Zh =resultSet.getString("F401_43_ZH");
//	    		String f40144Zh =resultSet.getString("F401_44_ZH");
//	    		String f40145Zh =resultSet.getString("F401_45_ZH");
//	    		String f40146Zh =resultSet.getString("F401_46_ZH");
//	    		String f40148Zh =resultSet.getString("F401_48_ZH");
//	    		String f40152Zh =resultSet.getString("F401_52_ZH");
//	    		String f40154Zh =resultSet.getString("F401_54_ZH");
//	    		String f40156Zh =resultSet.getString("F401_56_ZH");
//	    		String f40158Zh =resultSet.getString("F401_58_ZH");
//	    		String f40159Zh =resultSet.getString("F401_59_ZH");
//	    		String f40161Zh =resultSet.getString("F401_61_ZH");
//	    		String f40162Zh =resultSet.getString("F401_62_ZH");
//	    		String f40163Zh =resultSet.getString("F401_63_ZH");
//	    		String f40165Zh =resultSet.getString("F401_65_ZH");
//	    		String f40167Zh =resultSet.getString("F401_67_ZH");
//	    		String f40170Zh =resultSet.getString("F401_70_ZH");
//	    		String f40171Zh =resultSet.getString("F401_71_ZH");
//	    		String f40174Zh =resultSet.getString("F401_74_ZH");
//	    		String f40186Zh =resultSet.getString("F401_86_ZH");
//	    		String f40189Zh =resultSet.getString("F401_89_ZH");
//	    		String f40191Zh =resultSet.getString("F401_91_ZH");
	    	    String f40193Str =resultSet.getString("F401_93_Str");
	    	    String f40195Zh =resultSet.getString("F401_95_ZH");
	    	    String f401101Str =resultSet.getString("F401_101_Str");
	    	    String f401102Zh =resultSet.getString("F401_102_ZH");
	    	    
	    	    vf401 =new VF401();
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
	    	    vf401.setF401101(f401101);
	    	    vf401.setF401102(f401102);
	    	    vf401.setF401103(f401103);
	    	    
//	    	    vf401.setF40103Zh(f40103Zh);
//	    	    vf401.setF40105Zh(f40105Zh);
//	    	    vf401.setF40107Zh(f40107Zh);
//	    	    vf401.setF40108Zh(f40108Zh);
	    	    vf401.setF40104Str(f40104Str);
	    	    vf401.setF40110Zh(f40110Zh);
//	    	    vf401.setF40114Zh(f40114Zh);
//	    	    vf401.setF40115Zh(f40115Zh);
	    	    vf401.setF40117Zh(f40117Zh);
	    	    vf401.setF40121Zh(f40121Zh);
//	    	    vf401.setF40123Zh(f40123Zh);
//	    	    vf401.setF40125Zh(f40125Zh);
//	    	    vf401.setF40129Zh(f40129Zh);
//	    	    vf401.setF40134Zh(f40134Zh);
//	    	    vf401.setF40136Zh(f40136Zh);
//	    	    vf401.setF40138Zh(f40138Zh);
//	    	    vf401.setF40140Zh(f40140Zh);
//	    	    vf401.setF40143Zh(f40143Zh);
//	    	    vf401.setF40144Zh(f40144Zh);
//	    	    vf401.setF40145Zh(f40145Zh);
//	    	    vf401.setF40146Zh(f40146Zh);
//	    	    vf401.setF40148Zh(f40148Zh);
//	    	    vf401.setF40152Zh(f40152Zh);
//	    	    vf401.setF40154Zh(f40154Zh);
//	    	    vf401.setF40156Zh(f40156Zh);
//	    	    vf401.setF40158Zh(f40158Zh);
//	    	    vf401.setF40159Zh(f40159Zh);
//	    	    vf401.setF40161Zh(f40161Zh);
//	    	    vf401.setF40162Zh(f40162Zh);
//	    	    vf401.setF40163Zh(f40163Zh);
//	    	    vf401.setF40165Zh(f40165Zh);
//	    	    vf401.setF40167Zh(f40167Zh);
//	    	    vf401.setF40170Zh(f40170Zh);
//	    	    vf401.setF40171Zh(f40171Zh);
//	    	    vf401.setF40174Zh(f40174Zh);
//	    	    vf401.setF40186Zh(f40186Zh);
//	    	    vf401.setF40189Zh(f40189Zh);
//	    	    vf401.setF40191Zh(f40191Zh);
	    	    vf401.setF40193Str(f40193Str);
	    	    vf401.setF40195Zh(f40195Zh);
	    	    vf401.setF401101Str(f401101Str);
	    	    vf401.setF401102Zh(f401102Zh);
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
				if (connection != null) {
					connection.close();
					connection = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		f401Response.setState(state);
		return f401Response;
	}

	@Override
	public F401Response deleteF401(F401Request f401Request) {
		F401Response f401Response =new F401Response();
		long f40101 =f401Request.getF40101();
		
		boolean state =true;
		Session session =sessionFactory.getCurrentSession();
		try {
			F401 f401 =new F401();
			f401.setF40101(f40101);
			session.delete(f401);
			f401Response.setPromptMessage("删除成功！");
		} catch (Exception e) {
			state  =false;
			f401Response.setErrorMessage("删除失败！");
		}
		
		f401Response.setState(state);
		return f401Response;
	}
}
