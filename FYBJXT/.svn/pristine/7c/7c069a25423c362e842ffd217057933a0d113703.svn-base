<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "../../GenXmlData.jsp" %>
<%
String l30101= request.getParameter("l30101");
StringBuffer sb = new StringBuffer("select * from v_l301 where l301_01='"+l30101+"'");

%>
<%
XML_GenOneRecordset(response,sb.toString());
%>
