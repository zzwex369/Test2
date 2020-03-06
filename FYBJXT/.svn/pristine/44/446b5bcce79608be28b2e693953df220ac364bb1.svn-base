 <%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
	String address_status=request.getParameter("address_status");
	String address=request.getParameter("address");
	String date_status=request.getParameter("date_status");
	String date_satrt=request.getParameter("date_satrt");
	String date_end=request.getParameter("date_end");
	String f30146=request.getParameter("f30146");
	StringBuffer sql = new StringBuffer();
	//and t.f301_31_str >= '"+request.getParameter("date_start")+"'"+" and f301_31_str <= '"+request.getParameter("date_end")+"' order by t.f301_31_str"; 
	sql.append( "select * from V_F301 t where 1 = 1 and t.f301_32 like '%" + request.getParameter("institution") + "%'") ;
	if("0".equals(address_status)){
			sql.append(" and t.f301_36 like '%" + address +"%' ");	
	}
	if("1".equals(address_status)){
			sql.append(" and t.f301_35 like '%" + address +"%' ");
	}
	if("1".equals(f30146)){
			sql.append(" and t.f301_46='" + f30146 + "' ");
	}
	if("2".equals(f30146)){
			sql.append(" and t.f301_46='" + f30146 + "' ");
	}
	
	if("0".equals(date_status)){
			sql.append(" and t.f301_31_str >='" +date_satrt+ "' ");
			sql.append(" and t.f301_31_Str <='" +date_end+"' order by t.f301_31_str");
	}
	if("1".equals(date_status)){
			sql.append(" and t.f301_49_str >='" +date_satrt+ "'");
			sql.append(" and t.f301_49_str <='" +date_end + "' order by t.f301_49_str");
	}
%>
<%
XML_GenOneRecordset(response,sql.toString());
%>