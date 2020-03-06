<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../GenXmlData.jsp"%>

<%
	String dateStr= request.getParameter("dateStr");//开始时间
	String dateEnd= request.getParameter("dateEnd");//结束时间
	String code= request.getParameter("code");//机构编码        
	int codeLength=code.trim().length();
	String l302_62 = request.getParameter("L302_62");
	String l301_29 = request.getParameter("L301_29");
	String l301_30 = request.getParameter("L301_30");
	
	StringBuilder sql = new StringBuilder("select r.rws_04 qx,r.rws_07 rws,count(*) scs,count(decode( l1.l301_29 , '1',1,null)) jdlks,");
	sql.append("count(case when l1.l301_30 = '2' and l1.l301_29 = '2' then 1 else null end) qt,count(decode(l1.l301_30,'1',1,null)) db,");
	sql.append("count(decode(l2.l302_62,'1',1,null)) hpv_yi,count(decode(l2.l302_62,'2',1,null)) hpv_ya,");
	sql.append("count(decode(substr(l2.l302_64,0,1),'1',1,null)) hpv_68 from l301 l1, l302 l2,rws r where l1.l301_01 = l2.l302_02(+) ");
	sql.append("and substr(l2.l302_68,0,6) = r.rws_05(+) and r.rws_06 = '3' and l2.l302_68 is not null and to_char(l2.l302_70,'yyyy-MM-dd')>='"+dateStr+"' ");
	sql.append("and to_char(l2.l302_70,'yyyy-MM-dd')<='"+dateEnd+"' ");
	if(codeLength>4){
	sql.append("and substr(l2.l302_68,0,6) = '"+code+"' ");
	}
	sql.append("group by substr(l2.l302_68,0,6), r.rws_04,r.rws_07");
	
	//System.out.println(sql);
%>

<%
XML_GenOneRecordset(response,sql.toString());
%>