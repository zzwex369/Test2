 <%@ page contentType="text/html; charset=utf-8"%>
 <%@ page import="com.xyw.sys.util.StringUtil"%>
<%@ include file = "../../GenXmlData.jsp" %>
<%
String hospital=request.getParameter("hospital");
String date_satrt=request.getParameter("date_satrt");
String date_end=request.getParameter("date_end");
String institution=request.getParameter("institution");
String chargetype=request.getParameter("chargetype");
String checktype=request.getParameter("checktype");
String date_status=request.getParameter("date_status");
String address_status=request.getParameter("address_status");
String address=request.getParameter("address");
boolean isFull=institution.length() == 14;
String lastSymbol=isFull?"":"%";
String firstSymbol=isFull?"=":"like";
StringBuffer sql = new StringBuffer();
sql.append("select t.e601_03 as 母亲姓名,t.e601_04 as 身份证号,d.d201_05 as 现住地址,a.d201_05 as 户口地址 ,");
sql.append("e601_09 联系方式,e.s_02 as 婴儿性别,t.e601_18 as 出生日期,f.z_02 as 筛查类型,b.z_02 as 付费方式,");
sql.append("e601_26 as 采血日期,c.d101_02 as 筛查单位,t.e601_30 as 两病血卡号,t.e601_31 多病血卡号,t.e601_34 as 录入日期 ,");
sql.append("g.z_02 as 标本状态,t.e601_37 as 邮寄日期,t.e601_39 as 审核日期,t.e601_73 as 报告日期 ");
sql.append("from e601 t,d201_ms a,z601_06 b,d101 c , d201_ms d ,S301_01 e, z601_04 f,z601_02 g ");
sql.append("where t.e601_49=a.d201_01(+)  and  t.e601_08=d.d201_01(+) and t.e601_24=b.z_01(+) ");
sql.append("and t.e601_29=c.d101_01(+) and t.e601_17=e.s_01(+)and t.e601_23=f.z_01(+) and t.e601_36=g.z_01(+) ");
sql.append(" and t.e601_29 "+firstSymbol+"'"+institution+lastSymbol+"'");
if("0".equals(address_status)){
sql.append(" and t.e601_49 like '"+address+"%'");
}
if("1".equals(address_status)){
sql.append(" and t.e601_08 like '"+address+"%'");
}
if("2".equals(address_status)){
	
}
if("0".equals(date_status)){
sql.append(" and t.e601_26>=to_date('"+date_satrt+"','yyyy-mm-dd')");
sql.append(" and t.e601_26<=to_date('"+date_end+"','yyyy-mm-dd') ");
}
if("1".equals(date_status)){
sql.append(" and t.e601_34>=to_date('"+date_satrt+"','yyyy-mm-dd')");
sql.append(" and t.e601_34<=to_date('"+date_end+"','yyyy-mm-dd') ");
}
if("2".equals(date_status)){
sql.append(" and t.e601_37>=to_date('"+date_satrt+"','yyyy-mm-dd')");
sql.append(" and t.e601_37<=to_date('"+date_end+"','yyyy-mm-dd') ");
}
if("3".equals(date_status)){
sql.append(" and t.e601_39>=to_date('"+date_satrt+"','yyyy-mm-dd')");
sql.append(" and t.e601_39<=to_date('"+date_end+"','yyyy-mm-dd') ");
}
if("4".equals(date_status)){
sql.append(" and t.e601_73>=to_date('"+date_satrt+"','yyyy-mm-dd')");
sql.append(" and t.e601_73<=to_date('"+date_end+"','yyyy-mm-dd') ");
}

if(!StringUtil.isBlankString(chargetype)){//付费方式
	sql.append(" and t.e601_24 ='"+chargetype+"'");
}
if(!StringUtil.isBlankString(checktype)){//筛查类型
	sql.append(" and t.e601_23 ='"+checktype+"'");
}
sql.append(" order by t.e601_26");
%>
<%
XML_GenOneRecordset(response,sql.toString());
%>