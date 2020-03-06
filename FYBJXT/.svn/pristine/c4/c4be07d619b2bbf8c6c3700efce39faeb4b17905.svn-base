 <%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
String address_status=request.getParameter("address_status");
String address=request.getParameter("address");
String date_status=request.getParameter("date_status");
String date_satrt=request.getParameter("date_satrt");
String date_end=request.getParameter("date_end");
String institution=request.getParameter("institution");
StringBuffer sql = new StringBuffer();
sql.append("select t.l301_02 as 姓名 ,t.l301_06 as 年龄,t.l301_04 as 身份证号 ,a.d201_05 as 现住地址,case t.l301_29 when '1' THEN '√ ' ELSE '' END as 建档立卡 ,case t.l301_30 when '1' THEN '√ ' ELSE '' END as 城市低保 ,case  when (t.l301_29='2' and t.l301_30='2') THEN '√ '  ELSE ''  END as 低保户 ,case t.l301_33 when '1' THEN '√ ' ELSE '' END as 宫颈癌检查 ,case t.l301_34 when '1' THEN '√ ' ELSE '' END as 乳腺癌检查 ,t.l301_16 as 卡号,b.d101_02 as 初筛单位,t.l301_28 as 筛查日期  from l301 t,d201_ms a,d101 b where ");
sql.append("t.l301_17 like '%"+institution+"%'");
if("0".equals(address_status)){
sql.append(" and t.l301_11 like '%"+address+"%'");
}
if("1".equals(address_status)){
sql.append(" and t.l301_13 like '%"+address+"%'");
}
if("2".equals(address_status)){
	
}
if("0".equals(date_status)){
sql.append(" and t.l301_19>=to_date('"+date_satrt+"','yyyy-mm-dd')");
sql.append(" and t.l301_19<=to_date('"+date_end+"','yyyy-mm-dd')");
}
if("1".equals(date_status)){
sql.append(" and t.l301_28>=to_char(to_date('"+date_satrt+"','yyyy-mm-dd'),'yyyy-mm-dd')");
sql.append(" and t.l301_28<=to_char(to_date('"+date_end+"','yyyy-mm-dd'),'yyyy-mm-dd')");
}
sql.append(" and t.l301_13=a.d201_01");
sql.append(" and t.l301_17=b.d101_01");
sql.append(" order by t.l301_28");
%>
<%
XML_GenOneRecordset(response,sql.toString());
%>