<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
String sql = "select * "+
			 "from V_F401  where f401_01 = "+ request.getParameter("f40101"); 
			 
			 //System.out.println(sql);
%>
<%
XML_GenOneRecordset(response,sql);
%>
