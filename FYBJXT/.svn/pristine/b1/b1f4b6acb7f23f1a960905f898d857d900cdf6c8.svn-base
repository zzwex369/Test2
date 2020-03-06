package com.xyw.medical.birth.deliveryRegist.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

import com.xyw.medical.birth.deliveryRegist.dao.DeliveryDao;
import com.xyw.medical.birth.model.D601;
import com.xyw.medical.birth.model.D602;
import com.xyw.medical.birth.model.D603;
import com.xyw.medical.birth.model.QueryBirthRequest;
import com.xyw.medical.birth.model.QueryBirthResponse;
import com.xyw.medical.birth.model.VD601;
import com.xyw.medical.birth.model.ZyfmdjbRequest;
import com.xyw.medical.birth.model.ZyfmdjbResponse;
import com.xyw.sys.util.StringUtil;

public class DeliveryDaoImpl implements DeliveryDao {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private DataSource dataSource;
	private StringBuffer errorMessage;
	@SuppressWarnings("unchecked")
	@Override
	public QueryBirthResponse saveDeliveryRegist(D601 d601) {
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		String d60105 = d601.getD60105();
		String d60165 = d601.getD60165();
		Date d60103 = d601.getD60103();
		
		boolean state = true;
		Session session = sessionFactory.getCurrentSession();
		try{
			StringBuffer sql = new StringBuffer("select * from D601 t where 1=1 ");
			if(d60105 != null){
				sql.append(" and t.d601_05='"+d60105 +"' ");
			}
			if(d60165 != null){
				sql.append(" and t.d601_65='"+d60165 +"' ");
			}
			if(d60103 != null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String d60103str = sdf.format(d60103);
				sql.append(" and t.d601_03=to_date('"+d60103str +"','yyyy-MM-dd HH24:mi:ss') ");
			}
			SQLQuery query = session.createSQLQuery(sql.toString());
			List<D601> d601s = query.addEntity(D601.class).list();
			if(d601s.size()>0){
				state = false;
				queryBirthResponse.setErrorMessage("重复保存！");
			}
		}catch(Exception e){
			state = false;
			queryBirthResponse.setErrorMessage("保存失败！");
			e.printStackTrace();
		}
		if(state){
			try{
				session.save(d601);
				session.flush();
				session.refresh(d601);
			}catch(Exception e){
				e.printStackTrace();
				state = false;
				queryBirthResponse.setErrorMessage("保存失败！");
			}
		}
		queryBirthResponse.setState(state);
		return queryBirthResponse;
	}
	
