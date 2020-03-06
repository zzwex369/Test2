<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData_msmxb.jsp" %>
<%
String dateStr= request.getParameter("dateStr");
String dateEnd= request.getParameter("dateEnd");
String code= request.getParameter("code");
int i=code.length();
String sql="select to_char(t.f601_26,'yyyy-mm-dd')as f601_26Str,t.f601_03,t.f601_04,(t.f601_18||'周'||t.f601_38||'天') as YZT,"
+" a.d201_05,t.f601_09,t.f601_55,t.f601_27,b.d101_02 "
+" from f601 t,d201_ms a,D101 b"
+" where t.f601_56=a.d201_01 and t.f601_59='2' and t.f601_29='"+code+"' and t.f601_26>=to_date('"+dateStr+"','yyyy-mm-dd')"
+" and t.f601_26<=to_date('"+dateEnd+"','yyyy-mm-dd') and b.d101_01 = t.f601_29 order by t.f601_26,t.f601_55" ;
//System.out.println(sql);
%>
<%
	XML_GenOneRecordset(response,sql);
%>