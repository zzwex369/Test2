<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../GenXmlData.jsp"%>
<%!
	private String getDateFormat(String field,String dateStr,String dateEnd){
		
		return " and to_char("+field+",'yyyy-mm-dd')>='"+
		dateStr+"' and to_char("+field+",'yyyy-mm-dd')<='"
		+dateEnd+"' group by rws_04,rws_05 ";
	}
	
	private String getSubCode(String field,String [] fields,String code,int type,int length){
	  	String realField=type>1?field:fields[type];
	  	StringBuffer sql=new StringBuffer(" and substr("+realField+",0,"+length+")='"+code+"'");
	  	sql.append(type!=3?"and substr("+realField+",0,6)=rws_05 and rws_06='1' ":"and length(rws_05)=6 ");
		return  sql.toString();
		
	}
 %>
<%
	String dateStr= request.getParameter("dateStr");//开始时间
	String dateEnd= request.getParameter("dateEnd");//结束时间
	String code= request.getParameter("code");//机构编码        
	String statisticalMode=request.getParameter("statisticalMode");//统计模式 0 人数 1人次
	int type= Integer.parseInt(request.getParameter("codeType"));//机构编码       
	int codeLength=code.trim().length();
	String [] e301Code={"e301_12","e301_09"};//现住址  户口地址
	String [] e701Code={"e701_15","e701_16"};//现住址  户口地址

	
	
	StringBuffer sql = new StringBuffer("select rws_04 xq,rws_05 code,");		
				 sql.append("max(sl_0_3) sl_0_3,max(sl_3_6) sl_3_6,");
				 sql.append("max(sl_6) sl_6,max(sl_pro_6) sl_pro_6, max(sl_plan_0_3) sl_plan_0_3,");
				 sql.append("max(sl_plan_3_6) sl_plan_3_6 from(");
				 //sql.append("count(*) sl_0,0 sl_0_3,0 sl_3_6,0 sl_6,0 sl_pro_6,0 sl_plan_0_3,");
				 //sql.append("0 sl_plan_3_6 from e305,e301,rws where e305_78=e301_01");
				 //sql.append(getSubCode("e305_81",e301Code,code,type,codeLength));
				 //sql.append("and e305_95 is not null"+getDateFormat("e305_74",dateStr,dateEnd));
				 //sql.append("union all ");
				 //sql.append("select rws_04,rws_05,count(*) sl_0_3,0 sl_3_6,0 sl_6,");
				 //sql.append("0 sl_pro_6,0 sl_plan_0_3,0 sl_plan_3_6 from e304,e301,rws where ");
				 //sql.append("e304_40=e301_01 and e304_02>0 and e304_02<20");
				 //sql.append(getSubCode("e304_45",e301Code,code,type,codeLength));
				 //sql.append("and e304_98 is not null"+getDateFormat("e304_04",dateStr,dateEnd));
				 sql.append("select rws_04,rws_05,count(ids) as sl_0_3,");
				 sql.append("0 sl_3_6,0 sl_6,0 sl_pro_6,0 sl_plan_0_3,0 sl_plan_3_6 from ");
				 sql.append("(select rws_04,rws_05,e305_78 ids from e305,e301,rws ");
				 sql.append("where e305_78 = e301_01"+getSubCode("e305_81",e301Code,code,type,codeLength));
         		 sql.append("and e305_95 is not null"+getDateFormat("e305_74",dateStr,dateEnd)+",e305_78 ");
                 sql.append("union "+("0".equals(statisticalMode)?"":"all "));//all
           	     sql.append("select rws_04,rws_05,e304_40 ids from e304,e301,rws ");
				 sql.append("where e304_40 = e301_01  and e304_02 > 0 and e304_02 < 20 ");
				 sql.append(getSubCode("e304_45",e301Code,code,type,codeLength));
				 sql.append("and e304_98 is not null"+getDateFormat("e304_04",dateStr,dateEnd));
				 sql.append(",e304_40)group by rws_04,rws_05 ");
				 sql.append("union all ");
				 //sql.append("select rws_04,rws_05,0 sl_0_3,count(*) sl_3_6,");
				 //sql.append("0 sl_6,0 sl_pro_6,0 sl_plan_0_3,0 sl_plan_3_6 from e702,e701,rws ");
				 //sql.append("where e702_02=e701_01 and e702_08>19 and e702_08<31 and e702_09='1'");
			     //sql.append(getSubCode("e702_71",e701Code,code,type,codeLength));
				 //sql.append(getDateFormat("e702_70",dateStr,dateEnd));

				 sql.append("select rws_04,rws_05,0 sl_0_3,");
				 sql.append(("0".equals(statisticalMode)?"count(sl_3_6)":"")+"sl_3_6,");///////////
				 sql.append("0 sl_6, 0 sl_pro_6,0 sl_plan_0_3,0 sl_plan_3_6 ");
				 sql.append("from (select rws_04,rws_05,");
				 sql.append(("0".equals(statisticalMode)?"e702_02":"count(e702_02)")+" sl_3_6 ");////
				 sql.append("from e702,e701,rws where e702_02=e701_01 ");
				 sql.append(" and e702_08 >19 and e702_08 < 33 and e702_09 = '1' ");
                 sql.append(getSubCode("e702_71",e701Code,code,type,codeLength));
                 sql.append(getDateFormat("e702_70",dateStr,dateEnd));
                 sql.append(("0".equals(statisticalMode)?",e702_02":"")+")");///
                 sql.append("group by rws_04,rws_05");/////
                 sql.append(("0".equals(statisticalMode)?"":",sl_3_6")+" ");///
                 sql.append("union all ");
				 sql.append("select rws_04,rws_05,0 sl_0_3,0 sl_3_6,count(*) sl_6,");
				 sql.append("0 sl_pro_6,0 sl_plan_0_3,0 sl_plan_3_6 from e702,e701,rws ");
				 sql.append("where e702_02=e701_01 and e702_08='32' and e702_09='1'");
				 sql.append(getSubCode("e702_71",e701Code,code,type,codeLength));
				 sql.append(getDateFormat("e702_70",dateStr,dateEnd));
				 sql.append("union all ");
				 sql.append("select rws_04,rws_05,0 sl_0_3,0 sl_3_6,0 sl_6,");
				 sql.append("count(*) sl_pro_6,0 sl_plan_0_3,0 sl_plan_3_6 from e702,e701,rws ");
				 sql.append("where e702_02=e701_01 and e702_08='32' and e702_09='1' and e702_29!='1'");
				 sql.append(getSubCode("e702_71",e701Code,code,type,codeLength));
				 sql.append("and (trim(E702_34)<='0.8' or trim(E702_35)<='0.8')");
				 sql.append(getDateFormat("e702_70",dateStr,dateEnd));
				 sql.append("union all ");
				 sql.append("select rws_04,rws_05,0 sl_0_3,0 sl_3_6,0 sl_6,0 sl_pro_6,to_number(rws_07) sl_plan_0_3,");
				 sql.append("0 sl_plan_3_6 from rws where rws_02=to_number('"+dateStr.substring(0,4)+"') and rws_06='1'");
				 sql.append(getSubCode("rws_05",e701Code,code,3,codeLength));
				 sql.append("union all ");
				 sql.append("select rws_04,rws_05,0 sl_0_3,0 sl_3_6,0 sl_6,");
				 sql.append("0 sl_pro_6,0 sl_plan_0_3,to_number(rws_07) sl_plan_3_6 from rws ");
				 sql.append("where rws_02=to_number('"+dateStr.substring(0,4)+"')and rws_06='2'");
				 sql.append(getSubCode("rws_05",e701Code,code,3,codeLength));
				 sql.append(")group by rws_04,rws_05 order by rws_05 ");
				
 
       
   // System.out.println(sql);

%>

<%
XML_GenOneRecordset(response,sql.toString());
%>