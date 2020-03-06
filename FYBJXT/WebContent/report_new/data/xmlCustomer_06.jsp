<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
String sql = "select * from V_F303 t where 1 = 1 and t.f303_15 like '%" + request.getParameter("institution") + "%' and t.f303_14_str >= '"+request.getParameter("date_start")+"'"+" and f303_14_str <= '"+request.getParameter("date_end")+"' order by t.f303_14_str"; 
%>
<%
XML_GenOneRecordset(response,sql);
%>