<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "../../GenXmlData.jsp" %>
<%
String sql = "select * from v_f603 t where t.f603_01 ='"+ request.getParameter("f60301")+"'"; 
%>
<%
XML_GenOneRecordset(response,sql);
%>
