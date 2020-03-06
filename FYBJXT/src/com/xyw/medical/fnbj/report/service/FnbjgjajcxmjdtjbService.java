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

import com.sun.org.apache.xpath.internal.operations.And;

public class FnbjgjajcxmjdtjbService {
	public List<Object> query(String date_start,String date_end,String institution,ServletContext servletContext){
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		DataSource dataSource = (DataSource) webApplicationContext.getBean("dataSource");
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		List<Object> list=new ArrayList<Object>();
		try {
			connection = dataSource.getConnection();
			StringBuffer sql=new StringBuffer("select count(t.L302_01) as t1,"+
													"count(case when  t.L302_16 ='1' then '以前接受过宫颈癌检查的人数' end )as t2,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null then '结案人数' end )as t3,"+
											        "count(case when  t.L302_101 ='1' and t.L302_105 is not null and t.L302_112 is not null then '正常人数' end )as t4,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_76  is not null then '巴氏分级报告人数' end )as t5,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_73>='3'  then '巴氏分级IIB' end )as t6,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_76  is not null then '宫颈细胞学报告人数' end )as t7,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_74='3'  then '不典型鳞状上皮细胞' end )as t8,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_74='3'  then '不除外高度鳞状上皮内病变' end )as t9,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_74='4'  then '低度鳞状上皮内病变' end )as t10,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_74='5'  then '高度鳞状上皮内病变' end )as t11,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_74='6'  then '鳞状细胞癌' end )as t12,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_74='7'  then '不典型腺上皮细胞' end )as t13,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_74='8'  then '不典型颈管腺细胞倾向瘤变' end )as t14,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_74='9'  then '颈管原位癌' end )as t15,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_74='10'  then '腺癌' end )as t16,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_82  is not null then '醋酸碘染色实查人数' end )as t17,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and (t.L302_79='2' or t.L302_80='2') then '醋酸碘染色异常可疑' end )as t18,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and (t.L302_74='2' or t.L302_73>='3'or t.L302_79='2' or t.L302_80='2' or t.L302_34 in('3','6') or t.L302_36 in('3','6') ) then '阴道镜检查应查人数' end )as t19,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_92  is not null then '阴道镜检查实查人数' end )as t20,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_89='2' then '阴道镜检查异常可疑' end )as t21,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and (t.L302_27='1' or t.L302_56='2' or t.L302_102 in('6','7','8','9','10','11','12')) then '生殖道感染总人数' end )as t22,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and (t.L302_28 like '%滴虫%阴道炎%'or t.L302_57='2' or t.L302_102='6' ) then '滴虫性阴道炎' end )as t23,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and (t.L302_28 like '%细菌%阴道炎%'or  t.L302_57='4' or t.L302_102='8' ) then '细菌性阴道炎' end )as t24,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and (t.L302_28 like '%酵母菌%'or  t.L302_57='3' or t.L302_102='7'  ) then '外阴阴道假丝酵母菌病' end )as t25,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and (t.L302_28 like '%尖锐湿疣%'or  t.L302_57='1' or t.L302_102='9' ) then '外生殖器尖锐湿疣' end )as t26,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and (t.L302_28 like '%脓性宫颈%'or  t.L302_57='5' or t.L302_102='11' ) then '黏液脓性宫颈炎' end )as t27,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and (t.L302_28 like '%宫颈息肉炎%'or  t.L302_57='6' or t.L302_102='12') then '宫颈息肉' end )as t28,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and (t.L302_56='7' or t.L302_102='10') then '子宫肌瘤' end )as t29,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_102='14' then '其他良性疾病' end )as t30,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and (t.L302_79='2' or t.L302_80='2' or t.L302_90='3') then '组织病理应查' end )as t31,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_98 is not null then '组织病理实查' end )as t32,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_102='1' then '低级别鳞状上皮内病变' end )as t33,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_102='2' then '高级别鳞状上皮内病变' end )as t34,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_102='3' then '原位腺癌' end )as t35,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_102='4' then '微小浸润癌' end )as t36,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_102='5' then '浸润癌' end )as t37,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_102='13' then '其他恶性肿瘤' end )as t38,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_108='1' and t.L302_108 in('2','3','4','5') and months_between(t.L302_114,t.L302_107)>=3 then '随访人数' end )as t39,"+
											        "count(case when  t.L302_105 is not null and t.L302_112 is not null  and t.L302_109='1' then '治疗人数' end )as t40"+
											        " from  L302 t where  to_char(t.L302_120,'yyyy-mm-dd')>=? and to_char(t.L302_120,'yyyy-mm-dd')<=?   and t.L302_59 is not null and ( t.L302_76 is not null or t.L302_82 is not null) ");
			if (institution.length() == 14)
				sql.append(" and t.L302_118 = '"+institution+"'");
			else 
				sql.append(" and t.L302_118 like '"+institution+"%'");	
			
			pStatement = connection.prepareStatement(sql.toString());
			pStatement.setString(1, date_start);
			pStatement.setString(2, date_end);
			resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				long t1 = resultSet.getLong("t1");//总数
				long t2 = resultSet.getLong("t2");//以前接受过宫颈癌检查的人数
				long t3 = resultSet.getLong("t3");//结案人数
				long t4 = resultSet.getLong("t4");//正常人数
				long t5 = resultSet.getLong("t5");//巴氏分级报告人数
				long t6 = resultSet.getLong("t6");//巴氏分级IIB
				long t7 = resultSet.getLong("t7");//宫颈细胞学报告人数
				long t8 = resultSet.getLong("t8");//不典型鳞状上皮细胞
				long t9 = resultSet.getLong("t9");//不除外高度鳞状上皮内病变
				long t10 = resultSet.getLong("t10");//低度鳞状上皮内病变
				long t11 = resultSet.getLong("t11");//高度鳞状上皮内病变
				long t12 = resultSet.getLong("t12");//鳞状细胞癌
				long t13 = resultSet.getLong("t13");//不典型腺上皮细胞
				long t14 = resultSet.getLong("t14");//不典型颈管腺细胞倾向瘤变
				long t15 = resultSet.getLong("t15");//颈管原位癌
				long t16 = resultSet.getLong("t16");//腺癌
				long t17 = resultSet.getLong("t17");//醋酸碘染色实查人数
				long t18 = resultSet.getLong("t18");//醋酸碘染色异常可疑
				long t19 = resultSet.getLong("t19");//阴道镜检查应查人数
				long t20 = resultSet.getLong("t20");//阴道镜检查实查人数
				long t21 = resultSet.getLong("t21");//阴道镜检查异常可疑
				long t22 = resultSet.getLong("t22");//生殖道感染总人数
				long t23 = resultSet.getLong("t23");//滴虫性阴道炎
				long t24 = resultSet.getLong("t24");//细菌性阴道炎
				long t25 = resultSet.getLong("t25");//外阴阴道假丝酵母菌病
				long t26 = resultSet.getLong("t26");//外生殖器尖锐湿疣
				long t27 = resultSet.getLong("t27");//黏液脓性宫颈炎
				long t28 = resultSet.getLong("t28");//宫颈息肉
				long t29 = resultSet.getLong("t29");//子宫肌瘤
				long t30 = resultSet.getLong("t30");//其他良性疾病
				long t31 = resultSet.getLong("t31");//组织病理应查
				long t32 = resultSet.getLong("t32");//组织病理实查
				long t33 = resultSet.getLong("t33");//低级别鳞状上皮内病变
				long t34 = resultSet.getLong("t34");//高级别鳞状上皮内病变
				long t35 = resultSet.getLong("t35");//原位腺癌
				long t36 = resultSet.getLong("t36");//微小浸润癌
				long t37 = resultSet.getLong("t37");//浸润癌
				long t38 = resultSet.getLong("t38");//其他恶性肿瘤
				long t39 = resultSet.getLong("t39");//随访人数
				long t40 = resultSet.getLong("t40");//治疗人数
				long t41 = t22-t23-t24-t25-t26-t27-t28;//生殖道其他
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
				list.add(t38);
				list.add(t39);
				list.add(t40);
				list.add(t41);
			}
			
			sql=new StringBuffer("select d.d201_04 as t42 from d201 d where d.d201_01=");
			if (institution.length() == 14)
				sql.append("'"+institution.substring(0, 5)+"'");
			else 
				sql.append("'"+institution+"'");	
			
			pStatement = connection.prepareStatement(sql.toString());
			resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				list.add(resultSet.getString("t42"));//县区
				list.add(date_start);//开始时间
				list.add(date_end);//结束时间
			}
			
			sql=new StringBuffer("select sum(t.l305_06) as t45 from l305 t where l305_04 ");
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
				list.add(resultSet.getInt("t45"));//年度统计
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fnbjcssqService.close(connection, pStatement, resultSet);
		}
		return list;
	}
}
