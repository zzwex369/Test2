<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "../GenXmlData.jsp" %>
<%
String l30101= request.getParameter("l30101");
String isL301= request.getParameter("isL301");
StringBuffer sb = new StringBuffer();

	sb.append("select L301_02,L301_04,L301_06,L301_09,L301_10,L301_16,L301_19,L301_29,L301_30,L301_07zh,L301_13zh");
if("2".equals(isL301))
{
	sb.append(",t.*,d101_01.d101_02  L402_165ZH,d101_02.d101_02  L402_168ZH,d101_03.d101_02  L402_174ZH,d101_04.d101_02  L402_108ZH,");
	sb.append("to_char(t.L402_167,'yyyy-mm-dd') L402_167STR,to_char(t.L402_170,'yyyy-mm-dd') L402_170STR,");
	sb.append("to_char(t.L402_176,'yyyy-mm-dd') L402_176STR from  v_l402 t,v_l301 a,d101 d101_01,");
	sb.append("d101 d101_02,d101 d101_03,d101 d101_04 where  a.L301_01=t.l402_02(+) ");
	sb.append("and t.L402_165=d101_01.d101_01(+) and t.L402_168=d101_02.d101_01(+) ");
	sb.append("and t.L402_174=d101_03.d101_01(+) and t.L402_108=d101_04.d101_01(+)");
}else
{
	sb.append(" from  v_l301 a where 1=1 ");
}
	sb.append("and a.l301_01='"+l30101+"'");


%>
<%
XML_GenOneRecordset(response,sb.toString());
%>
