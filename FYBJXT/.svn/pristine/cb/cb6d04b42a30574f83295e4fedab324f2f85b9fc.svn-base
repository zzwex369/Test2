<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
	String date_status=request.getParameter("date_status");
	String date_satrt=request.getParameter("date_start");
	String date_end=request.getParameter("date_end");
	StringBuffer sql = new StringBuffer();
	sql.append( "select * from V_F306 t where 1 = 1 and t.f306_10 like '%" + request.getParameter("institution") + "%'") ;
	
	if("0".equals(date_status)){
			sql.append(" and to_char(t.F301_31,'yyyy-MM-dd') >='" +date_satrt+ "' ");
			sql.append(" and to_char(t.F301_31,'yyyy-MM-dd') <='" +date_end+"' order by t.F301_31");
	}
	else if("1".equals(date_status)){
			sql.append(" and t.F306_03_Str >='" +date_satrt+ "'");
			sql.append(" and t.F306_03_Str <='" +date_end + "' order by t.F306_03_Str");
	}
	else if("2".equals(date_status)){
			sql.append(" and t.F306_05_Str >='" +date_satrt+ "'");
			sql.append(" and t.F306_05_Str <='" +date_end + "' order by t.F306_05_Str");
	}
	
%>
<%
XML_GenOneRecordset(response,sql.toString());
%>