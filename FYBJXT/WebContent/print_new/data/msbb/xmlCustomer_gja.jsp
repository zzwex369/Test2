<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "../GenXmlData.jsp" %>
<%
String l30201= request.getParameter("l30201");
StringBuffer sb = new StringBuffer("select l302_03, t1.l301_06,t2.l301_10,");
       sb.append("l302_04,l302_05,l302_57, l302_58,l302_74,l302_63,l302_90,");
  	   sb.append("l302_96,l302_118zh,l302_120str,l302_76zh,l302_78str,l302_64,");
  	   sb.append("l302_65,l302_97, d.d201_05 l301_11zh from v_l302 t1, l301 t2, d201_ms d ");
  	   sb.append("where t1.l302_02 = t2.l301_01(+) and t2.l301_11 = d.d201_01 ");
 	   sb.append("and t1.l302_01 ='"+l30201+"'");
   


%>
<%
XML_GenOneRecordset(response,sb.toString());
%>
