<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "../GenXmlData.jsp" %>
<%
String date_start=request.getParameter("date_start");
String date_end=request.getParameter("date_end");
String institution=request.getParameter("institution");
String dateStart=">= to_date('"+date_start+"','yyyy-mm-dd') ";
String dateEnd="<= to_date('"+date_end+"','yyyy-mm-dd') ";


StringBuffer sql = new StringBuffer("select ");
sql.append("sum(decode(a.fk,0,fk,fk)) as fk,");
sql.append("sum(decode(a.tp,0,tp,tp)) as tp,");
sql.append("sum(decode(a.ydj,0,ydj,ydj)) as ydj,");
sql.append("sum(decode(a.zz,0,zz,zz)) as zz,");
sql.append("sum(decode(a.xxgj,0,xxgj,xxgj)) as xxgj,");
sql.append("sum(decode(a.rx,0,rx,rx)) as rx,");
sql.append("sum(decode(a.cc,0,cc,cc)) as cc,");
sql.append("sum(decode(a.xx,0,xx,xx)) as xx,");
sql.append("sum(decode(a.xxrx,0,xxrx,xxrx)) as xxrx,");
sql.append("d101_02, d101_01,'"+date_start+"' as date_start,'"+date_end+"' as date_end from ");
sql.append("(select count(l302_59) as fk,0 as tp,0 as ydj,");
sql.append("0 as zz,0 as xxgj,0 as rx,0 as cc,0 as xx,0 as xxrx,");
sql.append("d101_02, d101_01 from (select d101_02, d101_01 ");
sql.append("from d101 where d101_01 like '%"+institution+"%'),");
sql.append("(select l302_59 from l302 where l302_61 "+dateStart+"and l302_61 "+dateEnd+")");
sql.append("where l302_59 = d101_01 group by d101_02, d101_01 ");
sql.append("union all select 0 as fk,count(l302_76) as tp,0 as ydj,");
sql.append("0 as zz,0 as xxgj,0 as rx,0 as cc,0 as xx,0 as xxrx,");
sql.append("d101_02, d101_01 from (select d101_02, d101_01 ");
sql.append("from d101 where d101_01 like '%"+institution+"%'),(select l302_76 ");
sql.append("from l302 where l302_78 "+dateStart+"and l302_78 "+dateEnd+")");
sql.append("where l302_76 = d101_01 group by d101_02, d101_01 ");
sql.append("union all select 0 as fk,0 as tp, count(l302_92) as ydj,");
sql.append("0 as zz,0 as xxgj,0 as rx,0 as cc,0 as xx,0 as xxrx,");
sql.append("d101_02, d101_01 from (select d101_02, d101_01 ");
sql.append("from d101 where d101_01 like '%"+institution+"%'),");
sql.append("(select l302_92 from l302 where l302_85='1' and l302_94 "+dateStart+"and l302_94 "+dateEnd+")");
sql.append("where l302_92 = d101_01 group by d101_02, d101_01 ");
sql.append("union all select 0 as fk,0 as tp,0 as ydj,");
sql.append("count(l302_98) as zz,0 as xxgj,0 as rx,0 as cc,");
sql.append("0 as xx,0 as xxrx, d101_02,d101_01 from ");
sql.append("(select d101_02, d101_01 from d101 ");
sql.append("where d101_01 like '%"+institution+"%'),");
sql.append("(select l302_98 from l302 where l302_100 "+dateStart+"and l302_100 "+dateEnd+")");
sql.append("where l302_98 = d101_01 group by d101_02, d101_01 ");
sql.append("union all select 0 as fk,0 as tp,0 as ydj,");
sql.append("0 as zz,count(l302_118) as xxgj,0 as rx,");
sql.append("0 as cc,0 as xx,0 as xxrx, d101_02, d101_01 ");
sql.append("from (select d101_02, d101_01 from d101 ");
sql.append("where d101_01 like '%"+institution+"%'),(select l302_118 ");
sql.append("from l302 where l302_120 "+dateStart+"and l302_120 "+dateEnd+")");
sql.append("where l302_118 = d101_01 group by d101_02, d101_01 ");
sql.append("union all select 0 as fk,0 as tp,0 as ydj,");
sql.append("0 as zz,0 as xxgj, count(l402_44) as rx,");
sql.append("0 as cc,0 as xx,0 as xxrx, d101_02, d101_01 ");
sql.append("from (select d101_02, d101_01 from d101 ");
sql.append("where d101_01 like '%"+institution+"%'),(select l402_44 ");
sql.append("from l402 where l402_46 "+dateStart+"and l402_46 "+dateEnd+")");
sql.append("where l402_44 = d101_01 group by d101_02, d101_01 ");
sql.append("union all select 0 as fk,0 as tp,0 as ydj,0 as zz,");
sql.append("0 as xxgj,0 as rx,count(l402_84) as cc,0 as xx,");
sql.append("0 as xxrx, d101_02, d101_01 from (select d101_02,");
sql.append("d101_01 from d101 where d101_01 like '%"+institution+"%'),");
sql.append("(select l402_84 from l402 where l402_86 "+dateStart+"and l402_86 "+dateEnd+")");
sql.append("where l402_84 = d101_01 group by d101_02, d101_01 ");
sql.append("union all select 0 as fk,0 as tp,0 as ydj,0 as zz,");
sql.append("0 as xxgj,0 as rx,0 as cc,count(l402_102) as xx,");
sql.append("0 as xxrx, d101_02, d101_01 from (select d101_02, d101_01 ");
sql.append("from d101 where d101_01 like '%"+institution+"%'),(select l402_102 ");
sql.append("from l402 where l402_104 "+dateStart+"and l402_104 "+dateEnd+")");
sql.append("where l402_102 = d101_01 group by d101_02, d101_01 ");
sql.append("union all select 0 as fk,0 as tp,0 as ydj,0 as zz,");
sql.append("0 as xxgj,0 as rx,0 as cc,0 as xx,count(l402_123) as xxrx, d101_02, d101_01 ");
sql.append("from (select d101_02, d101_01 from d101 where d101_01 like '%"+institution+"%'),");
sql.append("(select l402_123 from l402 where l402_125 "+dateStart+"and l402_125 "+dateEnd+")");
sql.append("where l402_123 = d101_01 group by d101_02, d101_01 ");
sql.append(") a  group by d101_02, d101_01 order by d101_01");


//System.out.println(sql.toString());
%>

<%
XML_GenOneRecordset(response,sql.toString());
%>
