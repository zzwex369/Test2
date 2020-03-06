package com.xyw.medical.fnbj.fnjc.dao.impl;

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

import com.xyw.medical.fnbj.fngw.dao.F308Dao;
import com.xyw.medical.fnbj.fnjc.dao.MaternalCheckDao;
import com.xyw.medical.fnbj.model.F303;
import com.xyw.medical.fnbj.model.F303Request;
import com.xyw.medical.fnbj.model.F303Response;
import com.xyw.medical.fnbj.model.F308;
import com.xyw.medical.fnbj.model.F308Response;
import com.xyw.medical.fnbj.model.VF303;
import com.xyw.sys.util.StringUtil;

public class MaternalCheckDaoImpl implements MaternalCheckDao {

	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private F308Dao f308Dao;
	private StringBuffer hql;
	private StringBuffer errorMessage;

	@Resource
	private DataSource dataSource;

	@Override
	@SuppressWarnings("unchecked")
	public F303Response saveF303(F303 f303) {
		boolean state = true;
		String message="";
		F303Response f303Response = new F303Response();
		Session session = sessionFactory.getCurrentSession();
		String f30309=f303.getF30309();
		try {
			Date systemTime = new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String nowTime=sdf.format(f303.getF30314());
			String f303Result=null;
			F308Response f308Resopnse=null;
			String f30311=f303.getF30311().toString();
			if("1".equals(f30311))
			{
				f308Resopnse=saveF308(f303);
				message=f308Resopnse.isState()?f308Resopnse.getPromptMessage():f308Resopnse.getErrorMessage();				
			}
			if("1".equals(f30309)){
				f303Result=(String) session.createSQLQuery("select t.f303_04 from f303 t where to_char(t.f303_14,'yyyy-mm-dd')= ? and t.f303_09='1' and t.f303_02=? and t.f303_15=?")
				                   .setParameter(0,nowTime).setParameter(1, f303.getF30302()).setParameter(2, f303.getF30315()).uniqueResult();				
			}
			else if ("2".equals(f30309)) {
				//复诊建册编号
				f303Result=(String) session.createSQLQuery("select t.f303_04 from f303 t where to_char(t.f303_14,'yyyy-mm-dd')= ?  and t.f303_09='2' and t.f303_02=? and t.f303_15=?")
				                   .setParameter(0, nowTime).setParameter(1, f303.getF30302()).setParameter(2, f303.getF30315()).uniqueResult();
			}
			if(f303Result!=null)
			{
				
				f303Response.setState(false);
				f303Response.setErrorMessage("重复保存! "+message);
				return f303Response; 
			}
			f303.setF303128(systemTime);
			session.save(f303);
			session.flush();
			session.refresh(f303);
			f303Response.setPromptMessage("检查信息保存成功！"+message);
		} catch (Exception e) {
			state = false;
			f303Response.setErrorMessage("保存出错! "+message);
			e.printStackTrace();
		}
		f303Response.setState(state);
		return f303Response;
	}

