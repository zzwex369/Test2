<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "../GenXmlData.jsp" %>
<%
String l30101= request.getParameter("l30101");
String isL301= request.getParameter("isL301").toString();
StringBuffer sb = new StringBuffer();
	sb.append("select L301_02,a.L301_04,a.L301_06 as L30106,L301_09,");
	sb.append("a.L301_10 as L30110,L301_16,L301_19,L301_29,L301_30,L301_07zh,L301_13zh");

if("2".equals(isL301))
{
	sb.append(",t.*,d101_1.d101_02 L302_171ZH,l302_174Zh,to_char(L302_173,'yyyy-mm-dd')  L302_173Str ");
	sb.append("from  v_l302 t,v_l301 a,d101 d101_1 where ");
	sb.append("a.L301_01=t.l302_02(+) and t.L302_171=d101_1.d101_01(+) ");
	
}else
{
	sb.append(" L301_13zh from  v_l301 a where 1=1 ");
}
sb.append("and a.l301_01='"+l30101+"'");

%>
<%
XML_GenOneRecordset(response,sb.toString());
%>
