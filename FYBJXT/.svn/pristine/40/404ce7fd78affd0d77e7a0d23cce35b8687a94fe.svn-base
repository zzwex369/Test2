<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
	String status=request.getParameter("status");
	String f304_06_code=request.getParameter("f304_06_code");
	String date_satrt=request.getParameter("date_start");
	String date_end=request.getParameter("date_end");
	StringBuffer sql = new StringBuffer();
	sql.append( "select * from V_F304 t where 1 = 1 and t.f304_08 like '%" + request.getParameter("institution") + "%'") ;
//String sql = "select * from V_E301 t where 1 = 1 and t.e301_16 like '%" + request.getParameter("institution") + "%' and t.e301_14_str >= '"+request.getParameter("date_start")+"'"+" and e301_14_str <= '"+request.getParameter("date_end")+"' order by t.e301_14_str"; 
	if("0".equals(status)){
			sql.append(" and t.f304_06 like '%" + f304_06_code + "%'");
	}
	sql.append(" and t.f304_03_Str >= '"+date_satrt+"'"+" and f304_03_Str <= '"+date_end+"' order by t.f304_03_str");
%>
<%
	XML_GenOneRecordset(response,sql.toString());
%>