	@Override
	public QueryBirthResponse queryDeliveryRegist(QueryBirthRequest queryBirthRequest) {
	
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		this.errorMessage = new StringBuffer();
		boolean state = true;
		String d601_05 = queryBirthRequest.getD601_05();
		String d601_65 = queryBirthRequest.getD601_65();
		String d601_72 = queryBirthRequest.getD601_72();
		String d601_75 = queryBirthRequest.getD601_75();
		String d601_02 = queryBirthRequest.getD601_02();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from V_D601_FOR_D304 t where 1=1 ");
		if(d601_05 !=null){
			sql.append(" and t.D601_05 = '"+d601_05+"'");
		}
        if(d601_65 !=null){
        	sql.append(" and t.D601_65 = '"+d601_65+"'");
		}
        if(d601_72 !=null){
        	sql.append(" and t.D601_72 = '"+d601_72+"'");
        }
        if(d601_75 !=null){
        	sql.append(" and t.D601_75 = '"+d601_75+"'");
		}
        if(d601_02 !=null){
        	sql.append(" and t.D601_02 like '"+d601_02+"%'");
        }
		List<VD601> d601s = null;
		VD601 vd601 = null;
		try{
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			//preparedStatement.setString(0, d601_02);
			resultSet = preparedStatement.executeQuery();
			d601s = new ArrayList<VD601>();
			while(resultSet.next()) {
				
				long d60101 = resultSet.getLong("D601_01");
				String d60102 = resultSet.getString("D601_02");
				String d60103 = resultSet.getString("D601_03");
				long d60104 = resultSet.getLong("D601_04");
				String d60105 = resultSet.getString("D601_05");
				String d60109 = resultSet.getString("D601_09");
				long d60121 = resultSet.getLong("D601_21");
				String d60122 = resultSet.getString("D601_22");
				String d60124 = resultSet.getString("D601_24");
				String d60140 = resultSet.getString("D601_40");
				long d60143 = resultSet.getLong("D601_43");
				long d60144 = resultSet.getLong("D601_44");
				String d60149 = resultSet.getString("D601_49");
				String d60155 = resultSet.getString("D601_55");
				String d60157 = resultSet.getString("D601_57");
				String d60158 = resultSet.getString("D601_58");
				String d60159 = resultSet.getString("D601_59");
				String d60160 = resultSet.getString("D601_60");
				String d60164 = resultSet.getString("D601_64");
				String d60165 = resultSet.getString("D601_65");
				String d60167 = resultSet.getString("D601_67");
				String d60169 = resultSet.getString("D601_69");
				String d60172 = resultSet.getString("D601_72");
				String d60174 = resultSet.getString("D601_74");
				String d60175 = resultSet.getString("D601_75");
				String d60176 = resultSet.getString("D601_76");
				String d60177 = resultSet.getString("D601_77");
				String d60185 = resultSet.getString("D601_85");
				String d60186 = resultSet.getString("D601_86");
				String d60187 = resultSet.getString("D601_87");
				String d60188 = resultSet.getString("D601_88");
				
				String d60102ZH = resultSet.getString("D601_02_ZH");
				String d60109ZH = resultSet.getString("D601_09_ZH");
				String d60140ZH = resultSet.getString("D601_40_ZH");
				String d60157ZH = resultSet.getString("D601_57_ZH");
				String d60174ZH = resultSet.getString("D601_74_ZH");
				String d60177ZH = resultSet.getString("D601_77_ZH");
				String d60185ZH = resultSet.getString("D601_85_ZH");
				
				vd601 = new VD601();
				vd601.setD60101(d60101);
				vd601.setD60102(d60102);
				vd601.setD60103(d60103);
				vd601.setD60104(d60104);
				vd601.setD60105(d60105);
				vd601.setD60109(d60109);
				vd601.setD60121(d60121);
				vd601.setD60122(d60122);
				vd601.setD60124(d60124);
				vd601.setD60140(d60140);
				vd601.setD60143(d60143);
				vd601.setD60144(d60144);
				vd601.setD60149(d60149);
				vd601.setD60155(d60155);
				vd601.setD60157(d60157);
				vd601.setD60158(d60158);
				vd601.setD60159(d60159);
				vd601.setD60160(d60160);
				vd601.setD60164(d60164);
				vd601.setD60165(d60165);
				vd601.setD60167(d60167);
				vd601.setD60169(d60169);
				vd601.setD60172(d60172);
				vd601.setD60174(d60174);
				vd601.setD60175(d60175);
				vd601.setD60176(d60176);
				vd601.setD60177(d60177);
				vd601.setD60185(d60185);
				vd601.setD60186(d60186);
				vd601.setD60187(d60187);
				vd601.setD60188(d60188);
				vd601.setD60102ZH(d60102ZH);
				vd601.setD60109ZH(d60109ZH);
				vd601.setD60140ZH(d60140ZH);
				vd601.setD60157ZH(d60157ZH);
				vd601.setD60174ZH(d60174ZH);
				vd601.setD60177ZH(d60177ZH);
				vd601.setD60185ZH(d60185ZH);
				
				d601s.add(vd601);
			}
		}catch(Exception e) {
			e.printStackTrace();
			this.errorMessage.append("查询失败！");
			state = false;
		}finally {
			try {
				if(resultSet != null) {
					resultSet.close();
					resultSet = null;
				}
				if(preparedStatement != null) {
					preparedStatement.close();
					preparedStatement = null;
				}
				if(connection != null) {
					connection.close();
					connection = null;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(state){
			if(d601s.size() <= 0) {
				this.errorMessage.append("没有相关分娩信息！");
				state = false;
			} else {
				queryBirthResponse.setD601s(d601s);
			}
		}
		queryBirthResponse.setState(state);
		queryBirthResponse.setErrorMessage(this.errorMessage.toString());
		return queryBirthResponse;
	}
	@Override
	public QueryBirthResponse queryD601(QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		
		String d601_02_p = queryBirthRequest.getD601_02();
		String d601_05_p = queryBirthRequest.getD601_05();
		String d601_55_p = queryBirthRequest.getD601_55();
		String d601_56_p = queryBirthRequest.getD601_56();
		String d601_65_p = queryBirthRequest.getD601_65();
		String d601_72_p = queryBirthRequest.getD601_72();
		String d601_75_p = queryBirthRequest.getD601_75();
		Date d60103Start = queryBirthRequest.getD60103Start();
		Date d60103End = queryBirthRequest.getD60103End();
		int parameterPageindex = queryBirthRequest.getParameterPageindex();
		int parameterPagesize = queryBirthRequest.getParameterPagesize();
		String flag = queryBirthRequest.getFlag();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer parameterConditionwhere = new StringBuffer();
		if(!StringUtil.isBlankString(d601_02_p)){
			if(d601_02_p.length() == 14)
			{
				parameterConditionwhere.append(" and t.d601_02 = '");
				parameterConditionwhere.append(d601_02_p);
				parameterConditionwhere.append("'");
			}else
			{
				parameterConditionwhere.append(" and t.d601_02 like '");
				parameterConditionwhere.append(d601_02_p);
				parameterConditionwhere.append("%'");
			}
		}
		if(!StringUtil.isBlankString(d601_05_p)){
			parameterConditionwhere.append(" and t.d601_05 = '");
			parameterConditionwhere.append(d601_05_p);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(d601_55_p)){
			parameterConditionwhere.append(" and t.d601_55 = '");
			parameterConditionwhere.append(d601_55_p);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(d601_56_p)){
			parameterConditionwhere.append(" and t.d601_56 = '");
			parameterConditionwhere.append(d601_56_p);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(d601_65_p)){
			parameterConditionwhere.append(" and t.d601_65 = '");
			parameterConditionwhere.append(d601_65_p);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(d601_72_p)){
			parameterConditionwhere.append(" and t.d601_72 = '");
			parameterConditionwhere.append(d601_72_p);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(d601_75_p)){
			parameterConditionwhere.append(" and t.d601_75 = '");
			parameterConditionwhere.append(d601_75_p);
			parameterConditionwhere.append("'");
		}
		if(d60103Start != null)
		{
			String d60103Start_p = simpleDateFormat.format(d60103Start);
			parameterConditionwhere.append(" and t.d601_03_str >= '" + d60103Start_p + "'");
		}
		if(d60103End != null)
		{
			String d60103End_p = simpleDateFormat.format(d60103End);
			parameterConditionwhere.append(" and t.d601_03_str <= '" + d60103End_p + "'");
		}
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");
			
			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_D601");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D601_01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			
			long rowCount = callableStatement.getLong(6);
			queryBirthResponse.setRowCount(rowCount);
			queryBirthResponse.setFlag(flag);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			
			VD601 vd601 = null;
			List<VD601> vd601s = new ArrayList<VD601>();
		
			while(resultSet.next()){
				long d60101 = resultSet.getLong("D601_01");
				String d60102 = resultSet.getString("D601_02");
				Date d60103 = resultSet.getTimestamp("D601_03");
				long d60104 = resultSet.getLong("D601_04");
				String d60105 = resultSet.getString("D601_05");
				String d60106 = resultSet.getString("D601_06");
				String d60107 = resultSet.getString("D601_07");
				String d60108 = resultSet.getString("D601_08");
				String d60109 = resultSet.getString("D601_09");
				String d60110 = resultSet.getString("D601_10");
				
				String d60111 = resultSet.getString("D601_11");
				String d60112 = resultSet.getString("D601_12");
				String d60113 = resultSet.getString("D601_13");
				long d60114 = resultSet.getLong("D601_14");
				String d60115 = resultSet.getString("D601_15");
				String d60116 = resultSet.getString("D601_16");
				String d60117 = resultSet.getString("D601_17");
				String d60118 = resultSet.getString("D601_18");
				long d60119 = resultSet.getLong("D601_19");
				long d60120 = resultSet.getLong("D601_20");
				
				long d60121 = resultSet.getLong("D601_21");
				String d60122 = resultSet.getString("D601_22");
				String d60123 = resultSet.getString("D601_23");
				String d60124 = resultSet.getString("D601_24");
				String d60125 = resultSet.getString("D601_25");
				String d60126 = resultSet.getString("D601_26");
				String d60127 = resultSet.getString("D601_27");
				String d60128 = resultSet.getString("D601_28");
				String d60129 = resultSet.getString("D601_29");
				String d60130 = resultSet.getString("D601_30");
				
				String d60131 = resultSet.getString("D601_31");
				String d60132 = resultSet.getString("D601_32");
				String d60133 = resultSet.getString("D601_33");
				String d60134 = resultSet.getString("D601_34");
				long d60135 = resultSet.getLong("D601_35");
				long d60136 = resultSet.getLong("D601_36");
				long d60137 = resultSet.getLong("D601_37");
				String d60138 = resultSet.getString("D601_38");
				long d60139 = resultSet.getLong("D601_39");
				String d60140 = resultSet.getString("D601_40");
				
				long d60141 = resultSet.getLong("D601_41");
				long d60142 = resultSet.getLong("D601_42");
				long d60143 = resultSet.getLong("D601_43");
				long d60144 = resultSet.getLong("D601_44");
				String d60145 = resultSet.getString("D601_45");
				String d60146 = resultSet.getString("D601_46");
				String d60147 = resultSet.getString("D601_47");
				String d60148 = resultSet.getString("D601_48");
				String d60149 = resultSet.getString("D601_49");
				String d60150 = resultSet.getString("D601_50");
				
				String d60151 = resultSet.getString("D601_51");
				String d60152 = resultSet.getString("D601_52");
				String d60153 = resultSet.getString("D601_53");
				String d60154 = resultSet.getString("D601_54");
				String d60155 = resultSet.getString("D601_55");
				String d60156 = resultSet.getString("D601_56");
				String d60157 = resultSet.getString("D601_57");
				String d60158 = resultSet.getString("D601_58");
				String d60159 = resultSet.getString("D601_59");
				String d60160 = resultSet.getString("D601_60");
				
				String d60161 = resultSet.getString("D601_61");
				String d60162 = resultSet.getString("D601_62");
				String d60163 = resultSet.getString("D601_63");
				String d60164 = resultSet.getString("D601_64");
				String d60165 = resultSet.getString("D601_65");
				String d60166 = resultSet.getString("D601_66");
				String d60167 = resultSet.getString("D601_67");
				String d60168 = resultSet.getString("D601_68");
				String d60169 = resultSet.getString("D601_69");
				String d60170 = resultSet.getString("D601_70");
				
				String d60171 = resultSet.getString("D601_71");
				String d60172 = resultSet.getString("D601_72");
				String d60173 = resultSet.getString("D601_73");
				String d60174 = resultSet.getString("D601_74");
				String d60175 = resultSet.getString("D601_75");
				String d60176 = resultSet.getString("D601_76");
				String d60177 = resultSet.getString("D601_77");
				String d60178 = resultSet.getString("D601_78");
				String d60179 = resultSet.getString("D601_79");
				String d60180 = resultSet.getString("D601_80");
				
				String d60181 = resultSet.getString("D601_81");
				String d60182 = resultSet.getString("D601_82");
				String d60183 = resultSet.getString("D601_83");
				String d60184 = resultSet.getString("D601_84");
				String d60185 = resultSet.getString("D601_85");
				String d60186 = resultSet.getString("D601_86");
				String d60187 = resultSet.getString("D601_87");
				String d60188 = resultSet.getString("D601_88");
				String d60189 = resultSet.getString("D601_89");
				String d60190 = resultSet.getString("D601_90");
				
				String d60191 = resultSet.getString("D601_91");
				String d60192 = resultSet.getString("D601_92");
				String d60193 = resultSet.getString("D601_93");
				String d60194 = resultSet.getString("D601_94");
				String d60195 = resultSet.getString("D601_95");
				String d60196 = resultSet.getString("D601_96");
				String d60197 = resultSet.getString("D601_97");
				String d60198 = resultSet.getString("D601_98");
				String d60199 = resultSet.getString("D601_99");
				String d601103 = resultSet.getString("D601_103");
				
				String d60102ZH = resultSet.getString("D601_02_ZH");
				String d60106ZH = resultSet.getString("D601_06_ZH");
				String d60108ZH = resultSet.getString("D601_08_ZH");
				String d60109ZH = resultSet.getString("D601_09_ZH");
				String d60111ZH = resultSet.getString("D601_11_ZH");
				String d60117ZH = resultSet.getString("D601_17_ZH");
				String d60118ZH = resultSet.getString("D601_18_ZH");
				String d60123ZH = resultSet.getString("D601_23_ZH");
				String d60125ZH = resultSet.getString("D601_25_ZH");
				String d60126ZH = resultSet.getString("D601_26_ZH");
				String d60132ZH = resultSet.getString("D601_32_ZH");
				String d60133ZH = resultSet.getString("D601_33_ZH");
				String d60134ZH = resultSet.getString("D601_34_ZH");
				String d60140ZH = resultSet.getString("D601_40_ZH");
				String d60145ZH = resultSet.getString("D601_45_ZH");
				String d60146ZH = resultSet.getString("D601_46_ZH");
				String d60147ZH = resultSet.getString("D601_47_ZH");
				String d60148ZH = resultSet.getString("D601_48_ZH");
				String d60149ZH = resultSet.getString("D601_49_ZH");
				String d60151ZH = resultSet.getString("D601_51_ZH");
				String d60152ZH = resultSet.getString("D601_52_ZH");
				String d60157ZH = resultSet.getString("D601_57_ZH");
				String d60168ZH = resultSet.getString("D601_68_ZH");
				String d60170ZH = resultSet.getString("D601_70_ZH");
				String d60171ZH = resultSet.getString("D601_71_ZH");
				String d60174ZH = resultSet.getString("D601_74_ZH");
				String d60177ZH = resultSet.getString("D601_77_ZH");
				String d60178ZH = resultSet.getString("D601_78_ZH");
				String d60179ZH = resultSet.getString("D601_79_ZH");
				String d60180ZH = resultSet.getString("D601_80_ZH");
				String d60181ZH = resultSet.getString("D601_81_ZH");
				String d60182ZH = resultSet.getString("D601_82_ZH");
				String d60183ZH = resultSet.getString("D601_83_ZH");
				String d60184ZH = resultSet.getString("D601_84_ZH");
				String d60185ZH = resultSet.getString("D601_85_ZH");
				String d601103ZH = resultSet.getString("D601_103_ZH");
				
				vd601 = new VD601();
				
				vd601.setD60101(d60101);
				vd601.setD60102(d60102);
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String d60103_str = simpleDateFormat.format(d60103);
				vd601.setD60103(d60103_str);
				vd601.setD60104(d60104);
				vd601.setD60105(d60105);
				vd601.setD60106(d60106);
				vd601.setD60107(d60107);
				vd601.setD60108(d60108);
				vd601.setD60109(d60109);
				vd601.setD60110(d60110);
				
				vd601.setD60111(d60111);
				vd601.setD60112(d60112);
				vd601.setD60113(d60113);
				vd601.setD60114(d60114);
				vd601.setD60115(d60115);
				vd601.setD60116(d60116);
				vd601.setD60117(d60117);
				vd601.setD60118(d60118);
				vd601.setD60119(d60119);
				vd601.setD60120(d60120);
				
				vd601.setD60121(d60121);
				vd601.setD60122(d60122);
				vd601.setD60123(d60123);
				vd601.setD60124(d60124);
				vd601.setD60125(d60125);
				vd601.setD60126(d60126);
				vd601.setD60127(d60127);
				vd601.setD60128(d60128);
				vd601.setD60129(d60129);
				vd601.setD60130(d60130);
				
				vd601.setD60131(d60131);
				vd601.setD60132(d60132);
				vd601.setD60133(d60133);
				vd601.setD60134(d60134);
				vd601.setD60135(d60135);
				vd601.setD60136(d60136);
				vd601.setD60137(d60137);
				vd601.setD60138(d60138);
				vd601.setD60139(d60139);
				vd601.setD60140(d60140);
				
				vd601.setD60141(d60141);
				vd601.setD60142(d60142);
				vd601.setD60143(d60143);
				vd601.setD60144(d60144);
				vd601.setD60145(d60145);
				vd601.setD60146(d60146);
				vd601.setD60147(d60147);
				vd601.setD60148(d60148);
				vd601.setD60149(d60149);
				vd601.setD60150(d60150);
				
				vd601.setD60151(d60151);
				vd601.setD60152(d60152);
				vd601.setD60153(d60153);
				vd601.setD60154(d60154);
				vd601.setD60155(d60155);
				vd601.setD60156(d60156);
				vd601.setD60157(d60157);
				vd601.setD60158(d60158);
				vd601.setD60159(d60159);
				vd601.setD60160(d60160);
				
				vd601.setD60161(d60161);
				vd601.setD60162(d60162);
				vd601.setD60163(d60163);
				vd601.setD60164(d60164);
				vd601.setD60165(d60165);
				vd601.setD60166(d60166);
				vd601.setD60167(d60167);
				vd601.setD60168(d60168);
				vd601.setD60169(d60169);
				vd601.setD60170(d60170);
				
				vd601.setD60171(d60171);
				vd601.setD60172(d60172);
				vd601.setD60173(d60173);
				vd601.setD60174(d60174);
				vd601.setD60175(d60175);
				vd601.setD60176(d60176);
				vd601.setD60177(d60177);
				vd601.setD60178(d60178);
				vd601.setD60179(d60179);
				vd601.setD60180(d60180);
				
				vd601.setD60181(d60181);
				vd601.setD60182(d60182);
				vd601.setD60183(d60183);
				vd601.setD60184(d60184);
				vd601.setD60185(d60185);
				vd601.setD60186(d60186);
				vd601.setD60187(d60187);
				vd601.setD60188(d60188);
				vd601.setD60189(d60189);
				vd601.setD60190(d60190);
				
				vd601.setD60191(d60191);
				vd601.setD60192(d60192);
				vd601.setD60193(d60193);
				vd601.setD60194(d60194);
				vd601.setD60195(d60195);
				vd601.setD60196(d60196);
				vd601.setD60197(d60197);
				vd601.setD60198(d60198);
				vd601.setD60199(d60199);
				vd601.setD601103(d601103);
				
				vd601.setD60102ZH(d60102ZH);
				vd601.setD60106ZH(d60106ZH);
				vd601.setD60108ZH(d60108ZH);
				vd601.setD60109ZH(d60109ZH);
				vd601.setD60111ZH(d60111ZH);
				vd601.setD60117ZH(d60117ZH);
				vd601.setD60118ZH(d60118ZH);
				vd601.setD60123ZH(d60123ZH);
				vd601.setD60125ZH(d60125ZH);
				vd601.setD60126ZH(d60126ZH);
				vd601.setD60132ZH(d60132ZH);
				vd601.setD60133ZH(d60133ZH);
				vd601.setD60134ZH(d60134ZH);
				vd601.setD60140ZH(d60140ZH);
				vd601.setD60145ZH(d60145ZH);
				vd601.setD60146ZH(d60146ZH);
				vd601.setD60147ZH(d60147ZH);
				vd601.setD60148ZH(d60148ZH);
				vd601.setD60149ZH(d60149ZH);
				vd601.setD60151ZH(d60151ZH);
				vd601.setD60152ZH(d60152ZH);
				vd601.setD60157ZH(d60157ZH);
				vd601.setD60168ZH(d60168ZH);
				vd601.setD60170ZH(d60170ZH);
				vd601.setD60171ZH(d60171ZH);
				vd601.setD60174ZH(d60174ZH);
				vd601.setD60177ZH(d60177ZH);
				vd601.setD60178ZH(d60178ZH);
				vd601.setD60179ZH(d60179ZH);
				vd601.setD60180ZH(d60180ZH);
				vd601.setD60181ZH(d60181ZH);
				vd601.setD60182ZH(d60182ZH);
				vd601.setD60183ZH(d60183ZH);
				vd601.setD60184ZH(d60184ZH);
				vd601.setD60185ZH(d60185ZH);
				vd601.setD601103ZH(d601103ZH);
				
				vd601s.add(vd601);
			}
			queryBirthResponse.setD601s(vd601s);
		} catch (Exception e) {
			e.printStackTrace();
			queryBirthResponse.setErrorMessage("查询失败！");
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
				e.printStackTrace();
			}
		}
		
		return queryBirthResponse;
	}

	@Override
	public QueryBirthResponse saveD603(D603 d603) {
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		boolean state = true;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.save(d603);
		}catch(Exception e)
		{
			this.errorMessage.append("保存失败！");
			state = false;
			queryBirthResponse.setErrorMessage(errorMessage.toString());
		}
		queryBirthResponse.setState(state);
		return queryBirthResponse;
	}

