<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData_cssqd.jsp" %>
<%
String sql = "select t.* from v_f601 t where t.f601_01 ='"+ request.getParameter("f60101")+"'"; 
%>
<%
	XML_GenOneRecordset(response,sql);
%>
