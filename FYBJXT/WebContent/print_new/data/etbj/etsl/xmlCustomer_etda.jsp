<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../GenXmlData.jsp"%>
<%

	String sql = "select e701_03,e701_04,e701_05,e701_06,e70107_zh,"+
	"e701_08,e701_09,e70110_zh,e70111_zh,e701_12,e701_13,"+
	"e701_14,e70115_zh,e70116_zh,e701_17,e70118_zh,e701_19,e701_20,e701_36,e701_37,e701_40,e701_41,e701_42,e701_45,"+
	"e70138_zh,e70139_zh,e70143_zh,e70144_zh,"+
	"e701_21,e70122_zh,e701_23,e701_30,e70131_zh,e701_32,e701_33 from"+
	" v_e701 where e701_01='"+ request.getParameter("e70101")+"'"; 


%>
<%
XML_GenOneRecordset(response,sql);
%>
