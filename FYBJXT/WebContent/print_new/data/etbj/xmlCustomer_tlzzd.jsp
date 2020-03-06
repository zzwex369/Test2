<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../GenXmlData.jsp"%>
<%
	String e50502 = request.getParameter("e50502");
	StringBuffer sql = new StringBuffer("select E504_05,E504_06,E504_10,E504_14,E504_09_zh,E504_15_zh,");		
				 sql.append("E505_07,e1.e505_09_zh e505_09_zh_01,e1.E505_11_zh E505_11_zh_01,");
				 sql.append("e1.E505_13_zh E505_13_zh_01,e1.E505_25_zh e505_25_zh_01,E505_29,");
				 sql.append("e2.e505_09_zh e505_09_zh_02,e2.E505_11_zh E505_11_zh_02,");
				 sql.append("e2.E505_13_zh E505_13_zh_02,e2.E505_25_zh e505_25_zh_02,E505_28_zh,");
				 sql.append("E506_09,E506_11 from ( select E504_05,E504_06,E504_10,E504_14,E504_09_zh,");
				 sql.append("E504_15_zh, E505_09_zh,E505_11_zh,E505_13_zh,E505_25_zh from ");
				 sql.append("v_e505_and_v_e504  where E504_01='"+e50502+"' and E505_26='0') e1,");
				 sql.append("( select E505_07, E505_09_zh,E505_11_zh,E505_13_zh,E505_25_zh,E505_28_zh,");
				 sql.append("E505_29 from v_e505  where E505_02='"+e50502+"' and E505_26='1') e2,");
				 sql.append("( select E506_09,E506_11 from e506  where E506_02='"+e50502+"') e3");

	//System.out.println(sql);
%>
<%
	XML_GenOneRecordset(response, sql.toString());
%>
