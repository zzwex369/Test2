<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
	String date_status=request.getParameter("date_status");
	String date_satrt=request.getParameter("date_start");
	String date_end=request.getParameter("date_end");
	StringBuffer sql = new StringBuffer();
	sql.append( "select * from V_F305 t where 1 = 1 and t.f305_08 like '%" + request.getParameter("institution") + "%'") ;
//String sql = "select * from V_E301 t where 1 = 1 and t.e301_16 like '%" + request.getParameter("institution") + "%' and t.e301_14_str >= '"+request.getParameter("date_start")+"'"+" and e301_14_str <= '"+request.getParameter("date_end")+"' order by t.e301_14_str"; 
	if("0".equals(date_status)){
			sql.append(" and to_char(t.F301_31,'yyyy-MM-dd') >='" +date_satrt+ "' ");
			sql.append(" and to_char(t.F301_31,'yyyy-MM-dd') <='" +date_end+"' order by t.F301_31");
	}
	else if("1".equals(date_status)){
			sql.append(" and t.F305_03_Str >='" +date_satrt+ "'");
			sql.append(" and t.F305_03_Str <='" +date_end + "' order by t.F305_03_Str");
	}
	else if("2".equals(date_status)){
			sql.append(" and t.F305_04_Str >='" +date_satrt+ "'");
			sql.append(" and t.F305_04_Str <='" +date_end + "' order by t.F305_04_Str");
	}
	
%>
<%
	XML_GenOneRecordset(response,sql.toString());
%>