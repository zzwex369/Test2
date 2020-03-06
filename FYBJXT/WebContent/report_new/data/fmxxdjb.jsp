<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
	String timeStr=request.getParameter("timeStr");
	String timeEnd=request.getParameter("timeEnd");
	String institution=request.getParameter("institution");
	String time=request.getParameter("time");
	
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
	/*if(StartNo == 1){
		StringBuffer sql = new StringBuffer("select * from(select rownum as rowno,r.*from(");
		
		sql.append( "select D601_02_ZH,D601_03,D601_03 D601_03_hm,D601_04,D601_05,D601_06_ZH,D601_07,D601_08_ZH,D601_09_ZH,");
		sql.append( "D601_10,D601_11_ZH,D601_12,D601_13,D601_14,D601_18_ZH,D601_19,D601_20,D601_21,D601_23_ZH,");
		sql.append( "D601_24,D601_27,D601_28,D601_29,D601_30,D601_31,D601_33_ZH,D601_34_ZH,D601_35,D601_36,");
		sql.append( "D601_37,D601_38_ZH,D601_39,D601_41,D601_42,D601_43,D601_44,D601_45_ZH,D601_46_ZH,D601_47_ZH,");
		sql.append( "D601_48_ZH,D601_53,D601_54,D601_55,D601_56,D601_57,D601_57_ZH,D601_58,D601_59,D601_60,D601_61,");
		sql.append( "D601_62,D601_63,D601_64,D601_65,D601_66_ZH,D601_67,D601_68_ZH,D601_69,D601_70,D601_71,D601_72,D601_73,");
		sql.append( "D601_74_ZH,D601_75,D601_94_ZH,D601_77_ZH,D601_78_ZH,D601_79_ZH,D601_80_ZH,D601_81_ZH,D601_82_ZH,D601_83_ZH,D601_84_ZH, ");
		sql.append( "D601_16,D601_17,D601_25,D601_26,D601_32,D601_40,D601_51,D601_52 ");
		
		sql.append( "from V_D601  ");
		//sql.append( "where D601_13 >= to_date('"+timeStr+"','yyyy-mm-dd') and D601_13 <= to_date('"+timeEnd+"','yyyy-mm-dd')  " );
		if("1".equals(time)){
			sql.append( "where D601_03 >= to_date('"+timeStr+"','yyyy-mm-dd') and D601_03 <= to_date('"+timeEnd+"','yyyy-mm-dd')  " );
		}else if("2".equals(time)){
			sql.append( "where D601_13 >= to_date('"+timeStr+"','yyyy-mm-dd') and D601_13 <= to_date('"+timeEnd+"','yyyy-mm-dd')  " );
		}else if("3".equals(time)){
			sql.append( "where D601_60 >= to_date('"+timeStr+"','yyyy-mm-dd') and D601_60 <= to_date('"+timeEnd+"','yyyy-mm-dd')  " );
		}
		
		if(institution.length() == 14){
			sql.append("and D601_57 = '"+institution+"' ");
		}else{
			sql.append("and D601_57 like '"+institution+"%' ");
		}
		if("1".equals(time)){
			sql.append( "order by D601_03  " );
		}else if("2".equals(time)){
			sql.append( "order by D601_13   " );
		}else if("3".equals(time)){
			sql.append( "order by D601_60  " );
		}
		sql.append( " )r where rownum <="+EndOrder+" ) table_alias where table_alias.rowno >="+EndOrderID );
		
		String CountSQL = sql.toString();
		int Total = BatchGetDataCount(CountSQL);
		response.addIntHeader("gr_batch_total",Total);
	}*/
	
	
	StringBuffer sql = new StringBuffer("select * from(select rownum as rowno,r.*from(");
		
		sql.append( "select D601_02_ZH,D601_03,D601_03 D601_03_hm,D601_04,D601_05,D601_06_ZH,D601_07,D601_08_ZH,D601_09_ZH,");
		sql.append( "D601_10,D601_11_ZH,D601_12,D601_13,D601_14,D601_18_ZH,D601_19,D601_20,D601_21,D601_23_ZH,");
		sql.append( "D601_24,D601_27,D601_28,D601_29,D601_30,D601_31,D601_33_ZH,D601_34_ZH,D601_35,D601_36,");
		sql.append( "D601_37,D601_38_ZH,D601_39,D601_41,D601_42,D601_43,D601_44,D601_45_ZH,D601_46_ZH,D601_47_ZH,");
		sql.append( "D601_48_ZH,D601_53,D601_54,D601_55,D601_56,D601_57,D601_57_ZH,D601_58,D601_59,D601_60,D601_61,");
		sql.append( "D601_62,D601_63,D601_64,D601_65,D601_66_ZH,D601_67,D601_68_ZH,D601_69,D601_70,D601_71,D601_72,D601_73,");
		sql.append( "D601_74_ZH,D601_75,D601_94_ZH,D601_77_ZH,D601_78_ZH,D601_79_ZH,D601_80_ZH,D601_81_ZH,D601_82_ZH,D601_83_ZH,D601_84_ZH, ");
		sql.append( "D601_16,D601_17,D601_25,D601_26,D601_32,D601_40,D601_51,D601_52 ");
		
		sql.append( "from V_D601  ");
		//sql.append( "where D601_13 >= to_date('"+timeStr+"','yyyy-mm-dd') and D601_13 <= to_date('"+timeEnd+"','yyyy-mm-dd')  " );
		if("1".equals(time)){
			sql.append( "where  to_char(D601_03,'yyyy-mm-dd') >= '"+timeStr+"' and to_char(D601_03,'yyyy-mm-dd') <= '"+timeEnd+"'  " );
		}else if("2".equals(time)){
			sql.append( "where  to_char(D601_13,'yyyy-mm-dd') >= '"+timeStr+"' and to_char(D601_13,'yyyy-mm-dd') <= '"+timeEnd+"' " );
		}else if("3".equals(time)){
			sql.append( "where  to_char(D601_60,'yyyy-mm-dd') >= '"+timeStr+"' and to_char(D601_60,'yyyy-mm-dd') <= '"+timeEnd+"'  " );
		}
		
		if(institution.length() == 14){
			sql.append("and D601_57 = '"+institution+"' ");
		}else{
			sql.append("and D601_57 like '"+institution+"%' ");
		}
		if("1".equals(time)){
			sql.append( "order by D601_03  " );
		}else if("2".equals(time)){
			sql.append( "order by D601_13   " );
		}else if("3".equals(time)){
			sql.append( "order by D601_60  " );
		}
		sql.append( " )r where rownum <="+EndOrder+" ) table_alias where table_alias.rowno >="+EndOrderID );
	
  //System.out.println(sql);
%>
<%
XML_GenOneRecordset(response,sql.toString());
%>