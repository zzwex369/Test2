<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "../../GenXmlData.jsp" %>
<%
 //  System.out.println(">>>>>>>>>>");
String timeStr=request.getParameter("timeStr");//开始时间
String timeEnd=request.getParameter("timeEnd");//结束时间
String institution=request.getParameter("institution");//机构编码
String date=request.getParameter("date");//录入时间 或 检查时间 或 下次检查时间

		StringBuffer sql = new StringBuffer("");
		sql.append((institution.length() >= 6?"select e702_71zh,sum(YCRS) e,":"select d201_04, sum(YCRS) e,"));
		
		sql.append("sum(JCRS) c from(");
		//sql.append("select d201_04,0 as YCRS, count(*) as JCRS");
		sql.append((institution.length() >= 6?"select e702_71zh,0 as YCRS, count(*) as JCRS ":"select d201_04,0 as YCRS, count(*) as JCRS "));
		//sql.append(" from d201_ms,e702 ");
		sql.append((institution.length() >= 6?" from v_e702 ":" from d201_ms,v_e702 "));
		//sql.append(" where d201_01 = substr("+institution+",0,6)");
	/*	if(institution.length() > 4){
			sql.append(" where d201_01 = substr("+institution+",0,6)");
		}else{
			sql.append(" where d201_01 like '"+institution+"__'");
		}*/
		sql.append((institution.length() >= 14?" where e702_71 =  '"+institution+"' ":" where e702_71 like '"+institution+"%' "));
		if(institution.length() >= 6){
			sql.append(" ");
		}else {
			sql.append(" and substr(e702_71,0,6) = d201_01 ");
		}
		sql.append(" and e702_09 = 1  and e702_02 = e701_01 ");
		//sql.append(" and e702_73 >= to_date('"+timeStr+"','yyyy-mm-dd') ");
		//sql.append(" and e702_73 <= to_date('"+timeEnd+"','yyyy-mm-dd') ");
		if(date.equals('0')){
			sql.append(" and to_char(e702_73,'yyyy--mm-dd') >= '"+timeStr+"' ");
			sql.append(" and to_char(e702_73,'yyyy--mm-dd') <= '"+timeEnd+"' ");
		}else if(date.equals('1')){
			sql.append(" and to_char(e702_70,'yyyy--mm-dd') >= '"+timeStr+"' ");
			sql.append(" and to_char(e702_70,'yyyy--mm-dd') <= '"+timeEnd+"' ");
		}else if(date.equals('2')){
			sql.append(" and to_char(e702_67,'yyyy--mm-dd') >= '"+timeStr+"' ");
			sql.append(" and to_char(e702_67,'yyyy--mm-dd') <= '"+timeEnd+"' ");
		}
		//sql.append("  group by d201_04 ");
		sql.append((institution.length() >= 6?" group by e702_71zh ":" group by d201_04"));
		sql.append(" union all ");
	//	sql.append(" select d201_04,count(*) as YCRS,0 as JCRS  ");
		sql.append((institution.length() >= 6?"select e702_71zh,count(*) as YCRS, 0 as JCRS":"select d201_04,count(*) as YCRS, 0 as JCRS "));
	//	sql.append(" from d201_ms,e702 ");
		sql.append((institution.length() >= 6?" from v_e702 ":" from d201_ms,v_e702 "));
		//sql.append(" where d201_01 = substr("+institution+",0,6) ");
	/*	if(institution.length() > 4){
			sql.append(" where d201_01 = substr("+institution+",0,6)");
		}else{
			sql.append(" where d201_01 like '"+institution+"__'");
		}*/
		sql.append((institution.length() >= 14?" where e702_71 =  '"+institution+"' ":" where e702_71 like '"+institution+"%' "));
		if(institution.length() >= 6){
			sql.append("  ");
		}else {
			sql.append(" and substr(e702_71,0,6) = d201_01 ");
		}
		sql.append("  and e702_09 = 1  and e702_02 = e701_01 ");
		sql.append("  and e702_60 = 2 ");
	//	sql.append(" and e702_73 >= to_date('"+timeStr+"','yyyy-mm-dd') ");
	//	sql.append(" and e702_73 <= to_date('"+timeEnd+"','yyyy-mm-dd') ");
		if(date.equals('0')){
			sql.append(" and to_char(e702_73,'yyyy--mm-dd') >= '"+timeStr+"' ");
			sql.append(" and to_char(e702_73,'yyyy--mm-dd') <= '"+timeEnd+"' ");
		}else if(date.equals('1')){
			sql.append(" and to_char(e702_70,'yyyy--mm-dd') >= '"+timeStr+"' ");
			sql.append(" and to_char(e702_70,'yyyy--mm-dd') <= '"+timeEnd+"' ");
		}else if(date.equals('2')){
			sql.append(" and to_char(e702_67,'yyyy--mm-dd') >= '"+timeStr+"' ");
			sql.append(" and to_char(e702_67,'yyyy--mm-dd') <= '"+timeEnd+"' ");
		}
		sql.append((institution.length() >= 6?" group by e702_71zh) group by e702_71zh ":" group by d201_04) group by d201_04 "));
		//sql.append(" group by d201_04) ");
		//sql.append(" group by d201_04 ");



//	 System.out.println(sql);

%>
<%
XML_GenOneRecordset(response,sql.toString());
%>