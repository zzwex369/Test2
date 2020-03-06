<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<% 
String sql = "select t.f303_05,t.f303_23,t.f303_53 from F303 t where  t.f303_07 = '410421000000000000' or t.f303_07 = '410421000000000001' or (t.f303_07 = '"+ request.getParameter("f303_07")+"' and t.f303_04 = '"+ request.getParameter("f303_04")+"') order by t.f303_05,t.f303_23";
%>
<%
XML_GenOneRecordset(response,sql);
%>