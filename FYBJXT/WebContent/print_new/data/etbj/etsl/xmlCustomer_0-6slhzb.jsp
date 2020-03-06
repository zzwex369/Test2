<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../GenXmlData.jsp"%>
<%!
	private String getDateFormat(String field,String dateStr,String dateEnd){
		
		return " and to_char("+field+",'yyyy-mm-dd')>='"+
		dateStr+"' and to_char("+field+",'yyyy-mm-dd')<='"
		+dateEnd+"' group by d101_01,d101_02 ";
	}
	
	private String getD101(String code){
		return  "(select d101_01,d101_02 from d101 where d101_11='"+code+"' or d101_01='"+code+"')";
		
	}
 %>
<%
	String dateStr= request.getParameter("dateStr");//开始时间
	String dateEnd= request.getParameter("dateEnd");//结束时间
	String code= request.getParameter("code");//机构编码        
	String time= request.getParameter("time");//录入时间 或 检查 时间    
	String person= request.getParameter("person");//人数查询 或 人次查询  
	
	
	StringBuffer sql = new StringBuffer("select d101_02 name,d101_01 code,max(sl_0) sl_0,");		
				sql.append("max(sl_1_3) sl_1_3,max(sl_3_5) sl_3_5, max(sl_6) sl_6,");
				sql.append("max(sl_yey) sl_yey,max(sl_pro_6) sl_pro_6 from(");
				sql.append("select d101_02,d101_01,");
				sql.append(("1".equals(person)?"count(distinct E305_78) sl_0,":"count(*) sl_0,"));
				sql.append("0 sl_1_3,0 sl_3_5,0 sl_6,0 sl_yey,0 sl_pro_6 from e305 t,");
				sql.append("e301,"+getD101(code)+" where e305_78 = e301_01 and e305_81 =d101_01 ");
				sql.append("and e305_95 is not null ");
			/*	if("1".equals(time)){
					sql.append(getDateFormat("e305_100",dateStr,dateEnd));
				}else if("2".equals(time)){
					sql.append(getDateFormat("e305_74",dateStr,dateEnd));
				}*/
				sql.append(("1".equals(time)?getDateFormat("e305_100",dateStr,dateEnd):getDateFormat("e305_74",dateStr,dateEnd)));
				sql.append(" union all ");
				sql.append("select d101_02,d101_01,0 sl_0, ");
				sql.append(("1".equals(person)?"count(distinct E304_40) sl_1_3,":"count(*) sl_1_3,"));
				sql.append("0 sl_3_5,0 sl_6,0 sl_yey,0 sl_pro_6 from e304,"+getD101(code)+",e301 where ");
				sql.append("e304_40=e301_01 and e304_02 > 0 and e304_02 < 20 ");
 				sql.append("and e304_45 = d101_01 and e304_98 is not null");
				//sql.append(getDateFormat("e304_04",dateStr,dateEnd));
			/*	if("1".equals(time)){
					sql.append(getDateFormat("e304_51",dateStr,dateEnd));
				}else if("2".equals(time)){
					sql.append(getDateFormat("e304_04",dateStr,dateEnd));
				}*/
				sql.append(("1".equals(time)?getDateFormat("e304_51",dateStr,dateEnd):getDateFormat("e304_04",dateStr,dateEnd)));
				sql.append(" union all ");
				sql.append("select d101_02,d101_01,0 sl_0,0 sl_1_3,count(*) sl_3_5,0 sl_6,");
				sql.append("0 sl_yey,0 sl_pro_6 from e702,e701,"+getD101(code)+" where e702_02=e701_01 ");
				sql.append("and e702_08>19 and e702_08<31 and e702_09 = '1' and e702_71=d101_01 ");
				//sql.append(getDateFormat("e702_70",dateStr,dateEnd));
			/*	if("1".equals(time)){
					sql.append(getDateFormat("e702_73",dateStr,dateEnd));
				}else if("2".equals(time)){
					sql.append(getDateFormat("e702_70",dateStr,dateEnd));
				}*/
				sql.append(("1".equals(time)?getDateFormat("e702_73",dateStr,dateEnd):getDateFormat("e702_70",dateStr,dateEnd)));
				sql.append(" union all ");
				sql.append("select d101_02,d101_01,0 sl_0,0 sl_1_3,0 sl_3_5,count(*) sl_6,");
				sql.append("0 sl_yey,0 sl_pro_6 from e702,e701,"+getD101(code)+" where e702_02=e701_01 ");
      			sql.append("and e702_08='32' and e702_09='1' and e702_71=d101_01 ");
      		/*	if("1".equals(time)){
					sql.append(getDateFormat("e702_73",dateStr,dateEnd));
				}else if("2".equals(time)){
					sql.append(getDateFormat("e702_70",dateStr,dateEnd));
				}*/
				sql.append(("1".equals(time)?getDateFormat("e702_73",dateStr,dateEnd):getDateFormat("e702_70",dateStr,dateEnd)));
				sql.append(" union all ");
				sql.append("select d101_02,d101_01,0 sl_0,0 sl_1_3,0 sl_3_5,0 sl_6,");
				sql.append(("1".equals(person)?"count(distinct E702_02) sl_yey,":"count(*) sl_yey,"));
				sql.append("0 sl_pro_6 from e702,e701,"+getD101(code)+" where e702_02=e701_01 and e702_08 > 19 ");
				sql.append("and e702_08<33 and e702_09='1' and e702_04 is not null and e702_71=d101_01");
			   // sql.append(getDateFormat("e702_70",dateStr,dateEnd));
			 /*   if("1".equals(time)){
					sql.append(getDateFormat("e702_73",dateStr,dateEnd));
				}else if("2".equals(time)){
					sql.append(getDateFormat("e702_70",dateStr,dateEnd));
				}*/
				sql.append(("1".equals(time)?getDateFormat("e702_73",dateStr,dateEnd):getDateFormat("e702_70",dateStr,dateEnd)));
				sql.append("union all ");
				sql.append("select d101_02,d101_01,0 sl_0,0 sl_1_3,0 sl_3_5,0 sl_6,0 sl_yey,");
				sql.append("count(*) sl_pro_6 from e702,e701,"+getD101(code)+" where e702_02 = e701_01 ");
				sql.append("and e702_08 = '32' and e702_09 = '1' and e702_29 != '1' and e702_71 = d101_01 ");
				sql.append("and (trim(e702_34) <= '0.8' or trim(e702_35) <= '0.8')");
				//sql.append(getDateFormat("e702_70",dateStr,dateEnd)+") group by d101_02, d101_01 order by d101_01");
			/*	if("1".equals(time)){
					sql.append(getDateFormat("e702_73",dateStr,dateEnd));
				}else if("2".equals(time)){
					sql.append(getDateFormat("e702_70",dateStr,dateEnd));
				}*/
				sql.append(("1".equals(time)?getDateFormat("e702_73",dateStr,dateEnd):getDateFormat("e702_70",dateStr,dateEnd)));
				sql.append(") group by d101_02, d101_01 order by d101_01");
   //System.out.println(sql);

%>

<%
XML_GenOneRecordset(response,sql.toString());
%>