<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData_msmxb.jsp" %>
<%
String dateStr= request.getParameter("dateStr");
String dateEnd= request.getParameter("dateEnd");
String code= request.getParameter("code");
String addType= request.getParameter("addType");
String [] presentAdd={"d601_66","f501_34","f601_44","e504_09","e601_08"};//现住址
String [] permanentAdd={"d601_92","f501_42","f601_56","e504_61","e601_49"};;//户口住址
String [] address=(addType.equals("presentAdd"))?presentAdd:permanentAdd;
int i=code.length();
String d201Field=i==4?"d201_02":"d201_01";
    //String sql="";

	//sql="select a.code as code,nvl(a.xq,b.xq) as xq,d601cout,f501,f501_1,nvl(f602,0)as f602,nvl(a.f602_1,0)as f602_1,nvl(e505,0)as e505, nvl(a.e505_1,0)as e505_1,nvl(b.e601,0)as e601,nvl(b.e601_1,0)as e601_1 from(select a.code as code,nvl(a.xq,b.xq) as xq, d601cout,a.f501,a.f501_1,b.f602,b.f602_1,b.e505,b.e505_1 from (select a.code, nvl(a.xq,b.xq) as xq, d601cout,nvl(f501,0) as f501,nvl(f501_1,0) as f501_1 from(select xq,d601cout,code from(select nvl(a.d60120104,ms.d201_04)as xq,nvl(code,ms.d201_01)as code, nvl(d601cout,0) as d601cout from (select t.d201_01,t.d201_04 from d201_ms t where t.d201_01='"+code+"' order by t.d201_01) ms left join (select  COUNT(d.D601_01) as d601cout,ms_01.d201_04 as d60120104,ms_01.d201_01 as code from(select d601.d601_92,d601.d601_01 from d601 d601 where to_char(d601.d601_03,'yyyy')='2018' and substr(d601.d601_92,0,to_number("+i+"))='"+code+"') d,(select t.d201_01,t.d201_04 from d201_ms t where t.d201_02='4113') ms_01 where substr(d.d601_92,0,6)=ms_01.d201_01 GROUP BY ms_01.d201_04, ms_01.d201_01 ) a on a.d60120104=ms.d201_04) x ) a left join (select nvl(b.code,c.code) as code,nvl(c.f50220104_1,b.f50220104)as xq ,nvl(b.f502count,0)as f501, nvl(c.f502count1,0)as f501_1 from(select count(a.f502_01) as f502count ,ms_03.d201_04 as f50220104 ,ms_03.d201_01 as code from f501 b,(select ms.d201_01,ms.d201_04 from d201_ms ms where ms.d201_02='4113') ms_03,(select f.f502_02,f.f502_01 from f502 f where to_char(f.f502_24,'yyyy-mm-dd')>='"+dateStr+"' and to_char(f.f502_24,'yyyy-mm-dd')<='"+dateEnd+"' ) a  where a.f502_02=b.f501_01 and substr(b.f501_42,0,6)=ms_03.d201_01 group by ms_03.d201_04, ms_03.d201_01) b full join(select count(a.f502_01) as f502count1 ,ms_03.d201_04  as f50220104_1,ms_03.d201_01 as code from(select f501_01,f501_42 from f501) f1,(select ms.d201_01,ms.d201_04 from d201_ms ms where ms.d201_02='4113' ) ms_03,(select f.f502_02,f.f502_01 from f502 f where f.f502_35='1'and to_char(f.f502_24,'yyyy-mm-dd')>='"+dateStr+"'  and to_char(f.f502_24,'yyyy-mm-dd')<='"+dateEnd+"' ) a where a.f502_02=f1.f501_01 and substr(f1.f501_42,0,6)=ms_03.d201_01 group by ms_03.d201_04, ms_03.d201_01) c on b.f50220104 = c.f50220104_1) b on a.xq=b.xq) a left join (select nvl(a.code,b.code)as code, nvl(a.xq,b.xq)as xq ,a.f602,a.f602_1,b.e505,b.e505_1 from(select nvl(a.code,b.code)as code, nvl(a.xq,b.xq)as xq ,a.f602 as f602,b.f602_1 as f602_1 from(select count(f2.f602_01) as f602 ,ms_04.d201_04 as xq,ms_04.d201_01 as code  from(select f601_01,f601_56 from f601 where substr(f601_56,0,to_number("+i+"))='"+code+"') f1,(select ms.d201_01,ms.d201_04 from d201_ms ms where ms.d201_02='4113' )ms_04,(select c.f602_01,c.f602_02 from f602 c where to_char(c.f602_23,'yyyy-mm-dd')>='"+dateStr+"' and to_char(c.f602_23,'yyyy-mm-dd')<='"+dateEnd+"') f2  where  f2.f602_02=f1.f601_01 and substr(f1.f601_56,0,6)=ms_04.d201_01 group by  ms_04.d201_04, ms_04.d201_01 order by ms_04.d201_01) a full join (select count(f2.f602_01)as f602_1 ,ms_04.d201_04 as xq,ms_04.d201_01 as code from (select f601_01,f601_56 from f601  where  substr(f601_56,0,to_number("+i+"))='"+code+"') f1,(select ms.d201_01,ms.d201_04 from d201_ms ms where ms.d201_02='4113') ms_04,(select c.f602_01,c.f602_02 from f602 c where to_char(c.f602_23,'yyyy-mm-dd')>='"+dateStr+"'  and to_char(c.f602_23,'yyyy-mm-dd')<='"+dateEnd+"' or c.f602_16='3' or c.f602_18='3' or c.f602_20='3' or c.f602_22='3' or c.f602_29='3') f2 where f2.f602_02=f1.f601_01  and substr(f1.f601_56,0,6)=ms_04.d201_01 group by  ms_04.d201_04 ,ms_04.d201_01) b on a.xq = b.xq) a full join(select nvl(a.code,b.code)as code,nvl(a.xq,b.xq)as xq ,nvl(a.e505,0)as e505, nvl(b.e505_1,0)as e505_1 from(select count(e2.e505_01) as e505 ,ms_02.d201_04 as xq,ms_02.d201_01 as code from(select e.e504_01,e.e504_61 from e504 e where substr(e.e504_61,0,to_number("+i+"))='"+code+"') e1,(select ms.d201_01,ms.d201_04 from d201_ms ms where ms.d201_02='4113' ) ms_02,(select e.e505_01,e.e505_02 from e505 e where to_char(e505_29,'yyyy-mm-dd')>='"+dateStr+"' and to_char(e505_29,'yyyy-mm-dd')<='"+dateEnd+"') e2 where e1.e504_01=e2.e505_02 and substr(e1.e504_61,0,6)=ms_02.d201_01 group by ms_02.d201_04,ms_02.d201_01 order by ms_02.d201_01) a full join(select count(e2.e505_01) as e505_1 ,ms_02.d201_04 as xq ,ms_02.d201_01 as code from(select e.e504_01,e.e504_61 from e504 e where substr(e.e504_61,0,to_number("+i+"))='"+code+"') e1,(select ms.d201_01,ms.d201_04 from d201_ms ms where ms.d201_02='4113') ms_02,(select e.e505_01,e.e505_02 from e505 e where e505_25='2' and e505_26='2' and to_char(e505_29,'yyyy-mm-dd')>='"+dateStr+"' and to_char(e505_29,'yyyy-mm-dd')<='"+dateEnd+"') e2 where e1.e504_01=e2.e505_02 and substr(e1.e504_61,0,6)=ms_02.d201_01 group by ms_02.d201_04 ,ms_02.d201_01) b on a.xq = b.xq  ) b on a.xq=b.xq) b on a.xq=b.xq) a left join (select nvl(a.code,b.code)as code, nvl(a.xq,b.xq)as xq ,nvl(a.e601,0)as e601, nvl(b.e601_1,0)as e601_1 from(select count(e1.e601_01) as e601 ,ms_02.d201_04 as xq ,ms_02.d201_01 as code from(select e.e601_01,e.e601_49 from e601 e where substr(e.e601_49,0,to_number("+i+"))='"+code+"' and e601_36='3' and to_char(e601_39,'yyyy-mm-dd')>='"+dateStr+"' and to_char(e601_39,'yyyy-mm-dd')<='"+dateEnd+"') e1,(select ms.d201_01,ms.d201_04 from d201_ms ms where ms.d201_02='4113' ) ms_02 where substr(e1.e601_49,0,6)=ms_02.d201_01  group by ms_02.d201_04 , ms_02.d201_01 order by ms_02.d201_01) a  left join (select count(e1.e601_01) as e601_1 ,ms_02.d201_04 as xq,ms_02.d201_01 as code from(select e.e601_01,e.e601_49 from e601 e where substr(e.e601_49,0,to_number("+i+"))='"+code+"' and e601_36='3'  and to_char(e601_39,'yyyy-mm-dd')>='"+dateStr+"'  and to_char(e601_39,'yyyy-mm-dd')<='"+dateEnd+"') e1,(select ms.d201_01,ms.d201_04 from d201_ms ms where ms.d201_02='4113' ) ms_02 where substr(e1.e601_49,0,6)=ms_02.d201_01 group by ms_02.d201_04,ms_02.d201_01) b on a.xq =b.xq)b on a.xq = b.xq order by code";
	StringBuffer sql=new StringBuffer("select a.code as code,nvl(a.xq,b.xq) as xq,");
	sql.append("d601cout,f501,f501_1,nvl(f601,0)as f602,nvl(a.f602_1,0)as f602_1,nvl(e504,0)as e505,");
	sql.append("nvl(a.e505_1,0)as e505_1,nvl(b.e601,0)as e601,nvl(b.e601_1,0)as e601_1 from(select a.code as code,");
	sql.append("nvl(a.xq,b.xq) as xq, d601cout,a.f501,a.f501_1,b.f601,b.f602_1,b.e504,b.e505_1 ");
	sql.append("from(select a.code, nvl(a.xq,b.xq) as xq, d601cout,nvl(f501,0) as f501,");
	sql.append("nvl(f501_1,0) as f501_1 from(select xq,d601cout,code from(");
	sql.append("select nvl(a.d60120104,ms.d201_04)as xq,nvl(code,ms.d201_01)as code,");
	sql.append("nvl(d601cout,0) as d601cout from(select t.d201_01,t.d201_04 from d201_ms t ");
	sql.append("where "+d201Field+"='"+code+"' order by t.d201_01) ms left join (");
	sql.append("select  COUNT(d.D601_01) as d601cout,ms_01.d201_04 as d60120104,ms_01.d201_01 as code from(");
	sql.append("select "+address[0]+",d601.d601_01 from d601 d601 where to_char(d601.d601_03,'yyyy-mm-dd')>='"+dateStr+"' ");
	sql.append("and to_char(d601.d601_03,'yyyy-mm-dd')<='"+dateEnd+"' and ");
	sql.append("substr("+address[0]+",0,to_number("+i+"))='"+code+"') d,( select t.d201_01,t.d201_04 from d201_ms t ");
	sql.append("where "+d201Field+"='"+code+"') ms_01 where substr("+address[0]+",0,6)=ms_01.d201_01 ");
	sql.append("group by ms_01.d201_04, ms_01.d201_01 ) a on a.d60120104=ms.d201_04) x  ) a left join (");
	sql.append("select nvl(b.code,c.code) as code,nvl(c.f50220104_1,b.f50220104)as xq,");
	sql.append("nvl(b.f501count,0)as f501, nvl(c.f502count1,0)as f501_1 from(");
	sql.append("select count(b.f501_01) as f501count,ms_03.d201_04 as f50220104,ms_03.d201_01 as code from");
	sql.append("(select f501_01,"+address[1]+" from f501 f where substr("+address[1]+",0,to_number("+i+"))='"+code+"'");
	sql.append(" and f501_30='1') b,");
	sql.append("(select ms.d201_01,ms.d201_04 from d201_ms ms where "+d201Field+"='"+code+"') ms_03, ");
	/***f502*/
 	sql.append("(select f502_02 from f502 a where to_char(a.f502_24,'yyyy-mm-dd')>='"+dateStr+"'"); 
    sql.append("and to_char(a.f502_24,'yyyy-mm-dd')<='"+dateEnd+"' ) f2 ");
	sql.append("where b.f501_01=f2.f502_02 and substr("+address[1]+",0,6)=ms_03.d201_01 group by ms_03.d201_04, ms_03.d201_01) b ");
	sql.append("full join(select count(f501_01) as f502count1 ,ms_03.d201_04  as f50220104_1,ms_03.d201_01 as code from ");
	sql.append("(select f501_01,f501_28,"+address[1]+" from f501 f where substr("+address[1]+",0,to_number("+i+"))='"+code+"'");
    sql.append(" and f501_30='1') f1,");
     
	sql.append("(select ms.d201_01,ms.d201_04 from d201_ms ms where "+d201Field+"='"+code+"') ms_03, ");
	sql.append("(select f502_02 from f502 a where to_char(a.f502_24,'yyyy-mm-dd')>='"+dateStr+"'"); 
    sql.append("and to_char(a.f502_24,'yyyy-mm-dd')<='"+dateEnd+"' and f502_38='2') f2 ");
	sql.append("where f2.f502_02= f1.f501_01 and substr("+address[1]+",0,6)=ms_03.d201_01 group by ms_03.d201_04,ms_03.d201_01) c ");
	sql.append("on b.f50220104 = c.f50220104_1) b on a.xq=b.xq) a left join");
	sql.append("(select nvl(a.code,b.code)as code,nvl(a.xq,b.xq)as xq,a.f601,a.f602_1,b.e504,b.e505_1 from(");
	sql.append("select nvl(a.code,b.code)as code,nvl(a.xq,b.xq)as xq,a.f601 as f601,b.f602_1 as f602_1 from(");
	sql.append("select count(f601_01) as f601,ms_04.d201_04 as xq,ms_04.d201_01 as code from(");
		/***f601*/
	sql.append("select f601_01,f601_71,"+address[2]+" from f601 where substr("+address[2]+",0,to_number("+i+"))='"+code+"' ");
	sql.append("and to_char(f601_71,'yyyy-mm-dd')>='"+dateStr+"' and to_char(f601_71,'yyyy-mm-dd')<='"+dateEnd+"' and f601_41='1') f1,");
	sql.append("(select ms.d201_01,ms.d201_04 from d201_ms ms where "+d201Field+"='"+code+"') ms_04 ");
	sql.append("where substr("+address[2]+",0,6)=ms_04.d201_01 group by  ms_04.d201_04, ms_04.d201_01 order by ms_04.d201_01) a ");
	
	sql.append("full join(select count(f2.f602_01)as f602_1 ,ms_04.d201_04 as xq,ms_04.d201_01 as code from (");
	sql.append("select f601_01,f601_71,"+address[2]+" from f601 where substr("+address[2]+",0,to_number("+i+"))='"+code+"' ");
	sql.append("and to_char(f601_71,'yyyy-mm-dd')>='"+dateStr+"' and to_char(f601_71,'yyyy-mm-dd')<='"+dateEnd+"' and f601_41='1') f1,");
	sql.append("(select ms.d201_01,ms.d201_04 from d201_ms ms where "+d201Field+"='"+code+"') ms_04,");
	sql.append("(select c.f602_01,c.f602_02 from f602 c where  c.f602_16='3' or c.f602_18='3' ");
	sql.append("or c.f602_20='3' or c.f602_22='3' or c.f602_29='3') f2 where f2.f602_02=f1.f601_01 ");
	sql.append("and substr("+address[2]+",0,6)=ms_04.d201_01 group by  ms_04.d201_04 ,ms_04.d201_01) b on a.xq = b.xq) a ");
	sql.append("full join(select nvl(a.code,b.code)as code,nvl(a.xq,b.xq)as xq ,nvl(a.e504,0)as e504, nvl(b.e505_1,0)as e505_1 from(");
	sql.append("select count(e504_01) as e504 ,ms_02.d201_04 as xq,ms_02.d201_01 as code from(");
	sql.append("select e.e504_01,"+address[3]+" from e504 e where substr("+address[3]+",0,to_number("+i+"))='"+code+"' and e504_19='1') e1,(");
 
  
	sql.append("select ms.d201_01,ms.d201_04 from d201_ms ms where "+d201Field+"='"+code+"') ms_02, ");
	
	sql.append("(select distinct t.e505_02 from e505 t where to_char(e505_29,'yyyy-mm-dd')>='"+dateStr+"'");  
  	sql.append("and to_char(e505_29,'yyyy-mm-dd')<='"+dateEnd+"' and e505_26='0') e2 "); 
	
	sql.append("where e2.e505_02=e1.e504_01 and substr("+address[3]+",0,6)=ms_02.d201_01 group by ms_02.d201_04,ms_02.d201_01 order by ms_02.d201_01) a ");
	sql.append("full join(select count(e504_01) as e505_1 ,ms_02.d201_04 as xq ,ms_02.d201_01 as code from(");
	sql.append("select e.e504_01,"+address[3]+" from e504 e where substr("+address[3]+",0,to_number("+i+"))='"+code+"' and e504_19='1') e1,(");
	
	sql.append("select ms.d201_01,ms.d201_04 from d201_ms ms where "+d201Field+"='"+code+"') ms_02, ");
	
	sql.append("(select distinct t.e505_02 from e505 t where to_char(e505_29,'yyyy-mm-dd')>='"+dateStr+"' ");  
  	sql.append("and to_char(e505_29,'yyyy-mm-dd')<='"+dateEnd+"' and e505_25='1' and e505_26='1') e2 "); 

	sql.append("where e2.e505_02=e1.e504_01 and substr("+address[3]+",0,6)=ms_02.d201_01 ");
	sql.append("group by ms_02.d201_04 ,ms_02.d201_01) b on a.xq = b.xq) b on a.xq=b.xq) b on a.xq=b.xq) a left join (");
	sql.append("select nvl(a.code,b.code)as code, nvl(a.xq,b.xq)as xq ,nvl(a.e601,0)as e601, nvl(b.e601_1,0)as e601_1 from(");
	sql.append("select count(e1.e601_01) as e601 ,ms_02.d201_04 as xq ,ms_02.d201_01 as code from(");
	sql.append("select e.e601_01,e601_34,"+address[4]+" from e601 e where substr("+address[4]+",0,to_number("+i+"))='"+code+"' and ");
	sql.append("to_char(e601_34,'yyyy-mm-dd')>='"+dateStr+"' and to_char(e601_34,'yyyy-mm-dd')<='"+dateEnd+"' and e601_24='1') e1,(");
	sql.append("select ms.d201_01,ms.d201_04 from d201_ms ms where "+d201Field+"='"+code+"') ms_02 where ");
	sql.append("substr("+address[4]+",0,6)=ms_02.d201_01 group by ms_02.d201_04,ms_02.d201_01 order by ms_02.d201_01) ");
	sql.append("a left join(select count(e1.e601_01) as e601_1 ,ms_02.d201_04 as xq,ms_02.d201_01 as code from(");
	sql.append("select e.e601_01,e.e601_34,"+address[4]+" from e601 e where substr("+address[4]+",0,to_number("+i+"))='"+code+"' and e601_24='1' ");
	sql.append("and to_char(e601_34,'yyyy-mm-dd')>='"+dateStr+"' and to_char(e601_34,'yyyy-mm-dd')<='"+dateEnd+"' and (e601_57='阳性' or e601_59='阳性')) ");
	sql.append("e1,(select ms.d201_01,ms.d201_04 from d201_ms ms where "+d201Field+"='"+code+"') ms_02 ");
	sql.append("where substr("+address[4]+",0,6)=ms_02.d201_01 group by ms_02.d201_04,ms_02.d201_01) b on a.xq =b.xq");
	sql.append(")b on a.xq = b.xq  union all ");
	/***********************开始合并南阳市以外的统计信息**********************************/
	sql.append("select  nvl(a.code,b.code) as code ,nvl(a.xq,b.xq) as xq, nvl(d601cout,0) as d601cout,nvl(f501,0) as f501,");
	sql.append("nvl(f501_1,0) as f501_1,nvl(f602,0) as f602,nvl(f602_1,0) as f602_1,nvl(e505,0) as e505,nvl(e505_1,0) as e505_1,");
	sql.append("nvl(e601,0) as e601,nvl(e601_1,0) as e601_1 from");
	sql.append("(select  nvl(a.code,b.code) as code ,nvl(a.xq,b.xq) as xq, d601cout,f602,f602_1,f501,f501_1,e601,e601_1 from");
	sql.append("(select  nvl(a.code,b.code) as code ,nvl(a.xq,b.xq) as xq, d601cout,f602,f602_1,f501,f501_1 from");
	sql.append("(select  nvl(a.code,b.code) as code ,nvl(a.xq,b.xq) as xq,nvl(d601cout,0)as d601cout,f602,f602_1 from");
	sql.append("(select  code,xq,COUNT(d.D601_01) as d601cout from(select d601.d601_92,d601.d601_01,");
	sql.append("'南阳市外 'as xq,'666666' as code ");
	sql.append("from d601 d601 where to_char(d601.d601_03,'yyyy-mm-dd')>='"+dateStr+"' and to_char(d601.d601_03,'yyyy-mm-dd')<='"+dateEnd+"' and substr("+address[0]+",0,4 )!='4113' ");
	sql.append(") d  group by xq ,code) a full join (select nvl(a.code,b.code)as code,nvl(a.xq,b.xq)as xq");
	sql.append(",f602,nvl(f602_1,0)as f602_1 from(select  code,xq,count(f601_01) as f602 from(");
	sql.append("select f601_01,f601_71,f601_56,'南阳市外 ' as xq,'666666' as code from ");
	sql.append("f601 where to_char(f601_71,'yyyy-mm-dd')>='"+dateStr+"' and to_char(f601_71,'yyyy-mm-dd')<='"+dateEnd+"' ");
	sql.append("and f601_41='1' and substr("+address[2]+",0,4) !='4113') f1 group by xq,code) a left join (select code,xq,");
	sql.append("count(f602_01) as f602_1 from(select f601_01,f601_71,f601_56,'南阳市外 ' as xq,");
	sql.append("'666666' as code from f601 where to_char(f601_71,'yyyy-mm-dd')>='"+dateStr+"' ");
	sql.append("and to_char(f601_71,'yyyy-mm-dd')<='"+dateEnd+"' and substr("+address[2]+",0,4) !='4113') f1,");
	sql.append("(select c.f602_01,c.f602_02 from f602 c where  c.f602_16='3' or c.f602_18='3' or c.f602_20='3' ");
	sql.append("or c.f602_22='3' or c.f602_29='3')f2 where f2.f602_02=f1.f601_01 group by xq,code) b on b.code =a.code ");
	sql.append(") b on b.code =a.code) a full join(select nvl(b.code, c.code) as code,nvl(c.xq, b.xq) as xq,");
	sql.append("nvl(b.f501count, 0) as f501,nvl(c.f502count1, 0) as f501_1 from (select code,xq,count(f501_01) as f501count ");
	sql.append("from (select f501_01,'南阳市外 ' as xq,'666666' as code from (select f501_01 from f501 f ");
	sql.append("where substr("+address[1]+", 0, 4) !='4113' and f501_30='1') f1, (select f.f502_02 from f502 f where to_char(f502_24,");
	sql.append("'yyyy-mm-dd') >='"+dateStr+"' and to_char(f502_24,'yyyy-mm-dd')<='"+dateEnd+"') a ");
	sql.append("where a.f502_02 = f1.f501_01) group by xq, code) b left join");
	sql.append("(select count(f1.f501_01) as f502count1,");
	/**********f501*/
	sql.append("xq,code from(select f501_01,f501_28,f501_42,'南阳市外 ' as xq,'666666' as code ");
	sql.append("from f501 f where substr("+address[1]+",0,4)!='4113' and f501_30='1') f1, ");
	sql.append("(select f.f502_02 from f502 f where  to_char(f502_24,'yyyy-mm-dd')>='"+dateStr+"' ");
	sql.append("and to_char(f502_24,'yyyy-mm-dd')<='"+dateEnd+"' and f502_38='2') a ");
	sql.append("where a.f502_02=f1.f501_01 group by xq ,code) c on b.code = c.code )b on b.code =a.code ) a full join(");
	sql.append("select nvl(a.code,b.code)as code, nvl(a.xq,b.xq)as xq ,nvl(a.e601,0)as e601, nvl(b.e601_1,0)as e601_1 from(");
	sql.append("select count(e1.e601_01) as e601 ,xq ,code from(select e.e601_01,e601_34,e.e601_49,");
	sql.append("'南阳市外 ' as xq,'666666' as code from e601 e where to_char(");
	sql.append("e601_34,'yyyy-mm-dd')>='"+dateStr+"' and to_char(e601_34,'yyyy-mm-dd')<='"+dateEnd+"' and e601_24='1'");
	sql.append("and substr("+address[4]+",0,4)!='4113') e1 group by xq ,code) a left join(");
	sql.append("select count(e1.e601_01) as e601_1 ,xq,code from(select e.e601_01,e.e601_34,e601_49,");
	sql.append("'南阳市外 ' as xq,'666666' as code from e601 e where  to_char(e601_34,'yyyy-mm-dd')>=");
	sql.append("'"+dateStr+"' and to_char(e601_34,'yyyy-mm-dd')<='"+dateEnd+"' and substr");
	sql.append("("+address[4]+",0,4)!='4113' and e601_24='1' and (e601_57='阳性' or e601_59='阳性')) e1 ");
	sql.append("group by xq ,code) b on a.code =b.code)b on a.code =b.code)a full join(");
	
	sql.append("select nvl(a.code,b.code)as code,nvl(a.xq,b.xq)as xq ,nvl(a.e505,0)as e505, nvl(b.e505_1,0)as e505_1 ");
	/*****e504*****/
	sql.append("from(select count(e504_01) as e505 ,xq,code from(select e.e504_01,'南阳市外 ' as xq,'666666' as code from ");
	sql.append("(select e504_01  from e504 e where substr("+address[3]+",0,4)!='4113' and e504_19='1') e,(select distinct e.e505_02 from e505 e where  e505_26='0' and ");
	sql.append("to_char(e505_29,'yyyy-mm-dd')>='"+dateStr+"' and to_char(e505_29,'yyyy-mm-dd')<='"+dateEnd+"') e2 where ");  
  	sql.append(" e2.e505_02=e.e504_01 )e1 group by xq ,code) a left join");
	sql.append("(select count(e1.e504_01) as e505_1,xq,code from(");
	sql.append("select e.e504_01,'南阳市外 ' as xq,'666666'  as code from e504 e where substr("+address[3]+",0,4)!='4113' and e504_19='1') e1,(");
	sql.append("select distinct e.e505_02 from e505 e where e505_25='1' and e505_26='1' and to_char(e505_29,'yyyy-mm-dd')>='"+dateStr+"' and ");
	sql.append("to_char(e505_29,'yyyy-mm-dd')<='"+dateEnd+"') e2 ");
	sql.append(" where e2.e505_02=e1.e504_01 group by xq,code)b on a.code = b.code)b on a.code = b.code order by code");


	//System.out.println(sql);
%>
<%
	XML_GenOneRecordset(response,sql.toString());
%>
