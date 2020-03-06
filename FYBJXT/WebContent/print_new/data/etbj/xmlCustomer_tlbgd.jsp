<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../GenXmlData.jsp"%>
<%
	String sql = "select E504_04,E504_05,E504_06," +
					"E504_10,E504_12,E504_14,E504_15,E504_16," +
					"E504_20,E504_21,E505_09,E505_11,E505_13," +
					"E505_26,E505_27,E505_29,E505_03,E505_06," +
					"E505_12,E505_14,E505_27,E505_28,E504_12," +
					"E504_16,E504_20,h.d101_02 e505_28_ZH " +
					"from E505 a,E504 e,D101 h " +
					"where " +
					"a.e505_02=e.e504_01(+) " +
					" and a.e505_28 = h.d101_01(+) " +
					"and a.e505_01='"+ request.getParameter("e50501")+"'"; 


%>
<%
XML_GenOneRecordset(response,sql);
%>
