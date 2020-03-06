<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%!
	private String getMan(String str,String s){
		return " and substr("+s+",0,"+str+") = D201_01 ";
	}
/*	private String getWoman(String field,String str){
		return field.equals('1')?" and substr(D601_97,0,"+str+") = D201_01 ":"and substr(D601_98,0,"+str+") = D201_01 ";
	}*/
	
	private String getMans(String s){
		return " and "+s+" = D201_01 ";
	}
/*	private String getWomans(String field,String str){
		return field.equals('1')?" and D601_97 = D201_01 ":"and D601_98 = D201_01 ";
	}*/
	
	private String getCode(String s,String areaCode){
		return " where "+s+" = '"+areaCode+"'  ";
	}
	private String getCodes(String s,String areaCode,int area){
	/*	if(area==4){
			return " where " + s + " like '" + areaCode + "__%' ";
		}else if(area == 6 || area == 9){
			return " where " + s + " like '" + areaCode + "___%' ";
		}*/
		
		return area==4?"where " + s + " like '" + areaCode + "__%' ":"where " + s + " like '" + areaCode + "___%' ";
	}
 %>
<%
	String date_start=request.getParameter("date_start");
	String date_end=request.getParameter("date_end");
	String areaCode=request.getParameter("areaCode");
	String sexFlag=request.getParameter("sexFlag");
	String areaFlag=request.getParameter("areaFlag");
	String timeFlag=request.getParameter("timeFlag");
	int area = areaCode.length();
	String s;
	if(sexFlag.equals("1")){
		 s = areaFlag.equals("1")?"D601_97":"D601_98";
	}else {
		 s = areaFlag.equals("1")?"D601_95":"D601_96";
	}
	
	String time = timeFlag.equals("1")?"D601_03":"D601_60";
	
	
	
	StringBuffer sql = new StringBuffer("select D201_04, sum(C1_NYS) C1_NYS,sum(C1_NVS) C1_NVS,");
		sql.append( "sum(C2_NYS) C2_NYS,sum(C2_NVS) C2_NVS,sum(C3_NYS) C3_NYS,sum(C3_NVS) C3_NVS,");
		sql.append( "sum(QT_NYS) QT_NYS,sum(QT_NVS) QT_NVS from(");
		
		sql.append( "select D201_04,count(*) C1_NYS,0 C1_NVS,0 C2_NYS,0 C2_NVS,");
		sql.append( "0 C3_NYS,0 C3_NVS,0 QT_NYS,0 Qt_NVS from D601,D201 ");
		
	//	sql.append( "where D601_96 like '"+areaCode+"%'");
		sql.append((area>=12?getCode(s,areaCode):getCodes(s,areaCode,area)));
		
	//	sql.append( "and substr(D601_96,0,9) = D201_01");
		if(area==4){
			sql.append(getMan("6",s));
		}else if(areaCode.length()==6){
			sql.append(getMan("9",s));
		}else if(areaCode.length()==9){
			sql.append(getMan("12",s));
		}else if(areaCode.length()==12){
			sql.append(getMans(s));
		}
		
		sql.append( "and D601_40 = '1' and D601_20 = '1' ");
		sql.append( "and to_char("+time+",'yyyy-mm-dd') >= '"+date_start+"' ");
		sql.append( "and to_char("+time+",'yyyy-mm-dd') <= '"+date_end+"'  ");
		sql.append( "group by D201_04  union all ");
		sql.append( "select D201_04,0 C1_NYS,count(*) C1_NVS,0 C2_NYS,0 C2_NVS,  ");
		sql.append( "0 C3_NYS,0 C3_NVS,0 QT_NYS,0 Qt_NVS from D601,D201  ");
		
	//	sql.append( "where D601_96 like '411322%'  ");
		sql.append((area>=12?getCode(s,areaCode):getCodes(s,areaCode,area)));
	//	sql.append( "and substr(D601_96,0,9) = D201_01  ");
		if(area==4){
			sql.append(getMan("6",s));
		}else if(areaCode.length()==6){
			sql.append(getMan("9",s));
		}else if(areaCode.length()==9){
			sql.append(getMan("12",s));
		}else if(areaCode.length()==12){
			sql.append(getMans(s));
		}
		
		sql.append( "and D601_40 = '2'  and D601_20 = '1' ");
		sql.append( "and to_char("+time+",'yyyy-mm-dd') >= '"+date_start+"'  ");
		sql.append( "and to_char("+time+",'yyyy-mm-dd') <= '"+date_end+"'  ");
		sql.append( "group by D201_04  union all ");
		sql.append( "select D201_04,0 C1_NYS,0 C1_NVS,count(*) C2_NYS,0 C2_NVS,  ");
		sql.append( "0 C3_NYS,0 C3_NVS,0 QT_NYS,0 Qt_NVS from D601,D201  ");
		
	//	sql.append( "where D601_96 like '411322%'  ");
		sql.append((area>=12?getCode(s,areaCode):getCodes(s,areaCode,area)));
	//	sql.append( "and substr(D601_96,0,9) = D201_01  ");
		if(area==4){
			sql.append(getMan("6",s));
		}else if(areaCode.length()==6){
			sql.append(getMan("9",s));
		}else if(areaCode.length()==9){
			sql.append(getMan("12",s));
		}else if(areaCode.length()==12){
			sql.append(getMans(s));
		}
		
		sql.append( "and D601_40 = '1' and D601_20 = '2'  ");
		sql.append( "and to_char("+time+",'yyyy-mm-dd') >= '"+date_start+"'  ");
		sql.append( "and to_char("+time+",'yyyy-mm-dd') <= '"+date_end+"'  ");
		sql.append( "group by D201_04  union all ");
		sql.append( "select D201_04,0 C1_NYS,0 C1_NVS,0 C2_NYS,count(*) C2_NVS,  ");
		sql.append( "0 C3_NYS,0 C3_NVS,0 QT_NYS,0 Qt_NVS from D601,D201  ");
		
	//	sql.append( "where D601_96 like '411322%'  ");
		sql.append((area>=12?getCode(s,areaCode):getCodes(s,areaCode,area)));
	//	sql.append( "and substr(D601_96,0,9) = D201_01  ");
		if(area==4){
			sql.append(getMan("6",s));
		}else if(areaCode.length()==6){
			sql.append(getMan("9",s));
		}else if(areaCode.length()==9){
			sql.append(getMan("12",s));
		}else if(areaCode.length()==12){
			sql.append(getMans(s));
		}
		
		sql.append( "and D601_40 = '2'  and D601_20 = '2' ");
		sql.append( "and to_char("+time+",'yyyy-mm-dd') >= '"+date_start+"'  ");
		sql.append( "and to_char("+time+",'yyyy-mm-dd') <= '"+date_end+"'  ");
		sql.append( "group by D201_04  union all ");		
		sql.append( "select D201_04,0 C1_NYS,0 C1_NVS,0 C2_NYS,0 C2_NVS,  ");	
		sql.append( "count(*) C3_NYS,0 C3_NVS,0 QT_NYS,0 Qt_NVS from D601,D201  ");	
		
	//	sql.append( "where D601_96 like '411322%'  ");	
		sql.append((area>=12?getCode(s,areaCode):getCodes(s,areaCode,area)));
	//	sql.append( "and substr(D601_96,0,9) = D201_01  ");	
		if(area==4){
			sql.append(getMan("6",s));
		}else if(areaCode.length()==6){
			sql.append(getMan("9",s));
		}else if(areaCode.length()==9){
			sql.append(getMan("12",s));
		}else if(areaCode.length()==12){
			sql.append(getMans(s));
		}
		
		sql.append( "and D601_40 = '1'  and D601_20 = '3' ");	
		sql.append( "and to_char("+time+",'yyyy-mm-dd') >= '"+date_start+"'  ");	
		sql.append( "and to_char("+time+",'yyyy-mm-dd') <= '"+date_end+"'  ");	
		sql.append( "group by D201_04  union all ");	
		sql.append( "select D201_04,0 C1_NYS,0 C1_NVS,0 C2_NYS,0 C2_NVS,  ");	
		sql.append( "0 C3_NYS,count(*) C3_NVS,0 QT_NYS,0 Qt_NVS from D601,D201  ");	
		
	//	sql.append( "where D601_96 like '411322%' ");
		sql.append((area>=12?getCode(s,areaCode):getCodes(s,areaCode,area)));
	//	sql.append( "and substr(D601_96,0,9) = D201_01  ");	
		if(area==4){
			sql.append(getMan("6",s));
		}else if(areaCode.length()==6){
			sql.append(getMan("9",s));
		}else if(areaCode.length()==9){
			sql.append(getMan("12",s));
		}else if(areaCode.length()==12){
			sql.append(getMans(s));
		}
		
		sql.append( "and D601_40 = '2'  and D601_20 = '3'");	
		sql.append( "and to_char("+time+",'yyyy-mm-dd') >= '"+date_start+"'  ");	
		sql.append( "and to_char("+time+",'yyyy-mm-dd') <= '"+date_end+"'  ");	
		sql.append( "group by D201_04  union all ");	
		sql.append( "select D201_04,0 C1_NYS,0 C1_NVS,0 C2_NYS,0 C2_NVS,  ");	
		sql.append( "0 C3_NYS,0 C3_NVS,count(*) QT_NYS,0 QT_NVS from D601,D201  ");	
		
	//	sql.append( "where D601_96 like '411322%'  ");	
		sql.append((area>=12?getCode(s,areaCode):getCodes(s,areaCode,area)));	
	//	sql.append( " and substr(D601_96,0,9) = D201_01  ");	
		if(area==4){
			sql.append(getMan("6",s));
		}else if(areaCode.length()==6){
			sql.append(getMan("9",s));
		}else if(areaCode.length()==9){
			sql.append(getMan("12",s));
		}else if(areaCode.length()==12){
			sql.append(getMans(s));
		}
		
		sql.append( "and D601_40 = '1'  and D601_20 not in ('1','2','3') ");	
		sql.append( "and to_char("+time+",'yyyy-mm-dd') >= '"+date_start+"'  ");	
		sql.append( "and to_char("+time+",'yyyy-mm-dd') <= '"+date_end+"'  ");	
		sql.append( "group by D201_04  union all ");	
		sql.append( "select D201_04,0 C1_NYS,0 C1_NVS,0 C2_NYS,0 C2_NVS,  ");	
		sql.append( "0 C3_NYS,0 C3_NVS,0 QT_NYS,count(*) QT_NVS from D601,D201  ");	
		
	//	sql.append( "where D601_96 like '411322%'  ");	
		sql.append((area>=12?getCode(s,areaCode):getCodes(s,areaCode,area)));		
	//	sql.append( "and substr(D601_96,0,9) = D201_01  ");	
		if(area==4){
			sql.append(getMan("6",s));
		}else if(areaCode.length()==6){
			sql.append(getMan("9",s));
		}else if(areaCode.length()==9){
			sql.append(getMan("12",s));
		}else if(areaCode.length()==12){
			sql.append(getMans(s));
		}
		
		sql.append( "and D601_40 = '2'  and D601_20 not in ('1','2','3') ");	
		sql.append( "and to_char("+time+",'yyyy-mm-dd') >= '"+date_start+"'  ");	
		sql.append( "and to_char("+time+",'yyyy-mm-dd') <= '"+date_end+"'  ");	
		sql.append( "group by D201_04 ) group by D201_04");	
 // System.out.println(sql);
%>
<%
XML_GenOneRecordset(response,sql.toString());
%>