	@Override
	public F303Response queryF303(F303Request f303Request) {
		F303Response f303Response = new F303Response();
		String jigou = f303Request.getJigou();
		
		Date timeStr = f303Request.getTimeStr();//检查时间
		Date timeEnd = f303Request.getTimeEnd();//检查时间
		
		Date f303128Start = f303Request.getF303128Start(); //录入时间
		Date f303128End = f303Request.getF303128End(); //录入时间
		
		String name = f303Request.getName(); 
		String idcard = f303Request.getIdcard();
		String f303123_ = f303Request.getF303123();
		String f303123_flag = f303Request.getF303123_flag();

		int parameterPageindex = f303Request.getParameterPageindex();
		int parameterPagesize = f303Request.getParameterPagesize();
		String flag = f303Request.getFlag();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();

		if(f303123_flag !=null){
			if (f303123_flag.equals("初检")) {
				parameterConditionwhere.append(" and (t.F303_123 ='1' or t.F303_123='6') ");
			} else if (f303123_flag.equals("复检")) {
				parameterConditionwhere.append(" and (t.F303_123 ='2' or t.F303_123='3' or t.F303_123='4' or t.F303_123='5' or t.F303_123='7') ");
			} else if (f303123_flag.equals("当前")) {
				if (!StringUtil.isBlankString(f303123_)) {
					parameterConditionwhere.append(" and t.F303_123 = '" + f303123_+ "'");
				}
			}
		}
//		检查时间
		if (timeStr != null) {
			String f30314Start_ = sdf.format(timeStr);
			parameterConditionwhere.append(" and to_char(t.f303_14,'yyyy-mm-dd') >= '" + f30314Start_ + "'");
		}
		if (timeEnd != null) {
			String f30314End_ = sdf.format(timeEnd);
			parameterConditionwhere.append(" and to_char(t.f303_14,'yyyy-mm-dd') <= '" + f30314End_ + "'");
		}
//		录入时间
		if(f303128Start != null){
			String f303128Start_ = sdf.format(f303128Start);
			parameterConditionwhere.append(" and to_char(t.f303_128,'yyyy-mm-dd') >= '" + f303128Start_ +"'");
		}
		if(f303128End != null){
			String f303128End_ = sdf.format(f303128End);
			parameterConditionwhere.append(" and to_char(t.f303_128,'yyyy-mm-dd') <= '" + f303128End_ +"'");
		}
//		----------------
		if (!StringUtil.isBlankString(name)) {
			parameterConditionwhere.append(" and t.f303_05 = '" + name + "'");
		}
		if (!StringUtil.isBlankString(idcard)) {
			parameterConditionwhere.append(" and t.f303_07 = '" + idcard + "'");
		}
		if (!StringUtil.isBlankString(jigou)) {
			if (jigou.length() == 14) {
				parameterConditionwhere.append(" and t.f303_15 = '");
				parameterConditionwhere.append(jigou);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.f303_15 like '");
				parameterConditionwhere.append(jigou);
				parameterConditionwhere.append("%'");
			}
		}

		boolean state = true;
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_F303");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.F303_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();

			long rowCount = callableStatement.getLong(6);
			f303Response.setRowCount(rowCount);
			f303Request.setFlag(flag);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);

			//******************************************************
			//******************************************************
//			System.out.println(parameterConditionwhere.toString());
			//******************************************************
			//******************************************************
			
