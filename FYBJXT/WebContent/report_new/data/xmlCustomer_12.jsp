<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
	String e302_status=request.getParameter("e302_status");
	String e302_code=request.getParameter("e302_code");
	String date_status=request.getParameter("date_status");
	String date_satrt=request.getParameter("date_start");
	String date_end=request.getParameter("date_end");
	StringBuffer sql = new StringBuffer();
	sql.append( "select * from V_E302 t where 1 = 1 and t.e302_37 like '%" + request.getParameter("institution") + "%'") ;
	
	if("0".equals(e302_status)){
			sql.append(" and t.E302_13 >='" +e302_code + "'");
	}
	if("1".equals(e302_status)){
			sql.append(" and t.E302_19 ='" +e302_code+ "'");
	}
	if("0".equals(date_status)){
			sql.append(" and t.E302_04_Str >='" +date_satrt+ "'");
			sql.append(" and t.E302_04_Str <='" +date_end + "' order by t.E302_04_Str");
	}
	if("1".equals(date_status)){
			sql.append(" and t.E302_31_Str >='" +date_satrt+ "'");
			sql.append(" and t.E302_31_Str <='" +date_end + "' order by t.E302_31_Str");
	}

%>
<%
	XML_GenOneRecordset(response,sql.toString());
%>