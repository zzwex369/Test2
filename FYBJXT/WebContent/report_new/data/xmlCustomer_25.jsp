 <%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
String date_start=request.getParameter("date_satrt");
String date_end=request.getParameter("date_end");
String institution=request.getParameter("institution");
String l302DateStart=" and l302_120 >= to_date('"+date_start+"','yyyy-mm-dd') ";
String l302DateEnd=" and l302_120 <= to_date('"+date_end+"','yyyy-mm-dd') ";
String l402DateStart=" and l402_125 >= to_date('"+date_start+"','yyyy-mm-dd') ";
String l402DateEnd=" and l402_125 <= to_date('"+date_end+"','yyyy-mm-dd') ";
StringBuffer sql = new StringBuffer();
sql.append("select max(fk) as fk,");
sql.append("max(tp) as tp,");
sql.append("max(ydj) as ydj,");
sql.append("max(zz) as zz,");
sql.append("max(xxgj) as xxgj,");
sql.append("max(rx) as rx,");
sql.append("max(cc) as cc,");
sql.append("max(xx) as xx,");
sql.append("max(xxrx) as xxrx,");
sql.append("l301_02 as name,l301_04 as card,");
sql.append("l301_10 as phone,l301_11Zh as address,");
sql.append("'"+date_start+"' as date_start,'"+date_end+"' as date_end ");
sql.append("from (select l302_61 as fk,null as tp,");
sql.append("null as ydj,null as zz,null as xxgj,null as rx,null as cc,");
sql.append("null as xx,null as xxrx,l301_02,l301_04,l301_10,l301_11Zh,l301_19 ");
sql.append("from (select l302_02,l302_59,l302_61,l302_120 from l302),");
sql.append("(select l301_01,l301_02,l301_04,l301_10,l301_11Zh,l301_19 ");
sql.append("from v_l301)where l302_02 = l301_01"+l302DateStart+l302DateEnd);
sql.append("and l302_59 like '%"+institution+"%'");
sql.append("group by l301_02,l301_04,l301_10,l301_11Zh,l301_19,l302_61 ");
sql.append("union all select null as fk,l302_78 as tp,null as ydj,");
sql.append("null as zz,null as xxgj,null as rx,null as cc,null as xx,null as xxrx,");
sql.append("l301_02,l301_04,l301_10,l301_11Zh,l301_19  from ");
sql.append("(select l302_02,l302_76,l302_78,l302_120 from l302),");
sql.append("(select l301_01,l301_02,l301_04,l301_10,l301_11Zh,l301_19 ");
sql.append("from v_l301)where l302_02 = l301_01"+l302DateStart+l302DateEnd);
sql.append("and l302_76 like '%"+institution+"%' ");
sql.append("group by l301_02,l301_04,l301_10,l301_11Zh,l301_19,l302_78 union all ");
sql.append("select null as fk,null as tp,l302_94 as ydj, null as zz,");
sql.append("null as xxgj,null as rx,null as cc, null as xx,null as xxrx,");
sql.append("l301_02,l301_04,l301_10,l301_11Zh,l301_19 ");
sql.append("from (select l302_02,l302_92,l302_94,l302_120 from l302 where l302_85='1'),");
sql.append("(select l301_01,l301_02,l301_04,l301_10,l301_11Zh,l301_19 ");
sql.append("from v_l301)where l302_02 = l301_01"+l302DateStart+l302DateEnd);
sql.append("and l302_92 like '%"+institution+"%' ");
sql.append("group by l301_02,l301_04,l301_10,l301_11Zh,l301_19,l302_94 ");
sql.append("union all select null as fk,null as tp, null as ydj,l302_100 as zz,");
sql.append("null as xxgj,null as rx,null as cc,null as xx,null as xxrx,");
sql.append("l301_02,l301_04,l301_10,l301_11Zh,l301_19 from ");
sql.append("(select l302_02,l302_98,l302_100,l302_120 from l302),");
sql.append("(select l301_01,l301_02,l301_04,l301_10,l301_11Zh,l301_19 ");
sql.append("from v_l301) where l302_02 = l301_01 "+l302DateStart+l302DateEnd);
sql.append("and l302_98 like '%"+institution+"%' group by l301_02,l301_04,l301_10,l301_11Zh,l301_19,l302_100 ");
sql.append("union all select null as fk,null as tp,null as ydj,null as zz,l302_120 as xxgj,");
sql.append("null as rx,null as cc,null as xx,null as xxrx,l301_02,l301_04,l301_10,l301_11Zh,l301_19 ");
sql.append("from (select l302_02,l302_118,l302_120 from l302),");
sql.append("(select l301_01,l301_02,l301_04,l301_10,l301_11Zh,l301_19 ");
sql.append("from v_l301)where l302_02 = l301_01"+l302DateStart+l302DateEnd);
sql.append("and l302_118 like '%"+institution+"%' ");
sql.append("group by l301_02,l301_04,l301_10,l301_11Zh,l301_19,l302_120  union all ");
sql.append("select null as fk,null as tp,null as ydj,null as zz,null as xxgj,l402_46 as rx,");
sql.append("null as cc,null as xx,null as xxrx,l301_02,l301_04,l301_10,l301_11Zh,l301_19 ");
sql.append("from (select l402_02,l402_44,l402_46,l402_125 from l402),");
sql.append("(select l301_01,l301_02,l301_04,l301_10,l301_11Zh,l301_19 ");
sql.append("from v_l301)where l402_02 = l301_01"+l402DateStart+l402DateEnd);
sql.append("and l402_44 like '%"+institution+"%' ");
sql.append("group by l301_02,l301_04,l301_10,l301_11Zh,l301_19,l402_46 union all ");
sql.append("select null as fk,null as tp,null as ydj,null as zz,null as xxgj,null as rx,");
sql.append("l402_86 as cc,null as xx,null as xxrx,");
sql.append("l301_02,l301_04,l301_10,l301_11Zh,l301_19 from ");
sql.append("(select l402_02,l402_84,l402_86,l402_125 from l402),(select l301_01,l301_02,l301_04,l301_10,l301_11Zh,l301_19 ");
sql.append("from v_l301) where l402_02 = l301_01"+l402DateStart+l402DateEnd);
sql.append("and l402_84 like '%"+institution+"%' group by l301_02,l301_04,l301_10,l301_11Zh,l301_19,l402_86 ");
sql.append("union all select null as fk,null as tp,null as ydj,null as zz,null as xxgj,null as rx,");
sql.append("null as cc,l402_104 as xx,null as xxrx,l301_02,l301_04,l301_10,l301_11Zh,l301_19 ");
sql.append("from (select l402_02,l402_102,l402_104,l402_125 from l402),(select l301_01,l301_02,l301_04,l301_10,l301_11Zh,l301_19 ");
sql.append("from v_l301) where l402_02 = l301_01"+l402DateStart+l402DateEnd);
sql.append("and l402_102 like '%"+institution+"%' group by l301_02,l301_04,l301_10,l301_11Zh,l301_19,l402_104 ");
sql.append("union all select null as fk,null as tp,null as ydj,null as zz,null as xxgj,null as rx,null as cc,");
sql.append("null as xx,l402_125 as xxrx,l301_02,l301_04,l301_10,l301_11Zh,l301_19 ");
sql.append("from (select l402_02,l402_123,l402_125 from l402),(select l301_01,l301_02,l301_04,l301_10,l301_11Zh,l301_19 ");
sql.append("from v_l301) where l402_02 = l301_01"+l402DateStart+l402DateEnd);
sql.append("and l402_123 like '%"+institution+"%' group by l301_02,l301_04,l301_10,l301_11Zh,l301_19,l402_125)a ");
sql.append("group by l301_02,l301_04,l301_10,l301_11Zh,l301_19 order by l301_19");

//System.out.println(sql);
%>
<%
XML_GenOneRecordset(response,sql.toString());
%>