			VF303 vf303 = null;
			List<VF303> vf303s = new ArrayList<VF303>();
			while (resultSet.next()) {
				long f30301 = resultSet.getLong("F303_01");
				long f30302 = resultSet.getLong("F303_02");
				long f30303 = resultSet.getLong("F303_03");
				String f30304 = resultSet.getString("F303_04");
				String f30305 = resultSet.getString("F303_05");
				String f30306 = resultSet.getString("F303_06");
				String f30307 = resultSet.getString("F303_07");
				String f30308 = resultSet.getString("F303_08");
				String f30309 = resultSet.getString("F303_09");
				String f30310 = resultSet.getString("F303_10");
				Short f30311 = resultSet.getShort("F303_11");
				String f30312 = resultSet.getString("F303_12");
				String f30313 = resultSet.getString("F303_13");
				Date f30314 = resultSet.getDate("F303_14");
				String f30315 = resultSet.getString("F303_15");
				String f30316 = resultSet.getString("F303_16");
				String f30317 = resultSet.getString("F303_17");
				Date f30318 = resultSet.getDate("F303_18");
				String f30319 = resultSet.getString("F303_19");
				String f30320 = resultSet.getString("F303_20");
				Date f30321 = resultSet.getDate("F303_21");
				Date f30322 = resultSet.getDate("F303_22");
				Short f30323 = resultSet.getShort("F303_23");
				Short f30324 = resultSet.getShort("F303_24");
				Date f30325 = resultSet.getDate("F303_25");
				String f30326 = resultSet.getString("F303_26");
				String f30327 = resultSet.getString("F303_27");
				String f30328 = resultSet.getString("F303_28");
				Short f30329 = resultSet.getShort("F303_29");
				Short f30330 = resultSet.getShort("F303_30");
				String f30331 = resultSet.getString("F303_31");
				Short f30332 = resultSet.getShort("F303_32");
				String f30333 = resultSet.getString("F303_33");
				Short f30334 = resultSet.getShort("F303_34");
				String f30335 = resultSet.getString("F303_35");
				Short f30336 = resultSet.getShort("F303_36");
				String f30337 = resultSet.getString("F303_37");
				String f30338 = resultSet.getString("F303_38");
				double f30339 = resultSet.getDouble("F303_39");
				String f30340 = resultSet.getString("F303_40");
				double f30341 = resultSet.getDouble("F303_41");
				double f30342 = resultSet.getDouble("F303_42");
				String f30343 = resultSet.getString("F303_43");
				String f30344 = resultSet.getString("F303_44");
				String f30345 = resultSet.getString("F303_45");
				String f30346 = resultSet.getString("F303_46");
				String f30347 = resultSet.getString("F303_47");
				String f30348 = resultSet.getString("F303_48");
				String f30349 = resultSet.getString("F303_49");
				String f30350 = resultSet.getString("F303_50");
				String f30351 = resultSet.getString("F303_51");
				double f30352 = resultSet.getDouble("F303_52");
				double f30353 = resultSet.getDouble("F303_53");
				String f30354 = resultSet.getString("F303_54");
				double f30355 = resultSet.getDouble("F303_55");
				String f30356 = resultSet.getString("F303_56");
				String f30357 = resultSet.getString("F303_57");
				String f30358 = resultSet.getString("F303_58");
				String f30359 = resultSet.getString("F303_59");
				String f30360 = resultSet.getString("F303_60");
				String f30361 = resultSet.getString("F303_61");
				String f30362 = resultSet.getString("F303_62");
				String f30363 = resultSet.getString("F303_63");
				String f30364 = resultSet.getString("F303_64");
				String f30365 = resultSet.getString("F303_65");
				String f30366 = resultSet.getString("F303_66");
				String f30367 = resultSet.getString("F303_67");
				String f30368 = resultSet.getString("F303_68");
				String f30369 = resultSet.getString("F303_69");
				double f30370 = resultSet.getDouble("F303_70");
				double f30371 = resultSet.getDouble("F303_71");
				double f30372 = resultSet.getDouble("F303_72");
				double f30373 = resultSet.getDouble("F303_73");
				String f30374 = resultSet.getString("F303_74");
				double f30375 = resultSet.getDouble("F303_75");
				double f30376 = resultSet.getDouble("F303_76");
				String f30377 = resultSet.getString("F303_77");
				String f30378 = resultSet.getString("F303_78");
				String f30379 = resultSet.getString("F303_79");
				String f30380 = resultSet.getString("F303_80");
				String f30381 = resultSet.getString("F303_81");
				String f30382 = resultSet.getString("F303_82");
				String f30383 = resultSet.getString("F303_83");
				String f30384 = resultSet.getString("F303_84");
				String f30385 = resultSet.getString("F303_85");
				String f30386 = resultSet.getString("F303_86");
				String f30387 = resultSet.getString("F303_87");
				String f30388 = resultSet.getString("F303_88");
				String f30389 = resultSet.getString("F303_89");
				String f30390 = resultSet.getString("F303_90");
				String f30391 = resultSet.getString("F303_91");
				String f30392 = resultSet.getString("F303_92");
				String f30393 = resultSet.getString("F303_93");
				String f30394 = resultSet.getString("F303_94");
				String f30395 = resultSet.getString("F303_95");
				String f30396 = resultSet.getString("F303_96");
				String f30397 = resultSet.getString("F303_97");
				String f30398 = resultSet.getString("F303_98");
				String f30399 = resultSet.getString("F303_99");
				String f303100 = resultSet.getString("F303_100");
				String f303101 = resultSet.getString("F303_101");
				String f303102 = resultSet.getString("F303_102");
				String f303103 = resultSet.getString("F303_103");
				String f303104 = resultSet.getString("F303_104");
				String f303105 = resultSet.getString("F303_105");
				String f303106 = resultSet.getString("F303_106");
				String f303107 = resultSet.getString("F303_107");
				String f303108 = resultSet.getString("F303_108");
				String f303109 = resultSet.getString("F303_109");
				String f303110 = resultSet.getString("F303_110");

				String f303111 = resultSet.getString("F303_111");
				String f303112 = resultSet.getString("F303_112");
				String f303113 = resultSet.getString("F303_113");
				String f303114 = resultSet.getString("F303_114");
				String f303115 = resultSet.getString("F303_115");
				String f303116 = resultSet.getString("F303_116");
				String f303117 = resultSet.getString("F303_117");
				String f303118 = resultSet.getString("F303_118");
				String f303119 = resultSet.getString("F303_119");
				String f303120 = resultSet.getString("F303_120");
				String f303121 = resultSet.getString("F303_121");
				String f303122 = resultSet.getString("F303_122");
				String f303123 = resultSet.getString("F303_123");
				String f303124 = resultSet.getString("F303_124");
				String f303125 = resultSet.getString("F303_125");
				String f303126 = resultSet.getString("F303_126");
				String f303127 = resultSet.getString("F303_127");
				Date f303128 = resultSet.getDate("F303_128");
				String f303129 = resultSet.getString("F303_129");
				String f303130 = resultSet.getString("F303_130");
				
				Short f303131 = resultSet.getShort("F303_131");
				Short f303132 = resultSet.getShort("F303_132");
				Short f303133 = resultSet.getShort("F303_133");
				Short f303134 = resultSet.getShort("F303_134");
				String f303135 = resultSet.getString("F303_135");
				String f303136 = resultSet.getString("F303_136");
				String f303137 = resultSet.getString("F303_137");
				String f303138 = resultSet.getString("F303_138");
				Byte f303139 = resultSet.getByte("F303_139");
				Byte f303140 = resultSet.getByte("F303_140");
				Byte f303141 = resultSet.getByte("F303_141");
				Byte f303142 = resultSet.getByte("F303_142");
				Byte f303143 = resultSet.getByte("F303_143");
				Byte f303144 = resultSet.getByte("F303_144");
				Byte f303145 = resultSet.getByte("F303_145");
				Byte f303146 = resultSet.getByte("F303_146");
				Byte f303147 = resultSet.getByte("F303_147");
				Byte f303148 = resultSet.getByte("F303_148");
				Byte f303149 = resultSet.getByte("F303_149");
				Date f303150 = resultSet.getDate("F303_150");
				String f303151 = resultSet.getString("F303_151");
				Date f303152 = resultSet.getDate("F303_152");
				String f303153 = resultSet.getString("F303_153");
				String f303154 = resultSet.getString("F303_154");
				String f303155 = resultSet.getString("F303_155");
				String f303156 = resultSet.getString("F303_156");
				String f303157 = resultSet.getString("F303_157");
				String f303158 = resultSet.getString("F303_158");
				String f303159 = resultSet.getString("F303_159");
				String f303160 = resultSet.getString("F303_160");
				String f303161 = resultSet.getString("F303_161");
				String f303162 = resultSet.getString("F303_162");
				String f303163 = resultSet.getString("F303_163");
				String f303164 = resultSet.getString("F303_164");
				String f303165 = resultSet.getString("F303_165");
				String f303166 = resultSet.getString("F303_166");
				String f303167 = resultSet.getString("F303_167");
				String f303168 = resultSet.getString("F303_168");
				String f303169 = resultSet.getString("F303_169");
				String f303170 = resultSet.getString("F303_170");
				String f303171 = resultSet.getString("F303_171");
				Date f303172 = resultSet.getDate("F303_172");

				String f303173 = resultSet.getString("F303_173");
				String f303174 = resultSet.getString("F303_174");
				String f303175 = resultSet.getString("F303_175");
				String f303176 = resultSet.getString("F303_176");
				String f303177 = resultSet.getString("F303_177");
				String f303178 = resultSet.getString("F303_178");
				String f303179 = resultSet.getString("F303_179");
				String f303180 = resultSet.getString("F303_180");
				
				String f30306zh = resultSet.getString("F303_06ZH");
				String f30309zh = resultSet.getString("F303_09ZH");
				String f30310zh = resultSet.getString("F303_10ZH");
				String f30311zh = resultSet.getString("F303_11ZH");
				String f30326zh = resultSet.getString("F303_26ZH");
				String f30328zh = resultSet.getString("F303_28ZH");
				String f30333zh = resultSet.getString("F303_33ZH");
				String f30335zh = resultSet.getString("F303_35ZH");
				String f30344zh = resultSet.getString("F303_44ZH");
				String f30345zh = resultSet.getString("F303_45ZH");
				String f30346zh = resultSet.getString("F303_46ZH");
				String f30347zh = resultSet.getString("F303_47ZH");
				String f30348zh = resultSet.getString("F303_48ZH");
				String f30349zh = resultSet.getString("F303_49ZH");
				String f30350zh = resultSet.getString("F303_50ZH");
				String f30351zh = resultSet.getString("F303_51ZH");
				String f30354zh = resultSet.getString("F303_54ZH");
				String f30356zh = resultSet.getString("F303_56ZH");
				String f30357zh = resultSet.getString("F303_57ZH");
				String f30358zh = resultSet.getString("F303_58ZH");
				String f30360zh = resultSet.getString("F303_60ZH");
				String f30362zh = resultSet.getString("F303_62ZH");
				String f30364zh = resultSet.getString("F303_64ZH");
				String f30366zh = resultSet.getString("F303_66ZH");
				String f30368zh = resultSet.getString("F303_68ZH");
				String f30377zh = resultSet.getString("F303_77ZH");
				String f30374zh = resultSet.getString("F303_74ZH");
				String f30379zh = resultSet.getString("F303_79ZH");
				String f30381zh = resultSet.getString("F303_81ZH");
				String f30383zh = resultSet.getString("F303_83ZH");
				String f30385zh = resultSet.getString("F303_85ZH");
				String f30387zh = resultSet.getString("F303_87ZH");
				String f30389zh = resultSet.getString("F303_89ZH");
				String f30391zh = resultSet.getString("F303_91ZH");
				String f30393zh = resultSet.getString("F303_93ZH");
				String f30395zh = resultSet.getString("F303_95ZH");
				String f30397zh = resultSet.getString("F303_97ZH");
				String f30399zh = resultSet.getString("F303_99ZH");
				String f303101zh = resultSet.getString("F303_101ZH");
				String f303103zh = resultSet.getString("F303_103ZH");
				String f303105zh = resultSet.getString("F303_105ZH");
				String f303107zh = resultSet.getString("F303_107ZH");
				String f303109zh = resultSet.getString("F303_109ZH");
				String f30315zh = resultSet.getString("F303_15ZH");
				String f30316zh = resultSet.getString("F303_16ZH");
				String f303112zh = resultSet.getString("F303_112ZH");
				String f303117zh = resultSet.getString("F303_117ZH");
				String f303119zh = resultSet.getString("F303_119ZH");
				String f303121zh = resultSet.getString("F303_121ZH");
				String f303123zh = resultSet.getString("F303_123ZH");
				String f30312zh = resultSet.getString("F303_12ZH");
				Date f30252 = resultSet.getDate("F302_52");
				String f30252str = resultSet.getString("F302_52_str");
				String f30255 = resultSet.getString("F302_55");

				String f303126zh = resultSet.getString("F303_126ZH");
				
				vf303 = new VF303();
				vf303.setF30301(f30301);
				vf303.setF30302(f30302);
				vf303.setF30303(f30303);
				vf303.setF30304(f30304);
				vf303.setF30305(f30305);
				vf303.setF30306(f30306);
				vf303.setF30307(f30307);
				vf303.setF30308(f30308);
				vf303.setF30309(f30309);
				vf303.setF30310(f30310);
				vf303.setF30311(f30311);
				vf303.setF30312(f30312);
				vf303.setF30313(f30313);
				vf303.setF30314(f30314);
				vf303.setF30315(f30315);
				vf303.setF30316(f30316);
				vf303.setF30317(f30317);
				vf303.setF30318(f30318);
				vf303.setF30319(f30319);
				vf303.setF30320(f30320);
				vf303.setF30321(f30321);
				vf303.setF30322(f30322);
				vf303.setF30323(f30323);
				vf303.setF30324(f30324);
				vf303.setF30325(f30325);
				vf303.setF30326(f30326);
				vf303.setF30327(f30327);
				vf303.setF30328(f30328);
				vf303.setF30329(f30329);
				vf303.setF30330(f30330);
				vf303.setF30331(f30331);
				vf303.setF30332(f30332);
				vf303.setF30333(f30333);
				vf303.setF30334(f30334);
				vf303.setF30335(f30335);
				vf303.setF30336(f30336);
				vf303.setF30337(f30337);
				vf303.setF30338(f30338);
				vf303.setF30339(f30339);
				vf303.setF30340(f30340);
				vf303.setF30341(f30341);
				vf303.setF30342(f30342);
				vf303.setF30343(f30343);
				vf303.setF30344(f30344);
				vf303.setF30345(f30345);
				vf303.setF30346(f30346);
				vf303.setF30347(f30347);
				vf303.setF30348(f30348);
				vf303.setF30349(f30349);
				vf303.setF30350(f30350);
				vf303.setF30351(f30351);
				vf303.setF30352(f30352);
				vf303.setF30353(f30353);
				vf303.setF30354(f30354);
				vf303.setF30355(f30355);
				vf303.setF30356(f30356);
				vf303.setF30357(f30357);
				vf303.setF30358(f30358);
				vf303.setF30359(f30359);
				vf303.setF30360(f30360);
				vf303.setF30361(f30361);
				vf303.setF30362(f30362);
				vf303.setF30363(f30363);
				vf303.setF30364(f30364);
				vf303.setF30365(f30365);
				vf303.setF30366(f30366);
				vf303.setF30367(f30367);
				vf303.setF30368(f30368);
				vf303.setF30369(f30369);
				vf303.setF30370(f30370);
				vf303.setF30371(f30371);
				vf303.setF30372(f30372);
				vf303.setF30373(f30373);
				vf303.setF30374(f30374);
				vf303.setF30375(f30375);
				vf303.setF30376(f30376);
				vf303.setF30377(f30377);
				vf303.setF30378(f30378);
				vf303.setF30379(f30379);
				vf303.setF30380(f30380);
				vf303.setF30381(f30381);
				vf303.setF30382(f30382);
				vf303.setF30383(f30383);
				vf303.setF30384(f30384);
				vf303.setF30385(f30385);
				vf303.setF30386(f30386);
				vf303.setF30387(f30387);
				vf303.setF30388(f30388);
				vf303.setF30389(f30389);
				vf303.setF30390(f30390);
				vf303.setF30391(f30391);
				vf303.setF30392(f30392);
				vf303.setF30393(f30393);
				vf303.setF30394(f30394);
				vf303.setF30395(f30395);
				vf303.setF30396(f30396);
				vf303.setF30397(f30397);
				vf303.setF30398(f30398);
				vf303.setF30399(f30399);
				vf303.setF303100(f303100);
				vf303.setF303101(f303101);
				vf303.setF303102(f303102);
				vf303.setF303103(f303103);
				vf303.setF303104(f303104);
				vf303.setF303105(f303105);
				vf303.setF303106(f303106);
				vf303.setF303107(f303107);
				vf303.setF303108(f303108);
				vf303.setF303109(f303109);
				vf303.setF303110(f303110);

				vf303.setF303111(f303111);
				vf303.setF303112(f303112);
				vf303.setF303113(f303113);
				vf303.setF303114(f303114);
				vf303.setF303115(f303115);
				vf303.setF303116(f303116);
				vf303.setF303117(f303117);
				vf303.setF303118(f303118);
				vf303.setF303119(f303119);
				vf303.setF303120(f303120);
				vf303.setF303121(f303121);
				vf303.setF303122(f303122);
				vf303.setF303123(f303123);
				vf303.setF303124(f303124);
				vf303.setF303125(f303125);
				vf303.setF303126(f303126);
				vf303.setF303127(f303127);
				vf303.setF303128(f303128);
				vf303.setF303129(f303129);
				vf303.setF303130(f303130);
				
				vf303.setF303131(f303131);
				vf303.setF303132(f303132);
				vf303.setF303133(f303133);
				vf303.setF303134(f303134);
				vf303.setF303135(f303135);
				vf303.setF303136(f303136);
				vf303.setF303137(f303137);
				vf303.setF303138(f303138);
				vf303.setF303139(f303139);
				vf303.setF303140(f303140);
				vf303.setF303141(f303141);
				vf303.setF303142(f303142);
				vf303.setF303143(f303143);
				vf303.setF303144(f303144);
				vf303.setF303145(f303145);
				vf303.setF303146(f303146);
				vf303.setF303147(f303147);
				vf303.setF303148(f303148);
				vf303.setF303149(f303149);
				vf303.setF303150(f303150);
				
				vf303.setF303151(f303151);
				vf303.setF303152(f303152);
				vf303.setF303153(f303153);
				vf303.setF303154(f303154);
				vf303.setF303155(f303155);
				vf303.setF303156(f303156);
				vf303.setF303157(f303157);
				vf303.setF303158(f303158);
				vf303.setF303159(f303159);
				vf303.setF303160(f303160);
				vf303.setF303161(f303161);
				vf303.setF303162(f303162);
				vf303.setF303163(f303163);
				vf303.setF303164(f303164);
				vf303.setF303165(f303165);
				vf303.setF303166(f303166);
				vf303.setF303167(f303167);
				vf303.setF303168(f303168);
				vf303.setF303169(f303169);
				vf303.setF303170(f303170);
				
				vf303.setF303171(f303171);
				vf303.setF303172(f303172);
				vf303.setF303173(f303173);
				vf303.setF303174(f303174);
				vf303.setF303175(f303175);
				vf303.setF303176(f303176);
				vf303.setF303177(f303177);
				vf303.setF303178(f303178);
				vf303.setF303179(f303179);
				vf303.setF303180(f303180);
		

				vf303.setF30306zh(f30306zh);
				vf303.setF30309zh(f30309zh);
				vf303.setF30310zh(f30310zh);
				vf303.setF30311zh(f30311zh);
				vf303.setF30326zh(f30326zh);
				vf303.setF30328zh(f30328zh);
				vf303.setF30333zh(f30333zh);
				vf303.setF30335zh(f30335zh);
				vf303.setF30344zh(f30344zh);
				vf303.setF30345zh(f30345zh);
				vf303.setF30346zh(f30346zh);
				vf303.setF30347zh(f30347zh);
				vf303.setF30348zh(f30348zh);
				vf303.setF30349zh(f30349zh);
				vf303.setF30350zh(f30350zh);
				vf303.setF30351zh(f30351zh);
				vf303.setF30354zh(f30354zh);
				vf303.setF30356zh(f30356zh);
				vf303.setF30357zh(f30357zh);
				vf303.setF30358zh(f30358zh);
				vf303.setF30360zh(f30360zh);
				vf303.setF30362zh(f30362zh);
				vf303.setF30364zh(f30364zh);
				vf303.setF30366zh(f30366zh);
				vf303.setF30368zh(f30368zh);
				vf303.setF30377zh(f30377zh);
				vf303.setF30374zh(f30374zh);
				vf303.setF30379zh(f30379zh);
				vf303.setF30381zh(f30381zh);
				vf303.setF30383zh(f30383zh);
				vf303.setF30385zh(f30385zh);
				vf303.setF30387zh(f30387zh);
				vf303.setF30389zh(f30389zh);
				vf303.setF30391zh(f30391zh);
				vf303.setF30393zh(f30393zh);
				vf303.setF30395zh(f30395zh);
				vf303.setF30397zh(f30397zh);
				vf303.setF30399zh(f30399zh);
				vf303.setF303101zh(f303101zh);
				vf303.setF303103zh(f303103zh);
				vf303.setF303105zh(f303105zh);
				vf303.setF303107zh(f303107zh);
				vf303.setF303109zh(f303109zh);
				vf303.setF30315zh(f30315zh);
				vf303.setF30316zh(f30316zh);
				vf303.setF303112zh(f303112zh);
				vf303.setF303117zh(f303117zh);
				vf303.setF303119zh(f303119zh);
				vf303.setF303121zh(f303121zh);
				vf303.setF303123zh(f303123zh);
				vf303.setF30312zh(f30312zh);
				vf303.setF30252(f30252);
				vf303.setF30252Str(f30252str);
				vf303.setF30255(f30255);
				
				vf303.setF303126zh(f303126zh);
				vf303s.add(vf303);
			}
			f303Response.setState(state);
			f303Response.setVf303s(vf303s);
		} catch (Exception e) {
			e.printStackTrace();
			f303Response.setState(false);
			f303Response.setErrorMessage("查询失败！");
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
		return f303Response;
	}

	@Override
	public F303Response updateF303(F303 f303) {
		F303Response f303Response = new F303Response();
		Session session = sessionFactory.getCurrentSession();
		boolean state = true;
		try {
			session.saveOrUpdate(f303);
			f303Response.setPromptMessage("检查信息更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage.append(e.getMessage());
			f303Response.setErrorMessage(errorMessage.toString());
			state = false;
		}
		f303Response.setState(state);
		return f303Response;
	}

	@Override
	public F303Response deleteF303(F303Request f303Request) {
		F303Response f303Response = new F303Response();
		long f30301 = f303Request.getZhujian();
		String f30305 = f303Request.getName();
		String f30307 = f303Request.getIdcard();
		String f30315 = f303Request.getJigou();
		String f30314 = new SimpleDateFormat("yyyy-MM-dd").format(f303Request
				.getTimeEnd());
		StringBuffer sql = new StringBuffer("select * from V_F303 t where 1=1");
		// if (f30301 != 0) {
		// sql.append(" and t.f303_01 ='"+f30301+"'");
		// }
		if (f30305 != null) {
			sql.append(" and t.f303_05 = '" + f30305 + "'");
		}
		if (f30307 != null) {
			sql.append(" and t.f303_07 = '" + f30307 + "'");
		}
		if (f30314 != null) {
			sql.append(" and to_char(t.f303_14,'yyyy-mm-dd') > '" + f30314 + "'");
		}
		if (f30315 != null) {
			sql.append(" and t.f303_15 = '" + f30315 + "'");
		}

		try {
			Session session = sessionFactory.getCurrentSession();
			SQLQuery query = session.createSQLQuery(sql.toString());
			int size = query.list().size();
			if (size > 0) {
				f303Response.setErrorMessage("不是最新检查不能删除 ，不能再删除！");
				return f303Response;
			} else {
				F303 f303 = new F303();
				f303.setF30301(f30301);
				session.delete(f303);
				f303Response.setPromptMessage("删除成功！");
			}
		} catch (Exception e) {
			f303Response.setErrorMessage("删除失败！");
		}

		return f303Response;
	}
	
	@SuppressWarnings("unchecked")
	private F308Response saveF308(F303 f303) {
		F308Response _f308Response=f308Dao.queryByF301Id(f303.getF30302());		
		F308Response f308Response=new F308Response();
		try {
			F308 f308=new F308();
			String phone=null;
			Session session=sessionFactory.getCurrentSession();
			if(_f308Response.isState()){
				f308Response.setState(false);
				f308Response.setErrorMessage("已经存在高危档案，无法重复保存");
				return f308Response;
			}else {
				f308Response.setPromptMessage("高危档案保存成功");// 保存
				f308.setF30812("2");
				phone = (String) session.createSQLQuery(
						"select t.f301_13 from f301 t where t.f301_01=?")
						.setParameter(0, f303.getF30302()).uniqueResult();
				f308.setF30810(phone);
				f308.setF30802(f303.getF30302());
				f308.setF30803(f303.getF30305());
				f308.setF30804(f303.getF30306());
				f308.setF30805(f303.getF30307());
				f308.setF30806(f303.getF30304());
				f308.setF30807(new SimpleDateFormat("yyyy-MM-dd").parse(f303.getF30308()));
				f308.setF30808(f303.getF30323().toString());
				f308.setF30809(f303.getF30324().toString());
				f308.setF30811("0");
				f308.setF30813(f303.getF30312());
				f308.setF30814(f303.getF30313());
				f308.setF30815(f303.getF30319());
				f308.setF30816(f303.getF30315());
				f308.setF30817(new Date());
				session.save(f308);
				f308Response.setState(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			f308Response.setState(false);
			f308Response.setErrorMessage("保存高危档案异常");
		}
		return f308Response;
	}
}
