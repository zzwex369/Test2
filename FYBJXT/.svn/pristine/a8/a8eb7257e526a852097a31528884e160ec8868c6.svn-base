 <%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
String hospital=request.getParameter("hospital");
String date_satrt=request.getParameter("date_satrt");
String date_end=request.getParameter("date_end");
String institution=request.getParameter("institution");
String chargetype=request.getParameter("chargetype");
String date_status=request.getParameter("date_status");
StringBuffer sql = new StringBuffer();
String date_type=null;
String date_name=null;
if("0".equals(date_status)){
	date_type="t.f601_34";
	date_name="采血日期";
}else if("1".equals(date_status)){
	date_type="t.f601_26";
	date_name="录入日期";
}else if("2".equals(date_status)){
	date_type="t.f601_57";
	date_name="邮寄日期";
}else if("3".equals(date_status)){
	date_type="t.f601_60";
	date_name="审核日期";
}else if("4".equals(date_status)){
	date_type="t.f601_71";
	date_name="报告日期";
}
sql.append("select c.d101_02 as 采血单位,t.f601_03 as  筛查对象姓名,a.d201_05 as 家庭地址,t.f601_04 as 身份证号,t.f601_09 联系方式,case when t.f601_41='1' then '140' when t.f601_41='2' then '' end  as 筛查费用,");
sql.append("'"+date_name+"'  as 日期,");
sql.append(date_type+" as 产前血清学筛查,");
sql.append("'"+date_satrt+"'  as 开始时间,");
sql.append("'"+date_end+"'  as 结束时间");
sql.append(" from f601 t,d201_ms a,z501_07  b,d101 c");
sql.append(" where t.f601_56=a.d201_01(+) and t.f601_41=b.z_01(+) and t.f601_29=c.d101_01(+) and t.f601_29 like '%"+institution+"%'");

if(!"".equals(chargetype))
	sql.append(" and t.f601_41='"+chargetype+"'");
	
sql.append(" and "+date_type+">=to_date('"+date_satrt+"','yyyy-mm-dd')");
sql.append(" and "+date_type+"<=to_date('"+date_end+"','yyyy-mm-dd') ");
sql.append(" order by "+date_type);

%>
<%
XML_GenOneRecordset(response,sql.toString());
%>