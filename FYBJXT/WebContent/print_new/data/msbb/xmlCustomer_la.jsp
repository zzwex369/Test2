<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "../GenXmlData.jsp" %>
<%
String l40201= request.getParameter("l40201");
StringBuffer sb = new StringBuffer();
sb.append("select  a.l301_10 as Tel,b.d201_05 as address,");
sb.append("c.d101_02 as institution,");
sb.append("to_char(t.L402_125,'YYYY-MM-DD') as time, t.l402_03 as name,");
sb.append("a.l301_06  as age,t.l402_05  as cardId, ");
sb.append("case when (case when t.l402_87>t.l402_94 then t.l402_87 else t.l402_94 end ) = '1' then '√' end  as X_ray_1,");
sb.append("case when (case when t.l402_87>t.l402_94 then t.l402_87 else t.l402_94 end )>='2' and (case when t.l402_87>t.l402_94 then t.l402_87 else t.l402_94 end ) <='3' then '√' end  as X_ray_2, ");
sb.append("case when (case when t.l402_87>t.l402_94 then t.l402_87 else t.l402_94 end )= '4' then '√' end  as X_ray_3,");
sb.append("case when (case when t.l402_87>t.l402_94 then t.l402_87 else t.l402_94 end ) >='5' and (case when t.l402_87>t.l402_94 then t.l402_87 else t.l402_94 end )<='6' then '√' end  as X_ray_4 ,");
sb.append("case when (case when t.l402_64>t.l402_82 then t.l402_64 else t.l402_82 end ) = '1' then '√' end  as ultrasound_1,");
sb.append("case when (case when t.l402_64>t.l402_82 then t.l402_64 else t.l402_82 end )>='2' and (case when t.l402_64>t.l402_82 then t.l402_64 else t.l402_82 end ) <='3' then '√' end  as ultrasound_2, ");
sb.append("case when (case when t.l402_64>t.l402_82 then t.l402_64 else t.l402_82 end )= '4' then '√' end  as ultrasound_3,");
sb.append("case when (case when t.l402_64>t.l402_82 then t.l402_64 else t.l402_82 end ) >='5' and (case when t.l402_64>t.l402_82 then t.l402_64 else t.l402_82 end )<='6' then '√' end  as ultrasound_4,  ");
sb.append("case when t.l402_42= '1' then '√' end  as breast_1,");
sb.append("case when t.l402_42= '2' then '√' end  as breast_2, ");
sb.append("case when t.l402_42= '3' then '√' end  as breast_3");
sb.append(" from L402 t,L301 a,D201_MS b,d101 c  where t.l402_02=a.l301_01(+) ");
sb.append(" and a.l301_11 =b.d201_01(+)");
sb.append(" and t.l402_123=c.d101_01(+)");
sb.append(" and t.l402_01='"+l40201+"'");
System.out.print(sb);
%>
<%
XML_GenOneRecordset(response,sb.toString());
%>
