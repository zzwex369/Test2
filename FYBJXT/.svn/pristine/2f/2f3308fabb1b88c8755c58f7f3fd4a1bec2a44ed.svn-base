<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
	String date_status=request.getParameter("date_status");
	String date_satrt=request.getParameter("date_start");
	String date_end=request.getParameter("date_end");
	StringBuffer sql = new StringBuffer();
	sql.append( "select * from V_F303 t where 1 = 1 and t.f303_123 <> '1' and t.f303_15 like '%" + request.getParameter("institution") + "%'") ;
	if("0".equals(date_status)){
			sql.append(" and t.F303_14_Str >='" +date_satrt+ "' ");
			sql.append(" and t.F303_14_Str <='" +date_end+"' order by t.F303_14_Str");
	}
	if("1".equals(date_status)){
			sql.append(" and t.F303_18_Str >='" +date_satrt+ "'");
			sql.append(" and t.F303_18_Str <='" +date_end + "' order by t.F303_18_Str");
	}

%>
<%
	XML_GenOneRecordset(response,sql.toString());
%>