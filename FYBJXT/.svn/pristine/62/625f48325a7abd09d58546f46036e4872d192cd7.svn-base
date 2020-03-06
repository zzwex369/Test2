<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData_03.jsp" %>
<%
	String date_status=request.getParameter("date_status");
	String date_satrt=request.getParameter("date_start");
	String date_end=request.getParameter("date_end");
	StringBuffer sql = new StringBuffer();
	sql.append( "select * from V_F302 t where 1 = 1 and t.f302_50 like '%" + request.getParameter("institution") + "%'") ;
	
	if("0".equals(date_status)){
			sql.append(" and t.F302_52_Str >='" +date_satrt+ "' ");
			sql.append(" and t.F302_52_Str <='" +date_end+"' order by t.F302_52_Str");
	}
	if("1".equals(date_status)){
			sql.append(" and t.F302_53_Str >='" +date_satrt+ "'");
			sql.append(" and t.F302_53_Str <='" +date_end + "' order by t.F302_53_Str");
	}
%>
<%
XML_GenOneRecordset(response,sql.toString());
%>