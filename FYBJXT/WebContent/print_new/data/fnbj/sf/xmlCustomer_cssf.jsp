<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "../../GenXmlData.jsp" %>
<%
String sql = "select * from v_f503 t where t.f503_01 ='"+ request.getParameter("f50301")+"'"; 
%>
<%
XML_GenOneRecordset(response,sql);
%>
