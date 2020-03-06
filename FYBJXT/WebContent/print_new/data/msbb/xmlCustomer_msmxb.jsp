<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData_msmxb.jsp" %>
<%
String dateStr= request.getParameter("dateStr");
String dateEnd= request.getParameter("dateEnd");
String code= request.getParameter("code");
String payStatus= request.getParameter("payStatus");
int i=code.length();
String f501Pay="";
String f601Pay="";
String e504Pay="";
String e601Pay="";

//String sql="select code,hosname,name,card,tel,address,checkf502,checke505,checke601,checkf601,(f502money+e505money+e601money+f601money)as money from(select nvl(a.code,b.code)as code,nvl(a.hosname,b.hosname)as hosname,nvl(a.name,b.name)as name,nvl(a.card,b.card)as card,nvl(a.tel,b.tel)as tel,nvl(a.address,b.address)as address,a.checkf502 as checkf502,a.checke505 as checke505,a.checke601 as checke601,b.checkf601 as checkf601,nvl( f502money,0)as f502money,nvl(e505money,0)as e505money,nvl( e601money,0)as e601money,nvl(b.money,0)as f601money from(select nvl(a.code,b.code)as code,nvl(a.hosname,b.hosname)as hosname,nvl(a.name,b.name)as name,nvl(a.card,b.card)as card,nvl(a.tel,b.tel)as tel,nvl(a.address,b.address)as address,a.checkf502 as checkf502,a.checke505 as checke505,b.checke601 as checke601,f502money,e505money,b.money as e601money from(select nvl(a.code,b.code) as code,nvl(a.hosname,b.hosname) as hosname,nvl(a.name,b.name) as name,nvl(a.card,b.card) as card, nvl(a.tel,b.tel) as tel, nvl(a.address,b.address) as address,checkf502 as checkf502,b.checke505 as checke505,a.money as f502money,b.money as e505money from(select  a.d101_01 as code,a.d101_02 as hosname,f2.f502_03 as name,f2.f502_04 as card,f2.f502_07 as tel,(select ms.d201_05 from d201_ms ms where ms.d201_01=f1.f501_34) as address,nvl(f2.f502_24,null) as checkf502,nvl2(f502_01,160,0) as money from(select f501_01,f501_34  from f501 f) f1,(select d101_01 ,d101_02 from d101 d where d101_01='"+code+"' )a,(select f502_02,f502_01,f502_03 ,f502_04 ,f502_07,to_char(f.f502_24,'yyyy-mm-dd')as f502_24,f502_25 from f502 f where to_char(f.f502_24,'yyyy-mm-dd')>='"+dateStr+"'and to_char(f.f502_24,'yyyy-mm-dd')<='"+dateEnd+"')f2 where f2.f502_02=f1.f501_01 and f2.f502_25=a.d101_01 group by a.d101_01, a.d101_02,f2.f502_03,f2.f502_04 ,f2.f502_07,f1.f501_34,f502_24,f502_01 order by a.d101_02 ) a full join(select a.d101_01 as code,a.d101_02 as hosname,e504_06 as name,e504_07 as card,e504_10 as tel,(select ms.d201_05 from d201_ms ms where ms.d201_01=e504_61)as address,nvl(e505_29,null) as checke505,nvl2(e505_29,55,0)as money from(select e504_01,e504_06,e504_07,e504_10,e504_61 from e504 f)e1,(select d101_01,d101_02 from d101 d where d101_01='"+code+"' )a,(select e505_02,e505_28,to_char(e505_29,'yyyy-mm-dd')as e505_29 from e505 e where to_char(e505_29,'yyyy-mm-dd')>='"+dateStr+"' and to_char(e505_29,'yyyy-mm-dd')<='"+dateEnd+"'group by e505_02,e505_28,e505_29 having count(e505_02)<2 )e2 where e2.e505_02=e1.e504_01 and e2.e505_28=a.d101_01 group by a.d101_01,a.d101_02,e504_06,e504_07,e504_10,e504_61,e505_29 order by a.d101_02 )b on a.card=b.card )a full join(select a.d101_01 as code,a.d101_02 as hosname,e.e601_03 as name,e.e601_04 as card,e.e601_09 as tel,(select ms.d201_05 from d201_ms ms where ms.d201_01=e.e601_49)as address,nvl(e601_39,null)as checke601,nvl2(e601_47,45,0)as money from(select e601_03,e601_04,e601_09,to_char(e601_39,'yyyy-mm-dd')as e601_39,e601_47,e601_49 from e601 where to_char(e601_39,'yyyy-mm-dd')>='"+dateStr+"' and to_char(e601_39,'yyyy-mm-dd')<='"+dateEnd+"')e,(select d101_01 ,d101_02  from  d101 d  where d101_01='"+code+"' )a where e601_47=a.d101_01 group by a.d101_01, a.d101_02,e601_03,e601_04,e601_09,e601_49,e601_39,e601_47 order by a.d101_02 )b on a.card=b.card )a full join(select a.d101_01 as code,a.d101_02 as hosname,f2.f602_03 as name,f2.f602_04 as card,f1.f601_09 as tel,(select ms.d201_05 from d201_ms ms where ms.d201_01=f1.f601_09)as address,nvl(f602_23,null)as checkf601,nvl2(f602_02,140,0)as money from(select f601_01,f601_09,f601_56  from f601 )f1,(select f602_02,f602_03,f602_04,to_char(f602_23,'yyyy-mm-dd')as f602_23,f602_26 from f602 where to_char(f602_23,'yyyy-mm-dd')>='"+dateStr+"' and to_char(f602_23,'yyyy-mm-dd')<='"+dateEnd+"')f2,(select d101_01,d101_02 from d101 d where d101_01='"+code+"' )a where f2.f602_02=f1.f601_01 and f1.f601_56=a.d101_01 group by a.d101_01,a.d101_02,f602_03 ,f602_04,f601_09,f601_56,f602_23,f602_02 order by a.d101_02)b on a.card=b.card )a group by code,hosname,name,card,tel,address,checkf502,checke505,checke601,checkf601,f502money,e505money,e601money,f601money";

