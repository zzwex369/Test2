<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../GenXmlData.jsp"%>
<%
 //  System.out.println(">>>>>>>>>>");
String timeStr=request.getParameter("timeStr");//开始时间
String timeEnd=request.getParameter("timeEnd");//结束时间
String institution=request.getParameter("institution");//机构编码
String e70208=request.getParameter("e70208");//月龄
String time=request.getParameter("time");//录入时间 或 检查时间 或 下次检查时间

//int OrderID =  Integer.parseInt( request.getParameter("OrderID") );
//System.out.println(OrderID);
int StartNo = Integer.parseInt( request.getParameter("StartNo") );
int WantRows = Integer.parseInt( request.getParameter("WantRecords") );
//System.out.println(StartNo);
/*if (OrderID==0)
	OrderID = 1;
int EndOrderID = OrderID + WantRows;*/

	int EndOrderID = (StartNo-1)*WantRows+1;
	int EndOrder = StartNo * WantRows;
	//说明：设置Http头"gr_batch_total"并不是必须的
	//如果是第一次取数，在Http头中指定记录数，以便客户端在开始时就产生准确的分页信息
/*	if(StartNo == 1){
		StringBuffer sql = new StringBuffer("select * from(select rownum as rowno,r.*from(");
		sql.append("select t.E702_67,t.E702_70,t.E701_06,t.E701_07,t.E701_09,t.E702_09zh,t.E701_17,t.e702_08,t.E701_20,t.E702_73,t.E70107_ZH,");
		sql.append("t.E702_71,t.E702_60ZH,t.E702_68zh,t.E702_71ZH,");
		sql.append("a.E70408_ZH from ");
		sql.append("v_e702 t , V_E704 a where t.e702_02 = a.e704_02(+)  ");
		
		if("1".equals(time)){
			sql.append("and e702_73>=to_date('"+timeStr+"','yyyy-mm-dd')  and e702_73<=to_date('"+timeEnd+"','yyyy-mm-dd')");
		}else if("2".equals(time)){
			sql.append("and e702_70>=to_date('"+timeStr+"','yyyy-mm-dd')  and e702_70<=to_date('"+timeEnd+"','yyyy-mm-dd')");
		}else if("3".equals(time)){
			sql.append("and e702_67>=to_date('"+timeStr+"','yyyy-mm-dd')  and e702_67<=to_date('"+timeEnd+"','yyyy-mm-dd')");
		}*/
	/*	if(institution.length()==14){
			sql.append(" and E702_71 = '"+institution+"'");
		}else{
			sql.append(" and E702_71 like '%"+institution+"%'");
		}*/
	//	sql.append((institution.length()==14?" and E702_71 = '"+institution+"' ":" and E702_71 like '%"+institution+"%' "));
	/*	if("".equals(e70208)){
			sql.append(" and e702_08 >= '0' and e702_08 <= '35' ");
		}else {
			sql.append("  and e702_08 = "+ e70208 +"");
		}*/
	/*	sql.append(("".equals(e70208)?" and e702_08 >= '0' and e702_08 <= '35' ":" and e702_08 = '"+ e70208 +"' "));
		sql.append(" and e702_60zh = '异常' ");
		
		if("1".equals(time)){
				sql.append( "order by e702_73  " );
		}else if("2".equals(time)){
				sql.append( "order by e702_70   " );
		}else if("3".equals(time)){
				sql.append( "order by e702_67  " );
		}
		sql.append( " )r where rownum <="+EndOrder+" ) table_alias where table_alias.rowno >="+EndOrderID );

		String CountSQL = sql.toString();
		int Total = BatchGetDataCount(CountSQL);
		response.addIntHeader("gr_batch_total",Total);
	}*/



		StringBuffer sql = new StringBuffer("select * from(select rownum as rowno,r.*from(");
		sql.append("select t.E702_67,t.E702_70,t.E701_06,t.E701_07,t.E701_09,t.E702_09zh,t.E701_17,t.e702_08,t.E701_20,t.E702_73,t.E70107_ZH,");
		sql.append("t.E702_71,t.E702_60ZH,t.E702_68zh,t.E702_71ZH,");
		sql.append("a.E70408_ZH from ");
		sql.append("v_e702 t , V_E704 a where t.e702_02 = a.e704_02(+)  ");
		
		if("1".equals(time)){
			sql.append("and e702_73>=to_date('"+timeStr+"','yyyy-mm-dd')  and e702_73<=to_date('"+timeEnd+"','yyyy-mm-dd')");
		}else if("2".equals(time)){
			sql.append("and e702_70>=to_date('"+timeStr+"','yyyy-mm-dd')  and e702_70<=to_date('"+timeEnd+"','yyyy-mm-dd')");
		}else if("3".equals(time)){
			sql.append("and e702_67>=to_date('"+timeStr+"','yyyy-mm-dd')  and e702_67<=to_date('"+timeEnd+"','yyyy-mm-dd')");
		}
	/*	if(institution.length()==14){
			sql.append(" and E702_71 = '"+institution+"'");
		}else{
			sql.append(" and E702_71 like '%"+institution+"%'");
		}*/
		sql.append((institution.length()==14?" and E702_71 = '"+institution+"' ":" and E702_71 like '%"+institution+"%' "));
	/*	if("".equals(e70208)){
			sql.append(" and e702_08 >= '0' and e702_08 <= '35' ");
		}else {
			sql.append("  and e702_08 = "+ e70208 +"");
		}*/
		sql.append(("".equals(e70208)?" and e702_08 >= '0' and e702_08 <= '35' ":" and e702_08 = '"+ e70208 +"' "));
		sql.append(" and e702_60zh = '异常' ");
		
		if("1".equals(time)){
				sql.append( "order by e702_73  " );
		}else if("2".equals(time)){
				sql.append( "order by e702_70   " );
		}else if("3".equals(time)){
				sql.append( "order by e702_67  " );
		}
		sql.append( " )r where rownum <="+EndOrder+" ) table_alias where table_alias.rowno >="+EndOrderID );
//   System.out.println(sql);

%>
<%
XML_GenOneRecordset(response,sql.toString());
%>