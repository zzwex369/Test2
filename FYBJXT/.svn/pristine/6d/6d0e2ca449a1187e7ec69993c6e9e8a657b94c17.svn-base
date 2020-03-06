 <%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
String date_satrt=request.getParameter("date_satrt");
String date_end=request.getParameter("date_end");
String institution=request.getParameter("institution");
String chargetype=request.getParameter("chargetype");
String date_status=request.getParameter("date_status");
StringBuffer sql = new StringBuffer();
String date_type=null;
String date_name=null;
if("0".equals(date_status)){
	date_type="t.f501_25";
	date_name="筛查日期";
}else if("1".equals(date_status)){
	date_type="t.f501_28";
	date_name="录入日期";
}else if("2".equals(date_status)){
	date_type="d.f502_24";
	date_name="报告日期";
}
sql.append("select c.d101_02 as 筛查单位,t.f501_03 as 筛查对象姓名,a.d201_05 as 家庭地址,t.f501_05 as 身份证号,t.f501_07 as 联系方式,case when t.f501_30='1' then '160' when t.f501_30='2' then '' end  as  筛查费用,");
sql.append("'"+date_name+"'  as 日期,");
sql.append(""+date_type+"  as 产前超声学筛查,");
sql.append("'"+date_satrt+"'  as 开始时间,");
sql.append("'"+date_end+"'  as 结束时间");
sql.append(" from f501 t,d201_ms a,z501_07 b,d101 c ,f502 d ");
sql.append(" where t.f501_42=a.d201_01(+) and t.f501_30=b.z_01(+) and t.f501_01=d.f502_02(+) and t.f501_26=c.d101_01(+) and  t.f501_26 like '%"+institution+"%'");

sql.append(" and "+date_type+">=to_date('"+date_satrt+"','yyyy-mm-dd')");
sql.append(" and "+date_type+"<=to_date('"+date_end+"','yyyy-mm-dd') ");


if(chargetype!=null){//付费方式
	sql.append(" and t.f501_30 like '%"+chargetype+"%'");
}
sql.append(" order by "+date_type+"");
System.out.print(sql);
%>
<%
XML_GenOneRecordset(response,sql.toString());
%>