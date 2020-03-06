<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
String sql = "select t.*,substr(t.D301_04,1,4) as year,substr(t.D301_04,6,2) as month,substr(t.D301_04,9,2) as day,substr(t.D301_04,12,2) as hour, substr(t.D301_04,15,2) as min,substr(t.D301_28,1,4) as year1,substr(t.D301_28,6,2) as month1,substr(t.D301_28,9,2) as day1 from V_D301 t where 1 = 1 and t.d301_10 = '" + request.getParameter("d30110")+"'"; 
%>
<%
XML_GenOneRecordset(response,sql);
%>
