<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
System.out.print("***********");
	String d606_03_status=request.getParameter("d606_03_status");
	String d606_03_data=request.getParameter("d606_03_data");
	String date_status=request.getParameter("date_status");
	String date_satrt=request.getParameter("date_start");
	String date_end=request.getParameter("date_end");
	StringBuffer sql = new StringBuffer();
	sql.append( "select * from V_D606 t where 1 = 1 and t.d606_51 like '%" + request.getParameter("institution") + "%'") ;
	
	if("0".equals(d606_03_status)){
			sql.append(" and t.D606_03 ='" +d606_03_data+ "'");
	}
	if("0".equals(date_status)){
			sql.append(" and t.D606_53_Str >='" +date_satrt+ "'");
			sql.append(" and t.D606_53_Str <='" +date_end + "' order by t.D606_53_Str");
	}
	if("1".equals(date_status)){
			sql.append(" and t.D606_25_Str >='" +date_satrt+ "'");
			sql.append(" and t.D606_25_Str <='" +date_end + "' order by t.D606_25_Str");
	}
%>
<%
	XML_GenOneRecordset(response,sql.toString());
%>