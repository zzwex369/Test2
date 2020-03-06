<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
	String e305_74_status=request.getParameter("e305_74_status");
	String e305_74_data=request.getParameter("e305_74_data");
	String date_status=request.getParameter("date_status");
	String date_satrt=request.getParameter("date_start");
	String date_end=request.getParameter("date_end");
	StringBuffer sql = new StringBuffer();
	sql.append( "select * from V_E305 t where 1 = 1 and t.e305_17 like '%" + request.getParameter("institution") + "%'") ;
	
	if("0".equals(e305_74_status)){
			sql.append(" and t.E305_17 ='" +e305_74_data+ "'");
	}
	if("0".equals(date_status)){
			sql.append(" and t.E305_74_Str >='" +date_satrt+ "'");
			sql.append(" and t.E305_74_Str <='" +date_end + "' order by t.E305_74_Str");
	}
	if("1".equals(date_status)){
			sql.append(" and t.E305_76_Str >='" +date_satrt+ "'");
			sql.append(" and t.E305_76_Str <='" +date_end + "' order by t.E305_76_Str");
	}
%>
<%
	XML_GenOneRecordset(response,sql.toString());
%>