	@Override
	public QueryBirthResponse renewDelivery(D601 d601) {
		Session session = sessionFactory.getCurrentSession();
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		long d60101 = d601.getD60101();
		boolean state =true;
		try {
			StringBuffer sql =new StringBuffer("select * from v_d304 t where 1=1 and t.d304_32 ='" + d60101 +"' ");
			SQLQuery queryd304 = session.createSQLQuery(sql.toString());
			int size = queryd304.list().size();
			if(size>0){
				queryBirthResponse.setErrorMessage("首发登记表已保存，不能修改！");
				state = false;
			}
		} catch (Exception e) {
			state = false;
			queryBirthResponse.setErrorMessage("保存失败！");
			e.printStackTrace();
		}
		if(state){
			try{
				session.saveOrUpdate(d601);
			}catch(Exception e){
				e.printStackTrace();
				queryBirthResponse.setErrorMessage("保存失败!");
				state = false;
			}
		}
		
		queryBirthResponse.setState(state);
		return queryBirthResponse;
	}
	
	@Override
	public QueryBirthResponse saveHealthcareInfo(D602 d602) {
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		boolean state = true;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.save(d602);
		}catch(Exception e)
		{
			e.printStackTrace();
			this.errorMessage.append("保存失败！");
			state = false;
			queryBirthResponse.setErrorMessage(errorMessage.toString());
		}
		queryBirthResponse.setState(state);
		return queryBirthResponse;
	}
	@Override
	public QueryBirthResponse deleteD601(QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = null;
		long d60101 = queryBirthRequest.getD601_01();
		String d60102 = queryBirthRequest.getD601_02();
		String d60105 = queryBirthRequest.getD601_05();
		String d60155 = queryBirthRequest.getD601_55();
		
		StringBuffer sql = new StringBuffer("select * from v_d304 t where 1=1 and t.d304_32 ='" + d60101+"' " );
//		if(d60102 != null){
//		sql.append(" and t.d304_11 ='"+d60102+"' ");
//	}
//	if(d60105 != null){
//		sql.append(" and t.d304_16 ='"+d60105+"' ");
//	}
//	if(d60155 != null){
//		sql.append(" and t.d304_02 ='"+d60155+"' ");
//	}
		try{
			queryBirthResponse = new QueryBirthResponse();
			Session session = sessionFactory.getCurrentSession();
			SQLQuery queryd304 = session.createSQLQuery(sql.toString());
			int size = queryd304.list().size();
			if(size>0){
				queryBirthResponse.setErrorMessage("首发登记表已保存，不能删除！");
				return queryBirthResponse;
			}
			D601 d601 = new D601();
			d601.setD60101(d60101);
			session.delete(d601);
			queryBirthResponse.setPromptMessage("删除成功！");
		}catch(Exception e){
			queryBirthResponse.setErrorMessage("删除失败！");
			e.printStackTrace();
		}
		return queryBirthResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ZyfmdjbResponse pagerZyfmdjb(ZyfmdjbRequest zyfmdjbRequest) {
		String areaCode = zyfmdjbRequest.getAreaCode();
		String areaFlag = zyfmdjbRequest.getAreaFlag();
		String sexflag = zyfmdjbRequest.getSexFlag();
		String timeFlag = zyfmdjbRequest.getTimeFlag();
		String date_start = zyfmdjbRequest.getDate_start();
		String date_end = zyfmdjbRequest.getDate_end();
		int pageIndex = zyfmdjbRequest.getPageIndex();
		int pageSize = zyfmdjbRequest.getPageSize();
		String jiwei =zyfmdjbRequest.getJiwei();
		
		StringBuffer hql = new StringBuffer("");
		// 1按分娩日期统计，2按保存日期统计
		if("1".equals(timeFlag)){
			hql.append(" t.d60103_ >= to_date('"+ date_start +"','yyyy-MM-dd') and t.d60103_ <= to_date('"+ date_end +"','yyyy-MM-dd')");
		} else {
			hql.append(" t.d60160_ >= to_date('"+ date_start +"','yyyy-MM-dd') and t.d60160_ <= to_date('"+ date_end +"','yyyy-MM-dd')");
		}
		if(jiwei !=null && !"null".equals(jiwei) && !"".equals(jiwei)){
			hql.append(" and 1= " + jiwei + " ");
		}
		
		// 1按男方统计，2按女方统计
		if("1".equals(sexflag)){
			// 1按家庭地址统计，2按户口地址统计
			if("1".equals(areaFlag)){
				hql.append(" and t.d60197 like '" + areaCode + "%' ");
			} else {
				hql.append(" and t.d60198 like '" + areaCode + "%' ");
			}
		} else {
			if("1".equals(areaFlag)){
				hql.append(" and t.d60195 like '" + areaCode + "%' ");
			} else {
				hql.append(" and t.d60196 like '" + areaCode + "%' ");
			}
		}

		List<VD601> vd601s = null;
		ZyfmdjbResponse zyfmdjbResponse = new ZyfmdjbResponse();
		try {
			Session session = sessionFactory.getCurrentSession();
			Object rowCount = session.createQuery("select count(*) from VD601 t where 1=1 and " + hql.toString()).uniqueResult();
			
			zyfmdjbResponse.setRowCount(Long.valueOf(rowCount+""));
			vd601s = session.createQuery("from VD601 t where 1=1 and " + hql.toString() + "order by t.d60101")
								.setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
			zyfmdjbResponse.setVd601s(vd601s);
			if(vd601s.size() <= 0){
				zyfmdjbResponse.setPromptMessage("暂无数据！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			zyfmdjbResponse.setErrorMessage("查询失败！");
		}
		return zyfmdjbResponse;
	}
}