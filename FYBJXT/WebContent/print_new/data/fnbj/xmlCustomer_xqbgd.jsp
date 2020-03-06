<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData_cssqd.jsp" %>
<%
	String sql = "select f601_01,f602_03,F601_05_str as F601_05," +
				"F601_09,F601_10,F601_11_zh F601_11,F601_12_zh F601_12," +
				"F601_16_str as F601_16 ,F601_18 ,F601_19_zh F601_19,F601_20" +
				",to_char(f601_21,'yyyy-mm-dd') as f601_21 ,F601_22,F601_26_str as F601_26" +
				",F601_28,F601_29_zh F601_29,F601_38,F601_39,F601_36,F601_55,F601_77" +
				",to_char(f602_23,'yyyy-mm-dd') as f602_23,F602_21,F602_22,F602_24" +
				",F602_25,F602_15,F602_16,F602_28,F602_29,F602_07,F602_08,F602_09,F602_10" +
				",F602_11,F602_12,F602_13,F602_14,z1.z_02 f602_16,z2.z_02 f602_22,z3.z_02 f602_29 ,d.d101_02 as f601_73 " +
				" from v_f601 f1 ,f602 f2,z602_01 z1 ,z602_01 z2 ,z602_01 z3 ,d101 d where f2.f602_02=f1.F601_01 " +
				"and f2.f602_16=z1.z_01(+) and f2.f602_22=z2.z_01(+) and f2.f602_29=z3.z_01(+) and f1.F601_73=d.d101_01(+)" +
				"and f2.f602_01='"+ request.getParameter("f60201")+"'";
//System.out.println(sql);

%>
<%
XML_GenOneRecordset(response,sql);
%>
