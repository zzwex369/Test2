package com.xyw.medical.birth.report.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.birth.model.VD401;
import com.xyw.medical.birth.report.model.DeliveryTemp;
import com.xyw.sys.util.StringUtil;

public class PerinatalService {
	
	private DataSource dataSource;
	
	private SessionFactory sessionFactory;
	
	public List<DeliveryTemp> queryDeliveryTemp(String timeStr,String flag,String year,String quarter,String monthStart,String monthEnd,String institutionType,String institution,ServletContext servletContext){
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.dataSource = (DataSource)webApplicationContext.getBean("dataSource");
		Connection connection = null;
		CallableStatement callableStatement = null;
		DeliveryTemp deliveryTemp =null;
		List<DeliveryTemp> listDeliveryTemp = null;
		try {
			connection = this.dataSource.getConnection();
			
			if(flag.equals("hcyc")){
				callableStatement = connection.prepareCall("{call delivery_area_package.infoByYear_area_procedure(?,?,?,?,?,?,?,?)}");
			}else if(flag.equals("wcjs") || flag.equals("fmtj")){
				callableStatement = connection.prepareCall("{call delivery_birth_package.infoByYear_birth_procedure(?,?,?,?,?,?,?,?)}");
			}else if(flag.equals("wcq")){
				callableStatement = connection.prepareCall("{call delivery_p_package.infoByYear_p_procedure(?,?,?,?,?,?,?,?)}");
			}else if(flag.equals("wcjg")){
				callableStatement = connection.prepareCall("{call delivery_package.infoByYear_procedure(?,?,?,?,?,?,?,?)}");
			}
			
			callableStatement.setString(1, year);
			callableStatement.setString(2, quarter);
			callableStatement.setString(3, monthStart);
			callableStatement.setString(4, monthEnd);
			callableStatement.setString(5, institutionType);
			callableStatement.setString(6, institution);
			callableStatement.setString(7, timeStr);
			callableStatement.registerOutParameter(8, OracleTypes.CURSOR);
			callableStatement.execute();
			
			ResultSet resultSet = (ResultSet)callableStatement.getObject(8);
			listDeliveryTemp = new ArrayList<DeliveryTemp>();
			while(resultSet.next()) {
				deliveryTemp=new DeliveryTemp();
				deliveryTemp.setT01(resultSet.getInt("t_01"));
				deliveryTemp.setT02(resultSet.getInt("t_02"));
				deliveryTemp.setT03(resultSet.getInt("t_03"));
				deliveryTemp.setT04(resultSet.getInt("t_04"));
				deliveryTemp.setT05(resultSet.getInt("t_05"));
				deliveryTemp.setT06(resultSet.getInt("t_06"));
				deliveryTemp.setT07(resultSet.getInt("t_07"));
				deliveryTemp.setT08(resultSet.getInt("t_08"));
				deliveryTemp.setT09(resultSet.getInt("t_09"));
				deliveryTemp.setT10(resultSet.getInt("t_10"));
				deliveryTemp.setT11(resultSet.getInt("t_11"));
				deliveryTemp.setT12(resultSet.getInt("t_12"));
				deliveryTemp.setT13(resultSet.getInt("t_13"));
				deliveryTemp.setT14(resultSet.getInt("t_14"));
				deliveryTemp.setT15(resultSet.getInt("t_15"));
				deliveryTemp.setT16(resultSet.getInt("t_16"));
				deliveryTemp.setT17(resultSet.getInt("t_17"));
				deliveryTemp.setT18(resultSet.getInt("t_18"));
				deliveryTemp.setT19(resultSet.getInt("t_19"));
				deliveryTemp.setT20(resultSet.getInt("t_20"));
				deliveryTemp.setT21(resultSet.getInt("t_21"));
				deliveryTemp.setT22(resultSet.getInt("t_22"));
				deliveryTemp.setT23(resultSet.getInt("t_23"));
				deliveryTemp.setT24(resultSet.getInt("t_24"));
				deliveryTemp.setT25(resultSet.getInt("t_25"));
				deliveryTemp.setT26(resultSet.getInt("t_26"));
				deliveryTemp.setT27(resultSet.getInt("t_27"));
				deliveryTemp.setT28(resultSet.getInt("t_28"));
				deliveryTemp.setT29(resultSet.getInt("t_29"));
				deliveryTemp.setT30(resultSet.getInt("t_30"));
				deliveryTemp.setT31(resultSet.getInt("t_31"));
				deliveryTemp.setT32(resultSet.getInt("t_32"));
				deliveryTemp.setT33(resultSet.getInt("t_33"));
				deliveryTemp.setT34(resultSet.getInt("t_34"));
				deliveryTemp.setT35(resultSet.getInt("t_35"));
				deliveryTemp.setT36(resultSet.getInt("t_36"));
				deliveryTemp.setT37(resultSet.getInt("t_37"));
				deliveryTemp.setT38(resultSet.getInt("t_38"));
				deliveryTemp.setT39(resultSet.getInt("t_39"));
				deliveryTemp.setT40(resultSet.getInt("t_40"));
				deliveryTemp.setT41(resultSet.getInt("t_41"));
				deliveryTemp.setT42(resultSet.getInt("t_42"));
				deliveryTemp.setT43(resultSet.getInt("t_43"));
				deliveryTemp.setT44(resultSet.getInt("t_44"));
				deliveryTemp.setT45(resultSet.getInt("t_45"));
				deliveryTemp.setT46(resultSet.getInt("t_46"));
				deliveryTemp.setT47(resultSet.getInt("t_47"));
				deliveryTemp.setT48(resultSet.getInt("t_48"));
				deliveryTemp.setT49(resultSet.getInt("t_49"));
				deliveryTemp.setT50(resultSet.getInt("t_50"));
				deliveryTemp.setT51(resultSet.getInt("t_51"));
				deliveryTemp.setT52(resultSet.getInt("t_52"));
				deliveryTemp.setT53(resultSet.getInt("t_53"));
				deliveryTemp.setT54(resultSet.getInt("t_54"));
				deliveryTemp.setT55(resultSet.getInt("t_55"));
				deliveryTemp.setT56(resultSet.getInt("t_56"));
				deliveryTemp.setT57(resultSet.getInt("t_57"));
				deliveryTemp.setT58(resultSet.getInt("t_58"));
				deliveryTemp.setT59(resultSet.getInt("t_59"));
				deliveryTemp.setT60(resultSet.getInt("t_60"));
				deliveryTemp.setT61(resultSet.getInt("t_61"));
				deliveryTemp.setT62(resultSet.getString("t_62"));
				deliveryTemp.setT63(resultSet.getString("t_63"));
				deliveryTemp.setT64(resultSet.getString("t_64"));
				deliveryTemp.setT65(resultSet.getInt("t_65"));
				deliveryTemp.setT66(resultSet.getInt("t_66"));
				deliveryTemp.setT67(resultSet.getInt("t_67"));
				deliveryTemp.setT68(resultSet.getInt("t_68"));
				deliveryTemp.setYear(resultSet.getString("year"));
				deliveryTemp.setInstitution(resultSet.getString("institution"));
				deliveryTemp.setInstitonZh(resultSet.getString("institutionzh"));
				deliveryTemp.setSe(resultSet.getInt("se"));
				
				listDeliveryTemp.add(deliveryTemp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(callableStatement != null) {
					callableStatement.close();
					callableStatement = null;
				}
				if(connection != null) {
					connection.close();
					connection = null;
				}
			} catch(Exception e) {
				
			}
		}
		return listDeliveryTemp;
	}
    public DeliveryTemp total(List<DeliveryTemp> list){  	
    	int t05 =0;//产妇年龄<20
		int t06 =0;//产妇年龄20～
		int t07 =0;//产妇年龄25～   
		int t08 =0;//产妇年龄30～
		int t09 =0;//产妇年龄35～
		int t10 =0;//城镇-男<20数
		int t11 =0;//城镇-女<20数
		int t12 =0;//城镇-不明<20数
		int t13 =0;//乡村-男<20数
		int t14 =0;//乡村-女<20数
		int t15 =0;//乡村-不明<20数
		int t16 =0;//城镇-男20～数
		int t17 =0;//城镇-女20～数
		int t18 =0;//城镇-不明20～数
		int t19 =0;//乡村-男20～数
		int t20 =0;//乡村-女20～数
		int t21 =0;//乡村-不明20～数
		int t22 =0;//城镇-男25～数
		int t23 =0;//城镇-女25～数
		int t24 =0;//城镇-不明25～数
		int t25 =0;//乡村-男25～数
		int t26 =0;//乡村-女25～数
		int t27 =0;//乡村-不明25～数
		int t28 =0;//城镇-男30～数
		int t29 =0;//城镇-女30～数
		int t30 =0;//城镇-不明30～数
		int t31 =0;//乡村-男30～数
		int t32 =0;//乡村-女30～数
		int t33 =0;//乡村-不明30～数
		int t34 =0;//城镇-男35～数
		int t35 =0;//城镇-女35～数
		int t36 =0;//城镇-不明35～数
		int t37 =0;//乡村-男35～数
		int t38 =0;//乡村-女35～数
		int t39 =0;//乡村-不明35～数
		int t40 =0;//合计产妇<20围产儿总数
		int t41 =0;//合计产妇20～围产儿数
		int t42 =0;//合计产妇25～围产儿数
		int t43 =0;//合计产妇30～围产儿数
		int t44 =0;//合计产妇35～围产儿数
		int t45 =0;//合计城镇男围产儿数
		int t46 =0;//合计城镇女围产儿数
		int t47 =0;//合计城镇性别不明围产儿数
		int t48 =0;//合计乡村男围产儿数
		int t49 =0;//合计乡村女围产儿数
		int t50 =0;//合计乡村性别不明围产儿数
		int t51 =0;//城镇出生缺陷儿总数
		int t52 =0;//乡村出生缺陷儿总数
		int t53 =0;//城镇死胎死产总数
		int t54 =0;//乡村死胎死产总数
		int t55 =0;//城镇7天内死亡总数
		int t56 =0;//乡村7天内死亡总数
		int t57 =0;//城镇缺陷、围产儿死亡总数(死产死胎 七天内死亡)
		int t58 =0;//乡村缺陷、围产儿死亡总数(死产死胎 七天内死亡)
		int t59 =0;//双胎总数(产妇数)
		int t60 =0;//三胎及以上总数(产妇数)
		int t61 =0;//单胎数(产妇数)
		
	    int t65 =0;
		int t66 =0;
		int t67 =0;
		int t68 =0;
		
    	DeliveryTemp deliveryTemp =new DeliveryTemp();
    	DeliveryTemp temp =new DeliveryTemp();
    	for(int l=0;l<list.size();l++){
    		deliveryTemp=(DeliveryTemp)list.get(l);
			
			t05 +=deliveryTemp.getT05();
			t06 +=deliveryTemp.getT06();
			t07 +=deliveryTemp.getT07();   
			t08 +=deliveryTemp.getT08();
			t09 +=deliveryTemp.getT09();
			t10 +=deliveryTemp.getT10();
			t11 +=deliveryTemp.getT11();
			t12 +=deliveryTemp.getT12();
			t13 +=deliveryTemp.getT13();
			t14 +=deliveryTemp.getT14();
			t15 +=deliveryTemp.getT15();
			t16 +=deliveryTemp.getT16();
			t17 +=deliveryTemp.getT17();
			t18 +=deliveryTemp.getT18();
			t19 +=deliveryTemp.getT19();
			t20 +=deliveryTemp.getT20();
			t21 +=deliveryTemp.getT21();
			t22 +=deliveryTemp.getT22();
			t23 +=deliveryTemp.getT23();
			t24 +=deliveryTemp.getT24();
			t25 +=deliveryTemp.getT25();
			t26 +=deliveryTemp.getT26();
			t27 +=deliveryTemp.getT27();
			t28 +=deliveryTemp.getT28();
			t29 +=deliveryTemp.getT29();
		    t30 +=deliveryTemp.getT30();
			t31 +=deliveryTemp.getT31();
			t32 +=deliveryTemp.getT32();
			t33 +=deliveryTemp.getT33();
			t34 +=deliveryTemp.getT34();
			t35 +=deliveryTemp.getT35();
			t36 +=deliveryTemp.getT36();
			t37 +=deliveryTemp.getT37();
			t38 +=deliveryTemp.getT38();
			t39 +=deliveryTemp.getT39();
			t40 +=deliveryTemp.getT40();
			t41 +=deliveryTemp.getT41();
			t42 +=deliveryTemp.getT42();
			t43 +=deliveryTemp.getT43();
			t44 +=deliveryTemp.getT44();
			t45 +=deliveryTemp.getT45();
			t46 +=deliveryTemp.getT46();
			t47 +=deliveryTemp.getT47();
			t48 +=deliveryTemp.getT48();
			t49 +=deliveryTemp.getT49();
			t50 +=deliveryTemp.getT50();
			t51 +=deliveryTemp.getT51();
			t52 +=deliveryTemp.getT52();
			t53 +=deliveryTemp.getT53();
			t54 +=deliveryTemp.getT54();
			t55 +=deliveryTemp.getT55();
			t56 +=deliveryTemp.getT56();
			t57 +=deliveryTemp.getT57();
			t58 +=deliveryTemp.getT58();
			t59 +=deliveryTemp.getT59();
			t60 +=deliveryTemp.getT60();
			t61 +=deliveryTemp.getT61();
			
			t65 +=deliveryTemp.getT65();
			t66 +=deliveryTemp.getT66();
			t67 +=deliveryTemp.getT67();
			t68 +=deliveryTemp.getT68();
		}
    	
    	temp.setT05(t05);
    	temp.setT06(t06);
    	temp.setT07(t07);
    	temp.setT08(t08);
    	temp.setT09(t09);
    	temp.setT10(t10);
    	temp.setT11(t11);
    	temp.setT12(t12);
    	temp.setT13(t13);
    	temp.setT14(t14);
    	temp.setT15(t15);
    	temp.setT16(t16);
    	temp.setT17(t17);
    	temp.setT18(t18);
    	temp.setT19(t19);
    	temp.setT20(t20);
    	temp.setT21(t21);
    	temp.setT22(t22);
    	temp.setT23(t23);
    	temp.setT24(t24);
    	temp.setT25(t25);
    	temp.setT26(t26);
    	temp.setT27(t27);
    	temp.setT28(t28);
    	temp.setT29(t29);
		temp.setT30(t30);
		temp.setT31(t31);
		temp.setT32(t32);
		temp.setT33(t33);
		temp.setT34(t34);
		temp.setT35(t35);
		temp.setT36(t36);
		temp.setT37(t37);
		temp.setT38(t38);
		temp.setT39(t39);
		temp.setT40(t40);
		temp.setT41(t41);
		temp.setT42(t42);
		temp.setT43(t43);
		temp.setT44(t44);
		temp.setT45(t45);
		temp.setT46(t46);
		temp.setT47(t47);
		temp.setT48(t48);
		temp.setT49(t49);
		temp.setT50(t50);
		temp.setT51(t51);
		temp.setT52(t52);
		temp.setT53(t53);
		temp.setT54(t54);
		temp.setT55(t55);
		temp.setT56(t56);
		temp.setT57(t57);
		temp.setT58(t58);
		temp.setT59(t59);
		temp.setT60(t60);
		temp.setT61(t61);
    	
		temp.setT65(t65);
		temp.setT66(t66);
		temp.setT67(t67);
		temp.setT68(t68);
		
    	return temp;
    }
	public String getInstitutionName(String institution, String institutionType, ServletContext servletContext){
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.sessionFactory = (SessionFactory)webApplicationContext.getBean("sessionFactory");
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			SQLQuery sqlQuery = null;
			String institutionName = null;
			
			sqlQuery = session.createSQLQuery("select t.D101_02 from D101 t where t.d101_01 = ?");
			sqlQuery.setString(0, institution);
			institutionName = (String) sqlQuery.uniqueResult();
			return institutionName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getAreaName(String institution, ServletContext servletContext){
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.sessionFactory = (SessionFactory)webApplicationContext.getBean("sessionFactory");
		
		String areaName = null;
		Session session = null;
		SQLQuery sqlQuery = null;
		try {
			session = this.sessionFactory.openSession();
			
			sqlQuery = session.createSQLQuery("select t.D201_05 from D201 t where t.d201_01 = (select t1.D101_04 from D101 t1 where t1.D101_01 = ?)");
			sqlQuery.setString(0, institution);
			areaName = (String) sqlQuery.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return areaName;
	}
	
	@SuppressWarnings("unused")
	public List<DeliveryTemp> queryDeliveryTempNew(String timeStr,String flag,String year,String quarter,String monthStart,String monthEnd,String institutionType,String institution,ServletContext servletContext){
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.sessionFactory = (SessionFactory)webApplicationContext.getBean("sessionFactory");
		Session session = null;
		int state=0;
		
		String areaCode =null;
		String month =null;
		Map<String, List<DeliveryTemp>> mapList= new HashMap<String, List<DeliveryTemp>>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<DeliveryTemp> tempList =null; new ArrayList<DeliveryTemp>();
		List<Integer> monthList = new ArrayList<Integer>();
		try {
		    if(!StringUtil.isBlankString(quarter) && !quarter.equals("null")){  //季度为空,月份查询
		    	int q =Integer.parseInt(quarter);
		    	for(int k=((q*3-2));k <(q*3+1);k++){
		    		monthList.add(k);
		    	}
		    	state =1;
		    }else{
		    	if(monthStart.equals(monthEnd)){  //月份
					month =monthStart;
					state =0;
				}else{
					int m =Integer.parseInt(monthEnd);
					for(int i=Integer.parseInt(monthStart);i<(m+1);i++){
						monthList.add(i);
					}
					state =1;
				}
		    }
		    session =this.sessionFactory.openSession();
		    if(flag.equals("hcyc")){
		    	tempList =new ArrayList<DeliveryTemp>();
		    	if(state ==0){
					tempList=getAreaTemp(timeStr,flag,year,month,quarter,institutionType,institution,session);
				}else if(state ==1){
					List<DeliveryTemp> tempListD = new ArrayList<DeliveryTemp>();
					for(int i=0;i<monthList.size();i++){
						month =(monthList.get(i)).toString();
						tempListD = null;
						tempListD=getAreaTemp(timeStr,flag,year,month,quarter,institutionType,institution,session);
						if(tempListD.size() >0){
							for(int j=0;j < tempListD.size();j++){
								DeliveryTemp tempD =(DeliveryTemp) tempListD.get(j);
								if(tempD !=null){
									tempD.setSe(j);
									tempList.add(tempD);
								}
							}
						}
					}
				}
			}else if(flag.equals("wcjs") || flag.equals("fmtj")){
				tempList =new ArrayList<DeliveryTemp>();
		    	if(state ==0){
					tempList=getBirthTemp(timeStr,flag,year,month,quarter,institutionType,institution,session);
				}else if(state ==1){
					List<DeliveryTemp> tempListD = new ArrayList<DeliveryTemp>();
					for(int i=0;i<monthList.size();i++){
						month =(monthList.get(i)).toString();
						tempListD= null;					
						tempListD=getBirthTemp(timeStr,flag,year,month,quarter,institutionType,institution,session);
						if(tempListD.size() >0){
							for(int j=0;j < tempListD.size();j++){
								DeliveryTemp tempD =(DeliveryTemp) tempListD.get(j);
								if(tempD !=null){
									tempD.setSe(j);
									tempList.add(tempD);
								}
							}
						}
					}
				}
			//	callableStatement = connection.prepareCall("{call delivery_birth_package.infoByYear_birth_procedure(?,?,?,?,?,?,?,?)}");
			}else if(flag.equals("wcq")){
				tempList =new ArrayList<DeliveryTemp>();
		    	if(state ==0){
					tempList=getDeliveryTemp(timeStr,flag,year,month,quarter,institutionType,institution,session);
				}else if(state ==1){
					List<DeliveryTemp> tempListD = new ArrayList<DeliveryTemp>();
					for(int i=0;i<monthList.size();i++){
						month =(monthList.get(i)).toString();
						tempListD = null;
						tempListD=getDeliveryTemp(timeStr,flag,year,month,quarter,institutionType,institution,session);
		System.out.println(tempListD.size());
						if(tempListD.size() >0){
							for(int j=0;j < tempListD.size();j++){
								DeliveryTemp tempD =(DeliveryTemp) tempListD.get(j);
	 System.out.println(tempD.getInstitonZh());
								if(tempD !=null){
									tempD.setSe(j);
									tempList.add(tempD);
								}
							}
						}
					}
				}
			}else if(flag.equals("wcjg")){
				tempList =new ArrayList<DeliveryTemp>();
				institutionType ="8";
		    	if(state ==0){
					tempList=getDeliveryTemp(timeStr,flag,year,month,quarter,institutionType,institution,session);
				}else if(state ==1){
					List<DeliveryTemp> tempListD = new ArrayList<DeliveryTemp>();
					for(int i=0;i<monthList.size();i++){
						month =(monthList.get(i)).toString();
						tempListD =null;
						tempListD=getDeliveryTemp(timeStr,flag,year,month,quarter,institutionType,institution,session);
						if(tempListD.size() >0){
							for(int j=0;j < tempListD.size();j++){
								DeliveryTemp tempD =(DeliveryTemp) tempListD.get(j);
								if(tempD !=null){
									tempD.setSe(j);
									tempList.add(tempD);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session.isConnected()){
				System.out.println("关闭会话！");
				session.close();
			}else{
				System.out.println("会话已经关闭！");
			}
		}
		return tempList;
	}
	
	@SuppressWarnings("unchecked")
	private List<Object> getListCount(StringBuffer sb,String timeStr,String flag,String year,String month,String quarter,String areaCode,String institutionType,String institution,Session session){		
		if("8".equals(institutionType)){//单独一个医疗机构
			sb.append(" and t.d601_02 = '");
			sb.append(institution);
			sb.append("'");
		}else{ //上级查下级
			sb.append(" and (d.d101_11 = '");
			sb.append(institution);
			sb.append("' or d.d101_01 = '");
			sb.append(institution);
			sb.append("')");
		}
		if(timeStr.equals("deliveryTime")){  //分娩时间查询
			if(!StringUtil.isBlankString(year)){
				sb.append(" and extract(year from t.d601_03) = '"+year+"' ");
			}
			if(!StringUtil.isBlankString(month)){
				sb.append(" and extract(month from t.d601_03) = '"+month+"' ");
			}
		}else if(timeStr.equals("systemTime")){  //录入时间查询
			if(!StringUtil.isBlankString(year)){
				sb.append(" and extract(year from t.d601_60) = '"+year+"' ");
			}
			if(!StringUtil.isBlankString(month)){
				sb.append(" and extract(month from t.d601_60) = '"+month+"' ");
			}
		}
		if(!StringUtil.isBlankString(areaCode)){
			sb.append(" and t.d601_66 like '"+areaCode+"%' ");
		}
		sb.append(" and t.d601_02 =d.d101_01 group by d.d101_02 ");
System.out.println(sb.toString());
		SQLQuery sqlQuery = session.createSQLQuery(sb.toString());
		List<Object> listObj = sqlQuery.list();
		
		return listObj;
	}
	private List<DeliveryTemp> getAreaTemp(String timeStr,String flag,String year,String month,String quarter,String institutionType,String institution,Session session){
		Map<String, Object> map = new HashMap<String, Object>();
		List<DeliveryTemp> tempList = new ArrayList<DeliveryTemp>();
		
		StringBuffer sb = new StringBuffer("select d.d101_02,count(*)  as 总数, " + 
				"nvl(sum (case when t.d601_40 ='1' then 1 else 0 end),0) as 男, " +    
				"nvl(sum (case when t.d601_40 ='2' then 1 else 0 end),0) as 女, " +      
				"nvl(sum (case when t.d601_40 in ('3','4') then 1 else 0 end),0) as 不明  " +       
				"from D601 t ,d101 d where 1 = 1 and t.d601_48 not in ('2','3') ");
		String areaCode ="";
		StringBuffer sb0 =new StringBuffer(sb.toString());
		List<Object> listTotal =getListCount(sb0,timeStr,flag,year,month,quarter,areaCode,institutionType,institution,session);
		for (int i = 0; i < listTotal.size(); i++) {
			DeliveryTemp temp = new DeliveryTemp();
			Object[] obj = (Object[]) listTotal.get(i);
			temp.setInstitonZh((String) obj[0]);   //机构名称
			temp.setT02(Integer.valueOf(year));
			if(!StringUtil.isBlankString(quarter) && !quarter.equals("null")){
				temp.setT03(Integer.valueOf(quarter));
			}
			temp.setT04(Integer.valueOf(month));
			temp.setT08(Integer.valueOf(obj[1] + ""));
			temp.setT09(Integer.valueOf(obj[2] + ""));
			temp.setT10(Integer.valueOf(obj[3] + ""));
			temp.setT11(Integer.valueOf(obj[4] + ""));
            temp.setSe(i);
            
			map.put((String) obj[0], temp);
		}
		//梁园区
		areaCode="411402";
		sb0 =new StringBuffer(sb.toString());
		List<Object> list01 =getListCount(sb0,timeStr,flag,year,month,quarter,areaCode,institutionType,institution,session);
		for (int i = 0; i < list01.size(); i++) {
			DeliveryTemp temp = new DeliveryTemp();
			Object[] obj = (Object[]) list01.get(i);
			String institonZh =(String) obj[0];
			if(map.containsKey(institonZh)){
				temp.setT15(Integer.valueOf(obj[1] + ""));
				temp.setT16(Integer.valueOf(obj[2] + ""));
				temp.setT17(Integer.valueOf(obj[3] + ""));
				temp.setT18(Integer.valueOf(obj[4] + ""));
			}else{
				temp.setInstitonZh(institonZh);   //机构名称
				temp.setT15(Integer.valueOf(obj[1] + ""));
				temp.setT16(Integer.valueOf(obj[2] + ""));
				temp.setT17(Integer.valueOf(obj[3] + ""));
				temp.setT18(Integer.valueOf(obj[4] + ""));
			}
			map.put(institonZh, temp);
		}
		//宁陵县
		areaCode="411423";
		sb0 =new StringBuffer(sb.toString());
		List<Object> list02 =getListCount(sb0,timeStr,flag,year,month,quarter,areaCode,institutionType,institution,session);
		for (int i = 0; i < list02.size(); i++) {
			DeliveryTemp temp = new DeliveryTemp();
			Object[] obj = (Object[]) list02.get(i);
			String institonZh =(String) obj[0];
			if(map.containsKey(institonZh)){
				temp.setT19(Integer.valueOf(obj[1] + ""));
				temp.setT20(Integer.valueOf(obj[2] + ""));
				temp.setT21(Integer.valueOf(obj[3] + ""));
				temp.setT22(Integer.valueOf(obj[4] + ""));
			}else{
				temp.setInstitonZh(institonZh);   //机构名称
				temp.setT19(Integer.valueOf(obj[1] + ""));
				temp.setT20(Integer.valueOf(obj[2] + ""));
				temp.setT21(Integer.valueOf(obj[3] + ""));
				temp.setT22(Integer.valueOf(obj[4] + ""));
			}
			map.put(institonZh, temp);
		}
		//睢阳区
		areaCode="411403";
		sb0 =new StringBuffer(sb.toString());
		List<Object> list03 =getListCount(sb0,timeStr,flag,year,month,quarter,areaCode,institutionType,institution,session);
		for (int i = 0; i < list03.size(); i++) {
			DeliveryTemp temp = new DeliveryTemp();
			Object[] obj = (Object[]) list03.get(i);
			String institonZh =(String) obj[0];
			if(map.containsKey(institonZh)){
				temp.setT23(Integer.valueOf(obj[1] + ""));
				temp.setT24(Integer.valueOf(obj[2] + ""));
				temp.setT25(Integer.valueOf(obj[3] + ""));
				temp.setT26(Integer.valueOf(obj[4] + ""));
			}else{
				temp.setInstitonZh(institonZh);   //机构名称
				temp.setT23(Integer.valueOf(obj[1] + ""));
				temp.setT24(Integer.valueOf(obj[2] + ""));
				temp.setT25(Integer.valueOf(obj[3] + ""));
				temp.setT26(Integer.valueOf(obj[4] + ""));
			}
			map.put(institonZh, temp);
		}
		//民权县
		areaCode="411421";
		sb0 =new StringBuffer(sb.toString());
		List<Object> list04 =getListCount(sb0,timeStr,flag,year,month,quarter,areaCode,institutionType,institution,session);
		for (int i = 0; i < list04.size(); i++) {
			DeliveryTemp temp = new DeliveryTemp();
			Object[] obj = (Object[]) list04.get(i);
			String institonZh =(String) obj[0];
			if(map.containsKey(institonZh)){
				temp.setT27(Integer.valueOf(obj[1] + ""));
				temp.setT28(Integer.valueOf(obj[2] + ""));
				temp.setT29(Integer.valueOf(obj[3] + ""));
				temp.setT30(Integer.valueOf(obj[4] + ""));
			}else{
				temp.setInstitonZh(institonZh);   //机构名称
				temp.setT27(Integer.valueOf(obj[1] + ""));
				temp.setT28(Integer.valueOf(obj[2] + ""));
				temp.setT29(Integer.valueOf(obj[3] + ""));
				temp.setT30(Integer.valueOf(obj[4] + ""));
			}
			map.put(institonZh, temp);
		}
		//睢县
		areaCode="411422";
		sb0 =new StringBuffer(sb.toString());
		List<Object> list05 =getListCount(sb0,timeStr,flag,year,month,quarter,areaCode,institutionType,institution,session);
		for (int i = 0; i < list05.size(); i++) {
			DeliveryTemp temp = new DeliveryTemp();
			Object[] obj = (Object[]) list05.get(i);
			String institonZh =(String) obj[0];
			if(map.containsKey(institonZh)){
				temp.setT31(Integer.valueOf(obj[1] + ""));
				temp.setT32(Integer.valueOf(obj[2] + ""));
				temp.setT33(Integer.valueOf(obj[3] + ""));
				temp.setT34(Integer.valueOf(obj[4] + ""));
			}else{
				temp.setInstitonZh(institonZh);   //机构名称
				temp.setT31(Integer.valueOf(obj[1] + ""));
				temp.setT32(Integer.valueOf(obj[2] + ""));
				temp.setT33(Integer.valueOf(obj[3] + ""));
				temp.setT34(Integer.valueOf(obj[4] + ""));
			}
			map.put(institonZh, temp);
		}
		//柘城县
		areaCode="411424";
		sb0 =new StringBuffer(sb.toString());
		List<Object> list06 =getListCount(sb0,timeStr,flag,year,month,quarter,areaCode,institutionType,institution,session);
		for (int i = 0; i < list06.size(); i++) {
			DeliveryTemp temp = new DeliveryTemp();
			Object[] obj = (Object[]) list06.get(i);
			String institonZh =(String) obj[0];
			if(map.containsKey(institonZh)){
				temp.setT35(Integer.valueOf(obj[1] + ""));
				temp.setT36(Integer.valueOf(obj[2] + ""));
				temp.setT37(Integer.valueOf(obj[3] + ""));
				temp.setT38(Integer.valueOf(obj[4] + ""));
			}else{
				temp.setInstitonZh(institonZh);   //机构名称
				temp.setT35(Integer.valueOf(obj[1] + ""));
				temp.setT36(Integer.valueOf(obj[2] + ""));
				temp.setT37(Integer.valueOf(obj[3] + ""));
				temp.setT38(Integer.valueOf(obj[4] + ""));
			}
			map.put(institonZh, temp);
		}
		//虞城县
		areaCode="411425";
		sb0 =new StringBuffer(sb.toString());
		List<Object> list07 =getListCount(sb0,timeStr,flag,year,month,quarter,areaCode,institutionType,institution,session);
		for (int i = 0; i < list07.size(); i++) {
			DeliveryTemp temp = new DeliveryTemp();
			Object[] obj = (Object[]) list07.get(i);
			String institonZh =(String) obj[0];
			if(map.containsKey(institonZh)){
				temp.setT39(Integer.valueOf(obj[1] + ""));
				temp.setT40(Integer.valueOf(obj[2] + ""));
				temp.setT41(Integer.valueOf(obj[3] + ""));
				temp.setT42(Integer.valueOf(obj[4] + ""));
			}else{
				temp.setInstitonZh(institonZh);   //机构名称
				temp.setT39(Integer.valueOf(obj[1] + ""));
				temp.setT40(Integer.valueOf(obj[2] + ""));
				temp.setT41(Integer.valueOf(obj[3] + ""));
				temp.setT42(Integer.valueOf(obj[4] + ""));
			}
			map.put(institonZh, temp);
		}
		//夏邑县
		areaCode="411426";
		sb0 =new StringBuffer(sb.toString());
		List<Object> list08 =getListCount(sb0,timeStr,flag,year,month,quarter,areaCode,institutionType,institution,session);
		for (int i = 0; i < list08.size(); i++) {
			DeliveryTemp temp = new DeliveryTemp();
			Object[] obj = (Object[]) list08.get(i);
			String institonZh =(String) obj[0];
			if(map.containsKey(institonZh)){
				temp.setT43(Integer.valueOf(obj[1] + ""));
				temp.setT44(Integer.valueOf(obj[2] + ""));
				temp.setT45(Integer.valueOf(obj[3] + ""));
				temp.setT46(Integer.valueOf(obj[4] + ""));
			}else{
				temp.setInstitonZh(institonZh);   //机构名称
				temp.setT43(Integer.valueOf(obj[1] + ""));
				temp.setT44(Integer.valueOf(obj[2] + ""));
				temp.setT45(Integer.valueOf(obj[3] + ""));
				temp.setT46(Integer.valueOf(obj[4] + ""));
			}
			map.put(institonZh, temp);
		}
		//永城
		areaCode="411481";
		sb0 =new StringBuffer(sb.toString());
		List<Object> list09 =getListCount(sb0,timeStr,flag,year,month,quarter,areaCode,institutionType,institution,session);
		for (int i = 0; i < list09.size(); i++) {
			DeliveryTemp temp = new DeliveryTemp();
			Object[] obj = (Object[]) list09.get(i);
			String institonZh =(String) obj[0];
			if(map.containsKey(institonZh)){
				temp.setT47(Integer.valueOf(obj[1] + ""));
				temp.setT48(Integer.valueOf(obj[2] + ""));
				temp.setT49(Integer.valueOf(obj[3] + ""));
				temp.setT50(Integer.valueOf(obj[4] + ""));
			}else{
				temp.setInstitonZh(institonZh);   //机构名称
				temp.setT47(Integer.valueOf(obj[1] + ""));
				temp.setT48(Integer.valueOf(obj[2] + ""));
				temp.setT49(Integer.valueOf(obj[3] + ""));
				temp.setT50(Integer.valueOf(obj[4] + ""));
			}
			map.put(institonZh, temp);
		}
		//其他 市辖区
		areaCode="411401";
		sb0 =new StringBuffer(sb.toString());
		List<Object> list10 =getListCount(sb0,timeStr,flag,year,month,quarter,areaCode,institutionType,institution,session);
		for (int i = 0; i < list10.size(); i++) {
			DeliveryTemp temp = new DeliveryTemp();
			Object[] obj = (Object[]) list10.get(i);
			String institonZh =(String) obj[0];
			if(map.containsKey(institonZh)){
				temp.setT51(Integer.valueOf(obj[1] + ""));
				temp.setT52(Integer.valueOf(obj[2] + ""));
				temp.setT53(Integer.valueOf(obj[3] + ""));
				temp.setT54(Integer.valueOf(obj[4] + ""));
			}else{
				temp.setInstitonZh(institonZh);   //机构名称
				temp.setT51(Integer.valueOf(obj[1] + ""));
				temp.setT52(Integer.valueOf(obj[2] + ""));
				temp.setT53(Integer.valueOf(obj[3] + ""));
				temp.setT54(Integer.valueOf(obj[4] + ""));
			}
			map.put(institonZh, temp);
		}
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			DeliveryTemp temp = new DeliveryTemp();
			temp =(DeliveryTemp) entry.getValue();
			tempList.add(temp);
		}
		return tempList;
	}
	
	private List<DeliveryTemp> getBirthTemp(String timeStr,String flag,String year,String month,String quarter,String institutionType,String institution,Session session){
		Map<String, Object> map = new HashMap<String, Object>();
		List<DeliveryTemp> tempList = new ArrayList<DeliveryTemp>();
		
		StringBuffer sb = new StringBuffer("select d.d101_02, " + 
				"nvl(sum (case when t.d601_68 !='1' then 1 else 0 end),0) as 无生育证产妇数, " +     
				"nvl(sum (case when t.d601_68 ='1' then 1 else 0 end),0) as 有生育证产妇数, " +      
				"nvl(sum (case when t.d601_48 not in ('2','3') then 1 else 0 end),0) as 活产总数, " + 
				"nvl(sum (case when t.d601_48 not in ('2','3') and t.d601_40 ='1' then 1 else 0 end),0) as 活产男, " + 
				"nvl(sum (case when t.d601_48 not in ('2','3') and t.d601_40 ='2' then 1 else 0 end),0) as 活产女, " + 
				"nvl(sum (case when t.d601_48 not in ('2','3') and t.d601_40 in ('3','4') then 1 else 0 end),0) as 活产不明 , " + 
				"nvl(sum (case when t.d601_48 in ('2','3') then 1 else 0 end),0) as 死胎死产总数, " + 
				"nvl(sum (case when t.d601_48 in ('2','3') and t.d601_40 ='1' then 1 else 0 end),0) as 男死胎死产总数, " + 
				"nvl(sum (case when t.d601_48 in ('2','3') and t.d601_40 ='2' then 1 else 0 end),0) as 女死胎死产总数 , " + 
				"nvl(sum (case when t.d601_48 in ('2','3') and t.d601_40 in ('3','4') then 1 else 0 end),0) as 不明死胎死产总数 " +
				"from D601 t ,d101 d where 1 = 1 ");
		String areaCode =null;
		List<Object> listTotal =getListCount(sb,timeStr,flag,year,month,quarter,areaCode,institutionType,institution,session);
		for (int i = 0; i < listTotal.size(); i++) {
			DeliveryTemp temp = new DeliveryTemp();
			Object[] obj = (Object[]) listTotal.get(i);
			temp.setInstitonZh((String) obj[0]);   //机构名称
			temp.setT02(Integer.valueOf(year));
			if(!StringUtil.isBlankString(quarter) && !quarter.equals("null")){
				temp.setT03(Integer.valueOf(quarter));
			}
			temp.setT04(Integer.valueOf(month));
			
			temp.setT06(Integer.valueOf(obj[1] + ""));
			temp.setT07(Integer.valueOf(obj[2] + ""));
			temp.setT08(Integer.valueOf(obj[3] + ""));
			temp.setT09(Integer.valueOf(obj[4] + ""));
			temp.setT10(Integer.valueOf(obj[5] + ""));
			temp.setT11(Integer.valueOf(obj[6] + ""));
			temp.setT12(Integer.valueOf(obj[7] + ""));
			temp.setT13(Integer.valueOf(obj[8] + ""));
			temp.setT14(Integer.valueOf(obj[9] + ""));
			temp.setT15(Integer.valueOf(obj[10] + ""));
            temp.setSe(i);
            
			map.put((String) obj[0], temp);
		}
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			DeliveryTemp temp = new DeliveryTemp();
			temp =(DeliveryTemp) entry.getValue();
			tempList.add(temp);
		}
		return tempList;
	}
	
	private List<DeliveryTemp> getDeliveryTemp(String timeStr,String flag,String year,String month,String quarter,String institutionType,String institution,Session session){
		Map<String, Object> map = new HashMap<String, Object>();
		List<DeliveryTemp> tempList = new ArrayList<DeliveryTemp>();
		
		StringBuffer sb = new StringBuffer("select d.d101_02, " + 
				"nvl(sum (case when t.d601_07 <'20' then 1 else 0 end),0) as 产妇年龄小于20, " +    
				"nvl(sum (case when t.d601_07 >='20' and t.d601_07 <'25' then 1 else 0 end),0) as 产妇年龄20, " +      
				"nvl(sum (case when t.d601_07 >='25' and t.d601_07 <'30' then 1 else 0 end),0) as 产妇年龄25, " + 
				"nvl(sum (case when t.d601_07 >='30' and t.d601_07 <'35' then 1 else 0 end),0) as 产妇年龄30, " + 
				"nvl(sum (case when t.d601_07 >='35' then 1 else 0 end),0) as 产妇年龄35, " + 
				
				"nvl(sum (case when t.d601_71 ='2' and t.d601_40 ='1' and t.d601_07 <'20' then 1 else 0 end),0) as 城镇男小于20数 , " + 
				"nvl(sum (case when t.d601_71 ='2' and t.d601_40 ='2' and t.d601_07 <'20' then 1 else 0 end),0) as 城镇女小于20数 , " + 
				"nvl(sum (case when t.d601_71 ='2' and t.d601_40 in ('3','4') and t.d601_07 <'20' then 1 else 0 end),0) as 城镇不明小于20数 , " + 
				"nvl(sum (case when t.d601_71 ='1' and t.d601_40 ='1' and t.d601_07 <'20' then 1 else 0 end),0) as 乡村男小于20数, " + 
				"nvl(sum (case when t.d601_71 ='1' and t.d601_40 ='2' and t.d601_07 <'20' then 1 else 0 end),0) as 乡村女小于20数 , " + 
				"nvl(sum (case when t.d601_71 ='1' and t.d601_40 in ('3','4') and t.d601_07 <'20' then 1 else 0 end),0) as 乡村不明小于20数, " + 
				
                "nvl(sum (case when t.d601_71 ='2' and t.d601_40 ='1' and t.d601_07 >='20' and t.d601_07 <'25' then 1 else 0 end),0) as 城镇男20数, " +
                "nvl(sum (case when t.d601_71 ='2' and t.d601_40 ='2' and t.d601_07 >='20' and t.d601_07 <'25' then 1 else 0 end),0) as 城镇女20数, " +
                "nvl(sum (case when t.d601_71 ='2' and t.d601_40 in ('3','4') and t.d601_07 >='20' and t.d601_07 <'25' then 1 else 0 end),0) as 城镇不明20数, " +
                "nvl(sum (case when t.d601_71 ='1' and t.d601_40 ='1' and t.d601_07 >='20' and t.d601_07 <'25' then 1 else 0 end),0) as 乡村男20数, " +
                "nvl(sum (case when t.d601_71 ='1' and t.d601_40 ='2' and t.d601_07 >='20' and t.d601_07 <'25' then 1 else 0 end),0) as 乡村女20数, " +
                "nvl(sum (case when t.d601_71 ='1' and t.d601_40 in ('3','4') and t.d601_07 >='20' and t.d601_07 <'25' then 1 else 0 end),0) as 乡村不明20数, " +
                
                "nvl(sum (case when t.d601_71 ='2' and t.d601_40 ='1' and t.d601_07 >='25' and t.d601_07 <'30' then 1 else 0 end),0) as 城镇男25数, " +
                "nvl(sum (case when t.d601_71 ='2' and t.d601_40 ='2' and t.d601_07 >='25' and t.d601_07 <'30' then 1 else 0 end),0) as 城镇女25数, " +
                "nvl(sum (case when t.d601_71 ='2' and t.d601_40 in ('3','4') and t.d601_07 >='25' and t.d601_07 <'30' then 1 else 0 end),0) as 城镇不明25数, " +
                "nvl(sum (case when t.d601_71 ='1' and t.d601_40 ='1' and t.d601_07 >='25' and t.d601_07 <'30' then 1 else 0 end),0) as 乡村男25数, " +
                "nvl(sum (case when t.d601_71 ='1' and t.d601_40 ='2' and t.d601_07 >='25' and t.d601_07 <'30' then 1 else 0 end),0) as 乡村女25数, " +
                "nvl(sum (case when t.d601_71 ='1' and t.d601_40 in ('3','4') and t.d601_07 >='25' and t.d601_07 <'30' then 1 else 0 end),0) as 乡村不明25数, " +
                
                "nvl(sum (case when t.d601_71 ='2' and t.d601_40 ='1' and t.d601_07 >='30' and t.d601_07 <'35' then 1 else 0 end),0) as 城镇男30数, " +
                "nvl(sum (case when t.d601_71 ='2' and t.d601_40 ='2' and t.d601_07 >='30' and t.d601_07 <'35' then 1 else 0 end),0) as 城镇女30数, " +
                "nvl(sum (case when t.d601_71 ='2' and t.d601_40 in ('3','4') and t.d601_07 >='30' and t.d601_07 <'35' then 1 else 0 end),0) as 城镇不明30数, " +
                "nvl(sum (case when t.d601_71 ='1' and t.d601_40 ='1' and t.d601_07 >='30' and t.d601_07 <'35' then 1 else 0 end),0) as 乡村男30数, " +
                "nvl(sum (case when t.d601_71 ='1' and t.d601_40 ='2' and t.d601_07 >='30' and t.d601_07 <'35' then 1 else 0 end),0) as 乡村女30数, " +
                "nvl(sum (case when t.d601_71 ='1' and t.d601_40 in ('3','4') and t.d601_07 >='30' and t.d601_07 <'35' then 1 else 0 end),0) as 乡村不明30数, " +
                
                "nvl(sum (case when t.d601_71 ='2' and t.d601_40 ='1' and t.d601_07 >='35' then 1 else 0 end),0) as 城镇男35数, " +
                "nvl(sum (case when t.d601_71 ='2' and t.d601_40 ='2' and t.d601_07 >='35' then 1 else 0 end),0) as 城镇女35数, " +
                "nvl(sum (case when t.d601_71 ='2' and t.d601_40 in ('3','4') and t.d601_07 >='35' then 1 else 0 end),0) as 城镇不明35数, " +
                "nvl(sum (case when t.d601_71 ='1' and t.d601_40 ='1' and t.d601_07 >='35' then 1 else 0 end),0) as 乡村男35数, " +
                "nvl(sum (case when t.d601_71 ='1' and t.d601_40 ='2' and t.d601_07 >='35' then 1 else 0 end),0) as 乡村女35数, " +
                "nvl(sum (case when t.d601_71 ='1' and t.d601_40 in ('3','4') and t.d601_07 >='35' then 1 else 0 end),0) as 乡村不明35数, " +
                
                "nvl(sum (case when t.d601_71 ='2' and t.d601_52 in ('2','3') then 1 else 0 end),0) as 城镇出生缺陷儿总数, " +
                "nvl(sum (case when t.d601_71 ='1' and t.d601_52 in ('2','3') then 1 else 0 end),0) as 乡村出生缺陷儿总数, " +
                "nvl(sum (case when t.d601_71 ='2' and t.d601_48 in ('2','3') then 1 else 0 end),0) as 城镇死胎死产总数, " +
                "nvl(sum (case when t.d601_71 ='1' and t.d601_48 in ('2','3') then 1 else 0 end),0) as 乡村死胎死产总数, " +
                "nvl(sum (case when t.d601_71 ='2' and t.d601_48 ='4' then 1 else 0 end),0) as 城镇7天内死亡总数, " +
                "nvl(sum (case when t.d601_71 ='1' and t.d601_48 ='4' then 1 else 0 end),0) as 乡村7天内死亡总数, " +
                "nvl(sum (case when t.d601_71 ='2' and t.d601_48 in ('2','3','4') then 1 else 0 end),0) as 城镇围产儿死亡总数, " +
                "nvl(sum (case when t.d601_71 ='1' and t.d601_48 in ('2','3','4') then 1 else 0 end),0) as 乡村围产儿死亡总数, " +

                "nvl(sum (case when t.d601_51 in ('2','3') then 1 else 0 end),0) as 双胎的婴儿数 , " +
                "nvl(sum (case when t.d601_51 in ('4','5') then 1 else 0 end),0) as 三胎及以上的婴儿数 , " +
                
                "nvl(sum (case when t.d601_51 ='1' then 1 else 0 end),0) as 单胎产妇数 " +

				"from D601 t ,d101 d where 1 = 1 ");
		String areaCode =null;
		List<Object> listTotal =getListCount(sb,timeStr,flag,year,month,quarter,areaCode,institutionType,institution,session);
		for (int i = 0; i < listTotal.size(); i++) {
			DeliveryTemp temp = new DeliveryTemp();
			Object[] obj = (Object[]) listTotal.get(i);
			temp.setInstitonZh((String) obj[0]);   //机构名称
			temp.setT02(Integer.valueOf(year));
			if(!StringUtil.isBlankString(quarter) && !quarter.equals("null")){
				temp.setT03(Integer.valueOf(quarter));
			}
			temp.setT04(Integer.valueOf(month));
			
			temp.setT05(Integer.valueOf(obj[1] + ""));
			temp.setT06(Integer.valueOf(obj[2] + ""));
			temp.setT07(Integer.valueOf(obj[3] + ""));
			temp.setT08(Integer.valueOf(obj[4] + ""));
			temp.setT09(Integer.valueOf(obj[5] + ""));
			
			temp.setT10(Integer.valueOf(obj[6] + ""));
			temp.setT11(Integer.valueOf(obj[7] + ""));
			temp.setT12(Integer.valueOf(obj[8] + ""));
			temp.setT13(Integer.valueOf(obj[9] + ""));
			temp.setT14(Integer.valueOf(obj[10] + ""));
			temp.setT15(Integer.valueOf(obj[11] + ""));
			
			temp.setT16(Integer.valueOf(obj[12] + ""));
			temp.setT17(Integer.valueOf(obj[13] + ""));
			temp.setT18(Integer.valueOf(obj[14] + ""));
			temp.setT19(Integer.valueOf(obj[15] + ""));
			temp.setT20(Integer.valueOf(obj[16] + ""));
			temp.setT21(Integer.valueOf(obj[17] + ""));
			
			temp.setT22(Integer.valueOf(obj[18] + ""));
			temp.setT23(Integer.valueOf(obj[19] + ""));
			temp.setT24(Integer.valueOf(obj[20] + ""));
			temp.setT25(Integer.valueOf(obj[21] + ""));
			temp.setT26(Integer.valueOf(obj[22] + ""));
			temp.setT27(Integer.valueOf(obj[23] + ""));
			
			temp.setT28(Integer.valueOf(obj[24] + ""));
			temp.setT29(Integer.valueOf(obj[25] + ""));
			temp.setT30(Integer.valueOf(obj[26] + ""));
			temp.setT31(Integer.valueOf(obj[27] + ""));
			temp.setT32(Integer.valueOf(obj[28] + ""));
			temp.setT33(Integer.valueOf(obj[29] + ""));
			
			temp.setT34(Integer.valueOf(obj[30] + ""));
			temp.setT35(Integer.valueOf(obj[31] + ""));
			temp.setT36(Integer.valueOf(obj[32] + ""));
			temp.setT37(Integer.valueOf(obj[33] + ""));
			temp.setT38(Integer.valueOf(obj[34] + ""));
			temp.setT39(Integer.valueOf(obj[35] + ""));
			
			temp.setT40(temp.getT10() +temp.getT11() +temp.getT12() +temp.getT13() +temp.getT14() +temp.getT15());
			temp.setT41(temp.getT16() +temp.getT17() +temp.getT18() +temp.getT19() +temp.getT20() +temp.getT21());
			temp.setT42(temp.getT22() +temp.getT23() +temp.getT24() +temp.getT25() +temp.getT26() +temp.getT27());
			temp.setT43(temp.getT28() +temp.getT29() +temp.getT30() +temp.getT31() +temp.getT32() +temp.getT33());
			temp.setT44(temp.getT34() +temp.getT35() +temp.getT36() +temp.getT37() +temp.getT38() +temp.getT39());
			temp.setT45(temp.getT10() +temp.getT16() +temp.getT22() +temp.getT28() +temp.getT34() );
			temp.setT46(temp.getT11() +temp.getT17() +temp.getT23() +temp.getT29() +temp.getT35() );
			temp.setT47(temp.getT12() +temp.getT18() +temp.getT24() +temp.getT30() +temp.getT36() );
			temp.setT48(temp.getT13() +temp.getT19() +temp.getT25() +temp.getT31() +temp.getT37() );
			temp.setT49(temp.getT14() +temp.getT20() +temp.getT26() +temp.getT32() +temp.getT38() );
			temp.setT50(temp.getT15() +temp.getT21() +temp.getT27() +temp.getT33() +temp.getT39() );
			temp.setT64(String.valueOf(temp.getT45() +temp.getT46() +temp.getT47() +temp.getT48() +temp.getT49()) );
			
			temp.setT51(Integer.valueOf(obj[36] + ""));
			temp.setT52(Integer.valueOf(obj[37] + ""));
			temp.setT53(Integer.valueOf(obj[38] + ""));
			temp.setT54(Integer.valueOf(obj[39] + ""));
			temp.setT55(Integer.valueOf(obj[40] + ""));
			temp.setT56(Integer.valueOf(obj[41] + ""));
			temp.setT57(Integer.valueOf(obj[42] + ""));
			temp.setT58(Integer.valueOf(obj[43] + ""));
			
			int t59_p =Integer.valueOf(obj[44] + "");
			int t60_P=Integer.valueOf(obj[45] + "");
			if(t59_p <=0){
				temp.setT59(0);
			}else if(t59_p >=1 && t59_p<2){
				temp.setT59(1);
			}else{
				double t59P_ =t59_p /2;
				double t59P_double =(double)t59_p /2;
				if(t59P_ !=t59P_double){
					temp.setT59(Integer.valueOf((t59P_ +1) + ""));
				}else{
					temp.setT59(Integer.valueOf(t59P_ + ""));
				}
			}
			if(t60_P <=0){
				temp.setT60(0);
			}else if(t60_P >=1 && t60_P<3){
				temp.setT60(1);
			}else{
				double t60P_ =t60_P /3;
				double t60P_double =(double)t60_P /3;
				
				if(t60P_ !=t60P_double){
					temp.setT60(Integer.valueOf((t60P_ +1) + ""));
				}else{
					temp.setT60(Integer.valueOf(t60P_ + ""));
				}
			}
			
			temp.setT61(Integer.valueOf(obj[46] + ""));
            temp.setSe(i);
            
			map.put((String) obj[0], temp);
		}
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			DeliveryTemp temp = new DeliveryTemp();
			temp =(DeliveryTemp) entry.getValue();
			tempList.add(temp);
		}
		return tempList;
	}
	
}
