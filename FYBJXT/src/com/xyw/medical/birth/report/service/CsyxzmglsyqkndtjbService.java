package com.xyw.medical.birth.report.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xyw.medical.birth.report.model.BirthCertificateCount;
import com.xyw.sys.util.StringUtil;

public class CsyxzmglsyqkndtjbService {
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<BirthCertificateCount> queryBirthCertificateCount(String year, String institution, String institutionType,ServletContext servletContext) {
		
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.sessionFactory = (SessionFactory)webApplicationContext.getBean("sessionFactory");
		Session session = null;
		List<BirthCertificateCount> listBirthCertificateCount = null;
		try {
			session = this.sessionFactory.openSession();
			listBirthCertificateCount = new ArrayList<BirthCertificateCount>();
			Map<String, Object> map = new HashMap<String, Object>();//存放报表中的字段数据
			//第一阶段，institutionType=8||6||4，其中8和6全部，4只记录市卫生局的数据
			if(!"4".equals(institutionType)){
				//01.签发数据    出生证使用情况
				String str01 = "select t.d301_26 as 机构代码," +
						"sum (case when t.d301_42 = '0'  then 1 else 0 end) as 首次签发数," +
						"sum (case when t.d301_42 in ( '2','4' )  then 1 else 0 end) as 补发数," +
						"sum (case when t.d301_42 in ( '1','3' )  then 1 else 0 end) as 换发数," +
						"sum (case when t.d301_42 = '9'  then 1 else 0 end) as 家庭接生员接生的签发数," +
						"sum (case when t.d301_42 in ( '5','6','7' )  then 1 else 0 end) as 其它情况的签发数," +
						"d.d101_02 as 机构名称 " +
						"from D301 t ,d101 d where 1 = 1";
				StringBuffer sb01 = new StringBuffer(str01);
				//时间条件
				if(!StringUtil.isBlankString(year)){
					sb01.append(" and to_char(t.d301_28,'yyyy') = '");
					sb01.append(year);
					sb01.append("'");
				}
				//机构条件
				if("8".equals(institutionType)){//单独一个医疗机构
					sb01.append(" and t.d301_26 = '");
					sb01.append(institution);
					sb01.append("'");
				}else if("6".equals(institutionType)){//上级查下级
					sb01.append(" and (d.d101_11 = '");
					sb01.append(institution);
					sb01.append("' or d.d101_01 = '");
					sb01.append(institution);
					sb01.append("')");
				}
				sb01.append(" and t.d301_26 = d.d101_01 group by d.d101_02,t.d301_26");
//				System.out.println("==========01.签发数据==========="+sb01.toString());
				SQLQuery sqlQuery01 = session.createSQLQuery(sb01.toString());
				List<Object> list01 = sqlQuery01.list();

				for (int i = 0; i < list01.size(); i++) {
					BirthCertificateCount bcc = new BirthCertificateCount();
					Object[] obj = (Object[]) list01.get(i);
					String institutionCode = (String) obj[0];
					
					if(!"4".equals(institutionType)){
						bcc.setInstitutionCode(institutionCode);
						bcc.setQf03(Long.valueOf(obj[1] + ""));
						bcc.setQf04(Long.valueOf(obj[2] + ""));
						bcc.setQf05(Long.valueOf(obj[3] + ""));
						bcc.setQf07(Long.valueOf(obj[4] + ""));
						bcc.setQf08(Long.valueOf(obj[5] + ""));
						bcc.setInstitutionName((String) obj[6]);
						
						map.put(institutionCode, bcc);
					}
				}

				//02.废证数据 
				String str02 = "select t.d401_10 as 机构代码," +
						"sum (case when t.d401_06 in ('1','2','6','7','8')  then 1 else 0 end) as 因打印或填写错误数, " +
						"sum (case when t.d401_06 in ('3','4','10')  then 1 else 0 end) as 遗失数, " +
						"sum (case when t.d401_06  in ( '5','9' )   then 1 else 0 end) as 其它原因数," +
						"d.d101_02 as 机构名称 " +
						"from D401 t,d101 d where 1 = 1";
				StringBuffer sb02 = new StringBuffer(str02);
				//时间条件
				if(!StringUtil.isBlankString(year)){
					sb02.append(" and to_char(t.d401_08,'yyyy') = '");
					sb02.append(year);
					sb02.append("'");
				}
				//机构条件
				if("8".equals(institutionType)){//单独一个医疗机构
					sb02.append(" and t.d401_10 = '");
					sb02.append(institution);
					sb02.append("'");
				}else if("6".equals(institutionType)){//上级查下级
					sb02.append(" and (d.d101_11 = '");
					sb02.append(institution);
					sb02.append("' or d.d101_01 = '");
					sb02.append(institution);
					sb02.append("')");
				}
				sb02.append(" and t.d401_10 = d.d101_01 group by d.d101_02,t.d401_10");
//				System.out.println("==========02.废证数据==========="+sb02.toString());
				SQLQuery sqlQuery02 = session.createSQLQuery(sb02.toString());
				List<Object> list02 = sqlQuery02.list();

				for (int i = 0; i < list02.size(); i++) {
					BirthCertificateCount bcc = new BirthCertificateCount();
					Object[] obj = (Object[]) list02.get(i);
					String institutionCode = (String) obj[0];

					if(!"4".equals(institutionType)){
						if (map.containsKey(institutionCode)) {// 机构存在的话，找出对象，把数据设置给对象
							bcc = (BirthCertificateCount) map.get(institutionCode);
							bcc.setFz10(Long.valueOf(obj[1] + ""));
							bcc.setFz11(Long.valueOf(obj[2] + ""));
							bcc.setFz12(Long.valueOf(obj[3] + ""));
							bcc.setInstitutionName((String) obj[4]);
						} else {// 机构不存在的话，添加新对象
							bcc.setInstitutionCode(institutionCode);
							bcc.setFz10(Long.valueOf(obj[1] + ""));
							bcc.setFz11(Long.valueOf(obj[2] + ""));
							bcc.setFz12(Long.valueOf(obj[3] + ""));
							bcc.setInstitutionName((String) obj[4]);

							map.put(institutionCode, bcc);
						}
					}
				}
				
				// 05.活产数
				String str06 = "select t.d601_02,count(1) as 当年机构内活产数,d.d101_02 from D601 t,D101 d "
						+ "where 1 = 1 and t.d601_48 in ('1','4')";
				StringBuffer sb06 = new StringBuffer(str06);
				//时间条件
				if(!StringUtil.isBlankString(year)){
					sb06.append(" and to_char(t.d601_03,'yyyy') = '");
					sb06.append(year);
					sb06.append("'");
				}
				//机构条件
				if("8".equals(institutionType)){//单独一个医疗机构
					sb06.append(" and t.d601_02 = '");
					sb06.append(institution);
					sb06.append("'");
				}else if("6".equals(institutionType)){//上级查下级
					sb06.append(" and (d.d101_11 = '");
					sb06.append(institution);
					sb06.append("' or d.d101_01 = '");
					sb06.append(institution);
					sb06.append("')");
				}
				sb06.append(" and t.d601_02 = d.d101_01 group by d.d101_02,t.d601_02");
//				System.out.println("==========05.活产数==========="+sb06.toString());
				SQLQuery sqlQuery06 = session.createSQLQuery(sb06.toString());
				List<Object> list06 = sqlQuery06.list();

				for (int i = 0; i < list06.size(); i++) {
					BirthCertificateCount bcc = new BirthCertificateCount();
					Object[] obj = (Object[]) list06.get(i);
					String institutionCode = (String) obj[0];
					
					if (!"4".equals(institutionType)) {
						if (map.containsKey(institutionCode)) {// 机构存在的话，找出对象，把数据设置给对象
							bcc = (BirthCertificateCount) map.get(institutionCode);
							bcc.setHc16(Long.valueOf(obj[1] + ""));
							bcc.setInstitutionName((String) obj[2]);
						} else {// 机构不存在的话，添加新对象
							bcc.setInstitutionCode(institutionCode);
							bcc.setHc16(Long.valueOf(obj[1] + ""));
							bcc.setInstitutionName((String) obj[2]);

							map.put(institutionCode, bcc);
						}
					} 
				}      
			}

			// 03.库存数(统计的是当年库存数)
			String str03 = "select t.d505_04,count(1),d.d101_02 from D505 t ,d101 d " +
					"where 1 = 1 ";
			StringBuffer sb03 = new StringBuffer(str03);
			// 时间条件
			if (!StringUtil.isBlankString(year)) {
				sb03.append(" and to_char(t.d505_07,'yyyy') <= '");
				sb03.append(year);
				sb03.append("'");
				sb03.append(" and (t.d505_05 = '1' or (t.d505_05 = '6' and t.d505_11='2' " +
						"and substr(t.d505_09,0,4) = '" + year +"') or " +
								"(substr(t.d505_09,0,4) >'" + year +"'))");
			}
			// 机构条件
			if ("8".equals(institutionType)) {// 单独一个医疗机构
				sb03.append(" and t.d505_04 = '");
				sb03.append(institution);
				sb03.append("'");
			} else {// 上级查下级
				sb03.append(" and (d.d101_11 = '");
				sb03.append(institution);
				sb03.append("' or d.d101_01 = '");
				sb03.append(institution);
				sb03.append("')");
			}
			sb03.append(" and t.d505_04 = d.d101_01 group by d.d101_02,t.d505_04");
//			System.out.println("==========03.库存数==========="+sb03.toString());
			SQLQuery sqlQuery03 = session.createSQLQuery(sb03.toString());
			List<Object> list03 = sqlQuery03.list();

			for (int i = 0; i < list03.size(); i++) {
				BirthCertificateCount bcc = new BirthCertificateCount();
				Object[] obj = (Object[]) list03.get(i);
				String institutionCode = (String) obj[0];

				if (map.containsKey(institutionCode)) {// 机构存在的话，找出对象，把数据设置给对象
					bcc = (BirthCertificateCount) map.get(institutionCode);
					bcc.setKc15(Long.valueOf(obj[1] + ""));
					bcc.setInstitutionName((String) obj[2]);
				} else {// 机构不存在的话，添加新对象
					bcc.setInstitutionCode(institutionCode);
					bcc.setKc15(Long.valueOf(obj[1] + ""));
					bcc.setInstitutionName((String) obj[2]);

					map.put(institutionCode, bcc);
				}
			}
			
			// 04.当年申领数
			String str05 = "select t.d501_02,sum(t.d501_05) as 当年申领数,d.d101_02 from D501 t,d101 d " +
					"where 1 = 1";
			StringBuffer sb05 = new StringBuffer(str05);
			//时间条件
			if(!StringUtil.isBlankString(year)){
				sb05.append(" and extract(year from t.d501_12) = to_number('");
				sb05.append(year);
				sb05.append("')");
			}
			//机构条件
			if("8".equals(institutionType)){//单独一个医疗机构
				sb05.append(" and t.d501_02 = '");
				sb05.append(institution);
				sb05.append("'");
			}else {//上级查下级
				sb05.append(" and (d.d101_11 = '");
				sb05.append(institution);
				sb05.append("' or d.d101_01 = '");
				sb05.append(institution);
				sb05.append("')");
			}
			sb05.append(" and t.d501_02 = d.d101_01 group by d.d101_02,t.d501_02");
//			System.out.println("==========04.当年申领数==========="+sb05.toString());
			SQLQuery sqlQuery05 = session.createSQLQuery(sb05.toString());
			List<Object> list05 = sqlQuery05.list();

			for (int i = 0; i < list05.size(); i++) {
				BirthCertificateCount bcc = new BirthCertificateCount();
				Object[] obj = (Object[]) list05.get(i);
				String institutionCode = (String) obj[0];
				
				if (map.containsKey(institutionCode)) {// 机构存在的话，找出对象，把数据设置给对象
					bcc = (BirthCertificateCount) map.get(institutionCode);
					bcc.setSl02(Long.valueOf(obj[1] + ""));
					bcc.setInstitutionName((String) obj[2]);
				} else {// 机构不存在的话，添加新对象
					bcc.setInstitutionCode(institutionCode);
					bcc.setSl02(Long.valueOf(obj[1] + ""));
					bcc.setInstitutionName((String) obj[2]);

					map.put(institutionCode, bcc);
				}
			}
			
			if(!"8".equals(institutionType)){
				String institutionCodeA =""; 
				SQLQuery sqlQueryA = null;
				if("4".equals(institutionType)){
					institutionCodeA =institution.substring(0,4);
					sqlQueryA = session.createSQLQuery("select t.d101_01,t.d101_02 from D101 t where t.d101_11 = ? or t.d101_01 = ?");
					sqlQueryA.setString(0, institution);
					sqlQueryA.setString(1, institution);
				}else if("6".equals(institutionType)){
					institutionCodeA =institution.substring(0,6);
					sqlQueryA = session.createSQLQuery("select t.d101_01,t.d101_02 from D101 t where t.d101_01 = ?");
					sqlQueryA.setString(0, institution);
				}
				List<Object> list = sqlQueryA.list();
				for (int i = 0; i < list.size(); i++) {
					BirthCertificateCount bcc = new BirthCertificateCount();
					Object[] obj = (Object[]) list.get(i);
					String institutionCode = (String) obj[0];
					String institutionName = (String) obj[1];
					
					if (map.containsKey(institutionCode)) {// 机构存在的话，找出对象，把数据设置给对象
						bcc = (BirthCertificateCount) map.get(institutionCode);
						bcc.setInstitutionName(institutionName);
					} else {// 机构不存在的话，添加新对象
						bcc.setInstitutionCode(institutionCode);
						bcc.setInstitutionName(institutionName);
						
						map.put(institutionCode, bcc);
					}
				}
				
				if(institutionCodeA !=null & !institutionCodeA.isEmpty()){
					if("4".equals(institutionType)){
						map =getInstitutionCount(year,institution,institutionType,map,servletContext,institutionCodeA,"市");
						map =getInstitutionCount(year,institution,institutionType,map,servletContext,institutionCodeA,"区县");
					}else if("6".equals(institutionType)){
						map =getInstitutionCount(year,institution,institutionType,map,servletContext,institutionCodeA,"区县");
					}
				}
			}
	
			// 遍历map,计算出各个公式中的合计设置给bcc，放入map集合中
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				BirthCertificateCount bcc = new BirthCertificateCount();
				String institutionCode = entry.getKey();
				bcc = (BirthCertificateCount) entry.getValue();
				
				long sl02 = bcc.getSl02();//当年申领数（2）
				
				long qf03 = bcc.getQf03();//首次签发数（3）
				long qf04 = bcc.getQf04();//补发数（4）
				long qf05 = bcc.getQf05();//换发数（5）
				long qfCount06 = qf03 + qf04 + qf05;//机构内签发小计（6）=（3）+（4）+（5）
				
				long qf07 = bcc.getQf07();//家庭接生员接生的签发数（7）
				long qf08 = bcc.getQf08();//其它情况的签发数（8）
				long qfCount09 = qf07 + qf08;//机构外签发小计（9）=（7）+（8）
				
				long fz10 = bcc.getFz10();//因打印或填写错误数（10）
				long fz11 = bcc.getFz11();//遗失数（11）
				long fz12 = bcc.getFz12();//其它原因数（12）
				long fzCount13 = fz10 + fz11 + fz12;//废证数小计（13）=（10）+（11）+（12）
				
				long syCount14 = qfCount06 + qfCount09 + fzCount13;//使用合计（14）=（6）+（9）+（13）
				
				long kc15 = bcc.getKc15();//当年年底库存数（15）
//				long hc16;//当年医疗保健机构内活产数（16）
				
				long kc01 =  kc15 + syCount14 - sl02;//上一年年底库存数（1）=（15）+（14）-（2）
				if(kc01 < 0){
					kc01 = 0;
				}
//				System.out.println(institutionCode+" ---"+institution+"当年申领数:"+sl02+" 当年年底库存数："+ kc15 +" 上一年底库存："+kc01 +" 证使用合计："+syCount14);
				if (map.containsKey(institutionCode)) {// 机构存在的话，找出对象，把数据设置给对象
					bcc = (BirthCertificateCount) map.get(institutionCode);
					String institutionCode_ = bcc.getInstitutionCode();
					if(!"8".equals(institutionType) && institutionCode_.equals(institution)){//如果是上级单位，库存应该重新计算
						bcc.setKc01(kc01);
			//			bcc.setKc01(0);//上一年库存为0
			//			bcc.setSl02(syCount14);//当年申领数（12） = 合计（14）
			//			bcc.setKc15(0);//当年年底库存数为0
						bcc.setQfCount06(qfCount06);
						bcc.setQfCount09(qfCount09);
						bcc.setFzCount13(fzCount13);
						bcc.setSyCount14(syCount14);
					}else{  
						bcc.setKc01(kc01);
						bcc.setQfCount06(qfCount06);
						bcc.setQfCount09(qfCount09);
						bcc.setFzCount13(fzCount13);
						bcc.setSyCount14(syCount14);
					}
					
				}
				
				listBirthCertificateCount.add(bcc);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session.isConnected()){
				session.close();
			}
		}
		Collections.sort(listBirthCertificateCount, new Comparator<BirthCertificateCount>() {
			@Override
			public int compare(BirthCertificateCount bcc01, BirthCertificateCount bcc02) {
				return bcc01.getInstitutionCode().compareTo(bcc02.getInstitutionCode()); // 调用String中的compareTo()方法
			}
		});
		return listBirthCertificateCount;
	}
	
	public String getInstitutionName(String institution, String institutionType, ServletContext servletContext){
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.sessionFactory = (SessionFactory)webApplicationContext.getBean("sessionFactory");
		Session session = null;
		String institutionName = null;
		try {
			session = this.sessionFactory.openSession();
			SQLQuery sqlQuery = null;
			
			if ("8".equals(institutionType)) {
				sqlQuery = session
						.createSQLQuery("select t.D101_02 from D101 t where t.d101_01 = (select t1.D101_11 from D101 t1 where t1.D101_01 = ?)");
				sqlQuery.setString(0, institution);
				institutionName = (String) sqlQuery.uniqueResult();
			} else {
				sqlQuery = session
						.createSQLQuery("select t.D101_02 from D101 t where t.d101_01 = ?");
				sqlQuery.setString(0, institution);
				institutionName = (String) sqlQuery.uniqueResult();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session.isConnected()){
				session.close();
			}
		}
		return institutionName;
	}
	
	public String getInstitutionArea(String institution, String institutionType, ServletContext servletContext){
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.sessionFactory = (SessionFactory)webApplicationContext.getBean("sessionFactory");
		
		Session session = null;
		String institutionArea = null;
		try {
			session = this.sessionFactory.openSession();
			SQLQuery sqlQuery = null;
			if(!"8".equals(institutionType)){
				sqlQuery = session.createSQLQuery("select t.D101_04 from D101 t where t.d101_01 = ? ");  //查询当前机构及下级机构的所属地区
				sqlQuery.setString(0, institution);
				institutionArea = (String) sqlQuery.uniqueResult();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session.isConnected()){
				session.close();
			}
		}
		return institutionArea;
	}	

	@SuppressWarnings("unchecked")
	public Map<String, Object> getInstitutionCount(String year, String institution, String institutionType,Map<String, Object> map, ServletContext servletContext,String institutionCodeA,String flag){
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.sessionFactory = (SessionFactory)webApplicationContext.getBean("sessionFactory");
		
		Session session = null;
		if(!"8".equals(institutionType)){   //市县机构单地区查询
			try {
				session = this.sessionFactory.openSession();
			
				if(institutionCodeA != null && !institutionCodeA.isEmpty()){
					//01.签发数据 
					String str01 = "select substr(t.d301_26,0,6) as 地区,";
					if("市".equals(flag)){
						str01 = "select substr(t.d301_26,0,4) as 地区,";
					}
					StringBuffer sb01 = new StringBuffer(str01);
					sb01.append("sum (case when t.d301_42 = '0'  then 1 else 0 end) as 首次签发数," +
							"sum (case when t.d301_42 in ( '2','4' )  then 1 else 0 end) as 补发数," +
							"sum (case when t.d301_42 in ( '1','3' )  then 1 else 0 end) as 换发数," +
							"sum (case when t.d301_42 = '9'  then 1 else 0 end) as 家庭接生员接生的签发数," +
							"sum (case when t.d301_42 in ( '5','6','7' ) then 1 else 0 end) as 其它情况的签发数, " +
							"d.d201_04 as 地区名" +
							" from D301 t ,D201_JS d where 1 = 1 " );
					//时间条件
					if(!StringUtil.isBlankString(year)){
						sb01.append(" and to_char(t.d301_28,'yyyy') = '");
						sb01.append(year);
						sb01.append("'");
					}
					if(!"8".equals(institutionType)){   //市县机构单地区查询
						sb01.append(" and t.d301_26 like '"+institutionCodeA+"'||'%'");
						if("市".equals(flag)){
							sb01.append(" and d.d201_01=substr(t.d301_26,0,4) ");
							sb01.append(" group by substr(t.d301_26,0,4),d.d201_04");
						}else{
							sb01.append(" and d.d201_01=substr(t.d301_26,0,6) ");
							sb01.append(" group by substr(t.d301_26,0,6),d.d201_04");
						}
					}
//					System.out.println("==========01.签发数据==========="+sb01.toString());
					SQLQuery sqlQuery01 = session.createSQLQuery(sb01.toString());
					List<Object> list01 = sqlQuery01.list();

					for (int i = 0; i < list01.size(); i++) {
						BirthCertificateCount bcc = new BirthCertificateCount();
						Object[] obj = (Object[]) list01.get(i);
						String areaCode = (String) obj[0];
						String institutionCode = areaCode + "00000001";
						if("市".equals(flag)){
							institutionCode = areaCode + "0000000001";
						}
						if(institutionCode.length() ==14){
							if (map.containsKey(institutionCode)) {// 机构存在的话，找出对象，把数据设置给对象
								bcc = (BirthCertificateCount) map.get(institutionCode);
								bcc.setQf03(Long.valueOf(obj[1] + ""));
								bcc.setQf04(Long.valueOf(obj[2] + ""));
								bcc.setQf05(Long.valueOf(obj[3] + ""));
								bcc.setQf07(Long.valueOf(obj[4] + ""));
								bcc.setQf08(Long.valueOf(obj[5] + ""));
							}else{
								bcc.setInstitutionCode(institutionCode);
								bcc.setQf03(Long.valueOf(obj[1] + ""));
								bcc.setQf04(Long.valueOf(obj[2] + ""));
								bcc.setQf05(Long.valueOf(obj[3] + ""));
								bcc.setQf07(Long.valueOf(obj[4] + ""));
								bcc.setQf08(Long.valueOf(obj[5] + ""));
								
								map.put(institutionCode, bcc);
							}
						}
					}
					
					//02.废证数据 
					String str02 = "select substr(t.d401_10,0,6) as 地区,";
					if("市".equals(flag)){
						str02 = "select substr(t.d401_10,0,4) as 地区,";
					}
					StringBuffer sb02 = new StringBuffer(str02);
					sb02.append("sum (case when t.d401_06 in ('1','2','6','7','8')  then 1 else 0 end) as 因打印或填写错误数," +
							"sum (case when t.d401_06 in ('3','4','10')  then 1 else 0 end) as 遗失数," +
							"sum (case when t.d401_06 in ( '5','9' ) then 1 else 0 end) as 其它原因数, " +
							"d.d201_04 as 地区名" +
							" from D401 t,D201_JS d " +
							" where 1 = 1 ");
					//时间条件
					if(!StringUtil.isBlankString(year)){
						sb02.append(" and to_char(t.d401_08,'yyyy') = '");
						sb02.append(year);
						sb02.append("'");
					}
					if(!"8".equals(institutionType)){   //市县机构单地区查询
						sb02.append(" and t.d401_10 like '"+institutionCodeA+"'||'%'");
						if("市".equals(flag)){
							sb02.append(" and d.d201_01=substr(t.d401_10,0,4) ");
							sb02.append(" group by substr(t.d401_10,0,4),d.d201_04");
						}else{
							sb02.append(" and d.d201_01=substr(t.d401_10,0,6) ");
							sb02.append(" group by substr(t.d401_10,0,6),d.d201_04");
						}
					}
//					System.out.println("==========02.废证数据 ==========="+sb02.toString());
					SQLQuery sqlQuery02 = session.createSQLQuery(sb02.toString());
					List<Object> list02 = sqlQuery02.list();

					for (int i = 0; i < list02.size(); i++) {
						BirthCertificateCount bcc = new BirthCertificateCount();
						Object[] obj = (Object[]) list02.get(i);
						String areaCode = (String) obj[0];
						String institutionCode = areaCode + "00000001";
						if("市".equals(flag)){
							institutionCode = areaCode + "0000000001";
						}
						if(institutionCode.length() ==14){
							if (map.containsKey(institutionCode)) {// 机构存在的话，找出对象，把数据设置给对象
								bcc = (BirthCertificateCount) map.get(institutionCode);
								bcc.setFz10(Long.valueOf(obj[1] + ""));
								bcc.setFz11(Long.valueOf(obj[2] + ""));
								bcc.setFz12(Long.valueOf(obj[3] + ""));
							} else {// 机构不存在的话，添加新对象
								bcc.setInstitutionCode(institutionCode);
								bcc.setFz10(Long.valueOf(obj[1] + ""));
								bcc.setFz11(Long.valueOf(obj[2] + ""));
								bcc.setFz12(Long.valueOf(obj[3] + ""));

								map.put(institutionCode, bcc);
							}
						}
					}
					
					//05.活产数
					String str06 = "select substr(t.d601_02,0,6) as 地区,";
					if("市".equals(flag)){
						str06 = "select substr(t.d601_02,0,4) as 地区,";
					}
					StringBuffer sb06 = new StringBuffer(str06);
					sb06.append("count(1) as 当年机构内活产数, " +
							"d.d201_04 as 地区名 " +
							" from D601 t,D201_JS d " +
							" where 1 = 1 and t.d601_48 in ('1','4')");
					//时间条件
					if(!StringUtil.isBlankString(year)){
						sb06.append(" and to_char(t.d601_03,'yyyy') = '");
						sb06.append(year);
						sb06.append("'");
					}
					if(!"8".equals(institutionType)){
						sb06.append(" and t.d601_02 like '"+institutionCodeA+"'||'%'");
						if("市".equals(flag)){
							sb06.append(" and d.d201_01=substr(t.d601_02,0,4) ");
							sb06.append(" group by substr(t.d601_02,0,4),d.d201_04");
						}else{
							sb06.append(" and d.d201_01=substr(t.d601_02,0,6) ");
							sb06.append(" group by substr(t.d601_02,0,6),d.d201_04");
						}
					}
					
//					System.out.println("==========05.活产数 ==========="+sb06.toString());
					SQLQuery sqlQuery06 = session.createSQLQuery(sb06.toString());
					List<Object> list06 = sqlQuery06.list();

					for (int i = 0; i < list06.size(); i++) {
						BirthCertificateCount bcc = new BirthCertificateCount();
						Object[] obj = (Object[]) list06.get(i);
						String areaCode = (String) obj[0];
						String institutionCode = areaCode + "00000001";
						if("市".equals(flag)){
							institutionCode = areaCode + "0000000001";
						}
						if(institutionCode.length() ==14){
							if (map.containsKey(institutionCode)) {// 机构存在的话，找出对象，把数据设置给对象
								bcc = (BirthCertificateCount) map.get(institutionCode);
								bcc.setHc16(Long.valueOf(obj[1] + ""));
							} else {// 机构不存在的话，添加新对象
								bcc.setInstitutionCode(institutionCode);
								bcc.setHc16(Long.valueOf(obj[1] + ""));
								
								map.put(institutionCode, bcc);
							}
						}
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(session.isConnected()){
					session.close();
				}
			}
		}
		return map;
	}


}
