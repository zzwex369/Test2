<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
	String address_status=request.getParameter("address_status");
	String address_code=request.getParameter("address_code");
	String date_status=request.getParameter("date_status");
	String date_satrt=request.getParameter("date_start");
	String date_end=request.getParameter("date_end");
	StringBuffer sql = new StringBuffer();
	sql.append( "select * from V_E301 t where 1 = 1 and t.e301_16 like '%" + request.getParameter("institution") + "%'") ;
//String sql = "select * from V_E301 t where 1 = 1 and t.e301_16 like '%" + request.getParameter("institution") + "%' and t.e301_14_str >= '"+request.getParameter("date_start")+"'"+" and e301_14_str <= '"+request.getParameter("date_end")+"' order by t.e301_14_str"; 
	if("0".equals(address_status)){
			sql.append(" and t.E301_09 like '%" +address_code+ "%'");
	}
	if("1".equals(address_status)){
			sql.append(" and t.E301_12 like '%" +address_code+ "%'");
	}
	if("0".equals(date_status)){
			sql.append(" and t.E301_14_Str >='" +date_satrt+ "'");
			sql.append(" and t.E301_14_Str <='" +date_end + "' order by t.E301_14_Str");
	}
	if("1".equals(date_status)){
			sql.append(" and t.E301_31_Str >='" +date_satrt+ "'");
			sql.append(" and t.E301_31_Str <='" +date_end + "' order by t.E301_31_Str");
	}

%>
<%
	XML_GenOneRecordset(response,sql.toString());
%>