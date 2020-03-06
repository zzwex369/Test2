<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData_07.jsp" %>
<%
	String date_status=request.getParameter("date_status");
	String date_satrt=request.getParameter("date_start");
	String date_end=request.getParameter("date_end");
	String F307_27=request.getParameter("f307_27");
	String F307_27Data=request.getParameter("f307_27Data");
	StringBuffer sql = new StringBuffer();
	sql.append( "select * from V_F307 t where 1 = 1 and t.f307_37 like '%"+ request.getParameter("institution") + "%'") ;
	if("1".equals(F307_27))
	{
		sql.append(" and t.F307_27 ='" +F307_27Data+ "'");
	}
	if("0".equals(date_status)){
			sql.append(" and t.F307_03_Str >='" +date_satrt+ "'");
			sql.append(" and t.F307_03_Str <='" +date_end + "' order by t.F307_03_Str");
	}
	if("1".equals(date_status)){
			sql.append(" and t.F307_24_Str >='" +date_satrt+ "'");
			sql.append(" and t.F307_24_Str <='" +date_end + "' order by t.F307_24_Str");
	}
%>
<%
	XML_GenOneRecordset(response,sql.toString());
%>