<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "../GenXmlData.jsp" %>
<%
String sql = "select t.f601_03,t.f601_55 from f601 t where t.f601_01 ='"+ request.getParameter("f60101")+"'"; 
%>
<%
XML_GenOneRecordset(response,sql);
%>
