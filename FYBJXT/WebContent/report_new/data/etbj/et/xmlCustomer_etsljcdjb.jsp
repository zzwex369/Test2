<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../GenXmlData.jsp"%>

<%
//  System.out.println(">>>>>>>>>>");
String timeStr=request.getParameter("timeStr");//开始时间
String timeEnd=request.getParameter("timeEnd");//结束时间
String institution=request.getParameter("institution");//机构编码
String e70208=request.getParameter("e70208");//月龄
String e70273=request.getParameter("e70273");//录入时间 或 检查时间 或 下次检查时间
String e70204=request.getParameter("e70204");//托幼机构
String e70260=request.getParameter("e70260");//检查结果
String e70261=request.getParameter("e70261");//处理
String e70209=request.getParameter("e70209");//筛查类型 


int StartNo = Integer.parseInt( request.getParameter("StartNo") );
int WantRows = Integer.parseInt( request.getParameter("WantRecords") );

int EndOrderID = (StartNo-1)*WantRows+1;
int EndOrder = StartNo * WantRows;


	//说明：设置Http头"gr_batch_total"并不是必须的
	//如果是第一次取数，在Http头中指定记录数，以便客户端在开始时就产生准确的分页信息
/*	if(StartNo == 1){
		StringBuffer sql = new StringBuffer("select * from(select rownum as rowno,r.*from(");
		sql.append("select t.E701_06,t.E701_07,t.E701_09,t.E701_17,t.e702_08,t.E701_20,t.E70107_ZH,t.E702_09ZH,t.E702_61ZH,");
		sql.append("t.E702_71,t.E702_60ZH,t.E702_68ZH,t.E702_71ZH,t.E702_73,t.E702_70,t.E702_67,t.E702_04ZH,");
		sql.append("a.E70408_ZH from ");
		sql.append("v_e702 t , V_E704 a where t.e702_02 = a.e704_02(+) and t.e702_60zh in('无异常','异常')  ");*/
	/*	if(institution.length()==14){
			sql.append(" and t.E702_71 = '"+institution+"'");
		}else{
			sql.append(" and t.E702_71 like '"+institution+"%'");
		}*/
	//	sql.append((institution.length()==14?" and t.E702_71 = '"+institution+"'":" and t.E702_71 like '"+institution+"%'"));
		//sql.append(" and t.e702_73>=to_date('"+timeStr+"','yyyy-mm-dd')  and  t.e702_73<=to_date('"+timeEnd+"','yyyy-mm-dd')");
	/*	if("000".equals(e70208)){
			sql.append(" and t.e702_08 >='0' and t.e702_08 <= '36'");
		}else {
			sql.append("  and t.e702_08 = '"+ e70208 +"'");
		}*/
	/*	sql.append(("000".equals(e70208)?" and t.e702_08 >='0' and t.e702_08 <= '36'":" and t.e702_08 = '"+ e70208 +"'"));
		if("0".equals(e70273)){
			sql.append(" and t.e702_73>=to_date('"+timeStr+"','yyyy-mm-dd')  and  t.e702_73<=to_date('"+timeEnd+"','yyyy-mm-dd')");
		}else if("1".equals(e70273)){
			sql.append(" and t.E702_70>=to_date('"+timeStr+"','yyyy-mm-dd')  and  t.E702_70<=to_date('"+timeEnd+"','yyyy-mm-dd')");
		}else if("2".equals(e70273)){
			sql.append(" and t.E702_67>=to_date('"+timeStr+"','yyyy-mm-dd')  and  t.E702_67<=to_date('"+timeEnd+"','yyyy-mm-dd')");
		}*/
		//sql.append();
	/*	if(e70204.equals("")){
			sql.append("  ");
		}else{
			sql.append(" and t.e702_04 = '"+ e70204 +"' ");
		}*/
	//	sql.append((e70204.equals("0")?" ":"  and t.e702_04 = '"+ e70204 +"'"));
	/*	if(e70260.equals("0")){
			sql.append("  ");
		}else if(e70260.equals("3")){
			sql.append(" and t.e702_60 = '"+ e70260 +"' ");
		}else if(e70260.equals("2")){
			sql.append(" and t.e702_60 = '"+ e70260 +"' ");
		}*/
	//	sql.append((e70260.equals("0")?" ":" and t.e702_60 = '"+ e70260 +"'"));
	/*	if(e70261.equals("0")){
			sql.append("  ");
		}else if(e70261.equals("1")){
			sql.append(" and t.e702_61 = '"+ e70261 +"' ");
		}else if(e70261.equals("2")){
			sql.append(" and t.e702_61 = '"+ e70261 +"' ");
		}else if(e70261.equals("3")){
			sql.append(" and t.e702_61 = '"+ e70261 +"' ");
		}*/
	//	sql.append((e70261.equals("0")?" ":" and t.e702_61 = '"+ e70261 +"'"));
	/*	if(e70209.equals("0")){
			sql.append("  ");
		}else if(e70209.equals("1")){
			sql.append(" and t.e702_09 = '"+ e70209 +"' ");	
		}else if(e70209.equals("2")){
			sql.append(" and t.e702_09 = '"+ e70209 +"' ");	
		}*/
	/*	sql.append((e70209.equals("0")?" ":" and t.e702_09 = '"+ e70209 +"' "));
		if("0".equals(e70273)){
				sql.append( " order by e702_73  " );
		}else if("1".equals(e70273)){
				sql.append( " order by e702_70   " );
		}else if("2".equals(e70273)){
				sql.append( " order by e702_67  " );
		}
		
		sql.append( " )r where rownum <="+EndOrder+" ) table_alias where table_alias.rowno >="+EndOrderID );

		String CountSQL = sql.toString();
		int Total = BatchGetDataCount(CountSQL);
		response.addIntHeader("gr_batch_total",Total);
	}*/

		StringBuffer sql = new StringBuffer("select * from(select rownum as rowno,r.*from(");
		sql.append("select t.E701_06,t.E701_07,t.E701_09,t.E701_17,t.e702_08,t.E701_20,t.E70107_ZH,t.E702_09ZH,t.E702_61ZH,");
		sql.append("t.E702_71,t.E702_60ZH,t.E702_68ZH,t.E702_71ZH,t.E702_73,t.E702_70,t.E702_67,t.E702_04ZH,");
		sql.append("a.E70408_ZH from ");
		sql.append("v_e702 t , V_E704 a where t.e702_02 = a.e704_02(+) and t.e702_60zh in('无异常','异常')  ");
	/*	if(institution.length()==14){
			sql.append(" and t.E702_71 = '"+institution+"'");
		}else{
			sql.append(" and t.E702_71 like '"+institution+"%'");
		}*/
		sql.append((institution.length()==14?" and t.E702_71 = '"+institution+"'":" and t.E702_71 like '"+institution+"%'"));
		//sql.append(" and t.e702_73>=to_date('"+timeStr+"','yyyy-mm-dd')  and  t.e702_73<=to_date('"+timeEnd+"','yyyy-mm-dd')");
	/*	if("000".equals(e70208)){
			sql.append(" and t.e702_08 >='0' and t.e702_08 <= '36'");
		}else {
			sql.append("  and t.e702_08 = '"+ e70208 +"'");
		}*/
		sql.append(("000".equals(e70208)?" and t.e702_08 >='0' and t.e702_08 <= '36'":" and t.e702_08 = '"+ e70208 +"'"));
		if("0".equals(e70273)){
			sql.append(" and t.e702_73>=to_date('"+timeStr+"','yyyy-mm-dd')  and  t.e702_73<=to_date('"+timeEnd+"','yyyy-mm-dd')");
		}else if("1".equals(e70273)){
			sql.append(" and t.E702_70>=to_date('"+timeStr+"','yyyy-mm-dd')  and  t.E702_70<=to_date('"+timeEnd+"','yyyy-mm-dd')");
		}else if("2".equals(e70273)){
			sql.append(" and t.E702_67>=to_date('"+timeStr+"','yyyy-mm-dd')  and  t.E702_67<=to_date('"+timeEnd+"','yyyy-mm-dd')");
		}
	/*	if(e70204.equals("")){
			sql.append("  ");
		}else{
			sql.append(" and t.e702_04 = '"+ e70204 +"' ");
		}*/
		sql.append((e70204.equals("")?" ":" and t.e702_04 = '"+ e70204 +"'"));
	/*	if(e70260.equals("0")){
			sql.append("  ");
		}else if(e70260.equals("3")){
			sql.append(" and t.e702_60 = '"+ e70260 +"' ");
		}else if(e70260.equals("2")){
			sql.append(" and t.e702_60 = '"+ e70260 +"' ");
		}*/
		sql.append((e70260.equals("0")?" ":" and t.e702_60 = '"+ e70260 +"'"));
	/*	if(e70261.equals("0")){
			sql.append("  ");
		}else if(e70261.equals("1")){
			sql.append(" and t.e702_61 = '"+ e70261 +"' ");
		}else if(e70261.equals("2")){
			sql.append(" and t.e702_61 = '"+ e70261 +"' ");
		}else if(e70261.equals("3")){
			sql.append(" and t.e702_61 = '"+ e70261 +"' ");
		}*/
		sql.append((e70261.equals("0")?" ":" and t.e702_61 = '"+ e70261 +"'"));
	/*	if(e70209.equals("0")){
			sql.append("  ");
		}else if(e70209.equals("1")){
			sql.append(" and t.e702_09 = '"+ e70209 +"' ");	
		}else if(e70209.equals("2")){
			sql.append(" and t.e702_09 = '"+ e70209 +"' ");	
		}*/
		sql.append((e70209.equals("0")?" ":" and t.e702_09 = '"+ e70209 +"' "));
		if("0".equals(e70273)){
				sql.append( "order by e702_73  " );
		}else if("1".equals(e70273)){
				sql.append( "order by e702_70   " );
		}else if("2".equals(e70273)){
				sql.append( "order by e702_67  " );
		}
		
		sql.append( " )r where rownum <="+EndOrder+" ) table_alias where table_alias.rowno >="+EndOrderID );

 // System.out.println(sql);

%>
<%
XML_GenOneRecordset(response,sql.toString());
%>