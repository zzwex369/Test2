<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="com.xyw.sys.util.StringUtil"%>
<%@ include file = "GenXmlData_msmxb.jsp" %>
<%

String dateStr= request.getParameter("dateStr");//开始时间
String dateEnd= request.getParameter("dateEnd");//结束时间
String code= request.getParameter("code");//机构编码                      
String chargetype= request.getParameter("chargetype");//付费方式
String date_status= request.getParameter("date_status");//时间类型      申请日期0 录入日期 1  报告日期2
String address_status= request.getParameter("address_status");//地址类型  户口地址0  现住址1
String address= request.getParameter("address");//地址编码
String institution= request.getParameter("institution");//地址编码
boolean isFull=institution.length() == 14;
String lastSymbol=isFull?"":"%";
String firstSymbol=isFull?"=":"like";
StringBuffer sb = new StringBuffer();
sb.append("select t.f501_03 as 姓名,t.f501_05 as 身份证号,t.f501_06 as 出生日期,t.f501_31 as 年龄,");
		sb.append("t.f501_07 as 联系方式,t.f501_08 as 体重,");
		sb.append("t.f501_15 as 胎数,t.f501_17 as 末次月经,e.z_02 as 收费方式,a.f502_09 as 超声号,");
		sb.append("c.d201_05 as 现地址,d201_ms.d201_05 as 户口地址,");
		sb.append("b.d101_02 as 筛查单位,t.f501_25 as 申请日期 ,t.f501_24 as 申请医生,");
		sb.append("t.f501_28 as 录入日期,a.f502_24 as 报告日期,a.f502_22 as 报告医生,");
		sb.append("d.s_02 as 报告结果");
		sb.append(" from f501 t ,f502 a,d101 b,d201_ms c,d201_ms d201_ms,s601_05 d,z501_07 e");
		sb.append(" where t.f501_01=a.f502_02(+) and t.f501_30=e.z_01(+) and t.f501_26=b.d101_01(+)");
		sb.append(" and f501_34=c.d201_01(+) and f501_42=d201_ms.d201_01(+)  and a.f502_38=d.s_01(+)");
		
		sb.append(" and t.f501_26 "+firstSymbol+"'"+institution+lastSymbol+"'");
		

if(!StringUtil.isBlankString(chargetype)){//付费方式
	sb.append(" and t.f501_30 ='"+chargetype+"'");
}

if("0".equals(date_status)){//时间类型      申请日期0 录入日期 1  报告日期2
	sb.append(" and t.f501_25>=to_date('"+dateStr+"','yyyy-mm-dd') and t.f501_25<=to_date('"+dateEnd+"','yyyy-mm-dd')");
}else if("1".equals(date_status)){
	sb.append(" and t.f501_28>=to_date('"+dateStr+"','yyyy-mm-dd') and t.f501_28<=to_date('"+dateEnd+"','yyyy-mm-dd')");
}else if("2".equals(date_status)){
	sb.append(" and a.f502_24>=to_date('"+dateStr+"','yyyy-mm-dd') and a.f502_24<=to_date('"+dateEnd+"','yyyy-mm-dd')");
}

if("0".equals(address_status)){//地址类型  户口地址0  现住址1
	sb.append(" and t.f501_42 like '"+address+"%'");
}else if("1".equals(address_status)){
	sb.append(" and t.f501_34 like '"+address+"%'");
}
%>
<%
	XML_GenOneRecordset(response,sb.toString());
%>