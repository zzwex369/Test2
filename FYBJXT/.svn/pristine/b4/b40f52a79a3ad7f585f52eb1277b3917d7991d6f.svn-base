package com.xyw.medical.birth.report.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.birth.model.VD601;
import com.xyw.medical.birth.model.VD601_DBF;
import com.xyw.medical.birth.model.VD602;

public class DeliveryRegistService {
	private DataSource dataSource;
	public List<VD601> queryVD601(String d601_57,String date_start,String date_end,String flag,ServletContext servletContext)
	{
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from v_d601 t where t.D601_57 like ? and t.d601_03_str >= ? and t.d601_03_str <= ? ");
		sql.append(" order by t.D601_03");
		List<VD601> listVD601 = null;
		VD601 vd601 = null;
		try{
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setString(1, "%"+d601_57+"%");
			preparedStatement.setString(2, date_start);
			preparedStatement.setString(3, date_end);
			resultSet = preparedStatement.executeQuery();
			listVD601 = new ArrayList<VD601>();
			DateFormat df = null;
			while(resultSet.next())
			{
				vd601 = new VD601();
				long d60101 = resultSet.getLong("D601_01");
				String d60102 = resultSet.getString("D601_02");
				Date d60103_d = resultSet.getTimestamp("D601_03");
				df = new SimpleDateFormat("yyyy-MM-dd");
				String d60103 = "";
				if(d60103_d != null){
					d60103 = df.format(d60103_d);
				}
				long d60104 = resultSet.getLong("D601_04");
				String d60105 = resultSet.getString("D601_05");
				String d60106 = resultSet.getString("D601_06");
				String d60107 = resultSet.getString("D601_07");
				String d60108 = resultSet.getString("D601_08");
				String d60109 = resultSet.getString("D601_09");
				String d60110 = resultSet.getString("D601_10");
				
				String d60111 = resultSet.getString("D601_11");
				
				Date d60112_d = resultSet.getDate("D601_12");
				String d60112 = "";
				if(d60112_d != null){
					d60112 = df.format(d60112_d);
				}
				
				Date d60113_d = resultSet.getDate("D601_13");
				String d60113 = "";
				if(d60113_d != null){
					d60113 = df.format(d60113_d);
				}
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
				
				df = new SimpleDateFormat("HH:mm:ss");
				String d60124 = "";
				if(d60103_d != null){
					d60124 = df.format(d60103_d);
				}
				
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
				
				df = new SimpleDateFormat("yyyy-MM-dd");
				Date d60160_d = resultSet.getDate("D601_60");
				String d60160 = "";
				if(d60160 != null){
					d60160 = df.format(d60160_d);
				}
				
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
				String d60138ZH = resultSet.getString("D601_38_ZH");
				String d60145ZH = resultSet.getString("D601_45_ZH");
				String d60146ZH = resultSet.getString("D601_46_ZH");
				String d60147ZH = resultSet.getString("D601_47_ZH");
				String d60148ZH = resultSet.getString("D601_48_ZH");
				String d60149ZH = resultSet.getString("D601_49_ZH");
				String d60151ZH = resultSet.getString("D601_51_ZH");
				String d60152ZH = resultSet.getString("D601_52_ZH");
				String d60166ZH = resultSet.getString("D601_66_ZH");
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
				
				vd601.setD60101(d60101);
				vd601.setD60102(d60102);
				vd601.setD60102ZH(d60102ZH);
				vd601.setD60103(d60103);
				vd601.setD60104(d60104);
				vd601.setD60105(d60105);
				vd601.setD60106(d60106);
				vd601.setD60106ZH(d60106ZH);
				vd601.setD60107(d60107);
				vd601.setD60108(d60108);
				vd601.setD60108ZH(d60108ZH);
				vd601.setD60109(d60109);
				vd601.setD60109ZH(d60109ZH);
				vd601.setD60110(d60110);
				vd601.setD60111(d60111);
				vd601.setD60111ZH(d60111ZH);
				vd601.setD60112(d60112);
				vd601.setD60113(d60113);
				vd601.setD60114(d60114);
				vd601.setD60115(d60115);
				vd601.setD60116(d60116);
				vd601.setD60117(d60117);
				vd601.setD60117ZH(d60117ZH);
				vd601.setD60118(d60118);
				vd601.setD60118ZH(d60118ZH);
				vd601.setD60119(d60119);
				vd601.setD60120(d60120);
				vd601.setD60121(d60121);
				vd601.setD60122(d60122);
				vd601.setD60123(d60123);
				vd601.setD60123ZH(d60123ZH);
				vd601.setD60124(d60124);
				vd601.setD60125(d60125);
				vd601.setD60125ZH(d60125ZH);
				vd601.setD60126(d60126);
				vd601.setD60126ZH(d60126ZH);
				vd601.setD60127(d60127);
				vd601.setD60128(d60128);
				vd601.setD60129(d60129);
				vd601.setD60130(d60130);
				vd601.setD60131(d60131);
				vd601.setD60132(d60132);
				vd601.setD60132ZH(d60132ZH);
				vd601.setD60133(d60133);
				vd601.setD60133ZH(d60133ZH);
				vd601.setD60134(d60134);
				vd601.setD60134ZH(d60134ZH);
				vd601.setD60135(d60135);
				vd601.setD60136(d60136);
				vd601.setD60137(d60137);
				vd601.setD60138(d60138);
				vd601.setD60138ZH(d60138ZH);
				vd601.setD60139(d60139);
				vd601.setD60140(d60140);
				vd601.setD60141(d60141);
				vd601.setD60142(d60142);
				vd601.setD60143(d60143);
				vd601.setD60144(d60144);
				vd601.setD60145(d60145);
				vd601.setD60145ZH(d60145ZH);
				vd601.setD60146(d60146);
				vd601.setD60146ZH(d60146ZH);
				vd601.setD60147(d60147);
				vd601.setD60147ZH(d60147ZH);
				vd601.setD60148(d60148);
				vd601.setD60148ZH(d60148ZH);
				vd601.setD60149(d60149);
				vd601.setD60149ZH(d60149ZH);
				vd601.setD60150(d60150);
				vd601.setD60151(d60151);
				vd601.setD60151ZH(d60151ZH);
				vd601.setD60152(d60152);
				vd601.setD60152ZH(d60152ZH);
				vd601.setD60153(d60153);
				vd601.setD60154(d60154);
				vd601.setD60155(d60155);
				vd601.setD60156(d60156);
				vd601.setD60157(d60157);
				vd601.setD60157ZH(d60157ZH);
				vd601.setD60158(d60158);
				vd601.setD60159(d60159);
				vd601.setD60160(d60160);
				vd601.setD60161(d60161);
				vd601.setD60162(d60162);
				vd601.setD60163(d60163);
				vd601.setD60164(d60164);
				vd601.setD60165(d60165);
				vd601.setD60166(d60166);
				vd601.setD60166ZH(d60166ZH);
				vd601.setD60167(d60167);
				vd601.setD60168ZH(d60168ZH);
				vd601.setD60168(d60168);
				vd601.setD60169(d60169);
				vd601.setD60170(d60170);
				vd601.setD60170ZH(d60170ZH);
				vd601.setD60171(d60171);
				vd601.setD60171ZH(d60171ZH);
				vd601.setD60172(d60172);
				vd601.setD60173(d60173);
				vd601.setD60174(d60174);
				vd601.setD60174ZH(d60174ZH);
				vd601.setD60175(d60175);
				vd601.setD60176(d60176);
				vd601.setD60177(d60177);
				vd601.setD60177ZH(d60177ZH);
				vd601.setD60178(d60178);
				vd601.setD60178ZH(d60178ZH);
				vd601.setD60179(d60179);
				vd601.setD60179ZH(d60179ZH);
				vd601.setD60180(d60180);
				vd601.setD60180ZH(d60180ZH);
				vd601.setD60181(d60181);
				vd601.setD60181ZH(d60181ZH);
				vd601.setD60182(d60182);
				vd601.setD60182ZH(d60182ZH);
				vd601.setD60183(d60183);
				vd601.setD60183ZH(d60183ZH);
				vd601.setD60184(d60184);
				vd601.setD60184ZH(d60184ZH);
				listVD601.add(vd601);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			this.close(connection, preparedStatement, resultSet);
		}
		return listVD601;
	}
	private void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
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
	public List<VD602> queryVD602(String d601_57, ServletContext servletContext)
	{
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from v_d602 t ");
		sql.append(" order by t.D602_01");
		List<VD602> listVD602 = null;
		VD602 vd602 = null;
		try{
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			resultSet = preparedStatement.executeQuery();
			listVD602 = new ArrayList<VD602>();
			while(resultSet.next())
			{
				long d60201 = resultSet.getLong("D602_01");
				String d60202 = resultSet.getString("D602_02");
				String d60203 = resultSet.getString("D602_03");
				String d60204 = resultSet.getString("D602_04");
				String d60205 = resultSet.getString("D602_05");
				String d60206 = resultSet.getString("D602_06");
				String d60207 = resultSet.getString("D602_07");
				String d60208 = resultSet.getString("D602_08");
				String d60209 = resultSet.getString("D602_09");
				String d60202ZH = resultSet.getString("D602_02_ZH");
				String d60204ZH = resultSet.getString("D602_04_ZH");
				String d60208ZH = resultSet.getString("D602_08_ZH");
				String d60209ZH = resultSet.getString("D602_09_ZH");
				
				vd602 = new VD602();
				vd602.setD60201(d60201);
				vd602.setD60202(d60202);
				vd602.setD60203(d60203);
				vd602.setD60204(d60204);
				vd602.setD60205(d60205);
				vd602.setD60206(d60206);
				vd602.setD60207(d60207);
				vd602.setD60208(d60208);
				vd602.setD60209(d60209);
				vd602.setD60202ZH(d60202ZH);
				vd602.setD60204ZH(d60204ZH);
				vd602.setD60208ZH(d60208ZH);
				vd602.setD60209ZH(d60209ZH);
				
				listVD602.add(vd602);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, resultSet);
		}
		return listVD602;
	}
	public List<Object> queryVD601(String d601_02, String date_start,
			String date_end, String flag, String report_per,
			String person_charge, String phone, ServletContext servletContext) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from v_d601_dbf t where t.D601_02 = ? and t.d601_03_str >= ? and t.d601_03_str <= ? ");
		sql.append(" order by t.D601_03");
		List<Object> listVD601 = null;
		VD601_DBF vd601 = null;
		try{
			connection = this.dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setString(1, d601_02);
			preparedStatement.setString(2, date_start);
			preparedStatement.setString(3, date_end);
			resultSet = preparedStatement.executeQuery();
			listVD601 = new ArrayList<Object>();
			DateFormat df = null;
			while(resultSet.next())
			{
				vd601 = new VD601_DBF();
				long d60101 = resultSet.getLong("D601_01");
				String d60102 = resultSet.getString("D601_02");
				String d60103 = resultSet.getString("D601_03_STR").replace("-", "");
				String d60104 = resultSet.getString("D601_04");
				String d60105 = resultSet.getString("D601_05");
				String d60106 = resultSet.getString("D601_06");
				String d60107 = resultSet.getString("D601_07");
				String d60109 = resultSet.getString("D601_09");
				String d60117 = resultSet.getString("D601_17");
				String d60119 = resultSet.getString("D601_19");
				String d60120 = resultSet.getString("D601_20");
				
				String d60121 = resultSet.getString("D601_21");
				String d60122 = resultSet.getString("D601_22");
				String d60140 = resultSet.getString("D601_40");
				String d60141 = resultSet.getString("D601_41");
				String d60142 = resultSet.getString("D601_42");
				String d60148 = resultSet.getString("D601_48");
				String d60165 = resultSet.getString("D601_65");
				String d60166 = resultSet.getString("D601_66");
				String d60167 = resultSet.getString("D601_67");
				String d60169 = resultSet.getString("D601_69");
				String d60170 = resultSet.getString("D601_70");
				
				String d60171 = resultSet.getString("D601_71");
				String d60185 = resultSet.getString("D601_85");
				String d60186 = resultSet.getString("D601_86");
				String d60192 = resultSet.getString("D601_92");
				String d601103 = resultSet.getString("D601_103");
				String d60151 = resultSet.getString("D601_51");
				
				String date_load =resultSet.getString("date_load"); 
				String d60140ZH = resultSet.getString("D601_40_ZH");
				String d60148ZH = resultSet.getString("D601_48_ZH");
				String d60126ZH = resultSet.getString("D601_26_ZH");
				String d60186ZH = resultSet.getString("D601_86_ZH");
				String d60109ZH = resultSet.getString("D601_09_ZH");
				String d60192ZH1 = resultSet.getString("D60192_ZHO");
				String d60192ZH2 = resultSet.getString("D60192_ZHT");
				String d60192ZH3 = resultSet.getString("D60192_ZHS");
				String d60166ZH1 = resultSet.getString("D60166_ZHO");
				String d60166ZH2 = resultSet.getString("D60166_ZHT");
				String d60166ZH3 = resultSet.getString("D60166_ZHS");
				String d60102_ZH = resultSet.getString("D60102_ZH");
				vd601.setUSERNAME(d60105);//产妇姓名      助产机构 d60102_ZH
	//			vd601.setUSERIDKEY("");
	//			vd601.setTBJGDM("");
				vd601.setJG_ZC("1");
				vd601.setCF_XM(d60105);//产妇姓名
				
		//		vd601.setCF_BH("");   //孕产妇健康档案编号
		//		vd601.setCF_JDSJ("");  //建档时间YYYYMMDD
				
				vd601.setCF_BAH(d60104);//病例号
				vd601.setCF_ZJLX(d60186ZH);//证件类型
				vd601.setCF_ZJHM(d60165);///证件号码（身份证号）
				if(d60165 !=null  && !"null".equals(d60165) && !"".equals(d60165)){
					if (d60165.length()<18) {
						vd601.setCF_CSRQ("");//出生日期yyyyMMdd
					}else {
						vd601.setCF_CSRQ(d60165.substring(6,14));//出生日期yyyyMMdd
					}
				}else{
					vd601.setCF_CSRQ("");
				}
				vd601.setCF_GJ(d60185);//国籍代码
				vd601.setCF_MZ(d60109ZH);//民族
				vd601.setCF_HJ_S(d60192ZH1);//产妇户口省 区 市所在地
				vd601.setCF_HJ_SD(d60192ZH2);//市 地 州 所在地
				vd601.setCF_HJ_XQ(d60192ZH3);//县
//				if ("".equals(d60192)) {
					vd601.setCF_HJ_QHDM("410000");
//				}else{
//					vd601.setCF_HJ_QHDM(d60192.substring(0,2)+"0000");//行政区划代码
//				}
				vd601.setCF_JZD_S(d60166ZH1);//居住地省 区 市所在地
				vd601.setCF_JZD_SD(d60166ZH2);//市 地 州 所在地
				vd601.setCF_JZD_XQ(d60166ZH3);//县
//				if ("".equals(d60166)) {
					vd601.setCF_JZ_QHDM("410000");//行政区划代码
//				}else {
//					vd601.setCF_JZ_QHDM(d60166.substring(0,2)+"0000");//行政区划代码
//				}
				vd601.setCF_YC(d60119);//孕次
				vd601.setCF_CC(d60120);//产次
				vd601.setCF_YFZC(d60121);//孕周
				if(d601103 ==null || "null".equals(d601103) || "".equals(d601103)){
					vd601.setCF_GWYS("2");//妊娠风险级别     是否高危妊娠d60117
				}else{
					vd601.setCF_GWYS(d601103);//妊娠风险级别     是否高危妊娠d60117
				}
				vd601.setCF_FMDD("1");//分娩地点
				vd601.setCF_FMFS(d60126ZH);//分娩方式
				vd601.setCF_FMRQ(d60103);//分娩日期
				
				if("1".equals(d60151)){
					vd601.setFMTS("1"); //妊娠结局本次为	
				}else if("2".equals(d60151) || "3".equals(d60151)){
					vd601.setFMTS("2"); //妊娠结局本次为	
				}else if("4".equals(d60151) || "5".equals(d60151)){
					vd601.setFMTS("3"); //妊娠结局本次为	
				}else{
					vd601.setFMTS("1"); //妊娠结局本次为
				}
				vd601.setFM_XB1(d60140ZH);//性别代码1
				vd601.setFM_RSJJ1(d60148ZH);//妊娠结局1
				vd601.setFM_PF1(d60141);//1分钟apgar
				vd601.setFM_XB2("");//d601_94
				vd601.setFM_RSJJ2("");//d601_95
				vd601.setFM_PF2("");//d601_96
				vd601.setFM_XB3("");//d601_86_ZH
				vd601.setFM_RSJJ3("");//d601_40_ZH
				vd601.setFM_PF3("");//d601_48_ZH
				vd601.setFM_XB4("");//d601_26_ZH
				vd601.setFM_RSJJ4("");//d601_92_ZH1
				vd601.setFM_PF4("");//d601_92_ZH2
				
				vd601.setJG_DWFZR(person_charge);///单位负责人
				vd601.setJG_TBR(report_per);//填表人
				vd601.setJG_LXDH(phone);//联系电话
				vd601.setJG_BCRQ(date_load);//报出日期
				listVD601.add(vd601);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}finally
		{
			this.close(connection, preparedStatement, resultSet);
		}
		return listVD601;
	}
}