//String sql= ";
/**************时间字段改为档案的录入时间 ，别名未变，***********************/
/*	StringBuffer sql=new StringBuffer("select code,hosname,name,card,tel,address,checkf502,");
	sql.append("checke505,checke601,checkf601,(f502money+e505money+e601money+f601money)as money");
	sql.append(" from(select nvl(a.code,b.code)as code,nvl(a.hosname,b.hosname)as hosname,");
	sql.append("nvl(a.name,b.name)as name,nvl(a.card,b.card)as card,nvl(a.tel,b.tel)as tel,");
	sql.append("nvl(a.address,b.address)as address,a.checkf502 as checkf502,a.checke505 as checke505,");
	sql.append("a.checke601 as checke601,b.checkf601 as checkf601,nvl( f502money,0)as f502money,");
	sql.append("nvl(e505money,0)as e505money,nvl( e601money,0)as e601money,nvl(b.money,0)as f601money");
	sql.append(" from(select nvl(a.code,b.code)as code,nvl(a.hosname,b.hosname)as hosname,");
	sql.append("nvl(a.name,b.name)as name,nvl(a.card,b.card)as card,nvl(a.tel,b.tel)as tel,");
	sql.append("nvl(a.address,b.address)as address,a.checkf502 as checkf502,a.checke505 as checke505,");
	sql.append("b.checke601 as checke601,f502money,e505money,b.money as e601money from");
	sql.append("(select nvl(a.code,b.code) as code,nvl(a.hosname,b.hosname) as hosname,");
	sql.append("nvl(a.name,b.name) as name,nvl(a.card,b.card) as card, nvl(a.tel,b.tel) as tel,");
	sql.append("nvl(a.address,b.address) as address,checkf502 as checkf502,b.checke505 as checke505,");
	sql.append("a.money as f502money,b.money as e505money from(select  a.d101_01 as code,");
	sql.append("a.d101_02 as hosname,f2.f502_03 as name,f2.f502_04 as card,f2.f502_07 as tel,");
	sql.append("(select ms.d201_05 from d201_ms ms where ms.d201_01=f1.f501_34) as address,");
	sql.append("nvl(f1.f501_28,null) as checkf502,nvl2(f502_01,160,0) as money from");
	sql.append("(select f501_01,to_char(f501_28,'yyyy-mm-dd')as f501_28,f501_34  from f501 f");
	sql.append(" where to_char(f501_28,'yyyy-mm-dd')>='"+dateStr+"'and to_char(f501_28,'yyyy-mm-dd')<='"+dateEnd+"') f1");
	sql.append(",(select d101_01 ,d101_02 from d101 d where d101_01='"+code+"' )a,");
	sql.append("(select f502_02,f502_01,f502_03 ,f502_04 ,f502_07,f502_25 from f502 f )");
	sql.append(" f2 where f2.f502_02=f1.f501_01 and f2.f502_25=a.d101_01 group by a.d101_01, a.d101_02,");
	sql.append("f2.f502_03,f2.f502_04 ,f2.f502_07,f1.f501_34,f502_01,f501_28 order by a.d101_02 ) a");
	sql.append(" full join(select a.d101_01 as code,a.d101_02 as hosname,e504_06 as name,e504_07 as card,");
	sql.append("e504_10 as tel,(select ms.d201_05 from d201_ms ms where ms.d201_01=e504_61)as address,");
	sql.append("nvl(e504_59,null) as checke505,nvl2(e505_02,55,0)as money from(select e504_01,e504_06,");
	sql.append("e504_07,e504_10,to_char(e504_59,'yyyy-mm-dd')as e504_59,e504_61 from e504 f where");
	sql.append(" to_char(e504_59,'yyyy-mm-dd')>='"+dateStr+"' and to_char(e504_59,'yyyy-mm-dd')<='"+dateEnd+"')e1,");
	sql.append("(select d101_01,d101_02 from d101 d where d101_01='"+code+"' )a,(select e505_02,e505_28  from e505 e ");
	sql.append(" group by e505_02,e505_28,e505_29 having count(e505_02)<2 )e2 where e2.e505_02=e1.e504_01");
	sql.append(" and e2.e505_28=a.d101_01 group by a.d101_01,a.d101_02,e504_06,e504_07,e504_10,e504_59,e505_02,");
	sql.append("e504_61 order by a.d101_02 )b on a.card=b.card )a full join");
	sql.append("(select a.d101_01 as code,a.d101_02 as hosname,e.e601_03 as name,e.e601_04 as card,");
	sql.append("e.e601_09 as tel,(select ms.d201_05 from d201_ms ms where ms.d201_01=e.e601_49)as address,");
	sql.append("nvl(e601_34,null)as checke601,nvl2(e601_47,45,0)as money from(select e601_03,e601_04,");
	sql.append("e601_09,to_char(e601_34,'yyyy-mm-dd')as e601_34,e601_47,e601_49 from e601 where");
	sql.append(" to_char(e601_34,'yyyy-mm-dd')>='"+dateStr+"' and to_char(e601_34,'yyyy-mm-dd')<='"+dateEnd+"')e,");
	sql.append("(select d101_01 ,d101_02  from  d101 d  where d101_01='"+code+"' )a where e601_47=");
	sql.append("a.d101_01 group by a.d101_01, a.d101_02,e601_03,e601_04,e601_09,e601_49,e601_34,");
	sql.append("e601_47 order by a.d101_02 )b on a.card=b.card )a full join(select a.d101_01 as code,");
	sql.append("a.d101_02 as hosname,f2.f602_03 as name,f2.f602_04 as card,f1.f601_09 as tel,");
	sql.append("(select ms.d201_05 from d201_ms ms where ms.d201_01=f1.f601_56)as address,");
	sql.append("nvl(f601_34,null)as checkf601,nvl2(f602_02,140,0)as money from(select f601_01,");
	sql.append("f601_09,f601_29,to_char(f601_34,'yyyy-mm-dd')as f601_34,f601_56  from f601 ");
	sql.append("where to_char(f601_34,'yyyy-mm-dd')>='"+dateStr+"' and to_char(f601_34,'yyyy-mm-dd')<='"+dateEnd+"')f1,");
	sql.append("(select f602_02,f602_03,f602_04,f602_26 from f602 )f2,(select d101_01,");
	sql.append("d101_02 from d101 d where d101_01='"+code+"' )a where f2.f602_02=f1.f601_01 and");
	sql.append(" f1.f601_29=a.d101_01 group by a.d101_01,a.d101_02,f602_03 ,f602_04,f601_09,f601_29,f601_56,");
	sql.append("f601_34,f602_02 order by a.d101_02)b on a.card=b.card )a group by code,hosname,name,");
	sql.append("card,tel,address,checkf502,checke505,checke601,checkf601,f502money,e505money,e601money,f601money");*/
	if(!"".equals(payStatus))
	{
		f501Pay=" and f501_30='"+payStatus+"'";
		f601Pay=" and f601_41='"+payStatus+"'";
		e504Pay=" and e504_19='"+payStatus+"'";
		e601Pay=" and e601_24='"+payStatus+"'";
	}
	StringBuffer sql=new StringBuffer("select code,hosname,name,card,");
	sql.append("(case when (instr(tel,','))>0 then substr(tel,0,instr(tel,',')-1) else tel end) as tel,");
	sql.append("(case when (instr(address,','))>0 then substr(address,0,instr(address,',')-1) else address end) as address,");
	sql.append("(case when (instr(checkf502,','))>0 then substr(checkf502,0,instr(checkf502,',')-1) else checkf502 end) as checkf502,");
	sql.append("(case when (instr(checke505,','))>0 then substr(checke505,0,instr(checke505,',')-1) else checke505 end) as checke505,");
	sql.append("(case when (instr(checke601,','))>0 then substr(checke601,0,instr(checke601,',')-1) else checke601 end) as checke601,");
	sql.append("(case when (instr(checkf601,','))>0 then substr(checkf601,0,instr(checkf601,',')-1) else checkf601 end) as checkf601,");
	sql.append("money from (select code,hosname,name,card,wm_concat(tel) as tel,wm_concat(address) as address,wm_concat(checkf502) as checkf502,");
	sql.append("wm_concat(checke505) as checke505 ,wm_concat(checke601) as checke601,wm_concat(checkf601) as checkf601 ,sum(money) as money from(");
	sql.append("select  code,hosname,name,card, tel,address,checkf502,checke505,checke601,checkf601,money from(");
	
	sql.append("select f501_03 as name ,f501_05 as card,f501_07 as tel,f501_26 as code,f501_26_zh as hosname,");
	sql.append("f501_42_zhall as address,F501_28_Str as checkf502,'' as checke505,'' as checke601,'' as checkf601,");
	sql.append("(to_char(count(f501_05)*160)) as money from v_f501 f,f502 f2 where f2.f502_02=f.F501_01 ");
	sql.append(" and to_char(f501_28,'yyyy-mm-dd')>='"+dateStr+"' and to_char(f501_28,'yyyy-mm-dd')<='"+dateEnd+"' and f501_26='"+code+"'"+f501Pay);
	sql.append(" group by f501_03,f501_05,f501_07,f501_26,f501_26_zh,f501_42_zhall,F501_28_Str");
	
	sql.append(") f1 union all select code,hosname,name,card, tel,address,checkf502,checke505,checke601,checkf601,money from");
	sql.append("(select e504_06 as name,e504_07 as card,e504_10 as tel,e504_57 as code ,e504_57_Zh as hosname , e504_59,e504_61_ZH as address,");
	sql.append("'' as checkf502,E504_59_STR as checke505,'' as checke601,'' as checkf601,'55' as money from v_e504 f ");
	sql.append("where to_char(e504_59,'yyyy-mm-dd')>='"+dateStr+"' and to_char(e504_59,'yyyy-mm-dd')<='"+dateEnd+"' and e504_57='"+code+"'"+e504Pay);
	sql.append(" )e1 union all select code,hosname,name,card, tel,address,checkf502,checke505,checke601,checkf601,money from");
	sql.append("(select e601_03 as name,e601_04 as card,e601_09 as tel,e601_47 as code, e601_47_zh as hosname, e601_49_zh as address,");
	sql.append("'' as checkf502,'' as checke505,e601_34Str as checke601,'' as checkf601,'45' as money from v_e601 where ");
	sql.append("to_char(e601_34,'yyyy-mm-dd')>='"+dateStr+"' and to_char(e601_34,'yyyy-mm-dd')<='"+dateEnd+"' and e601_47='"+code+"'"+e601Pay+")e ");
	sql.append("union all select code,hosname,name,card, tel,address,checkf502,checke505,checke601,checkf601,money from");
	sql.append("(select f601_03 as name,f601_04 as card,f601_09 as tel,f601_29 as code,F601_29_ZH as hosname,f601_56_zh as address,");
	sql.append("'' as checkf502,'' as checke505,'' as checke601,f601_34_str as checkf601,'140' as money from v_f601 ");
	sql.append("where to_char(f601_34,'yyyy-mm-dd')>='"+dateStr+"' and to_char(f601_34,'yyyy-mm-dd')<='"+dateEnd+"' and f601_29='"+code+"'"+f601Pay+")f1 ");
	sql.append("group by card ,code,hosname,name, tel,address,checkf502,checke505,checke601,checkf601,money order by card");
	sql.append(" ) t group by card  ,code,hosname,name) order by money");
	
	
   //  System.out.println(sql);
%>
<%
	XML_GenOneRecordset(response,sql.toString());
%>
