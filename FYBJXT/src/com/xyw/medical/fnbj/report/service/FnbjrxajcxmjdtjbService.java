package com.xyw.medical.fnbj.report.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class FnbjrxajcxmjdtjbService {
	public List<Object> query(String date_start,String date_end,String institution,ServletContext servletContext){
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		DataSource dataSource = (DataSource) webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		List<Object> list=new ArrayList<Object>();
		try {
			connection = dataSource.getConnection();
			StringBuffer sql=new StringBuffer(
					"select count(t.L402_01)  as t1 ,"+
				       "count(case when t.l402_13 ='1' then '以前接受过检查' end) as t2,"+
				       "count(case when t.l402_102 is not null and t.l402_120 is not null then '结案人数' end) as t3, "+
				       "count(case when t.l402_84 is not null and t.l402_102 is not null and t.l402_120 is not null then '彩超实查人数' end) as t4,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_64='1' or t.l402_82='1') then '彩超0级' end) as t5,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_64='2' or t.l402_82='2') then '彩超1级' end) as t6,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_64='3' or t.l402_82='3') then '彩超2级' end) as t7,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_64='4' or t.l402_82='4') then '彩超3级' end) as t8,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_64='5' or t.l402_82='5') then '彩超4级' end) as t9,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_64='6' or t.l402_82='6') then '彩超5级' end) as t10,"+
				       "count(case when t.l402_102 is not null and t.l402_107 is not null and t.l402_120 is not null then 'X线实查人数' end) as t11,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_87='1' or t.l402_94='1') then 'X线0级' end) as t12,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_87='2' or t.l402_94='2') then 'X线1级' end) as t13,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_87='3' or t.l402_94='3') then 'X线2级' end) as t14,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_87='4' or t.l402_94='4') then 'X线3级' end) as t15,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_87='5' or t.l402_94='5') then 'X线4级' end) as t16,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_87='6' or t.l402_94='6') then 'X线5级' end) as t17,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and t.l402_111='1'  then '乳腺纤维腺瘤' end) as t18,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and t.l402_111='2'  then '乳腺导管内乳头状瘤' end) as t19,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and t.l402_111='9' and t.l402_126 not like '%乳腺增生%' then '其他' end) as t20,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and t.l402_64 in('4','5') and (t.l402_87 in('0','3','4','5') or t.l402_82 in('4','5') or t.l402_94 in('0','3','4','5')) then '组织病理应查人数' end) as t21,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and t.l402_112 in('1','2') then '不典型增生' end) as t22,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and t.l402_106='1' and t.l402_107='1' then '组织病理应查人数' end) as t37,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and t.l402_112='3'then '小叶原位癌' end) as t23,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and t.l402_110='4'then '导管原位癌' end) as t24,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and t.l402_113='1'then '浸润性导管癌' end) as t25,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and t.l402_113='2'then '浸润性小叶癌' end) as t26,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and t.l402_127 is not null then '其他恶性肿瘤' end) as t27,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and t.l402_110 not in('1','2') then '应分期人数' end) as t28,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_115='1' or t.l402_118='1') then '获得分期人数' end) as t29,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_116 like '0%' or t.l402_119 like '0%') then '0期' end) as t30,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_116 like 'I%' or t.l402_119 like 'I%') then 'I期' end) as t31,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_116 like 'IIA%' or t.l402_119 like 'IIA%') then 'IIA期' end) as t32,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_116 like 'IIB%' or t.l402_119 like 'IIB%') then 'IIB期' end) as t33,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and (t.l402_116 like '%III%' or t.l402_119 like '%III%') then 'III期及以上' end) as t34,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and t.l402_110 in('3','4','5') and t.l402_105='1' and months_between(t.l402_121,t.l402_109)>=3  then '随访人数' end) as t35,"+
				       "count(case when t.l402_107 is not null and t.l402_120 is not null and t.l402_122='1' then '治疗人数' end) as t36"+
				       " from  L402 t where  to_char(t.L402_125,'yyyy-mm-dd')>= ? and to_char(t.L402_125,'yyyy-mm-dd')<=? and t.L402_44 is not null and t.L402_84 is not null");

			if (institution.length() == 14)
				sql.append(" and t.L402_123 = '"+institution+"'");
			else 
				sql.append(" and t.L402_123 like '"+institution+"%'");	
			pStatement = connection.prepareStatement(sql.toString());
			pStatement.setString(1, date_start);
			pStatement.setString(2, date_end);
			resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				long t1 = resultSet.getLong("t1");//检查人数
				long t2 = resultSet.getLong("t2");//以前接受过检查
				long t3 = resultSet.getLong("t3");//结案人数
				long t4 = resultSet.getLong("t4");//彩超实查人数
				long t5 = resultSet.getLong("t5");//彩超0级
				long t6 = resultSet.getLong("t6");//彩超1级
				long t7 = resultSet.getLong("t7");//彩超2级
				long t8 = resultSet.getLong("t8");//彩超3级
				long t9 = resultSet.getLong("t9");//彩超4级
				long t10 = resultSet.getLong("t10");//彩超5级
				long t11 = resultSet.getLong("t11");//X线实查人数
				long t12 = resultSet.getLong("t12");//X线0级
				long t13 = resultSet.getLong("t13");//X线1级
				long t14 = resultSet.getLong("t14");//X线2级
				long t15 = resultSet.getLong("t15");//X线3级
				long t16 = resultSet.getLong("t16");//X线4级
				long t17 = resultSet.getLong("t17");//X线5级
				long t18 = resultSet.getLong("t18");//乳腺纤维腺瘤
				long t19 = resultSet.getLong("t19");//乳腺导管内乳头状瘤
				long t20 = resultSet.getLong("t20");//其他
				long t21 = resultSet.getLong("t21");//组织病理应查人数
				long t37 = resultSet.getLong("t37");//组织病理实查人数
				long t22 = resultSet.getLong("t22");//不典型增生
				long t23 = resultSet.getLong("t23");//小叶原位癌
				long t24 = resultSet.getLong("t24");//导管原位癌
				long t25 = resultSet.getLong("t25");//浸润性导管癌
				long t26 = resultSet.getLong("t26");//浸润性小叶癌
				long t27 = resultSet.getLong("t27");//其他恶性肿瘤
				long t28 = resultSet.getLong("t28");//应分期人数
				long t29 = resultSet.getLong("t29");//获得分期人数
				long t30 = resultSet.getLong("t30");//0期
				long t31 = resultSet.getLong("t31");//I期
				long t32 = resultSet.getLong("t32");//IIA期
				long t33 = resultSet.getLong("t33");//IIB期
				long t34 = resultSet.getLong("t34");//III期及以上
				long t35 = resultSet.getLong("t35");//随访人数
				long t36 = resultSet.getLong("t36");//治疗人数

				list.add(t1);
				list.add(t2);
				list.add(t3);
				list.add(t4);
				list.add(t5);
				list.add(t6);
				list.add(t7);
				list.add(t8);
				list.add(t9);
				list.add(t10);
				list.add(t11);
				list.add(t12);
				list.add(t13);
				list.add(t14);
				list.add(t15);
				list.add(t16);
				list.add(t17);
				list.add(t18);
				list.add(t19);
				list.add(t20);
				list.add(t21);
				list.add(t22);
				list.add(t23);
				list.add(t24);
				list.add(t25);
				list.add(t26);
				list.add(t27);
				list.add(t28);
				list.add(t29);
				list.add(t30);
				list.add(t31);
				list.add(t32);
				list.add(t33);
				list.add(t34);
				list.add(t35);
				list.add(t36);
				list.add(t37);
			}
			
			sql=new StringBuffer("select d.d201_04 as t38 from d201 d where d.d201_01=");
			if (institution.length() == 14)
				sql.append("'"+institution.substring(0, 5)+"'");
			else 
				sql.append("'"+institution+"'");	
			
			pStatement = connection.prepareStatement(sql.toString());
			resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				list.add(resultSet.getString("t38"));//县区
				list.add(date_start);//开始时间
				list.add(date_end);//结束时间
			}
			sql=new StringBuffer("select sum(t.l305_05) as t39 from l305 t where l305_04 ");
			
			if (institution.length() == 14)
				sql.append("   = '"+institution+"'");
			else 
				sql.append("   like '"+institution+"%'");	
	
			if(date_start.substring(0, 4).equals(date_end.substring(0, 4)))
				sql.append("  and to_char(t.l305_02)='"+date_start.substring(0, 4)+"'");
			else 
				sql.append("  and to_char(t.l305_02)='"+date_start.substring(0, 4) 
						+"' or to_char(t.l305_02)='"+date_end.substring(0, 4)+"'");
			pStatement = connection.prepareStatement(sql.toString());
			resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				list.add(resultSet.getInt("t39"));//年度统计
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fnbjcssqService.close(connection, pStatement, resultSet);
		}
		return list;
	}
}
