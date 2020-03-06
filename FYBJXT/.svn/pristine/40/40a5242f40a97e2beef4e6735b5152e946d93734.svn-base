<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../GenXmlData.jsp"%>
<%
//System.out.println("1");
	String dateStr= request.getParameter("dateStr");//开始时间
	String dateEnd= request.getParameter("dateEnd");//结束时间
	String institution= request.getParameter("institution");//机构编码        
	int codeLength=institution.trim().length();
	String l302_62 = request.getParameter("L302_62");
	String l301_29 = request.getParameter("L301_29");
	String l301_30 = request.getParameter("L301_30");
	
	StringBuilder sql = new StringBuilder("select d.d101_02 l302_68zh, l1.l301_02 l301_02, l1.l301_04 l301_04, l1.l301_29 l301_29, l1.l301_30 l301_30,");
	sql.append(" l2.l302_62 l302_62, nvl(substr(l2.l302_64,0,1),-1) l302_64 , to_char(l2.l302_70, 'yyyy-MM-dd') l302_70 from l301 l1, l302 l2,");
	sql.append("d101 d where l1.l301_01 = l2.l302_02(+) and l2.l302_68 = d.d101_01(+) and to_char(l2.l302_70,'yyyy-MM-dd')>='"+dateStr+"' and ");
	sql.append("to_char(l2.l302_70,'yyyy-MM-dd')<='"+dateEnd+"' ");
	if(codeLength==14){
		sql.append("and l2.l302_68 = '"+institution+"' ");
	}else{
		sql.append("and l2.l302_68 like '"+institution+"%' ");
	}
	if("1".equals(l302_62)){
		sql.append("and l2.l302_62 = '1' ");
	}
	if("2".equals(l302_62)){
		sql.append("and l2.l302_62 = '2' ");
	}
	if("1".equals(l301_29)){
		sql.append("and l1.l301_29 = '1' ");
	}
	if("2".equals(l301_29)){
		sql.append("and l1.l301_29 = '2' ");
	}
	if("1".equals(l301_30)){
		sql.append("and l1.l301_30 = '1' ");
	}
	if("2".equals(l301_30)){
		sql.append("and l1.l301_30 = '2' ");
	}

	
	//System.out.println(sql);
%>
<%
XML_GenOneRecordset(response,sql.toString());
%>