<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../GenXmlData.jsp"%>
<%
	String sql = "select e703_04,e703_05,e70306_zh,"+
	"e703_07,e703_08,e703_09,e703_10,e703_11,e703_12,"+
	"e703_13,e703_14,e703_15,e70316_zh,e703_17,e703_18,"+
	"e703_19,e703_20,e70321_zh,e70322_zh,e703_23,e703_24 "+
	"from v_e703 where e703_01='"+ request.getParameter("e70301")+"'"; 


%>
<%
XML_GenOneRecordset(response,sql);
%>
