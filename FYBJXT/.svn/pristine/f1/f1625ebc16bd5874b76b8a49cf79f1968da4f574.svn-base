<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData_msmxb.jsp" %>
<%
String dateStr= request.getParameter("dateStr");
String dateEnd= request.getParameter("dateEnd");
StringBuffer sql=new StringBuffer();
sql.append("select substr(a.d201_04,1,4) as 县区,");
sql.append("count(t.l301_01) as 档案人数,");
sql.append("count(case when t.l301_33='1' then t.l301_33 end) as 宫颈癌检查人数,");
sql.append("count(case when t.l301_33='1' and t.l301_29='1' then t.l301_29 end) as 农村低保,");
sql.append("count(case when t.l301_33='1' and t.l301_30='1' then t.l301_30 end) as 城市低保,");
sql.append("count(case when t.l301_34='1' then t.l301_34 end) as 乳腺癌检查人数,");
sql.append("count(case when t.l301_34='1' and t.l301_29='1'  then t.l301_29 end) as 农村低保1,");
sql.append("count(case when t.l301_34='1' and t.l301_30='1'  then t.l301_30 end) as 城市低保1");
sql.append(" from L301 t ,D201_MS a  ");
sql.append(" where t.l301_19>=to_date('"+dateStr+"','yyyy-mm-dd') and t.l301_19<=to_date('"+dateEnd+"','yyyy-mm-dd')");
sql.append(" and substr(t.l301_17,1,6)=a.d201_01");
sql.append(" group by a.d201_04 ");
System.out.print(sql);
%>
<%
	XML_GenOneRecordset(response,sql.toString());
%>
