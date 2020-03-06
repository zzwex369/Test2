<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
String date_status=request.getParameter("date_status");
	String date_satrt=request.getParameter("date_start");
	String date_end=request.getParameter("date_end");
	StringBuffer sql = new StringBuffer();
	sql.append( "select * from V_E304 t where 1 = 1 and t.e304_45 like '%" + request.getParameter("institution") + "%' and t.E304_02>'12' and t.E304_02<='20'") ;
	
	if("0".equals(date_status)){
			sql.append(" and t.E304_04_Str >='" +date_satrt+ "'");
			sql.append(" and t.E304_04_Str <='" +date_end + "' order by t.E304_04_Str");
	}
	if("1".equals(date_status)){
			sql.append(" and t.E304_51_Str >='" +date_satrt+ "'");
			sql.append(" and t.E304_51_Str <='" +date_end + "' order by t.E304_51_Str");
	}
%>
<%
	XML_GenOneRecordset(response,sql.toString());
%>