 <%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
//String hospital=request.getParameter("hospital");
String date_satrt=request.getParameter("date_satrt");
String date_end=request.getParameter("date_end");
String institution=request.getParameter("institution");
String chargetype=request.getParameter("chargetype");
String checktype=request.getParameter("checktype");
String date_status=request.getParameter("date_status");


int StartNo = Integer.parseInt( request.getParameter("StartNo") );
int WantRows = Integer.parseInt( request.getParameter("WantRecords") );

int EndOrderID = (StartNo-1)*WantRows+1;
int EndOrder = StartNo * WantRows;

	if(StartNo == 1){
		StringBuffer sql = new StringBuffer();
		String date_type=null;
		String date_name=null;
		sql.append("select * from(select rownum as rowno,r.*from( ");
		if("0".equals(date_status)){
			date_type="t.e601_26";
			date_name="采血日期";
		}else if("1".equals(date_status)){
			date_type="t.e601_34";
			date_name="录入日期";
		}else if("2".equals(date_status)){
			date_type="t.e601_37";
			date_name="邮寄日期";
		}else if("3".equals(date_status)){
			date_type="t.e601_39";
			date_name="审核日期";
		}else if("4".equals(date_status)){
			date_type="t.e601_73";
			date_name="报告日期";
		}
		sql.append("select c.d101_02 as 筛查单位,t.e601_03 as 筛查对象姓名,t.e601_04 as 身份证号,a.d201_05 as 家庭地址 ,s.d201_05 as 现地址 ,");
		sql.append("t.e601_09 as 联系方式, case when t.e601_24='1' then '45' when t.e601_24='2' then '' end  as 筛查费用,");
		sql.append("'"+date_name+"'  as 日期,");
		sql.append(""+date_type+"  as 两病筛查,");
		sql.append("'"+date_satrt+"'  as 开始时间,");
		sql.append("'"+date_end+"'  as 结束时间");
		sql.append(" from e601 t,d201_ms a,z601_06 b,d101 c,d201_ms s ");
		sql.append(" where t.e601_49=a.d201_01(+) and t.e601_08=s.d201_01(+) and t.e601_24=b.z_01(+)  and t.e601_29=c.d101_01(+)");
		//sql.append(" and t.e601_29 like '"+institution+"%'");
		sql.append((institution.length() == 14?" and t.e601_29 = '"+institution+"'":" and t.e601_29 like '"+institution+"%'"));
		
		sql.append(" and "+date_type+" >=to_date('"+date_satrt+"','yyyy-mm-dd')");
		sql.append(" and "+date_type+" <=to_date('"+date_end+"','yyyy-mm-dd') ");
		
		/*	if(chargetype!=""){//付费方式
			sql.append(" and t.e601_24 = '"+chargetype+"'");
		}*/
		sql.append(("".equals(chargetype)?" ":" and t.e601_24 = '"+chargetype+"' "));
	/*	if(checktype!=""){//筛查类型
			sql.append(" and t.e601_23 = '"+checktype+"'");
		}*/
		sql.append(("".equals(checktype)?" ":" and t.e601_23 = '"+checktype+"' "));
		sql.append(" order by "+date_type+"");
		
		sql.append( " )r where rownum <="+EndOrder+" ) table_alias where table_alias.rowno >="+EndOrderID );
		
		String CountSQL = sql.toString();
		int Total = BatchGetDataCount(CountSQL);
		response.addIntHeader("gr_batch_total",Total);
	}

		StringBuffer sql = new StringBuffer();
		String date_type=null;
		String date_name=null;
		if("0".equals(date_status)){
			date_type="t.e601_26";
			date_name="采血日期";
		}else if("1".equals(date_status)){
			date_type="t.e601_34";
			date_name="录入日期";
		}else if("2".equals(date_status)){
			date_type="t.e601_37";
			date_name="邮寄日期";
		}else if("3".equals(date_status)){
			date_type="t.e601_39";
			date_name="审核日期";
		}else if("4".equals(date_status)){
			date_type="t.e601_73";
			date_name="报告日期";
		}
		sql.append("select * from(select rownum as rowno,r.*from( ");
		sql.append("select c.d101_02 as 筛查单位,t.e601_03 as 筛查对象姓名,t.e601_04 as 身份证号,a.d201_05 as 家庭地址 ,s.d201_05 as 现地址 ,");
		sql.append("t.e601_09 as 联系方式, case when t.e601_24='1' then '45' when t.e601_24='2' then '' end  as 筛查费用,");
		sql.append("'"+date_name+"'  as 日期,");
		sql.append(""+date_type+"  as 两病筛查,");
		sql.append("'"+date_satrt+"'  as 开始时间,");
		sql.append("'"+date_end+"'  as 结束时间");
		sql.append(" from e601 t,d201_ms a,z601_06 b,d101 c,d201_ms s ");
		sql.append(" where t.e601_49=a.d201_01(+) and t.e601_08=s.d201_01(+) and t.e601_24=b.z_01(+)  and t.e601_29=c.d101_01(+)");
		//sql.append(" and t.e601_29 like '"+institution+"%'");
		sql.append((institution.length() == 14?" and t.e601_29 = '"+institution+"'":" and t.e601_29 like '"+institution+"%'"));
		
		sql.append(" and "+date_type+" >=to_date('"+date_satrt+"','yyyy-mm-dd')");
		sql.append(" and "+date_type+" <=to_date('"+date_end+"','yyyy-mm-dd') ");
		
	/*	if(chargetype!=""){//付费方式
			sql.append(" and t.e601_24 = '"+chargetype+"'");
		}*/
		sql.append(("".equals(chargetype)?" ":" and t.e601_24 = '"+chargetype+"' "));
	/*	if(checktype!=""){//筛查类型
			sql.append(" and t.e601_23 = '"+checktype+"'");
		}*/
		sql.append(("".equals(checktype)?" ":" and t.e601_23 = '"+checktype+"' "));
		sql.append(" order by "+date_type+"");
		
		sql.append( " )r where rownum <="+EndOrder+" ) table_alias where table_alias.rowno >="+EndOrderID );
//System.out.println(sql);
%>
<%
XML_GenOneRecordset(response,sql.toString());
%>