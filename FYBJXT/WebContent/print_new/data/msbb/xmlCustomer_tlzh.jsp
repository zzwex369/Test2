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
String sczt= request.getParameter("sczt");
String scjg=request.getParameter("scjg");
boolean isFull=institution.length() == 14;
String lastSymbol=isFull?"":"%";
String firstSymbol=isFull?"=":"like";
StringBuffer sb = new StringBuffer();
sb.append("select t.e504_06 as 母亲姓名,t.e504_07 as 身份证号,t.e504_10 as 联系方式,b.s_02 as 婴儿性别,");
		sb.append("t.e504_14 as 出生日期,t.e504_16 体重,c.z_02 as 付费方式,t.e504_56 as 检查医生 ,d.d101_02 as 筛查单位,");
		sb.append("e.z_02 as 筛查结果,f.z_02 初筛复筛,a.e505_29 as 检查日期,t.e504_59 as 录入时间 ,ms1.d201_05 as 现住址,");
		sb.append("ms2.d201_05 as 户口地址");
		sb.append(" from e504 t,e505 a ,S301_01 b,z601_06 c,d101 d,z505_01 e ,z501_04 f,d201_ms ms1,d201_ms ms2 ");
		sb.append(" where t.e504_01=a.e505_02(+) and t.e504_15=b.s_01(+) and t.e504_19=c.z_01(+) and t.e504_57=d.d101_01(+)");
		sb.append(" and a.e505_25=e.z_01(+) and a.e505_26=f.z_01 (+) and e504_09=ms1.d201_01(+)");
		sb.append(" and e504_61=ms2.d201_01(+) and t.e504_57 "+firstSymbol+"'"+institution+lastSymbol+"'");
		
		
if(!StringUtil.isBlankString(chargetype)){//付费方式
	sb.append(" and t.e504_19 = '"+chargetype+"'");
}
if(!StringUtil.isBlankString(sczt)){//筛查状态  
	sb.append(" and a.e505_26 = '"+sczt+"'");
}
if(!StringUtil.isBlankString(scjg)){//筛查结果 
	sb.append(" and a.e505_25 = '"+scjg+"'");
}
if("0".equals(date_status)){//时间类型      筛查日期0 录入日期 1
	sb.append(" and a.e505_29>=to_date('"+dateStr+"','yyyy-mm-dd') and a.e505_29<=to_date('"+dateEnd+"','yyyy-mm-dd')");
}else if("1".equals(date_status)){
	sb.append(" and t.e504_59>=to_date('"+dateStr+"','yyyy-mm-dd') and t.e504_59<=to_date('"+dateEnd+"','yyyy-mm-dd')");
}

if("0".equals(address_status)){//地址类型  户口地址0  现住址1
	sb.append(" and t.e504_61 like '"+address+"%'");
}else if("1".equals(address_status)){
	sb.append(" and t.e504_09 like '"+address+"%'");
}else if("2".equals(address_status)){
	
}
sb.append(" order by t.e504_59");

System.out.println(sb.toString());
%>
<%
	XML_GenOneRecordset(response,sb.toString());
%>