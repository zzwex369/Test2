<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "../../GenXmlData.jsp" %>
<%
 //  System.out.println(">>>>>>>>>>");
String timeStr=request.getParameter("timeStr");
String timeEnd=request.getParameter("timeEnd");
String institution=request.getParameter("institution");
int institutionType = institution.length();

		
		StringBuffer sql = new StringBuffer("select ");
	//	sql.append("d201_04,sum(a) ZRS,sum(aa) TRRS,sum(aaa) JCRS from(");
	//	sql.append("select d201_04, count(e301_01) a,0 as aa, 0 as aaa");
	//	sql.append(" from d201_ms d, e301 e ");
		//sql.append("  where d.d201_01 = substr(e.e301_16, 0, 6) ");
		if(institutionType == 4){
			sql.append("d201_04,sum(a) ZRS,sum(aa) TRRS,sum(aaa) JCRS from(");
			sql.append("select d201_04, count(e301_01) a,0 as aa, 0 as aaa");
			sql.append(" from d201_ms d, e301 e ");
			sql.append("  where d.d201_01 = substr(e.e301_16, 0, 6) ");
		}else {
			sql.append("D101_02,sum(a) ZRS,sum(aa) TRRS,sum(aaa) JCRS from(");
			sql.append("select D101_02, count(e301_01) a,0 as aa, 0 as aaa");
			sql.append(" from D101 D,e301 e  where ");
			sql.append((institutionType == 14?"E301_16 = '"+institution+"'  ":" E301_16 like '"+institution+"%'  "));
			sql.append("and d.d101_01 = e.e301_16 ");
		}
		
		sql.append("  and to_number((sysdate - e.e301_06)) / 365 < 7 ");
		sql.append(" and e301_31 >= to_date('"+timeStr+"','yyyy-mm-dd') ");
		sql.append(" and e301_31 <= to_date('"+timeEnd+"','yyyy-mm-dd') ");
	//	sql.append(" group by d201_04 ");
		sql.append((institutionType == 4?"group by d201_04 ":" group by D101_02 "));
		sql.append(" union all ");
		
	//	sql.append(" select d201_04,0 as aa,count(e303_02),0 as aaa");
	//	sql.append(" from e301 t, e303 e, d201_ms d ");
	//	sql.append("  where t.e301_01 = e.e303_02 ");
		//sql.append(" and d.d201_01 = substr(t.e301_16, 0, 6) ");
	//	if(institution.length()==6){
	//	sql.append("  and d.d201_01 = '"+institution+"' ");
	//	}else {
	//		sql.append("  and d.d201_01 = substr(t.e301_16, 0, 6) ");
	//	}
		
		if(institutionType == 4){
			sql.append(" select d201_04,0 as aa,count(e303_02),0 as aaa");
			sql.append(" from e301 t, e303 e, d201_ms d ");
			sql.append("  where t.e301_01 = e.e303_02 ");
			sql.append("  and d.d201_01 = substr(t.e301_16, 0, 6) ");
			sql.append(" and substr(e.e303_13, 0, 6) = substr(t.e301_16, 0, 6) ");
		}else {
			sql.append(" select D101_02,0 as aa,count(e303_02),0 as aaa");
			sql.append(" from e301 t, e303 e,D101 d ");
			sql.append("  where t.e301_01 = e.e303_02 "); 
			sql.append((institutionType == 14?" and E301_16 = '"+institution+"' ":"and E301_16 like '"+institution+"%' "));
			sql.append("and d.d101_01 = t.e301_16 ");
			sql.append(" and e.e303_13 = t.e301_16 ");
		}
		
	//	sql.append(" and substr(e.e303_13, 0, 6) = substr(t.e301_16, 0, 6) ");
		sql.append(" and to_number((sysdate - t.e301_06)) / 365 < 5 ");
		sql.append(" and e.e303_15 = 4 ");
		sql.append(" and e301_31 >= to_date('"+timeStr+"','yyyy-mm-dd') ");
		sql.append(" and e301_31 <= to_date('"+timeEnd+"','yyyy-mm-dd') ");
	//	sql.append("  group by d201_04 ");
		sql.append((institutionType == 4?"group by d201_04 ":"group by D101_02 "));
		sql.append("   union all ");
	//	sql.append("  select d201_04,0 as aa,0 as a,count(*) as aaa from d201_ms,e702 ");
		//sql.append("  where d201_01 = substr("+institution+",0,6) ");
	/*	if(institution.length()==6){
			sql.append("  where d201_01 = '"+institution+"' ");
		}else {
			sql.append("  where d201_01 = substr(e702_71,0,6)");
		}*/
		
		if(institutionType == 4){
			sql.append("  select d201_04,0 as aa,0 as a,count(*) as aaa from d201_ms,e702 ");
			sql.append("  where d201_01 = substr(e702_71,0,6)");
		}else {
			sql.append("  select D101_02,0 as aa,0 as a,count(*) as aaa from e702,D101  ");
			sql.append((institutionType == 14?"where E702_71 = '"+institution+"' ":"where E702_71 like '"+institution+"%' "));
			sql.append("and d101_01 = e702_71 ");
		}
		
		sql.append("   and e702_09 = 1 ");
		sql.append("  and to_number((sysdate -e702_73 )) / 365 < 7 ");
		sql.append("   and e702_73 >= to_date('"+timeStr+"','yyyy-mm-dd') ");
		sql.append("   and e702_73 <= to_date('"+timeEnd+"','yyyy-mm-dd') ");
	//	sql.append("  group by d201_04) ");
	//	sql.append("   group by d201_04 ");
		sql.append((institutionType == 4?"group by d201_04) group by d201_04 ":"group by D101_02) group by D101_02 "));



//	 System.out.println(sql);


%>
<%
XML_GenOneRecordset(response,sql.toString());
%>