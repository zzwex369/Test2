 <%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
String hospital=request.getParameter("hospital");
String date_satrt=request.getParameter("date_satrt");
String date_end=request.getParameter("date_end");
String institution=request.getParameter("institution");
String chargetype=request.getParameter("chargetype");
String sczt=request.getParameter("sczt");
String scjg=request.getParameter("scjg");
String date_status=request.getParameter("date_status");
StringBuffer sql = new StringBuffer();
String date_type=null;
String date_name=null;
if("0".equals(date_status)){
	date_type="d.e505_29";
	date_name="筛查日期";
}else if("1".equals(date_status)){
	date_type="t.e504_59";
	date_name="录入日期";
}
sql.append("select c.d101_02 as 筛查单位,t.e504_06 as 筛查对象姓名,t.e504_07 as 身份证号,a.d201_05 as 家庭地址,t.e504_10 as 联系方式, case when t.e504_19='1' then '55' when t.e504_19='2' then '' end  as 筛查费用,");
sql.append("'"+date_name+"'  as 日期,");
sql.append(""+date_type+"  as 产前听力学筛查,");
sql.append("'"+date_satrt+"'  as 开始时间,");
sql.append("'"+date_end+"'  as 结束时间");
sql.append(" from e504 t,d201_ms a,z601_06 b,d101 c ,e505 d ");
sql.append(" where t.e504_61=a.d201_01(+) and t.e504_19=b.z_01(+) and t.e504_57=c.d101_01(+) and t.e504_01=d.e505_02(+)");
sql.append(" and t.e504_57 like '%"+institution+"%'");
sql.append(" and "+date_type+" >=to_date('"+date_satrt+"','yyyy-mm-dd')");
sql.append(" and "+date_type+" <=to_date('"+date_end+"','yyyy-mm-dd') ");


if(chargetype!=null){//付费方式
	sql.append(" and t.e504_19 like '%"+chargetype+"%'");
}
if(sczt!=null){//筛查状态  
	sql.append(" and d.e505_26 like '%"+sczt+"%'");
}
if(scjg !=null){//筛查结果 
	sql.append(" and d.e505_25 like '%"+scjg+"%'");
}
sql.append(" order by "+date_type+"");

%>
<%
XML_GenOneRecordset(response,sql.toString());
%>